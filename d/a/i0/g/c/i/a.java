package d.a.i0.g.c.i;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46885a;

    /* renamed from: b  reason: collision with root package name */
    public String f46886b;

    /* renamed from: c  reason: collision with root package name */
    public String f46887c;

    /* renamed from: d  reason: collision with root package name */
    public String f46888d;

    /* renamed from: e  reason: collision with root package name */
    public String f46889e;

    /* renamed from: f  reason: collision with root package name */
    public String f46890f;

    /* renamed from: g  reason: collision with root package name */
    public String f46891g;

    /* renamed from: h  reason: collision with root package name */
    public String f46892h;

    /* renamed from: i  reason: collision with root package name */
    public String f46893i;

    public a() {
        this.f46885a = "swan";
        this.f46888d = "";
        this.f46889e = "";
        this.f46890f = "";
        this.f46891g = "";
        this.f46892h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f46885a = k.m(L.G());
        this.f46887c = L.H();
        this.f46886b = L.T();
        this.f46890f = L.r0().getString("aiapp_extra_need_download", "");
        this.f46891g = L.W();
        this.f46892h = L.e0();
        this.f46893i = L.V();
        this.f46888d = L.u1();
        this.f46889e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f46885a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f46887c);
            jSONObject.put("source", this.f46886b);
            jSONObject.put("needDown", this.f46890f);
            jSONObject.put("scheme", this.f46891g);
            jSONObject.put("extPage", this.f46892h);
            jSONObject.put("launchId", this.f46893i);
            jSONObject.put("appVersion", this.f46888d);
            jSONObject.put("thirdVersion", this.f46889e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f46885a = "swan";
        this.f46888d = "";
        this.f46889e = "";
        this.f46890f = "";
        this.f46891g = "";
        this.f46892h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f46885a = jSONObject.optString("from", "swan");
        this.f46887c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f46886b = jSONObject.optString("source");
        this.f46890f = jSONObject.optString("needDown");
        this.f46891g = jSONObject.optString("scheme");
        this.f46892h = jSONObject.optString("extPage");
        this.f46893i = jSONObject.optString("launchId", null);
        this.f46888d = jSONObject.optString("appVersion");
        this.f46889e = jSONObject.optString("thirdVersion");
    }
}
