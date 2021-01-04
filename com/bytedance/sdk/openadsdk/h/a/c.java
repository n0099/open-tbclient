package com.bytedance.sdk.openadsdk.h.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends d<c> {

    /* renamed from: a  reason: collision with root package name */
    private long f7472a;

    /* renamed from: b  reason: collision with root package name */
    private long f7473b;

    public c a(long j) {
        this.f7472a = j;
        return this;
    }

    public c b(long j) {
        this.f7473b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.d, com.bytedance.sdk.openadsdk.h.a.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.f7472a);
            a2.put("s_process_time", this.f7473b);
        } catch (Exception e) {
        }
        return a2;
    }
}
