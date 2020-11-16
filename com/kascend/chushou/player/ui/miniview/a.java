package com.kascend.chushou.player.ui.miniview;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.widget.MyWebView;
import com.kascend.chushou.widget.cswebview.CSWebView;
import com.kascend.chushou.widget.cswebview.c;
import com.kascend.chushou.widget.cswebview.d;
/* loaded from: classes6.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f4186a;
    private boolean c;
    private int d;
    private boolean g;
    private String h;
    private MyWebView pxg;
    private ListItem pxh;
    private d pxi;

    public a(Context context, ListItem listItem, d dVar) {
        super(context);
        this.c = false;
        this.g = false;
        this.h = "";
        a(context, listItem, dVar);
    }

    private void a(Context context, ListItem listItem, d dVar) {
        this.f4186a = context;
        this.pxh = listItem;
        this.pxi = dVar;
        inflate(getContext(), a.h.popupwebview, this);
        setLayoutParams(new RelativeLayout.LayoutParams(tv.chushou.zues.utils.a.hB(this.f4186a).x, tv.chushou.zues.utils.a.dip2px(this.f4186a, 80.0f)));
        this.pxg = (MyWebView) findViewById(a.f.wv);
        this.pxg.setBackgroundColor(0);
        com.kascend.chushou.widget.cswebview.a aVar = new com.kascend.chushou.widget.cswebview.a();
        aVar.a(new JSInterface(this.f4186a));
        if (this.pxi != null) {
            aVar.a(this.pxi);
        }
        aVar.bJ(this);
        CSWebView.a(this.pxg, this.f4186a, new c() { // from class: com.kascend.chushou.player.ui.miniview.a.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                a.this.g = true;
                if (a.this.c && a.this != null) {
                    a.this.setVisibility(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                a.this.g = false;
                if (a.this != null) {
                    a.this.setVisibility(8);
                }
            }
        }, aVar);
        this.pxg.onResume();
        this.pxg.resumeTimers();
        this.g = false;
        this.pxg.loadUrl(this.pxh.mUrl);
        setVisibility(8);
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.c;
    }

    public void a(int i, int i2, final String str) {
        this.h = str;
        this.d = i2;
        this.c = true;
        setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f4186a, i);
        loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.miniview.a.2
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(3, 0);
                aVar.Ys(str);
                tv.chushou.zues.a.a.post(aVar);
            }

            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (!a.this.g && a.this != null) {
                    a.this.setVisibility(0);
                }
            }
        });
        startAnimation(loadAnimation);
    }

    public boolean a() {
        if (!this.c) {
            return this.pxh.mPackStyle != 1;
        }
        this.c = false;
        if (this.pxh.mPackStyle != 1) {
            setVisibility(8);
            b();
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(3, 8);
            aVar.Ys(this.h);
            tv.chushou.zues.a.a.post(aVar);
            return true;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f4186a, this.d);
        loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.miniview.a.3
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(3, 8);
                aVar2.Ys(a.this.h);
                tv.chushou.zues.a.a.post(aVar2);
            }

            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (!a.this.c) {
                    a.this.setVisibility(8);
                }
            }
        });
        startAnimation(loadAnimation);
        return false;
    }

    public void a(String str) {
        if (this.pxg != null) {
            this.pxg.loadUrl("javascript:getRefreshData('" + str + "')");
        }
    }

    public void b() {
        this.f4186a = null;
        if (this.pxg != null) {
            this.pxg.loadUrl("");
            this.pxg.removeAllViews();
            this.pxg.destroy();
            this.pxg = null;
        }
    }
}
