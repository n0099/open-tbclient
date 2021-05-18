package d.a.j0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f50362a;

    public boolean a() {
        return this.f50362a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50362a = jSONObject.optInt("agree_icon", 0);
    }
}
