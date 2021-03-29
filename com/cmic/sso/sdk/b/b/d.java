package com.cmic.sso.sdk.b.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30624a;

    /* renamed from: b  reason: collision with root package name */
    public String f30625b;

    /* renamed from: c  reason: collision with root package name */
    public String f30626c;

    public d(String str, String str2, String str3) {
        this.f30624a = str;
        this.f30625b = str2;
        this.f30626c = str3;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30624a;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30625b);
            jSONObject.put("data", this.f30626c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
