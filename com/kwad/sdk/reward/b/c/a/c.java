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
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f73279b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f73280c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f73281d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f73282e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73283f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f73284g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.d.c f73285h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73286i;

    /* renamed from: j  reason: collision with root package name */
    public f f73287j;

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
        this.f73287j = new f(this) { // from class: com.kwad.sdk.reward.b.c.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73288a;

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
                this.f73288a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.sdk.reward.d) this.f73288a).f73410a.t || ((com.kwad.sdk.reward.d) this.f73288a).f73410a.u) {
                    return;
                }
                if (this.f73288a.f73285h != null && this.f73288a.f73285h.d()) {
                    this.f73288a.f73286i = false;
                    return;
                }
                this.f73288a.f73286i = true;
                this.f73288a.f();
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.f73286i) {
            this.f73279b.b();
            this.f73279b.setVisibility(8);
            this.f73280c.b();
            this.f73280c.setVisibility(8);
            this.f73281d.b();
            this.f73281d.setVisibility(8);
            this.f73282e.b();
            this.f73282e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (((com.kwad.sdk.reward.d) this).f73410a.f73072e == 0) {
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
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f73284g);
            return C.height > C.width;
        }
        return invokeV.booleanValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f73279b.a(this.f73283f, ((com.kwad.sdk.reward.d) this).f73410a.f73071d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73289a;

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
                    this.f73289a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73289a.s();
                    }
                }
            });
            this.f73279b.setVisibility(0);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f73280c.a(this.f73283f, ((com.kwad.sdk.reward.d) this).f73410a.f73071d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73290a;

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
                    this.f73290a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73290a.s();
                    }
                }
            });
            this.f73280c.setVisibility(0);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f73281d.a(this.f73283f, ((com.kwad.sdk.reward.d) this).f73410a.f73071d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73291a;

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
                    this.f73291a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73291a.s();
                    }
                }
            });
            this.f73281d.setVisibility(0);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f73282e.a(this.f73283f, ((com.kwad.sdk.reward.d) this).f73410a.f73071d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73292a;

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
                    this.f73292a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73292a.s();
                    }
                }
            });
            this.f73282e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f73283f, 2, ((com.kwad.sdk.reward.d) this).f73410a.f73075h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f73410a.f73071d);
            ((com.kwad.sdk.reward.d) this).f73410a.f73069b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f73410a.f73073f;
            this.f73283f = adTemplate;
            this.f73284g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73410a;
            this.f73285h = aVar.l;
            aVar.a(this.f73287j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73279b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
            this.f73280c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
            this.f73281d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
            this.f73282e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            e();
            ((com.kwad.sdk.reward.d) this).f73410a.b(this.f73287j);
        }
    }
}
