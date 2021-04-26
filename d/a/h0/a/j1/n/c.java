package d.a.h0.a.j1.n;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.h0.a.j1.g;
import d.a.h0.a.j1.l.f;
import d.a.h0.a.s0.k.f.b;
/* loaded from: classes3.dex */
public class c implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            if (c.this.b(hybridUbcFlow)) {
                return;
            }
            long e2 = hybridUbcFlow.e("na_first_meaningful_paint", "naStart");
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_first_paint", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("slave_first_rendered", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("fe_page_show", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_page_show", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_receive_intent", "naStart");
            }
            if (e2 <= 0) {
                e2 = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("property_launch_cost", e2);
            d.a.h0.a.n1.c.a e3 = d.a.h0.a.n1.c.a.e();
            d.a.h0.a.n1.c.c cVar = new d.a.h0.a.n1.c.c(20, bundle);
            cVar.f(true);
            e3.h(cVar);
            f.h().c(e2);
        }
    }

    public final boolean b(HybridUbcFlow hybridUbcFlow) {
        return hybridUbcFlow.m("performanceEnd") && !hybridUbcFlow.m("na_first_meaningful_paint");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: c */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.E("670");
        hybridUbcFlow.y("preload_scene", "1");
        hybridUbcFlow.z("from", "swan");
        hybridUbcFlow.C("component_reporter", new d.a.h0.a.j1.d());
        hybridUbcFlow.C("component_reporter", new d.a.h0.a.g1.o.d.c());
        hybridUbcFlow.C("component_reporter", new d.a.h0.a.j1.a());
        hybridUbcFlow.C("component_reporter", new g());
        hybridUbcFlow.C("callback_on_submit", new b.a());
        hybridUbcFlow.C("fmp_callback", new e("fmp_callback"));
        hybridUbcFlow.C("callback_on_submit", new e("callback_on_submit"));
        hybridUbcFlow.C("callback_on_submit", new a());
    }
}
