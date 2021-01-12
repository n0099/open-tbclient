package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f7705a;

    /* renamed from: b  reason: collision with root package name */
    private String f7706b;
    private String c;

    public d(String str, String str2, String str3) {
        this.f7705a = str;
        this.f7706b = str2;
        this.c = str3;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f7705a;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f7706b);
            jSONObject.put("data", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
