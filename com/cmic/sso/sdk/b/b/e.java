package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public a f30611a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30612b;

    /* renamed from: c  reason: collision with root package name */
    public String f30613c;

    /* renamed from: d  reason: collision with root package name */
    public String f30614d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30615e = false;

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void a(boolean z) {
        this.f30615e = z;
    }

    public void b(String str) {
        this.f30614d = str;
    }

    public void c(String str) {
        this.f30613c = str;
    }

    public void a(byte[] bArr) {
        this.f30612b = bArr;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f30615e) {
            try {
                jSONObject.put("encrypted", this.f30613c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.d.a.a(this.f30612b, this.f30611a.toString()));
                jSONObject.put("securityreinforce", this.f30614d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a c() {
        return this.f30611a;
    }

    public void a(a aVar) {
        this.f30611a = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30611a.a();
    }
}
