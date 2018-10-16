package com.sina.weibo.sdk.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.web.param.DefaultWebViewRequestParam;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class WeiboPageUtils {
    private static final String USER_INFO_H5 = "http://m.weibo.cn/u/";
    private static final String USER_INFO_SCHEME = "sinaweibo://userinfo?";
    private static final String WEIBO_ARTICLE_H5 = "http://media.weibo.cn/article?";
    private static final String WEIBO_ARTICLE_SCHEME = "sinaweibo://article?";
    private static final String WEIBO_COMMENT_H5 = "http://m.weibo.cn/comment?";
    private static final String WEIBO_COMMENT_SCHEME = "sinaweibo://comment?";
    private static final String WEIBO_DETAIL_H5 = "http://m.weibo.cn/";
    private static final String WEIBO_DETAIL_SCHEME = "sinaweibo://detail?";
    private static final String WEIBO_GOTO_HOME_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_HOME_SCHEME = "sinaweibo://gotohome?";
    private static final String WEIBO_GOTO_MYPROFILE_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_MYPROFILE_SCHEME = "sinaweibo://myprofile?";
    private static final String WEIBO_SEARCH_URL_CHEME = "sinaweibo://searchall?";
    private static final String WEIBO_SEARCH_URL_H5 = "https://m.weibo.cn/p/100103type=1&";
    private static final String WEIBO_SEND_CONTENT_H5 = "http://m.weibo.cn/mblog?";
    private static final String WEIBO_SEND_CONTENT_SCHEME = "sinaweibo://sendweibo?";
    private static WeiboPageUtils weiboSdkUtils;
    private AuthInfo authInfo;
    private Context context;
    private WbAppInfo mWeiboInfo;

    private WeiboPageUtils(Context context, AuthInfo authInfo) {
        this.mWeiboInfo = null;
        this.mWeiboInfo = WeiboAppManager.getInstance(context).getWbAppInfo();
        this.authInfo = authInfo;
        this.context = context;
    }

    public static WeiboPageUtils getInstance(Context context, AuthInfo authInfo) {
        if (weiboSdkUtils == null) {
            weiboSdkUtils = new WeiboPageUtils(context, authInfo);
        }
        return weiboSdkUtils;
    }

    public void startUserMainPage(String str) {
        startUserMainPage(str, false);
    }

    public void startUserMainPage(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            gotoWebActivity(schemeAddProperty(USER_INFO_H5 + str + "?", null));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uid", str);
        try {
            this.context.startActivity(createScheme(USER_INFO_SCHEME, hashMap));
        } catch (Exception e) {
        }
    }

    public void startWeiboDetailPage(String str, String str2) {
        startWeiboDetailPage(str, str2, false);
    }

    public void startWeiboDetailPage(String str, String str2, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            gotoWebActivity(schemeAddProperty(WEIBO_DETAIL_H5 + str2 + "/" + str + "?", null));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mblogid", str);
        try {
            this.context.startActivity(createScheme(WEIBO_DETAIL_SCHEME, hashMap));
        } catch (Exception e) {
        }
    }

    public void startWeiboTopPage(String str) {
        startWeiboTopPage(str, false);
    }

    public void startWeiboTopPage(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", str);
            gotoWebActivity(schemeAddProperty(WEIBO_ARTICLE_H5, hashMap));
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("object_id", "1022:" + str);
        try {
            this.context.startActivity(createScheme(WEIBO_ARTICLE_SCHEME, hashMap2));
        } catch (Exception e) {
        }
    }

    public void shareToWeibo(String str) {
        shareToWeibo(str, false);
    }

    public void shareToWeibo(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            new HashMap().put("content", str);
            gotoWebActivity(schemeAddProperty(WEIBO_SEND_CONTENT_H5, null));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content", str);
        try {
            this.context.startActivity(createScheme(WEIBO_SEND_CONTENT_SCHEME, hashMap));
        } catch (Exception e) {
        }
    }

    public void commentWeibo(String str) {
        commentWeibo(str, false);
    }

    public void commentWeibo(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", str);
            gotoWebActivity(schemeAddProperty(WEIBO_COMMENT_H5, hashMap));
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("srcid", str);
        try {
            this.context.startActivity(createScheme(WEIBO_COMMENT_SCHEME, hashMap2));
        } catch (Exception e) {
        }
    }

    public void openWeiboSearchPage(String str) {
        openWeiboSearchPage(str, false);
    }

    public void openWeiboSearchPage(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("q", str);
            gotoWebActivity(schemeAddProperty(WEIBO_SEARCH_URL_H5, hashMap));
            return;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("q", str);
        try {
            this.context.startActivity(createScheme(WEIBO_SEARCH_URL_CHEME, hashMap2));
        } catch (Exception e) {
        }
    }

    public void gotoMyHomePage() {
        gotoMyHomePage(false);
    }

    public void gotoMyHomePage(boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            new HashMap().put("cookie", "0_all");
            gotoWebActivity(schemeAddProperty("http://m.weibo.cn/index/router?", null));
            return;
        }
        try {
            this.context.startActivity(createScheme(WEIBO_GOTO_HOME_SCHEME, null));
        } catch (Exception e) {
        }
    }

    public void gotoMyProfile() {
        gotoMyProfile(false);
    }

    public void gotoMyProfile(boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            new HashMap().put("cookie", "3");
            gotoWebActivity(schemeAddProperty("http://m.weibo.cn/index/router?", null));
            return;
        }
        try {
            this.context.startActivity(createScheme(WEIBO_GOTO_MYPROFILE_SCHEME, null));
        } catch (Exception e) {
        }
    }

    public void startOtherPage(String str) {
        startOtherPage(str, null);
    }

    public void startOtherPage(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            gotoWebActivity(schemeAddProperty(str, hashMap));
        }
    }

    private Intent createScheme(String str, HashMap<String, String> hashMap) {
        return new Intent("android.intent.action.VIEW", Uri.parse(schemeAddProperty(str, hashMap)));
    }

    private String schemeAddProperty(String str, HashMap<String, String> hashMap) {
        String str2 = str + "luicode=10000360&&lfid=OP_" + this.authInfo.getAppKey();
        if (hashMap == null) {
            return str2;
        }
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                str2 = str3 + ETAG.ITEM_SEPARATOR + next.getKey().toString() + ETAG.EQUAL + next.getValue().toString();
            } else {
                return str3;
            }
        }
    }

    private void gotoWebActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(this.context, WeiboSdkWebActivity.class);
        DefaultWebViewRequestParam defaultWebViewRequestParam = new DefaultWebViewRequestParam(this.authInfo, WebRequestType.DEFAULT, null, null, str, this.context);
        Bundle bundle = new Bundle();
        defaultWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        this.context.startActivity(intent);
    }
}
