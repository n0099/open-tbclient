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
import com.kwad.sdk.KsAdSDKImpl;
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
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.utils.aq;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes6.dex */
public class AdLandPageActivityProxy extends com.kwad.sdk.b.a {
    public static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean mIsDownloadDialogShowing = false;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public String mDialogUrl;
    public com.kwad.sdk.core.webview.a mJsBridgeContext;
    public g mJsInterface;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public m webCardRegisterLifecycleListenerHandler;

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
        aVar.f32796b = this.mAdTemplate;
        aVar.f32795a = 0;
        aVar.f32800f = this.mAdWebView;
        aVar.f32799e = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo g2 = c.g(this.mAdTemplate);
        boolean T = com.kwad.sdk.core.response.b.a.T(g2);
        String R = com.kwad.sdk.core.response.b.a.R(g2);
        if (!T) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(R);
        this.mWebTipBarTitle.setSelected(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        KsAdWebView ksAdWebView;
        String y;
        KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView2;
        handlerLandingPageAtEndCard(ksAdWebView2);
        this.mAdWebView.setTemplateData(this.mAdTemplate);
        this.mAdWebView.a();
        this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                if (AdLandPageActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        this.mWebContainer = (ViewGroup) findViewById(R.id.ksad_landing_page_root);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        if (list != null && list.size() > 0 && this.mAdTemplate.adInfoList.get(0) != null) {
            AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
            if (!TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText(adBaseInfo.productName);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AdLandPageActivityProxy.this.finish();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AdLandPageActivityProxy.this.onBackPressed();
                    }
                });
                initTipBarView();
                if (this.mDialogUrl == null) {
                    inflateJsBridgeContext();
                    b bVar = new b(this.mAdTemplate);
                    setupJsBridge(this.mAdWebView, bVar);
                    if (com.kwad.sdk.core.config.c.P() && com.ksad.download.d.b.b(getActivity())) {
                        bVar.a((Context) getActivity(), false);
                    }
                    ksAdWebView = this.mAdWebView;
                    y = this.mDialogUrl;
                } else {
                    ksAdWebView = this.mAdWebView;
                    y = com.kwad.sdk.core.response.b.a.y(c.g(this.mAdTemplate));
                }
                ksAdWebView.loadUrl(y);
                this.mAdWebView.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.6
                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a() {
                        if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                            AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.c();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a(int i2, String str, String str2) {
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void b() {
                        if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                            AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.d();
                        }
                    }
                });
            }
        }
        textView.setText("详情页面");
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdLandPageActivityProxy.this.onBackPressed();
            }
        });
        initTipBarView();
        if (this.mDialogUrl == null) {
        }
        ksAdWebView.loadUrl(y);
        this.mAdWebView.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.6
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.c();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.d();
                }
            }
        });
    }

    public static boolean isDownloadDialogShowing() {
        return mIsDownloadDialogShowing;
    }

    public static void launch(Context context, AdTemplate adTemplate, String str) {
        if (context == null || adTemplate == null) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdLandPageActivityProxy.class);
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdLandPageActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_DIALOG_URL, str);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
        mIsDownloadDialogShowing = true;
    }

    private void registerWebCardHandler(g gVar, b bVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.mJsBridgeContext, bVar, new a.b() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.1
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0374a c0374a) {
            }
        }));
        gVar.a(new e(this.mJsBridgeContext));
        gVar.a(new n(this.mJsBridgeContext, bVar));
        gVar.a(new j(this.mJsBridgeContext));
        gVar.a(new k(new k.b() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i2) {
            }
        }));
        m mVar = new m();
        this.webCardRegisterLifecycleListenerHandler = mVar;
        gVar.a(mVar);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, b bVar) {
        clearJsInterfaceRegister();
        aq.a(this.mAdWebView);
        g gVar = new g(ksAdWebView);
        this.mJsInterface = gVar;
        registerWebCardHandler(gVar, bVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            super.onBackPressed();
            return;
        }
        this.mAdWebView.goBack();
        com.kwad.sdk.core.report.b.k(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.ksad_activity_ad_webview);
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mDialogUrl = getIntent().getStringExtra(KEY_DIALOG_URL);
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        if (this.mAdTemplate != null) {
            initView();
        } else {
            finish();
        }
    }

    @Override // com.kwad.sdk.b.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        m mVar = this.webCardRegisterLifecycleListenerHandler;
        if (mVar != null) {
            mVar.b();
        }
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.b();
        }
        super.onDestroy();
        mIsDownloadDialogShowing = false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        super.onStop();
    }
}
