package com.qq.e.comm.managers.setting;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class c extends e {
    public c() {
    }

    public c(String str) {
        super(str);
    }

    public final Object a(String str, String str2) {
        JSONObject optJSONObject = this.f38325a.optJSONObject(str2);
        if (optJSONObject != null) {
            return optJSONObject.opt(str);
        }
        return null;
    }
}
