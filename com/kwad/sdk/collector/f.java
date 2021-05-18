package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f31963a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f31964b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f31965c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f31966d;

    /* renamed from: e  reason: collision with root package name */
    public int f31967e;

    public f(String str, int i2) {
        this.f31967e = f31963a;
        this.f31966d = str;
        this.f31967e = i2;
    }

    public static JSONArray a(List<f> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (f fVar : list) {
            jSONArray.put(fVar.a());
        }
        return jSONArray;
    }

    private String b() {
        int lastIndexOf;
        String str = this.f31966d;
        return ((str.startsWith("com.android.") || this.f31966d.startsWith("android.permission")) && (lastIndexOf = this.f31966d.lastIndexOf(".")) < this.f31966d.length() + (-1)) ? this.f31966d.substring(lastIndexOf + 1) : str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.f31967e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject;
    }
}
