package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29710a;

    /* renamed from: b  reason: collision with root package name */
    public int f29711b;

    /* renamed from: c  reason: collision with root package name */
    public int f29712c;

    /* renamed from: d  reason: collision with root package name */
    public int f29713d;

    /* renamed from: e  reason: collision with root package name */
    public long f29714e;

    /* renamed from: f  reason: collision with root package name */
    public long f29715f;

    /* renamed from: g  reason: collision with root package name */
    public long f29716g;

    /* renamed from: h  reason: collision with root package name */
    public long f29717h;

    /* renamed from: i  reason: collision with root package name */
    public int f29718i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.f29711b = 0;
        this.f29712c = 0;
        this.f29714e = 0L;
        this.f29715f = 0L;
        this.f29716g = 0L;
        this.f29717h = 0L;
        this.f29718i = 0;
        this.f29710a = str;
        this.f29711b = i2;
        this.f29712c = i3;
        this.f29714e = j;
        this.f29715f = j2;
        this.f29716g = j3;
        this.f29717h = j4;
        this.f29718i = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f29718i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29710a);
            jSONObject.put("corePoolSize", this.f29711b);
            jSONObject.put("maximumPoolSize", this.f29712c);
            jSONObject.put("largestPoolSize", this.f29713d);
            jSONObject.put("waitLargestTime", this.f29714e);
            jSONObject.put("waitAvgTime", (((float) this.f29715f) * 1.0f) / this.f29718i);
            jSONObject.put("taskCostLargestTime", this.f29716g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29717h) * 1.0f) / this.f29718i);
            jSONObject.put("logCount", this.f29718i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29710a;
    }

    public long c() {
        return this.f29714e;
    }

    public long d() {
        return this.f29716g;
    }

    public int e() {
        return this.f29718i;
    }

    public void b(long j) {
        this.f29715f += j;
    }

    public void c(long j) {
        this.f29716g = j;
    }

    public void d(long j) {
        this.f29717h += j;
    }

    public void b(int i2) {
        this.f29713d = i2;
    }

    public void a(long j) {
        this.f29714e = j;
    }

    public void a(int i2) {
        this.f29718i += i2;
    }
}
