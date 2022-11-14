package com.kwad.components.core.c.kwai;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
/* loaded from: classes7.dex */
public final class e extends c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b DG;
    public b.C0579b DH;
    public Runnable DP;
    public boolean DQ;
    public KsAdWebView bF;
    public aa bI;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public r.b bK;
    public q.b bL;
    public x.b bM;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DQ = false;
        this.bJ = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.core.c.kwai.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e DR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.DR = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + this.DR.DQ);
                    this.DR.DQ = true;
                }
            }
        };
        this.bK = new r.b(this) { // from class: com.kwad.components.core.c.kwai.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e DR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.DR = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
                    this.DR.bF.setTranslationY((float) (aVar.height + aVar.bottomMargin));
                }
            }
        };
        this.bL = new q.b(this) { // from class: com.kwad.components.core.c.kwai.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e DR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.DR = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
                    this.DR.aK();
                }
            }
        };
        this.bM = new x.b(this) { // from class: com.kwad.components.core.c.kwai.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e DR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.DR = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    com.kwad.sdk.core.e.b.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
                    if (aVar.status == 1) {
                        this.DR.mv();
                        return;
                    }
                    this.DR.aK();
                    if (this.DR.getContext() != null) {
                        t.z(this.DR.getContext(), u.ck(this.DR.getContext()));
                    }
                }
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
            aVar.a(new f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ, 1));
            aVar.a(new l(this.mJsBridgeContext));
            aVar.a(new o(this.mJsBridgeContext));
            aVar.a(new k(this.mJsBridgeContext));
            aVar.a(new r(this.mJsBridgeContext, this.bK));
            aVar.a(new x(this.bM, this.DH.url));
            aa aaVar = new aa();
            this.bI = aaVar;
            aVar.a(aaVar);
            aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
            aVar.a(new q(this.bL));
            aVar.a(new s(this.mJsBridgeContext));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
            clearJsInterfaceRegister();
            com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
            this.mJsInterface = aVar;
            a(aVar);
            this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.DQ);
            if (this.bF.getVisibility() != 0) {
                return;
            }
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.bF.setVisibility(4);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
            if (this.DQ) {
                com.kwad.sdk.core.report.a.aB(this.mAdTemplate);
            }
            b bVar = this.DG;
            if (bVar == null || !bVar.isShowing()) {
                return;
            }
            this.DG.ai(this.DQ);
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

    private void inflateJsBridgeContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            this.mJsBridgeContext = bVar;
            bVar.setAdTemplate(this.DI.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
            AdBaseFrameLayout adBaseFrameLayout = this.DI.mRootContainer;
            bVar2.agd = adBaseFrameLayout;
            bVar2.Gl = adBaseFrameLayout;
            bVar2.Fv = this.bF;
        }
    }

    private void mt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            aF();
            this.bF.loadUrl(this.DH.url);
            this.bF.postDelayed(mu(), 1500L);
            this.bF.setBackgroundColor(0);
            this.bF.getBackground().setAlpha(0);
            this.bF.setVisibility(0);
        }
    }

    private Runnable mu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.DP == null) {
                this.DP = new Runnable(this) { // from class: com.kwad.components.core.c.kwai.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ e DR;

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
                        this.DR = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.DR.aK();
                            if (this.DR.getContext() != null) {
                                t.z(this.DR.getContext(), u.ck(this.DR.getContext()));
                            }
                        }
                    }
                };
            }
            return this.DP;
        }
        return (Runnable) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (runnable = this.DP) == null) {
            return;
        }
        this.bF.removeCallbacks(runnable);
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.bF.setVisibility(8);
            this.bF.release();
            clearJsInterfaceRegister();
        }
    }

    @Override // com.kwad.components.core.c.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            d dVar = this.DI;
            this.DG = dVar.DG;
            this.DH = dVar.DH;
            this.mAdTemplate = dVar.mAdTemplate;
            dVar.mRootContainer.setOnClickListener(this);
            this.mApkDownloadHelper = this.DI.mApkDownloadHelper;
            inflateJsBridgeContext();
            mt();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            com.kwad.sdk.core.report.a.aB(this.mAdTemplate);
            b bVar = this.DG;
            if (bVar != null) {
                bVar.dismiss();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0910dc);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            mv();
        }
    }
}
