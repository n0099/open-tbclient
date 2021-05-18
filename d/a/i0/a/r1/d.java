package d.a.i0.a.r1;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class d implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44258e = k.f43025a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        PMSAppInfo s;
        if (f44258e) {
            Log.i("LaunchCounter", "report: flow=" + hybridUbcFlow);
        }
        if (hybridUbcFlow == null || (s = d.a.i0.n.g.a.h().s(d.a.i0.a.a2.d.g().getAppId())) == null) {
            return;
        }
        UbcFlowEvent f2 = hybridUbcFlow.f("naStart");
        s.e(f2 == null ? System.currentTimeMillis() : f2.g());
        d.a.i0.n.g.a.h().w(s);
    }
}
