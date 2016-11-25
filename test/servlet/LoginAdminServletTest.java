package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.User;

public class LoginAdminServletTest extends TestServlet {

	@Test
	public void 管理者ログインに成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();

		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "admin");
		webRequest.setParameter("PassWord", "admin");

		// Servletを呼び出す。
		callServlet();

		// RequestにUserオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("User"),notNullValue());

		// RequestからUserオブジェクトを読み込み
		User user=(User)request.getAttribute("User");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(user.getLoginName(),is("admin"));
		assertThat(user.getPassWord(),is("admin"));
		assertThat(user.getName(),is("Mr.Admin"));

	}

	@Test
	public void 通常ユーザは管理者ログインに失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "test1");
		webRequest.setParameter("PassWord", "xyz");

		// Servletを呼び出す。
		callServlet();

		// RequestにUserオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(request.getAttribute("User"),nullValue());

	}

	@Test
	public void 未登録ユーザは管理者ログインに失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story02/LoginAdminServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("LoginName", "aaa");
		webRequest.setParameter("PassWord", "bbb");

		// Servletを呼び出す。
		callServlet();

		// RequestにUserオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(request.getAttribute("User"),nullValue());

	}

}
