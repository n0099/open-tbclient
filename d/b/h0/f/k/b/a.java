package d.b.h0.f.k.b;

import d.b.h0.a.k;
import d.b.h0.a.t.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48574c = k.f45772a;

    public a() {
        super("getSid");
    }

    @Override // d.b.h0.f.i.a
    public b a(JSONObject jSONObject, d.b.h0.a.p0.b bVar) {
        String c2 = d.b.h0.a.w0.a.N().c();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sid", c2);
        } catch (JSONException e2) {
            if (f48574c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject2);
        return null;
    }
}
