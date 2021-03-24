package com.xiaomi.push;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f40321a;

    /* renamed from: a  reason: collision with other field name */
    public long f186a;

    /* renamed from: a  reason: collision with other field name */
    public String f187a;

    /* renamed from: b  reason: collision with root package name */
    public long f40322b;

    /* renamed from: c  reason: collision with root package name */
    public long f40323c;

    public cn() {
        this(0, 0L, 0L, null);
    }

    public cn(int i, long j, long j2, Exception exc) {
        this.f40321a = i;
        this.f186a = j;
        this.f40323c = j2;
        this.f40322b = System.currentTimeMillis();
        if (exc != null) {
            this.f187a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f40321a;
    }

    public cn a(JSONObject jSONObject) {
        this.f186a = jSONObject.getLong("cost");
        this.f40323c = jSONObject.getLong("size");
        this.f40322b = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.f40321a = jSONObject.getInt("wt");
        this.f187a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m199a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f186a);
        jSONObject.put("size", this.f40323c);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f40322b);
        jSONObject.put("wt", this.f40321a);
        jSONObject.put("expt", this.f187a);
        return jSONObject;
    }
}
