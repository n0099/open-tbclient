package d.b.h0.a.j1;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class d implements d.b.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45598e = d.b.h0.a.k.f45772a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.i2.u0.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo r;
        if (f45598e) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow == null || (r = d.b.h0.l.i.a.h().r(d.b.h0.a.r1.d.e().getAppId())) == null) {
            return;
        }
        UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
        r.e(f2 == null ? System.currentTimeMillis() : f2.g());
        d.b.h0.l.i.a.h().u(r);
    }
}
