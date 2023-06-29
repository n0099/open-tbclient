package com.kwad.components.core.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.kwai.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
@Deprecated
/* loaded from: classes9.dex */
public class AdLandPageActivityProxy extends com.kwad.components.core.i.a {
    public static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean mIsDownloadDialogShowing;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public String mDialogUrl;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public com.kwad.components.core.kwai.a mTitleBarHelper;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public aa webCardRegisterLifecycleListenerHandler;

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private u.b getClientParams() {
        u.b bVar = new u.b();
        bVar.abM = 0;
        return bVar;
    }

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.5
            @Override // com.kwad.components.core.webview.KsAdWebView.c
            public final void nu() {
                if (AdLandPageActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.4
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.py();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.pz();
                }
            }
        };
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        bVar2.Fv = this.mAdWebView;
        bVar2.Gl = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091425);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f091426);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091427);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        boolean aQ = com.kwad.sdk.core.response.a.a.aQ(bQ);
        String aM = com.kwad.sdk.core.response.a.a.aM(bQ);
        if (!aQ) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(aM);
        this.mWebTipBarTitle.setSelected(true);
    }

    private void initView() {
        KsAdWebView ksAdWebView;
        String ar;
        KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09141c);
        this.mAdWebView = ksAdWebView2;
        this.mAdWebView.setClientConfig(ksAdWebView2.getClientConfig().R(this.mAdTemplate).b(getClientParams()).a(getOnWebViewScrollChangeListener()).b(getWebErrorListener()));
        this.mAdWebView.pp();
        findViewById(R.id.obfuscated_res_0x7f0912c9);
        findViewById(R.id.obfuscated_res_0x7f0912ca);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912cb);
        this.mWebContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912cf);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        String bl = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.mWebContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0647a() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.3
            @Override // com.kwad.components.core.kwai.a.InterfaceC0647a
            public final void r(View view2) {
                AdLandPageActivityProxy.this.onBackPressed();
            }

            @Override // com.kwad.components.core.kwai.a.InterfaceC0647a
            public final void s(View view2) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.kwai.b(bl));
        initTipBarView();
        if (this.mDialogUrl != null) {
            inflateJsBridgeContext();
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            setupJsBridge(this.mAdWebView, cVar);
            if (com.kwad.sdk.core.config.d.rT() && ae.isWifiConnected(getActivity())) {
                cVar.m(new a.C0641a(getActivity()).aj(false).ak(false).L(this.mAdTemplate).am(false));
            }
            ksAdWebView = this.mAdWebView;
            ar = this.mDialogUrl;
        } else {
            ksAdWebView = this.mAdWebView;
            ar = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
        }
        ksAdWebView.loadUrl(ar);
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

    private void registerWebCardHandler(com.kwad.components.core.webview.a aVar, com.kwad.components.core.c.a.c cVar) {
        aVar.a(new i(this.mJsBridgeContext, cVar, null));
        aVar.a(new f(this.mJsBridgeContext, cVar, (com.kwad.sdk.core.webview.a.kwai.a) null));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new ac(this.mJsBridgeContext, cVar));
        aVar.a(new s(this.mJsBridgeContext));
        aVar.a(new x(new x.b() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.1
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar2) {
            }
        }, this.mDialogUrl));
        aa aaVar = new aa();
        this.webCardRegisterLifecycleListenerHandler = aaVar;
        aVar.a(aaVar);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, com.kwad.components.core.c.a.c cVar) {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.mJsInterface = aVar;
        registerWebCardHandler(aVar, cVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    @Override // com.kwad.components.core.i.a
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
        com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.obfuscated_res_0x7f0d0468);
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mDialogUrl = getIntent().getStringExtra(KEY_DIALOG_URL);
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
        if (this.mAdTemplate != null) {
            initView();
        } else {
            finish();
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        aa aaVar = this.webCardRegisterLifecycleListenerHandler;
        if (aaVar != null) {
            aaVar.onDestroy();
        }
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        super.onDestroy();
        mIsDownloadDialogShowing = false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        super.onStop();
    }
}
