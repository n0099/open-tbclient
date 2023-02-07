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
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements RewardActionBarControl.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup es;
    public KsLogoView pM;
    public m rN;
    public int rO;
    public FrameLayout.LayoutParams rP;
    public m.a rQ;

    public e(ViewGroup viewGroup, m.a aVar) {
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
        this.es = viewGroup;
        this.rQ = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.nM.ml.a(this);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            this.rO = this.pM.getVisibility();
            this.rP = d.a(getContext(), bQ, this.pM, R.dimen.obfuscated_res_0x7f0703e0, true);
            m mVar = new m(this.es, new com.kwad.components.ad.reward.k.a(this, getContext(), this.nM) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e rR;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (k) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.rR = this;
                }

                @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
                public final void hA() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.rR.nM.a(this.rR.getContext(), 10, 2);
                    }
                }

                @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
                public final void hz() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.rR.nM.a(this.rR.getContext(), 10, 2);
                    }
                }
            });
            this.rN = mVar;
            mVar.a(this.rQ);
            this.rN.b(u.D(this.nM.mAdTemplate));
            j.a(new com.kwad.components.core.widget.f(), this.rN.fR());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.es.setVisibility(0);
            RewardActionBarControl.a(aVar, this.es, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091136);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            this.pM.setVisibility(this.rO);
            FrameLayout.LayoutParams layoutParams = this.rP;
            if (layoutParams != null) {
                this.pM.setLayoutParams(layoutParams);
            }
        }
    }
}
