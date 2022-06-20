package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface ch1 {
    SwanCoreVersion n();

    rc2 o(SwanAppActivity swanAppActivity, String str);

    a32 p(le3<Exception> le3Var);

    void q(Intent intent);

    View r(yy1 yy1Var);

    void release();

    void s(V8ExceptionInfo v8ExceptionInfo);

    ExtensionCore t();

    ea2 u();

    int v(String str, long j);

    void w(String str, boolean z);
}
