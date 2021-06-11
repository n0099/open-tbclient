package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public final String f30606a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30607b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30608c;

    /* renamed from: d  reason: collision with root package name */
    public String f30609d = "authz";

    /* renamed from: e  reason: collision with root package name */
    public String f30610e;

    public d(String str, String str2, String str3) {
        this.f30606a = str;
        this.f30607b = str2;
        this.f30608c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30606a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void b(String str) {
        this.f30609d = str;
    }

    public void c(String str) {
        this.f30610e = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30607b);
            jSONObject.put("data", this.f30608c);
            jSONObject.put("userCapaid", this.f30610e);
            jSONObject.put("funcType", this.f30609d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
