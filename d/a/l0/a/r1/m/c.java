package d.a.l0.a.r1.m;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.l0.o.a;
import d.a.l0.a.n2.h.b;
import d.a.l0.a.r1.k.f;
import d.a.l0.a.y0.k.f.b;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.v2.e1.b<HybridUbcFlow> {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<HybridUbcFlow> {
        public a(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            if (c.a(hybridUbcFlow)) {
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
            d.a.l0.a.v1.c.a e3 = d.a.l0.a.v1.c.a.e();
            d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(20, bundle);
            cVar.f(true);
            e3.h(cVar);
            f.j().c(e2);
            d.a.l0.a.r1.l.f.a.e().f();
        }
    }

    public static boolean a(HybridUbcFlow hybridUbcFlow) {
        return hybridUbcFlow.n("performanceEnd") && !hybridUbcFlow.n("na_first_meaningful_paint");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        hybridUbcFlow.G("670");
        hybridUbcFlow.A("preload_scene", "1");
        hybridUbcFlow.B("from", "swan");
        hybridUbcFlow.E("component_reporter", new d.a.l0.a.r1.d());
        hybridUbcFlow.E("component_reporter", new d.a.l0.a.n1.q.d.c());
        hybridUbcFlow.E("component_reporter", new d.a.l0.a.r1.a());
        hybridUbcFlow.E("component_reporter", new d.a.l0.a.r1.f());
        hybridUbcFlow.E("callback_on_submit", new b.a());
        hybridUbcFlow.E("callback_on_submit", new b.e());
        hybridUbcFlow.E("callback_on_submit", new a.d());
        hybridUbcFlow.E("fmp_callback", new e("fmp_callback"));
        hybridUbcFlow.E("fmp_callback", new d.a.l0.a.r1.r.d.a());
        hybridUbcFlow.E("callback_on_submit", new e("callback_on_submit"));
        hybridUbcFlow.E("callback_on_submit", new d.a.l0.a.r2.a());
        hybridUbcFlow.E("callback_on_submit", new a(this));
    }
}
