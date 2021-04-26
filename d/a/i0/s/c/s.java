package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f49629a;

    public String a() {
        return this.f49629a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49629a = jSONObject.optString("client_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
