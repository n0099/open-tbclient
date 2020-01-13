package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f196a;

    /* renamed from: a  reason: collision with other field name */
    private String f197a;
    private long b;
    private long c;

    public cp() {
        this(0, 0L, 0L, null);
    }

    public cp(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f196a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f197a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cp a(JSONObject jSONObject) {
        this.f196a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.a = jSONObject.getInt("wt");
        this.f197a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m191a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f196a);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f197a);
        return jSONObject;
    }
}
