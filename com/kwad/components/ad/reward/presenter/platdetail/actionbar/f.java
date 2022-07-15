package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.o;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.l.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements RewardActionBarControl.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public o c;
    public KsLogoView d;
    public int e;
    public FrameLayout.LayoutParams f;
    public o.a g;

    public f(ViewGroup viewGroup, o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = viewGroup;
        this.g = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.components.ad.reward.presenter.a) this).a.m.a(this);
            AdInfo i = com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            this.e = this.d.getVisibility();
            this.f = d.a(u(), i, this.d, R.dimen.obfuscated_res_0x7f0703e0, true);
            o oVar = new o(this.b, new com.kwad.components.ad.reward.i.a(this, u(), ((com.kwad.components.ad.reward.presenter.a) this).a) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (l) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.i.a, com.kwad.components.ad.reward.i.b
                public final void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 10, 2);
                    }
                }

                @Override // com.kwad.components.ad.reward.i.a, com.kwad.components.ad.reward.i.b
                public final void g() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 10, 2);
                    }
                }
            });
            this.c = oVar;
            oVar.a(this.g);
            this.c.b(w.a(((com.kwad.components.ad.reward.presenter.a) this).a.g));
            j.a(new com.kwad.components.core.widget.f(), this.c.a());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.b.setVisibility(0);
            RewardActionBarControl.a(aVar, this.b, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.d = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            this.d.setVisibility(this.e);
            FrameLayout.LayoutParams layoutParams = this.f;
            if (layoutParams != null) {
                this.d.setLayoutParams(layoutParams);
            }
        }
    }
}
