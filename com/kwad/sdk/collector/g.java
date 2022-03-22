package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f39202b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f39203c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f39204d;

    /* renamed from: e  reason: collision with root package name */
    public int f39205e;

    public g(String str, int i) {
        this.f39205e = a;
        this.f39204d = str;
        this.f39205e = i;
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
        String str = this.f39204d;
        return ((str.startsWith("com.android.") || this.f39204d.startsWith("android.permission")) && (lastIndexOf = this.f39204d.lastIndexOf(".")) < this.f39204d.length() + (-1)) ? this.f39204d.substring(lastIndexOf + 1) : str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.f39205e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject;
    }
}
