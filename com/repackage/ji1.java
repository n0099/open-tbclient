package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes6.dex */
public interface ji1 {
    SwanCoreVersion m();

    yd2 n(SwanAppActivity swanAppActivity, String str);

    h42 o(sf3<Exception> sf3Var);

    void p(Intent intent);

    View q(f02 f02Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    lb2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
