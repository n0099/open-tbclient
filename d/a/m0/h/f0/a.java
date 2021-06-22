package d.a.m0.h.f0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51148a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.h.f0.i.d f51149b;

    /* renamed from: c  reason: collision with root package name */
    public int f51150c;

    /* renamed from: d  reason: collision with root package name */
    public long f51151d;

    public a(int i2, d.a.m0.h.f0.i.d dVar) {
        this.f51148a = i2;
        this.f51149b = dVar;
        this.f51150c = h.d() ? 20 : 10;
        this.f51151d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f51148a);
            jSONObject.put("stage", this.f51150c);
            jSONObject.put("ts", this.f51151d);
            if (this.f51149b != null) {
                jSONObject.put("msg", this.f51149b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
