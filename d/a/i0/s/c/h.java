package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f49576a;

    /* renamed from: b  reason: collision with root package name */
    public int f49577b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49576a = jSONObject.optInt("logined");
            this.f49577b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
