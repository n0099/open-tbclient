package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29525a;

    /* renamed from: b  reason: collision with root package name */
    public int f29526b;

    /* renamed from: c  reason: collision with root package name */
    public int f29527c;

    /* renamed from: d  reason: collision with root package name */
    public int f29528d;

    /* renamed from: e  reason: collision with root package name */
    public long f29529e;

    /* renamed from: f  reason: collision with root package name */
    public long f29530f;

    /* renamed from: g  reason: collision with root package name */
    public long f29531g;

    /* renamed from: h  reason: collision with root package name */
    public long f29532h;

    /* renamed from: i  reason: collision with root package name */
    public int f29533i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.f29526b = 0;
        this.f29527c = 0;
        this.f29529e = 0L;
        this.f29530f = 0L;
        this.f29531g = 0L;
        this.f29532h = 0L;
        this.f29533i = 0;
        this.f29525a = str;
        this.f29526b = i2;
        this.f29527c = i3;
        this.f29529e = j;
        this.f29530f = j2;
        this.f29531g = j3;
        this.f29532h = j4;
        this.f29533i = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f29533i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29525a);
            jSONObject.put("corePoolSize", this.f29526b);
            jSONObject.put("maximumPoolSize", this.f29527c);
            jSONObject.put("largestPoolSize", this.f29528d);
            jSONObject.put("waitLargestTime", this.f29529e);
            jSONObject.put("waitAvgTime", (((float) this.f29530f) * 1.0f) / this.f29533i);
            jSONObject.put("taskCostLargestTime", this.f29531g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29532h) * 1.0f) / this.f29533i);
            jSONObject.put("logCount", this.f29533i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29525a;
    }

    public long c() {
        return this.f29529e;
    }

    public long d() {
        return this.f29531g;
    }

    public int e() {
        return this.f29533i;
    }

    public void b(long j) {
        this.f29530f += j;
    }

    public void c(long j) {
        this.f29531g = j;
    }

    public void d(long j) {
        this.f29532h += j;
    }

    public void b(int i2) {
        this.f29528d = i2;
    }

    public void a(long j) {
        this.f29529e = j;
    }

    public void a(int i2) {
        this.f29533i += i2;
    }
}
