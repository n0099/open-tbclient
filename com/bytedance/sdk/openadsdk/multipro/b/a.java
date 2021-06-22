package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29836a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29837b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29838c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29839d;

    /* renamed from: e  reason: collision with root package name */
    public long f29840e;

    /* renamed from: f  reason: collision with root package name */
    public long f29841f;

    /* renamed from: g  reason: collision with root package name */
    public long f29842g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0319a {
        a e();

        boolean g();
    }

    public a a(boolean z) {
        this.f29839d = z;
        return this;
    }

    public a b(boolean z) {
        this.f29836a = z;
        return this;
    }

    public a c(boolean z) {
        this.f29837b = z;
        return this;
    }

    public a d(boolean z) {
        this.f29838c = z;
        return this;
    }

    public a a(long j) {
        this.f29840e = j;
        return this;
    }

    public a b(long j) {
        this.f29841f = j;
        return this;
    }

    public a c(long j) {
        this.f29842g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f29836a);
            jSONObject.put("isFromVideoDetailPage", this.f29837b);
            jSONObject.put("isFromDetailPage", this.f29838c);
            jSONObject.put("duration", this.f29840e);
            jSONObject.put("totalPlayDuration", this.f29841f);
            jSONObject.put("currentPlayPosition", this.f29842g);
            jSONObject.put("isAutoPlay", this.f29839d);
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
