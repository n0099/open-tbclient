package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public String f51213a;

    public String a() {
        return this.f51213a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51213a = jSONObject.optString("client_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
