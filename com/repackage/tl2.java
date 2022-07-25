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
import com.repackage.ul2;
/* loaded from: classes7.dex */
public interface tl2 extends ul2.b {
    qm1 A(String str);

    View B(String str);

    String C();

    i03 D();

    void E(fl2 fl2Var, cj2 cj2Var);

    wh1 F();

    @NonNull
    l83 G();

    qz1 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    zh1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    zh1 P();

    void a();

    String b();

    void c();

    void d(fl2 fl2Var, cj2 cj2Var);

    @NonNull
    x03 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    x03 f(String str);

    String g();

    SwanAppActivity getActivity();

    pm1 i();

    @NonNull
    x03 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ia2 ia2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    nm1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ia2 ia2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(la2 la2Var, boolean z);

    String z();
}
