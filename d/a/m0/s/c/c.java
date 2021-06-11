package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f54096a;

    public boolean a() {
        return this.f54096a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54096a = jSONObject.optInt("agree_icon", 0);
    }
}
