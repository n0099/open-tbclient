package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30300a;

    /* renamed from: b  reason: collision with root package name */
    public String f30301b;

    /* renamed from: c  reason: collision with root package name */
    public String f30302c;

    /* renamed from: d  reason: collision with root package name */
    public String f30303d;

    /* renamed from: e  reason: collision with root package name */
    public String f30304e;

    /* renamed from: f  reason: collision with root package name */
    public String f30305f;

    /* renamed from: g  reason: collision with root package name */
    public String f30306g;

    /* renamed from: h  reason: collision with root package name */
    public String f30307h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30305f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30300a);
            jSONObject.put("apptype", this.f30301b);
            jSONObject.put("phone_ID", this.f30302c);
            jSONObject.put("certflag", this.f30303d);
            jSONObject.put("sdkversion", this.f30304e);
            jSONObject.put("appid", this.f30305f);
            jSONObject.put("expandparams", this.f30306g);
            jSONObject.put("sign", this.f30307h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30302c = str;
    }

    public void d(String str) {
        this.f30303d = str;
    }

    public void e(String str) {
        this.f30304e = str;
    }

    public void f(String str) {
        this.f30305f = str;
    }

    public void g(String str) {
        this.f30307h = str;
    }

    public void a(String str) {
        this.f30300a = str;
    }

    public String c() {
        return n(this.f30300a + this.f30304e + this.f30305f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30301b = str;
    }
}
