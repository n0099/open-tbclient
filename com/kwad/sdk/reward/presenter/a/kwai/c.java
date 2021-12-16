package com.kwad.sdk.reward.presenter.a.kwai;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.l;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes3.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f59647b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f59648c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f59649d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f59650e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59651f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59652g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.i.b f59653h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59654i;

    /* renamed from: j  reason: collision with root package name */
    public l.b f59655j;

    /* renamed from: k  reason: collision with root package name */
    public f f59656k;

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
        this.f59656k = new f(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.sdk.core.response.a.a.aG(this.a.f59652g)) {
                        l.a(this.a.o(), this.a.f59651f, this.a.f59655j);
                    } else if (((g) this.a).a.x) {
                    } else {
                        if (this.a.f59653h != null && this.a.f59653h.d()) {
                            this.a.f59654i = false;
                            return;
                        }
                        this.a.f59654i = true;
                        this.a.i();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.f59651f, z ? 2 : 153, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
            ((g) this).a.f59450b.a();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f59654i) {
            this.f59647b.a();
            this.f59647b.setVisibility(8);
            this.f59648c.a();
            this.f59648c.setVisibility(8);
            this.f59649d.a();
            this.f59649d.setVisibility(8);
            this.f59650e.a();
            this.f59650e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (((g) this).a.f59454f == 0) {
                if (r()) {
                    s();
                } else {
                    t();
                }
            } else if (r()) {
                u();
            } else {
                v();
            }
        }
    }

    private boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f59652g);
            return J.height > J.width;
        }
        return invokeV.booleanValue;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.f59647b.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.sdk.reward.widget.tailframe.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            });
            this.f59647b.setVisibility(0);
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f59648c.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.sdk.reward.widget.tailframe.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            });
            this.f59648c.setVisibility(0);
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f59649d.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.sdk.reward.widget.tailframe.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            });
            this.f59649d.setVisibility(0);
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.f59650e.a(this.f59651f, ((g) this).a.f59453e, new com.kwad.sdk.reward.widget.tailframe.a(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // com.kwad.sdk.reward.widget.tailframe.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.a.b(z);
                    }
                }
            });
            this.f59650e.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59647b.setCallerContext(((g) this).a);
            this.f59648c.setCallerContext(((g) this).a);
            this.f59649d.setCallerContext(((g) this).a);
            this.f59650e.setCallerContext(((g) this).a);
            AdTemplate adTemplate = ((g) this).a.f59455g;
            this.f59651f = adTemplate;
            this.f59652g = com.kwad.sdk.core.response.a.d.j(adTemplate);
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            this.f59653h = aVar.o;
            aVar.a(this.f59656k);
        }
    }

    public void a(l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f59655j = bVar;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            e();
            ((g) this).a.b(this.f59656k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c_();
            this.f59647b = (TailFramePortraitVertical) a(R.id.ksad_video_portrait_vertical);
            this.f59648c = (TailFramePortraitHorizontal) a(R.id.ksad_video_portrait_horizontal);
            this.f59649d = (TailFrameLandscapeVertical) a(R.id.ksad_video_landscape_vertical);
            this.f59650e = (TailFrameLandscapeHorizontal) a(R.id.ksad_video_landscape_horizontal);
        }
    }
}
