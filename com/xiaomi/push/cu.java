package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class cu {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f184a;

    /* renamed from: a  reason: collision with other field name */
    private String f185a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f184a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f185a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cu a(JSONObject jSONObject) {
        this.f184a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.a = jSONObject.getInt("wt");
        this.f185a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m200a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f184a);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f185a);
        return jSONObject;
    }
}
