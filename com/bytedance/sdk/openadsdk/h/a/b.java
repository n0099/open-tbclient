package com.bytedance.sdk.openadsdk.h.a;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    public long f29102a;

    /* renamed from: b  reason: collision with root package name */
    public long f29103b;

    public b a(long j) {
        this.f29102a = j;
        return this;
    }

    public b b(long j) {
        this.f29103b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.c, com.bytedance.sdk.openadsdk.h.a.a
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.f29102a);
            a2.put("s_process_time", this.f29103b);
        } catch (Exception unused) {
        }
        return a2;
    }
}
