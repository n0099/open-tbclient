package d.a.l0.g.c.i;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47061a;

    /* renamed from: b  reason: collision with root package name */
    public String f47062b;

    /* renamed from: c  reason: collision with root package name */
    public String f47063c;

    /* renamed from: d  reason: collision with root package name */
    public String f47064d;

    /* renamed from: e  reason: collision with root package name */
    public String f47065e;

    /* renamed from: f  reason: collision with root package name */
    public String f47066f;

    /* renamed from: g  reason: collision with root package name */
    public String f47067g;

    /* renamed from: h  reason: collision with root package name */
    public String f47068h;

    /* renamed from: i  reason: collision with root package name */
    public String f47069i;

    public a() {
        this.f47061a = "swan";
        this.f47064d = "";
        this.f47065e = "";
        this.f47066f = "";
        this.f47067g = "";
        this.f47068h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f47061a = k.m(L.G());
        this.f47063c = L.H();
        this.f47062b = L.T();
        this.f47066f = L.r0().getString("aiapp_extra_need_download", "");
        this.f47067g = L.W();
        this.f47068h = L.e0();
        this.f47069i = L.V();
        this.f47064d = L.u1();
        this.f47065e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f47061a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47063c);
            jSONObject.put("source", this.f47062b);
            jSONObject.put("needDown", this.f47066f);
            jSONObject.put("scheme", this.f47067g);
            jSONObject.put("extPage", this.f47068h);
            jSONObject.put("launchId", this.f47069i);
            jSONObject.put("appVersion", this.f47064d);
            jSONObject.put("thirdVersion", this.f47065e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f47061a = "swan";
        this.f47064d = "";
        this.f47065e = "";
        this.f47066f = "";
        this.f47067g = "";
        this.f47068h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f47061a = jSONObject.optString("from", "swan");
        this.f47063c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f47062b = jSONObject.optString("source");
        this.f47066f = jSONObject.optString("needDown");
        this.f47067g = jSONObject.optString("scheme");
        this.f47068h = jSONObject.optString("extPage");
        this.f47069i = jSONObject.optString("launchId", null);
        this.f47064d = jSONObject.optString("appVersion");
        this.f47065e = jSONObject.optString("thirdVersion");
    }
}
