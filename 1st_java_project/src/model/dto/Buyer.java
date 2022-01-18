package model.dto;

public class Buyer {

	private int id;
	private String name;
	private String phonenum;
	private String item;
	
	public Buyer() {}
	public Buyer(int id, String name, String phonenum, String item) {
		super();
		this.id = id;
		this.name = name;
		this.phonenum = phonenum;
		this.item = item;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return phonenum;
	}

	public void setContact(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phonenum=");
		builder.append(phonenum);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}

	
}
