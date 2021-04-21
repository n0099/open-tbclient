package d.b.h0.g.c0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f48735a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.g.c0.e.d f48736b;

    /* renamed from: c  reason: collision with root package name */
    public int f48737c;

    /* renamed from: d  reason: collision with root package name */
    public long f48738d;

    public a(int i, d.b.h0.g.c0.e.d dVar) {
        this.f48735a = i;
        this.f48736b = dVar;
        this.f48737c = d.d() ? 20 : 10;
        this.f48738d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f48735a);
            jSONObject.put("stage", this.f48737c);
            jSONObject.put("ts", this.f48738d);
            if (this.f48736b != null) {
                jSONObject.put("msg", this.f48736b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
