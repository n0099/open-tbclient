package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.zl1;
/* loaded from: classes5.dex */
public interface am1<T extends zl1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d J();

    @UiThread
    void Q();

    void X(f12 f12Var);

    String a();

    String c();

    void d(gy1 gy1Var);

    void destroy();

    String e0();

    void f(Activity activity);

    void h0();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void s();

    T u();

    void v(f12 f12Var);
}
