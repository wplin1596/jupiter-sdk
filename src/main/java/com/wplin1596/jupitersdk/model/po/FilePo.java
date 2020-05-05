package com.wplin1596.jupitersdk.model.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description TODO
 * @ClassName FilePo
 * @Author wplin1596
 * @Date 2020/5/4 13:07
 * @Version 1.0.0
 */
@Entity
@Table(name = "t_file")
public class FilePo {
    @Id
    private String id;
    private String name;
    private String path;
    private String content;
    private Date createTime;
    private Date modifyTime;
    private Long allowTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getAllowTime() {
        return allowTime;
    }

    public void setAllowTime(Long allowTime) {
        this.allowTime = allowTime;
    }

    @Override
    public String toString() {
        return "FilePo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", allowTime=" + allowTime +
                '}';
    }
}
