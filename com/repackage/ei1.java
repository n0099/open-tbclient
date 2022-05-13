package com.repackage;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes5.dex */
public interface ei1 {
    SwanCoreVersion n();

    td2 o(SwanAppActivity swanAppActivity, String str);

    c42 p(nf3<Exception> nf3Var);

    void q(Intent intent);

    View r(a02 a02Var);

    void release();

    void s(V8ExceptionInfo v8ExceptionInfo);

    ExtensionCore t();

    gb2 u();

    int v(String str, long j);

    void w(String str, boolean z);
}
