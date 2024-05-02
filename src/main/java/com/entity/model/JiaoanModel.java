package com.entity.model;

import com.entity.JiaoanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 教案标题
     */
    private String jiaoanName;


    /**
     * 教案照片
     */
    private String jiaoanPhoto;


    /**
     * 教案文件
     */
    private String jiaoanFile;


    /**
     * 教案类型
     */
    private Integer jiaoanTypes;


    /**
     * 点击次数
     */
    private Integer jiaoanClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jiaoanDelete;


    /**
     * 教案介绍
     */
    private String jiaoanContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：教案标题
	 */
    public String getJiaoanName() {
        return jiaoanName;
    }


    /**
	 * 设置：教案标题
	 */
    public void setJiaoanName(String jiaoanName) {
        this.jiaoanName = jiaoanName;
    }
    /**
	 * 获取：教案照片
	 */
    public String getJiaoanPhoto() {
        return jiaoanPhoto;
    }


    /**
	 * 设置：教案照片
	 */
    public void setJiaoanPhoto(String jiaoanPhoto) {
        this.jiaoanPhoto = jiaoanPhoto;
    }
    /**
	 * 获取：教案文件
	 */
    public String getJiaoanFile() {
        return jiaoanFile;
    }


    /**
	 * 设置：教案文件
	 */
    public void setJiaoanFile(String jiaoanFile) {
        this.jiaoanFile = jiaoanFile;
    }
    /**
	 * 获取：教案类型
	 */
    public Integer getJiaoanTypes() {
        return jiaoanTypes;
    }


    /**
	 * 设置：教案类型
	 */
    public void setJiaoanTypes(Integer jiaoanTypes) {
        this.jiaoanTypes = jiaoanTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getJiaoanClicknum() {
        return jiaoanClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setJiaoanClicknum(Integer jiaoanClicknum) {
        this.jiaoanClicknum = jiaoanClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaoanDelete() {
        return jiaoanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiaoanDelete(Integer jiaoanDelete) {
        this.jiaoanDelete = jiaoanDelete;
    }
    /**
	 * 获取：教案介绍
	 */
    public String getJiaoanContent() {
        return jiaoanContent;
    }


    /**
	 * 设置：教案介绍
	 */
    public void setJiaoanContent(String jiaoanContent) {
        this.jiaoanContent = jiaoanContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
