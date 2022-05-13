package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.bn1;
/* loaded from: classes5.dex */
public interface cn1<T extends bn1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d J();

    @UiThread
    void Q();

    void X(h22 h22Var);

    String a();

    String c();

    void d(iz1 iz1Var);

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

    void v(h22 h22Var);
}
