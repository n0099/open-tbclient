package com.kascend.chushou.player.ui.h5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.cswebview.CSWebView;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.e;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class d extends RelativeLayout implements View.OnClickListener {
    public String a;
    public boolean b;
    private Context c;
    private FrameLayout d;
    private View e;
    private ImageView f;
    private View g;
    private TextView h;
    private boolean j;
    private CSWebView ncE;
    private com.kascend.chushou.widget.cswebview.a ncF;
    private com.kascend.chushou.widget.cswebview.d ncG;

    public d(Context context, H5Options h5Options, com.kascend.chushou.widget.cswebview.a aVar) {
        super(context);
        this.j = false;
        this.c = context;
        this.a = h5Options.a;
        this.b = h5Options.b;
        this.ncF = aVar;
        if (this.ncF != null) {
            this.ncG = aVar.dEx();
        }
        a();
    }

    public void a() {
        View inflate = LayoutInflater.from(this.c).inflate(a.h.view_small_h5, (ViewGroup) this, true);
        inflate.setBackgroundColor(0);
        this.d = (FrameLayout) inflate.findViewById(a.f.empty_loading_view);
        this.g = inflate.findViewById(a.f.ll_loading);
        this.e = inflate.findViewById(a.f.ll_error);
        this.f = (ImageView) inflate.findViewById(a.f.iv_empty);
        this.h = (TextView) inflate.findViewById(a.f.tv_refresh);
        this.h.setOnClickListener(this);
        this.ncE = (CSWebView) inflate.findViewById(a.f.web_view);
        this.ncE.setBackgroundColor(0);
        if (this.ncF == null) {
            this.ncF = new com.kascend.chushou.widget.cswebview.a();
        }
        this.ncF.a(this.ncG);
        CSWebView.a(this.ncE, this.c, new com.kascend.chushou.widget.cswebview.c() { // from class: com.kascend.chushou.player.ui.h5.d.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!d.this.c() && !d.this.j) {
                    d.this.a(1);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                e.e("SmallH5View", "onPageFinished");
                if (!d.this.c()) {
                    d.this.j = false;
                    String str2 = (String) webView.getTag();
                    if (!tv.chushou.zues.utils.a.dQp()) {
                        d.this.a(3);
                    } else if (str2 == null || !str2.equals(BdStatsConstant.StatsType.ERROR)) {
                        d.this.a(2);
                    } else {
                        d.this.a(4);
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                e.e("SmallH5View", "onReceivedError code=" + i);
                if (!d.this.c()) {
                    d.this.j = false;
                    try {
                        webView.stopLoading();
                    } catch (Exception e) {
                        e.e("SmallH5View", "", e);
                    }
                    webView.setTag(BdStatsConstant.StatsType.ERROR);
                }
            }
        }, this.ncF);
        this.ncE.resumeTimers();
        this.ncE.onResume();
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_refresh) {
            b();
        } else if (id == a.f.iv_close && this.ncG != null) {
            this.ncG.a((Object) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        tv.chushou.zues.a.a.cr(this);
        if (this.ncE != null) {
            this.ncE.loadUrl("");
            this.ncE.removeAllViews();
            this.ncE.destroy();
            this.ncE = null;
        }
        super.onDetachedFromWindow();
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!c() && iVar.a == 0 && (iVar.b instanceof Boolean) && ((Boolean) iVar.b).booleanValue()) {
            b();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ncE != null && this.b && this.ncE.canGoBack()) {
            this.ncE.goBack();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        switch (i) {
            case 1:
                this.ncE.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setBackgroundResource(a.c.transparent);
                this.e.setVisibility(8);
                this.g.setVisibility(0);
                return;
            case 2:
                this.d.setVisibility(8);
                this.ncE.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.ncE.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setBackgroundResource(a.e.powindow_circle_bg);
                this.g.setVisibility(8);
                this.e.setVisibility(0);
                this.f.setVisibility(0);
                int i2 = a.e.commonres_pagestatus_unknown_error;
                if (i == 3) {
                    i2 = a.e.commonres_pagestatus_net_error;
                }
                this.f.setImageResource(i2);
                this.h.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void b() {
        if (this.ncE != null) {
            this.ncE.setTag(null);
            if (tv.chushou.zues.utils.a.dQp()) {
                if (this.a != null && this.a.length() > 0) {
                    this.ncE.loadUrl(this.a);
                    return;
                } else {
                    this.ncE.loadUrl("");
                    return;
                }
            }
            a(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return !ViewCompat.isAttachedToWindow(this);
    }
}
