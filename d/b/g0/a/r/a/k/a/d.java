package d.b.g0.a.r.a.k.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.n.a.b f45701a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f45702a = new d();
    }

    public static d a() {
        return a.f45702a;
    }

    public void b(int i) {
        d.b.g0.a.n.a.b bVar = this.f45701a;
        if (bVar != null) {
            bVar.a(i);
            this.f45701a = null;
        }
    }

    public void c(JSONObject jSONObject) {
        d.b.g0.a.n.a.b bVar = this.f45701a;
        if (bVar != null) {
            bVar.b(jSONObject);
            this.f45701a = null;
        }
    }
}
