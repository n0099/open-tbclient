package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f193a;

    /* renamed from: a  reason: collision with other field name */
    private String f194a;
    private long b;
    private long c;

    public cp() {
        this(0, 0L, 0L, null);
    }

    public cp(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f193a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f194a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cp a(JSONObject jSONObject) {
        this.f193a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.a = jSONObject.getInt("wt");
        this.f194a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m179a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f193a);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f194a);
        return jSONObject;
    }
}
