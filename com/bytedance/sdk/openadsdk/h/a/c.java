package com.bytedance.sdk.openadsdk.h.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends d<c> {

    /* renamed from: a  reason: collision with root package name */
    private long f7175a;

    /* renamed from: b  reason: collision with root package name */
    private long f7176b;

    public c a(long j) {
        this.f7175a = j;
        return this;
    }

    public c b(long j) {
        this.f7176b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.d, com.bytedance.sdk.openadsdk.h.a.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.f7175a);
            a2.put("s_process_time", this.f7176b);
        } catch (Exception e) {
        }
        return a2;
    }
}
