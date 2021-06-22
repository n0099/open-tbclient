package d.a.m0.f.j.r;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50724a;

    /* renamed from: b  reason: collision with root package name */
    public String f50725b;

    /* renamed from: c  reason: collision with root package name */
    public String f50726c;

    /* renamed from: d  reason: collision with root package name */
    public String f50727d;

    /* renamed from: e  reason: collision with root package name */
    public String f50728e;

    /* renamed from: f  reason: collision with root package name */
    public String f50729f;

    /* renamed from: g  reason: collision with root package name */
    public String f50730g;

    /* renamed from: h  reason: collision with root package name */
    public String f50731h;

    /* renamed from: i  reason: collision with root package name */
    public String f50732i;

    public a() {
        this.f50724a = "swan";
        this.f50727d = "";
        this.f50728e = "";
        this.f50729f = "";
        this.f50730g = "";
        this.f50731h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50724a = k.m(L.G());
        this.f50726c = L.H();
        this.f50725b = L.T();
        this.f50729f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50730g = L.W();
        this.f50731h = L.e0();
        this.f50732i = L.V();
        this.f50727d = L.u1();
        this.f50728e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f50724a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50726c);
            jSONObject.put("source", this.f50725b);
            jSONObject.put("needDown", this.f50729f);
            jSONObject.put("scheme", this.f50730g);
            jSONObject.put("extPage", this.f50731h);
            jSONObject.put("launchId", this.f50732i);
            jSONObject.put("appVersion", this.f50727d);
            jSONObject.put("thirdVersion", this.f50728e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f50724a = "swan";
        this.f50727d = "";
        this.f50728e = "";
        this.f50729f = "";
        this.f50730g = "";
        this.f50731h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50724a = jSONObject.optString("from", "swan");
        this.f50726c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50725b = jSONObject.optString("source");
        this.f50729f = jSONObject.optString("needDown");
        this.f50730g = jSONObject.optString("scheme");
        this.f50731h = jSONObject.optString("extPage");
        this.f50732i = jSONObject.optString("launchId", null);
        this.f50727d = jSONObject.optString("appVersion");
        this.f50728e = jSONObject.optString("thirdVersion");
    }
}
