package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public a f30693a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30694b;

    /* renamed from: c  reason: collision with root package name */
    public String f30695c;

    /* renamed from: d  reason: collision with root package name */
    public String f30696d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30697e = false;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void a(boolean z) {
        this.f30697e = z;
    }

    public void b(String str) {
        this.f30696d = str;
    }

    public void c(String str) {
        this.f30695c = str;
    }

    public void a(byte[] bArr) {
        this.f30694b = bArr;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f30697e) {
            try {
                jSONObject.put("encrypted", this.f30695c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.d.a.a(this.f30694b, this.f30693a.toString()));
                jSONObject.put("securityreinforce", this.f30696d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a c() {
        return this.f30693a;
    }

    public void a(a aVar) {
        this.f30693a = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30693a.a();
    }
}
