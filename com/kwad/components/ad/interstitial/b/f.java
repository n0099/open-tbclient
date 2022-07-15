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
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public AdInfo b;
    public AdTemplate c;
    public com.kwad.sdk.core.video.videoview.a d;
    public KsAutoCloseView e;
    public boolean f;
    public KSFrameLayout g;
    public com.kwad.components.core.widget.kwai.b h;
    public com.kwad.sdk.core.g.c i;

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
        this.i = new com.kwad.sdk.core.g.c(this) { // from class: com.kwad.components.ad.interstitial.b.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

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

            @Override // com.kwad.sdk.core.g.c, com.kwad.sdk.core.g.b
            public final void m_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!this.a.c.mPvReported && !this.a.a.h && this.a.a.b != null) {
                        this.a.a.b.onAdShow();
                    }
                    com.kwad.components.core.l.c.a().a(this.a.c, null, new com.kwad.sdk.core.report.f().k(this.a.a.n));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i, i2) == null) {
            this.a.a(new c.b(u()).a(this.f).a(this.g.getTouchCoords()).a(i).b(i2));
            if (!com.kwad.components.ad.interstitial.kwai.b.g() || (dialog = this.a.c) == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            c cVar = this.a;
            if (!cVar.h && !z && !cVar.f && !cVar.g && com.kwad.components.ad.interstitial.c.a.a(cVar)) {
                this.a.g = true;
                com.kwad.components.ad.interstitial.a.b.b(u());
                return;
            }
            this.a.a(z, this.d);
            this.a.c.dismiss();
            com.kwad.sdk.core.video.videoview.a aVar = this.d;
            if (aVar != null) {
                aVar.i();
            }
            c cVar2 = this.a;
            if (cVar2.h || (adInteractionListener = cVar2.b) == null) {
                return;
            }
            adInteractionListener.onAdClosed();
        }
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adInfo)) == null) ? adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.ar(adInfo) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.components.ad.interstitial.widget.f fVar = this.a.e;
            fVar.setAdTemplate(this.c);
            if (com.kwad.sdk.core.response.a.a.X(this.b)) {
                fVar.a(com.kwad.sdk.core.response.a.a.P(this.b).materialUrl, this.c);
                fVar.a(true, true);
                fVar.a(false);
            } else {
                fVar.a(true);
                String a = com.kwad.sdk.core.response.a.a.ae(this.b).a();
                if (TextUtils.isEmpty(a)) {
                    fVar.a(false, false);
                } else {
                    fVar.a(a, this.c);
                    fVar.a(true, false);
                }
                com.kwad.sdk.core.video.videoview.a aVar = this.a.l;
                this.d = aVar;
                if (aVar.getParent() != null) {
                    ((ViewGroup) this.d.getParent()).removeView(this.d);
                }
                if (com.kwad.sdk.core.response.a.a.W(this.b)) {
                    fVar.a(com.kwad.sdk.core.response.a.a.Q(this.b).height / com.kwad.sdk.core.response.a.a.Q(this.b).width, this.d);
                }
                fVar.b(this.a.j.isVideoSoundEnable());
                this.a.a(new a.b(this, com.kwad.sdk.core.response.a.a.c(this.b), fVar) { // from class: com.kwad.components.ad.interstitial.b.f.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;
                    public final /* synthetic */ com.kwad.components.ad.interstitial.widget.f b;
                    public final /* synthetic */ f c;

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
                        this.c = this;
                        this.a = r7;
                        this.b = fVar;
                    }

                    @Override // com.kwad.components.core.video.a.b
                    @SuppressLint({"SetTextI18n"})
                    public final void a(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                            int i = this.a - ((int) (j / 1000));
                            com.kwad.components.ad.interstitial.widget.f fVar2 = this.b;
                            if (i >= 0) {
                                fVar2.a(String.valueOf(i));
                            } else {
                                fVar2.c();
                            }
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void f_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.b.a(true);
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void g_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.b.a(false, false);
                        }
                    }

                    @Override // com.kwad.components.core.video.a.b
                    public final void h_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.c.d.setVisibility(8);
                            if (this.c.a.a(this.c.u())) {
                                return;
                            }
                            this.b.e();
                        }
                    }
                });
                fVar.a(this.c, this.b);
                fVar.a(true);
            }
            this.a.a(u(), this.b, this.c, fVar.getBlurBgView());
            String e = com.kwad.sdk.core.response.a.a.e(this.b);
            if (TextUtils.isEmpty(e)) {
                e = com.kwad.sdk.core.response.a.a.k(this.b);
            }
            ImageLoaderProxy.INSTANCE.load(fVar.getTailFrameView(), e);
            if (!a(this.b)) {
                this.e.a(false);
                return;
            }
            this.e.a(true);
            h();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            AdInfo adInfo = this.b;
            int i = adInfo.adInsertScreenInfo.autoCloseTime;
            if (com.kwad.sdk.core.response.a.a.W(adInfo)) {
                i = Math.min(i, com.kwad.sdk.core.response.a.a.c(this.b));
                this.a.e.c();
                this.a.e.d();
            }
            this.e.a(i);
            com.kwad.sdk.core.report.a.c(this.c, 165, (JSONObject) null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) t();
            this.a = cVar;
            AdTemplate adTemplate = cVar.a;
            this.c = adTemplate;
            this.b = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.a.e.a(this.c);
            this.a.a(new c.InterfaceC0469c(this) { // from class: com.kwad.components.ad.interstitial.b.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0469c
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.g();
                    }
                }
            });
            this.a.e.setViewListener(new com.kwad.components.ad.interstitial.widget.h(this) { // from class: com.kwad.components.ad.interstitial.b.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(3, this.a.a.e.f() ? 53 : 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void a(KSFrameLayout kSFrameLayout) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kSFrameLayout) == null) {
                        this.a.g = kSFrameLayout;
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.a.d == null) {
                        return;
                    }
                    this.a.d.setVideoSoundEnable(z);
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.a.a(false);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void b(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) {
                        this.a.f = z;
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        this.a.a(1, 39);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        this.a.a(1, 29);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        this.a.a(3, 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        this.a.a(3, 85);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void g() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        this.a.a(2, 53);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void h() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                        this.a.a(2, 30);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void i() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                        this.a.a(2, 31);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void j() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                        this.a.a(2, 32);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void k() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                        this.a.a(2, 15);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void l() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                        this.a.a(2, 16);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void m() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048591, this) == null) {
                        this.a.a(2, 17);
                    }
                }

                @Override // com.kwad.components.ad.interstitial.widget.h
                public final void n() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048592, this) == null) {
                        this.a.a(2, 35);
                    }
                }
            });
            com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this.a.e, 100);
            this.h = bVar;
            bVar.a(this.i);
            this.h.b();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.e.setCountDownPaused(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e();
            this.e.setCountDownPaused(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) b(R.id.obfuscated_res_0x7f09105b);
            this.e = ksAutoCloseView;
            ksAutoCloseView.setViewListener(new KsAutoCloseView.a(this) { // from class: com.kwad.components.ad.interstitial.b.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.core.widget.KsAutoCloseView.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(true);
                    }
                }

                @Override // com.kwad.components.core.widget.KsAutoCloseView.a
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.a(false);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            this.h.b(this.i);
            this.h.c();
        }
    }
}
