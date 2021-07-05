package com.kwad.sdk.contentalliance.detail.photo.e;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.g.a.a f34786b;

    /* renamed from: c  reason: collision with root package name */
    public long f34787c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34788d;

    /* renamed from: e  reason: collision with root package name */
    public int f34789e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f34790f;

    public e() {
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
        this.f34787c = 0L;
        this.f34789e = 2;
        this.f34790f = new com.kwad.sdk.contentalliance.trends.view.d(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f34791a;

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
                this.f34791a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34791a.f34786b.setVisibility(4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f34791a.f34788d) {
                    this.f34791a.f34786b.setVisibility(0);
                }
            }
        };
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? i2 == 1 : invokeI.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
            boolean v = com.kwad.sdk.core.response.b.d.v(k);
            this.f34788d = v;
            if (v) {
                this.f34789e = com.kwad.sdk.core.response.b.d.w(k);
                long o = com.kwad.sdk.core.response.b.d.o(k);
                this.f34787c = o;
                this.f34786b.setAuthorId(o);
                this.f34786b.setAlignment(c(this.f34789e) ? 1 : 0);
                a(this.f34789e);
                this.f34786b.setVisibility(0);
                if (!com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                    return;
                }
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.a(this.f34790f);
                if (!((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a.l) {
                    this.f34786b.setVisibility(0);
                    return;
                }
            }
            this.f34786b.setVisibility(4);
        }
    }

    public void a(int i2) {
        Context o;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f34786b.getLayoutParams();
            if (i2 == 2) {
                layoutParams.gravity = 3;
                layoutParams.leftMargin = ao.a(o(), 12.0f);
            } else {
                layoutParams.gravity = 5;
                layoutParams.rightMargin = ao.a(o(), 12.0f);
            }
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            if (!adTemplate.mIsTubeEpisodeList) {
                if (com.kwad.sdk.core.response.b.c.B(adTemplate)) {
                    o = o();
                    f2 = 105.0f;
                }
                this.f34786b.setLayoutParams(layoutParams);
            }
            o = o();
            f2 = 95.0f;
            layoutParams.topMargin = ao.a(o, f2);
            this.f34786b.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.b(this.f34790f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            this.f34786b = (com.kwad.sdk.contentalliance.detail.photo.g.a.a) b(R.id.ksad_video_water_mark);
        }
    }
}
