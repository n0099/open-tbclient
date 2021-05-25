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
    public String f39433a;

    /* renamed from: b  reason: collision with root package name */
    public long f39434b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public String f39435c = f.d();

    /* renamed from: d  reason: collision with root package name */
    public String f39436d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39437e;

    public b(String str) {
        this.f39433a = str;
    }

    public JSONObject a() {
        if (TextUtils.isEmpty(this.f39433a)) {
            d.a.c0.n.d.b("statistics action can not null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f39433a);
            jSONObject.put("t", this.f39434b);
            jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f39435c);
            if (this.f39437e != null) {
                jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f39437e);
            } else if (!TextUtils.isEmpty(this.f39436d)) {
                try {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f39436d));
                } catch (JSONException unused) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f39436d);
                }
            }
        } catch (JSONException e2) {
            if (d.a.c0.n.d.f39496d) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b b(JSONObject jSONObject) {
        this.f39437e = jSONObject;
        return this;
    }

    public b c(String str) {
        this.f39436d = str;
        return this;
    }
}
