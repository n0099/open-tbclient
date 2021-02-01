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
    private Context qiN;
    private Info qji;
    private WebView qkq;

    public bj(Context context) {
        this.qiN = context;
        if (this.qkq != null) {
            return;
        }
        this.qkq = new WebView(this.qiN);
        WebSettings settings = this.qkq.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.qkq.removeJavascriptInterface("searchBoxJavaBridge_");
            this.qkq.removeJavascriptInterface("accessibility");
            this.qkq.removeJavascriptInterface("accessibilityTraversal");
        }
        this.qkq.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.qkq.getSettings().setBlockNetworkImage(true);
        this.qkq.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.qkq.getSettings().setCacheMode(2);
        this.qkq.getSettings().setAppCacheEnabled(true);
        this.qkq.setScrollBarStyle(0);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(false);
        this.qkq.clearCache(true);
        this.qkq.clearHistory();
        this.qkq.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.bj.1
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.qkq.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bj.2
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
                bj.this.qkq.setVisibility(8);
                if (str.contains("TIMED_OUT")) {
                    if (bj.this.qji != null) {
                        w.iN(bj.this.qiN).a(new x(bj.this.qji), 4).hB("desc", str + "&errcode:" + i + "&fileurl:" + str2).eIP();
                    }
                    Toast.makeText(bj.this.qiN, d.e.win_toast_network_error, 0).show();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public final void a(Info info) {
        this.qji = info;
        if (this.qkq != null) {
            this.qkq.loadUrl(info.getOpen());
            this.qkq.setDownloadListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (bj.this.qji != null && bj.this.qji.getOpent() == 1 && j > 10) {
                Context context = bj.this.qiN;
                Info info = bj.this.qji;
                if (!av.iM(context)) {
                    Toast.makeText(context, context.getString(d.e.wdownload_no_netwrok) + info.getDl_name(), 0).show();
                    if (info != null) {
                        w.iN(context).a(new x(info), 1).eIP();
                        return;
                    }
                    return;
                }
                try {
                    if (bv.bJ(context, info.getOpen()) && bv.a(context, info)) {
                        w.iN(context).e(new x(info), info.getOpen()).eIP();
                        bv.a(info, context, bv.bN(context, info.getOpen()));
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
                            w.iN(context).a(new x(info), 2).hB("desc", e2.getMessage()).eIP();
                        }
                    }
                }
            }
        }
    }
}
