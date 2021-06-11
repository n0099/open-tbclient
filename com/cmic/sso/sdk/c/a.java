package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.wallet.api.IWalletLoginListener;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b.b.g;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {
    public String A;
    public String B;
    public String C;
    public String D;
    public JSONArray o;
    public String z;

    /* renamed from: b  reason: collision with root package name */
    public String f30648b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f30649c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f30650d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f30651e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f30652f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f30653g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f30654h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f30655i = null;
    public String j = null;
    public String k = "";
    public String l = null;
    public String m = null;
    public String n = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<Throwable> f30647a = new CopyOnWriteArrayList<>();

    public void A(String str) {
        this.A = str;
    }

    public void B(String str) {
        this.B = str;
    }

    public void C(String str) {
        this.C = str;
    }

    public void D(String str) {
        this.D = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return null;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void a(JSONArray jSONArray) {
        this.o = jSONArray;
    }

    public void b(String str) {
        this.f30648b = str;
    }

    public void c(String str) {
        this.z = str;
    }

    public void d(String str) {
        this.w = str;
    }

    public void e(String str) {
        this.x = str;
    }

    public void f(String str) {
        this.y = str;
    }

    public void g(String str) {
        this.s = str;
    }

    public void h(String str) {
        this.m = str;
    }

    public void i(String str) {
        this.l = str;
    }

    public void j(String str) {
        this.k = str;
    }

    public void k(String str) {
        this.f30650d = str;
    }

    public void l(String str) {
        this.f30651e = str;
    }

    public void m(String str) {
        this.f30652f = str;
    }

    public void n(String str) {
        this.f30655i = str;
    }

    public void o(String str) {
        this.v = str;
    }

    public void p(String str) {
        this.p = str;
    }

    public void q(String str) {
        this.t = str;
    }

    public void r(String str) {
        this.u = str;
    }

    public void s(String str) {
        this.n = str;
    }

    public void t(String str) {
        this.f30649c = str;
    }

    public void u(String str) {
        this.f30653g = str;
    }

    public void v(String str) {
        this.r = str;
    }

    public void x(String str) {
        this.f30654h = str;
    }

    public void y(String str) {
        this.j = str;
    }

    public void z(String str) {
        this.q = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f30648b);
            jSONObject.put("traceId", this.f30649c);
            jSONObject.put("appName", this.f30650d);
            jSONObject.put("appVersion", this.f30651e);
            jSONObject.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", this.f30652f);
            jSONObject.put("requestTime", this.f30653g);
            jSONObject.put("responseTime", this.f30654h);
            jSONObject.put("elapsedTime", this.f30655i);
            jSONObject.put(AdExtParam.KEY_REQUEST_TYPE, this.j);
            jSONObject.put("interfaceType", this.k);
            jSONObject.put("interfaceCode", this.l);
            jSONObject.put("interfaceElasped", this.m);
            jSONObject.put(IWalletLoginListener.KEY_LOGIN_TYPE, this.n);
            jSONObject.put("exceptionStackTrace", this.o);
            jSONObject.put("operatorType", this.p);
            jSONObject.put("networkType", this.q);
            jSONObject.put("networkClass", this.r);
            jSONObject.put("brand", this.s);
            jSONObject.put("reqDevice", this.t);
            jSONObject.put("reqSystem", this.u);
            jSONObject.put("simCardNum", this.v);
            jSONObject.put("imsiState", this.w);
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, this.x);
            jSONObject.put("is_root", this.y);
            jSONObject.put("is_phoneStatePermission", this.z);
            jSONObject.put("AID", this.A);
            jSONObject.put("sysOperType", this.B);
            jSONObject.put("scripType", this.C);
            if (!TextUtils.isEmpty(this.D)) {
                jSONObject.put("eip", this.D);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
