package controller;

import exception.InfoNotFoundException;
import exception.ItemNameDuplicationException;
import model.dto.Buyer;
import model.dto.Seller;
import model.dto.TradeInfo;
import service.TradeService;
import view.EndView;
import view.FailView;

public class TradeController {

	private static TradeController instance = new TradeController();

	private TradeService ser = TradeService.getInstance();

	private TradeController() {
	}

	public static TradeController getInstance() {
		return instance;
	}

	public void getTradeInfoRead(String itemname) {

		try {
			EndView.tradeView(ser.getIteminfoRead(itemname));
		} catch (InfoNotFoundException e) {
			e.printStackTrace();
			FailView.failView(e.getMessage());
		}
	}

	public void getTradeListRead() {
		EndView.tradeListView(ser.getTradeList());
	}

	public void tradeinfoCreate(TradeInfo item) {
		if (item != null) {
			try {
				ser.tradeinfoCreate(item);
			} catch (ItemNameDuplicationException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		} else {
			FailView.failView("생성하고자 하는 매칭 데이터가 존재하지 않습니다");
		}
	}

	
	public void getPeopleinfo(int id, String item) {
		if((Integer) id != null && item != null) {
			try {
				EndView.tradeSellerView(ser.getPeopleinfo(id, item));
			}catch (InfoNotFoundException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}else {
			FailView.failView("거래중인 고객을 찾지 못했습니다.");
		}
	}
	
	
	public void sellertradeinfoUpdate(String itemname, Seller name) {
		if (itemname != null && name != null) {
			boolean result = ser.sellertradeinfoUpdate(itemname, name);
			
			if(result) {
				try {
					EndView.tradeView(ser.getIteminfoRead(itemname));
				} catch (InfoNotFoundException e) {
					e.printStackTrace();
					FailView.failView("판매자 정보 갱신 후 검색에 실패하였습니다.");
				}
			} else {
				FailView.failView("존재하지 않는 거래 수정을 시도하였습니다.");
			}
			
		}else {
			FailView.failView("판매자 갱신 정보를 정확히 입력해주세요.");
		}
	}

	public void buyertradeinfoUpdate(String itemname, Buyer name) {
		if (itemname != null && name != null) {
			boolean result = ser.buyertradeinfoUpdate(itemname, name);
			
			if(result) {
				try {
					EndView.tradeView(ser.getIteminfoRead(itemname));
				} catch (InfoNotFoundException e) {
					e.printStackTrace();
					FailView.failView("판매자 정보 갱신 후 검색에 실패하였습니다.");
				}
			} else {
				FailView.failView("존재하지 않는 거래 수정을 시도하였습니다.");
			}
			
		}else {
			FailView.failView("판매자 갱신 정보를 정확히 입력해주세요.");
		}
	}
	
	public void TradeInfoDelete(String itemname) {
		
		if(itemname != null) {
			boolean result = ser.TradeInfoDelete(itemname);
			if(result) {
				EndView.successView(itemname + " 해당 거래 삭제 완료");
			}else {
				FailView.failView("삭제하고자 하는 거래가 존재하지 않습니다.");
			}
		}else {
			FailView.failView("삭제하고자 하는 거래의 고유번호를 입력하세요");
		}
	}
	
}
