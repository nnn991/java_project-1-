package model.dto;

public class Items {

	private String itemname;
	private int price;
	private String detail;
	
	public Items() {}
	public Items(String itemname, int price, String detail) {
		super();
		this.itemname = itemname;
		this.price = price;
		this.detail = detail;
	}


	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Items [itemname=");
		builder.append(itemname);
		builder.append(", price=");
		builder.append(price);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
