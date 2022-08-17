package com.kwad.components.ad.reward.presenter.a.kwai;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.i.b;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.m;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public FrameLayout bS;
    public com.kwad.components.ad.i.b bb;
    public DetailVideoView mDetailVideoView;
    public final h mRewardVerifyListener;
    public com.kwad.components.ad.i.b mn;
    public int qC;
    @Nullable
    public FrameLayout sF;

    public d() {
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
        this.qC = Integer.MIN_VALUE;
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d sG;

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
                this.sG = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.sG.bb != null && k.q(this.sG.nM.mAdTemplate)) {
                    this.sG.bb.af(true);
                }
            }
        };
        this.bJ = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d sG;

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
                this.sG = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.sG.nM.mAdOpenInteractionListener.bB();
                }
            }
        };
    }

    private void hO() {
        FrameLayout frameLayout;
        com.kwad.components.ad.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            AdTemplate adTemplate = this.nM.mAdTemplate;
            if (!com.kwad.sdk.core.response.a.b.bx(adTemplate) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bz(adTemplate)) || (frameLayout = this.sF) == null || (bVar = this.mn) == null) {
                return;
            }
            k kVar = this.nM;
            bVar.a(frameLayout, kVar.mRootContainer, adTemplate, kVar.mApkDownloadHelper, kVar.mScreenOrientation);
            this.mn.a((b.InterfaceC0316b) null);
            ViewGroup.LayoutParams layoutParams = this.sF.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                if (ag.cB(getContext())) {
                    marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07038e);
                } else {
                    marginLayoutParams.bottomMargin = 0;
                    int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / 2;
                    marginLayoutParams.width = screenWidth;
                    marginLayoutParams.height = -1;
                    marginLayoutParams.rightMargin = -screenWidth;
                }
                this.sF.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void a(com.kwad.components.ad.i.b bVar) {
        Animator a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar.equals(this.mn)) {
            if (ag.cB(getContext())) {
                this.qC = com.kwad.sdk.b.kwai.a.A(this.mDetailVideoView);
                com.kwad.sdk.b.kwai.a.i(this.mDetailVideoView, 49);
                a = r.a(this.nM.mAdTemplate, this.mn.kW(), this.mDetailVideoView);
            } else {
                a = r.a(this.nM.mAdTemplate, this.mDetailVideoView, this.mn.kW());
            }
            if (a != null) {
                a.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            k kVar = this.nM;
            AdTemplate adTemplate = kVar.mAdTemplate;
            m mVar = kVar.mm;
            this.bb = mVar;
            if (mVar == null) {
                return;
            }
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.bb.a(this.bJ);
            com.kwad.components.ad.i.b bVar = this.bb;
            FrameLayout frameLayout = this.bS;
            k kVar2 = this.nM;
            bVar.a(frameLayout, kVar2.mRootContainer, adTemplate, kVar2.mApkDownloadHelper, kVar2.mScreenOrientation);
            this.bb.a((b.InterfaceC0316b) null);
            com.kwad.components.ad.i.b bVar2 = this.nM.mn;
            this.mn = bVar2;
            if (bVar2 != null) {
                bVar2.a(this);
            }
            hO();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.bS = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09121c);
            this.sF = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0910fd);
            this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f09120c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            com.kwad.components.ad.i.b bVar = this.bb;
            if (bVar != null) {
                bVar.kV();
                this.bb.bt();
            }
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            com.kwad.components.ad.i.b bVar2 = this.mn;
            if (bVar2 != null) {
                bVar2.kV();
                this.mn.bt();
                this.mn.a((b.a) null);
            }
            DetailVideoView detailVideoView = this.mDetailVideoView;
            if (detailVideoView == null || (i = this.qC) == Integer.MIN_VALUE) {
                return;
            }
            com.kwad.sdk.b.kwai.a.i(detailVideoView, i);
        }
    }
}
