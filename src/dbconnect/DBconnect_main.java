package dbconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.data.category.DefaultCategoryDataset;

public class DBconnect_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id, year, ton;
		String name;
		ResultSet rs;
		
		MySQL mysql = new MySQL();
		//テーブルから情報をもってくる
		rs = mysql.selectAll();
		
		int []tonArray = new int[20]; //量
		String []nameArray = new String[20]; //名前
		String []yearArray = new String[20]; //年
		int count = 0; //行列の何番目か
		int rslen = 0; //行列の長さ
		
		try {
			while(rs.next()) {
				id = rs.getInt("id");
				rslen = id;
				name = rs.getString("name");
				nameArray[count] = name;
				year = rs.getInt("year");
				yearArray[count] = Integer.toString(year);
				ton = rs.getInt("ton");
				tonArray[count] = ton;
				System.out.println("ID:" + id);
				System.out.println("name:" + name);
				System.out.println("year:" + year);
				System.out.println("ton:" + ton);
				System.out.println(tonArray[count] + nameArray[count] + yearArray[count]);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBconnect_view view = new DBconnect_view(rslen, tonArray, nameArray, yearArray);
		view.setBounds(5, 5, 755, 475);
		view.setVisible(true);

	}

}
