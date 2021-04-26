package d.a.h0.f.k.b;

import d.a.h0.a.k;
import d.a.h0.a.t.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46035c = k.f43101a;

    public a() {
        super("getSid");
    }

    @Override // d.a.h0.f.i.a
    public b a(JSONObject jSONObject, d.a.h0.a.p0.b bVar) {
        String b2 = d.a.h0.a.w0.a.N().b();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sid", b2);
        } catch (JSONException e2) {
            if (f46035c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject2);
        return null;
    }
}
