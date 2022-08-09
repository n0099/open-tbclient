package com.repackage;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.repackage.gn1;
/* loaded from: classes6.dex */
public interface hn1<T extends gn1> extends TypedCallbackHandler {
    SwanAppWebViewManager.d G();

    @UiThread
    void N();

    void U(m22 m22Var);

    String a();

    void attachActivity(Activity activity);

    void b(nz1 nz1Var);

    String b0();

    void destroy();

    void e0();

    String getUserAgent();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void p();

    T r();

    void s(m22 m22Var);
}
