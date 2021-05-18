package d.a.j0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f50448a;

    public String a() {
        return this.f50448a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50448a = jSONObject.optString("client_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
