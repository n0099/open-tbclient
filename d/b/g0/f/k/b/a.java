package d.b.g0.f.k.b;

import d.b.g0.a.k;
import d.b.g0.a.t.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48245c = k.f45443a;

    public a() {
        super("getSid");
    }

    @Override // d.b.g0.f.i.a
    public b a(JSONObject jSONObject, d.b.g0.a.p0.b bVar) {
        String c2 = d.b.g0.a.w0.a.N().c();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sid", c2);
        } catch (JSONException e2) {
            if (f48245c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject2);
        return null;
    }
}
