package com.bytedance.sdk.openadsdk.j.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f4863a;
    private int b;
    private int c;
    private int d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f4863a);
            jSONObject.put("corePoolSize", this.b);
            jSONObject.put("maximumPoolSize", this.c);
            jSONObject.put("largestPoolSize", this.d);
            jSONObject.put("waitLargestTime", this.e);
            jSONObject.put("waitAvgTime", (((float) this.f) * 1.0f) / this.i);
            jSONObject.put("taskCostLargestTime", this.g);
            jSONObject.put("taskCostAvgTime", (((float) this.h) * 1.0f) / this.i);
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public c(String str, int i, int i2, long j, long j2, long j3, long j4, int i3) {
        this.b = 0;
        this.c = 0;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0;
        this.f4863a = str;
        this.b = i;
        this.c = i2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = j4;
        this.i = i3;
    }

    public String b() {
        return this.f4863a;
    }

    public long c() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.f += j;
    }

    public long d() {
        return this.g;
    }

    public void c(long j) {
        this.g = j;
    }

    public void d(long j) {
        this.h += j;
    }

    public int e() {
        return this.i;
    }

    public void a(int i) {
        this.i += i;
    }

    public void b(int i) {
        this.d = i;
    }
}
