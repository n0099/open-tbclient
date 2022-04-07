package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface th1 {
    SwanCoreVersion n();

    id2 o(SwanAppActivity swanAppActivity, String str);

    r32 p(cf3<Exception> cf3Var);

    void q(Intent intent);

    View r(pz1 pz1Var);

    void release();

    void s(V8ExceptionInfo v8ExceptionInfo);

    ExtensionCore t();

    va2 u();

    int v(String str, long j);

    void w(String str, boolean z);
}
