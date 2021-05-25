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
    public String f46942a;

    /* renamed from: b  reason: collision with root package name */
    public String f46943b;

    /* renamed from: c  reason: collision with root package name */
    public String f46944c;

    /* renamed from: d  reason: collision with root package name */
    public String f46945d;

    /* renamed from: e  reason: collision with root package name */
    public String f46946e;

    /* renamed from: f  reason: collision with root package name */
    public String f46947f;

    /* renamed from: g  reason: collision with root package name */
    public String f46948g;

    /* renamed from: h  reason: collision with root package name */
    public String f46949h;

    /* renamed from: i  reason: collision with root package name */
    public String f46950i;

    public a() {
        this.f46942a = "swan";
        this.f46945d = "";
        this.f46946e = "";
        this.f46947f = "";
        this.f46948g = "";
        this.f46949h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f46942a = k.m(L.G());
        this.f46944c = L.H();
        this.f46943b = L.T();
        this.f46947f = L.r0().getString("aiapp_extra_need_download", "");
        this.f46948g = L.W();
        this.f46949h = L.e0();
        this.f46950i = L.V();
        this.f46945d = L.u1();
        this.f46946e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f46942a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f46944c);
            jSONObject.put("source", this.f46943b);
            jSONObject.put("needDown", this.f46947f);
            jSONObject.put("scheme", this.f46948g);
            jSONObject.put("extPage", this.f46949h);
            jSONObject.put("launchId", this.f46950i);
            jSONObject.put("appVersion", this.f46945d);
            jSONObject.put("thirdVersion", this.f46946e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f46942a = "swan";
        this.f46945d = "";
        this.f46946e = "";
        this.f46947f = "";
        this.f46948g = "";
        this.f46949h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f46942a = jSONObject.optString("from", "swan");
        this.f46944c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f46943b = jSONObject.optString("source");
        this.f46947f = jSONObject.optString("needDown");
        this.f46948g = jSONObject.optString("scheme");
        this.f46949h = jSONObject.optString("extPage");
        this.f46950i = jSONObject.optString("launchId", null);
        this.f46945d = jSONObject.optString("appVersion");
        this.f46946e = jSONObject.optString("thirdVersion");
    }
}
