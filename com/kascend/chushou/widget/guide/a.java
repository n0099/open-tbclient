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
/* loaded from: classes6.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public String f4289a;
    private boolean d = false;
    private CSWebView oBL;
    private EmptyLoadingView oxq;

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f4289a = getArguments().getString("mH5Url");
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.view_x5_page, (ViewGroup) null);
        this.oxq = (EmptyLoadingView) inflate.findViewById(a.f.empty_view);
        this.oBL = (CSWebView) inflate.findViewById(a.f.web_view);
        CSWebView.a(this.oBL, this.mContext, new c() { // from class: com.kascend.chushou.widget.guide.a.1
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
                    if (tv.chushou.zues.utils.a.etZ()) {
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
        if (this.oBL != null) {
            this.oBL.loadUrl("");
            this.oBL.removeAllViews();
            this.oBL.destroy();
            this.oBL = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.oBL != null) {
            this.oBL.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.oBL.onPause();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.oBL != null) {
            this.oBL.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.oBL.onResume();
            }
        }
    }

    private void b() {
        e.d("GuideFragment", "H5=" + this.f4289a);
        if (tv.chushou.zues.utils.a.etZ()) {
            if (this.f4289a != null && this.f4289a.length() > 0) {
                this.oBL.loadUrl(this.f4289a);
                return;
            } else {
                this.oBL.loadUrl("");
                return;
            }
        }
        showStatus(3);
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                this.oBL.setVisibility(8);
                this.oxq.OD(1);
                return;
            case 2:
                this.oBL.setVisibility(0);
                this.oxq.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.oBL.setVisibility(8);
                this.oxq.setVisibility(0);
                this.oxq.OD(i);
                return;
            default:
                return;
        }
    }

    public void a() {
        if (tv.chushou.zues.utils.a.etZ()) {
            this.d = true;
            if (this.f4289a != null && this.f4289a.length() > 0) {
                this.oBL.loadUrl(this.f4289a);
                return;
            } else {
                this.oBL.loadUrl("");
                return;
            }
        }
        showStatus(3);
    }
}
