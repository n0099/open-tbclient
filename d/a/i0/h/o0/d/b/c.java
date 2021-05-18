package d.a.i0.h.o0.d.b;

import d.a.i0.a.e0.d;
import d.a.i0.a.g1.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f47380e;

        public a(c cVar, b bVar) {
            this.f47380e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.d.a aVar) {
            JSONObject jSONObject;
            if (aVar != null && (jSONObject = aVar.f41597g) != null) {
                d.a("OpenData", "onOpenDataCallback success: ", jSONObject);
                this.f47380e.a(aVar.f41597g);
                return;
            }
            this.f47380e.a(null);
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
        d.a.i0.a.e2.d.a.C(f.V().getActivity(), "snsapi_userinfo", null, true, "GameUserInfoRequest", new a(this, bVar));
    }
}
