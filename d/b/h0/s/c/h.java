package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f51587a;

    /* renamed from: b  reason: collision with root package name */
    public int f51588b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51587a = jSONObject.optInt("logined");
            this.f51588b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
