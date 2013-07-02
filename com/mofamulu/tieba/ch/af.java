package com.mofamulu.tieba.ch;

import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.loginshare.Token;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes.dex */
public class af {
    public static String a = HttpUtils.HEADER_NAME_USER_AGENT;
    public static String b = "UTF-8";
    public static String c = "GBK";
    HttpClient d;

    public static af a() {
        return new af();
    }

    public static af b() {
        af afVar = new af();
        afVar.c();
        return afVar;
    }

    public boolean c() {
        String N;
        Token b2 = bg.b();
        if (b2 != null) {
            Date a2 = ae.a(MKEvent.ERROR_PERMISSION_DENIED);
            a("BDUSS", b2.mBduss, a2, ".baidu.com", "/");
            a("PTOKEN", b2.mPtoken, a2, ".baidu.com", "/");
            if (!TiebaApplication.m() && (N = TiebaApplication.f().N()) != null) {
                a("tbs", N, a2, ".baidu.com", "/");
            }
            return true;
        }
        return false;
    }

    public void a(AccountData accountData) {
        if (accountData != null) {
            Token b2 = com.baidu.tieba.account.a.b(accountData.getBDUSS());
            Date a2 = ae.a(MKEvent.ERROR_PERMISSION_DENIED);
            a("BDUSS", b2.mBduss, a2, ".baidu.com", "/");
            a("PTOKEN", b2.mPtoken, a2, ".baidu.com", "/");
            String tbs = accountData.getTbs();
            if (tbs != null) {
                a("tbs", tbs, a2, ".baidu.com", "/");
            }
        }
    }

    private af() {
    }

    private void f() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
        this.d = new DefaultHttpClient(basicHttpParams);
        this.d.getParams().setParameter("http.protocol.cookie-policy", "compatibility");
    }

    public HttpClient d() {
        if (this.d == null) {
            f();
        }
        return this.d;
    }

    public void a(Cookie cookie) {
        d().getCookieStore().addCookie(cookie);
    }

    public void a(String str, String str2, Date date, String str3, String str4) {
        BasicClientCookie basicClientCookie = new BasicClientCookie(str, str2);
        basicClientCookie.setExpiryDate(date);
        basicClientCookie.setDomain(str3);
        basicClientCookie.setPath(str4);
        a((Cookie) basicClientCookie);
    }

    public List e() {
        return d().getCookieStore().getCookies();
    }

    public String a(String str, Map map, String str2, String str3, String str4) {
        HttpClient d = d();
        if (str2 != null) {
            d.getParams().setParameter(HttpUtils.HEADER_NAME_REFERER, str2);
        }
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
            if (!str.endsWith("&")) {
                str = String.valueOf(str) + "&";
            }
            str = String.valueOf(str) + URLEncodedUtils.format(arrayList, "UTF-8");
        }
        HttpGet httpGet = new HttpGet(str);
        httpGet.setHeader(a, str3);
        if (str2 != null) {
            httpGet.addHeader(HttpUtils.HEADER_NAME_REFERER, str2);
        }
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
        HttpEntity entity = d.execute(httpGet).getEntity();
        if (entity == null) {
            return null;
        }
        String a2 = bf.a(entity.getContent(), str4);
        entity.consumeContent();
        return a2;
    }

    public byte[] b(String str, Map map, String str2, String str3, String str4) {
        HttpClient d = d();
        if (str2 != null) {
            d.getParams().setParameter(HttpUtils.HEADER_NAME_REFERER, str2);
        }
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
            if (!str.endsWith("&")) {
                str = String.valueOf(str) + "&";
            }
            str = String.valueOf(str) + URLEncodedUtils.format(arrayList, str4);
        }
        HttpGet httpGet = new HttpGet(str);
        httpGet.setHeader(a, str3);
        if (str2 != null) {
            httpGet.addHeader(HttpUtils.HEADER_NAME_REFERER, str2);
        }
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
        HttpEntity entity = d.execute(httpGet).getEntity();
        if (entity == null) {
            return null;
        }
        byte[] a2 = bf.a(entity.getContent());
        entity.consumeContent();
        return a2;
    }

    public String a(String str, Map map, String str2, String str3, String str4, String str5) {
        HttpClient d = d();
        HttpPost httpPost = new HttpPost(str);
        httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpPost.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
        httpPost.setHeader(a, str3);
        if (str2 != null) {
            d.getParams().setParameter(HttpUtils.HEADER_NAME_REFERER, str2);
            httpPost.addHeader(HttpUtils.HEADER_NAME_REFERER, str2);
        }
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, str4));
        HttpResponse execute = d.execute(httpPost);
        HttpEntity entity = execute.getEntity();
        if (execute.getStatusLine().getStatusCode() / 100 == 3) {
            return execute.getFirstHeader(HttpUtils.HEADER_NAME_LOCATION).getValue();
        }
        if (entity == null) {
            return null;
        }
        String a2 = bf.a(entity.getContent(), str5);
        entity.consumeContent();
        return a2;
    }
}
