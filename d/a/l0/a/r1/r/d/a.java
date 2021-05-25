package d.a.l0.a.r1.r.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.r1.h;
import d.a.l0.a.v2.e1.b;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final List<String> f44576e = new ArrayList(5);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(@NonNull HybridUbcFlow hybridUbcFlow) {
        d.a.l0.a.r1.r.a.f().c(false);
        String g2 = hybridUbcFlow.g("launchid");
        if (!TextUtils.isEmpty(g2)) {
            synchronized (f44576e) {
                if (!f44576e.contains(g2)) {
                    f44576e.add(g2);
                    c(g2, hybridUbcFlow);
                }
            }
        }
        String str = (String) hybridUbcFlow.i("routeId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f44576e) {
            if (!f44576e.contains(str)) {
                f44576e.add(str);
                b(str, hybridUbcFlow);
            }
        }
    }

    public final void b(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        d(hybridUbcFlow);
        UbcFlowEvent f2 = hybridUbcFlow.f("na_first_meaningful_paint");
        HybridUbcFlow e2 = h.e(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        if (e2 == null || f2 == null) {
            return;
        }
        e2.C(f2);
        e2.y();
    }

    public final void c(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        d(hybridUbcFlow);
    }

    public final void d(@NonNull HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow.f("na_first_meaningful_paint") == null) {
            return;
        }
        g.N().H0(new d.a.l0.a.o0.d.h((String) hybridUbcFlow.i(PrefetchEvent.EVENT_DATA_WEBVIEW_ID), (String) hybridUbcFlow.i("pageUrl")));
    }
}
