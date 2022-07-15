package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface rh1 {
    SwanCoreVersion m();

    gd2 n(SwanAppActivity swanAppActivity, String str);

    p32 o(af3<Exception> af3Var);

    void p(Intent intent);

    View q(nz1 nz1Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    ta2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
