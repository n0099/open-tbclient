package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public String f49575a;

    public String a() {
        return this.f49575a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49575a = jSONObject.optString("checkurl", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
