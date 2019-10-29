package com.xiaomi.network;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AccessHistory {
    private int a;
    private long b;
    private long c;
    private String d;
    private long e;

    public AccessHistory() {
        this(0, 0L, 0L, null);
    }

    public AccessHistory(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.b = j;
        this.e = j2;
        this.c = System.currentTimeMillis();
        if (exc != null) {
            this.d = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public AccessHistory a(JSONObject jSONObject) {
        this.b = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.e = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.c = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.a = jSONObject.getInt("wt");
        this.d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.b);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.e);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.c);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.d);
        return jSONObject;
    }
}
