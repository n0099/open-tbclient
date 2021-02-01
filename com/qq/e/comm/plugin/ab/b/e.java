package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f11724a;

    /* renamed from: b  reason: collision with root package name */
    private String f11725b;
    private a c;
    private int d;

    /* loaded from: classes15.dex */
    public enum a {
        OK,
        ERROR,
        HANDLER_NOT_FOUND_EXCEPTION,
        JSON_PARSE_EXCEPTION
    }

    public e(d dVar, a aVar, String str) {
        this.d = 0;
        this.f11724a = dVar.c();
        this.c = aVar;
        this.f11725b = str;
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
            jSONObject.put("callbackid", this.f11724a);
            jSONObject.put("status", this.c.ordinal());
            jSONObject.put("data", this.f11725b);
            jSONObject.put("keep", this.d);
        } catch (JSONException e) {
            GDTLogger.w("Exception while sendingJSResponse", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bridge.callback").append("(").append(jSONObject.toString()).append(");");
        return sb.toString();
    }
}
