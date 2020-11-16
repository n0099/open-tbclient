package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f4844a;

    /* renamed from: a  reason: collision with other field name */
    private long f182a;

    /* renamed from: a  reason: collision with other field name */
    private String f183a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f4844a = i;
        this.f182a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f183a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f4844a;
    }

    public cu a(JSONObject jSONObject) {
        this.f182a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.f4844a = jSONObject.getInt("wt");
        this.f183a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m208a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f182a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.f4844a);
        jSONObject.put("expt", this.f183a);
        return jSONObject;
    }
}
