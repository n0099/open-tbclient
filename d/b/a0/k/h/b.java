package d.b.a0.k.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.b.a0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f41987a;

    /* renamed from: b  reason: collision with root package name */
    public long f41988b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f41989c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f41990d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f41991e;

    public b(String str) {
        this.f41987a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f41987a)) {
            d.b.a0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f41987a);
            jSONObject.put("t", this.f41988b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f41989c);
            if (this.f41991e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f41991e);
            } else if (!TextUtils.isEmpty(this.f41990d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f41990d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f41990d);
                }
            }
        } catch (JSONException e2) {
            if (d.b.a0.n.d.f42050d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f41991e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f41990d = str;
        return this;
    }
}
