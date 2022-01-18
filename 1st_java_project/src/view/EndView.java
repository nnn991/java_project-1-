package view;

import java.util.ArrayList;

import model.dto.TradeInfo;

public class EndView {

	public static void tradeView(TradeInfo info) {
		if(info != null) {
			System.out.println(info);
		}else {
			System.out.println("해당 거래는 존재하지 않습니다.");
		}
	}

	public static void tradeSellerView(int id) {
		if((Integer) id != null) {
			System.out.println(id);
		}else {
			System.out.println("존재하지 않습니다~");
		}
	}
	
	
	public static void tradeListView(ArrayList<TradeInfo> alltrade) {
		if(alltrade != null) {
			int tradesize = alltrade.size();
			
			for(int index = 0; index < tradesize; index++) {
				if(alltrade.get(index) != null);
				System.out.println(alltrade.get(index));
			}
		}
	}
	
	public static void successView(String message) {
		System.out.println(message);
	}
}
