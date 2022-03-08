package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f54053b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f54054c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f54055d;

    /* renamed from: e  reason: collision with root package name */
    public int f54056e;

    public g(String str, int i2) {
        this.f54056e = a;
        this.f54055d = str;
        this.f54056e = i2;
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
        String str = this.f54055d;
        return ((str.startsWith("com.android.") || this.f54055d.startsWith("android.permission")) && (lastIndexOf = this.f54055d.lastIndexOf(".")) < this.f54055d.length() + (-1)) ? this.f54055d.substring(lastIndexOf + 1) : str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.f54056e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject;
    }
}
