package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f8005a;

    /* renamed from: b  reason: collision with root package name */
    private String f8006b;
    private String c;

    public d(String str, String str2, String str3) {
        this.f8005a = str;
        this.f8006b = str2;
        this.c = str3;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f8005a;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f8006b);
            jSONObject.put("data", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
