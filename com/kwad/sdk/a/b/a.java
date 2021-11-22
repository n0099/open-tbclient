package com.kwad.sdk.a.b;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.a.a.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f64793a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f64794b;

    /* renamed from: c  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f64795c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f64796d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f64797e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.a.a.a f64798f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f64799g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f64800h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdWebView f64801i;
    public Dialog j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64799g = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f64796d = context;
        c();
    }

    public com.kwad.sdk.a.a.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwad.sdk.a.a.a aVar = new com.kwad.sdk.a.a.a();
            AdTemplate adTemplate = this.f64793a;
            aVar.f64717a = adTemplate;
            aVar.f64718b = this.f64795c;
            aVar.f64719c = this.j;
            aVar.f64720d = new com.kwad.sdk.core.download.b.b(adTemplate);
            aVar.f64722f = this.f64800h;
            aVar.f64724h = new com.kwad.sdk.core.video.videoview.b(this.f64796d);
            aVar.f64721e = new b(this.f64796d);
            return aVar;
        }
        return (com.kwad.sdk.a.a.a) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.f64793a = adTemplate;
            this.f64794b = com.kwad.sdk.core.response.b.c.i(adTemplate);
            adTemplate.realShowType = 2;
            this.f64800h = ksAdVideoPlayConfig;
            this.j = dialog;
            this.f64795c = adInteractionListener;
            this.f64798f = a();
            if (this.f64797e == null) {
                Presenter b2 = b();
                this.f64797e = b2;
                b2.a((View) this.f64799g);
                this.f64797e.a(this.f64798f);
            }
        }
    }

    @NonNull
    public Presenter b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new d());
            if (com.kwad.sdk.core.response.b.a.F(this.f64794b)) {
                presenter.a((Presenter) new com.kwad.sdk.a.a.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.a.a.b());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64801i = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.ksad_interstitial_webview : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            d();
            com.kwad.sdk.a.a.a aVar = this.f64798f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f64798f.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adInteractionListener) == null) {
            this.f64795c = adInteractionListener;
            com.kwad.sdk.a.a.a aVar = this.f64798f;
            if (aVar != null) {
                aVar.f64718b = adInteractionListener;
            }
        }
    }
}
