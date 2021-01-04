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
/* loaded from: classes4.dex */
public class bj {
    private static final String java = bj.class.getSimpleName();
    private Context qbB;
    private Info qbW;
    private WebView qde;

    public bj(Context context) {
        this.qbB = context;
        if (this.qde != null) {
            return;
        }
        this.qde = new WebView(this.qbB);
        WebSettings settings = this.qde.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.qde.removeJavascriptInterface("searchBoxJavaBridge_");
            this.qde.removeJavascriptInterface("accessibility");
            this.qde.removeJavascriptInterface("accessibilityTraversal");
        }
        this.qde.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.qde.getSettings().setBlockNetworkImage(true);
        this.qde.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.qde.getSettings().setCacheMode(2);
        this.qde.getSettings().setAppCacheEnabled(true);
        this.qde.setScrollBarStyle(0);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(false);
        this.qde.clearCache(true);
        this.qde.clearHistory();
        this.qde.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.bj.1
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.qde.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bj.2
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
                bj.this.qde.setVisibility(8);
                if (str.contains("TIMED_OUT")) {
                    if (bj.this.qbW != null) {
                        w.iM(bj.this.qbB).a(new x(bj.this.qbW), 4).hu("desc", str + "&errcode:" + i + "&fileurl:" + str2).eJL();
                    }
                    Toast.makeText(bj.this.qbB, d.e.win_toast_network_error, 0).show();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public final void a(Info info) {
        this.qbW = info;
        if (this.qde != null) {
            this.qde.loadUrl(info.getOpen());
            this.qde.setDownloadListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (bj.this.qbW != null && bj.this.qbW.getOpent() == 1 && j > 10) {
                Context context = bj.this.qbB;
                Info info = bj.this.qbW;
                if (!av.iL(context)) {
                    Toast.makeText(context, context.getString(d.e.wdownload_no_netwrok) + info.getDl_name(), 0).show();
                    if (info != null) {
                        w.iM(context).a(new x(info), 1).eJL();
                        return;
                    }
                    return;
                }
                try {
                    if (bv.bK(context, info.getOpen()) && bv.a(context, info)) {
                        w.iM(context).e(new x(info), info.getOpen()).eJL();
                        bv.a(info, context, bv.bO(context, info.getOpen()));
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
                            w.iM(context).a(new x(info), 2).hu("desc", e2.getMessage()).eJL();
                        }
                    }
                }
            }
        }
    }
}
