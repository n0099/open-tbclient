package com.kwad.components.ad.interstitial.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
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
import com.kwad.components.ad.interstitial.b.i;
import com.kwad.components.ad.interstitial.widget.f;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate b;
    public AdInfo c;
    public KsInterstitialAd.AdInteractionListener d;
    @NonNull
    public Context e;
    public com.kwad.components.ad.interstitial.b.b f;
    public com.kwad.components.ad.interstitial.b.c g;
    public ViewGroup h;
    public KsAdVideoPlayConfig i;
    public Dialog j;
    public boolean k;
    public int l;
    public boolean m;
    public c.a n;
    public boolean o;

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
        this.l = -1;
        this.h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.e = context;
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.b.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, adInfo, cVar)) == null) {
            boolean a = com.kwad.components.ad.interstitial.b.c.a(this.e, adInfo);
            f.a aVar = new f.a();
            aVar.a(a);
            boolean z = true;
            aVar.b(!cVar.a(context) && com.kwad.components.ad.interstitial.kwai.b.b());
            aVar.a(com.kwad.components.ad.interstitial.kwai.b.c());
            if (com.kwad.sdk.core.response.a.a.R(adInfo) && ae.e(context)) {
                z = false;
            }
            aVar.c(z);
            return new f(context, aVar);
        }
        return (f) invokeLLL.objValue;
    }

    private com.kwad.components.ad.interstitial.b.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.components.ad.interstitial.b.c cVar = new com.kwad.components.ad.interstitial.b.c();
            AdTemplate adTemplate = this.b;
            cVar.a = adTemplate;
            cVar.b = this.d;
            cVar.c = this.j;
            cVar.d = new com.kwad.components.core.c.a.b(adTemplate);
            cVar.j = this.i;
            cVar.l = new com.kwad.sdk.core.video.videoview.a(this.e);
            cVar.n = this.l;
            cVar.h = this.m;
            cVar.i = this.n;
            cVar.e = a(this.e, com.kwad.sdk.core.response.a.d.i(this.b), cVar);
            return cVar;
        }
        return (com.kwad.components.ad.interstitial.b.c) invokeV.objValue;
    }

    @NonNull
    private com.kwad.components.ad.interstitial.b.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            com.kwad.components.ad.interstitial.b.b bVar = new com.kwad.components.ad.interstitial.b.b();
            bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.d());
            if (com.kwad.sdk.core.response.a.a.W(this.c)) {
                bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.h());
            }
            bVar.a((Presenter) new i());
            bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.f());
            bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.e(this.c));
            if (com.kwad.sdk.core.response.a.a.K(this.c)) {
                bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.a());
            }
            if (this.g.a(getContext())) {
                bVar.a((Presenter) new com.kwad.components.ad.interstitial.b.g());
            }
            return bVar;
        }
        return (com.kwad.components.ad.interstitial.b.b) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.d();
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.b = adTemplate;
            this.c = com.kwad.sdk.core.response.a.d.i(adTemplate);
            adTemplate.realShowType = 2;
            this.i = ksAdVideoPlayConfig;
            this.j = dialog;
            this.d = adInteractionListener;
            this.g = c();
            if (this.f == null) {
                this.f = d();
            }
            this.f.c(this.h);
            this.f.a(this.g);
            this.k = ae.e(this.e);
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.e();
        }
    }

    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d042a : invokeV.intValue;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!this.o || ae.e(this.e) == this.k || (gVar = this.a) == null) {
                return;
            }
            gVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            com.kwad.components.ad.interstitial.b.c cVar = this.g;
            if (cVar != null) {
                cVar.a();
            }
            com.kwad.components.ad.interstitial.b.b bVar = this.f;
            if (bVar != null) {
                bVar.p();
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            this.o = i == 0;
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.n = aVar;
            com.kwad.components.ad.interstitial.b.c cVar = this.g;
            if (cVar != null) {
                cVar.i = aVar;
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adInteractionListener) == null) {
            this.d = adInteractionListener;
            com.kwad.components.ad.interstitial.b.c cVar = this.g;
            if (cVar != null) {
                cVar.b = adInteractionListener;
            }
        }
    }

    public final void setAggregateAdView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
            com.kwad.components.ad.interstitial.b.c cVar = this.g;
            if (cVar != null) {
                cVar.h = z;
            }
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.l = i;
            com.kwad.components.ad.interstitial.b.c cVar = this.g;
            if (cVar != null) {
                cVar.n = i;
            }
        }
    }
}
