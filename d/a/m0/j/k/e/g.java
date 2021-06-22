package d.a.m0.j.k.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import d.a.m0.a.k;
import d.a.m0.j.n.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.a.m0.j.k.a<d.a.m0.a.h1.c.f> {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1128b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h1.c.f f51629a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h1.b f51630b;

        public a(g gVar, d.a.m0.a.h1.c.f fVar, d.a.m0.a.h1.b bVar) {
            this.f51629a = fVar;
            this.f51630b = bVar;
        }

        @Override // d.a.m0.j.n.b.InterfaceC1128b
        public void onAnimationEnd() {
            if (!TextUtils.isEmpty(this.f51629a.C)) {
                this.f51630b.c(this.f51629a.C, null);
            }
            d.a.m0.a.e0.d.g("map", "TranslateMarkerAction animation end");
        }
    }

    static {
        boolean z = k.f46983a;
    }

    public static g e() {
        return new g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.m0.a.h1.c.f fVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar, JSONObject jSONObject) {
        return f(context, fVar, bVar, eVar);
    }

    public final boolean f(Context context, d.a.m0.a.h1.c.f fVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.e0.d.g("map", "TranslateMarkerAction start");
        d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(fVar.f44630g);
        if (!(B instanceof d.a.m0.a.p.e.b)) {
            d.a.m0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.m0.j.n.c d2 = d.a.m0.j.c.b().c((d.a.m0.a.p.e.b) B).d(fVar.f44629f);
        if (d2 == null) {
            d.a.m0.a.e0.d.b("map", "can not find map by id " + fVar.f44629f);
            return false;
        }
        return g(fVar, d2, bVar);
    }

    public final boolean g(d.a.m0.a.h1.c.f fVar, d.a.m0.j.n.c cVar, d.a.m0.a.h1.b bVar) {
        if (fVar.isValid()) {
            d.a.m0.a.h1.c.h.c cVar2 = fVar.E;
            LatLng latLng = new LatLng(cVar2.f46457e, cVar2.f46458f);
            List<d.a.m0.j.n.b> K = cVar.K(fVar.D);
            d.a.m0.a.e0.d.g("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (d.a.m0.j.n.b bVar2 : K) {
                    bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                }
            }
            d.a.m0.a.e0.d.g("map", "TranslateMarkerAction end");
            return true;
        }
        return false;
    }
}
