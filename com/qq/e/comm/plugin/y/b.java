package com.qq.e.comm.plugin.y;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f12698a = new JSONObject();

    public JSONObject a() {
        return this.f12698a;
    }

    void a(int i) {
        a("seq", Integer.valueOf(i));
    }

    void a(long j) {
        a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(j));
    }

    public void a(c cVar) {
        if (cVar != null) {
            a(Constants.KEYS.BIZ, cVar.a());
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            a("ext", dVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            this.f12698a.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.f12698a.toString();
    }
}
