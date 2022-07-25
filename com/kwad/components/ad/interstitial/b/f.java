package com.kwad.components.ad.interstitial.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.widget.kwai.b aM;
    public com.kwad.sdk.core.video.videoview.a dp;
    public KsAutoCloseView ge;
    public c gh;
    public boolean hm;
    public KSFrameLayout hn;
    public com.kwad.sdk.core.h.c ho;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public f() {
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
        this.ho = new com.kwad.sdk.core.h.c(this) { // from class: com.kwad.components.ad.interstitial.b.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f hp;

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
                this.hp = this;
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!this.hp.mAdTemplate.mPvReported && !this.hp.gh.gn && this.hp.gh.fo != null) {
                        this.hp.gh.fo.onAdShow();
                        com.kwad.components.ad.interstitial.monitor.b.cr().a(this.hp.gh.mAdTemplate, 1);
                    }
                    com.kwad.components.core.m.c.ox().a(this.hp.mAdTemplate, null, new com.kwad.sdk.core.report.f().aU(ag.cB(this.hp.getContext()) ? 2 : 1).aS(this.hp.gh.gx));
                }
            }
        };
    }

    public static boolean d(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adInfo)) == null) ? adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.aY(adInfo) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.components.ad.interstitial.widget.f fVar = this.gh.gj;
            fVar.setAdTemplate(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aC(this.mAdInfo)) {
                fVar.a(com.kwad.sdk.core.response.a.a.at(this.mAdInfo).materialUrl, this.mAdTemplate);
                fVar.b(true, true);
                fVar.t(false);
            } else {
                fVar.t(true);
                String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
                if (TextUtils.isEmpty(url)) {
                    fVar.b(false, false);
                } else {
                    fVar.a(url, this.mAdTemplate);
                    fVar.b(true, false);
                }
                com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
                this.dp = aVar;
                if (aVar.getParent() != null) {
                    ((ViewGroup) this.dp.getParent()).removeView(this.dp);
                }
                if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                    fVar.a(com.kwad.sdk.core.response.a.a.au(this.mAdInfo).height / com.kwad.sdk.core.response.a.a.au(this.mAdInfo).width, this.dp);
                }
                fVar.u(this.gh.cN.isVideoSoundEnable());
                this.gh.a(new a.b(this, com.kwad.sdk.core.response.a.a.B(this.mAdInfo), fVar) { // from class: com.kwad.components.ad.interstitial.b.f.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f hp;
                    public final /* synthetic */ int hq;
                    public final /* synthetic */ com.kwad.components.ad.interstitial.widget.f hr;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r7), fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hp = this;
                        this.hq = r7;
                        this.hr = fVar;
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void bm() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.hp.dp.setVisibility(8);
                            if (this.hp.gh.K(this.hp.getContext())) {
                                return;
                            }
                            this.hr.eb();
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    @SuppressLint({"SetTextI18n"})
                    public final void d(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                            int i = this.hq - ((int) (j / 1000));
                            com.kwad.components.ad.interstitial.widget.f fVar2 = this.hr;
                            if (i >= 0) {
                                fVar2.B(String.valueOf(i));
                            } else {
                                fVar2.dZ();
                            }
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void onVideoPlayStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.hr.t(true);
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void onVideoPlaying() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.hr.b(false, false);
                        }
                    }
                });
                fVar.a(this.mAdTemplate, this.mAdInfo);
                fVar.t(true);
                this.gh.gs.add(new c.InterfaceC0316c(this, fVar) { // from class: com.kwad.components.ad.interstitial.b.f.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f hp;
                    public final /* synthetic */ com.kwad.components.ad.interstitial.widget.f hr;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hp = this;
                        this.hr = fVar;
                    }

                    @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0316c
                    public final void cH() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.hr.ec();
                            this.hp.dp.setVisibility(0);
                        }
                    }
                });
            }
            this.gh.a(getContext(), this.mAdInfo, this.mAdTemplate, fVar.getBlurBgView());
            String D = com.kwad.sdk.core.response.a.a.D(this.mAdInfo);
            if (TextUtils.isEmpty(D)) {
                D = com.kwad.sdk.core.response.a.a.K(this.mAdInfo);
            }
            ImageLoaderProxy.INSTANCE.load(fVar.getTailFrameView(), D);
            if (!d(this.mAdInfo)) {
                this.ge.aG(false);
                return;
            }
            this.ge.aG(true);
            df();
        }
    }

    private void df() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            AdInfo adInfo = this.mAdInfo;
            int i = adInfo.adInsertScreenInfo.autoCloseTime;
            if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                i = Math.min(i, com.kwad.sdk.core.response.a.a.B(this.mAdInfo));
                this.gh.gj.dZ();
                this.gh.gj.ea();
            }
            this.ge.U(i);
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 165, (JSONObject) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2) {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, this, i, i2) == null) {
            this.gh.a(new c.b(getContext()).l(this.hm).a(this.hn.getTouchCoords()).y(i).z(i2));
            if (!com.kwad.components.ad.interstitial.kwai.b.co() || (dialog = this.gh.gi) == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            c cVar = this.gh;
            if (!cVar.gn && !z && !cVar.gl && !cVar.gm && com.kwad.components.ad.interstitial.c.a.c(cVar)) {
                this.gh.gm = true;
                com.kwad.components.ad.interstitial.a.b.J(getContext());
                return;
            }
            this.gh.a(z, -1, this.dp);
            this.gh.gi.dismiss();
            com.kwad.sdk.core.video.videoview.a aVar = this.dp;
            if (aVar != null) {
                aVar.release();
            }
            c cVar2 = this.gh;
            if (cVar2.gn || (adInteractionListener = cVar2.fo) == null) {
                return;
            }
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            c cVar = (c) xR();
            this.gh = cVar;
            AdTemplate adTemplate = cVar.mAdTemplate;
            this.mAdTemplate = adTemplate;
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.gh.gj.i(this.mAdTemplate);
            this.gh.a(new c.e(this) { // from class: com.kwad.components.ad.interstitial.b.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f hp;

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
                    this.hp = this;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.e
                public final void onError() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hp.de();
                    }
                }
            });
            this.gh.gj.setViewListener(new com.kwad.components.ad.interstitial.widget.i(this) { // from class: com.kwad.components.ad.interstitial.b.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f hp;

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
                    this.hp = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void a(KSFrameLayout kSFrameLayout) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, kSFrameLayout) == null) {
                        this.hp.hn = kSFrameLayout;
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dh() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.hp.n(false);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void di() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.hp.e(3, this.hp.gh.gj.ed() ? 53 : 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dj() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.hp.e(1, 39);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dk() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.hp.e(1, 29);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dl() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        this.hp.e(3, 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dm() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        this.hp.e(3, 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dn() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        this.hp.e(2, 53);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                /* renamed from: do  reason: not valid java name */
                public final void mo81do() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        this.hp.e(2, 30);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dp() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        this.hp.e(2, 31);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dq() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                        this.hp.e(2, 32);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dr() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                        this.hp.e(2, 15);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void ds() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                        this.hp.e(2, 16);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void dt() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                        this.hp.e(2, 17);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void du() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                        this.hp.e(2, 35);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void o(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(1048591, this, z) == null) || this.hp.dp == null) {
                        return;
                    }
                    this.hp.dp.setVideoSoundEnable(z);
                }

                @Override // com.kwad.components.ad.interstitial.widget.i
                public final void p(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048592, this, z) == null) {
                        this.hp.hm = z;
                    }
                }
            });
            com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this.gh.gj, 100);
            this.aM = bVar;
            bVar.a(this.ho);
            this.aM.qi();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.cv();
            this.ge.setCountDownPaused(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cw();
            this.ge.setCountDownPaused(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f091052);
            this.ge = ksAutoCloseView;
            ksAutoCloseView.setViewListener(new KsAutoCloseView.a(this) { // from class: com.kwad.components.ad.interstitial.b.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f hp;

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
                    this.hp = this;
                }

                @Override // com.kwad.components.core.widget.KsAutoCloseView.a
                public final void dg() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hp.n(true);
                    }
                }

                @Override // com.kwad.components.core.widget.KsAutoCloseView.a
                public final void dh() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.hp.n(false);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            this.aM.b(this.ho);
            this.aM.qj();
        }
    }
}
