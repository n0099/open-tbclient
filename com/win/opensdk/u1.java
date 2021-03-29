package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u1 {

    /* renamed from: a  reason: collision with root package name */
    public int f40046a = 101;

    /* renamed from: b  reason: collision with root package name */
    public String f40047b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f40048c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f40046a = jSONObject.optInt(Constants.KEYS.RET);
        this.f40047b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = G.b(optString);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.f40048c = new JSONObject();
        } else {
            this.f40048c = new JSONObject(optString);
        }
    }
}
