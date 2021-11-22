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
/* loaded from: classes2.dex */
public class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f66464a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f66465b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f66466c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f66467d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f66468e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f66469f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f66470g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f66471h;

    /* renamed from: i  reason: collision with root package name */
    public e f66472i;
    public Context j;

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
        this.j = context;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.f66465b = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.f66466c = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.sdk.draw.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
            bVar.f66474a = this.f66464a;
            bVar.f66475b = this.f66465b;
            bVar.f66476c = this.f66469f;
            if (com.kwad.sdk.core.response.b.a.v(this.f66470g)) {
                bVar.f66477d = new com.kwad.sdk.core.download.b.b(this.f66469f);
            }
            bVar.f66478e = this.f66471h;
            bVar.f66479f = new com.kwad.sdk.draw.b.b.a(this.f66469f);
            if (com.kwad.sdk.core.response.b.b.j(this.f66469f)) {
                bVar.f66480g = new c();
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
            if (com.kwad.sdk.core.response.b.b.i(this.f66469f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
            if (com.kwad.sdk.core.response.b.b.j(this.f66469f)) {
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
            this.f66467d = d();
            Presenter e2 = e();
            this.f66468e = e2;
            e2.a((View) this.f66465b);
            this.f66468e.a(this.f66467d);
            this.f66472i.a();
            this.f66471h.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f66469f = adTemplate;
            this.f66470g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            e eVar = new e(this, 70);
            this.f66472i = eVar;
            this.f66471h = new com.kwad.sdk.draw.c.a(this.f66469f, eVar, this.f66466c);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            e eVar = this.f66472i;
            if (eVar != null) {
                eVar.f();
            }
            com.kwad.sdk.draw.c.a aVar = this.f66471h;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.draw.a.b bVar = this.f66467d;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f66468e;
            if (presenter != null) {
                presenter.h();
            }
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f66464a = adInteractionListener;
        }
    }
}
