package d.a.h0.f.f.h;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46011a;

    /* renamed from: b  reason: collision with root package name */
    public String f46012b;

    /* renamed from: c  reason: collision with root package name */
    public String f46013c;

    /* renamed from: d  reason: collision with root package name */
    public String f46014d;

    /* renamed from: e  reason: collision with root package name */
    public String f46015e;

    /* renamed from: f  reason: collision with root package name */
    public String f46016f;

    /* renamed from: g  reason: collision with root package name */
    public String f46017g;

    /* renamed from: h  reason: collision with root package name */
    public String f46018h;

    /* renamed from: i  reason: collision with root package name */
    public String f46019i;
    public String j;

    public a() {
        this.f46011a = "swan";
        this.f46014d = "";
        this.f46015e = "";
        this.f46016f = "";
        this.f46017g = "";
        this.f46018h = "";
        this.f46019i = "";
        if (e.O() == null) {
            return;
        }
        b.a J = e.O().J();
        this.f46011a = h.n(J.F());
        this.f46013c = J.G();
        this.f46012b = J.S();
        this.f46016f = J.n0().getString("aiapp_extra_need_download", "");
        this.f46017g = J.n0().getString("aiapp_extra_preset_pkg", "");
        this.f46018h = J.V();
        this.f46019i = J.b0();
        this.j = J.U();
        this.f46014d = J.n1();
        this.f46015e = J.o1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f46011a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f46013c);
            jSONObject.put("source", this.f46012b);
            jSONObject.put("needDown", this.f46016f);
            jSONObject.put("isPreset", this.f46017g);
            jSONObject.put("scheme", this.f46018h);
            jSONObject.put("extPage", this.f46019i);
            jSONObject.put("launchId", this.j);
            jSONObject.put("appVersion", this.f46014d);
            jSONObject.put("thirdVersion", this.f46015e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f46011a = "swan";
        this.f46014d = "";
        this.f46015e = "";
        this.f46016f = "";
        this.f46017g = "";
        this.f46018h = "";
        this.f46019i = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f46011a = jSONObject.optString("from", "swan");
        this.f46013c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f46012b = jSONObject.optString("source");
        this.f46016f = jSONObject.optString("needDown");
        this.f46017g = jSONObject.optString("isPreset");
        this.f46018h = jSONObject.optString("scheme");
        this.f46019i = jSONObject.optString("extPage");
        this.j = jSONObject.optString("launchId", null);
        this.f46014d = jSONObject.optString("appVersion");
        this.f46015e = jSONObject.optString("thirdVersion");
    }
}
