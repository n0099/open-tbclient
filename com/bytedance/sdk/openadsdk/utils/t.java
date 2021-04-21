package com.bytedance.sdk.openadsdk.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30139a;

    /* loaded from: classes5.dex */
    public static class a {
        public a() {
        }

        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(19)
    /* loaded from: classes5.dex */
    public static class b extends a {
        public b() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.t.a
        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f30139a = new b();
        } else {
            f30139a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        f30139a.a(webView, str);
    }
}
