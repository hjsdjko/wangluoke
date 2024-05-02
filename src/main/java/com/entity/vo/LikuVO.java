package com.entity.vo;

import com.entity.LikuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 案例库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liku")
public class LikuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
