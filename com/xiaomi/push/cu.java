package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f4614a;

    /* renamed from: a  reason: collision with other field name */
    private long f180a;

    /* renamed from: a  reason: collision with other field name */
    private String f181a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f4614a = i;
        this.f180a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f181a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f4614a;
    }

    public cu a(JSONObject jSONObject) {
        this.f180a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.f4614a = jSONObject.getInt("wt");
        this.f181a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m198a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f180a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.f4614a);
        jSONObject.put("expt", this.f181a);
        return jSONObject;
    }
}
