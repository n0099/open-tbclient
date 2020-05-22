package com.kascend.chushou.widget.guide;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kascend.chushou.a;
import com.kascend.chushou.view.base.b;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.kascend.chushou.widget.cswebview.CSWebView;
import com.kascend.chushou.widget.cswebview.c;
import tv.chushou.zues.utils.e;
/* loaded from: classes5.dex */
public class a extends b {
    public String a;
    private boolean d = false;
    private EmptyLoadingView mYl;
    private CSWebView ncH;

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.a = getArguments().getString("mH5Url");
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.view_x5_page, (ViewGroup) null);
        this.mYl = (EmptyLoadingView) inflate.findViewById(a.f.empty_view);
        this.ncH = (CSWebView) inflate.findViewById(a.f.web_view);
        CSWebView.a(this.ncH, this.mContext, new c() { // from class: com.kascend.chushou.widget.guide.a.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!a.this.isFinishing() && !a.this.d) {
                    a.this.showStatus(1);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!a.this.isFinishing()) {
                    a.this.d = false;
                    String str2 = (String) webView.getTag();
                    if (tv.chushou.zues.utils.a.dRJ()) {
                        if (str2 != null && str2.equals(BdStatsConstant.StatsType.ERROR)) {
                            a.this.showStatus(4);
                            return;
                        } else {
                            a.this.showStatus(2);
                            return;
                        }
                    }
                    a.this.showStatus(3);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (!a.this.isFinishing()) {
                    a.this.d = false;
                    try {
                        webView.stopLoading();
                    } catch (Exception e) {
                    }
                    try {
                        webView.clearView();
                    } catch (Exception e2) {
                    }
                    webView.setTag(BdStatsConstant.StatsType.ERROR);
                }
            }
        }, null);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        b();
    }

    @Override // com.kascend.chushou.view.base.b
    public void unInit() {
        if (this.ncH != null) {
            this.ncH.loadUrl("");
            this.ncH.removeAllViews();
            this.ncH.destroy();
            this.ncH = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ncH != null) {
            this.ncH.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.ncH.onPause();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ncH != null) {
            this.ncH.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.ncH.onResume();
            }
        }
    }

    private void b() {
        e.d("GuideFragment", "H5=" + this.a);
        if (tv.chushou.zues.utils.a.dRJ()) {
            if (this.a != null && this.a.length() > 0) {
                this.ncH.loadUrl(this.a);
                return;
            } else {
                this.ncH.loadUrl("");
                return;
            }
        }
        showStatus(3);
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                this.ncH.setVisibility(8);
                this.mYl.Jl(1);
                return;
            case 2:
                this.ncH.setVisibility(0);
                this.mYl.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.ncH.setVisibility(8);
                this.mYl.setVisibility(0);
                this.mYl.Jl(i);
                return;
            default:
                return;
        }
    }

    public void a() {
        if (tv.chushou.zues.utils.a.dRJ()) {
            this.d = true;
            if (this.a != null && this.a.length() > 0) {
                this.ncH.loadUrl(this.a);
                return;
            } else {
                this.ncH.loadUrl("");
                return;
            }
        }
        showStatus(3);
    }
}
