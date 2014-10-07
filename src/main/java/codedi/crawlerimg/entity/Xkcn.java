package codedi.crawlerimg.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "xkcn")

public class Xkcn implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String path;
	private String description;
	private Date createdAt;
	
	public Xkcn() {
	}
	
	public Xkcn(int id, String name, String path, String description, Date createdAt) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = true, length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "path", nullable = true, length = 255)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", nullable = true)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
