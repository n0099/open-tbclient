package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f30351a;

    /* renamed from: b  reason: collision with root package name */
    public int f30352b;

    /* renamed from: c  reason: collision with root package name */
    public int f30353c;

    /* renamed from: d  reason: collision with root package name */
    public int f30354d;

    /* renamed from: e  reason: collision with root package name */
    public long f30355e;

    /* renamed from: f  reason: collision with root package name */
    public long f30356f;

    /* renamed from: g  reason: collision with root package name */
    public long f30357g;

    /* renamed from: h  reason: collision with root package name */
    public long f30358h;

    /* renamed from: i  reason: collision with root package name */
    public int f30359i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.f30352b = 0;
        this.f30353c = 0;
        this.f30355e = 0L;
        this.f30356f = 0L;
        this.f30357g = 0L;
        this.f30358h = 0L;
        this.f30359i = 0;
        this.f30351a = str;
        this.f30352b = i2;
        this.f30353c = i3;
        this.f30355e = j;
        this.f30356f = j2;
        this.f30357g = j3;
        this.f30358h = j4;
        this.f30359i = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f30359i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f30351a);
            jSONObject.put("corePoolSize", this.f30352b);
            jSONObject.put("maximumPoolSize", this.f30353c);
            jSONObject.put("largestPoolSize", this.f30354d);
            jSONObject.put("waitLargestTime", this.f30355e);
            jSONObject.put("waitAvgTime", (((float) this.f30356f) * 1.0f) / this.f30359i);
            jSONObject.put("taskCostLargestTime", this.f30357g);
            jSONObject.put("taskCostAvgTime", (((float) this.f30358h) * 1.0f) / this.f30359i);
            jSONObject.put("logCount", this.f30359i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f30351a;
    }

    public long c() {
        return this.f30355e;
    }

    public long d() {
        return this.f30357g;
    }

    public int e() {
        return this.f30359i;
    }

    public void b(long j) {
        this.f30356f += j;
    }

    public void c(long j) {
        this.f30357g = j;
    }

    public void d(long j) {
        this.f30358h += j;
    }

    public void b(int i2) {
        this.f30354d = i2;
    }

    public void a(long j) {
        this.f30355e = j;
    }

    public void a(int i2) {
        this.f30359i += i2;
    }
}
