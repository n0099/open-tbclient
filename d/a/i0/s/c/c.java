package d.a.i0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f49543a;

    public boolean a() {
        return this.f49543a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49543a = jSONObject.optInt("agree_icon", 0);
    }
}
