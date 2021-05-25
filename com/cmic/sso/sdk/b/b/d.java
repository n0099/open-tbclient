package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30505a;

    /* renamed from: b  reason: collision with root package name */
    public String f30506b;

    /* renamed from: c  reason: collision with root package name */
    public String f30507c;

    public d(String str, String str2, String str3) {
        this.f30505a = str;
        this.f30506b = str2;
        this.f30507c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30505a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30506b);
            jSONObject.put("data", this.f30507c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
