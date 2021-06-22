package com.qq.e.comm.managers.setting;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
        return this.f39240a.opt(str);
    }

    public final void a(String str, Object obj) {
        try {
            this.f39240a.putOpt(str, obj);
        } catch (JSONException e2) {
            GDTLogger.e("Exception while update setting", e2);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f39240a.toString() + PreferencesUtil.RIGHT_MOUNT;
    }
}
