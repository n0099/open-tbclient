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
    public String f43114a;

    /* renamed from: b  reason: collision with root package name */
    public long f43115b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f43116c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f43117d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f43118e;

    public b(String str) {
        this.f43114a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f43114a)) {
            d.a.c0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f43114a);
            jSONObject.put("t", this.f43115b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f43116c);
            if (this.f43118e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f43118e);
            } else if (!TextUtils.isEmpty(this.f43117d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f43117d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f43117d);
                }
            }
        } catch (JSONException e2) {
            if (d.a.c0.n.d.f43177d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f43118e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f43117d = str;
        return this;
    }
}
