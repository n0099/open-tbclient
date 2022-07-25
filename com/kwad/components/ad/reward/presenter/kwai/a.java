package com.kwad.components.ad.reward.presenter.kwai;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> bv;
    public volatile boolean bw;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Handler mHandler;
    public long mPlayTime;
    public g mVideoPlayStateListener;
    public final e rh;
    public boolean ri;
    public Runnable rj;

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
        this.rh = new e();
        this.mPlayTime = 0L;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.ri = true;
        this.bw = false;
        this.rj = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a rk;

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
                this.rk = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.rk.rh.pi()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.rk.rh.pk();
                        int pl = this.rk.rh.pj().pl();
                        this.rk.nM.a(elapsedRealtime, this.rk.rh.pj().pm(), pl);
                    } else if (this.rk.ri) {
                        this.rk.nM.a(5000L, 5000L, 1);
                    }
                    com.kwad.components.core.j.a.og().Q(this.rk.mAdTemplate);
                }
            }
        };
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a rk;

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
                this.rk = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayBufferingPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onVideoPlayBufferingPaused();
                    this.rk.rh.pg();
                    this.rk.mHandler.removeCallbacks(this.rk.rj);
                    this.rk.mHandler.postDelayed(this.rk.rj, 5000L);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayBufferingPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onVideoPlayBufferingPlaying();
                    this.rk.rh.pg();
                    this.rk.mHandler.removeCallbacks(this.rk.rj);
                    this.rk.mHandler.postDelayed(this.rk.rj, 5000L);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    if (!this.rk.nM.mz || !this.rk.nM.mC) {
                        com.kwad.sdk.core.report.a.i(this.rk.mAdTemplate, this.rk.nM.mReportExtData);
                    }
                    this.rk.rh.ph();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048579, this, i3, i4) == null) {
                    super.onVideoPlayError(i3, i4);
                    com.kwad.components.ad.reward.monitor.a.a(this.rk.nM.mz, this.rk.nM.mAdTemplate, this.rk.nM.mP, i3, i4);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.onVideoPlayPaused();
                    this.rk.rh.ph();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.rk.c(j2);
                    this.rk.mPlayTime = j2;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                f fVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.onVideoPlayStart();
                    this.rk.bw = false;
                    EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.rk.mAdInfo);
                    if (createFromAdInfo != null) {
                        fVar = new f();
                        u.a aVar = new u.a();
                        aVar.abz = String.valueOf(createFromAdInfo.getValue());
                        fVar.a(aVar);
                    } else {
                        fVar = null;
                    }
                    c.ox().a(this.rk.mAdTemplate, null, fVar);
                    com.kwad.sdk.core.report.a.h(this.rk.mAdTemplate, this.rk.nM.mReportExtData);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    super.onVideoPlaying();
                    this.rk.rh.ph();
                    this.rk.ri = false;
                    if (this.rk.bw) {
                        return;
                    }
                    this.rk.bw = true;
                    com.kwad.components.core.j.a.og().a(this.rk.mAdTemplate, System.currentTimeMillis(), 1);
                    com.kwad.components.ad.reward.monitor.a.c(this.rk.nM.mz, this.rk.mAdTemplate, this.rk.nM.mPageEnterTime);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.bv;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.bv) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, this.nM.mReportExtData);
                    this.bv.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            AdTemplate adTemplate = this.nM.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.bv = com.kwad.sdk.core.response.a.a.aF(bQ);
            this.nM.eF.a(this.mVideoPlayStateListener);
            this.mHandler.postDelayed(this.rj, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onUnbind();
            this.mHandler.removeCallbacksAndMessages(null);
            this.nM.eF.b(this.mVideoPlayStateListener);
            e.a pj = this.rh.pj();
            com.kwad.components.core.j.a.og().a(this.nM.mAdTemplate, this.mPlayTime, pj.pm(), pj.pl());
        }
    }
}
