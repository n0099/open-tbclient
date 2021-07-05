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
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitHorizontal;
import com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TailFramePortraitVertical f38994b;

    /* renamed from: c  reason: collision with root package name */
    public TailFramePortraitHorizontal f38995c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameLandscapeVertical f38996d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameLandscapeHorizontal f38997e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f38998f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f38999g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c f39000h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39001i;
    public e j;

    public a() {
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
        this.j = new e(this) { // from class: com.kwad.sdk.reward.b.c.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39002a;

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
                this.f39002a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f39002a.f39000h != null && this.f39002a.f39000h.d()) {
                        this.f39002a.f39001i = false;
                        return;
                    }
                    this.f39002a.f39001i = true;
                    this.f39002a.f();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.f39001i) {
            this.f38994b.b();
            this.f38994b.setVisibility(8);
            this.f38995c.b();
            this.f38995c.setVisibility(8);
            this.f38996d.b();
            this.f38996d.setVisibility(8);
            this.f38997e.b();
            this.f38997e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (((d) this).f39062a.f38815e == 0) {
                if (g()) {
                    h();
                } else {
                    p();
                }
            } else if (g()) {
                q();
            } else {
                r();
            }
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f38999g);
            return E.height > E.width;
        }
        return invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f38994b.a(this.f38998f, ((d) this).f39062a.f38814d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39003a;

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
                    this.f39003a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39003a.s();
                    }
                }
            });
            this.f38994b.setVisibility(0);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f38995c.a(this.f38998f, ((d) this).f39062a.f38814d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39004a;

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
                    this.f39004a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39004a.s();
                    }
                }
            });
            this.f38995c.setVisibility(0);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f38996d.a(this.f38998f, ((d) this).f39062a.f38814d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39005a;

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
                    this.f39005a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39005a.s();
                    }
                }
            });
            this.f38996d.setVisibility(0);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f38997e.a(this.f38998f, ((d) this).f39062a.f38814d, new com.kwad.sdk.reward.widget.tailframe.b(this) { // from class: com.kwad.sdk.reward.b.c.a.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f39006a;

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
                    this.f39006a = this;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39006a.s();
                    }
                }
            });
            this.f38997e.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f38998f, 2, ((d) this).f39062a.f38818h.getTouchCoords(), ((d) this).f39062a.f38814d);
            ((d) this).f39062a.f38812b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((d) this).f39062a.f38816f;
            this.f38998f = adTemplate;
            this.f38999g = com.kwad.sdk.core.response.b.c.j(adTemplate);
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            this.f39000h = aVar.l;
            aVar.n.add(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            e();
            ((d) this).f39062a.n.remove(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38994b = (TailFramePortraitVertical) b(R.id.ksad_video_portrait_vertical);
            this.f38995c = (TailFramePortraitHorizontal) b(R.id.ksad_video_portrait_horizontal);
            this.f38996d = (TailFrameLandscapeVertical) b(R.id.ksad_video_landscape_vertical);
            this.f38997e = (TailFrameLandscapeHorizontal) b(R.id.ksad_video_landscape_horizontal);
        }
    }
}
