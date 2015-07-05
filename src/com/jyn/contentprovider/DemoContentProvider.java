package com.jyn.contentprovider;

import org.xmlpull.v1.XmlPullParser;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.util.Xml;

public class DemoContentProvider extends ContentProvider {

	private static final String TAG = "DemoContentProvider";
	
	public static final UriMatcher uriMatcher;
	public static final String AUTHORIY = "com.jyn.contentprovider.democp";
	
	public static final int MATCH_ONE = 1;
	public static final int MATCH_ALL = 2;
	
	static{
		//实例化路由，注册路由
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORIY, "demo", MATCH_ALL);
		uriMatcher.addURI(AUTHORIY, "demo/#", MATCH_ONE);
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		System.out.println("delete");
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		//getType(Uri)返回MIME类型，保持和访问一致，校验
		System.out.println("getType");
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		System.out.println("insert");
		System.out.println(arg0 + "---" + uriMatcher.match(arg0) + "+++");
		System.out.println(arg1.get("id") + "===" + arg1.get("name"));
		return null;
	}

	@Override
	public boolean onCreate() {
		System.out.println("onCreate");
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		System.out.println("query");
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		System.out.println("update");
		return 0;
	}

}
