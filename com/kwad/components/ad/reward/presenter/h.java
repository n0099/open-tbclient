package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.g;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public final class h extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.video.g mVideoPlayStateListener;
    public RewardActionBarControl ml;
    @Nullable
    public com.kwad.components.ad.reward.k.g pK;
    public boolean pL;
    public KsLogoView pM;
    @Nullable
    public com.kwad.components.ad.reward.k.k pN;

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
        this.pL = false;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h pO;

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
                this.pO = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    super.onVideoPlayProgress(j, j2);
                    if (this.pO.pL) {
                        return;
                    }
                    if (this.pO.pK == null) {
                        this.pO.ml.S(false);
                    } else {
                        this.pO.pK.a(new g.a(this) { // from class: com.kwad.components.ad.reward.presenter.h.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 pP;

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
                                this.pP = this;
                            }

                            @Override // com.kwad.components.ad.reward.k.g.a
                            public final void gX() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.pP.pO.ml.S(true);
                                }
                            }
                        }, 500L);
                    }
                    this.pO.pL = true;
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        com.kwad.components.ad.reward.k.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, showActionBarResult, view2) == null) || (kVar = this.pN) == null) {
            return;
        }
        kVar.iW();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            com.kwad.components.ad.reward.k kVar = this.nM;
            this.ml = kVar.ml;
            kVar.eF.a(this.mVideoPlayStateListener);
            AdTemplate adTemplate = this.nM.mAdTemplate;
            boolean z = com.kwad.sdk.core.response.a.b.bA(adTemplate).displayWeakCard;
            this.nM.B(z);
            if (z) {
                if (this.pK == null) {
                    this.pK = new com.kwad.components.ad.reward.k.g(this.nM);
                }
                this.pK.e((AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911d6));
                this.pK.b(u.D(adTemplate));
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (com.kwad.sdk.core.response.a.a.aK(adTemplate)) {
                if (this.pN == null) {
                    this.pN = new com.kwad.components.ad.reward.k.k(this.nM);
                }
                this.pN.f(this.nM.mRootContainer);
                this.pN.b(u.D(adTemplate));
                com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), bQ, this.pM, R.dimen.obfuscated_res_0x7f070380, false);
            }
            this.nM.ml.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091053);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            this.nM.eF.b(this.mVideoPlayStateListener);
            this.nM.ml.b(this);
            com.kwad.components.ad.reward.k.k kVar = this.pN;
            if (kVar != null) {
                kVar.onUnbind();
            }
        }
    }
}
