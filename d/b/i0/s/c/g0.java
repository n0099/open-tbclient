package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51922a;

    public String a() {
        return this.f51922a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51922a = jSONObject.optString("checkurl", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
