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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.utils.ay;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class AdLandPageActivityProxy extends com.kwad.sdk.c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean mIsDownloadDialogShowing;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public String mDialogUrl;
    public com.kwad.sdk.core.webview.a mJsBridgeContext;
    public g mJsInterface;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public p webCardRegisterLifecycleListenerHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2114983292, "Lcom/kwad/sdk/core/page/AdLandPageActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2114983292, "Lcom/kwad/sdk/core/page/AdLandPageActivityProxy;");
        }
    }

    public AdLandPageActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void clearJsInterfaceRegister() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (gVar = this.mJsInterface) == null) {
            return;
        }
        gVar.a();
        this.mJsInterface = null;
    }

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, ksAdWebView) == null) {
            n.a aVar = new n.a();
            aVar.l = 0;
            ksAdWebView.setClientParams(aVar);
        }
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.mJsBridgeContext = aVar;
            aVar.f72423b = this.mAdTemplate;
            aVar.f72422a = 0;
            aVar.f72427f = this.mAdWebView;
            aVar.f72426e = this.mWebContainer;
        }
    }

    private void initTipBarView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
            this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
            this.mWebTipBarCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f72004a;

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
                    this.f72004a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f72004a.mWebTipBarLayout.setVisibility(8);
                    }
                }
            });
            AdInfo i2 = c.i(this.mAdTemplate);
            boolean W = com.kwad.sdk.core.response.b.a.W(i2);
            String U = com.kwad.sdk.core.response.b.a.U(i2);
            if (!W) {
                this.mWebTipBarLayout.setVisibility(8);
                return;
            }
            this.mWebTipBarLayout.setVisibility(0);
            this.mWebTipBarTitle.setText(U);
            this.mWebTipBarTitle.setSelected(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        KsAdWebView ksAdWebView;
        String y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.ksad_video_webview);
            this.mAdWebView = ksAdWebView2;
            handlerLandingPageAtEndCard(ksAdWebView2);
            this.mAdWebView.setTemplateData(this.mAdTemplate);
            this.mAdWebView.a();
            this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f72000a;

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
                    this.f72000a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && this.f72000a.mWebTipBarLayout.getVisibility() == 0) {
                        this.f72000a.mWebTipBarLayout.setVisibility(8);
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
                    imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdLandPageActivityProxy f72001a;

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
                            this.f72001a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f72001a.finish();
                            }
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdLandPageActivityProxy f72002a;

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
                            this.f72002a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f72002a.onBackPressed();
                            }
                        }
                    });
                    initTipBarView();
                    if (this.mDialogUrl == null) {
                        inflateJsBridgeContext();
                        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.mAdTemplate);
                        setupJsBridge(this.mAdWebView, bVar);
                        if (com.kwad.sdk.core.config.c.V() && com.ksad.download.d.b.b(getActivity())) {
                            bVar.a((Context) getActivity(), false);
                        }
                        ksAdWebView = this.mAdWebView;
                        y = this.mDialogUrl;
                    } else {
                        ksAdWebView = this.mAdWebView;
                        y = com.kwad.sdk.core.response.b.a.y(c.i(this.mAdTemplate));
                    }
                    ksAdWebView.loadUrl(y);
                    this.mAdWebView.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdLandPageActivityProxy f72003a;

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
                            this.f72003a = this;
                        }

                        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72003a.webCardRegisterLifecycleListenerHandler == null) {
                                return;
                            }
                            this.f72003a.webCardRegisterLifecycleListenerHandler.c();
                        }

                        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                        public void a(int i2, String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                            }
                        }

                        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                        public void b() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72003a.webCardRegisterLifecycleListenerHandler == null) {
                                return;
                            }
                            this.f72003a.webCardRegisterLifecycleListenerHandler.d();
                        }
                    });
                }
            }
            textView.setText("详情页面");
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f72001a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
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
                    this.f72001a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f72001a.finish();
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f72002a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
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
                    this.f72002a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f72002a.onBackPressed();
                    }
                }
            });
            initTipBarView();
            if (this.mDialogUrl == null) {
            }
            ksAdWebView.loadUrl(y);
            this.mAdWebView.setHttpErrorListener(new KsAdWebView.d(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f72003a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
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
                    this.f72003a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72003a.webCardRegisterLifecycleListenerHandler == null) {
                        return;
                    }
                    this.f72003a.webCardRegisterLifecycleListenerHandler.c();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72003a.webCardRegisterLifecycleListenerHandler == null) {
                        return;
                    }
                    this.f72003a.webCardRegisterLifecycleListenerHandler.d();
                }
            });
        }
    }

    public static boolean isDownloadDialogShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? mIsDownloadDialogShowing : invokeV.booleanValue;
    }

    public static void launch(Context context, AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, context, adTemplate, str) == null) || context == null || adTemplate == null) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdLandPageActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(268435456);
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

    private void registerWebCardHandler(g gVar, com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, gVar, bVar) == null) {
            gVar.a(new d());
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.mJsBridgeContext, bVar, new a.b(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f71998a;

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
                    this.f71998a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(a.C2000a c2000a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c2000a) == null) {
                    }
                }
            }));
            gVar.a(new e(this.mJsBridgeContext));
            gVar.a(new q(this.mJsBridgeContext, bVar));
            gVar.a(new j(this.mJsBridgeContext));
            gVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.core.page.AdLandPageActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdLandPageActivityProxy f71999a;

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
                    this.f71999a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }
            }));
            p pVar = new p();
            this.webCardRegisterLifecycleListenerHandler = pVar;
            gVar.a(pVar);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, com.kwad.sdk.core.download.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, ksAdWebView, bVar) == null) {
            clearJsInterfaceRegister();
            ay.a(this.mAdWebView);
            g gVar = new g(ksAdWebView);
            this.mJsInterface = gVar;
            registerWebCardHandler(gVar, bVar);
            ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    @Override // com.kwad.sdk.c.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdLandPageActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
                super.onBackPressed();
                return;
            }
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.a.l(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p pVar = this.webCardRegisterLifecycleListenerHandler;
            if (pVar != null) {
                pVar.b();
            }
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null) {
                ksAdWebView.b();
            }
            super.onDestroy();
            mIsDownloadDialogShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStop();
        }
    }
}
