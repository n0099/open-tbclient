package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7402a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7403b;
    public boolean c;
    public boolean d;
    public long e;
    public long f;
    public long g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1026a {
        a a();
    }

    public a a(boolean z) {
        this.d = z;
        return this;
    }

    public a b(boolean z) {
        this.f7402a = z;
        return this;
    }

    public a c(boolean z) {
        this.f7403b = z;
        return this;
    }

    public a d(boolean z) {
        this.c = z;
        return this;
    }

    public a a(long j) {
        this.e = j;
        return this;
    }

    public a b(long j) {
        this.f = j;
        return this;
    }

    public a c(long j) {
        this.g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f7402a);
            jSONObject.put("isFromVideoDetailPage", this.f7403b);
            jSONObject.put("isFromDetailPage", this.c);
            jSONObject.put("duration", this.e);
            jSONObject.put("totalPlayDuration", this.f);
            jSONObject.put("currentPlayPosition", this.g);
            jSONObject.put("isAutoPlay", this.d);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.b(jSONObject.optBoolean("isCompleted"));
        aVar.c(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.d(jSONObject.optBoolean("isFromDetailPage"));
        aVar.a(jSONObject.optLong("duration"));
        aVar.b(jSONObject.optLong("totalPlayDuration"));
        aVar.c(jSONObject.optLong("currentPlayPosition"));
        aVar.a(jSONObject.optBoolean("isAutoPlay"));
        return aVar;
    }
}
