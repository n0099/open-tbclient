package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29754a;

    /* renamed from: b  reason: collision with root package name */
    public int f29755b;

    /* renamed from: c  reason: collision with root package name */
    public int f29756c;

    /* renamed from: d  reason: collision with root package name */
    public int f29757d;

    /* renamed from: e  reason: collision with root package name */
    public long f29758e;

    /* renamed from: f  reason: collision with root package name */
    public long f29759f;

    /* renamed from: g  reason: collision with root package name */
    public long f29760g;

    /* renamed from: h  reason: collision with root package name */
    public long f29761h;
    public int i;

    public c(String str, int i, int i2, long j, long j2, long j3, long j4, int i3) {
        this.f29755b = 0;
        this.f29756c = 0;
        this.f29758e = 0L;
        this.f29759f = 0L;
        this.f29760g = 0L;
        this.f29761h = 0L;
        this.i = 0;
        this.f29754a = str;
        this.f29755b = i;
        this.f29756c = i2;
        this.f29758e = j;
        this.f29759f = j2;
        this.f29760g = j3;
        this.f29761h = j4;
        this.i = i3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29754a);
            jSONObject.put("corePoolSize", this.f29755b);
            jSONObject.put("maximumPoolSize", this.f29756c);
            jSONObject.put("largestPoolSize", this.f29757d);
            jSONObject.put("waitLargestTime", this.f29758e);
            jSONObject.put("waitAvgTime", (((float) this.f29759f) * 1.0f) / this.i);
            jSONObject.put("taskCostLargestTime", this.f29760g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29761h) * 1.0f) / this.i);
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29754a;
    }

    public long c() {
        return this.f29758e;
    }

    public long d() {
        return this.f29760g;
    }

    public int e() {
        return this.i;
    }

    public void b(long j) {
        this.f29759f += j;
    }

    public void c(long j) {
        this.f29760g = j;
    }

    public void d(long j) {
        this.f29761h += j;
    }

    public void b(int i) {
        this.f29757d = i;
    }

    public void a(long j) {
        this.f29758e = j;
    }

    public void a(int i) {
        this.i += i;
    }
}
