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
/* loaded from: classes10.dex */
public class a extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f71046a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f71047b;

    /* renamed from: c  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f71048c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f71049d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f71050e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.a.a.a f71051f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f71052g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f71053h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdWebView f71054i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f71055j;

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
        this.f71052g = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f71049d = context;
        c();
    }

    public com.kwad.sdk.a.a.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwad.sdk.a.a.a aVar = new com.kwad.sdk.a.a.a();
            AdTemplate adTemplate = this.f71046a;
            aVar.f70966a = adTemplate;
            aVar.f70967b = this.f71048c;
            aVar.f70968c = this.f71055j;
            aVar.f70969d = new com.kwad.sdk.core.download.b.b(adTemplate);
            aVar.f70971f = this.f71053h;
            aVar.f70973h = new com.kwad.sdk.core.video.videoview.b(this.f71049d);
            aVar.f70970e = new b(this.f71049d);
            return aVar;
        }
        return (com.kwad.sdk.a.a.a) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener) == null) {
            this.f71046a = adTemplate;
            this.f71047b = com.kwad.sdk.core.response.b.c.i(adTemplate);
            adTemplate.realShowType = 2;
            this.f71053h = ksAdVideoPlayConfig;
            this.f71055j = dialog;
            this.f71048c = adInteractionListener;
            this.f71051f = a();
            if (this.f71050e == null) {
                Presenter b2 = b();
                this.f71050e = b2;
                b2.a((View) this.f71052g);
                this.f71050e.a(this.f71051f);
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
            if (com.kwad.sdk.core.response.b.a.F(this.f71047b)) {
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
            this.f71054i = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
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
            com.kwad.sdk.a.a.a aVar = this.f71051f;
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
            this.f71051f.c();
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
            this.f71048c = adInteractionListener;
            com.kwad.sdk.a.a.a aVar = this.f71051f;
            if (aVar != null) {
                aVar.f70967b = adInteractionListener;
            }
        }
    }
}
