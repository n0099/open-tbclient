package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class am {
    int java = 101;

    /* renamed from: java  reason: collision with other field name */
    public String f24java;
    JSONObject qez;

    public final void abL(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.java = jSONObject.optInt(Constants.KEYS.RET);
        this.f24java = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = bc.abO(optString);
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(optString)) {
            this.qez = new JSONObject(optString);
        } else {
            this.qez = new JSONObject();
        }
    }
}
