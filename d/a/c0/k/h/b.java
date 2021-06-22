package d.a.c0.k.h;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.a.c0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43217a;

    /* renamed from: b  reason: collision with root package name */
    public long f43218b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f43219c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f43220d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f43221e;

    public b(String str) {
        this.f43217a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f43217a)) {
            d.a.c0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f43217a);
            jSONObject.put("t", this.f43218b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f43219c);
            if (this.f43221e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f43221e);
            } else if (!TextUtils.isEmpty(this.f43220d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f43220d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f43220d);
                }
            }
        } catch (JSONException e2) {
            if (d.a.c0.n.d.f43280d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f43221e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f43220d = str;
        return this;
    }
}
