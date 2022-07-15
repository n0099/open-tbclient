package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public String d;
    public int e;

    public g(String str, int i) {
        this.e = a;
        this.d = str;
        this.e = i;
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

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.e);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        return jSONObject;
    }

    private String b() {
        int lastIndexOf;
        String str = this.d;
        return ((str.startsWith("com.android.") || this.d.startsWith("android.permission")) && (lastIndexOf = this.d.lastIndexOf(".")) < this.d.length() + (-1)) ? this.d.substring(lastIndexOf + 1) : str;
    }
}
