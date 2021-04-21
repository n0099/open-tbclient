package com.cmic.sso.sdk.c;

import com.baidu.tbadk.util.AdExtParam;
import com.baidu.wallet.api.IWalletLoginListener;
import com.cmic.sso.sdk.b.b.g;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public static CopyOnWriteArrayList<Throwable> f30450a = new CopyOnWriteArrayList<>();
    public String A;
    public String B;
    public String C;
    public JSONArray p;

    /* renamed from: b  reason: collision with root package name */
    public String f30451b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f30452c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f30453d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f30454e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f30455f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f30456g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f30457h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = "";
    public String m = null;
    public String n = null;
    public String o = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;
    public String z = null;

    public void A(String str) {
        this.B = str;
    }

    public void B(String str) {
        this.C = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return null;
    }

    public void a(String str) {
        this.f30451b = str;
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
        this.f30453d = str;
    }

    public void k(String str) {
        this.f30454e = str;
    }

    public void l(String str) {
        this.f30456g = str;
    }

    public void m(String str) {
        this.j = str;
    }

    public void o(String str) {
        this.w = str;
    }

    public void p(String str) {
        this.q = str;
    }

    public void q(String str) {
        this.u = str;
    }

    public void r(String str) {
        this.v = str;
    }

    public void s(String str) {
        this.o = str;
    }

    public void t(String str) {
        this.f30452c = str;
    }

    public void u(String str) {
        this.f30457h = str;
    }

    public void v(String str) {
        this.s = str;
    }

    public void w(String str) {
        this.i = str;
    }

    public void x(String str) {
        this.k = str;
    }

    public void y(String str) {
        this.f30455f = str;
    }

    public void z(String str) {
        this.r = str;
    }

    public void a(JSONArray jSONArray) {
        this.p = jSONArray;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f30451b);
            jSONObject.put("traceId", this.f30452c);
            jSONObject.put("appName", this.f30453d);
            jSONObject.put("appVersion", this.f30454e);
            jSONObject.put(CommandMessage.SDK_VERSION, this.f30455f);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", this.f30456g);
            jSONObject.put("requestTime", this.f30457h);
            jSONObject.put("responseTime", this.i);
            jSONObject.put("elapsedTime", this.j);
            jSONObject.put(AdExtParam.KEY_REQUEST_TYPE, this.k);
            jSONObject.put("interfaceType", this.l);
            jSONObject.put("interfaceCode", this.m);
            jSONObject.put("interfaceElasped", this.n);
            jSONObject.put(IWalletLoginListener.KEY_LOGIN_TYPE, this.o);
            jSONObject.put("exceptionStackTrace", this.p);
            jSONObject.put("operatorType", this.q);
            jSONObject.put("networkType", this.r);
            jSONObject.put("networkClass", this.s);
            jSONObject.put("brand", this.t);
            jSONObject.put("reqDevice", this.u);
            jSONObject.put("reqSystem", this.v);
            jSONObject.put("simCardNum", this.w);
            jSONObject.put("imsiState", this.x);
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, this.y);
            jSONObject.put("is_root", this.z);
            jSONObject.put("is_phoneStatePermission", this.A);
            jSONObject.put("AID", this.B);
            jSONObject.put("sysOperType", this.C);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
