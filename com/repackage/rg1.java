package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes7.dex */
public interface rg1 {
    SwanCoreVersion n();

    gc2 o(SwanAppActivity swanAppActivity, String str);

    p22 p(ae3<Exception> ae3Var);

    void q(Intent intent);

    View r(ny1 ny1Var);

    void release();

    void s(V8ExceptionInfo v8ExceptionInfo);

    ExtensionCore t();

    t92 u();

    int v(String str, long j);

    void w(String str, boolean z);
}
