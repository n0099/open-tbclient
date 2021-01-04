package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f14220a;

    /* renamed from: a  reason: collision with other field name */
    private long f258a;

    /* renamed from: a  reason: collision with other field name */
    private String f259a;

    /* renamed from: b  reason: collision with root package name */
    private long f14221b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f14220a = i;
        this.f258a = j;
        this.c = j2;
        this.f14221b = System.currentTimeMillis();
        if (exc != null) {
            this.f259a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f14220a;
    }

    public cu a(JSONObject jSONObject) {
        this.f258a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.f14221b = jSONObject.getLong("ts");
        this.f14220a = jSONObject.getInt("wt");
        this.f259a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m224a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f258a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.f14221b);
        jSONObject.put("wt", this.f14220a);
        jSONObject.put("expt", this.f259a);
        return jSONObject;
    }
}
