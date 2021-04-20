package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51586a;

    public String a() {
        return this.f51586a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51586a = jSONObject.optString("checkurl", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
