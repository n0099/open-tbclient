package d.a.l0.h.f0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f47366a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.h.f0.i.d f47367b;

    /* renamed from: c  reason: collision with root package name */
    public int f47368c;

    /* renamed from: d  reason: collision with root package name */
    public long f47369d;

    public a(int i2, d.a.l0.h.f0.i.d dVar) {
        this.f47366a = i2;
        this.f47367b = dVar;
        this.f47368c = h.d() ? 20 : 10;
        this.f47369d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f47366a);
            jSONObject.put("stage", this.f47368c);
            jSONObject.put("ts", this.f47369d);
            if (this.f47367b != null) {
                jSONObject.put("msg", this.f47367b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
