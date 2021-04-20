package d.b.z.k.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.b.z.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f65685a;

    /* renamed from: b  reason: collision with root package name */
    public long f65686b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f65687c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f65688d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f65689e;

    public b(String str) {
        this.f65685a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f65685a)) {
            d.b.z.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f65685a);
            jSONObject.put("t", this.f65686b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f65687c);
            if (this.f65689e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f65689e);
            } else if (!TextUtils.isEmpty(this.f65688d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f65688d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f65688d);
                }
            }
        } catch (JSONException e2) {
            if (d.b.z.n.d.f65748d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f65689e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f65688d = str;
        return this;
    }
}
