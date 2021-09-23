package com.kwad.sdk.b;

import android.content.Context;
import android.view.View;
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
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.b.b.c;
import com.kwad.sdk.b.b.f;
import com.kwad.sdk.b.b.g;
import com.kwad.sdk.b.b.h;
import com.kwad.sdk.b.b.i;
import com.kwad.sdk.b.b.k;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.j.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.d;
/* loaded from: classes10.dex */
public class b extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f71516a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f71517b;

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f71518c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f71519d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.b.a.b f71520e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f71521f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f71522g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f71523h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f71524i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.b.c.a f71525j;
    public e k;
    public KsAdVideoPlayConfig l;
    public d m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new d(this) { // from class: com.kwad.sdk.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f71526a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f71526a = this;
            }

            @Override // com.kwad.sdk.widget.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    j.c(this.f71526a.f71522g);
                }
            }
        };
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
            AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
            this.f71518c = adBasePvFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
            this.f71519d = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.sdk.b.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.sdk.b.a.b bVar = new com.kwad.sdk.b.a.b();
            bVar.f71512c = this.f71518c;
            bVar.f71513d = this.f71522g;
            bVar.f71510a = this.f71516a;
            bVar.f71511b = this.f71517b;
            bVar.f71514e = (this.f71524i == null && com.kwad.sdk.core.response.b.a.v(this.f71523h)) ? new com.kwad.sdk.core.download.b.b(this.f71522g) : this.f71524i;
            bVar.f71515f = this.f71525j;
            return bVar;
        }
        return (com.kwad.sdk.b.a.b) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.b.b.e());
            presenter.a((Presenter) new c());
            presenter.a((Presenter) new i());
            presenter.a((Presenter) new com.kwad.sdk.b.b.j());
            presenter.a((Presenter) new com.kwad.sdk.b.b.d());
            presenter.a((Presenter) new com.kwad.sdk.b.b.b());
            presenter.a((Presenter) new k());
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.l;
            if (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) {
                presenter.a((Presenter) new com.kwad.sdk.b.b.a());
            }
            presenter.a((Presenter) new g());
            presenter.a(com.kwad.sdk.core.response.b.a.v(this.f71523h) ? new f() : new h());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.f71525j == null) {
                this.f71525j = new com.kwad.sdk.b.c.a(this.f71522g, this.k, this.f71519d, this.l);
            }
            this.f71520e = d();
            Presenter e2 = e();
            this.f71521f = e2;
            e2.a((View) this.f71518c);
            this.f71521f.a(this.f71520e);
            this.k.a();
            this.f71525j.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, bVar, ksAdVideoPlayConfig) == null) {
            this.f71522g = adTemplate;
            this.f71523h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f71524i = bVar;
            this.l = ksAdVideoPlayConfig;
            this.f71518c.setVisibleListener(this.m);
            this.k = new e(getParent() == null ? this : (View) getParent(), 30);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            e eVar = this.k;
            if (eVar != null) {
                eVar.f();
            }
            com.kwad.sdk.b.c.a aVar = this.f71525j;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.b.a.b bVar = this.f71520e;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f71521f;
            if (presenter != null) {
                presenter.h();
            }
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f71516a = adInteractionListener;
        }
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoPlayListener) == null) {
            this.f71517b = videoPlayListener;
        }
    }
}
