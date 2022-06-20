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
import com.repackage.el2;
/* loaded from: classes5.dex */
public interface dl2 extends el2.b {
    am1 A(String str);

    View B(String str);

    String C();

    sz2 D();

    void E(pk2 pk2Var, mi2 mi2Var);

    gh1 F();

    @NonNull
    v73 G();

    az1 H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    jh1 L();

    SwanCoreVersion M();

    boolean N();

    void O();

    jh1 P();

    void a();

    String b();

    void c();

    void d(pk2 pk2Var, mi2 mi2Var);

    @NonNull
    h03 e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    h03 f(String str);

    String g();

    SwanAppActivity getActivity();

    zl1 i();

    @NonNull
    h03 j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, s92 s92Var);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    xl1 q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(s92 s92Var);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(v92 v92Var, boolean z);

    String z();
}
