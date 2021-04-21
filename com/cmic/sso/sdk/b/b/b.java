package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30395a;

    /* renamed from: b  reason: collision with root package name */
    public String f30396b;

    /* renamed from: c  reason: collision with root package name */
    public String f30397c;

    /* renamed from: d  reason: collision with root package name */
    public String f30398d;

    /* renamed from: e  reason: collision with root package name */
    public String f30399e;

    /* renamed from: f  reason: collision with root package name */
    public String f30400f;

    /* renamed from: g  reason: collision with root package name */
    public String f30401g;

    /* renamed from: h  reason: collision with root package name */
    public String f30402h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30400f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30395a);
            jSONObject.put("apptype", this.f30396b);
            jSONObject.put("phone_ID", this.f30397c);
            jSONObject.put("certflag", this.f30398d);
            jSONObject.put("sdkversion", this.f30399e);
            jSONObject.put("appid", this.f30400f);
            jSONObject.put("expandparams", this.f30401g);
            jSONObject.put("sign", this.f30402h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30397c = str;
    }

    public void d(String str) {
        this.f30398d = str;
    }

    public void e(String str) {
        this.f30399e = str;
    }

    public void f(String str) {
        this.f30400f = str;
    }

    public void g(String str) {
        this.f30402h = str;
    }

    public void a(String str) {
        this.f30395a = str;
    }

    public String c() {
        return n(this.f30395a + this.f30399e + this.f30400f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30396b = str;
    }
}
