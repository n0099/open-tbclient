package com.kwad.sdk.draw;

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
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.a.c;
import com.kwad.sdk.draw.a.d;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes2.dex */
public class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f58310b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f58311c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.kwai.b f58312d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f58313e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f58314f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f58315g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f58316h;

    /* renamed from: i  reason: collision with root package name */
    public f f58317i;

    /* renamed from: j  reason: collision with root package name */
    public Context f58318j;

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
        this.f58318j = context;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            FrameLayout.inflate(this.f58318j, R.layout.ksad_draw_layout, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.f58310b = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.f58311c = detailVideoView;
            detailVideoView.setAd(true);
            this.f58311c.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.draw.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.a.f58312d.f58378b.getContext()).a(this.a.f58312d.f58379c).a(this.a.f58312d.f58380d).a(false).a(3).a(new a.b(this) { // from class: com.kwad.sdk.draw.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                }
                            }
                        }));
                    }
                }
            });
        }
    }

    private com.kwad.sdk.draw.kwai.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.kwad.sdk.draw.kwai.b bVar = new com.kwad.sdk.draw.kwai.b();
            bVar.a = this.a;
            bVar.f58378b = this.f58310b;
            bVar.f58379c = this.f58314f;
            if (com.kwad.sdk.core.response.a.a.B(this.f58315g)) {
                bVar.f58380d = new com.kwad.sdk.core.download.a.b(this.f58314f);
            }
            bVar.f58381e = this.f58316h;
            bVar.f58382f = new com.kwad.sdk.draw.a.a.a(this.f58314f);
            if (com.kwad.sdk.core.response.a.b.h(this.f58314f)) {
                bVar.f58383g = new com.kwad.sdk.i.b();
            }
            return bVar;
        }
        return (com.kwad.sdk.draw.kwai.b) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.draw.a.kwai.a());
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b());
            presenter.a((Presenter) new d());
            presenter.a((Presenter) new c());
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.b());
            if (com.kwad.sdk.core.response.a.b.d(this.f58314f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
            if (com.kwad.sdk.core.response.a.b.h(this.f58314f)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
            }
            if (com.kwad.sdk.core.response.a.a.D(this.f58315g)) {
                presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
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
            this.f58312d = d();
            Presenter e2 = e();
            this.f58313e = e2;
            e2.c(this.f58310b);
            this.f58313e.a(this.f58312d);
            this.f58317i.a();
            this.f58316h.a();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f58314f = adTemplate;
            this.f58315g = com.kwad.sdk.core.response.a.d.j(adTemplate);
            f fVar = new f(this, 70);
            this.f58317i = fVar;
            this.f58316h = new com.kwad.sdk.draw.b.a(this.f58314f, fVar, this.f58311c);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            f fVar = this.f58317i;
            if (fVar != null) {
                fVar.g();
            }
            com.kwad.sdk.draw.b.a aVar = this.f58316h;
            if (aVar != null) {
                aVar.b();
            }
            com.kwad.sdk.draw.kwai.b bVar = this.f58312d;
            if (bVar != null) {
                bVar.a();
            }
            Presenter presenter = this.f58313e;
            if (presenter != null) {
                presenter.k();
            }
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.a = adInteractionListener;
        }
    }
}
