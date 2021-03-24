package d.b.g0.g.k0.f.b;

import d.b.g0.a.z0.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48253e;

        public a(c cVar, b bVar) {
            this.f48253e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            JSONObject jSONObject;
            if (aVar != null && (jSONObject = aVar.f46838g) != null) {
                d.b.g0.a.c0.c.a("OpenData", "onOpenDataCallback success: ", jSONObject);
                this.f48253e.a(aVar.f46838g);
                return;
            }
            this.f48253e.a(null);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    public void a(b bVar) {
        if (bVar == null || f.V().getActivity() == null) {
            return;
        }
        d.b.g0.a.v1.d.a.v(f.V().getActivity(), "snsapi_userinfo", null, true, new a(this, bVar));
    }
}
