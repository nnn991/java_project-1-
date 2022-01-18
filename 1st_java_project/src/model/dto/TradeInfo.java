package model.dto;

public class TradeInfo {

	private String tsid;
	private Seller sellerinfo;
	private Buyer buyerinfo;
	private Items iteminfo;
	private String date;
	private String condition;
	
	public TradeInfo() {
		super();
	}
	
	public TradeInfo(String tsid, Seller sellerinfo, Buyer buyerinfo, Items iteminfo, String date, String condition) {
		super();
		this.tsid = tsid;
		this.sellerinfo = sellerinfo;
		this.buyerinfo = buyerinfo;
		this.iteminfo = iteminfo;
		this.date = date;
		this.condition = condition;
	}

	public String getTsid() {
		return tsid;
	}
	public void setTsid(String tsid) {
		this.tsid = tsid;
	}
	public Seller getSellerinfo() {
		return sellerinfo;
	}
	public void setSellerinfo(Seller sellerinfo) {
		this.sellerinfo = sellerinfo;
	}
	public Buyer getBuyerinfo() {
		return buyerinfo;
	}
	public void setBuyerinfo(Buyer buyerinfo) {
		this.buyerinfo = buyerinfo;
	}
	public Items getIteminfo() {
		return iteminfo;
	}
	public void setIteminfo(Items iteminfo) {
		this.iteminfo = iteminfo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n 거래정보 [거래 고유번호 =");
		builder.append(tsid);
		builder.append(", 판매자 정보 = ");
		builder.append(sellerinfo);
		builder.append(", 구매자 정보 = ");
		builder.append(buyerinfo);
		builder.append(", 물품 정보 = ");
		builder.append(iteminfo);
		builder.append(", 거래 날짜 = ");
		builder.append(date);
		builder.append(", 거래 상태 = ");
		builder.append(condition);
		builder.append("]");
		return builder.toString();
	}
	
}