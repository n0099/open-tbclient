package d.a.n0.b3.j;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends d.a.n0.b3.f.a {

    /* renamed from: c  reason: collision with root package name */
    public d f55872c;

    @Override // d.a.n0.b3.f.a
    public void d(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.a(optJSONObject);
            i(dVar);
        }
    }

    public d h() {
        return this.f55872c;
    }

    public void i(d dVar) {
        this.f55872c = dVar;
        g(null);
    }
}
