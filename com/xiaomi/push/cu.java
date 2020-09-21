package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class cu {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f179a;

    /* renamed from: a  reason: collision with other field name */
    private String f180a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f179a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f180a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cu a(JSONObject jSONObject) {
        this.f179a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f180a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m205a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f179a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f180a);
        return jSONObject;
    }
}
