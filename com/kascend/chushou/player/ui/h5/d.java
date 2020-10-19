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
/* loaded from: classes6.dex */
public class d extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public String f4177a;
    public boolean b;
    private Context c;
    private View e;
    private ImageView f;
    private View g;
    private TextView h;
    private boolean j;
    private FrameLayout opl;
    private CSWebView ouu;
    private com.kascend.chushou.widget.cswebview.a ouv;
    private com.kascend.chushou.widget.cswebview.d ouw;

    public d(Context context, H5Options h5Options, com.kascend.chushou.widget.cswebview.a aVar) {
        super(context);
        this.j = false;
        this.c = context;
        this.f4177a = h5Options.f4233a;
        this.b = h5Options.b;
        this.ouv = aVar;
        if (this.ouv != null) {
            this.ouw = aVar.eiD();
        }
        a();
    }

    public void a() {
        View inflate = LayoutInflater.from(this.c).inflate(a.h.view_small_h5, (ViewGroup) this, true);
        inflate.setBackgroundColor(0);
        this.opl = (FrameLayout) inflate.findViewById(a.f.empty_loading_view);
        this.g = inflate.findViewById(a.f.ll_loading);
        this.e = inflate.findViewById(a.f.ll_error);
        this.f = (ImageView) inflate.findViewById(a.f.iv_empty);
        this.h = (TextView) inflate.findViewById(a.f.tv_refresh);
        this.h.setOnClickListener(this);
        this.ouu = (CSWebView) inflate.findViewById(a.f.web_view);
        this.ouu.setBackgroundColor(0);
        if (this.ouv == null) {
            this.ouv = new com.kascend.chushou.widget.cswebview.a();
        }
        this.ouv.a(this.ouw);
        CSWebView.a(this.ouu, this.c, new com.kascend.chushou.widget.cswebview.c() { // from class: com.kascend.chushou.player.ui.h5.d.1
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
                    if (!tv.chushou.zues.utils.a.etZ()) {
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
        }, this.ouv);
        this.ouu.resumeTimers();
        this.ouu.onResume();
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_refresh) {
            b();
        } else if (id == a.f.iv_close && this.ouw != null) {
            this.ouw.a((Object) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        tv.chushou.zues.a.a.cp(this);
        if (this.ouu != null) {
            this.ouu.loadUrl("");
            this.ouu.removeAllViews();
            this.ouu.destroy();
            this.ouu = null;
        }
        super.onDetachedFromWindow();
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!c() && iVar.f4073a == 0 && (iVar.b instanceof Boolean) && ((Boolean) iVar.b).booleanValue()) {
            b();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ouu != null && this.b && this.ouu.canGoBack()) {
            this.ouu.goBack();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        switch (i) {
            case 1:
                this.ouu.setVisibility(8);
                this.opl.setVisibility(0);
                this.opl.setBackgroundResource(a.c.transparent);
                this.e.setVisibility(8);
                this.g.setVisibility(0);
                return;
            case 2:
                this.opl.setVisibility(8);
                this.ouu.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.ouu.setVisibility(8);
                this.opl.setVisibility(0);
                this.opl.setBackgroundResource(a.e.powindow_circle_bg);
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
        if (this.ouu != null) {
            this.ouu.setTag(null);
            if (tv.chushou.zues.utils.a.etZ()) {
                if (this.f4177a != null && this.f4177a.length() > 0) {
                    this.ouu.loadUrl(this.f4177a);
                    return;
                } else {
                    this.ouu.loadUrl("");
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
