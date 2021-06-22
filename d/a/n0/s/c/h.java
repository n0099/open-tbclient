package d.a.n0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f54244a;

    /* renamed from: b  reason: collision with root package name */
    public int f54245b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54244a = jSONObject.optInt("logined");
            this.f54245b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
