package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29564a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29565b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29566c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29567d;

    /* renamed from: e  reason: collision with root package name */
    public long f29568e;

    /* renamed from: f  reason: collision with root package name */
    public long f29569f;

    /* renamed from: g  reason: collision with root package name */
    public long f29570g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0331a {
        a e();

        boolean g();
    }

    public a a(boolean z) {
        this.f29567d = z;
        return this;
    }

    public a b(boolean z) {
        this.f29564a = z;
        return this;
    }

    public a c(boolean z) {
        this.f29565b = z;
        return this;
    }

    public a d(boolean z) {
        this.f29566c = z;
        return this;
    }

    public a a(long j) {
        this.f29568e = j;
        return this;
    }

    public a b(long j) {
        this.f29569f = j;
        return this;
    }

    public a c(long j) {
        this.f29570g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f29564a);
            jSONObject.put("isFromVideoDetailPage", this.f29565b);
            jSONObject.put("isFromDetailPage", this.f29566c);
            jSONObject.put("duration", this.f29568e);
            jSONObject.put("totalPlayDuration", this.f29569f);
            jSONObject.put("currentPlayPosition", this.f29570g);
            jSONObject.put("isAutoPlay", this.f29567d);
        } catch (Exception unused) {
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
