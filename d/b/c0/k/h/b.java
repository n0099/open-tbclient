package d.b.c0.k.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.b.c0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f42616a;

    /* renamed from: b  reason: collision with root package name */
    public long f42617b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f42618c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f42619d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f42620e;

    public b(String str) {
        this.f42616a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f42616a)) {
            d.b.c0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f42616a);
            jSONObject.put("t", this.f42617b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f42618c);
            if (this.f42620e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f42620e);
            } else if (!TextUtils.isEmpty(this.f42619d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f42619d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f42619d);
                }
            }
        } catch (JSONException e2) {
            if (d.b.c0.n.d.f42679d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f42620e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f42619d = str;
        return this;
    }
}
