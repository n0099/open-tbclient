package com.win.opensdk;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class R0 {

    /* renamed from: a  reason: collision with root package name */
    public int f36928a = 101;

    /* renamed from: b  reason: collision with root package name */
    public String f36929b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f36930c;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f36928a = jSONObject.optInt(Constants.KEYS.RET);
        this.f36929b = jSONObject.optString("msg");
        String optString = jSONObject.optString("data");
        try {
            optString = z.b(optString);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(optString)) {
            this.f36930c = new JSONObject();
        } else {
            this.f36930c = new JSONObject(optString);
        }
    }
}
