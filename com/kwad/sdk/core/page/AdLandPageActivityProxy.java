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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.utils.be;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class AdLandPageActivityProxy extends com.kwad.sdk.h.a {
    public static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean mIsDownloadDialogShowing;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public String mDialogUrl;
    public com.kwad.sdk.core.webview.a mJsBridgeContext;
    public g mJsInterface;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public s webCardRegisterLifecycleListenerHandler;

    private void clearJsInterfaceRegister() {
        g gVar = this.mJsInterface;
        if (gVar != null) {
            gVar.a();
            this.mJsInterface = null;
        }
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        p.a aVar = new p.a();
        aVar.n = 0;
        ksAdWebView.setClientParams(aVar);
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.mJsBridgeContext = aVar;
        aVar.a(this.mAdTemplate);
        com.kwad.sdk.core.webview.a aVar2 = this.mJsBridgeContext;
        aVar2.a = 0;
        aVar2.e = this.mAdWebView;
        aVar2.d = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09118b);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f09118c);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09118d);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
        boolean af = com.kwad.sdk.core.response.a.a.af(j);
        String ab = com.kwad.sdk.core.response.a.a.ab(j);
        if (!af) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(ab);
        this.mWebTipBarTitle.setSelected(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        KsAdWebView ksAdWebView;
        String G;
        KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091182);
        this.mAdWebView = ksAdWebView2;
        handlerLandingPageAtEndCard(ksAdWebView2);
        this.mAdWebView.setTemplateData(this.mAdTemplate);
        this.mAdWebView.b();
        this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (AdLandPageActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0910a6);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910a7);
        ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910a8);
        this.mWebContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910ad);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        if (list != null && list.size() > 0 && this.mAdTemplate.adInfoList.get(0) != null) {
            AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
            if (!TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText(adBaseInfo.productName);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdLandPageActivityProxy.this.finish();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdLandPageActivityProxy.this.onBackPressed();
                    }
                });
                initTipBarView();
                if (this.mDialogUrl == null) {
                    inflateJsBridgeContext();
                    com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.mAdTemplate);
                    setupJsBridge(this.mAdWebView, bVar);
                    if (com.kwad.sdk.core.config.b.Z() && com.ksad.download.c.b.b(getActivity())) {
                        bVar.a((Context) getActivity(), false);
                    }
                    ksAdWebView = this.mAdWebView;
                    G = this.mDialogUrl;
                } else {
                    ksAdWebView = this.mAdWebView;
                    G = com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.mAdTemplate));
                }
                ksAdWebView.loadUrl(G);
                this.mAdWebView.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a() {
                        if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                            AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.c();
                        }
                    }

                    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                    public void a(int i, String str, String str2) {
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
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdLandPageActivityProxy.this.onBackPressed();
            }
        });
        initTipBarView();
        if (this.mDialogUrl == null) {
        }
        ksAdWebView.loadUrl(G);
        this.mAdWebView.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.c();
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
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
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
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

    private void registerWebCardHandler(g gVar, com.kwad.sdk.core.download.a.b bVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.mJsBridgeContext, bVar, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.mJsBridgeContext, bVar, (b.c) null));
        gVar.a(new f(this.mJsBridgeContext));
        gVar.a(new t(this.mJsBridgeContext, bVar));
        gVar.a(new k(this.mJsBridgeContext));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.p(new p.b() { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.1
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
            }
        }));
        s sVar = new s();
        this.webCardRegisterLifecycleListenerHandler = sVar;
        gVar.a(sVar);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, com.kwad.sdk.core.download.a.b bVar) {
        clearJsInterfaceRegister();
        be.a(this.mAdWebView);
        g gVar = new g(ksAdWebView);
        this.mJsInterface = gVar;
        registerWebCardHandler(gVar, bVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return "AdLandPageActivityProxy";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            super.onBackPressed();
            return;
        }
        this.mAdWebView.goBack();
        com.kwad.sdk.core.report.a.l(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.obfuscated_res_0x7f0d0412);
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

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        s sVar = this.webCardRegisterLifecycleListenerHandler;
        if (sVar != null) {
            sVar.b();
        }
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.c();
            this.mAdWebView = null;
        }
        super.onDestroy();
        mIsDownloadDialogShowing = false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        super.onStop();
    }
}
