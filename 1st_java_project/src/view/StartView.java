package view;

import controller.TradeController;
import model.dto.Buyer;
import model.dto.Items;
import model.dto.Seller;
import model.dto.TradeInfo;

public class StartView {

	public static void main(String[] args) {

		Seller sel1 = new Seller(1000, "James", "010-1233-2344", "������");
		Seller sel2 = new Seller(2000, "Smith", "010-5323-8854", "������");
		Seller sel3 = new Seller(3000, "kelly", "010-1111-7852", "å��");
		Seller sel4 = new Seller(4000, "Brown", "010-7521-7777", "����");
		Seller sel5 = new Seller(5000, "Ash", "010-0252-6653", "��Ʈ");
		Seller sel6 = new Seller(6000, "Alice", "010-4998-0047", "ħ��");
		Seller sel7 = new Seller(7000, "Venjamin", "010-9874-9985", "�����");
		Seller sel8 = new Seller(8000, "julia", "070-1024-1004", "������");
		
		Buyer buy1 = new Buyer(100, "�赿��", "010-5121-5312", "������");
		Buyer buy3 = new Buyer(300, "�踻��", "010-3145-1542", "����");
		Buyer buy6 = new Buyer(600, "������", "010-7748-6141", "������");
		Buyer buy7 = new Buyer(700, "����ǥ", "010-0002-4445", "������");
		
		Items info1 = new Items("������", 200000, "3���� ����߽��ϴ�. ��Ȱ�⽺ �����.");
		Items info2 = new Items("������", 300000, "1������ ����߽��ϴ�. �װ� �����ؿ� ^^");
		Items info3 = new Items("å��", 150000, "�ݳ����� ��µ� ū ���� �����ϴ�.");
		Items info4 = new Items("����", 100000, "����̰� ��¦ ���� �ڱ��� �־ �Ф�. ���Ⱓ�� 1�� 2���� ��������.");
		Items info5 = new Items("��Ʈ", 30000, "�����Ǽ� �� �Խ��ϴ�... �ѹ� �Ծ����...");
		Items info6 = new Items("ħ��", 450000, "�̱�ħ���Դϴ�. 2������ ����.");
		Items info7 = new Items("�����", 600000, "2��� ��ġ����� �Դϴ�. AS�Ⱓ 1�� ���Ҿ��.");
		
		TradeInfo tr1 = new TradeInfo("A01", sel1, buy1, info1, "2022-01-20", "������");
		TradeInfo tr3 = new TradeInfo("A02", sel4, buy3, info4, "2022-01-11", "�ŷ� ����");
		TradeInfo tr4 = new TradeInfo("A03", sel2, buy6, info2, "2022-02-15", "�װ���");
		
		TradeController controller = TradeController.getInstance();
		
		System.out.println(" *** �ŷ� ��Ī ���� ***");
		controller.tradeinfoCreate(tr1);
		controller.tradeinfoCreate(tr3);
		controller.tradeinfoCreate(tr4);
		
		System.out.println("\n *** ��� �ŷ� ��ȸ ***");
		controller.getTradeListRead();
		
		System.out.println("\n *** 'A01' ���� �ŷ� ���� ��ȸ ***");
		controller.getTradeInfoRead("A01");
		System.out.println("\n *** �ǸŹ�ǰ�� ��Ī�� �������� id��ȸ *** ");
		controller.getPeopleinfo(4000, "����");
		
		System.out.println("\n *** 'A01'�ŷ��� �Ǹ��ڸ� ������ �� �ŷ��� ��˻� *** ");
		controller.sellertradeinfoUpdate("A01", sel8);
		
		System.out.println("\n *** 'A01'�ŷ��� �����ڸ� ������ �� �ŷ��� ��˻� *** ");
		controller.buyertradeinfoUpdate("A01", buy7);
		
		System.out.println("\n *** 'A01' �ŷ��� �����ϰ� ������ �ŷ��� ��˻� *** ");
		controller.TradeInfoDelete("A01");
		controller.getTradeInfoRead("A01");
	}

}
