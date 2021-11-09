package com.kwad.sdk.reward.b.c.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f66212b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f66213c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f66214d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f66215e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f66216f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f66217g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.d.c f66218h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66219i;
    public f j;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new f(this) { // from class: com.kwad.sdk.reward.b.c.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66220a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66220a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.sdk.reward.d) this.f66220a).f66342a.t || ((com.kwad.sdk.reward.d) this.f66220a).f66342a.u) {
                    return;
                }
                if (this.f66220a.f66218h != null && this.f66220a.f66218h.d()) {
                    this.f66220a.f66219i = false;
                    return;
                }
                this.f66220a.f66219i = true;
                this.f66220a.f();
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.f66219i) {
            this.f66212b.b();
            this.f66212b.setVisibility(8);
            this.f66213c.b();
            this.f66213c.setVisibility(8);
            this.f66214d.b();
            this.f66214d.setVisibility(8);
            this.f66215e.b();
            this.f66215e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (((com.kwad.sdk.reward.d) this).f66342a.f66014e == 0) {
                if (n()) {
                    o();
                } else {
                    p();
                }
            } else if (n()) {
                q();
            } else {
                r();
            }
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f66217g);
            return C.height > C.width;
        }
        return invokeV.booleanValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f66212b.a(this.f66216f, ((com.kwad.sdk.reward.d) this).f66342a.f66013d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66221a;

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
                    this.f66221a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66221a.s();
                    }
                }
            });
            this.f66212b.setVisibility(0);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f66213c.a(this.f66216f, ((com.kwad.sdk.reward.d) this).f66342a.f66013d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66222a;

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
                    this.f66222a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66222a.s();
                    }
                }
            });
            this.f66213c.setVisibility(0);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f66214d.a(this.f66216f, ((com.kwad.sdk.reward.d) this).f66342a.f66013d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66223a;

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
                    this.f66223a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66223a.s();
                    }
                }
            });
            this.f66214d.setVisibility(0);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f66215e.a(this.f66216f, ((com.kwad.sdk.reward.d) this).f66342a.f66013d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66224a;

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
                    this.f66224a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66224a.s();
                    }
                }
            });
            this.f66215e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f66216f, 2, ((com.kwad.sdk.reward.d) this).f66342a.f66017h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66342a.f66013d);
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f66342a.f66015f;
            this.f66216f = adTemplate;
            this.f66217g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            this.f66218h = aVar.l;
            aVar.a(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f66212b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
            this.f66213c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
            this.f66214d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
            this.f66215e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            e();
            ((com.kwad.sdk.reward.d) this).f66342a.b(this.j);
        }
    }
}
