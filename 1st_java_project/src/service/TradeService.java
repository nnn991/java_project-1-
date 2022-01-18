package service;

import java.util.ArrayList;

import exception.InfoNotFoundException;
import exception.ItemNameDuplicationException;
import model.dto.Buyer;
import model.dto.Seller;
import model.dto.TradeInfo;


public class TradeService {

	private static TradeService instance = new TradeService();
	
	private ArrayList<TradeInfo> tradelist = new ArrayList<TradeInfo>();
	
	private TradeService() {}
	
	public static TradeService getInstance() {
		return instance;
	}
	
	public ArrayList<TradeInfo> getTradeList() {
		return tradelist;
	}
	
	public TradeInfo getIteminfoRead(String itemname) throws InfoNotFoundException {
		
		for(TradeInfo e : tradelist) {
			if(e.getTsid().equals(itemname)) {
				return e;
			}
		}
		throw new InfoNotFoundException("�ش� ǰ���� �������� �ʽ��ϴ�.");
	}
	
	public int getPeopleinfo(int id, String item) throws InfoNotFoundException {
		int count = tradelist.size();
		for(int i = 0; i < count; i++) {
			if(tradelist.get(i).getSellerinfo().getId() == id && tradelist.get(i).getIteminfo().getItemname().equals(item)) {
				return tradelist.get(i).getBuyerinfo().getId();
			}
		}throw new InfoNotFoundException();
	}
	
	
	public void tradeinfoCreate(TradeInfo item) throws ItemNameDuplicationException {

		for (TradeInfo e : tradelist) {
			if (e.getTsid().equals(item)) {
				throw new ItemNameDuplicationException("�ߺ��� ǰ�� ���� �����Դϴ�. �ϳ��� ǰ�� �Ѱ��� ��Ī�� �����˴ϴ�.");
			}
		}
		tradelist.add(item);
	}

	public boolean sellertradeinfoUpdate(String itemname, Seller name) {
		for (TradeInfo e : tradelist) {
			if(e.getTsid().equals(itemname)) {
				e.setSellerinfo(name);
				System.out.println("  !! ������Ʈ�� �Ϸ�Ǿ����ϴ�. !! ");
				return true;
			}
		}
		
		return false;
	}

	
	public boolean buyertradeinfoUpdate(String itemname, Buyer name) {
		for (TradeInfo e : tradelist) {
			if(e.getTsid().equals(itemname)) {
				e.setBuyerinfo(name);
				System.out.println("  !! ������Ʈ�� �Ϸ�Ǿ����ϴ�. !! ");
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean TradeInfoDelete(String itemname) {
		TradeInfo item = null;
		for(int i = 0; i < tradelist.size(); i++) {
			if(tradelist.get(i).getTsid().equals(itemname)) {
				tradelist.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	public int TradeListSize() {
		return tradelist.size();
	}
}
