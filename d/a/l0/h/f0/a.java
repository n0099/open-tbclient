package d.a.l0.h.f0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51040a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.h.f0.i.d f51041b;

    /* renamed from: c  reason: collision with root package name */
    public int f51042c;

    /* renamed from: d  reason: collision with root package name */
    public long f51043d;

    public a(int i2, d.a.l0.h.f0.i.d dVar) {
        this.f51040a = i2;
        this.f51041b = dVar;
        this.f51042c = h.d() ? 20 : 10;
        this.f51043d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f51040a);
            jSONObject.put("stage", this.f51042c);
            jSONObject.put("ts", this.f51043d);
            if (this.f51041b != null) {
                jSONObject.put("msg", this.f51041b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
