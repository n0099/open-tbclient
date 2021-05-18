package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30576a;

    /* renamed from: b  reason: collision with root package name */
    public String f30577b;

    /* renamed from: c  reason: collision with root package name */
    public String f30578c;

    public d(String str, String str2, String str3) {
        this.f30576a = str;
        this.f30577b = str2;
        this.f30578c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30576a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30577b);
            jSONObject.put("data", this.f30578c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
