package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface sh1 {
    SwanCoreVersion m();

    hd2 n(SwanAppActivity swanAppActivity, String str);

    q32 o(bf3<Exception> bf3Var);

    void p(Intent intent);

    View q(oz1 oz1Var);

    void r(V8ExceptionInfo v8ExceptionInfo);

    void release();

    ExtensionCore s();

    ua2 t();

    int u(String str, long j);

    void v(String str, boolean z);
}
