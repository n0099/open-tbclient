package d.b.h0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f51142a;

    public boolean a() {
        return this.f51142a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51142a = jSONObject.optInt("agree_icon", 0);
    }
}
