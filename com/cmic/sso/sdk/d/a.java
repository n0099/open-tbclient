package com.cmic.sso.sdk.d;

import com.cmic.sso.sdk.c.b.g;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends g {
    public static CopyOnWriteArrayList<Throwable> oKP = new CopyOnWriteArrayList<>();
    private String A;
    private String B;
    private String C;
    private JSONArray oKO;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = "";
    private String m = null;
    private String n = null;
    private String o = null;
    private String q = null;
    private String r = null;
    private String s = null;
    private String t = null;
    private String u = null;
    private String v = null;
    private String w = null;
    private String x = null;
    private String y = null;
    private String z = null;

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.A = str;
    }

    public void c(String str) {
        this.x = str;
    }

    public void d(String str) {
        this.y = str;
    }

    public void e(String str) {
        this.z = str;
    }

    public void f(String str) {
        this.t = str;
    }

    public void g(String str) {
        this.n = str;
    }

    public void h(String str) {
        this.m = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void j(String str) {
        this.d = str;
    }

    public void k(String str) {
        this.e = str;
    }

    public void l(String str) {
        this.g = str;
    }

    public void m(String str) {
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONArray jSONArray) {
        this.oKO = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str) {
        this.w = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str) {
        this.q = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.u = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str) {
        this.v = str;
    }

    public void s(String str) {
        this.o = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str) {
        this.c = str;
    }

    public void u(String str) {
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(String str) {
        this.s = str;
    }

    public void w(String str) {
        this.i = str;
    }

    public void x(String str) {
        this.k = str;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str) {
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(String str) {
        this.r = str;
    }

    public void A(String str) {
        this.B = str;
    }

    public void WH(String str) {
        this.C = str;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.b);
            jSONObject.put("traceId", this.c);
            jSONObject.put("appName", this.d);
            jSONObject.put("appVersion", this.e);
            jSONObject.put(CommandMessage.SDK_VERSION, this.f);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", this.g);
            jSONObject.put("requestTime", this.h);
            jSONObject.put("responseTime", this.i);
            jSONObject.put("elapsedTime", this.j);
            jSONObject.put("requestType", this.k);
            jSONObject.put("interfaceType", this.l);
            jSONObject.put("interfaceCode", this.m);
            jSONObject.put("interfaceElasped", this.n);
            jSONObject.put("loginType", this.o);
            jSONObject.put("exceptionStackTrace", this.oKO);
            jSONObject.put("operatorType", this.q);
            jSONObject.put("networkType", this.r);
            jSONObject.put("networkClass", this.s);
            jSONObject.put(Constants.PHONE_BRAND, this.t);
            jSONObject.put("reqDevice", this.u);
            jSONObject.put("reqSystem", this.v);
            jSONObject.put("simCardNum", this.w);
            jSONObject.put("imsiState", this.x);
            jSONObject.put("resultCode", this.y);
            jSONObject.put("is_root", this.z);
            jSONObject.put("is_phoneStatePermission", this.A);
            jSONObject.put("AID", this.B);
            jSONObject.put("sysOperType", this.C);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
