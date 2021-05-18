package d.a.i0.h.f0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f47190a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.h.f0.i.d f47191b;

    /* renamed from: c  reason: collision with root package name */
    public int f47192c;

    /* renamed from: d  reason: collision with root package name */
    public long f47193d;

    public a(int i2, d.a.i0.h.f0.i.d dVar) {
        this.f47190a = i2;
        this.f47191b = dVar;
        this.f47192c = h.d() ? 20 : 10;
        this.f47193d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f47190a);
            jSONObject.put("stage", this.f47192c);
            jSONObject.put("ts", this.f47193d);
            if (this.f47191b != null) {
                jSONObject.put("msg", this.f47191b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
