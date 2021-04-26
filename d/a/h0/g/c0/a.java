package d.a.h0.g.c0;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f46202a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.g.c0.e.d f46203b;

    /* renamed from: c  reason: collision with root package name */
    public int f46204c;

    /* renamed from: d  reason: collision with root package name */
    public long f46205d;

    public a(int i2, d.a.h0.g.c0.e.d dVar) {
        this.f46202a = i2;
        this.f46203b = dVar;
        this.f46204c = d.d() ? 20 : 10;
        this.f46205d = System.currentTimeMillis();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f46202a);
            jSONObject.put("stage", this.f46204c);
            jSONObject.put("ts", this.f46205d);
            if (this.f46203b != null) {
                jSONObject.put("msg", this.f46203b.a());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
