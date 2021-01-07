package com.kwad.sdk.core.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.l;
import com.kwad.sdk.core.webview.jshandler.m;
import java.io.Serializable;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.b.a {
    public static final String KEY_TEMPLATE = "key_template";
    private static final String TAG = "AdWebViewActivityProxy";
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.sdk.core.webview.a mJsBridgeContext;
    private g mJsInterface;
    private ViewGroup mWebContainer;
    private ImageView mWebTipBarCloseBtn;
    private LinearLayout mWebTipBarLayout;
    private TextView mWebTipBarTitle;

    private void clearJsInterfaceRegister() {
        if (this.mJsInterface != null) {
            this.mJsInterface.a();
            this.mJsInterface = null;
        }
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        o.a aVar = new o.a();
        aVar.l = 0;
        ksAdWebView.setClientParams(aVar);
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.a();
        this.mJsBridgeContext.f9837b = this.mAdTemplate;
        this.mJsBridgeContext.f9836a = 0;
        this.mJsBridgeContext.f = this.mAdWebView;
        this.mJsBridgeContext.e = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        this.mWebTipBarCloseBtn = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo j = c.j(this.mAdTemplate);
        boolean aa = com.kwad.sdk.core.response.b.a.aa(j);
        String Y = com.kwad.sdk.core.response.b.a.Y(j);
        if (!aa) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(Y);
        this.mWebTipBarTitle.setSelected(true);
    }

    private void initView() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        handlerLandingPageAtEndCard(this.mAdWebView);
        this.mAdWebView.setTemplateData(this.mAdTemplate);
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.mAdTemplate)));
        this.mAdWebView.d();
        this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i, int i2, int i3, int i4) {
                if (AdWebViewActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdWebViewActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        this.mWebContainer = (ViewGroup) findViewById(R.id.ksad_landing_page_root);
        if (this.mAdTemplate.adInfoList == null || this.mAdTemplate.adInfoList.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) {
            textView.setText("详情页面");
        } else {
            AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
            if (adBaseInfo == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
            } else {
                textView.setText(adBaseInfo.productName);
            }
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewActivityProxy.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewActivityProxy.this.onBackPressed();
            }
        });
        initTipBarView();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        context.startActivity(intent);
        Context delegatedContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
        if (delegatedContext instanceof Activity) {
            ((Activity) delegatedContext).overridePendingTransition(0, 0);
        }
    }

    private void registerWebCardHandler(KsAdWebView ksAdWebView, g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.mJsBridgeContext, new b(this.mAdTemplate), new a.b() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.mJsBridgeContext));
        gVar.a(new l(this.mJsBridgeContext));
        gVar.a(new j(this.mJsBridgeContext));
        final m mVar = new m();
        ksAdWebView.setDeepLinkListener(new KsAdWebView.b() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void a() {
                mVar.c();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void b() {
                mVar.d();
            }
        });
        gVar.a(mVar);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView) {
        clearJsInterfaceRegister();
        this.mJsInterface = new g(ksAdWebView);
        registerWebCardHandler(ksAdWebView, this.mJsInterface);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        if (this.mAdWebView == null || !this.mAdWebView.canGoBack()) {
            return;
        }
        this.mAdWebView.goBack();
        com.kwad.sdk.core.report.b.k(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.ksad_activity_ad_webview);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
        if (!(serializableExtra instanceof AdTemplate)) {
            finish();
            return;
        }
        this.mAdTemplate = (AdTemplate) serializableExtra;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        if (this.mAdWebView != null) {
            this.mAdWebView.e();
        }
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
