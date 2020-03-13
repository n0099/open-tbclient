package com.kascend.chushou.view.auth;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.log.LogConfig;
import com.kascend.chushou.a;
import com.kascend.chushou.d.i;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.kascend.chushou.widget.cswebview.SimpleWebview;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.text.l;
import tv.chushou.basis.http.Http;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
@h
/* loaded from: classes5.dex */
public final class BaiduAuthActivity extends BaseActivity {
    public static final a nfn = new a(null);
    private HashMap b;

    public View b(int i) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        View view = (View) this.b.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.b.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a() {
            String packParams;
            HashMap hashMap = new HashMap();
            hashMap.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            hashMap.put(LogConfig.KEY_DISPLAY, "mobile");
            hashMap.put("client_id", "43vLB6EGs9V4tVNugF3OdqjS");
            hashMap.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, "cstvsdk://baiduauth");
            hashMap.put("changeAcc", 3);
            Http http = (Http) tv.chushou.basis.d.b.dPW().S(Http.class);
            if (http == null || (packParams = http.packParams("https://openapi.baidu.com/oauth/2.0/authorize", hashMap)) == null) {
                return "https://openapi.baidu.com/oauth/2.0/authorize";
            }
            return packParams;
        }
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.cs_activity_baidu_auth);
        ImageView imageView = (ImageView) b(a.f.back_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        TextView textView = (TextView) b(a.f.tittle_name);
        if (textView != null) {
            textView.setText(a.i.cs_baidu_auth_title);
        }
        SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
        if (simpleWebview != null) {
            simpleWebview.setWebViewClient(new c());
        }
        EmptyLoadingView emptyLoadingView = (EmptyLoadingView) b(a.f.emptyView);
        if (emptyLoadingView != null) {
            emptyLoadingView.setReloadListener(new d());
        }
        c();
    }

    @h
    /* loaded from: classes5.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaiduAuthActivity.this.finish();
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class c extends WebViewClient {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        c() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean z = false;
            if (str == null || !l.a((CharSequence) str, (CharSequence) "cstvsdk://baiduauth", false, 2, (Object) null)) {
                return false;
            }
            String a = BaiduAuthActivity.this.a(str);
            e.d(BaiduAuthActivity.this.v, a);
            String str2 = a;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            if (z) {
                g.Om(a.i.cs_baidu_auth_failed);
            } else {
                LoginManager.Instance().baiduLogin(a);
                BaiduAuthActivity.this.finish();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BaiduAuthActivity.this.a_(1);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Object tag = webView != null ? webView.getTag() : null;
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str2 = (String) tag;
            if (tv.chushou.zues.utils.a.dQq()) {
                if (str2 != null && q.h(str2, BdStatsConstant.StatsType.ERROR)) {
                    BaiduAuthActivity.this.a_(4);
                    return;
                } else {
                    BaiduAuthActivity.this.a_(2);
                    return;
                }
            }
            BaiduAuthActivity.this.a_(3);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            e.d(BaiduAuthActivity.this.v, "onReceivedError: " + webResourceError);
            if (!BaiduAuthActivity.this.isFinishing()) {
                if (webView != null) {
                    try {
                        webView.stopLoading();
                    } catch (Exception e) {
                    }
                }
                if (webView != null) {
                    webView.setTag(BdStatsConstant.StatsType.ERROR);
                }
            }
        }
    }

    @h
    /* loaded from: classes5.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaiduAuthActivity.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
        if (simpleWebview != null) {
            simpleWebview.onResume();
        }
        SimpleWebview simpleWebview2 = (SimpleWebview) b(a.f.webView);
        if (simpleWebview2 != null) {
            simpleWebview2.resumeTimers();
        }
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
        if (simpleWebview != null) {
            simpleWebview.onPause();
        }
        SimpleWebview simpleWebview2 = (SimpleWebview) b(a.f.webView);
        if (simpleWebview2 != null) {
            simpleWebview2.pauseTimers();
        }
        super.onPause();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
        if (simpleWebview != null) {
            simpleWebview.removeAllViews();
        }
        SimpleWebview simpleWebview2 = (SimpleWebview) b(a.f.webView);
        if (simpleWebview2 != null) {
            simpleWebview2.destroy();
        }
        super.onDestroy();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a_(int i) {
        switch (i) {
            case 1:
                EmptyLoadingView emptyLoadingView = (EmptyLoadingView) b(a.f.emptyView);
                if (emptyLoadingView != null) {
                    emptyLoadingView.Na(1);
                }
                SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
                if (simpleWebview != null) {
                    simpleWebview.setVisibility(8);
                    return;
                }
                return;
            case 2:
                EmptyLoadingView emptyLoadingView2 = (EmptyLoadingView) b(a.f.emptyView);
                if (emptyLoadingView2 != null) {
                    emptyLoadingView2.Na(2);
                }
                SimpleWebview simpleWebview2 = (SimpleWebview) b(a.f.webView);
                if (simpleWebview2 != null) {
                    simpleWebview2.setVisibility(0);
                    return;
                }
                return;
            case 3:
            case 4:
            case 6:
                EmptyLoadingView emptyLoadingView3 = (EmptyLoadingView) b(a.f.emptyView);
                if (emptyLoadingView3 != null) {
                    emptyLoadingView3.Na(i);
                }
                SimpleWebview simpleWebview3 = (SimpleWebview) b(a.f.webView);
                if (simpleWebview3 != null) {
                    simpleWebview3.setVisibility(8);
                    return;
                }
                return;
            case 5:
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        SimpleWebview simpleWebview = (SimpleWebview) b(a.f.webView);
        if (simpleWebview != null) {
            simpleWebview.setTag(null);
        }
        String a2 = nfn.a();
        e.d(this.v, a2);
        ((SimpleWebview) b(a.f.webView)).loadUrl(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        Uri QV = i.QV(str);
        if (QV != null) {
            return QV.getQueryParameter("code");
        }
        return null;
    }
}
