package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class d extends e {
    public d() {
    }

    public d(String str) {
        super(str);
    }

    public final Object a(String str) {
        return this.f35534a.opt(str);
    }

    public final void a(String str, Object obj) {
        try {
            this.f35534a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f35534a.toString() + "]";
    }
}
