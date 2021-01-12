package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes3.dex */
final class l extends WebChromeClient {
    private y pZk;
    private h pZo;

    public l(y yVar, h hVar) {
        this.pZk = yVar;
        this.pZo = hVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.pZk == null || this.pZk.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        this.pZk.getDispatcher();
        return false;
    }
}
