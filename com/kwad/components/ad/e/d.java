package com.kwad.components.ad.e;

import android.content.Context;
import android.view.View;
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
import com.kwad.components.ad.e.a.e;
import com.kwad.components.ad.e.a.f;
import com.kwad.components.ad.e.a.g;
import com.kwad.components.ad.e.a.h;
import com.kwad.components.ad.e.a.i;
import com.kwad.components.ad.e.c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;
/* loaded from: classes5.dex */
public final class d extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a a;
    public KsNativeAd.VideoPlayListener b;
    public AdBasePvFrameLayout c;
    public DetailVideoView d;
    public com.kwad.components.ad.e.kwai.b e;
    public Presenter f;
    public AdTemplate g;
    public com.kwad.components.core.c.a.b h;
    public com.kwad.components.ad.e.b.a i;
    public com.kwad.components.core.widget.kwai.b j;
    public KsAdVideoPlayConfig k;
    public j l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new j(this) { // from class: com.kwad.components.ad.e.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.widget.j
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k.c(this.a.g);
                }
            }
        };
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0439, this);
            AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f091182);
            this.c = adBasePvFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f0911da);
            this.d = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.components.ad.e.kwai.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.components.ad.e.kwai.b bVar = new com.kwad.components.ad.e.kwai.b();
            bVar.c = this.c;
            AdTemplate adTemplate = this.g;
            bVar.d = adTemplate;
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.e = (this.h == null && com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(adTemplate))) ? new com.kwad.components.core.c.a.b(this.g) : this.h;
            bVar.f = this.i;
            return bVar;
        }
        return (com.kwad.components.ad.e.kwai.b) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new e());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.c());
            presenter.a((Presenter) new i());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.j());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.d());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.b());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.k());
            presenter.a((Presenter) new com.kwad.components.ad.e.a.a(this.k));
            presenter.a((Presenter) new g());
            presenter.a(com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(this.g)) ? new f() : new h());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, bVar, ksAdVideoPlayConfig) == null) {
            this.g = adTemplate;
            this.h = bVar;
            this.k = ksAdVideoPlayConfig;
            this.c.setVisibleListener(this.l);
            this.j = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a_();
            com.kwad.components.core.widget.kwai.b bVar = this.j;
            if (bVar != null) {
                bVar.f();
            }
            com.kwad.components.ad.e.b.a aVar = this.i;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.components.ad.e.kwai.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.a();
            }
            Presenter presenter = this.f;
            if (presenter != null) {
                presenter.p();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            if (this.i == null) {
                this.i = new com.kwad.components.ad.e.b.a(this.g, this.j, this.d, this.k);
            }
            this.e = d();
            Presenter e = e();
            this.f = e;
            e.c(this.c);
            this.f.a(this.e);
            this.j.b();
            this.i.a();
        }
    }

    public final void setInnerAdInteractionListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoPlayListener) == null) {
            this.b = videoPlayListener;
        }
    }
}
