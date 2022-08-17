package com.kwad.components.core.page.kwai;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView Fv;
    public int Gk;
    public ViewGroup Gl;
    public final a Gm;
    public AdTemplate mAdTemplate;
    public final boolean mIsRewardLandPage;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;

    /* loaded from: classes5.dex */
    public interface a {
        void aj(int i);
    }

    public f(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Gk = -1;
        this.Gm = aVar;
        this.mIsRewardLandPage = z;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            com.kwad.sdk.core.e.b.d("LandPageWebViewPresenter", "registerWebCardHandler");
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.Gi.mAdTemplate);
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(new ac(this.mJsBridgeContext, cVar));
            aVar.a(new k(this.mJsBridgeContext));
            aVar.a(new aa());
            aVar.a(new x(nN(), com.kwad.sdk.core.response.a.b.aZ(this.mAdTemplate)));
            aVar.a(new s(this.mJsBridgeContext));
            aVar.a(new w(getOpenNewPageListener()));
            aVar.a(new i(this.mJsBridgeContext, cVar, null));
            aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, cVar, null, 2, this.mIsRewardLandPage));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Fv);
            this.mJsInterface = aVar;
            a(aVar);
            this.Fv.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    private void as(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            aF();
            this.Fv.loadUrl(str);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (aVar = this.mJsInterface) == null) {
            return;
        }
        aVar.destroy();
        this.mJsInterface = null;
    }

    private w.a getOpenNewPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new w.a(this) { // from class: com.kwad.components.core.page.kwai.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f Gn;

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
                this.Gn = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.Gn.Fv.getContext(), new AdWebViewActivityProxy.a.C0361a().ao(bVar.title).ap(bVar.url).N(this.Gn.mAdTemplate).nx());
                }
            }
        } : (w.a) invokeV.objValue;
    }

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            bVar2.Gl = this.Gl;
            bVar2.Fv = this.Fv;
        }
    }

    private x.b nN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? new x.b(this) { // from class: com.kwad.components.core.page.kwai.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f Gn;

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
                this.Gn = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.Gn.Gk = aVar.status;
                    if (this.Gn.Gm != null) {
                        this.Gn.Gm.aj(aVar.status);
                    }
                    if (aVar.status == 1) {
                        this.Gn.Gl.setVisibility(0);
                    } else {
                        this.Gn.Fv.setVisibility(8);
                    }
                }
            }
        } : (x.b) invokeV.objValue;
    }

    @Override // com.kwad.components.core.page.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.Gi.mAdTemplate;
            this.mAdTemplate = adTemplate;
            String aZ = com.kwad.sdk.core.response.a.b.aZ(adTemplate);
            if (!TextUtils.isEmpty(aZ)) {
                inflateJsBridgeContext();
                as(aZ);
                return;
            }
            a aVar = this.Gm;
            if (aVar != null) {
                aVar.aj(this.Gk);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.Fv = (WebView) findViewById(R.id.obfuscated_res_0x7f0910cc);
            this.Gl = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09121c);
            this.Fv.setBackgroundColor(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            clearJsInterfaceRegister();
        }
    }
}
