package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class R0 {

    /* renamed from: a  reason: collision with root package name */
    public int f40710a = 101;

    /* renamed from: b  reason: collision with root package name */
    public String f40711b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f40712c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f40710a = jSONObject.optInt(Constants.KEYS.RET);
        this.f40711b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = z.b(optString);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.f40712c = new JSONObject();
        } else {
            this.f40712c = new JSONObject(optString);
        }
    }
}
