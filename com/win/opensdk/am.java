package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes14.dex */
public class am extends WebChromeClient {
    public C0 qkf;

    public am(C0 c0, t tVar) {
        this.qkf = c0;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C0 c0 = this.qkf;
        if (c0 == null || c0.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        ((e) this.qkf.getDispatcher()).b(str2, jsResult);
        return false;
    }
}
