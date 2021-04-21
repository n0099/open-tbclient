package d.b.h0.f.f.h;

import com.baidu.sapi2.activity.BaseActivity;
import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48551a;

    /* renamed from: b  reason: collision with root package name */
    public String f48552b;

    /* renamed from: c  reason: collision with root package name */
    public String f48553c;

    /* renamed from: d  reason: collision with root package name */
    public String f48554d;

    /* renamed from: e  reason: collision with root package name */
    public String f48555e;

    /* renamed from: f  reason: collision with root package name */
    public String f48556f;

    /* renamed from: g  reason: collision with root package name */
    public String f48557g;

    /* renamed from: h  reason: collision with root package name */
    public String f48558h;
    public String i;
    public String j;

    public a() {
        this.f48551a = "swan";
        this.f48554d = "";
        this.f48555e = "";
        this.f48556f = "";
        this.f48557g = "";
        this.f48558h = "";
        this.i = "";
        if (e.O() == null) {
            return;
        }
        b.a J = e.O().J();
        this.f48551a = h.n(J.F());
        this.f48553c = J.G();
        this.f48552b = J.S();
        this.f48556f = J.n0().getString("aiapp_extra_need_download", "");
        this.f48557g = J.n0().getString("aiapp_extra_preset_pkg", "");
        this.f48558h = J.V();
        this.i = J.b0();
        this.j = J.U();
        this.f48554d = J.n1();
        this.f48555e = J.o1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f48551a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f48553c);
            jSONObject.put("source", this.f48552b);
            jSONObject.put("needDown", this.f48556f);
            jSONObject.put("isPreset", this.f48557g);
            jSONObject.put("scheme", this.f48558h);
            jSONObject.put("extPage", this.i);
            jSONObject.put("launchId", this.j);
            jSONObject.put("appVersion", this.f48554d);
            jSONObject.put("thirdVersion", this.f48555e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f48551a = "swan";
        this.f48554d = "";
        this.f48555e = "";
        this.f48556f = "";
        this.f48557g = "";
        this.f48558h = "";
        this.i = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f48551a = jSONObject.optString("from", "swan");
        this.f48553c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f48552b = jSONObject.optString("source");
        this.f48556f = jSONObject.optString("needDown");
        this.f48557g = jSONObject.optString("isPreset");
        this.f48558h = jSONObject.optString("scheme");
        this.i = jSONObject.optString("extPage");
        this.j = jSONObject.optString("launchId", null);
        this.f48554d = jSONObject.optString("appVersion");
        this.f48555e = jSONObject.optString("thirdVersion");
    }
}
