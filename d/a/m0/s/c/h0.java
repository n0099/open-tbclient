package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54139a;

    public String a() {
        return this.f54139a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54139a = jSONObject.optString("checkurl", null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
