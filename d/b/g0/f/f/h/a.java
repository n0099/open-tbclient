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
    public String f47830a;

    /* renamed from: b  reason: collision with root package name */
    public String f47831b;

    /* renamed from: c  reason: collision with root package name */
    public String f47832c;

    /* renamed from: d  reason: collision with root package name */
    public String f47833d;

    /* renamed from: e  reason: collision with root package name */
    public String f47834e;

    /* renamed from: f  reason: collision with root package name */
    public String f47835f;

    /* renamed from: g  reason: collision with root package name */
    public String f47836g;

    /* renamed from: h  reason: collision with root package name */
    public String f47837h;
    public String i;
    public String j;

    public a() {
        this.f47830a = "swan";
        this.f47833d = "";
        this.f47834e = "";
        this.f47835f = "";
        this.f47836g = "";
        this.f47837h = "";
        this.i = "";
        if (e.O() == null) {
            return;
        }
        b.a J = e.O().J();
        this.f47830a = h.n(J.F());
        this.f47832c = J.G();
        this.f47831b = J.S();
        this.f47835f = J.n0().getString("aiapp_extra_need_download", "");
        this.f47836g = J.n0().getString("aiapp_extra_preset_pkg", "");
        this.f47837h = J.V();
        this.i = J.b0();
        this.j = J.U();
        this.f47833d = J.n1();
        this.f47834e = J.o1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f47830a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47832c);
            jSONObject.put("source", this.f47831b);
            jSONObject.put("needDown", this.f47835f);
            jSONObject.put("isPreset", this.f47836g);
            jSONObject.put("scheme", this.f47837h);
            jSONObject.put("extPage", this.i);
            jSONObject.put("launchId", this.j);
            jSONObject.put("appVersion", this.f47833d);
            jSONObject.put("thirdVersion", this.f47834e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f47830a = "swan";
        this.f47833d = "";
        this.f47834e = "";
        this.f47835f = "";
        this.f47836g = "";
        this.f47837h = "";
        this.i = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f47830a = jSONObject.optString("from", "swan");
        this.f47832c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f47831b = jSONObject.optString("source");
        this.f47835f = jSONObject.optString("needDown");
        this.f47836g = jSONObject.optString("isPreset");
        this.f47837h = jSONObject.optString("scheme");
        this.i = jSONObject.optString("extPage");
        this.j = jSONObject.optString("launchId", null);
        this.f47833d = jSONObject.optString("appVersion");
        this.f47834e = jSONObject.optString("thirdVersion");
    }
}
