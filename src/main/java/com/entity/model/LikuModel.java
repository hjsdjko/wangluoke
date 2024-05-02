package com.entity.model;

import com.entity.LikuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 案例库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LikuModel implements Serializable {
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
     * 案例库标题
     */
    private String likuName;


    /**
     * 案例库照片
     */
    private String likuPhoto;


    /**
     * 文件
     */
    private String likuFile;


    /**
     * 案例库类型
     */
    private Integer likuTypes;


    /**
     * 点击次数
     */
    private Integer likuClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer likuDelete;


    /**
     * 案例库介绍
     */
    private String likuContent;


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
	 * 获取：案例库标题
	 */
    public String getLikuName() {
        return likuName;
    }


    /**
	 * 设置：案例库标题
	 */
    public void setLikuName(String likuName) {
        this.likuName = likuName;
    }
    /**
	 * 获取：案例库照片
	 */
    public String getLikuPhoto() {
        return likuPhoto;
    }


    /**
	 * 设置：案例库照片
	 */
    public void setLikuPhoto(String likuPhoto) {
        this.likuPhoto = likuPhoto;
    }
    /**
	 * 获取：文件
	 */
    public String getLikuFile() {
        return likuFile;
    }


    /**
	 * 设置：文件
	 */
    public void setLikuFile(String likuFile) {
        this.likuFile = likuFile;
    }
    /**
	 * 获取：案例库类型
	 */
    public Integer getLikuTypes() {
        return likuTypes;
    }


    /**
	 * 设置：案例库类型
	 */
    public void setLikuTypes(Integer likuTypes) {
        this.likuTypes = likuTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getLikuClicknum() {
        return likuClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setLikuClicknum(Integer likuClicknum) {
        this.likuClicknum = likuClicknum;
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
    public Integer getLikuDelete() {
        return likuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setLikuDelete(Integer likuDelete) {
        this.likuDelete = likuDelete;
    }
    /**
	 * 获取：案例库介绍
	 */
    public String getLikuContent() {
        return likuContent;
    }


    /**
	 * 设置：案例库介绍
	 */
    public void setLikuContent(String likuContent) {
        this.likuContent = likuContent;
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
