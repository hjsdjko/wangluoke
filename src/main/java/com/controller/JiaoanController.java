






























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
 * 教案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoan")
public class JiaoanController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoanController.class);

    @Autowired
    private JiaoanService jiaoanService;


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
        params.put("jiaoanDeleteStart",1);params.put("jiaoanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaoanService.queryPage(params);

        //字典表数据转换
        List<JiaoanView> list =(List<JiaoanView>)page.getList();
        for(JiaoanView c:list){
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
        JiaoanEntity jiaoan = jiaoanService.selectById(id);
        if(jiaoan !=null){
            //entity转view
            JiaoanView view = new JiaoanView();
            BeanUtils.copyProperties( jiaoan , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(jiaoan.getLaoshiId());
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
    public R save(@RequestBody JiaoanEntity jiaoan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoan:{}",this.getClass().getName(),jiaoan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            jiaoan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaoanEntity> queryWrapper = new EntityWrapper<JiaoanEntity>()
            .eq("laoshi_id", jiaoan.getLaoshiId())
            .eq("jiaoan_name", jiaoan.getJiaoanName())
            .eq("jiaoan_types", jiaoan.getJiaoanTypes())
            .eq("jiaoan_clicknum", jiaoan.getJiaoanClicknum())
            .eq("shangxia_types", jiaoan.getShangxiaTypes())
            .eq("jiaoan_delete", jiaoan.getJiaoanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoanEntity jiaoanEntity = jiaoanService.selectOne(queryWrapper);
        if(jiaoanEntity==null){
            jiaoan.setJiaoanClicknum(1);
            jiaoan.setShangxiaTypes(1);
            jiaoan.setJiaoanDelete(1);
            jiaoan.setCreateTime(new Date());
            jiaoanService.insert(jiaoan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoanEntity jiaoan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoan:{}",this.getClass().getName(),jiaoan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            jiaoan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiaoanEntity> queryWrapper = new EntityWrapper<JiaoanEntity>()
            .notIn("id",jiaoan.getId())
            .andNew()
            .eq("laoshi_id", jiaoan.getLaoshiId())
            .eq("jiaoan_name", jiaoan.getJiaoanName())
            .eq("jiaoan_types", jiaoan.getJiaoanTypes())
            .eq("jiaoan_clicknum", jiaoan.getJiaoanClicknum())
            .eq("shangxia_types", jiaoan.getShangxiaTypes())
            .eq("jiaoan_delete", jiaoan.getJiaoanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoanEntity jiaoanEntity = jiaoanService.selectOne(queryWrapper);
        if("".equals(jiaoan.getJiaoanPhoto()) || "null".equals(jiaoan.getJiaoanPhoto())){
                jiaoan.setJiaoanPhoto(null);
        }
        if("".equals(jiaoan.getJiaoanFile()) || "null".equals(jiaoan.getJiaoanFile())){
                jiaoan.setJiaoanFile(null);
        }
        if(jiaoanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaoan.set
            //  }
            jiaoanService.updateById(jiaoan);//根据id更新
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
        ArrayList<JiaoanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiaoanEntity jiaoanEntity = new JiaoanEntity();
            jiaoanEntity.setId(id);
            jiaoanEntity.setJiaoanDelete(2);
            list.add(jiaoanEntity);
        }
        if(list != null && list.size() >0){
            jiaoanService.updateBatchById(list);
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
            List<JiaoanEntity> jiaoanList = new ArrayList<>();//上传的东西
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
                            JiaoanEntity jiaoanEntity = new JiaoanEntity();
//                            jiaoanEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            jiaoanEntity.setJiaoanName(data.get(0));                    //教案标题 要改的
//                            jiaoanEntity.setJiaoanPhoto("");//照片
//                            jiaoanEntity.setJiaoanFile(data.get(0));                    //教案文件 要改的
//                            jiaoanEntity.setJiaoanTypes(Integer.valueOf(data.get(0)));   //教案类型 要改的
//                            jiaoanEntity.setJiaoanClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            jiaoanEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jiaoanEntity.setJiaoanDelete(1);//逻辑删除字段
//                            jiaoanEntity.setJiaoanContent("");//照片
//                            jiaoanEntity.setCreateTime(date);//时间
                            jiaoanList.add(jiaoanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiaoanService.insertBatch(jiaoanList);
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
        PageUtils page = jiaoanService.queryPage(params);

        //字典表数据转换
        List<JiaoanView> list =(List<JiaoanView>)page.getList();
        for(JiaoanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoanEntity jiaoan = jiaoanService.selectById(id);
            if(jiaoan !=null){

                //点击数量加1
                jiaoan.setJiaoanClicknum(jiaoan.getJiaoanClicknum()+1);
                jiaoanService.updateById(jiaoan);

                //entity转view
                JiaoanView view = new JiaoanView();
                BeanUtils.copyProperties( jiaoan , view );//把实体数据重构到view中

                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(jiaoan.getLaoshiId());
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
    public R add(@RequestBody JiaoanEntity jiaoan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaoan:{}",this.getClass().getName(),jiaoan.toString());
        Wrapper<JiaoanEntity> queryWrapper = new EntityWrapper<JiaoanEntity>()
            .eq("laoshi_id", jiaoan.getLaoshiId())
            .eq("jiaoan_name", jiaoan.getJiaoanName())
            .eq("jiaoan_types", jiaoan.getJiaoanTypes())
            .eq("jiaoan_clicknum", jiaoan.getJiaoanClicknum())
            .eq("shangxia_types", jiaoan.getShangxiaTypes())
            .eq("jiaoan_delete", jiaoan.getJiaoanDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoanEntity jiaoanEntity = jiaoanService.selectOne(queryWrapper);
        if(jiaoanEntity==null){
            jiaoan.setJiaoanDelete(1);
            jiaoan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaoan.set
        //  }
        jiaoanService.insert(jiaoan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
