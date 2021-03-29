package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30615a;

    /* renamed from: b  reason: collision with root package name */
    public String f30616b;

    /* renamed from: c  reason: collision with root package name */
    public String f30617c;

    /* renamed from: d  reason: collision with root package name */
    public String f30618d;

    /* renamed from: e  reason: collision with root package name */
    public String f30619e;

    /* renamed from: f  reason: collision with root package name */
    public String f30620f;

    /* renamed from: g  reason: collision with root package name */
    public String f30621g;

    /* renamed from: h  reason: collision with root package name */
    public String f30622h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30620f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30615a);
            jSONObject.put("apptype", this.f30616b);
            jSONObject.put("phone_ID", this.f30617c);
            jSONObject.put("certflag", this.f30618d);
            jSONObject.put("sdkversion", this.f30619e);
            jSONObject.put("appid", this.f30620f);
            jSONObject.put("expandparams", this.f30621g);
            jSONObject.put("sign", this.f30622h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30617c = str;
    }

    public void d(String str) {
        this.f30618d = str;
    }

    public void e(String str) {
        this.f30619e = str;
    }

    public void f(String str) {
        this.f30620f = str;
    }

    public void g(String str) {
        this.f30622h = str;
    }

    public void a(String str) {
        this.f30615a = str;
    }

    public String c() {
        return n(this.f30615a + this.f30619e + this.f30620f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30616b = str;
    }
}
