package com.kwad.sdk.draw;

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
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.j.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.d.c;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f72576a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f72577b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f72578c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f72579d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f72580e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f72581f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f72582g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f72583h;

    /* renamed from: i  reason: collision with root package name */
    public e f72584i;

    /* renamed from: j  reason: collision with root package name */
    public Context f72585j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
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
        this.f72585j = context;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            FrameLayout.inflate(this.f72585j, R.layout.ksad_draw_layout, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.f72577b = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.f72578c = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.sdk.draw.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
            bVar.f72587a = this.f72576a;
            bVar.f72588b = this.f72577b;
            bVar.f72589c = this.f72581f;
            if (com.kwad.sdk.core.response.b.a.v(this.f72582g)) {
                bVar.f72590d = new com.kwad.sdk.core.download.b.b(this.f72581f);
            }
            bVar.f72591e = this.f72583h;
            bVar.f72592f = new com.kwad.sdk.draw.b.b.a(this.f72581f);
            if (com.kwad.sdk.core.response.b.b.j(this.f72581f)) {
                bVar.f72593g = new c();
            }
            return bVar;
        }
        return (com.kwad.sdk.draw.a.b) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.draw.b.a.a());
            presenter.a((Presenter) new com.kwad.sdk.draw.b.a());
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c());
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b());
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.b());
            if (com.kwad.sdk.core.response.b.b.i(this.f72581f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
            if (com.kwad.sdk.core.response.b.b.j(this.f72581f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f72579d = d();
            Presenter e2 = e();
            this.f72580e = e2;
            e2.a((View) this.f72577b);
            this.f72580e.a(this.f72579d);
            this.f72584i.a();
            this.f72583h.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f72581f = adTemplate;
            this.f72582g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            e eVar = new e(this, 70);
            this.f72584i = eVar;
            this.f72583h = new com.kwad.sdk.draw.c.a(this.f72581f, eVar, this.f72578c);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            e eVar = this.f72584i;
            if (eVar != null) {
                eVar.f();
            }
            com.kwad.sdk.draw.c.a aVar = this.f72583h;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.draw.a.b bVar = this.f72579d;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f72580e;
            if (presenter != null) {
                presenter.h();
            }
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f72576a = adInteractionListener;
        }
    }
}
