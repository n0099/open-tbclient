package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f4014a;
    private String b;
    private String c;

    public d(String str, String str2, String str3) {
        this.f4014a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f4014a;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.b);
            jSONObject.put("data", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
