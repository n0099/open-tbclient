package com.kwad.sdk.core.page.widget.webview;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* loaded from: classes5.dex */
public class a extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (webView instanceof b) {
                if (((b) webView).a(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        try {
            if (webView instanceof b) {
                ((b) webView).a(webView);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }
}
