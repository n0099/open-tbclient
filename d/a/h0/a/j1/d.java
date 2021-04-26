package d.a.h0.a.j1;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes3.dex */
public class d implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42921e = d.a.h0.a.k.f43101a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo r;
        if (f42921e) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow == null || (r = d.a.h0.l.i.a.h().r(d.a.h0.a.r1.d.e().getAppId())) == null) {
            return;
        }
        UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
        r.e(f2 == null ? System.currentTimeMillis() : f2.g());
        d.a.h0.l.i.a.h().u(r);
    }
}
