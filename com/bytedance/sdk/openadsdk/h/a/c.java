package com.bytedance.sdk.openadsdk.h.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends d<c> {

    /* renamed from: a  reason: collision with root package name */
    private long f7473a;

    /* renamed from: b  reason: collision with root package name */
    private long f7474b;

    public c a(long j) {
        this.f7473a = j;
        return this;
    }

    public c b(long j) {
        this.f7474b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.d, com.bytedance.sdk.openadsdk.h.a.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.f7473a);
            a2.put("s_process_time", this.f7474b);
        } catch (Exception e) {
        }
        return a2;
    }
}
