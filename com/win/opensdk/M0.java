package com.win.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public class M0 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public C0 f39722a;

    public M0(C0 c0, F0 f0) {
        this.f39722a = c0;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C0 c0 = this.f39722a;
        if (c0 == null || c0.getDispatcher() == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        ((A0) this.f39722a.getDispatcher()).a(str2, jsResult);
        return false;
    }
}
