package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29596a;

    /* renamed from: b  reason: collision with root package name */
    public int f29597b;

    /* renamed from: c  reason: collision with root package name */
    public int f29598c;

    /* renamed from: d  reason: collision with root package name */
    public int f29599d;

    /* renamed from: e  reason: collision with root package name */
    public long f29600e;

    /* renamed from: f  reason: collision with root package name */
    public long f29601f;

    /* renamed from: g  reason: collision with root package name */
    public long f29602g;

    /* renamed from: h  reason: collision with root package name */
    public long f29603h;

    /* renamed from: i  reason: collision with root package name */
    public int f29604i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.f29597b = 0;
        this.f29598c = 0;
        this.f29600e = 0L;
        this.f29601f = 0L;
        this.f29602g = 0L;
        this.f29603h = 0L;
        this.f29604i = 0;
        this.f29596a = str;
        this.f29597b = i2;
        this.f29598c = i3;
        this.f29600e = j;
        this.f29601f = j2;
        this.f29602g = j3;
        this.f29603h = j4;
        this.f29604i = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f29604i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29596a);
            jSONObject.put("corePoolSize", this.f29597b);
            jSONObject.put("maximumPoolSize", this.f29598c);
            jSONObject.put("largestPoolSize", this.f29599d);
            jSONObject.put("waitLargestTime", this.f29600e);
            jSONObject.put("waitAvgTime", (((float) this.f29601f) * 1.0f) / this.f29604i);
            jSONObject.put("taskCostLargestTime", this.f29602g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29603h) * 1.0f) / this.f29604i);
            jSONObject.put("logCount", this.f29604i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29596a;
    }

    public long c() {
        return this.f29600e;
    }

    public long d() {
        return this.f29602g;
    }

    public int e() {
        return this.f29604i;
    }

    public void b(long j) {
        this.f29601f += j;
    }

    public void c(long j) {
        this.f29602g = j;
    }

    public void d(long j) {
        this.f29603h += j;
    }

    public void b(int i2) {
        this.f29599d = i2;
    }

    public void a(long j) {
        this.f29600e = j;
    }

    public void a(int i2) {
        this.f29604i += i2;
    }
}
