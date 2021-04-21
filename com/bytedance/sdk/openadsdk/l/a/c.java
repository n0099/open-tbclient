package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29447a;

    /* renamed from: b  reason: collision with root package name */
    public int f29448b;

    /* renamed from: c  reason: collision with root package name */
    public int f29449c;

    /* renamed from: d  reason: collision with root package name */
    public int f29450d;

    /* renamed from: e  reason: collision with root package name */
    public long f29451e;

    /* renamed from: f  reason: collision with root package name */
    public long f29452f;

    /* renamed from: g  reason: collision with root package name */
    public long f29453g;

    /* renamed from: h  reason: collision with root package name */
    public long f29454h;
    public int i;

    public c(String str, int i, int i2, long j, long j2, long j3, long j4, int i3) {
        this.f29448b = 0;
        this.f29449c = 0;
        this.f29451e = 0L;
        this.f29452f = 0L;
        this.f29453g = 0L;
        this.f29454h = 0L;
        this.i = 0;
        this.f29447a = str;
        this.f29448b = i;
        this.f29449c = i2;
        this.f29451e = j;
        this.f29452f = j2;
        this.f29453g = j3;
        this.f29454h = j4;
        this.i = i3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29447a);
            jSONObject.put("corePoolSize", this.f29448b);
            jSONObject.put("maximumPoolSize", this.f29449c);
            jSONObject.put("largestPoolSize", this.f29450d);
            jSONObject.put("waitLargestTime", this.f29451e);
            jSONObject.put("waitAvgTime", (((float) this.f29452f) * 1.0f) / this.i);
            jSONObject.put("taskCostLargestTime", this.f29453g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29454h) * 1.0f) / this.i);
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29447a;
    }

    public long c() {
        return this.f29451e;
    }

    public long d() {
        return this.f29453g;
    }

    public int e() {
        return this.i;
    }

    public void b(long j) {
        this.f29452f += j;
    }

    public void c(long j) {
        this.f29453g = j;
    }

    public void d(long j) {
        this.f29454h += j;
    }

    public void b(int i) {
        this.f29450d = i;
    }

    public void a(long j) {
        this.f29451e = j;
    }

    public void a(int i) {
        this.i += i;
    }
}
