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
import com.repackage.vl2;
/* loaded from: classes7.dex */
public interface ul2 extends vl2.b {
    rm1 A(String str);

    View B(String str);

    String C();

    j03 D();

    void E(gl2 gl2Var, dj2 dj2Var);

    xh1 F();

    @NonNull
    m83 G();

    rz1 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    ai1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    ai1 P();

    void a();

    String b();

    void c();

    void d(gl2 gl2Var, dj2 dj2Var);

    @NonNull
    y03 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    y03 f(String str);

    String g();

    SwanAppActivity getActivity();

    qm1 i();

    @NonNull
    y03 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ja2 ja2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    om1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ja2 ja2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(ma2 ma2Var, boolean z);

    String z();
}
