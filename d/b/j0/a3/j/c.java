package d.b.j0.a3.j;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends d.b.j0.a3.f.a {

    /* renamed from: c  reason: collision with root package name */
    public d f53581c;

    @Override // d.b.j0.a3.f.a
    public void d(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.a(optJSONObject);
            i(dVar);
        }
    }

    public d h() {
        return this.f53581c;
    }

    public void i(d dVar) {
        this.f53581c = dVar;
        g(null);
    }
}
