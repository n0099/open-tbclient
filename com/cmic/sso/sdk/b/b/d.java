package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30404a;

    /* renamed from: b  reason: collision with root package name */
    public String f30405b;

    /* renamed from: c  reason: collision with root package name */
    public String f30406c;

    public d(String str, String str2, String str3) {
        this.f30404a = str;
        this.f30405b = str2;
        this.f30406c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30404a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30405b);
            jSONObject.put("data", this.f30406c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
