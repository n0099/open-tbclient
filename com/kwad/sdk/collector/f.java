package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f32718a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f32719b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f32720c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f32721d;

    /* renamed from: e  reason: collision with root package name */
    public int f32722e;

    public f(String str, int i2) {
        this.f32722e = f32718a;
        this.f32721d = str;
        this.f32722e = i2;
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
        String str = this.f32721d;
        return ((str.startsWith("com.android.") || this.f32721d.startsWith("android.permission")) && (lastIndexOf = this.f32721d.lastIndexOf(".")) < this.f32721d.length() + (-1)) ? this.f32721d.substring(lastIndexOf + 1) : str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", b());
            jSONObject.put("state", this.f32722e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject;
    }
}
