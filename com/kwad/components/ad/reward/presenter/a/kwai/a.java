package com.kwad.components.ad.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.page.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ComplianceTextView bc;
    public AdBaseFrameLayout ct;
    public com.kwad.components.core.page.c landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public final e mPlayEndPageListener;
    public final g mVideoPlayStateListener;
    public FrameLayout sr;
    public volatile long ss;
    public volatile boolean st;

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
        this.ss = 0L;
        this.st = false;
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a su;

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
                this.su = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    super.onVideoPlayProgress(j, j2);
                    this.su.ss = j2;
                    this.su.st = j - j2 < 800;
                }
            }
        };
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a su;

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
                this.su = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.su.nM.mJ || this.su.sr == null || this.su.landingPageViewHelper == null || !this.su.landingPageViewHelper.ny()) {
                    return;
                }
                this.su.bc.setVisibility(8);
                this.su.sr.setVisibility(0);
                this.su.landingPageViewHelper.show();
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.mAdTemplate = this.nM.mAdTemplate;
            if (this.landingPageViewHelper == null) {
                com.kwad.components.core.page.c cVar = new com.kwad.components.core.page.c(getContext(), this.mAdTemplate, 4, false);
                this.landingPageViewHelper = cVar;
                cVar.a(this);
                this.landingPageViewHelper.a(new c.C0582c().at(false).as(true).aq("").ar(com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)).nI());
                this.sr.addView(this.landingPageViewHelper.getRootView());
            }
            this.ss = 0L;
            this.st = false;
            k kVar = this.nM;
            this.ct = kVar.mRootContainer;
            kVar.a(this.mPlayEndPageListener);
            this.nM.eF.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onBackBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            k kVar = this.nM;
            if (kVar.mAdOpenInteractionListener != null) {
                long T = com.kwad.sdk.core.response.a.a.T(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate));
                boolean z = true;
                if (T >= 0 && !this.st && this.ss < T) {
                    z = false;
                }
                if (z) {
                    this.nM.mAdOpenInteractionListener.onRewardVerify();
                }
            }
            this.nM.mAdOpenInteractionListener.j(false);
            gR();
        }
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onCloseBtnClicked(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.sr = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0910c7);
            this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f091087);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            com.kwad.components.core.page.c cVar = this.landingPageViewHelper;
            if (cVar != null) {
                cVar.destroy();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            this.nM.b(this.mPlayEndPageListener);
            this.nM.eF.b(this.mVideoPlayStateListener);
        }
    }
}
