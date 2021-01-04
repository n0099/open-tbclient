package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f12021a;

    /* renamed from: b  reason: collision with root package name */
    private String f12022b;
    private a c;
    private int d;

    /* loaded from: classes3.dex */
    public enum a {
        OK,
        ERROR,
        HANDLER_NOT_FOUND_EXCEPTION,
        JSON_PARSE_EXCEPTION
    }

    public e(d dVar, a aVar, String str) {
        this.d = 0;
        this.f12021a = dVar.c();
        this.c = aVar;
        this.f12022b = str;
    }

    public e(d dVar, a aVar, JSONObject jSONObject) {
        this(dVar, aVar, jSONObject != null ? jSONObject.toString() : "");
    }

    public e(d dVar, a aVar, JSONObject jSONObject, int i) {
        this(dVar, aVar, jSONObject != null ? jSONObject.toString() : "");
        this.d = i;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackid", this.f12021a);
            jSONObject.put("status", this.c.ordinal());
            jSONObject.put("data", this.f12022b);
            jSONObject.put("keep", this.d);
        } catch (JSONException e) {
            GDTLogger.w("Exception while sendingJSResponse", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bridge.callback").append("(").append(jSONObject.toString()).append(");");
        return sb.toString();
    }
}
