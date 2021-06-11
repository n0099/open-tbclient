package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f54137a;

    /* renamed from: b  reason: collision with root package name */
    public int f54138b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54137a = jSONObject.optInt("logined");
            this.f54138b = jSONObject.optInt("unlogin");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
