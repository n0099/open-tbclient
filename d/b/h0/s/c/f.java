package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f51160a;

    /* renamed from: b  reason: collision with root package name */
    public int f51161b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51160a = jSONObject.optInt("logined");
            this.f51161b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
