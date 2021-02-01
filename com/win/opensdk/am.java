package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class am {
    int java = 101;

    /* renamed from: java  reason: collision with other field name */
    public String f23java;
    JSONObject qkd;

    public final void abF(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.java = jSONObject.optInt(Constants.KEYS.RET);
        this.f23java = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = bc.abI(optString);
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(optString)) {
            this.qkd = new JSONObject(optString);
        } else {
            this.qkd = new JSONObject();
        }
    }
}
