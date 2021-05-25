package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30496a;

    /* renamed from: b  reason: collision with root package name */
    public String f30497b;

    /* renamed from: c  reason: collision with root package name */
    public String f30498c;

    /* renamed from: d  reason: collision with root package name */
    public String f30499d;

    /* renamed from: e  reason: collision with root package name */
    public String f30500e;

    /* renamed from: f  reason: collision with root package name */
    public String f30501f;

    /* renamed from: g  reason: collision with root package name */
    public String f30502g;

    /* renamed from: h  reason: collision with root package name */
    public String f30503h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30501f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30496a);
            jSONObject.put("apptype", this.f30497b);
            jSONObject.put("phone_ID", this.f30498c);
            jSONObject.put("certflag", this.f30499d);
            jSONObject.put("sdkversion", this.f30500e);
            jSONObject.put("appid", this.f30501f);
            jSONObject.put("expandparams", this.f30502g);
            jSONObject.put("sign", this.f30503h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30498c = str;
    }

    public void d(String str) {
        this.f30499d = str;
    }

    public void e(String str) {
        this.f30500e = str;
    }

    public void f(String str) {
        this.f30501f = str;
    }

    public void g(String str) {
        this.f30503h = str;
    }

    public void a(String str) {
        this.f30496a = str;
    }

    public String c() {
        return n(this.f30496a + this.f30500e + this.f30501f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30497b = str;
    }
}
