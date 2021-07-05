package com.kwad.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.a.b.c;
import com.kwad.sdk.a.b.d;
import com.kwad.sdk.a.b.e;
import com.kwad.sdk.a.b.f;
import com.kwad.sdk.a.b.h;
import com.kwad.sdk.a.b.i;
import com.kwad.sdk.a.b.j;
import com.kwad.sdk.a.b.k;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.core.view.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f34074a;

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f34075b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f34076c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f34077d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.a.b f34078e;

    /* renamed from: f  reason: collision with root package name */
    public Presenter f34079f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34080g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f34081h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34082i;
    public com.kwad.sdk.a.c.a j;
    public g k;
    public KsAdVideoPlayConfig l;

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
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.ksad_native_video_layout, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.f34076c = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.f34077d = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.sdk.a.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.kwad.sdk.a.a.b bVar = new com.kwad.sdk.a.a.b();
            bVar.f34070c = this.f34076c;
            bVar.f34071d = this.f34080g;
            bVar.f34068a = this.f34074a;
            bVar.f34069b = this.f34075b;
            bVar.f34072e = (this.f34082i == null && com.kwad.sdk.core.response.b.a.y(this.f34081h)) ? new com.kwad.sdk.core.download.b.b(this.f34080g) : this.f34082i;
            bVar.f34073f = this.j;
            return bVar;
        }
        return (com.kwad.sdk.a.a.b) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new e());
            presenter.a((Presenter) new c());
            presenter.a((Presenter) new i());
            presenter.a((Presenter) new j());
            presenter.a((Presenter) new d());
            presenter.a((Presenter) new com.kwad.sdk.a.b.b());
            presenter.a((Presenter) new k());
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.l;
            if (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) {
                presenter.a((Presenter) new com.kwad.sdk.a.b.a());
            }
            presenter.a((Presenter) new com.kwad.sdk.a.b.g());
            presenter.a(com.kwad.sdk.core.response.b.a.y(this.f34081h) ? new f() : new h());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34078e = d();
            Presenter e2 = e();
            this.f34079f = e2;
            e2.a((View) this.f34076c);
            this.f34079f.a(this.f34078e);
            this.k.a();
            this.j.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, bVar, ksAdVideoPlayConfig) == null) {
            this.f34080g = adTemplate;
            this.f34081h = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f34082i = bVar;
            this.l = ksAdVideoPlayConfig;
            g gVar = new g(getParent() == null ? this : (View) getParent(), 30);
            this.k = gVar;
            this.j = new com.kwad.sdk.a.c.a(this.f34080g, gVar, this.f34077d, ksAdVideoPlayConfig);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g gVar = this.k;
            if (gVar != null) {
                gVar.c();
            }
            com.kwad.sdk.a.c.a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.a.a.b bVar = this.f34078e;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f34079f;
            if (presenter != null) {
                presenter.j();
            }
        }
    }

    public void setAdInteractionListener(KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f34074a = adInteractionListener;
        }
    }

    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoPlayListener) == null) {
            this.f34075b = videoPlayListener;
        }
    }
}
