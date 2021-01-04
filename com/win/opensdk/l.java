package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes4.dex */
final class l extends WebChromeClient {
    private y qcd;
    private h qch;

    public l(y yVar, h hVar) {
        this.qcd = yVar;
        this.qch = hVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.qcd == null || this.qcd.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        this.qcd.getDispatcher();
        return false;
    }
}
