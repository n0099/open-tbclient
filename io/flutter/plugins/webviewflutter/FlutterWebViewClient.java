package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.webkit.b;
import androidx.webkit.c;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
class FlutterWebViewClient {
    private static final String TAG = "FlutterWebViewClient";
    private boolean hasNavigationDelegate;
    private final MethodChannel methodChannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlutterWebViewClient(MethodChannel methodChannel) {
        this.methodChannel = methodChannel;
    }

    private static String errorCodeToString(int i) {
        switch (i) {
            case -16:
                return "unsafeResource";
            case -15:
                return "tooManyRequests";
            case -14:
                return "fileNotFound";
            case -13:
                return "file";
            case -12:
                return "badUrl";
            case -11:
                return "failedSslHandshake";
            case -10:
                return "unsupportedScheme";
            case -9:
                return "redirectLoop";
            case -8:
                return "timeout";
            case -7:
                return "io";
            case -6:
                return "connect";
            case -5:
                return "proxyAuthentication";
            case -4:
                return "authentication";
            case -3:
                return "unsupportedAuthScheme";
            case -2:
                return "hostLookup";
            case -1:
                return "unknown";
            default:
                throw new IllegalArgumentException(String.format(Locale.getDefault(), "Could not find a string for errorCode: %d", Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.hasNavigationDelegate) {
            return false;
        }
        notifyOnNavigationRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders(), webView, webResourceRequest.isForMainFrame());
        return webResourceRequest.isForMainFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.hasNavigationDelegate) {
            return false;
        }
        Log.w(TAG, "Using a navigationDelegate with an old webview implementation, pages with frames or iframes will not work");
        notifyOnNavigationRequest(str, null, webView, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageStarted(WebView webView, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.methodChannel.invokeMethod("onPageStarted", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageFinished(WebView webView, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.methodChannel.invokeMethod("onPageFinished", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebResourceError(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TiebaInitialize.LogFields.ERROR_CODE, Integer.valueOf(i));
        hashMap.put("description", str);
        hashMap.put("errorType", errorCodeToString(i));
        hashMap.put("failingUrl", str2);
        this.methodChannel.invokeMethod("onWebResourceError", hashMap);
    }

    private void notifyOnNavigationRequest(String str, Map<String, String> map, WebView webView, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("isForMainFrame", Boolean.valueOf(z));
        if (z) {
            this.methodChannel.invokeMethod("navigationRequest", hashMap, new OnNavigationRequestResult(str, map, webView));
        } else {
            this.methodChannel.invokeMethod("navigationRequest", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewClient createWebViewClient(boolean z) {
        this.hasNavigationDelegate = z;
        return (!z || Build.VERSION.SDK_INT >= 24) ? internalCreateWebViewClient() : internalCreateWebViewClientCompat();
    }

    private WebViewClient internalCreateWebViewClient() {
        return new WebViewClient() { // from class: io.flutter.plugins.webviewflutter.FlutterWebViewClient.1
            @Override // android.webkit.WebViewClient
            @TargetApi(24)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return FlutterWebViewClient.this.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                FlutterWebViewClient.this.onPageStarted(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                FlutterWebViewClient.this.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                FlutterWebViewClient.this.onWebResourceError(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                FlutterWebViewClient.this.onWebResourceError(i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            }
        };
    }

    private c internalCreateWebViewClientCompat() {
        return new c() { // from class: io.flutter.plugins.webviewflutter.FlutterWebViewClient.2
            @Override // androidx.webkit.c, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return FlutterWebViewClient.this.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return FlutterWebViewClient.this.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                FlutterWebViewClient.this.onPageStarted(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                FlutterWebViewClient.this.onPageFinished(webView, str);
            }

            @Override // androidx.webkit.c
            @RequiresApi(api = 21)
            @SuppressLint({"RequiresFeature"})
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, b bVar) {
                FlutterWebViewClient.this.onWebResourceError(bVar.getErrorCode(), bVar.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                FlutterWebViewClient.this.onWebResourceError(i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class OnNavigationRequestResult implements MethodChannel.Result {
        private final Map<String, String> headers;
        private final String url;
        private final WebView webView;

        private OnNavigationRequestResult(String str, Map<String, String> map, WebView webView) {
            this.url = str;
            this.headers = map;
            this.webView = webView;
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                loadUrl();
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(String str, String str2, Object obj) {
            throw new IllegalStateException("navigationRequest calls must succeed");
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            throw new IllegalStateException("navigationRequest must be implemented by the webview method channel");
        }

        private void loadUrl() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.webView.loadUrl(this.url, this.headers);
            } else {
                this.webView.loadUrl(this.url);
            }
        }
    }
}
