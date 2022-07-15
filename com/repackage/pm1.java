package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.om1;
/* loaded from: classes6.dex */
public interface pm1<T extends om1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d I();

    @UiThread
    void P();

    void W(u12 u12Var);

    String b();

    void c(vy1 vy1Var);

    String d0();

    void destroy();

    void e(Activity activity);

    void g0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void r();

    T t();

    void u(u12 u12Var);
}
