package com.kwad.components.ad.reward.presenter.a.kwai;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public com.kwad.components.ad.i.b bb;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public DetailVideoView mDetailVideoView;
    public e mPlayEndPageListener;
    public final h mRewardVerifyListener;
    public boolean qn;
    public n sA;
    public int sB;
    public int sC;
    public Drawable sD;
    public o.b sp;
    public TailFrameView sw;
    public boolean sx;
    public j sy;
    public q sz;

    public c() {
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
        this.qn = false;
        this.sB = Integer.MIN_VALUE;
        this.sC = Integer.MIN_VALUE;
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c sE;

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
                this.sE = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.sE.sw != null && k.q(this.sE.mAdTemplate)) {
                    this.sE.sw.iP();
                }
            }
        };
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c sE;

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
                this.sE = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.components.ad.reward.kwai.b.i(this.sE.mAdInfo) || com.kwad.components.ad.reward.kwai.b.j(this.sE.mAdInfo) || com.kwad.sdk.core.response.a.a.aK(this.sE.mAdTemplate)) {
                        k.a(this.sE.nM, this.sE.getActivity(), this.sE.mAdTemplate, this.sE.sp);
                    } else if ((!com.kwad.sdk.core.response.a.d.ce(this.sE.mAdTemplate) && this.sE.qn && !this.sE.nM.fA()) || this.sE.nM.mF || this.sE.nM.mJ) {
                    } else {
                        boolean z = com.kwad.sdk.core.response.a.b.bx(this.sE.mAdTemplate) && com.kwad.components.ad.b.a.a(this.sE.mAdTemplate.mPlayAgain) && this.sE.nM.mRewardVerifyCalled && this.sE.nM.ft() == 1;
                        this.sE.sx = true;
                        com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "onPlayEndPageShow " + z);
                        if (z) {
                            com.kwad.components.ad.i.b bVar = this.sE.nM.mn;
                            if (bVar != null && bVar.ay()) {
                                this.sE.nM.C(true);
                                this.sE.sx = false;
                            }
                            this.sE.hK();
                        } else if (this.sE.bb != null && this.sE.bb.ay()) {
                            this.sE.sx = false;
                        }
                        if (this.sE.sx) {
                            if (this.sE.nM.mm != null) {
                                com.kwad.components.ad.reward.monitor.a.a(this.sE.nM.mz, "end_card", com.kwad.sdk.core.response.a.b.bb(this.sE.mAdTemplate), System.currentTimeMillis() - this.sE.nM.mm.getLoadTime());
                            }
                            this.sE.W(z);
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 2 : 153, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i) == null) || (layoutParams = this.mDetailVideoView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        this.mDetailVideoView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            q qVar = this.sz;
            if (qVar != null) {
                qVar.show();
            } else if (z) {
                this.sA.show();
                this.sA.b(u.D(this.mAdTemplate));
                this.nM.C(true);
            } else if (!com.kwad.sdk.core.response.a.a.bF(this.mAdInfo)) {
                this.sw.a(new com.kwad.components.ad.reward.widget.tailframe.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c sE;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.sE = this;
                    }

                    @Override // com.kwad.components.ad.reward.widget.tailframe.b
                    public final void R(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            this.sE.P(z2);
                        }
                    }
                });
                this.sw.setVisibility(0);
            } else {
                this.sy.show();
                this.sy.b(u.D(this.mAdTemplate));
                com.kwad.sdk.core.report.a.c(this.mAdTemplate, 19, (JSONObject) null);
            }
        }
    }

    private void hJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            boolean aY = com.kwad.sdk.core.response.a.a.aY(this.mAdInfo);
            boolean cc = com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate);
            if (aY && cc) {
                q qVar = new q(R.id.obfuscated_res_0x7f091166);
                this.sz = qVar;
                qVar.a(new p.a(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c sE;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.sE = this;
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hs() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            new u.b().acd = 6;
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void ht() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            com.kwad.components.ad.reward.b.eV().c(PlayableSource.ENDCARD_CLICK, new com.kwad.components.ad.reward.f.a(this.sE.getContext()));
                            com.kwad.sdk.core.report.a.a(this.sE.nM.mAdTemplate, new f().aK(67).aP(6));
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hu() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.sE.nM.a(this.sE.getContext(), 2, 1);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.k.p.a
                    public final void hv() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.sE.nM.a(this.sE.getContext(), 2, 2);
                        }
                    }
                });
                this.sz.e((ViewGroup) getRootView());
                this.sz.b(com.kwad.components.ad.reward.k.u.D(this.nM.mAdTemplate));
                this.sz.a(this.mAdInfo, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mDetailVideoView.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c sE;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.sE = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DetailVideoView detailVideoView;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.sE.mDetailVideoView == null || ag.cB(this.sE.getContext())) {
                        return;
                    }
                    boolean ay = com.kwad.sdk.core.response.a.a.ay(this.sE.mAdInfo);
                    int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(this.sE.getContext());
                    c cVar = this.sE;
                    cVar.sB = cVar.mDetailVideoView.getLayoutParams().width;
                    com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "setPlayAgainDetailView:  videoOriginalWidth :" + this.sE.sB);
                    this.sE.Q(screenWidth / 2);
                    c cVar2 = this.sE;
                    cVar2.sC = cVar2.mDetailVideoView.getTextureViewGravity();
                    if (ay) {
                        detailVideoView = this.sE.mDetailVideoView;
                        i = 21;
                    } else {
                        detailVideoView = this.sE.mDetailVideoView;
                        i = 17;
                    }
                    detailVideoView.updateTextureViewGravity(i);
                    c cVar3 = this.sE;
                    cVar3.sD = cVar3.mDetailVideoView.getBackground();
                    this.sE.mDetailVideoView.setBackgroundColor(this.sE.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060780));
                    this.sE.hL();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910a5)) == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(imageView, com.kwad.sdk.core.response.a.a.K(this.mAdInfo));
    }

    private void hM() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && this.sx) {
            this.sw.destroy();
            this.sw.setVisibility(8);
            this.sy.hide();
            this.sA.hide();
        }
    }

    private boolean hN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(this.mAdInfo);
            return au.height > au.width;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.qn = aVar.isSuccess();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            com.kwad.components.core.playable.a aVar = this.nM.mk;
            if (aVar != null) {
                aVar.a(this);
            }
            AdTemplate adTemplate = this.nM.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            k kVar = this.nM;
            this.bb = kVar.mm;
            kVar.a(this.mPlayEndPageListener);
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.sw.setCallerContext(this.nM);
            this.sw.a(getContext(), this.nM.mScreenOrientation == 0, hN());
            ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f09116c);
            this.sy = viewStub != null ? new j(this.nM, viewStub) : new j(this.nM, (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911ae));
            ViewStub viewStub2 = (ViewStub) findViewById(R.id.obfuscated_res_0x7f09116d);
            this.sA = viewStub2 != null ? new n(this.mAdTemplate, this.nM, viewStub2, this.mDetailVideoView) : new n(this.mAdTemplate, this.nM, (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09114d), this.mDetailVideoView);
            hJ();
        }
    }

    public final void b(o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.sp = bVar;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.sw = (TailFrameView) findViewById(R.id.obfuscated_res_0x7f091263);
            DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f09125f);
            this.mDetailVideoView = detailVideoView;
            if (detailVideoView.getLayoutTransition() != null) {
                this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            com.kwad.components.core.playable.a aVar = this.nM.mk;
            if (aVar != null) {
                aVar.b(this);
            }
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            hM();
            this.nM.b(this.mPlayEndPageListener);
            DetailVideoView detailVideoView = this.mDetailVideoView;
            if (detailVideoView != null) {
                int i = this.sC;
                if (i != Integer.MIN_VALUE) {
                    detailVideoView.updateTextureViewGravity(i);
                }
                com.kwad.sdk.core.e.b.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.sB);
                int i2 = this.sB;
                if (i2 != Integer.MIN_VALUE) {
                    Q(i2);
                }
                Drawable drawable = this.sD;
                if (drawable != null) {
                    this.mDetailVideoView.setBackground(drawable);
                }
            }
            n nVar = this.sA;
            if (nVar != null) {
                nVar.bt();
            }
        }
    }
}
