package com.qq.e.comm.plugin.ab.a;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f11998a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f11999b;

    public a(c cVar, JSONObject jSONObject) {
        this.f11998a = cVar;
        this.f11999b = jSONObject;
    }

    public static a a(String str, JSONObject jSONObject) {
        c a2 = c.a(str);
        if (a2 == null) {
            GDTLogger.e("Unknown ADEvent Type:" + str);
            return null;
        }
        return new a(a2, jSONObject);
    }

    public c a() {
        return this.f11998a;
    }

    public JSONObject b() {
        return this.f11999b;
    }

    public String toString() {
        return "event<" + this.f11998a + "," + this.f11999b + ">";
    }
}
