package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class R0 {

    /* renamed from: a  reason: collision with root package name */
    public int f40607a = 101;

    /* renamed from: b  reason: collision with root package name */
    public String f40608b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f40609c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f40607a = jSONObject.optInt(Constants.KEYS.RET);
        this.f40608b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = z.b(optString);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.f40609c = new JSONObject();
        } else {
            this.f40609c = new JSONObject(optString);
        }
    }
}
