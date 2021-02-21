package com.win.opensdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import com.win.opensdk.downloader.WDownLoadService;
/* loaded from: classes3.dex */
public class bj {
    private static final String java = bj.class.getSimpleName();
    private Info qjI;
    private Context qjn;
    private WebView qkQ;

    public bj(Context context) {
        this.qjn = context;
        if (this.qkQ != null) {
            return;
        }
        this.qkQ = new WebView(this.qjn);
        WebSettings settings = this.qkQ.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.qkQ.removeJavascriptInterface("searchBoxJavaBridge_");
            this.qkQ.removeJavascriptInterface("accessibility");
            this.qkQ.removeJavascriptInterface("accessibilityTraversal");
        }
        this.qkQ.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.qkQ.getSettings().setBlockNetworkImage(true);
        this.qkQ.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.qkQ.getSettings().setCacheMode(2);
        this.qkQ.getSettings().setAppCacheEnabled(true);
        this.qkQ.setScrollBarStyle(0);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(false);
        this.qkQ.clearCache(true);
        this.qkQ.clearHistory();
        this.qkQ.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.bj.1
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.qkQ.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bj.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                bj.this.qkQ.setVisibility(8);
                if (str.contains("TIMED_OUT")) {
                    if (bj.this.qjI != null) {
                        w.iN(bj.this.qjn).a(new x(bj.this.qjI), 4).hD("desc", str + "&errcode:" + i + "&fileurl:" + str2).eIX();
                    }
                    Toast.makeText(bj.this.qjn, d.e.win_toast_network_error, 0).show();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public final void a(Info info) {
        this.qjI = info;
        if (this.qkQ != null) {
            this.qkQ.loadUrl(info.getOpen());
            this.qkQ.setDownloadListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (bj.this.qjI != null && bj.this.qjI.getOpent() == 1 && j > 10) {
                Context context = bj.this.qjn;
                Info info = bj.this.qjI;
                if (!av.iM(context)) {
                    Toast.makeText(context, context.getString(d.e.wdownload_no_netwrok) + info.getDl_name(), 0).show();
                    if (info != null) {
                        w.iN(context).a(new x(info), 1).eIX();
                        return;
                    }
                    return;
                }
                try {
                    if (bv.bI(context, info.getOpen()) && bv.a(context, info)) {
                        w.iN(context).e(new x(info), info.getOpen()).eIX();
                        bv.a(info, context, bv.bM(context, info.getOpen()));
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (info != null) {
                    try {
                        if (TextUtils.isEmpty(info.getOpen())) {
                            return;
                        }
                        az.a(context, info.getDl_pkg(), info);
                        Intent intent = new Intent(context, WDownLoadService.class);
                        intent.putExtra("down_load_apk_url", info.getOpen());
                        intent.putExtra("down_load_pkg_name", info.getDl_pkg());
                        context.startService(intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (info != null) {
                            w.iN(context).a(new x(info), 2).hD("desc", e2.getMessage()).eIX();
                        }
                    }
                }
            }
        }
    }
}
