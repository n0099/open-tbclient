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
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.view.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f37025a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f37026b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f37027c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f37028d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f37029e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f37030f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f37031g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f37032h;

    /* renamed from: i  reason: collision with root package name */
    public g f37033i;
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
            this.f37026b = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.f37027c = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private com.kwad.sdk.draw.a.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
            bVar.f37035a = this.f37025a;
            bVar.f37036b = this.f37026b;
            bVar.f37037c = this.f37030f;
            if (com.kwad.sdk.core.response.b.a.y(this.f37031g)) {
                bVar.f37038d = new com.kwad.sdk.core.download.b.b(this.f37030f);
            }
            bVar.f37039e = this.f37032h;
            bVar.f37040f = new com.kwad.sdk.draw.b.b.a(this.f37030f);
            if (com.kwad.sdk.core.response.b.b.p(this.f37030f)) {
                bVar.f37041g = new c();
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
            if (com.kwad.sdk.core.response.b.b.o(this.f37030f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
            if (com.kwad.sdk.core.response.b.b.p(this.f37030f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37028d = d();
            Presenter e2 = e();
            this.f37029e = e2;
            e2.a((View) this.f37026b);
            this.f37029e.a(this.f37028d);
            this.f37033i.a();
            this.f37032h.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f37030f = adTemplate;
            this.f37031g = com.kwad.sdk.core.response.b.c.j(adTemplate);
            g gVar = new g(this, 70);
            this.f37033i = gVar;
            this.f37032h = new com.kwad.sdk.draw.c.a(this.f37030f, gVar, this.f37027c);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g gVar = this.f37033i;
            if (gVar != null) {
                gVar.c();
            }
            com.kwad.sdk.draw.c.a aVar = this.f37032h;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.draw.a.b bVar = this.f37028d;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f37029e;
            if (presenter != null) {
                presenter.j();
            }
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f37025a = adInteractionListener;
        }
    }
}
