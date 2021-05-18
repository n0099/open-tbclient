package d.a.i0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class c implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43588e = k.f43025a;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.n1.q.d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f43589a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f43590b;

        public a(UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            this.f43589a = ubcFlowEvent;
            this.f43590b = ubcFlowEvent2;
        }

        @Override // d.a.i0.a.n1.q.d.a
        public boolean a(d dVar) {
            if (dVar == null) {
                return false;
            }
            return c.this.b(dVar, this.f43589a, this.f43590b);
        }
    }

    public c() {
        b.f().g();
        if (f43588e) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public final boolean b(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        long b2 = dVar.b();
        return b2 >= ubcFlowEvent.g() && b2 <= ubcFlowEvent2.g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.v2.e1.b
    /* renamed from: c */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f43588e) {
            Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow == null) {
            return;
        }
        UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
        UbcFlowEvent f3 = hybridUbcFlow.f("na_first_meaningful_paint");
        if (f2 != null && f3 != null) {
            b.f().h(new a(f2, f3));
            b.f().a(hybridUbcFlow);
            if (f43588e) {
                Log.d("MaUpdateReporter", "na_start ts - " + f2.g());
                Log.d("MaUpdateReporter", "fmp_end ts - " + f3.g());
                return;
            }
            return;
        }
        if (f43588e) {
            if (f2 == null) {
                Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
            } else {
                Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
            }
        }
        b.f().c();
    }
}
