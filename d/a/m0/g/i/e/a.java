package d.a.m0.g.i.e;

import d.a.m0.a.k;
import d.a.m0.a.u.h.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.m0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50880c = k.f46983a;

    public a() {
        super("getSid");
    }

    @Override // d.a.m0.g.f.a
    public b a(JSONObject jSONObject, d.a.m0.a.u0.b bVar) {
        String k = d.a.m0.a.c1.a.Z().k();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sid", k);
        } catch (JSONException e2) {
            if (f50880c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject2);
        return null;
    }
}
