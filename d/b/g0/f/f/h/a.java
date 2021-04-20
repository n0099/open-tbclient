package d.b.g0.f.f.h;

import com.baidu.sapi2.activity.BaseActivity;
import d.b.g0.a.r1.e;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48222a;

    /* renamed from: b  reason: collision with root package name */
    public String f48223b;

    /* renamed from: c  reason: collision with root package name */
    public String f48224c;

    /* renamed from: d  reason: collision with root package name */
    public String f48225d;

    /* renamed from: e  reason: collision with root package name */
    public String f48226e;

    /* renamed from: f  reason: collision with root package name */
    public String f48227f;

    /* renamed from: g  reason: collision with root package name */
    public String f48228g;

    /* renamed from: h  reason: collision with root package name */
    public String f48229h;
    public String i;
    public String j;

    public a() {
        this.f48222a = "swan";
        this.f48225d = "";
        this.f48226e = "";
        this.f48227f = "";
        this.f48228g = "";
        this.f48229h = "";
        this.i = "";
        if (e.O() == null) {
            return;
        }
        b.a J = e.O().J();
        this.f48222a = h.n(J.F());
        this.f48224c = J.G();
        this.f48223b = J.S();
        this.f48227f = J.n0().getString("aiapp_extra_need_download", "");
        this.f48228g = J.n0().getString("aiapp_extra_preset_pkg", "");
        this.f48229h = J.V();
        this.i = J.b0();
        this.j = J.U();
        this.f48225d = J.n1();
        this.f48226e = J.o1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f48222a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f48224c);
            jSONObject.put("source", this.f48223b);
            jSONObject.put("needDown", this.f48227f);
            jSONObject.put("isPreset", this.f48228g);
            jSONObject.put("scheme", this.f48229h);
            jSONObject.put("extPage", this.i);
            jSONObject.put("launchId", this.j);
            jSONObject.put("appVersion", this.f48225d);
            jSONObject.put("thirdVersion", this.f48226e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f48222a = "swan";
        this.f48225d = "";
        this.f48226e = "";
        this.f48227f = "";
        this.f48228g = "";
        this.f48229h = "";
        this.i = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f48222a = jSONObject.optString("from", "swan");
        this.f48224c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f48223b = jSONObject.optString("source");
        this.f48227f = jSONObject.optString("needDown");
        this.f48228g = jSONObject.optString("isPreset");
        this.f48229h = jSONObject.optString("scheme");
        this.i = jSONObject.optString("extPage");
        this.j = jSONObject.optString("launchId", null);
        this.f48225d = jSONObject.optString("appVersion");
        this.f48226e = jSONObject.optString("thirdVersion");
    }
}
