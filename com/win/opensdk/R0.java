package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class R0 {

    /* renamed from: a  reason: collision with root package name */
    public int f37754a = 101;

    /* renamed from: b  reason: collision with root package name */
    public String f37755b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f37756c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f37754a = jSONObject.optInt(Constants.KEYS.RET);
        this.f37755b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = z.b(optString);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.f37756c = new JSONObject();
        } else {
            this.f37756c = new JSONObject(optString);
        }
    }
}
