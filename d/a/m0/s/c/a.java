package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54083a = false;

    public boolean a() {
        return this.f54083a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
            c(optJSONObject);
            d(optJSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54083a = true;
        }
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            d.a.m0.r.d0.b.j().x("praise_abtest_switch_json", jSONObject.toString());
        } else {
            d.a.m0.r.d0.b.j().x("praise_abtest_switch_json", "");
        }
    }
}
