package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f13923a;

    /* renamed from: a  reason: collision with other field name */
    private long f258a;

    /* renamed from: a  reason: collision with other field name */
    private String f259a;

    /* renamed from: b  reason: collision with root package name */
    private long f13924b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int i, long j, long j2, Exception exc) {
        this.f13923a = i;
        this.f258a = j;
        this.c = j2;
        this.f13924b = System.currentTimeMillis();
        if (exc != null) {
            this.f259a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f13923a;
    }

    public cu a(JSONObject jSONObject) {
        this.f258a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.f13924b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.f13923a = jSONObject.getInt("wt");
        this.f259a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m230a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f258a);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f13924b);
        jSONObject.put("wt", this.f13923a);
        jSONObject.put("expt", this.f259a);
        return jSONObject;
    }
}
