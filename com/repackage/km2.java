package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.repackage.lm2;
/* loaded from: classes6.dex */
public interface km2 extends lm2.b {
    hn1 A(String str);

    View B(String str);

    String C();

    z03 D();

    void E(wl2 wl2Var, tj2 tj2Var);

    ni1 F();

    @NonNull
    c93 G();

    h02 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    qi1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    qi1 P();

    void a();

    String b();

    void c();

    void d(wl2 wl2Var, tj2 tj2Var);

    @NonNull
    o13 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    o13 f(String str);

    String g();

    SwanAppActivity getActivity();

    gn1 i();

    @NonNull
    o13 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, za2 za2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    en1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(za2 za2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(cb2 cb2Var, boolean z);

    String z();
}
