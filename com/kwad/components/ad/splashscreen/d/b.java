package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class b implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ViewGroup es;
    @Nullable
    public AdInfo mAdInfo;
    @Nullable
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public a yM;
    public ViewStub zM;
    public KsAdWebView zN;
    public ViewGroup zO;
    public View zP;
    public TextView zQ;
    public boolean zR;
    @Nullable
    public f zS;
    public com.kwad.sdk.widget.f zT;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, viewStub, ksAdWebView, Boolean.valueOf(z), cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.es = viewGroup;
        this.zM = viewStub;
        this.zN = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.zR = z;
    }

    private void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, eVar) == null) || eVar == null) {
            return;
        }
        ab(eVar.jw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || (textView = this.zQ) == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.zP = viewGroup.findViewById(R.id.obfuscated_res_0x7f0912e4);
        this.zQ = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912e7);
        this.zT = new com.kwad.sdk.widget.f(this.zP.getContext(), this.zP, this);
        this.zP.getContext();
        a(e.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void g(boolean z, boolean z2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (fVar = this.zS) == null) {
            return;
        }
        fVar.f(z, z2);
    }

    public final void E(AdTemplate adTemplate) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
            a aVar2 = this.yM;
            if (aVar2 == null) {
                this.yM = new a(this, this.es.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.d.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b zU;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.zU = this;
                    }

                    @Override // com.kwad.components.ad.splashscreen.d.a
                    public final void Z(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.zU.ab(str);
                        }
                    }
                };
            } else {
                aVar2.setAdTemplate(adTemplate);
            }
            if (adTemplate != null) {
                this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            }
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar == null || (aVar = this.yM) == null) {
                return;
            }
            cVar.b(aVar);
        }
    }

    public final void a(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.zS = fVar;
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            g(true, view2.equals(this.zP));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.zR) {
            g(false, view2.equals(this.zP));
        }
    }

    public final void kv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.e.b.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.zM + ", mSplashWebView: " + this.zN);
            if (this.zN == null) {
                return;
            }
            if (this.zO == null) {
                ViewStub viewStub = this.zM;
                this.zO = (ViewGroup) ((viewStub == null || viewStub.getParent() == null) ? this.es.findViewById(R.id.obfuscated_res_0x7f0912e5) : this.zM.inflate());
                g(this.zO);
            }
            ViewGroup viewGroup = this.zO;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
                this.zN.setVisibility(8);
            }
        }
    }

    public final void onUnbind() {
        com.kwad.components.core.c.a.c cVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.mApkDownloadHelper) == null || (aVar = this.yM) == null) {
            return;
        }
        cVar.c(aVar);
    }
}
