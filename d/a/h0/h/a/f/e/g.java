package d.a.h0.h.a.f.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import d.a.h0.a.k;
import d.a.h0.h.a.i.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.a.h0.h.a.f.a<d.a.h0.a.a1.c.f> {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC0979b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.c.f f46948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.b f46949b;

        public a(g gVar, d.a.h0.a.a1.c.f fVar, d.a.h0.a.a1.b bVar) {
            this.f46948a = fVar;
            this.f46949b = bVar;
        }

        @Override // d.a.h0.h.a.i.b.InterfaceC0979b
        public void onAnimationEnd() {
            if (!TextUtils.isEmpty(this.f46948a.C)) {
                this.f46949b.c(this.f46948a.C, null);
            }
            d.a.h0.a.c0.c.g("map", "TranslateMarkerAction animation end");
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public static g e() {
        return new g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.a.h0.a.a1.c.f fVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, JSONObject jSONObject) {
        return f(context, fVar, bVar, eVar);
    }

    public final boolean f(Context context, d.a.h0.a.a1.c.f fVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("map", "TranslateMarkerAction start");
        d.a.h0.a.p.d.d B = d.a.h0.a.z0.f.V().B(fVar.f41093g);
        if (!(B instanceof d.a.h0.a.p.d.b)) {
            d.a.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.a.h0.h.a.i.c d2 = d.a.h0.h.a.c.b().c((d.a.h0.a.p.d.b) B).d(fVar.f41092f);
        if (d2 == null) {
            d.a.h0.a.c0.c.b("map", "can not find map by id " + fVar.f41092f);
            return false;
        }
        return g(fVar, d2, bVar);
    }

    public final boolean g(d.a.h0.a.a1.c.f fVar, d.a.h0.h.a.i.c cVar, d.a.h0.a.a1.b bVar) {
        if (fVar.isValid()) {
            d.a.h0.a.a1.c.h.c cVar2 = fVar.E;
            LatLng latLng = new LatLng(cVar2.f41178e, cVar2.f41179f);
            List<d.a.h0.h.a.i.b> K = cVar.K(fVar.D);
            d.a.h0.a.c0.c.g("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (d.a.h0.h.a.i.b bVar2 : K) {
                    bVar2.c(cVar, latLng, fVar.F, new a(this, fVar, bVar));
                }
            }
            d.a.h0.a.c0.c.g("map", "TranslateMarkerAction end");
            return true;
        }
        return false;
    }
}
