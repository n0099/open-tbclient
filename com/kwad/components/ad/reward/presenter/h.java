package com.kwad.components.ad.reward.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.g;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public final class h extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public com.kwad.components.ad.reward.i.g b;
    public RewardActionBarControl c;
    public boolean d;
    public KsLogoView e;
    @Nullable
    public com.kwad.components.ad.reward.i.m f;
    public com.kwad.components.core.video.g g;

    public h() {
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
        this.d = false;
        this.g = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

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
                    if (this.a.d) {
                        return;
                    }
                    if (this.a.b == null) {
                        this.a.c.a(false);
                    } else {
                        this.a.b.a(new g.a(this) { // from class: com.kwad.components.ad.reward.presenter.h.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
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

                            @Override // com.kwad.components.ad.reward.i.g.a
                            public final void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.c.a(true);
                                }
                            }
                        }, 500L);
                    }
                    this.a.d = true;
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            this.c = lVar.m;
            lVar.j.a(this.g);
            AdTemplate adTemplate = ((a) this).a.g;
            boolean z = com.kwad.sdk.core.response.a.b.C(adTemplate).displayWeakCard;
            ((a) this).a.a(z);
            if (z) {
                if (this.b == null) {
                    this.b = new com.kwad.components.ad.reward.i.g(((a) this).a);
                }
                this.b.a((ViewGroup) ((AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f091182)));
                this.b.b(w.a(adTemplate));
            }
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (com.kwad.sdk.core.response.a.a.b(adTemplate)) {
                if (this.f == null) {
                    this.f = new com.kwad.components.ad.reward.i.m(((a) this).a);
                }
                this.f.a((ViewGroup) ((a) this).a.h);
                this.f.b(w.a(adTemplate));
                com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(u(), i, this.e, R.dimen.obfuscated_res_0x7f070382, false);
            }
            ((a) this).a.m.a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        com.kwad.components.ad.reward.i.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, showActionBarResult, view2) == null) || (mVar = this.f) == null) {
            return;
        }
        mVar.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.e = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((a) this).a.j.b(this.g);
            ((a) this).a.m.b(this);
            com.kwad.components.ad.reward.i.m mVar = this.f;
            if (mVar != null) {
                mVar.b();
            }
        }
    }
}
