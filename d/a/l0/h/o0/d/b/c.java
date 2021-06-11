package d.a.l0.h.o0.d.b;

import d.a.l0.a.e0.d;
import d.a.l0.a.g1.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51230e;

        public a(c cVar, b bVar) {
            this.f51230e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            JSONObject jSONObject;
            if (aVar != null && (jSONObject = aVar.f45447g) != null) {
                d.a("OpenData", "onOpenDataCallback success: ", jSONObject);
                this.f51230e.a(aVar.f45447g);
                return;
            }
            this.f51230e.a(null);
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
        d.a.l0.a.e2.d.a.C(f.V().getActivity(), "snsapi_userinfo", null, true, "GameUserInfoRequest", new a(this, bVar));
    }
}
