package d.b.g0.a.r.a.k.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.n.a.b f46094a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f46095a = new d();
    }

    public static d a() {
        return a.f46095a;
    }

    public void b(int i) {
        d.b.g0.a.n.a.b bVar = this.f46094a;
        if (bVar != null) {
            bVar.a(i);
            this.f46094a = null;
        }
    }

    public void c(JSONObject jSONObject) {
        d.b.g0.a.n.a.b bVar = this.f46094a;
        if (bVar != null) {
            bVar.b(jSONObject);
            this.f46094a = null;
        }
    }
}
