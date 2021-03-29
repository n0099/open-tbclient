package d.b.g0.h.a.f.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import d.b.g0.a.k;
import d.b.g0.h.a.i.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.b.g0.h.a.f.a<d.b.g0.a.a1.c.f> {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1008b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.c.f f48727a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.b f48728b;

        public a(g gVar, d.b.g0.a.a1.c.f fVar, d.b.g0.a.a1.b bVar) {
            this.f48727a = fVar;
            this.f48728b = bVar;
        }

        @Override // d.b.g0.h.a.i.b.InterfaceC1008b
        public void onAnimationEnd() {
            if (!TextUtils.isEmpty(this.f48727a.C)) {
                this.f48728b.c(this.f48727a.C, null);
            }
            d.b.g0.a.c0.c.g("map", "TranslateMarkerAction animation end");
        }
    }

    static {
        boolean z = k.f45051a;
    }

    public static g e() {
        return new g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.b.g0.a.a1.c.f fVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, JSONObject jSONObject) {
        return f(context, fVar, bVar, eVar);
    }

    public final boolean f(Context context, d.b.g0.a.a1.c.f fVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("map", "TranslateMarkerAction start");
        d.b.g0.a.p.d.d j = d.b.g0.a.z0.f.V().j(fVar.f43114g);
        if (!(j instanceof d.b.g0.a.p.d.b)) {
            d.b.g0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.g0.h.a.i.c d2 = d.b.g0.h.a.c.b().c((d.b.g0.a.p.d.b) j).d(fVar.f43113f);
        if (d2 == null) {
            d.b.g0.a.c0.c.b("map", "can not find map by id " + fVar.f43113f);
            return false;
        }
        return g(fVar, d2, bVar);
    }

    public final boolean g(d.b.g0.a.a1.c.f fVar, d.b.g0.h.a.i.c cVar, d.b.g0.a.a1.b bVar) {
        if (fVar.isValid()) {
            d.b.g0.a.a1.c.h.c cVar2 = fVar.E;
            LatLng latLng = new LatLng(cVar2.f43191e, cVar2.f43192f);
            List<d.b.g0.h.a.i.b> K = cVar.K(fVar.D);
            d.b.g0.a.c0.c.g("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (d.b.g0.h.a.i.b bVar2 : K) {
                    bVar2.c(cVar, latLng, fVar.F, new a(this, fVar, bVar));
                }
            }
            d.b.g0.a.c0.c.g("map", "TranslateMarkerAction end");
            return true;
        }
        return false;
    }
}
