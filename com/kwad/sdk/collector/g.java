package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f55703b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f55704c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f55705d;

    /* renamed from: e  reason: collision with root package name */
    public int f55706e;

    public g(String str, int i2) {
        this.f55706e = a;
        this.f55705d = str;
        this.f55706e = i2;
    }

    public static JSONArray a(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (g gVar : list) {
            jSONArray.put(gVar.a());
        }
        return jSONArray;
    }

    private String b() {
        int lastIndexOf;
        String str = this.f55705d;
        return ((str.startsWith("com.android.") || this.f55705d.startsWith("android.permission")) && (lastIndexOf = this.f55705d.lastIndexOf(".")) < this.f55705d.length() + (-1)) ? this.f55705d.substring(lastIndexOf + 1) : str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.f55706e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject;
    }
}
