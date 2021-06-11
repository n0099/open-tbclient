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
    public String f50735a;

    /* renamed from: b  reason: collision with root package name */
    public String f50736b;

    /* renamed from: c  reason: collision with root package name */
    public String f50737c;

    /* renamed from: d  reason: collision with root package name */
    public String f50738d;

    /* renamed from: e  reason: collision with root package name */
    public String f50739e;

    /* renamed from: f  reason: collision with root package name */
    public String f50740f;

    /* renamed from: g  reason: collision with root package name */
    public String f50741g;

    /* renamed from: h  reason: collision with root package name */
    public String f50742h;

    /* renamed from: i  reason: collision with root package name */
    public String f50743i;

    public a() {
        this.f50735a = "swan";
        this.f50738d = "";
        this.f50739e = "";
        this.f50740f = "";
        this.f50741g = "";
        this.f50742h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50735a = k.m(L.G());
        this.f50737c = L.H();
        this.f50736b = L.T();
        this.f50740f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50741g = L.W();
        this.f50742h = L.e0();
        this.f50743i = L.V();
        this.f50738d = L.u1();
        this.f50739e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f50735a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50737c);
            jSONObject.put("source", this.f50736b);
            jSONObject.put("needDown", this.f50740f);
            jSONObject.put("scheme", this.f50741g);
            jSONObject.put("extPage", this.f50742h);
            jSONObject.put("launchId", this.f50743i);
            jSONObject.put("appVersion", this.f50738d);
            jSONObject.put("thirdVersion", this.f50739e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f50735a = "swan";
        this.f50738d = "";
        this.f50739e = "";
        this.f50740f = "";
        this.f50741g = "";
        this.f50742h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50735a = jSONObject.optString("from", "swan");
        this.f50737c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50736b = jSONObject.optString("source");
        this.f50740f = jSONObject.optString("needDown");
        this.f50741g = jSONObject.optString("scheme");
        this.f50742h = jSONObject.optString("extPage");
        this.f50743i = jSONObject.optString("launchId", null);
        this.f50738d = jSONObject.optString("appVersion");
        this.f50739e = jSONObject.optString("thirdVersion");
    }
}
