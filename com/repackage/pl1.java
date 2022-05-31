package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.ol1;
/* loaded from: classes6.dex */
public interface pl1<T extends ol1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d J();

    @UiThread
    void Q();

    void X(u02 u02Var);

    String a();

    String c();

    void d(vx1 vx1Var);

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

    void v(u02 u02Var);
}
