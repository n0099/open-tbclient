package d.a.a0.k.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.a.a0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f38413a;

    /* renamed from: b  reason: collision with root package name */
    public long f38414b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f38415c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f38416d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f38417e;

    public b(String str) {
        this.f38413a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f38413a)) {
            d.a.a0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f38413a);
            jSONObject.put("t", this.f38414b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f38415c);
            if (this.f38417e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f38417e);
            } else if (!TextUtils.isEmpty(this.f38416d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f38416d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f38416d);
                }
            }
        } catch (JSONException e2) {
            if (d.a.a0.n.d.f38476d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f38417e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f38416d = str;
        return this;
    }
}
