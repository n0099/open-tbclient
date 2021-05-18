package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29722a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29723b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29724c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29725d;

    /* renamed from: e  reason: collision with root package name */
    public long f29726e;

    /* renamed from: f  reason: collision with root package name */
    public long f29727f;

    /* renamed from: g  reason: collision with root package name */
    public long f29728g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0313a {
        a e();

        boolean g();
    }

    public a a(boolean z) {
        this.f29725d = z;
        return this;
    }

    public a b(boolean z) {
        this.f29722a = z;
        return this;
    }

    public a c(boolean z) {
        this.f29723b = z;
        return this;
    }

    public a d(boolean z) {
        this.f29724c = z;
        return this;
    }

    public a a(long j) {
        this.f29726e = j;
        return this;
    }

    public a b(long j) {
        this.f29727f = j;
        return this;
    }

    public a c(long j) {
        this.f29728g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f29722a);
            jSONObject.put("isFromVideoDetailPage", this.f29723b);
            jSONObject.put("isFromDetailPage", this.f29724c);
            jSONObject.put("duration", this.f29726e);
            jSONObject.put("totalPlayDuration", this.f29727f);
            jSONObject.put("currentPlayPosition", this.f29728g);
            jSONObject.put("isAutoPlay", this.f29725d);
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
