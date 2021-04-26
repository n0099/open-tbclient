package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f31322a;

    /* renamed from: b  reason: collision with root package name */
    public String f31323b;

    /* renamed from: c  reason: collision with root package name */
    public String f31324c;

    /* renamed from: d  reason: collision with root package name */
    public String f31325d;

    /* renamed from: e  reason: collision with root package name */
    public String f31326e;

    /* renamed from: f  reason: collision with root package name */
    public String f31327f;

    /* renamed from: g  reason: collision with root package name */
    public String f31328g;

    /* renamed from: h  reason: collision with root package name */
    public String f31329h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f31327f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f31322a);
            jSONObject.put("apptype", this.f31323b);
            jSONObject.put("phone_ID", this.f31324c);
            jSONObject.put("certflag", this.f31325d);
            jSONObject.put("sdkversion", this.f31326e);
            jSONObject.put("appid", this.f31327f);
            jSONObject.put("expandparams", this.f31328g);
            jSONObject.put("sign", this.f31329h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f31324c = str;
    }

    public void d(String str) {
        this.f31325d = str;
    }

    public void e(String str) {
        this.f31326e = str;
    }

    public void f(String str) {
        this.f31327f = str;
    }

    public void g(String str) {
        this.f31329h = str;
    }

    public void a(String str) {
        this.f31322a = str;
    }

    public String c() {
        return n(this.f31322a + this.f31326e + this.f31327f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f31323b = str;
    }
}
