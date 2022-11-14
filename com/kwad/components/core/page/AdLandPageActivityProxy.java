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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class AdLandPageActivityProxy extends com.kwad.components.core.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public static boolean mIsDownloadDialogShowing;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1668571932, "Lcom/kwad/components/core/page/AdLandPageActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1668571932, "Lcom/kwad/components/core/page/AdLandPageActivityProxy;");
        }
    }

    public AdLandPageActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    private u.b getClientParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            u.b bVar = new u.b();
            bVar.abM = 0;
            return bVar;
        }
        return (u.b) invokeV.objValue;
    }

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new KsAdWebView.c(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdLandPageActivityProxy Ft;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.Ft = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.c
            public final void nu() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.Ft.mWebTipBarLayout.getVisibility() == 0) {
                    this.Ft.mWebTipBarLayout.setVisibility(8);
                }
            }
        } : (KsAdWebView.c) invokeV.objValue;
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdLandPageActivityProxy Ft;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.Ft = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.Ft.webCardRegisterLifecycleListenerHandler == null) {
                    return;
                }
                this.Ft.webCardRegisterLifecycleListenerHandler.py();
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.Ft.webCardRegisterLifecycleListenerHandler == null) {
                    return;
                }
                this.Ft.webCardRegisterLifecycleListenerHandler.pz();
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.mScreenOrientation = 0;
            bVar2.Fv = this.mAdWebView;
            bVar2.Gl = this.mWebContainer;
        }
    }

    private void initTipBarView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091277);
            this.mWebTipBarTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f091278);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091279);
            this.mWebTipBarCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdLandPageActivityProxy Ft;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ft = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Ft.mWebTipBarLayout.setVisibility(8);
                    }
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
    }

    private void initView() {
        KsAdWebView ksAdWebView;
        String ar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            KsAdWebView ksAdWebView2 = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09126e);
            this.mAdWebView = ksAdWebView2;
            this.mAdWebView.setClientConfig(ksAdWebView2.getClientConfig().R(this.mAdTemplate).b(getClientParams()).a(getOnWebViewScrollChangeListener()).b(getWebErrorListener()));
            this.mAdWebView.pp();
            findViewById(R.id.obfuscated_res_0x7f09111b);
            findViewById(R.id.obfuscated_res_0x7f09111c);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09111d);
            this.mWebContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091121);
            List<AdInfo> list = this.mAdTemplate.adInfoList;
            String bl = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdLandPageActivityProxy Ft;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ft = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Ft.finish();
                    }
                }
            });
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.mWebContainer);
            this.mTitleBarHelper = aVar;
            aVar.a(new a.InterfaceC0583a(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdLandPageActivityProxy Ft;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ft = this;
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0583a
                public final void r(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Ft.onBackPressed();
                    }
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0583a
                public final void s(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.Ft.finish();
                    }
                }
            });
            this.mTitleBarHelper.a(new com.kwad.components.core.kwai.b(bl));
            initTipBarView();
            if (this.mDialogUrl != null) {
                inflateJsBridgeContext();
                com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                setupJsBridge(this.mAdWebView, cVar);
                if (com.kwad.sdk.core.config.d.rT() && ae.isWifiConnected(getActivity())) {
                    cVar.m(new a.C0577a(getActivity()).aj(false).ak(false).L(this.mAdTemplate).am(false));
                }
                ksAdWebView = this.mAdWebView;
                ar = this.mDialogUrl;
            } else {
                ksAdWebView = this.mAdWebView;
                ar = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            }
            ksAdWebView.loadUrl(ar);
        }
    }

    public static boolean isDownloadDialogShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? mIsDownloadDialogShowing : invokeV.booleanValue;
    }

    public static void launch(Context context, AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, context, adTemplate, str) == null) || context == null || adTemplate == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, aVar, cVar) == null) {
            aVar.a(new i(this.mJsBridgeContext, cVar, null));
            aVar.a(new f(this.mJsBridgeContext, cVar, (com.kwad.sdk.core.webview.a.kwai.a) null));
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new ac(this.mJsBridgeContext, cVar));
            aVar.a(new s(this.mJsBridgeContext));
            aVar.a(new x(new x.b(this) { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdLandPageActivityProxy Ft;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ft = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.x.b
                public final void a(x.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    }
                }
            }, this.mDialogUrl));
            aa aaVar = new aa();
            this.webCardRegisterLifecycleListenerHandler = aaVar;
            aVar.a(aaVar);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, ksAdWebView, cVar) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
            this.mJsInterface = aVar;
            registerWebCardHandler(aVar, cVar);
            ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    @Override // com.kwad.components.core.i.a
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
            com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d040a);
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
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
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
