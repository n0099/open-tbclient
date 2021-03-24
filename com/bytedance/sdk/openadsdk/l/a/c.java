package com.bytedance.sdk.openadsdk.l.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f29753a;

    /* renamed from: b  reason: collision with root package name */
    public int f29754b;

    /* renamed from: c  reason: collision with root package name */
    public int f29755c;

    /* renamed from: d  reason: collision with root package name */
    public int f29756d;

    /* renamed from: e  reason: collision with root package name */
    public long f29757e;

    /* renamed from: f  reason: collision with root package name */
    public long f29758f;

    /* renamed from: g  reason: collision with root package name */
    public long f29759g;

    /* renamed from: h  reason: collision with root package name */
    public long f29760h;
    public int i;

    public c(String str, int i, int i2, long j, long j2, long j3, long j4, int i3) {
        this.f29754b = 0;
        this.f29755c = 0;
        this.f29757e = 0L;
        this.f29758f = 0L;
        this.f29759g = 0L;
        this.f29760h = 0L;
        this.i = 0;
        this.f29753a = str;
        this.f29754b = i;
        this.f29755c = i2;
        this.f29757e = j;
        this.f29758f = j2;
        this.f29759g = j3;
        this.f29760h = j4;
        this.i = i3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.f29753a);
            jSONObject.put("corePoolSize", this.f29754b);
            jSONObject.put("maximumPoolSize", this.f29755c);
            jSONObject.put("largestPoolSize", this.f29756d);
            jSONObject.put("waitLargestTime", this.f29757e);
            jSONObject.put("waitAvgTime", (((float) this.f29758f) * 1.0f) / this.i);
            jSONObject.put("taskCostLargestTime", this.f29759g);
            jSONObject.put("taskCostAvgTime", (((float) this.f29760h) * 1.0f) / this.i);
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f29753a;
    }

    public long c() {
        return this.f29757e;
    }

    public long d() {
        return this.f29759g;
    }

    public int e() {
        return this.i;
    }

    public void b(long j) {
        this.f29758f += j;
    }

    public void c(long j) {
        this.f29759g = j;
    }

    public void d(long j) {
        this.f29760h += j;
    }

    public void b(int i) {
        this.f29756d = i;
    }

    public void a(long j) {
        this.f29757e = j;
    }

    public void a(int i) {
        this.i += i;
    }
}
