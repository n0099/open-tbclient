package com.kascend.chushou.widget.cswebview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.support.annotation.CallSuper;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class c extends WebViewClient {
    @Override // android.webkit.WebViewClient
    @CallSuper
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (a(webView, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str = null;
        if (sslError != null) {
            str = sslError.getUrl();
        }
        if (str != null && str.contains("kascend.com")) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    private static boolean a(WebView webView, String str) {
        boolean z;
        if (h.isEmpty(str) || webView == null) {
            return false;
        }
        if (str.startsWith("chushoutv")) {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } else if (str.startsWith("mqqwpa://im/chat")) {
            com.kascend.chushou.toolkit.a.a.a("20");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (tv.chushou.zues.utils.a.isIntentAvailable(webView.getContext(), intent)) {
                webView.getContext().startActivity(intent);
            }
            return true;
        } else if (str.startsWith("tel:")) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                Intent intent2 = new Intent("android.intent.action.DIAL", parse);
                if (tv.chushou.zues.utils.a.isIntentAvailable(webView.getContext(), intent2)) {
                    webView.getContext().startActivity(intent2);
                }
            }
            return true;
        } else {
            if (!h.isEmpty(com.kascend.chushou.d.h.dAK().f)) {
                for (int i = 0; i < com.kascend.chushou.d.h.dAK().f.size(); i++) {
                    if (str.toLowerCase().startsWith(com.kascend.chushou.d.h.dAK().f.get(i).toLowerCase())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.VIEW");
                intent3.setFlags(268435456);
                intent3.setData(Uri.parse(str));
                if (tv.chushou.zues.utils.a.isIntentAvailable(webView.getContext(), intent3)) {
                    webView.getContext().startActivity(intent3);
                }
                return true;
            }
            return false;
        }
    }
}
