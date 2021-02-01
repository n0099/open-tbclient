package com.qq.e.comm.managers.setting;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class c extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str, String str2) {
        JSONObject optJSONObject = this.f11558a.optJSONObject(str2);
        if (optJSONObject != null) {
            return optJSONObject.opt(str);
        }
        return null;
    }
}
