package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30309a;

    /* renamed from: b  reason: collision with root package name */
    public String f30310b;

    /* renamed from: c  reason: collision with root package name */
    public String f30311c;

    public d(String str, String str2, String str3) {
        this.f30309a = str;
        this.f30310b = str2;
        this.f30311c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30309a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30310b);
            jSONObject.put("data", this.f30311c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
