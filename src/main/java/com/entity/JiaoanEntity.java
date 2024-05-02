package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 教案
 *
 * @author 
 * @email
 */
@TableName("jiaoan")
public class JiaoanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoanEntity() {

	}

	public JiaoanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 教案标题
     */
    @TableField(value = "jiaoan_name")

    private String jiaoanName;


    /**
     * 教案照片
     */
    @TableField(value = "jiaoan_photo")

    private String jiaoanPhoto;


    /**
     * 教案文件
     */
    @TableField(value = "jiaoan_file")

    private String jiaoanFile;


    /**
     * 教案类型
     */
    @TableField(value = "jiaoan_types")

    private Integer jiaoanTypes;


    /**
     * 点击次数
     */
    @TableField(value = "jiaoan_clicknum")

    private Integer jiaoanClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "jiaoan_delete")

    private Integer jiaoanDelete;


    /**
     * 教案介绍
     */
    @TableField(value = "jiaoan_content")

    private String jiaoanContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：教案标题
	 */
    public String getJiaoanName() {
        return jiaoanName;
    }


    /**
	 * 获取：教案标题
	 */

    public void setJiaoanName(String jiaoanName) {
        this.jiaoanName = jiaoanName;
    }
    /**
	 * 设置：教案照片
	 */
    public String getJiaoanPhoto() {
        return jiaoanPhoto;
    }


    /**
	 * 获取：教案照片
	 */

    public void setJiaoanPhoto(String jiaoanPhoto) {
        this.jiaoanPhoto = jiaoanPhoto;
    }
    /**
	 * 设置：教案文件
	 */
    public String getJiaoanFile() {
        return jiaoanFile;
    }


    /**
	 * 获取：教案文件
	 */

    public void setJiaoanFile(String jiaoanFile) {
        this.jiaoanFile = jiaoanFile;
    }
    /**
	 * 设置：教案类型
	 */
    public Integer getJiaoanTypes() {
        return jiaoanTypes;
    }


    /**
	 * 获取：教案类型
	 */

    public void setJiaoanTypes(Integer jiaoanTypes) {
        this.jiaoanTypes = jiaoanTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getJiaoanClicknum() {
        return jiaoanClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setJiaoanClicknum(Integer jiaoanClicknum) {
        this.jiaoanClicknum = jiaoanClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiaoanDelete() {
        return jiaoanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiaoanDelete(Integer jiaoanDelete) {
        this.jiaoanDelete = jiaoanDelete;
    }
    /**
	 * 设置：教案介绍
	 */
    public String getJiaoanContent() {
        return jiaoanContent;
    }


    /**
	 * 获取：教案介绍
	 */

    public void setJiaoanContent(String jiaoanContent) {
        this.jiaoanContent = jiaoanContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaoan{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", jiaoanName=" + jiaoanName +
            ", jiaoanPhoto=" + jiaoanPhoto +
            ", jiaoanFile=" + jiaoanFile +
            ", jiaoanTypes=" + jiaoanTypes +
            ", jiaoanClicknum=" + jiaoanClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jiaoanDelete=" + jiaoanDelete +
            ", jiaoanContent=" + jiaoanContent +
            ", createTime=" + createTime +
        "}";
    }
}
