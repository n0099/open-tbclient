package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class ep {

    /* renamed from: a  reason: collision with root package name */
    public int f8164a = 101;
    public String b;
    public JSONObject c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f8164a = jSONObject.optInt(Constants.KEYS.RET);
        this.b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = v.b(optString);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.c = new JSONObject();
        } else {
            this.c = new JSONObject(optString);
        }
    }
}
