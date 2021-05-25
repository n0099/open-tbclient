package d.a.l0.j.k.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import d.a.l0.a.k;
import d.a.l0.j.n.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.a.l0.j.k.a<d.a.l0.a.h1.c.f> {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1069b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h1.c.f f47847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h1.b f47848b;

        public a(g gVar, d.a.l0.a.h1.c.f fVar, d.a.l0.a.h1.b bVar) {
            this.f47847a = fVar;
            this.f47848b = bVar;
        }

        @Override // d.a.l0.j.n.b.InterfaceC1069b
        public void onAnimationEnd() {
            if (!TextUtils.isEmpty(this.f47847a.C)) {
                this.f47848b.c(this.f47847a.C, null);
            }
            d.a.l0.a.e0.d.g("map", "TranslateMarkerAction animation end");
        }
    }

    static {
        boolean z = k.f43199a;
    }

    public static g e() {
        return new g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.l0.a.h1.c.f fVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return f(context, fVar, bVar, eVar);
    }

    public final boolean f(Context context, d.a.l0.a.h1.c.f fVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("map", "TranslateMarkerAction start");
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(fVar.f40846g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.l0.j.n.c d2 = d.a.l0.j.c.b().c((d.a.l0.a.p.e.b) B).d(fVar.f40845f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "can not find map by id " + fVar.f40845f);
            return false;
        }
        return g(fVar, d2, bVar);
    }

    public final boolean g(d.a.l0.a.h1.c.f fVar, d.a.l0.j.n.c cVar, d.a.l0.a.h1.b bVar) {
        if (fVar.isValid()) {
            d.a.l0.a.h1.c.h.c cVar2 = fVar.E;
            LatLng latLng = new LatLng(cVar2.f42673e, cVar2.f42674f);
            List<d.a.l0.j.n.b> K = cVar.K(fVar.D);
            d.a.l0.a.e0.d.g("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (d.a.l0.j.n.b bVar2 : K) {
                    bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                }
            }
            d.a.l0.a.e0.d.g("map", "TranslateMarkerAction end");
            return true;
        }
        return false;
    }
}
