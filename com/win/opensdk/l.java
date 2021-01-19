package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes3.dex */
final class l extends WebChromeClient {
    private y pZl;
    private h pZp;

    public l(y yVar, h hVar) {
        this.pZl = yVar;
        this.pZp = hVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.pZl == null || this.pZl.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        this.pZl.getDispatcher();
        return false;
    }
}
