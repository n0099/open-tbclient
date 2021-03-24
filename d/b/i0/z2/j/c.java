package d.b.i0.z2.j;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends d.b.i0.z2.f.a {

    /* renamed from: c  reason: collision with root package name */
    public d f63540c;

    @Override // d.b.i0.z2.f.a
    public void d(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.a(optJSONObject);
            i(dVar);
        }
    }

    public d h() {
        return this.f63540c;
    }

    public void i(d dVar) {
        this.f63540c = dVar;
        g(null);
    }
}
