package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30680a;

    /* renamed from: b  reason: collision with root package name */
    public String f30681b;

    /* renamed from: c  reason: collision with root package name */
    public String f30682c;

    /* renamed from: d  reason: collision with root package name */
    public String f30683d;

    /* renamed from: e  reason: collision with root package name */
    public String f30684e;

    /* renamed from: f  reason: collision with root package name */
    public String f30685f;

    /* renamed from: g  reason: collision with root package name */
    public String f30686g;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30685f;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30680a);
            jSONObject.put("apptype", this.f30681b);
            jSONObject.put("phone_ID", this.f30682c);
            jSONObject.put("certflag", this.f30683d);
            jSONObject.put("sdkversion", this.f30684e);
            jSONObject.put("appid", this.f30685f);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", this.f30686g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void c(String str) {
        this.f30681b = str;
    }

    public void d(String str) {
        this.f30682c = str;
    }

    public void e(String str) {
        this.f30683d = str;
    }

    public void f(String str) {
        this.f30684e = str;
    }

    public void g(String str) {
        this.f30685f = str;
    }

    public void h(String str) {
        this.f30686g = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return this.f30680a + this.f30684e + this.f30685f + "iYm0HAnkxQtpvN44";
    }

    public void b(String str) {
        this.f30680a = str;
    }
}
