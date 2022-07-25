package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.pm1;
/* loaded from: classes7.dex */
public interface qm1<T extends pm1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d I();

    @UiThread
    void P();

    void W(v12 v12Var);

    String b();

    void c(wy1 wy1Var);

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

    void u(v12 v12Var);
}
