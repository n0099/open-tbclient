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
    private Info qdE;
    private Context qdj;
    private WebView qeM;

    public bj(Context context) {
        this.qdj = context;
        if (this.qeM != null) {
            return;
        }
        this.qeM = new WebView(this.qdj);
        WebSettings settings = this.qeM.getSettings();
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.qeM.removeJavascriptInterface("searchBoxJavaBridge_");
            this.qeM.removeJavascriptInterface("accessibility");
            this.qeM.removeJavascriptInterface("accessibilityTraversal");
        }
        this.qeM.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.qeM.getSettings().setBlockNetworkImage(true);
        this.qeM.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.qeM.getSettings().setCacheMode(2);
        this.qeM.getSettings().setAppCacheEnabled(true);
        this.qeM.setScrollBarStyle(0);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(false);
        this.qeM.clearCache(true);
        this.qeM.clearHistory();
        this.qeM.setWebChromeClient(new WebChromeClient() { // from class: com.win.opensdk.bj.1
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.qeM.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bj.2
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
                bj.this.qeM.setVisibility(8);
                if (str.contains("TIMED_OUT")) {
                    if (bj.this.qdE != null) {
                        w.iM(bj.this.qdj).a(new x(bj.this.qdE), 4).hv("desc", str + "&errcode:" + i + "&fileurl:" + str2).eKp();
                    }
                    Toast.makeText(bj.this.qdj, d.e.win_toast_network_error, 0).show();
                }
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(11)
    public final void a(Info info) {
        this.qdE = info;
        if (this.qeM != null) {
            this.qeM.loadUrl(info.getOpen());
            this.qeM.setDownloadListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (bj.this.qdE != null && bj.this.qdE.getOpent() == 1 && j > 10) {
                Context context = bj.this.qdj;
                Info info = bj.this.qdE;
                if (!av.iL(context)) {
                    Toast.makeText(context, context.getString(d.e.wdownload_no_netwrok) + info.getDl_name(), 0).show();
                    if (info != null) {
                        w.iM(context).a(new x(info), 1).eKp();
                        return;
                    }
                    return;
                }
                try {
                    if (bv.bK(context, info.getOpen()) && bv.a(context, info)) {
                        w.iM(context).e(new x(info), info.getOpen()).eKp();
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
                            w.iM(context).a(new x(info), 2).hv("desc", e2.getMessage()).eKp();
                        }
                    }
                }
            }
        }
    }
}
