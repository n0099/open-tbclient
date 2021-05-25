package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f50420a;

    public boolean a() {
        return this.f50420a == 1;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50420a = jSONObject.optInt("agree_icon", 0);
    }
}
