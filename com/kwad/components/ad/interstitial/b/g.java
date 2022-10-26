package com.kwad.components.ad.interstitial.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes7.dex */
public final class g extends b implements a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long hs = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public c gh;
    public a ht;
    public int hu;
    public AdTemplate mAdTemplate;

    /* loaded from: classes7.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int hv;
        public boolean hw;
        public boolean hx;
        public final /* synthetic */ g hy;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hy = gVar;
            this.hv = Integer.MIN_VALUE;
            this.hw = false;
            this.hx = false;
        }

        public /* synthetic */ a(g gVar, byte b) {
            this(gVar);
        }

        public final void q(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.hx = true;
            }
        }

        public final void r(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.hw = z;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.hx) {
                return;
            }
            if (!this.hw) {
                if (this.hv == Integer.MIN_VALUE) {
                    this.hv = this.hy.hu;
                }
                if (this.hv < 0) {
                    return;
                }
                com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", this.hy.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.hv);
                this.hy.D(this.hv);
                this.hv = this.hv + (-1);
            }
            bd.a(this, null, g.hs);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228459915, "Lcom/kwad/components/ad/interstitial/b/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228459915, "Lcom/kwad/components/ad/interstitial/b/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i) {
        c cVar;
        com.kwad.components.ad.interstitial.widget.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i) == null) || (fVar = (cVar = this.gh).gj) == null) {
            return;
        }
        if (i != 0) {
            fVar.b(true, i);
        } else if (cVar.cB()) {
        } else {
            this.gh.b(getContext(), this.mAdTemplate);
            cY();
            c cVar2 = this.gh;
            cVar2.a(true, -1, cVar2.dp);
        }
    }

    private void cY() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
            if (aVar != null) {
                aVar.release();
            }
            this.gh.gi.dismiss();
            c cVar = this.gh;
            if (cVar.gn || (adInteractionListener = cVar.fo) == null) {
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
            com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", this + " onBind");
            c cVar = (c) xR();
            this.gh = cVar;
            AdTemplate adTemplate = cVar.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            long j = bQ.adInsertScreenInfo.autoCloseTime;
            if (j > 0) {
                this.hu = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.b(bQ), j);
            } else {
                this.hu = com.kwad.components.ad.interstitial.kwai.b.b(bQ);
            }
            com.kwad.components.ad.interstitial.widget.f fVar = this.gh.gj;
            if (fVar != null) {
                fVar.b(true, -1);
            }
            if (!com.kwad.sdk.core.response.a.a.aB(bQ)) {
                a aVar = new a(this, (byte) 0);
                this.ht = aVar;
                bd.a(aVar, null, 1000L);
                return;
            }
            this.hu = (int) Math.min(this.hu, com.kwad.sdk.core.response.a.a.B(bQ));
            this.ht = null;
            this.gh.a(this);
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void bm() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.gh.cB()) {
            return;
        }
        this.gh.b(getContext(), this.mAdTemplate);
        cY();
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cv();
            a aVar = this.ht;
            if (aVar != null) {
                aVar.r(false);
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.cw();
            a aVar = this.ht;
            if (aVar != null) {
                aVar.r(true);
            }
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            D(this.hu - ((int) (j / 1000)));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", this + " onUnbind");
            this.gh.b(this);
            a aVar = this.ht;
            if (aVar != null) {
                aVar.q(true);
                bd.c(this.ht);
                this.ht = null;
            }
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void onVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void onVideoPlaying() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
