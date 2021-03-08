package com.bytedance.sdk.openadsdk.g.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    private long f4774a;
    private long b;

    public b a(long j) {
        this.f4774a = j;
        return this;
    }

    public b b(long j) {
        this.b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.g.a.c, com.bytedance.sdk.openadsdk.g.a.a
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.f4774a);
            a2.put("s_process_time", this.b);
        } catch (Exception e) {
        }
        return a2;
    }
}
