package d.b.g0.g.c0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48406a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.c0.e.d f48407b;

    /* renamed from: c  reason: collision with root package name */
    public int f48408c;

    /* renamed from: d  reason: collision with root package name */
    public long f48409d;

    public a(int i, d.b.g0.g.c0.e.d dVar) {
        this.f48406a = i;
        this.f48407b = dVar;
        this.f48408c = d.d() ? 20 : 10;
        this.f48409d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f48406a);
            jSONObject.put("stage", this.f48408c);
            jSONObject.put("ts", this.f48409d);
            if (this.f48407b != null) {
                jSONObject.put("msg", this.f48407b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
