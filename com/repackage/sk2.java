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
import com.repackage.tk2;
/* loaded from: classes7.dex */
public interface sk2 extends tk2.b {
    pl1 A(String str);

    View B(String str);

    String C();

    hz2 D();

    void E(ek2 ek2Var, bi2 bi2Var);

    vg1 F();

    @NonNull
    k73 G();

    py1 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    yg1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    yg1 P();

    void a();

    String b();

    void c();

    void d(ek2 ek2Var, bi2 bi2Var);

    @NonNull
    wz2 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    wz2 f(String str);

    String g();

    SwanAppActivity getActivity();

    ol1 i();

    @NonNull
    wz2 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, h92 h92Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    ml1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(h92 h92Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(k92 k92Var, boolean z);

    String z();
}
