






























package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 案例库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liku")
public class LikuController {
    private static final Logger logger = LoggerFactory.getLogger(LikuController.class);

    @Autowired
    private LikuService likuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        params.put("likuDeleteStart",1);params.put("likuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = likuService.queryPage(params);

        //字典表数据转换
        List<LikuView> list =(List<LikuView>)page.getList();
        for(LikuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LikuEntity liku = likuService.selectById(id);
        if(liku !=null){
            //entity转view
            LikuView view = new LikuView();
            BeanUtils.copyProperties( liku , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(liku.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LikuEntity liku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liku:{}",this.getClass().getName(),liku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            liku.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LikuEntity> queryWrapper = new EntityWrapper<LikuEntity>()
            .eq("laoshi_id", liku.getLaoshiId())
            .eq("liku_name", liku.getLikuName())
            .eq("liku_types", liku.getLikuTypes())
            .eq("liku_clicknum", liku.getLikuClicknum())
            .eq("shangxia_types", liku.getShangxiaTypes())
            .eq("liku_delete", liku.getLikuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LikuEntity likuEntity = likuService.selectOne(queryWrapper);
        if(likuEntity==null){
            liku.setLikuClicknum(1);
            liku.setShangxiaTypes(1);
            liku.setLikuDelete(1);
            liku.setCreateTime(new Date());
            likuService.insert(liku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LikuEntity liku, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,liku:{}",this.getClass().getName(),liku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            liku.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LikuEntity> queryWrapper = new EntityWrapper<LikuEntity>()
            .notIn("id",liku.getId())
            .andNew()
            .eq("laoshi_id", liku.getLaoshiId())
            .eq("liku_name", liku.getLikuName())
            .eq("liku_types", liku.getLikuTypes())
            .eq("liku_clicknum", liku.getLikuClicknum())
            .eq("shangxia_types", liku.getShangxiaTypes())
            .eq("liku_delete", liku.getLikuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LikuEntity likuEntity = likuService.selectOne(queryWrapper);
        if("".equals(liku.getLikuPhoto()) || "null".equals(liku.getLikuPhoto())){
                liku.setLikuPhoto(null);
        }
        if("".equals(liku.getLikuFile()) || "null".equals(liku.getLikuFile())){
                liku.setLikuFile(null);
        }
        if(likuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      liku.set
            //  }
            likuService.updateById(liku);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<LikuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LikuEntity likuEntity = new LikuEntity();
            likuEntity.setId(id);
            likuEntity.setLikuDelete(2);
            list.add(likuEntity);
        }
        if(list != null && list.size() >0){
            likuService.updateBatchById(list);
        }
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LikuEntity> likuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LikuEntity likuEntity = new LikuEntity();
//                            likuEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            likuEntity.setLikuName(data.get(0));                    //案例库标题 要改的
//                            likuEntity.setLikuPhoto("");//照片
//                            likuEntity.setLikuFile(data.get(0));                    //文件 要改的
//                            likuEntity.setLikuTypes(Integer.valueOf(data.get(0)));   //案例库类型 要改的
//                            likuEntity.setLikuClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            likuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            likuEntity.setLikuDelete(1);//逻辑删除字段
//                            likuEntity.setLikuContent("");//照片
//                            likuEntity.setCreateTime(date);//时间
                            likuList.add(likuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        likuService.insertBatch(likuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = likuService.queryPage(params);

        //字典表数据转换
        List<LikuView> list =(List<LikuView>)page.getList();
        for(LikuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LikuEntity liku = likuService.selectById(id);
            if(liku !=null){

                //点击数量加1
                liku.setLikuClicknum(liku.getLikuClicknum()+1);
                likuService.updateById(liku);

                //entity转view
                LikuView view = new LikuView();
                BeanUtils.copyProperties( liku , view );//把实体数据重构到view中

                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(liku.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LikuEntity liku, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liku:{}",this.getClass().getName(),liku.toString());
        Wrapper<LikuEntity> queryWrapper = new EntityWrapper<LikuEntity>()
            .eq("laoshi_id", liku.getLaoshiId())
            .eq("liku_name", liku.getLikuName())
            .eq("liku_types", liku.getLikuTypes())
            .eq("liku_clicknum", liku.getLikuClicknum())
            .eq("shangxia_types", liku.getShangxiaTypes())
            .eq("liku_delete", liku.getLikuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LikuEntity likuEntity = likuService.selectOne(queryWrapper);
        if(likuEntity==null){
            liku.setLikuDelete(1);
            liku.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      liku.set
        //  }
        likuService.insert(liku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
