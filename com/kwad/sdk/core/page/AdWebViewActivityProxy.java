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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template";
    public static final String TAG = "AdWebViewActivityProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public com.kwad.sdk.core.webview.a mJsBridgeContext;
    public g mJsInterface;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;

    public AdWebViewActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void clearJsInterfaceRegister() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (gVar = this.mJsInterface) == null) {
            return;
        }
        gVar.a();
        this.mJsInterface = null;
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, ksAdWebView) == null) {
            o.a aVar = new o.a();
            aVar.l = 0;
            ksAdWebView.setClientParams(aVar);
        }
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.mJsBridgeContext = aVar;
            aVar.f36790b = this.mAdTemplate;
            aVar.f36789a = 0;
            aVar.f36794f = this.mAdWebView;
            aVar.f36793e = this.mWebContainer;
        }
    }

    private void initTipBarView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
            this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
            this.mWebTipBarCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36375a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36375a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36375a.mWebTipBarLayout.setVisibility(8);
                    }
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
    }

    private void initView() {
        AdInfo.AdBaseInfo adBaseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
            this.mAdWebView = ksAdWebView;
            handlerLandingPageAtEndCard(ksAdWebView);
            this.mAdWebView.setTemplateData(this.mAdTemplate);
            this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.mAdTemplate)));
            this.mAdWebView.d();
            this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36372a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36372a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.f36372a.mWebTipBarLayout.getVisibility() == 0) {
                        this.f36372a.mWebTipBarLayout.setVisibility(8);
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
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36373a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36373a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36373a.finish();
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36374a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36374a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f36374a.onBackPressed();
                    }
                }
            });
            initTipBarView();
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, adTemplate) == null) || context == null || adTemplate == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, ksAdWebView, gVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.mJsBridgeContext, new b(this.mAdTemplate), new a.b(this) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36369a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36369a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }
            }));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.mJsBridgeContext));
            gVar.a(new l(this.mJsBridgeContext));
            gVar.a(new j(this.mJsBridgeContext));
            m mVar = new m();
            ksAdWebView.setDeepLinkListener(new KsAdWebView.b(this, mVar) { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f36370a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdWebViewActivityProxy f36371b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36371b = this;
                    this.f36370a = mVar;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36370a.c();
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f36370a.d();
                    }
                }
            });
            gVar.a(mVar);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ksAdWebView) == null) {
            clearJsInterfaceRegister();
            g gVar = new g(ksAdWebView);
            this.mJsInterface = gVar;
            registerWebCardHandler(ksAdWebView, gVar);
            ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
                return;
            }
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.b.k(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            setContentView(R.layout.ksad_activity_ad_webview);
            Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
            if (!(serializableExtra instanceof AdTemplate)) {
                finish();
                return;
            }
            this.mAdTemplate = (AdTemplate) serializableExtra;
            initView();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null) {
                ksAdWebView.e();
            }
            super.onDestroy();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            overridePendingTransition(0, 0);
        }
    }
}
