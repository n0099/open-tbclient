package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes4.dex */
final class l extends WebChromeClient {
    private y qdL;
    private h qdP;

    public l(y yVar, h hVar) {
        this.qdL = yVar;
        this.qdP = hVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.qdL == null || this.qdL.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        this.qdL.getDispatcher();
        return false;
    }
}
