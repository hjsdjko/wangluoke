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
 * 案例库
 *
 * @author 
 * @email
 */
@TableName("liku")
public class LikuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LikuEntity() {

	}

	public LikuEntity(T t) {
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
     * 案例库标题
     */
    @TableField(value = "liku_name")

    private String likuName;


    /**
     * 案例库照片
     */
    @TableField(value = "liku_photo")

    private String likuPhoto;


    /**
     * 文件
     */
    @TableField(value = "liku_file")

    private String likuFile;


    /**
     * 案例库类型
     */
    @TableField(value = "liku_types")

    private Integer likuTypes;


    /**
     * 点击次数
     */
    @TableField(value = "liku_clicknum")

    private Integer likuClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "liku_delete")

    private Integer likuDelete;


    /**
     * 案例库介绍
     */
    @TableField(value = "liku_content")

    private String likuContent;


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
	 * 设置：案例库标题
	 */
    public String getLikuName() {
        return likuName;
    }


    /**
	 * 获取：案例库标题
	 */

    public void setLikuName(String likuName) {
        this.likuName = likuName;
    }
    /**
	 * 设置：案例库照片
	 */
    public String getLikuPhoto() {
        return likuPhoto;
    }


    /**
	 * 获取：案例库照片
	 */

    public void setLikuPhoto(String likuPhoto) {
        this.likuPhoto = likuPhoto;
    }
    /**
	 * 设置：文件
	 */
    public String getLikuFile() {
        return likuFile;
    }


    /**
	 * 获取：文件
	 */

    public void setLikuFile(String likuFile) {
        this.likuFile = likuFile;
    }
    /**
	 * 设置：案例库类型
	 */
    public Integer getLikuTypes() {
        return likuTypes;
    }


    /**
	 * 获取：案例库类型
	 */

    public void setLikuTypes(Integer likuTypes) {
        this.likuTypes = likuTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getLikuClicknum() {
        return likuClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setLikuClicknum(Integer likuClicknum) {
        this.likuClicknum = likuClicknum;
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
    public Integer getLikuDelete() {
        return likuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLikuDelete(Integer likuDelete) {
        this.likuDelete = likuDelete;
    }
    /**
	 * 设置：案例库介绍
	 */
    public String getLikuContent() {
        return likuContent;
    }


    /**
	 * 获取：案例库介绍
	 */

    public void setLikuContent(String likuContent) {
        this.likuContent = likuContent;
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
        return "Liku{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", likuName=" + likuName +
            ", likuPhoto=" + likuPhoto +
            ", likuFile=" + likuFile +
            ", likuTypes=" + likuTypes +
            ", likuClicknum=" + likuClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", likuDelete=" + likuDelete +
            ", likuContent=" + likuContent +
            ", createTime=" + createTime +
        "}";
    }
}
