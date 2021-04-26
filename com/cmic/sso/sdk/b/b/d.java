package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f31331a;

    /* renamed from: b  reason: collision with root package name */
    public String f31332b;

    /* renamed from: c  reason: collision with root package name */
    public String f31333c;

    public d(String str, String str2, String str3) {
        this.f31331a = str;
        this.f31332b = str2;
        this.f31333c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f31331a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f31332b);
            jSONObject.put("data", this.f31333c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
