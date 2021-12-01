package com.kwad.sdk.d.a;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d.a.b;
import com.kwad.sdk.d.kwai.e;
import com.kwad.sdk.d.kwai.f;
import com.kwad.sdk.d.kwai.g;
import com.kwad.sdk.d.kwai.h;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.af;
/* loaded from: classes2.dex */
public class a extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58219b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f58220c;

    /* renamed from: d  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f58221d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f58222e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.b f58223f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.d.kwai.c f58224g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f58225h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdVideoPlayConfig f58226i;

    /* renamed from: j  reason: collision with root package name */
    public Dialog f58227j;

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
        this.f58225h = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f58222e = context;
    }

    private b a(Context context, AdInfo adInfo, com.kwad.sdk.d.kwai.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, adInfo, cVar)) == null) {
            boolean a = cVar.a(this.f58222e, adInfo);
            b.a aVar = new b.a();
            aVar.a(a);
            boolean z = true;
            aVar.b(!cVar.a(context) && com.kwad.sdk.core.config.b.r());
            aVar.a(com.kwad.sdk.core.config.b.s());
            if (com.kwad.sdk.core.response.a.a.K(adInfo) && af.e(context)) {
                z = false;
            }
            aVar.c(z);
            return new b(context, aVar);
        }
        return (b) invokeLLL.objValue;
    }

    public com.kwad.sdk.d.kwai.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwad.sdk.d.kwai.c cVar = new com.kwad.sdk.d.kwai.c();
            AdTemplate adTemplate = this.a;
            cVar.a = adTemplate;
            cVar.f58249b = this.f58221d;
            cVar.f58250c = this.f58227j;
            cVar.f58251d = new com.kwad.sdk.core.download.a.b(adTemplate);
            cVar.f58254g = this.f58226i;
            cVar.f58253f = this.f58219b;
            cVar.f58256i = new com.kwad.sdk.core.video.videoview.b(this.f58222e);
            cVar.f58252e = a(this.f58222e, com.kwad.sdk.core.response.a.d.j(this.a), cVar);
            return cVar;
        }
        return (com.kwad.sdk.d.kwai.c) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adTemplate, dialog, ksAdVideoPlayConfig, adInteractionListener, Boolean.valueOf(z)}) == null) {
            this.a = adTemplate;
            this.f58220c = com.kwad.sdk.core.response.a.d.j(adTemplate);
            adTemplate.realShowType = 2;
            this.f58226i = ksAdVideoPlayConfig;
            this.f58227j = dialog;
            this.f58219b = z;
            this.f58221d = adInteractionListener;
            this.f58224g = a();
            if (this.f58223f == null) {
                com.kwad.sdk.d.kwai.b b2 = b();
                this.f58223f = b2;
                b2.c(this.f58225h);
                this.f58223f.a(this.f58224g);
            }
        }
    }

    @NonNull
    public com.kwad.sdk.d.kwai.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.sdk.d.kwai.b bVar = new com.kwad.sdk.d.kwai.b();
            bVar.a((Presenter) new com.kwad.sdk.d.kwai.d());
            if (com.kwad.sdk.core.response.a.a.P(this.f58220c)) {
                bVar.a((Presenter) new g());
            }
            bVar.a((Presenter) new h());
            bVar.a((Presenter) new e());
            if (com.kwad.sdk.core.response.a.a.D(this.f58220c)) {
                bVar.a((Presenter) new com.kwad.sdk.d.kwai.a());
            }
            if (this.f58224g.a(getContext())) {
                bVar.a((Presenter) new f());
            }
            return bVar;
        }
        return (com.kwad.sdk.d.kwai.b) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58223f.g();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f58223f.h();
        }
    }

    public void e() {
        com.kwad.sdk.d.kwai.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bVar = this.f58223f) == null) {
            return;
        }
        bVar.j();
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.ksad_interstitial : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            e();
            com.kwad.sdk.d.kwai.c cVar = this.f58224g;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f58224g.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adInteractionListener) == null) {
            this.f58221d = adInteractionListener;
            com.kwad.sdk.d.kwai.c cVar = this.f58224g;
            if (cVar != null) {
                cVar.f58249b = adInteractionListener;
            }
        }
    }
}
