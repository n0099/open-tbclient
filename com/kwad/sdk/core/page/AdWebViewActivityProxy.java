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
import com.alibaba.fastjson.asm.Label;
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
import java.util.List;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes4.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.b.a {
    public static final String KEY_TEMPLATE = "key_template";
    public static final String TAG = "AdWebViewActivityProxy";
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public com.kwad.sdk.core.webview.a mJsBridgeContext;
    public g mJsInterface;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;

    private void clearJsInterfaceRegister() {
        g gVar = this.mJsInterface;
        if (gVar != null) {
            gVar.a();
            this.mJsInterface = null;
        }
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        o.a aVar = new o.a();
        aVar.l = 0;
        ksAdWebView.setClientParams(aVar);
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.mJsBridgeContext = aVar;
        aVar.f34929b = this.mAdTemplate;
        aVar.f34928a = 0;
        aVar.f34933f = this.mAdWebView;
        aVar.f34932e = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.6
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
        AdInfo.AdBaseInfo adBaseInfo;
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        handlerLandingPageAtEndCard(ksAdWebView);
        this.mAdWebView.setTemplateData(this.mAdTemplate);
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.mAdTemplate)));
        this.mAdWebView.d();
        this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                if (AdWebViewActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdWebViewActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        this.mWebContainer = (ViewGroup) findViewById(R.id.ksad_landing_page_root);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        if (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null || (adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
            textView.setText("详情页面");
        } else {
            textView.setText(adBaseInfo.productName);
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
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template", adTemplate);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
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
        g gVar = new g(ksAdWebView);
        this.mJsInterface = gVar;
        registerWebCardHandler(ksAdWebView, gVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.e();
        }
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
