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
import com.repackage.tl2;
/* loaded from: classes7.dex */
public interface sl2 extends tl2.b {
    pm1 A(String str);

    View B(String str);

    String C();

    h03 D();

    void E(el2 el2Var, bj2 bj2Var);

    vh1 F();

    @NonNull
    k83 G();

    pz1 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    yh1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    yh1 P();

    void a();

    String b();

    void c();

    void d(el2 el2Var, bj2 bj2Var);

    @NonNull
    w03 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    w03 f(String str);

    String g();

    SwanAppActivity getActivity();

    om1 i();

    @NonNull
    w03 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ha2 ha2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    mm1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ha2 ha2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(ka2 ka2Var, boolean z);

    String z();
}
