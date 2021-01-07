package com.win.opensdk.webviewbase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.win.opensdk.be;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class AdvancedWebView extends WebView {
    protected static final String[] qdT = {"org.mozilla.firefox", "com.android.chrome", "com.opera.browser", "org.mozilla.firefox_beta", "com.chrome.beta", "com.opera.browser.beta"};

    /* renamed from: case  reason: not valid java name */
    protected String f82case;
    protected int java;

    /* renamed from: java  reason: collision with other field name */
    protected String f83java;
    protected long qdF;
    protected boolean qdm;
    protected final Map<String, String> qea;
    protected WeakReference<Activity> qed;
    protected final List<String> qen;
    protected WeakReference<Fragment> qfL;
    protected a qfM;
    protected ValueCallback<Uri> qfN;
    protected ValueCallback<Uri[]> qfO;
    protected WebViewClient qfP;
    protected WebChromeClient qfQ;

    /* loaded from: classes4.dex */
    public interface a {
        void abL(String str);

        void cc(int i, String str);

        void eKp();
    }

    public AdvancedWebView(Context context) {
        super(context);
        this.qen = new LinkedList();
        this.java = 51426;
        this.f82case = "*/*";
        this.qea = new HashMap();
        iK(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qen = new LinkedList();
        this.java = 51426;
        this.f82case = "*/*";
        this.qea = new HashMap();
        iK(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qen = new LinkedList();
        this.java = 51426;
        this.f82case = "*/*";
        this.qea = new HashMap();
        iK(context);
    }

    public final void a(Activity activity, a aVar) {
        this.qed = new WeakReference<>(activity);
        this.qfM = aVar;
        this.java = 51426;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.qfP = webViewClient;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.qfQ = webChromeClient;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setGeolocationEnabled(boolean z) {
        Activity activity;
        if (z) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setGeolocationEnabled(true);
            if (this.qfL != null && this.qfL.get() != null && Build.VERSION.SDK_INT >= 11 && this.qfL.get().getActivity() != null) {
                activity = this.qfL.get().getActivity();
            } else if (this.qed != null && this.qed.get() != null) {
                activity = this.qed.get();
            }
            getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
        }
        this.qdm = z;
    }

    public void setUploadableFileTypes(String str) {
        this.f82case = str;
    }

    @Override // android.webkit.WebView
    @SuppressLint({"NewApi"})
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
        resumeTimers();
    }

    @Override // android.webkit.WebView
    @SuppressLint({"NewApi"})
    public void onPause() {
        pauseTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    public final void d(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == this.java) {
            if (i2 == -1) {
                if (intent != null) {
                    if (this.qfN != null) {
                        this.qfN.onReceiveValue(intent.getData());
                        this.qfN = null;
                    } else if (this.qfO != null) {
                        try {
                            if (intent.getDataString() != null) {
                                uriArr = new Uri[]{Uri.parse(intent.getDataString())};
                            } else if (Build.VERSION.SDK_INT < 16 || intent.getClipData() == null) {
                                uriArr = null;
                            } else {
                                int itemCount = intent.getClipData().getItemCount();
                                uriArr = new Uri[itemCount];
                                for (int i3 = 0; i3 < itemCount; i3++) {
                                    try {
                                        uriArr[i3] = intent.getClipData().getItemAt(i3).getUri();
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            uriArr = null;
                        }
                        this.qfO.onReceiveValue(uriArr);
                        this.qfO = null;
                    }
                }
            } else if (this.qfN != null) {
                this.qfN.onReceiveValue(null);
                this.qfN = null;
            } else if (this.qfO != null) {
                this.qfO.onReceiveValue(null);
                this.qfO = null;
            }
        }
    }

    public List<String> getPermittedHostnames() {
        return this.qen;
    }

    @SuppressLint({"NewApi"})
    private static void setAllowAccessFromFileUrls$1ffbdba(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
    }

    public void setCookiesEnabled(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    @SuppressLint({"NewApi"})
    public void setThirdPartyCookiesEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, z);
        }
    }

    public void setMixedContentAllowed(boolean z) {
        WebSettings settings = getSettings();
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        settings.setMixedContentMode(z ? 0 : 1);
    }

    public void setDesktopMode(boolean z) {
        String replace;
        WebSettings settings = getSettings();
        if (z) {
            replace = settings.getUserAgentString().replace("Mobile", "eliboM").replace("Android", "diordnA");
        } else {
            replace = settings.getUserAgentString().replace("eliboM", "Mobile").replace("diordnA", "Android");
        }
        settings.setUserAgentString(replace);
        settings.setUseWideViewPort(z);
        settings.setLoadWithOverviewMode(z);
        settings.setSupportZoom(z);
        settings.setBuiltInZoomControls(z);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void iK(final Context context) {
        if (!isInEditMode()) {
            if (context instanceof Activity) {
                this.qed = new WeakReference<>((Activity) context);
            }
            this.f83java = getLanguageIso3();
            setFocusable(true);
            setFocusableInTouchMode(true);
            setSaveEnabled(true);
            String path = context.getFilesDir().getPath();
            String str = path.substring(0, path.lastIndexOf("/")) + "/databases";
            WebSettings settings = getSettings();
            settings.setAllowFileAccess(false);
            setAllowAccessFromFileUrls$1ffbdba(settings);
            settings.setBuiltInZoomControls(false);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            if (Build.VERSION.SDK_INT < 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            settings.setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT < 19) {
                settings.setDatabasePath(str);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            setThirdPartyCookiesEnabled(true);
            super.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.webviewbase.AdvancedWebView.1
                @Override // android.webkit.WebViewClient
                public final void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    if (!AdvancedWebView.this.java() && AdvancedWebView.this.qfM != null) {
                        AdvancedWebView.this.qfM.eKp();
                    }
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onPageStarted(webView, str2, bitmap);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str2) {
                    if (!AdvancedWebView.this.java() && AdvancedWebView.this.qfM != null) {
                        AdvancedWebView.this.qfM.abL(str2);
                    }
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onPageFinished(webView, str2);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void onReceivedError(WebView webView, int i, String str2, String str3) {
                    AdvancedWebView.this.eKp();
                    if (AdvancedWebView.this.qfM != null) {
                        AdvancedWebView.this.qfM.cc(i, str3);
                    }
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onReceivedError(webView, i, str2, str3);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    if (AdvancedWebView.this.abK(str2) && (AdvancedWebView.this.qfP == null || !AdvancedWebView.this.qfP.shouldOverrideUrlLoading(webView, str2))) {
                        Uri parse = Uri.parse(str2);
                        String scheme = parse.getScheme();
                        if ((TextUtils.isEmpty(scheme) || scheme.equals(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equals("https")) ? false : true) {
                            try {
                                be.j(context, parse);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            webView.loadUrl(str2);
                        }
                    }
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public final void onLoadResource(WebView webView, String str2) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onLoadResource(webView, str2);
                    } else {
                        super.onLoadResource(webView, str2);
                    }
                }

                @Override // android.webkit.WebViewClient
                @SuppressLint({"NewApi"})
                public final WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                    if (Build.VERSION.SDK_INT >= 11) {
                        if (AdvancedWebView.this.qfP != null) {
                            return AdvancedWebView.this.qfP.shouldInterceptRequest(webView, str2);
                        }
                        return super.shouldInterceptRequest(webView, str2);
                    }
                    return null;
                }

                @Override // android.webkit.WebViewClient
                @SuppressLint({"NewApi"})
                public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (AdvancedWebView.this.qfP != null) {
                            return AdvancedWebView.this.qfP.shouldInterceptRequest(webView, webResourceRequest);
                        }
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    }
                    return null;
                }

                @Override // android.webkit.WebViewClient
                public final void onFormResubmission(WebView webView, Message message, Message message2) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onFormResubmission(webView, message, message2);
                    } else {
                        super.onFormResubmission(webView, message, message2);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void doUpdateVisitedHistory(WebView webView, String str2, boolean z) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.doUpdateVisitedHistory(webView, str2, z);
                    } else {
                        super.doUpdateVisitedHistory(webView, str2, z);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onReceivedSslError(webView, sslErrorHandler, sslError);
                    } else {
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    }
                }

                @Override // android.webkit.WebViewClient
                @SuppressLint({"NewApi"})
                public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (AdvancedWebView.this.qfP != null) {
                            AdvancedWebView.this.qfP.onReceivedClientCertRequest(webView, clientCertRequest);
                        } else {
                            super.onReceivedClientCertRequest(webView, clientCertRequest);
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str2, String str3) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onReceivedHttpAuthRequest(webView, httpAuthHandler, str2, str3);
                    } else {
                        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str2, str3);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
                    return AdvancedWebView.this.qfP != null ? AdvancedWebView.this.qfP.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
                }

                @Override // android.webkit.WebViewClient
                public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onUnhandledKeyEvent(webView, keyEvent);
                    } else {
                        super.onUnhandledKeyEvent(webView, keyEvent);
                    }
                }

                @Override // android.webkit.WebViewClient
                public final void onScaleChanged(WebView webView, float f, float f2) {
                    if (AdvancedWebView.this.qfP != null) {
                        AdvancedWebView.this.qfP.onScaleChanged(webView, f, f2);
                    } else {
                        super.onScaleChanged(webView, f, f2);
                    }
                }

                @Override // android.webkit.WebViewClient
                @SuppressLint({"NewApi"})
                public final void onReceivedLoginRequest(WebView webView, String str2, String str3, String str4) {
                    if (Build.VERSION.SDK_INT >= 12) {
                        if (AdvancedWebView.this.qfP != null) {
                            AdvancedWebView.this.qfP.onReceivedLoginRequest(webView, str2, str3, str4);
                        } else {
                            super.onReceivedLoginRequest(webView, str2, str3, str4);
                        }
                    }
                }
            });
            super.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.webviewbase.AdvancedWebView.2
                @Override // android.webkit.WebChromeClient
                public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        AdvancedWebView.this.a(valueCallback, fileChooserParams.getMode() == 1);
                        return true;
                    }
                    return false;
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView, int i) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onProgressChanged(webView, i);
                    } else {
                        super.onProgressChanged(webView, i);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str2) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onReceivedTitle(webView, str2);
                    } else {
                        super.onReceivedTitle(webView, str2);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onReceivedIcon(webView, bitmap);
                    } else {
                        super.onReceivedIcon(webView, bitmap);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onReceivedTouchIconUrl(WebView webView, String str2, boolean z) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onReceivedTouchIconUrl(webView, str2, z);
                    } else {
                        super.onReceivedTouchIconUrl(webView, str2, z);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onShowCustomView(view, customViewCallback);
                    } else {
                        super.onShowCustomView(view, customViewCallback);
                    }
                }

                @Override // android.webkit.WebChromeClient
                @SuppressLint({"NewApi"})
                public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        if (AdvancedWebView.this.qfQ != null) {
                            AdvancedWebView.this.qfQ.onShowCustomView(view, i, customViewCallback);
                        } else {
                            super.onShowCustomView(view, i, customViewCallback);
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onHideCustomView() {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onHideCustomView();
                    } else {
                        super.onHideCustomView();
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
                }

                @Override // android.webkit.WebChromeClient
                public final void onRequestFocus(WebView webView) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onRequestFocus(webView);
                    } else {
                        super.onRequestFocus(webView);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onCloseWindow(WebView webView) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onCloseWindow(webView);
                    } else {
                        super.onCloseWindow(webView);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsAlert(WebView webView, String str2, String str3, JsResult jsResult) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onJsAlert(webView, str2, str3, jsResult) : super.onJsAlert(webView, str2, str3, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsConfirm(WebView webView, String str2, String str3, JsResult jsResult) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onJsConfirm(webView, str2, str3, jsResult) : super.onJsConfirm(webView, str2, str3, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsPrompt(WebView webView, String str2, String str3, String str4, JsPromptResult jsPromptResult) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onJsPrompt(webView, str2, str3, str4, jsPromptResult) : super.onJsPrompt(webView, str2, str3, str4, jsPromptResult);
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsBeforeUnload(WebView webView, String str2, String str3, JsResult jsResult) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onJsBeforeUnload(webView, str2, str3, jsResult) : super.onJsBeforeUnload(webView, str2, str3, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public final void onGeolocationPermissionsShowPrompt(String str2, GeolocationPermissions.Callback callback) {
                    if (AdvancedWebView.this.qdm) {
                        callback.invoke(str2, true, false);
                    } else if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onGeolocationPermissionsShowPrompt(str2, callback);
                    } else {
                        super.onGeolocationPermissionsShowPrompt(str2, callback);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onGeolocationPermissionsHidePrompt() {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onGeolocationPermissionsHidePrompt();
                    } else {
                        super.onGeolocationPermissionsHidePrompt();
                    }
                }

                @Override // android.webkit.WebChromeClient
                @SuppressLint({"NewApi"})
                public final void onPermissionRequest(PermissionRequest permissionRequest) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (AdvancedWebView.this.qfQ != null) {
                            AdvancedWebView.this.qfQ.onPermissionRequest(permissionRequest);
                        } else {
                            super.onPermissionRequest(permissionRequest);
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                @SuppressLint({"NewApi"})
                public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (AdvancedWebView.this.qfQ != null) {
                            AdvancedWebView.this.qfQ.onPermissionRequestCanceled(permissionRequest);
                        } else {
                            super.onPermissionRequestCanceled(permissionRequest);
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsTimeout() {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onJsTimeout() : super.onJsTimeout();
                }

                @Override // android.webkit.WebChromeClient
                public final void onConsoleMessage(String str2, int i, String str3) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onConsoleMessage(str2, i, str3);
                    } else {
                        super.onConsoleMessage(str2, i, str3);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
                }

                @Override // android.webkit.WebChromeClient
                public final Bitmap getDefaultVideoPoster() {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.getDefaultVideoPoster() : super.getDefaultVideoPoster();
                }

                @Override // android.webkit.WebChromeClient
                public final View getVideoLoadingProgressView() {
                    return AdvancedWebView.this.qfQ != null ? AdvancedWebView.this.qfQ.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
                }

                @Override // android.webkit.WebChromeClient
                public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.getVisitedHistory(valueCallback);
                    } else {
                        super.getVisitedHistory(valueCallback);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onExceededDatabaseQuota(String str2, String str3, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onExceededDatabaseQuota(str2, str3, j, j2, j3, quotaUpdater);
                    } else {
                        super.onExceededDatabaseQuota(str2, str3, j, j2, j3, quotaUpdater);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                    if (AdvancedWebView.this.qfQ != null) {
                        AdvancedWebView.this.qfQ.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
                    } else {
                        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
                    }
                }
            });
            setDownloadListener(new DownloadListener() { // from class: com.win.opensdk.webviewbase.AdvancedWebView.3
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    URLUtil.guessFileName(str2, str4, str5);
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (map == null) {
            map = this.qea;
        } else if (this.qea.size() > 0) {
            map.putAll(this.qea);
        }
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.qea.size() > 0) {
            super.loadUrl(str, this.qea);
        } else {
            super.loadUrl(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean abK(String str) {
        if (this.qen.size() == 0) {
            return true;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
            String userInfo = parse.getUserInfo();
            if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                for (String str2 : this.qen) {
                    if (host.equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                        return true;
                    }
                    while (r4.hasNext()) {
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    protected final void eKp() {
        this.qdF = System.currentTimeMillis();
    }

    protected final boolean java() {
        return this.qdF + 500 >= System.currentTimeMillis();
    }

    protected static String getLanguageIso3() {
        try {
            return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
        } catch (MissingResourceException e) {
            return "eng";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x01da -> B:5:0x0012). Please submit an issue!!! */
    protected String getFileUploadPromptLabel() {
        if (this.f83java.equals("zho")) {
            return abO("6YCJ5oup5LiA5Liq5paH5Lu2");
        } else if (this.f83java.equals("spa")) {
            return abO("RWxpamEgdW4gYXJjaGl2bw==");
        } else {
            if (this.f83java.equals("hin")) {
                return abO("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=");
            }
            if (this.f83java.equals("ben")) {
                return abO("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=");
            }
            if (this.f83java.equals("ara")) {
                return abO("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==");
            }
            if (this.f83java.equals("por")) {
                return abO("RXNjb2xoYSB1bSBhcnF1aXZv");
            }
            if (this.f83java.equals("rus")) {
                return abO("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==");
            }
            if (this.f83java.equals("jpn")) {
                return abO("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==");
            }
            if (this.f83java.equals("pan")) {
                return abO("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=");
            }
            if (this.f83java.equals("deu")) {
                return abO("V8OkaGxlIGVpbmUgRGF0ZWk=");
            }
            if (this.f83java.equals("jav")) {
                return abO("UGlsaWggc2lqaSBiZXJrYXM=");
            }
            if (this.f83java.equals("msa")) {
                return abO("UGlsaWggc2F0dSBmYWls");
            }
            if (this.f83java.equals("tel")) {
                return abO("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=");
            }
            if (this.f83java.equals("vie")) {
                return abO("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==");
            }
            if (this.f83java.equals("kor")) {
                return abO("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=");
            }
            if (this.f83java.equals("fra")) {
                return abO("Q2hvaXNpc3NleiB1biBmaWNoaWVy");
            }
            if (this.f83java.equals("mar")) {
                return abO("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==");
            }
            if (this.f83java.equals("tam")) {
                return abO("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=");
            }
            if (this.f83java.equals("urd")) {
                return abO("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==");
            }
            if (this.f83java.equals("fas")) {
                return abO("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==");
            }
            if (this.f83java.equals("tur")) {
                return abO("QmlyIGRvc3lhIHNlw6dpbg==");
            }
            if (this.f83java.equals("ita")) {
                return abO("U2NlZ2xpIHVuIGZpbGU=");
            }
            if (this.f83java.equals("tha")) {
                return abO("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH");
            }
            if (this.f83java.equals("guj")) {
                return abO("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=");
            }
            return "Choose a file";
        }
    }

    private static String abO(String str) {
        return new String(Base64.decode(str, 0), "UTF-8");
    }

    @SuppressLint({"NewApi"})
    protected final void a(ValueCallback<Uri[]> valueCallback, boolean z) {
        if (this.qfN != null) {
            this.qfN.onReceiveValue(null);
        }
        this.qfN = null;
        if (this.qfO != null) {
            this.qfO.onReceiveValue(null);
        }
        this.qfO = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (z && Build.VERSION.SDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.setType(this.f82case);
        if (this.qfL != null && this.qfL.get() != null && Build.VERSION.SDK_INT >= 11) {
            this.qfL.get().startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.java);
        } else if (this.qed != null && this.qed.get() != null) {
            this.qed.get().startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.java);
        }
    }
}
