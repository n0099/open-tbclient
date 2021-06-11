package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30598a;

    /* renamed from: b  reason: collision with root package name */
    public String f30599b;

    /* renamed from: c  reason: collision with root package name */
    public String f30600c;

    /* renamed from: d  reason: collision with root package name */
    public String f30601d;

    /* renamed from: e  reason: collision with root package name */
    public String f30602e;

    /* renamed from: f  reason: collision with root package name */
    public String f30603f;

    /* renamed from: g  reason: collision with root package name */
    public String f30604g;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30603f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30598a);
            jSONObject.put("apptype", this.f30599b);
            jSONObject.put("phone_ID", this.f30600c);
            jSONObject.put("certflag", this.f30601d);
            jSONObject.put("sdkversion", this.f30602e);
            jSONObject.put("appid", this.f30603f);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", this.f30604g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30599b = str;
    }

    public void d(String str) {
        this.f30600c = str;
    }

    public void e(String str) {
        this.f30601d = str;
    }

    public void f(String str) {
        this.f30602e = str;
    }

    public void g(String str) {
        this.f30603f = str;
    }

    public void h(String str) {
        this.f30604g = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return this.f30598a + this.f30602e + this.f30603f + "iYm0HAnkxQtpvN44";
    }

    public void b(String str) {
        this.f30598a = str;
    }
}
