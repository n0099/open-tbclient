package com.xiaomi.push;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cu {

    /* renamed from: a  reason: collision with root package name */
    private int f8307a;

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
        this.f8307a = i;
        this.f179a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f180a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f8307a;
    }

    public cu a(JSONObject jSONObject) {
        this.f179a = jSONObject.getLong(BdStatsConstant.StatsKey.COST);
        this.c = jSONObject.getLong(TiebaInitialize.LogFields.SIZE);
        this.b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.f8307a = jSONObject.getInt("wt");
        this.f180a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m209a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.COST, this.f179a);
        jSONObject.put(TiebaInitialize.LogFields.SIZE, this.c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.b);
        jSONObject.put("wt", this.f8307a);
        jSONObject.put("expt", this.f180a);
        return jSONObject;
    }
}
