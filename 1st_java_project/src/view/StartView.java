package view;

import controller.TradeController;
import model.dto.Buyer;
import model.dto.Items;
import model.dto.Seller;
import model.dto.TradeInfo;

public class StartView {

	public static void main(String[] args) {

		Seller sel1 = new Seller(1000, "James", "010-1233-2344", "자전거");
		Seller sel2 = new Seller(2000, "Smith", "010-5323-8854", "유모차");
		Seller sel3 = new Seller(3000, "kelly", "010-1111-7852", "책상");
		Seller sel4 = new Seller(4000, "Brown", "010-7521-7777", "의자");
		Seller sel5 = new Seller(5000, "Ash", "010-0252-6653", "코트");
		Seller sel6 = new Seller(6000, "Alice", "010-4998-0047", "침대");
		Seller sel7 = new Seller(7000, "Venjamin", "010-9874-9985", "냉장고");
		Seller sel8 = new Seller(8000, "julia", "070-1024-1004", "자전거");
		
		Buyer buy1 = new Buyer(100, "김동훈", "010-5121-5312", "자전거");
		Buyer buy3 = new Buyer(300, "김말숙", "010-3145-1542", "의자");
		Buyer buy6 = new Buyer(600, "구신혜", "010-7748-6141", "유모차");
		Buyer buy7 = new Buyer(700, "김준표", "010-0002-4445", "자전거");
		
		Items info1 = new Items("자전거", 200000, "3개월 사용했습니다. 생활기스 없어요.");
		Items info2 = new Items("유모차", 300000, "1년정도 사용했습니다. 네고 가능해요 ^^");
		Items info3 = new Items("책상", 150000, "반년정도 썼는데 큰 문제 없습니다.");
		Items info4 = new Items("의자", 100000, "고양이가 살짝 긁은 자국이 있어여 ㅠㅠ. 사용기간은 1년 2개월 정도구요.");
		Items info5 = new Items("코트", 30000, "살이쪄서 못 입습니다... 한번 입었어요...");
		Items info6 = new Items("침대", 450000, "싱글침대입니다. 2달정도 썼어요.");
		Items info7 = new Items("냉장고", 600000, "2년된 김치냉장고 입니다. AS기간 1년 남았어요.");
		
		TradeInfo tr1 = new TradeInfo("A01", sel1, buy1, info1, "2022-01-20", "진행중");
		TradeInfo tr3 = new TradeInfo("A02", sel4, buy3, info4, "2022-01-11", "거래 실패");
		TradeInfo tr4 = new TradeInfo("A03", sel2, buy6, info2, "2022-02-15", "네고중");
		
		TradeController controller = TradeController.getInstance();
		
		System.out.println(" *** 거래 매칭 생성 ***");
		controller.tradeinfoCreate(tr1);
		controller.tradeinfoCreate(tr3);
		controller.tradeinfoCreate(tr4);
		
		System.out.println("\n *** 모든 거래 조회 ***");
		controller.getTradeListRead();
		
		System.out.println("\n *** 'A01' 고유 거래 정보 조회 ***");
		controller.getTradeInfoRead("A01");
		System.out.println("\n *** 판매물품과 매칭된 구매자의 id조회 *** ");
		controller.getPeopleinfo(4000, "의자");
		
		System.out.println("\n *** 'A01'거래의 판매자를 변경한 후 거래를 재검색 *** ");
		controller.sellertradeinfoUpdate("A01", sel8);
		
		System.out.println("\n *** 'A01'거래의 구매자를 변경한 후 거래를 재검색 *** ");
		controller.buyertradeinfoUpdate("A01", buy7);
		
		System.out.println("\n *** 'A01' 거래를 삭제하고 삭제한 거래를 재검색 *** ");
		controller.TradeInfoDelete("A01");
		controller.getTradeInfoRead("A01");
	}

}
