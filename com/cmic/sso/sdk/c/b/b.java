package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f7702a;

    /* renamed from: b  reason: collision with root package name */
    private String f7703b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f7702a);
            jSONObject.put("apptype", this.f7703b);
            jSONObject.put("phone_ID", this.c);
            jSONObject.put("certflag", this.d);
            jSONObject.put("sdkversion", this.e);
            jSONObject.put("appid", this.f);
            jSONObject.put("expandparams", this.g);
            jSONObject.put("sign", this.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f7702a = str;
    }

    public void b(String str) {
        this.f7703b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.h = str;
    }

    public String c() {
        return dD(this.f7702a + this.e + this.f + "iYm0HAnkxQtpvN44").toLowerCase();
    }
}
