package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30477a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30478b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30479c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30480d;

    /* renamed from: e  reason: collision with root package name */
    public long f30481e;

    /* renamed from: f  reason: collision with root package name */
    public long f30482f;

    /* renamed from: g  reason: collision with root package name */
    public long f30483g;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0326a {
        a e();

        boolean g();
    }

    public a a(boolean z) {
        this.f30480d = z;
        return this;
    }

    public a b(boolean z) {
        this.f30477a = z;
        return this;
    }

    public a c(boolean z) {
        this.f30478b = z;
        return this;
    }

    public a d(boolean z) {
        this.f30479c = z;
        return this;
    }

    public a a(long j) {
        this.f30481e = j;
        return this;
    }

    public a b(long j) {
        this.f30482f = j;
        return this;
    }

    public a c(long j) {
        this.f30483g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f30477a);
            jSONObject.put("isFromVideoDetailPage", this.f30478b);
            jSONObject.put("isFromDetailPage", this.f30479c);
            jSONObject.put("duration", this.f30481e);
            jSONObject.put("totalPlayDuration", this.f30482f);
            jSONObject.put("currentPlayPosition", this.f30483g);
            jSONObject.put("isAutoPlay", this.f30480d);
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
