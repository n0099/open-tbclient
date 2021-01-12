package com.bytedance.sdk.openadsdk.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final a f7600a;

    /* loaded from: classes4.dex */
    private static class a {
        private a() {
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                try {
                    webView.loadUrl(str);
                } catch (Throwable th) {
                }
            }
        }
    }

    @TargetApi(19)
    /* loaded from: classes4.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.t.a
        public void a(WebView webView, String str) {
            boolean z = false;
            if (webView != null) {
                if (str != null && str.startsWith("javascript:")) {
                    try {
                        webView.evaluateJavascript(str, null);
                        z = true;
                    } catch (Throwable th) {
                        if (th instanceof IllegalStateException) {
                        }
                    }
                }
                if (!z) {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable th2) {
                    }
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f7600a = new b();
        } else {
            f7600a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        f7600a.a(webView, str);
    }
}
