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
    private Context pYJ;
    private Info pZe;
    private WebView qam;

    public bj(Context context) {
        this.pYJ = context;
        if (this.qam != null) {
            return;
        }
        this.qam = new WebView(this.pYJ);
        WebSettings settings = this.qam.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.qam.removeJavascriptInterface("searchBoxJavaBridge_");
            this.qam.removeJavascriptInterface("accessibility");
            this.qam.removeJavascriptInterface("accessibilityTraversal");
        }
        this.qam.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.qam.getSettings().setBlockNetworkImage(true);
        this.qam.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.qam.getSettings().setCacheMode(2);
        this.qam.getSettings().setAppCacheEnabled(true);
        this.qam.setScrollBarStyle(0);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(false);
        this.qam.clearCache(true);
        this.qam.clearHistory();
        this.qam.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.bj.1
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.qam.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bj.2
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
                bj.this.qam.setVisibility(8);
                if (str.contains("TIMED_OUT")) {
                    if (bj.this.pZe != null) {
                        w.iK(bj.this.pYJ).a(new x(bj.this.pZe), 4).hu("desc", str + "&errcode:" + i + "&fileurl:" + str2).eGz();
                    }
                    Toast.makeText(bj.this.pYJ, d.e.win_toast_network_error, 0).show();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public final void a(Info info) {
        this.pZe = info;
        if (this.qam != null) {
            this.qam.loadUrl(info.getOpen());
            this.qam.setDownloadListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (bj.this.pZe != null && bj.this.pZe.getOpent() == 1 && j > 10) {
                Context context = bj.this.pYJ;
                Info info = bj.this.pZe;
                if (!av.iJ(context)) {
                    Toast.makeText(context, context.getString(d.e.wdownload_no_netwrok) + info.getDl_name(), 0).show();
                    if (info != null) {
                        w.iK(context).a(new x(info), 1).eGz();
                        return;
                    }
                    return;
                }
                try {
                    if (bv.bK(context, info.getOpen()) && bv.a(context, info)) {
                        w.iK(context).e(new x(info), info.getOpen()).eGz();
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
                            w.iK(context).a(new x(info), 2).hu("desc", e2.getMessage()).eGz();
                        }
                    }
                }
            }
        }
    }
}
