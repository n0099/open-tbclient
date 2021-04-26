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
    public String f39168a;

    /* renamed from: b  reason: collision with root package name */
    public long f39169b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f39170c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f39171d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39172e;

    public b(String str) {
        this.f39168a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f39168a)) {
            d.a.a0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f39168a);
            jSONObject.put("t", this.f39169b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f39170c);
            if (this.f39172e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f39172e);
            } else if (!TextUtils.isEmpty(this.f39171d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f39171d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f39171d);
                }
            }
        } catch (JSONException e2) {
            if (d.a.a0.n.d.f39231d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f39172e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f39171d = str;
        return this;
    }
}
