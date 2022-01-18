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
			FailView.failView("�����ϰ��� �ϴ� ��Ī �����Ͱ� �������� �ʽ��ϴ�");
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
			FailView.failView("�ŷ����� ���� ã�� ���߽��ϴ�.");
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
					FailView.failView("�Ǹ��� ���� ���� �� �˻��� �����Ͽ����ϴ�.");
				}
			} else {
				FailView.failView("�������� �ʴ� �ŷ� ������ �õ��Ͽ����ϴ�.");
			}
			
		}else {
			FailView.failView("�Ǹ��� ���� ������ ��Ȯ�� �Է����ּ���.");
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
					FailView.failView("�Ǹ��� ���� ���� �� �˻��� �����Ͽ����ϴ�.");
				}
			} else {
				FailView.failView("�������� �ʴ� �ŷ� ������ �õ��Ͽ����ϴ�.");
			}
			
		}else {
			FailView.failView("�Ǹ��� ���� ������ ��Ȯ�� �Է����ּ���.");
		}
	}
	
	public void TradeInfoDelete(String itemname) {
		
		if(itemname != null) {
			boolean result = ser.TradeInfoDelete(itemname);
			if(result) {
				EndView.successView(itemname + " �ش� �ŷ� ���� �Ϸ�");
			}else {
				FailView.failView("�����ϰ��� �ϴ� �ŷ��� �������� �ʽ��ϴ�.");
			}
		}else {
			FailView.failView("�����ϰ��� �ϴ� �ŷ��� ������ȣ�� �Է��ϼ���");
		}
	}
	
}
