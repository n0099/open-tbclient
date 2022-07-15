package com.kwad.components.ad.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.page.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout b;
    public com.kwad.components.core.page.c c;
    public AdTemplate d;
    public AdBaseFrameLayout e;
    public ComplianceTextView f;
    public volatile long g;
    public volatile boolean h;
    public final g i;
    public final f j;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0L;
        this.h = false;
        this.i = new h(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    super.a(j, j2);
                    this.a.g = j2;
                    this.a.h = j - j2 < 800;
                }
            }
        };
        this.j = new f(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.components.ad.reward.presenter.a) this.a).a.A || this.a.b == null || this.a.c == null || !this.a.c.b()) {
                    return;
                }
                this.a.f.setVisibility(8);
                this.a.b.setVisibility(0);
                this.a.c.c();
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.d = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            if (this.c == null) {
                com.kwad.components.core.page.c cVar = new com.kwad.components.core.page.c(u(), this.d, 4, false);
                this.c = cVar;
                cVar.a(this);
                this.c.a(new c.C0515c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.n(this.d)).a());
                this.b.addView(this.c.a());
            }
            this.g = 0L;
            this.h = false;
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.e = lVar.h;
            lVar.a(this.j);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.a(this.i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e_();
            com.kwad.components.core.page.c cVar = this.c;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (FrameLayout) b(R.id.obfuscated_res_0x7f09105a);
            this.f = (ComplianceTextView) b(R.id.obfuscated_res_0x7f09101a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.j);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.i);
        }
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onBackBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            if (lVar.b != null) {
                long r = com.kwad.sdk.core.response.a.a.r(com.kwad.sdk.core.response.a.d.i(lVar.g));
                boolean z = true;
                if (r >= 0 && !this.h && this.g < r) {
                    z = false;
                }
                if (z) {
                    ((com.kwad.components.ad.reward.presenter.a) this).a.b.e();
                }
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a(false);
            j();
        }
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onCloseBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }
}
