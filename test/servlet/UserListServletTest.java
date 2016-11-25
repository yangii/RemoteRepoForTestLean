package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.User;

public class UserListServletTest extends TestServlet {


	@Test
	public void ログインに成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story03/UserListServlet_test.xls");

		// Getメソッドを指定
		setGet();

		// Servletを呼び出す。
		callServlet();

		// RequestにUserオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("Users"),notNullValue());

		// RequestからUserオブジェクトを読み込み
		LinkedList<User> users=(LinkedList<User>)request.getAttribute("Users");

		// 読み込んだリストに登録されているユーザ数をチェック
		assertThat(users.size(),is(3));

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		User user=users.get(2);
		assertThat(user.getLoginName(),is("admin"));
		assertThat(user.getPassWord(),is("admin"));
		assertThat(user.getName(),is("Mr.Admin"));
		assertThat(user.getUserType(),is(1));

	}

}
