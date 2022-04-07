package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.qm1;
/* loaded from: classes7.dex */
public interface rm1<T extends qm1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d J();

    @UiThread
    void Q();

    void X(w12 w12Var);

    String a();

    String c();

    void d(xy1 xy1Var);

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

    void v(w12 w12Var);
}
