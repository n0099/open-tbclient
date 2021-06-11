package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29628a;

    /* renamed from: b  reason: collision with root package name */
    public int f29629b;

    /* renamed from: c  reason: collision with root package name */
    public int f29630c;

    /* renamed from: d  reason: collision with root package name */
    public int f29631d;

    /* renamed from: e  reason: collision with root package name */
    public long f29632e;

    /* renamed from: f  reason: collision with root package name */
    public long f29633f;

    /* renamed from: g  reason: collision with root package name */
    public long f29634g;

    /* renamed from: h  reason: collision with root package name */
    public long f29635h;

    /* renamed from: i  reason: collision with root package name */
    public int f29636i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.f29629b = 0;
        this.f29630c = 0;
        this.f29632e = 0L;
        this.f29633f = 0L;
        this.f29634g = 0L;
        this.f29635h = 0L;
        this.f29636i = 0;
        this.f29628a = str;
        this.f29629b = i2;
        this.f29630c = i3;
        this.f29632e = j;
        this.f29633f = j2;
        this.f29634g = j3;
        this.f29635h = j4;
        this.f29636i = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f29636i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29628a);
            jSONObject.put("corePoolSize", this.f29629b);
            jSONObject.put("maximumPoolSize", this.f29630c);
            jSONObject.put("largestPoolSize", this.f29631d);
            jSONObject.put("waitLargestTime", this.f29632e);
            jSONObject.put("waitAvgTime", (((float) this.f29633f) * 1.0f) / this.f29636i);
            jSONObject.put("taskCostLargestTime", this.f29634g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29635h) * 1.0f) / this.f29636i);
            jSONObject.put("logCount", this.f29636i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29628a;
    }

    public long c() {
        return this.f29632e;
    }

    public long d() {
        return this.f29634g;
    }

    public int e() {
        return this.f29636i;
    }

    public void b(long j) {
        this.f29633f += j;
    }

    public void c(long j) {
        this.f29634g = j;
    }

    public void d(long j) {
        this.f29635h += j;
    }

    public void b(int i2) {
        this.f29631d = i2;
    }

    public void a(long j) {
        this.f29632e = j;
    }

    public void a(int i2) {
        this.f29636i += i2;
    }
}
