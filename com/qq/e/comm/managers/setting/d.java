package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str) {
        return this.f11558a.opt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, Object obj) {
        try {
            this.f11558a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f11558a.toString() + "]";
    }
}
