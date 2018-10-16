package com.xiaomi.network;

import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
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
        this.b = jSONObject.getLong("cost");
        this.e = jSONObject.getLong(ChooseVideoAction.CB_KEY_SIZE);
        this.c = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.a = jSONObject.getInt("wt");
        this.d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.b);
        jSONObject.put(ChooseVideoAction.CB_KEY_SIZE, this.e);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.c);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.d);
        return jSONObject;
    }
}
