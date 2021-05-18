package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30567a;

    /* renamed from: b  reason: collision with root package name */
    public String f30568b;

    /* renamed from: c  reason: collision with root package name */
    public String f30569c;

    /* renamed from: d  reason: collision with root package name */
    public String f30570d;

    /* renamed from: e  reason: collision with root package name */
    public String f30571e;

    /* renamed from: f  reason: collision with root package name */
    public String f30572f;

    /* renamed from: g  reason: collision with root package name */
    public String f30573g;

    /* renamed from: h  reason: collision with root package name */
    public String f30574h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30572f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30567a);
            jSONObject.put("apptype", this.f30568b);
            jSONObject.put("phone_ID", this.f30569c);
            jSONObject.put("certflag", this.f30570d);
            jSONObject.put("sdkversion", this.f30571e);
            jSONObject.put("appid", this.f30572f);
            jSONObject.put("expandparams", this.f30573g);
            jSONObject.put("sign", this.f30574h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30569c = str;
    }

    public void d(String str) {
        this.f30570d = str;
    }

    public void e(String str) {
        this.f30571e = str;
    }

    public void f(String str) {
        this.f30572f = str;
    }

    public void g(String str) {
        this.f30574h = str;
    }

    public void a(String str) {
        this.f30567a = str;
    }

    public String c() {
        return n(this.f30567a + this.f30571e + this.f30572f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30568b = str;
    }
}
