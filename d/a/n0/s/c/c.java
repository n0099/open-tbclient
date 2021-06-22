package d.a.n0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f54203a;

    public boolean a() {
        return this.f54203a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54203a = jSONObject.optInt("agree_icon", 0);
    }
}
