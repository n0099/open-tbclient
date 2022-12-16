package com.kwad.components.ad.interstitial.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.ad.interstitial.widget.f;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public final class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdVideoPlayConfig cN;
    public KsInterstitialAd.AdInteractionListener fo;
    public com.kwad.components.ad.interstitial.b.c gh;
    public Dialog gi;
    public boolean gn;
    public c.a go;
    public com.kwad.components.core.webview.b.d.b gp;
    public int gx;
    public boolean iA;
    public ViewGroup iB;
    public com.kwad.components.ad.interstitial.b.b iz;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gx = -1;
        this.gp = new com.kwad.components.core.webview.b.d.b(this) { // from class: com.kwad.components.ad.interstitial.widget.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e iC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.iC = this;
            }

            @Override // com.kwad.components.core.webview.b.d.b
            public final void u(String str) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && "ksad-interstitial-card".equals(str)) {
                    this.iC.iA = false;
                    com.kwad.components.ad.interstitial.b.b bVar = this.iC.iz;
                    if (bVar != null) {
                        bVar.bt();
                    }
                    e eVar = this.iC;
                    eVar.iz = eVar.dV();
                    e eVar2 = this.iC;
                    eVar2.iz.B(eVar2.iB);
                    e eVar3 = this.iC;
                    eVar3.iz.e(eVar3.gh);
                }
            }
        };
        this.iB = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.b.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, adInfo, cVar)) == null) {
            boolean a = com.kwad.components.ad.interstitial.b.c.a(this.mContext, adInfo);
            f.a aVar = new f.a();
            aVar.v(a);
            boolean z = true;
            aVar.w(!cVar.K(context) && com.kwad.components.ad.interstitial.kwai.b.cj());
            aVar.E(com.kwad.components.ad.interstitial.kwai.b.ck());
            if (com.kwad.sdk.core.response.a.a.av(adInfo) && ag.cB(context)) {
                z = false;
            }
            aVar.x(z);
            return new f(context, aVar);
        }
        return (f) invokeLLL.objValue;
    }

    private com.kwad.components.ad.interstitial.b.c dU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            com.kwad.components.ad.interstitial.b.c cVar = new com.kwad.components.ad.interstitial.b.c();
            AdTemplate adTemplate = this.mAdTemplate;
            cVar.mAdTemplate = adTemplate;
            cVar.fo = this.fo;
            cVar.gi = this.gi;
            cVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(adTemplate);
            cVar.cN = this.cN;
            cVar.dp = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            KSFrameLayout kSFrameLayout = (KSFrameLayout) this.iB.findViewById(R.id.obfuscated_res_0x7f09111d);
            cVar.gq = kSFrameLayout;
            com.kwad.components.ad.interstitial.c.b bVar = new com.kwad.components.ad.interstitial.c.b(kSFrameLayout, 100);
            cVar.gt = bVar;
            bVar.qi();
            cVar.gx = this.gx;
            cVar.gn = this.gn;
            cVar.go = this.go;
            cVar.gp = this.gp;
            cVar.gj = a(this.mContext, com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate), cVar);
            return cVar;
        }
        return (com.kwad.components.ad.interstitial.b.c) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            adTemplate.realShowType = 2;
            this.cN = ksAdVideoPlayConfig;
            this.gi = dialog;
            this.iA = com.kwad.sdk.core.response.a.b.bn(this.mAdTemplate);
            this.fo = adInteractionListener;
            this.gh = dU();
            if (this.iz == null) {
                this.iz = dV();
            }
            this.iz.B(this.iB);
            this.iz.e(this.gh);
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.iz.cv();
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.iz.cw();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.b.b dV() {
        InterceptResult invokeV;
        Presenter gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.components.ad.interstitial.b.b bVar = new com.kwad.components.ad.interstitial.b.b();
            if (!this.iA) {
                bVar.a(new com.kwad.components.ad.interstitial.b.d());
                if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                    bVar.a(new com.kwad.components.ad.interstitial.b.h());
                }
                bVar.a(new com.kwad.components.ad.interstitial.b.i());
                bVar.a(new com.kwad.components.ad.interstitial.b.f());
                bVar.a(new com.kwad.components.ad.interstitial.b.e(this.mAdInfo));
                if (com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
                    bVar.a(new com.kwad.components.ad.interstitial.b.a());
                }
                if (this.gh.K(getContext())) {
                    gVar = new com.kwad.components.ad.interstitial.b.g();
                }
                return bVar;
            }
            gVar = new com.kwad.components.ad.interstitial.b.kwai.b();
            bVar.a(gVar);
            return bVar;
        }
        return (com.kwad.components.ad.interstitial.b.b) invokeV.objValue;
    }

    public final void dW() {
        com.kwad.components.ad.interstitial.b.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cVar = this.gh) != null && cVar.gw) {
            cVar.cz();
        }
    }

    public final void dX() {
        com.kwad.components.ad.interstitial.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.gh) == null) {
            return;
        }
        if (this.iA || cVar.gw) {
            this.gh.cA();
        }
    }

    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.obfuscated_res_0x7f0d044a : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                cVar.release();
            }
            com.kwad.components.ad.interstitial.b.b bVar = this.iz;
            if (bVar != null) {
                bVar.destroy();
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.go = aVar;
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                cVar.go = aVar;
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adInteractionListener) == null) {
            this.fo = adInteractionListener;
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                cVar.fo = adInteractionListener;
            }
        }
    }

    public final void setAggregateAdView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.gn = z;
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                cVar.gn = z;
            }
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.gx = i;
            com.kwad.components.ad.interstitial.b.c cVar = this.gh;
            if (cVar != null) {
                cVar.gx = i;
            }
        }
    }
}
