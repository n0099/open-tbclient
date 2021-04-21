package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29572a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29573b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29574c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29575d;

    /* renamed from: e  reason: collision with root package name */
    public long f29576e;

    /* renamed from: f  reason: collision with root package name */
    public long f29577f;

    /* renamed from: g  reason: collision with root package name */
    public long f29578g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0333a {
        a e();

        boolean g();
    }

    public a a(boolean z) {
        this.f29575d = z;
        return this;
    }

    public a b(boolean z) {
        this.f29572a = z;
        return this;
    }

    public a c(boolean z) {
        this.f29573b = z;
        return this;
    }

    public a d(boolean z) {
        this.f29574c = z;
        return this;
    }

    public a a(long j) {
        this.f29576e = j;
        return this;
    }

    public a b(long j) {
        this.f29577f = j;
        return this;
    }

    public a c(long j) {
        this.f29578g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f29572a);
            jSONObject.put("isFromVideoDetailPage", this.f29573b);
            jSONObject.put("isFromDetailPage", this.f29574c);
            jSONObject.put("duration", this.f29576e);
            jSONObject.put("totalPlayDuration", this.f29577f);
            jSONObject.put("currentPlayPosition", this.f29578g);
            jSONObject.put("isAutoPlay", this.f29575d);
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
