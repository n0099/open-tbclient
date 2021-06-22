package d.a.m0.g.c.i;

import com.baidu.sapi2.activity.BaseActivity;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50843a;

    /* renamed from: b  reason: collision with root package name */
    public String f50844b;

    /* renamed from: c  reason: collision with root package name */
    public String f50845c;

    /* renamed from: d  reason: collision with root package name */
    public String f50846d;

    /* renamed from: e  reason: collision with root package name */
    public String f50847e;

    /* renamed from: f  reason: collision with root package name */
    public String f50848f;

    /* renamed from: g  reason: collision with root package name */
    public String f50849g;

    /* renamed from: h  reason: collision with root package name */
    public String f50850h;

    /* renamed from: i  reason: collision with root package name */
    public String f50851i;

    public a() {
        this.f50843a = "swan";
        this.f50846d = "";
        this.f50847e = "";
        this.f50848f = "";
        this.f50849g = "";
        this.f50850h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50843a = k.m(L.G());
        this.f50845c = L.H();
        this.f50844b = L.T();
        this.f50848f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50849g = L.W();
        this.f50850h = L.e0();
        this.f50851i = L.V();
        this.f50846d = L.u1();
        this.f50847e = L.v1();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.f50843a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50845c);
            jSONObject.put("source", this.f50844b);
            jSONObject.put("needDown", this.f50848f);
            jSONObject.put("scheme", this.f50849g);
            jSONObject.put("extPage", this.f50850h);
            jSONObject.put("launchId", this.f50851i);
            jSONObject.put("appVersion", this.f50846d);
            jSONObject.put("thirdVersion", this.f50847e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public a(JSONObject jSONObject) {
        this.f50843a = "swan";
        this.f50846d = "";
        this.f50847e = "";
        this.f50848f = "";
        this.f50849g = "";
        this.f50850h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50843a = jSONObject.optString("from", "swan");
        this.f50845c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50844b = jSONObject.optString("source");
        this.f50848f = jSONObject.optString("needDown");
        this.f50849g = jSONObject.optString("scheme");
        this.f50850h = jSONObject.optString("extPage");
        this.f50851i = jSONObject.optString("launchId", null);
        this.f50846d = jSONObject.optString("appVersion");
        this.f50847e = jSONObject.optString("thirdVersion");
    }
}
