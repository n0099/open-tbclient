package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f4842a;

    /* renamed from: a  reason: collision with other field name */
    private long f177a;

    /* renamed from: a  reason: collision with other field name */
    private String f178a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f4842a = i;
        this.f177a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f178a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f4842a;
    }

    public cu a(JSONObject jSONObject) {
        this.f177a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.f4842a = jSONObject.getInt("wt");
        this.f178a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m205a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f177a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.f4842a);
        jSONObject.put("expt", this.f178a);
        return jSONObject;
    }
}
