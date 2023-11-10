package club;

public class Bill extends Socios{
	String data;
	String conceptBill;
	String amount;
	String memberName;
	String[][] billsSaved = new String[700][5];
	
	public Bill() {
	}
	
	public Bill(String data, String conceptBill, String amount, String memberName) {
		super();
		this.data = data;
		this.conceptBill = conceptBill;
		this.amount = amount;
		this.memberName = memberName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getConceptBill() {
		return conceptBill;
	}

	public void setConceptBill(String conceptBill) {
		this.conceptBill = conceptBill;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String[][] getBillsSaved() {
		return billsSaved;
	}

	public void setBillsSaved(String[][] billsSaved) {
		this.billsSaved = billsSaved;
	}

	public void bills_debt(String id,String name, String concept, String mount, String data) {
		int i = this.count();
		this.billsSaved[i][0] = id;
		this.billsSaved[i][1] = name;
		this.billsSaved[i][2] = concept;
		this.billsSaved[i][3] = mount;
		this.billsSaved[i][4] = data;
		
	}
	
	public String[][] products(int i){
		
		String[][] products = new String[1][2];
		
		switch(i) {
		
			case 1:
				products[0][0] = "soda";
				products[0][1] = "3000";
				break;
				
			case 2:
				products[0][0] = "snack";
				products[0][1] = "4000";
				break;
				
			case 3:
				products[0][0] = "hamburger";
				products[0][1] = "15000";
				break;
		}
		
		return products;
	}
	
	
	public int count() {
		int count = 0;
		
		for (int i=0; i<billsSaved.length;i++) {
			
			if(this.billsSaved[i][0] != null) {
				count = count + 1;
			}
		}
		return count;
		
	}
	
	public String[][] getBills(){
		return this.billsSaved;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
