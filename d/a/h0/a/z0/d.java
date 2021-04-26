package d.a.h0.a.z0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.z0.e;
/* loaded from: classes2.dex */
public interface d extends e.b {
    String A();

    d.a.h0.a.p.d.d B(String str);

    AbsoluteLayout C(String str);

    String D();

    void E(Context context);

    d.a.h0.a.r1.e F();

    void G(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2);

    d.a.h0.g.v.a H();

    @NonNull
    d.a.h0.a.a2.f.c I();

    d.a.h0.a.e0.l.e J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    d.a.h0.g.k0.d M();

    SwanCoreVersion N();

    boolean O();

    void P();

    d.a.h0.g.k0.d Q();

    void a();

    void b();

    String c();

    void d();

    void e(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2);

    void exit();

    @NonNull
    d.a.h0.a.r1.n.c f(String str, SwanAppConfigData swanAppConfigData, String str2);

    @NonNull
    d.a.h0.a.r1.n.c g(String str);

    SwanAppActivity getActivity();

    String h();

    d.a.h0.a.p.d.c j();

    @NonNull
    d.a.h0.a.r1.n.c k(String str);

    boolean l();

    void m(Context context);

    void n(SwanAppActivity swanAppActivity);

    void o(String str, d.a.h0.a.k0.b.a aVar);

    FullScreenFloatView p(Activity activity);

    void q();

    void r();

    @DebugTrace
    d.a.h0.a.p.d.a s();

    @NonNull
    Pair<Integer, Integer> t();

    SwanAppConfigData u();

    void v(Intent intent);

    void w();

    void x(d.a.h0.a.k0.b.a aVar);

    @NonNull
    Pair<Integer, Integer> y();

    void z(d.a.h0.a.k0.b.d dVar, boolean z);
}
