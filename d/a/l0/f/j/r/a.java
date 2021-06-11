package d.a.l0.f.j.r;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.l0.a.a2.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50616a;

    /* renamed from: b  reason: collision with root package name */
    public String f50617b;

    /* renamed from: c  reason: collision with root package name */
    public String f50618c;

    /* renamed from: d  reason: collision with root package name */
    public String f50619d;

    /* renamed from: e  reason: collision with root package name */
    public String f50620e;

    /* renamed from: f  reason: collision with root package name */
    public String f50621f;

    /* renamed from: g  reason: collision with root package name */
    public String f50622g;

    /* renamed from: h  reason: collision with root package name */
    public String f50623h;

    /* renamed from: i  reason: collision with root package name */
    public String f50624i;

    public a() {
        this.f50616a = "swan";
        this.f50619d = "";
        this.f50620e = "";
        this.f50621f = "";
        this.f50622g = "";
        this.f50623h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50616a = k.m(L.G());
        this.f50618c = L.H();
        this.f50617b = L.T();
        this.f50621f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50622g = L.W();
        this.f50623h = L.e0();
        this.f50624i = L.V();
        this.f50619d = L.u1();
        this.f50620e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f50616a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50618c);
            jSONObject.put("source", this.f50617b);
            jSONObject.put("needDown", this.f50621f);
            jSONObject.put("scheme", this.f50622g);
            jSONObject.put("extPage", this.f50623h);
            jSONObject.put("launchId", this.f50624i);
            jSONObject.put("appVersion", this.f50619d);
            jSONObject.put("thirdVersion", this.f50620e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f50616a = "swan";
        this.f50619d = "";
        this.f50620e = "";
        this.f50621f = "";
        this.f50622g = "";
        this.f50623h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50616a = jSONObject.optString("from", "swan");
        this.f50618c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50617b = jSONObject.optString("source");
        this.f50621f = jSONObject.optString("needDown");
        this.f50622g = jSONObject.optString("scheme");
        this.f50623h = jSONObject.optString("extPage");
        this.f50624i = jSONObject.optString("launchId", null);
        this.f50619d = jSONObject.optString("appVersion");
        this.f50620e = jSONObject.optString("thirdVersion");
    }
}
