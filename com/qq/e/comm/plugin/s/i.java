package com.qq.e.comm.plugin.s;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private int f12455a;

    public static i a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ssp_ext")) == null) {
            return null;
        }
        i iVar = new i();
        iVar.a(optJSONObject.optInt("priority"));
        return iVar;
    }

    public static int b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ssp_ext")) == null) {
            return -1;
        }
        return optJSONObject.optInt("priority", -1);
    }

    public int a() {
        return this.f12455a;
    }

    public void a(int i) {
        this.f12455a = i;
    }
}
