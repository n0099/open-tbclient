package d.b.h0.h.a.f.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import d.b.h0.a.k;
import d.b.h0.h.a.i.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.b.h0.h.a.f.a<d.b.h0.a.a1.c.f> {

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1040b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.c.f f49448a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.b f49449b;

        public a(g gVar, d.b.h0.a.a1.c.f fVar, d.b.h0.a.a1.b bVar) {
            this.f49448a = fVar;
            this.f49449b = bVar;
        }

        @Override // d.b.h0.h.a.i.b.InterfaceC1040b
        public void onAnimationEnd() {
            if (!TextUtils.isEmpty(this.f49448a.C)) {
                this.f49449b.c(this.f49448a.C, null);
            }
            d.b.h0.a.c0.c.g("map", "TranslateMarkerAction animation end");
        }
    }

    static {
        boolean z = k.f45772a;
    }

    public static g e() {
        return new g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.b.h0.a.a1.c.f fVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, JSONObject jSONObject) {
        return f(context, fVar, bVar, eVar);
    }

    public final boolean f(Context context, d.b.h0.a.a1.c.f fVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("map", "TranslateMarkerAction start");
        d.b.h0.a.p.d.d j = d.b.h0.a.z0.f.V().j(fVar.f43835g);
        if (!(j instanceof d.b.h0.a.p.d.b)) {
            d.b.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.h0.h.a.i.c d2 = d.b.h0.h.a.c.b().c((d.b.h0.a.p.d.b) j).d(fVar.f43834f);
        if (d2 == null) {
            d.b.h0.a.c0.c.b("map", "can not find map by id " + fVar.f43834f);
            return false;
        }
        return g(fVar, d2, bVar);
    }

    public final boolean g(d.b.h0.a.a1.c.f fVar, d.b.h0.h.a.i.c cVar, d.b.h0.a.a1.b bVar) {
        if (fVar.isValid()) {
            d.b.h0.a.a1.c.h.c cVar2 = fVar.E;
            LatLng latLng = new LatLng(cVar2.f43912e, cVar2.f43913f);
            List<d.b.h0.h.a.i.b> K = cVar.K(fVar.D);
            d.b.h0.a.c0.c.g("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (d.b.h0.h.a.i.b bVar2 : K) {
                    bVar2.c(cVar, latLng, fVar.F, new a(this, fVar, bVar));
                }
            }
            d.b.h0.a.c0.c.g("map", "TranslateMarkerAction end");
            return true;
        }
        return false;
    }
}
