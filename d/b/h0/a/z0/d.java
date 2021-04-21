package d.b.h0.a.z0;

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
import d.b.h0.a.z0.e;
/* loaded from: classes2.dex */
public interface d extends e.b {
    d.b.h0.a.e0.l.e A();

    FullScreenFloatView B(Activity activity);

    void C();

    void D();

    void E();

    @DebugTrace
    d.b.h0.a.p.d.a F();

    @NonNull
    Pair<Integer, Integer> G();

    SwanAppPropertyWindow H(Activity activity);

    SwanAppConfigData I();

    void J(Intent intent);

    d.b.h0.g.k0.d K();

    SwanCoreVersion L();

    void M();

    void N(d.b.h0.a.k0.b.a aVar);

    boolean O();

    void P();

    d.b.h0.g.k0.d Q();

    void a();

    void b();

    @NonNull
    Pair<Integer, Integer> c();

    String d();

    void e(d.b.h0.a.k0.b.d dVar, boolean z);

    void exit();

    void f();

    void g(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2);

    SwanAppActivity getActivity();

    String h();

    @NonNull
    d.b.h0.a.r1.n.c i(String str, SwanAppConfigData swanAppConfigData, String str2);

    d.b.h0.a.p.d.d j(String str);

    @NonNull
    d.b.h0.a.r1.n.c k(String str);

    String l();

    AbsoluteLayout m(String str);

    d.b.h0.a.p.d.c o();

    String p();

    void q(Context context);

    @NonNull
    d.b.h0.a.r1.n.c r(String str);

    boolean s();

    d.b.h0.a.r1.e t();

    void u(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2);

    d.b.h0.g.v.a v();

    void w(Context context);

    void x(SwanAppActivity swanAppActivity);

    @NonNull
    d.b.h0.a.a2.f.c y();

    void z(String str, d.b.h0.a.k0.b.a aVar);
}
