package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public final String f30688a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30689b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30690c;

    /* renamed from: d  reason: collision with root package name */
    public String f30691d = "authz";

    /* renamed from: e  reason: collision with root package name */
    public String f30692e;

    public d(String str, String str2, String str3) {
        this.f30688a = str;
        this.f30689b = str2;
        this.f30690c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30688a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void b(String str) {
        this.f30691d = str;
    }

    public void c(String str) {
        this.f30692e = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30689b);
            jSONObject.put("data", this.f30690c);
            jSONObject.put("userCapaid", this.f30692e);
            jSONObject.put("funcType", this.f30691d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
