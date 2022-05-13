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
import com.repackage.gm2;
/* loaded from: classes6.dex */
public interface fm2 extends gm2.b {
    cn1 A(String str);

    View B(String str);

    String C();

    u03 D();

    void E(rl2 rl2Var, oj2 oj2Var);

    ii1 F();

    @NonNull
    x83 G();

    c02 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    li1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    li1 P();

    void a();

    String b();

    void c();

    void d(rl2 rl2Var, oj2 oj2Var);

    @NonNull
    j13 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    j13 f(String str);

    String g();

    SwanAppActivity getActivity();

    bn1 i();

    @NonNull
    j13 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, ua2 ua2Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    zm1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(ua2 ua2Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(xa2 xa2Var, boolean z);

    String z();
}
