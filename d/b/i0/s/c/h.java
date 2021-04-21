package d.b.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f51923a;

    /* renamed from: b  reason: collision with root package name */
    public int f51924b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51923a = jSONObject.optInt("logined");
            this.f51924b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
