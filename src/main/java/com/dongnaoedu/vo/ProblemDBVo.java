package com.dongnaoedu.vo;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/12/05
 * 创建时间: 11:39
 * 题目在数据库中存放实体类
 */
public class ProblemDBVo {
    //题目id
    private Integer id;
    //题目内容，平均长度700字节
    private String content;
    //题目的sha串
    private String summary;
    
    public ProblemDBVo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ProblemDBVo(Integer id, String content, String summary) {
		super();
		this.id = id;
		this.content = content;
		this.summary = summary;
	}
    

   
}
