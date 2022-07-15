package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
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
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class b extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener a;
    public AdBaseFrameLayout b;
    public DetailVideoView c;
    public com.kwad.components.ad.draw.kwai.b d;
    public Presenter e;
    @NonNull
    public AdTemplate f;
    public AdInfo g;
    public com.kwad.components.ad.draw.b.a h;
    public com.kwad.components.core.widget.kwai.b i;
    public Context j;
    public boolean k;
    public ImageView l;
    public View.OnClickListener m;
    public g n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
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
        this.m = new View.OnClickListener(this) { // from class: com.kwad.components.ad.draw.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    com.kwad.components.core.c.a.a.a(new a.C0507a(this.a.d.b.getContext()).a(this.a.d.c).a(this.a.d.d).a(false).a(3).a(new a.b(this) { // from class: com.kwad.components.ad.draw.b.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            }
                        }
                    }));
                    if (3 == com.kwad.sdk.core.response.a.a.ai(com.kwad.sdk.core.response.a.d.i(this.a.d.c))) {
                        this.a.d();
                    }
                }
            }
        };
        this.n = new h(this) { // from class: com.kwad.components.ad.draw.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.a.l.setVisibility(0);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.b();
                    this.a.l.setVisibility(8);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.c();
                    this.a.l.setVisibility(8);
                }
            }
        };
        this.j = context;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            View.inflate(this.j, R.layout.obfuscated_res_0x7f0d0415, this);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091182);
            this.b = adBaseFrameLayout;
            this.l = (ImageView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0911c4);
            DetailVideoView detailVideoView = (DetailVideoView) this.b.findViewById(R.id.obfuscated_res_0x7f0911da);
            this.c = detailVideoView;
            detailVideoView.setAd(true);
            this.c.setOnClickListener(this.m);
            this.l.setOnClickListener(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.h.a(!this.k);
            if (this.k) {
                this.h.c();
            } else {
                this.h.d();
            }
            this.k = !this.k;
        }
    }

    private com.kwad.components.ad.draw.kwai.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            com.kwad.components.ad.draw.kwai.b bVar = new com.kwad.components.ad.draw.kwai.b();
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.f;
            if (com.kwad.sdk.core.response.a.a.I(this.g)) {
                bVar.d = new com.kwad.components.core.c.a.b(this.f);
            }
            bVar.e = this.h;
            bVar.f = new com.kwad.components.ad.draw.a.a.a(this.f);
            if (com.kwad.sdk.core.response.a.b.m(this.f)) {
                bVar.g = new com.kwad.components.ad.h.b();
            }
            return bVar;
        }
        return (com.kwad.components.ad.draw.kwai.b) invokeV.objValue;
    }

    private Presenter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.kwai.a());
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.b());
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.d());
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.c());
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.a.b());
            if (com.kwad.sdk.core.response.a.b.c(this.f)) {
                presenter.a((Presenter) new com.kwad.components.ad.draw.a.a.c());
            }
            presenter.a((Presenter) new com.kwad.components.ad.draw.a.b.a());
            if (com.kwad.sdk.core.response.a.b.m(this.f)) {
                presenter.a((Presenter) new com.kwad.components.ad.draw.a.b.b());
            }
            if (com.kwad.sdk.core.response.a.a.K(this.g)) {
                presenter.a((Presenter) new com.kwad.components.ad.draw.a.a());
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.f = adTemplate;
            this.g = com.kwad.sdk.core.response.a.d.i(adTemplate);
            com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this, 70);
            this.i = bVar;
            this.h = new com.kwad.components.ad.draw.b.a(this.f, bVar, this.c);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a_();
            com.kwad.components.core.widget.kwai.b bVar = this.i;
            if (bVar != null) {
                bVar.f();
            }
            com.kwad.components.ad.draw.b.a aVar = this.h;
            if (aVar != null) {
                aVar.b();
                this.h.b(this.n);
            }
            com.kwad.components.ad.draw.kwai.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.a();
            }
            Presenter presenter = this.e;
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
            this.d = e();
            Presenter f = f();
            this.e = f;
            f.c(this.b);
            this.e.a(this.d);
            this.i.b();
            this.h.a();
            this.h.a(this.n);
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.a = adInteractionListener;
        }
    }
}
