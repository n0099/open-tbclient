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
    public String f47829a;

    /* renamed from: b  reason: collision with root package name */
    public String f47830b;

    /* renamed from: c  reason: collision with root package name */
    public String f47831c;

    /* renamed from: d  reason: collision with root package name */
    public String f47832d;

    /* renamed from: e  reason: collision with root package name */
    public String f47833e;

    /* renamed from: f  reason: collision with root package name */
    public String f47834f;

    /* renamed from: g  reason: collision with root package name */
    public String f47835g;

    /* renamed from: h  reason: collision with root package name */
    public String f47836h;
    public String i;
    public String j;

    public a() {
        this.f47829a = "swan";
        this.f47832d = "";
        this.f47833e = "";
        this.f47834f = "";
        this.f47835g = "";
        this.f47836h = "";
        this.i = "";
        if (e.O() == null) {
            return;
        }
        b.a J = e.O().J();
        this.f47829a = h.n(J.F());
        this.f47831c = J.G();
        this.f47830b = J.S();
        this.f47834f = J.n0().getString("aiapp_extra_need_download", "");
        this.f47835g = J.n0().getString("aiapp_extra_preset_pkg", "");
        this.f47836h = J.V();
        this.i = J.b0();
        this.j = J.U();
        this.f47832d = J.n1();
        this.f47833e = J.o1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f47829a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47831c);
            jSONObject.put("source", this.f47830b);
            jSONObject.put("needDown", this.f47834f);
            jSONObject.put("isPreset", this.f47835g);
            jSONObject.put("scheme", this.f47836h);
            jSONObject.put("extPage", this.i);
            jSONObject.put("launchId", this.j);
            jSONObject.put("appVersion", this.f47832d);
            jSONObject.put("thirdVersion", this.f47833e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f47829a = "swan";
        this.f47832d = "";
        this.f47833e = "";
        this.f47834f = "";
        this.f47835g = "";
        this.f47836h = "";
        this.i = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f47829a = jSONObject.optString("from", "swan");
        this.f47831c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f47830b = jSONObject.optString("source");
        this.f47834f = jSONObject.optString("needDown");
        this.f47835g = jSONObject.optString("isPreset");
        this.f47836h = jSONObject.optString("scheme");
        this.i = jSONObject.optString("extPage");
        this.j = jSONObject.optString("launchId", null);
        this.f47832d = jSONObject.optString("appVersion");
        this.f47833e = jSONObject.optString("thirdVersion");
    }
}
