package d.b.i0.a3.j;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends d.b.i0.a3.f.a {

    /* renamed from: c  reason: collision with root package name */
    public d f53160c;

    @Override // d.b.i0.a3.f.a
    public void d(JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("forum_dir");
        if (optJSONObject != null) {
            d dVar = new d();
            dVar.a(optJSONObject);
            i(dVar);
        }
    }

    public d h() {
        return this.f53160c;
    }

    public void i(d dVar) {
        this.f53160c = dVar;
        g(null);
    }
}
