package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30614a;

    /* renamed from: b  reason: collision with root package name */
    public String f30615b;

    /* renamed from: c  reason: collision with root package name */
    public String f30616c;

    /* renamed from: d  reason: collision with root package name */
    public String f30617d;

    /* renamed from: e  reason: collision with root package name */
    public String f30618e;

    /* renamed from: f  reason: collision with root package name */
    public String f30619f;

    /* renamed from: g  reason: collision with root package name */
    public String f30620g;

    /* renamed from: h  reason: collision with root package name */
    public String f30621h;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30619f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30614a);
            jSONObject.put("apptype", this.f30615b);
            jSONObject.put("phone_ID", this.f30616c);
            jSONObject.put("certflag", this.f30617d);
            jSONObject.put("sdkversion", this.f30618e);
            jSONObject.put("appid", this.f30619f);
            jSONObject.put("expandparams", this.f30620g);
            jSONObject.put("sign", this.f30621h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30616c = str;
    }

    public void d(String str) {
        this.f30617d = str;
    }

    public void e(String str) {
        this.f30618e = str;
    }

    public void f(String str) {
        this.f30619f = str;
    }

    public void g(String str) {
        this.f30621h = str;
    }

    public void a(String str) {
        this.f30614a = str;
    }

    public String c() {
        return n(this.f30614a + this.f30618e + this.f30619f + "iYm0HAnkxQtpvN44").toLowerCase();
    }

    public void b(String str) {
        this.f30615b = str;
    }
}
