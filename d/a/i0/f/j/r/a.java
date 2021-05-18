package d.a.i0.f.j.r;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46766a;

    /* renamed from: b  reason: collision with root package name */
    public String f46767b;

    /* renamed from: c  reason: collision with root package name */
    public String f46768c;

    /* renamed from: d  reason: collision with root package name */
    public String f46769d;

    /* renamed from: e  reason: collision with root package name */
    public String f46770e;

    /* renamed from: f  reason: collision with root package name */
    public String f46771f;

    /* renamed from: g  reason: collision with root package name */
    public String f46772g;

    /* renamed from: h  reason: collision with root package name */
    public String f46773h;

    /* renamed from: i  reason: collision with root package name */
    public String f46774i;

    public a() {
        this.f46766a = "swan";
        this.f46769d = "";
        this.f46770e = "";
        this.f46771f = "";
        this.f46772g = "";
        this.f46773h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f46766a = k.m(L.G());
        this.f46768c = L.H();
        this.f46767b = L.T();
        this.f46771f = L.r0().getString("aiapp_extra_need_download", "");
        this.f46772g = L.W();
        this.f46773h = L.e0();
        this.f46774i = L.V();
        this.f46769d = L.u1();
        this.f46770e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f46766a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f46768c);
            jSONObject.put("source", this.f46767b);
            jSONObject.put("needDown", this.f46771f);
            jSONObject.put("scheme", this.f46772g);
            jSONObject.put("extPage", this.f46773h);
            jSONObject.put("launchId", this.f46774i);
            jSONObject.put("appVersion", this.f46769d);
            jSONObject.put("thirdVersion", this.f46770e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f46766a = "swan";
        this.f46769d = "";
        this.f46770e = "";
        this.f46771f = "";
        this.f46772g = "";
        this.f46773h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f46766a = jSONObject.optString("from", "swan");
        this.f46768c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f46767b = jSONObject.optString("source");
        this.f46771f = jSONObject.optString("needDown");
        this.f46772g = jSONObject.optString("scheme");
        this.f46773h = jSONObject.optString("extPage");
        this.f46774i = jSONObject.optString("launchId", null);
        this.f46769d = jSONObject.optString("appVersion");
        this.f46770e = jSONObject.optString("thirdVersion");
    }
}
