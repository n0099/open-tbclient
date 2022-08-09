package com.repackage;

import android.view.View;
import android.webkit.ValueCallback;
/* loaded from: classes6.dex */
public interface gn1 extends xz1 {
    boolean canGoBack();

    View covertToView();

    void destroy();

    @Override // com.repackage.xz1
    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i, int i2, String str);

    void webViewScrollTo(int i, int i2);
}
