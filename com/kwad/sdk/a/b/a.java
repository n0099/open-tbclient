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
    public AdTemplate f63881a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f63882b;

    /* renamed from: c  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f63883c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f63884d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f63885e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.a.a.a f63886f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f63887g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f63888h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdWebView f63889i;
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
        this.f63887g = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f63884d = context;
        c();
    }

    public com.kwad.sdk.a.a.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwad.sdk.a.a.a aVar = new com.kwad.sdk.a.a.a();
            AdTemplate adTemplate = this.f63881a;
            aVar.f63805a = adTemplate;
            aVar.f63806b = this.f63883c;
            aVar.f63807c = this.j;
            aVar.f63808d = new com.kwad.sdk.core.download.b.b(adTemplate);
            aVar.f63810f = this.f63888h;
            aVar.f63812h = new com.kwad.sdk.core.video.videoview.b(this.f63884d);
            aVar.f63809e = new b(this.f63884d);
            return aVar;
        }
        return (com.kwad.sdk.a.a.a) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.f63881a = adTemplate;
            this.f63882b = com.kwad.sdk.core.response.b.c.i(adTemplate);
            adTemplate.realShowType = 2;
            this.f63888h = ksAdVideoPlayConfig;
            this.j = dialog;
            this.f63883c = adInteractionListener;
            this.f63886f = a();
            if (this.f63885e == null) {
                Presenter b2 = b();
                this.f63885e = b2;
                b2.a((View) this.f63887g);
                this.f63885e.a(this.f63886f);
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
            if (com.kwad.sdk.core.response.b.a.F(this.f63882b)) {
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
            this.f63889i = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
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
            com.kwad.sdk.a.a.a aVar = this.f63886f;
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
            this.f63886f.c();
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
            this.f63883c = adInteractionListener;
            com.kwad.sdk.a.a.a aVar = this.f63886f;
            if (aVar != null) {
                aVar.f63806b = adInteractionListener;
            }
        }
    }
}
