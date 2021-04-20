package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29439a;

    /* renamed from: b  reason: collision with root package name */
    public int f29440b;

    /* renamed from: c  reason: collision with root package name */
    public int f29441c;

    /* renamed from: d  reason: collision with root package name */
    public int f29442d;

    /* renamed from: e  reason: collision with root package name */
    public long f29443e;

    /* renamed from: f  reason: collision with root package name */
    public long f29444f;

    /* renamed from: g  reason: collision with root package name */
    public long f29445g;

    /* renamed from: h  reason: collision with root package name */
    public long f29446h;
    public int i;

    public c(String str, int i, int i2, long j, long j2, long j3, long j4, int i3) {
        this.f29440b = 0;
        this.f29441c = 0;
        this.f29443e = 0L;
        this.f29444f = 0L;
        this.f29445g = 0L;
        this.f29446h = 0L;
        this.i = 0;
        this.f29439a = str;
        this.f29440b = i;
        this.f29441c = i2;
        this.f29443e = j;
        this.f29444f = j2;
        this.f29445g = j3;
        this.f29446h = j4;
        this.i = i3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29439a);
            jSONObject.put("corePoolSize", this.f29440b);
            jSONObject.put("maximumPoolSize", this.f29441c);
            jSONObject.put("largestPoolSize", this.f29442d);
            jSONObject.put("waitLargestTime", this.f29443e);
            jSONObject.put("waitAvgTime", (((float) this.f29444f) * 1.0f) / this.i);
            jSONObject.put("taskCostLargestTime", this.f29445g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29446h) * 1.0f) / this.i);
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29439a;
    }

    public long c() {
        return this.f29443e;
    }

    public long d() {
        return this.f29445g;
    }

    public int e() {
        return this.i;
    }

    public void b(long j) {
        this.f29444f += j;
    }

    public void c(long j) {
        this.f29445g = j;
    }

    public void d(long j) {
        this.f29446h += j;
    }

    public void b(int i) {
        this.f29442d = i;
    }

    public void a(long j) {
        this.f29443e = j;
    }

    public void a(int i) {
        this.i += i;
    }
}
