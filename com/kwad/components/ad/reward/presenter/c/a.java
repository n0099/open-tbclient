package com.kwad.components.ad.reward.presenter.c;

import android.content.DialogInterface;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.h.c;
import com.kwad.components.ad.reward.h.d;
import com.kwad.components.ad.reward.h.f;
import com.kwad.components.ad.reward.h.g;
import com.kwad.components.ad.reward.h.j;
import com.kwad.components.ad.reward.h.kwai.e;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.b.a.g;
import com.kwad.components.core.webview.b.a.k;
import com.kwad.components.core.webview.b.a.m;
import com.kwad.components.core.webview.b.a.n;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.components.ad.reward.presenter.a implements DialogInterface.OnDismissListener, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h.a dv;
    public com.kwad.components.ad.reward.j.a eF;
    public final com.kwad.components.ad.reward.d.e mPlayEndPageListener;
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener;
    public com.kwad.components.ad.reward.h.kwai.d sW;
    public j sX;
    public i sY;
    public com.kwad.components.ad.reward.h.h sZ;
    public com.kwad.components.ad.reward.h.i ta;
    public s tb;
    public boolean tc;
    public final com.kwad.components.core.video.h td;

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
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a te;

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
                this.te = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.te.sY == null) {
                    return;
                }
                com.kwad.components.core.webview.b.a.i iVar = new com.kwad.components.core.webview.b.a.i();
                iVar.NR = true;
                this.te.sY.c(iVar);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.mRewardVerifyListener = new com.kwad.components.ad.reward.d.h(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a te;

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
                this.te = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.te.sZ == null) {
                    return;
                }
                g gVar = new g();
                gVar.NO = 1;
                this.te.sZ.a(gVar);
            }
        };
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a te;

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
                this.te = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.te.ta == null) {
                    return;
                }
                bd.runOnUiThreadDelay(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.6.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass6 tf;

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
                        this.tf = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            k kVar = new k();
                            kVar.NS = 1;
                            this.tf.te.ta.a(kVar);
                        }
                    }
                }, 0L);
            }
        };
        this.td = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a te;

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
                this.te = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.te.nM.mC) {
                        this.te.ib();
                    } else {
                        this.te.ia();
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    this.te.ib();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.te.b(j, j2);
                    this.te.d(j2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.te.d(0.0d);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPreparing() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.te.d(0.0d);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            long min = Math.min(com.kwad.sdk.core.response.a.a.T(this.nM.mAdTemplate.adInfoList.get(0)), j);
            if (j2 < min - 800) {
                this.nM.mM = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Double.valueOf(d)}) == null) {
            s sVar = this.tb;
            sVar.NZ = false;
            sVar.Oa = false;
            sVar.kD = (int) ((d / 1000.0d) + 0.5d);
            ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.c(kVar.mAdTemplate, 17, kVar.mReportExtData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.c(kVar.mAdTemplate, 18, kVar.mReportExtData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 39, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 40, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 41, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            s sVar = this.tb;
            sVar.Oa = true;
            sVar.NZ = false;
            sVar.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate));
            ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            s sVar = this.tb;
            sVar.NZ = true;
            sVar.Oa = false;
            ic();
        }
    }

    private void ic() {
        j jVar;
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (jVar = this.sX) == null || (sVar = this.tb) == null) {
            return;
        }
        jVar.a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.nM.mAdOpenInteractionListener.onRewardVerify();
        }
    }

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (kVar = this.nM) == null) {
            return;
        }
        kVar.b(bVar);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.components.ad.reward.presenter.e.a(kVar, false, (e.a) kVar.fC());
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.sY = iVar;
            this.eF.a(this.dv);
            bd.runOnUiThreadDelay(com.kwad.components.core.m.b.at(getContext()).ov() ? new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
                        iVar2.NR = true;
                        this.te.sY.c(iVar2);
                    }
                }
            } : new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
                        iVar2.NR = !this.te.nM.mVideoPlayConfig.isVideoSoundEnable();
                        this.te.sY.c(iVar2);
                    }
                }
            }, 0L);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            this.sX = jVar;
            this.eF.a(this.td);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aaVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(com.kwad.sdk.components.h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, hVar, bVar) == null) {
            com.kwad.components.ad.reward.h.j jVar = new com.kwad.components.ad.reward.h.j();
            jVar.a(new j.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.j.a
                public final void d(n nVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, nVar) == null) {
                        com.kwad.components.ad.reward.d.fc().c(nVar);
                    }
                }
            });
            hVar.c(jVar);
            long j = this.nM.mO;
            hVar.c(new f(j > 0 ? ((int) j) / 1000 : 0));
            com.kwad.components.ad.reward.h.h hVar2 = new com.kwad.components.ad.reward.h.h();
            this.sZ = hVar2;
            hVar.c(hVar2);
            com.kwad.components.ad.reward.h.i iVar = new com.kwad.components.ad.reward.h.i();
            this.ta = iVar;
            hVar.c(iVar);
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.nM.a(this.mPlayEndPageListener);
            hVar.c(new com.kwad.components.core.webview.jshandler.q(new q.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.q.b
                public final void a(q.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.te.ca().setVisibility(8);
                    }
                }
            }));
            com.kwad.components.ad.reward.h.c cVar = new com.kwad.components.ad.reward.h.c();
            cVar.a(new c.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.c.a
                public final void a(m mVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0354a(this.te.getContext()).L(this.te.nM.mAdTemplate).b(this.te.nM.mApkDownloadHelper).ae(1).a(new a.b(this, mVar) { // from class: com.kwad.components.ad.reward.presenter.c.a.9.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ m tg;
                            public final /* synthetic */ AnonymousClass9 th;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, mVar};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.th = this;
                                this.tg = mVar;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.tg.NU) {
                                        this.th.te.hX();
                                    } else {
                                        this.th.te.hY();
                                    }
                                }
                            }
                        }));
                    }
                }
            });
            hVar.c(cVar);
            com.kwad.components.ad.reward.h.d dVar = new com.kwad.components.ad.reward.h.d();
            dVar.a(new d.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.d.a
                public final void id() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.c.a.a.a(new a.C0354a(this.te.getContext()).L(this.te.nM.mAdTemplate).b(this.te.nM.mApkDownloadHelper).ae(2).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.10.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass10 ti;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.ti = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.ti.te.hZ();
                                }
                            }
                        }));
                    }
                }
            });
            hVar.c(dVar);
            hVar.c(new com.kwad.components.ad.reward.h.g(new g.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.g.a
                public final void id() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.components.ad.reward.k.q(this.te.nM.mAdTemplate)) {
                            if (!com.kwad.components.ad.reward.k.o(this.te.nM.mAdTemplate) || this.te.nM.mK == null) {
                                if (com.kwad.components.ad.reward.k.p(this.te.nM.mAdTemplate) && this.te.nM.mL != null && !this.te.nM.mL.iC()) {
                                    this.te.nM.mL.iB();
                                }
                            } else if (!this.te.nM.mK.iC()) {
                                this.te.nM.mK.iB();
                            }
                        }
                        this.te.notifyRewardVerify();
                    }
                }
            }));
            hVar.c(new com.kwad.components.ad.reward.h.b(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.b
                public final void ie() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.ie();
                        this.te.hW();
                    }
                }
            });
            hVar.c(new com.kwad.components.ad.reward.h.e(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.e
                public final void ie() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.ie();
                        com.kwad.components.ad.reward.presenter.e.b(this.te.nM, this.te.nM.fC());
                    }
                }
            });
            hVar.c(new com.kwad.components.ad.reward.h.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a te;

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
                    this.te = this;
                }

                @Override // com.kwad.components.ad.reward.h.a
                public final void ie() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.ie();
                        this.te.hV();
                    }
                }
            });
            hVar.c(new com.kwad.components.ad.reward.f.b(getContext(), this.nM.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.aq();
            boolean cc = cc();
            this.tc = cc;
            if (cc) {
                this.nM.a(this);
                if (this.sW == null) {
                    this.sW = new com.kwad.components.ad.reward.h.kwai.d(this.nM, -1L, getContext());
                }
                if (this.tb == null) {
                    this.tb = new s();
                }
                com.kwad.components.ad.reward.k kVar = this.nM;
                this.eF = kVar.eF;
                this.sW.a(kVar.getActivity(), this.nM.mAdTemplate, this);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
        com.kwad.components.ad.reward.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) || (aVar = this.eF) == null) {
            return;
        }
        aVar.c(!iVar.NR, true);
    }

    public abstract boolean cc();

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.nM.mRootContainer : (com.kwad.sdk.widget.e) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.c.a.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a te;

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
                this.te = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    this.te.nM.mAdOpenInteractionListener.bB();
                }
            }
        } : (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.h.kwai.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, dialogInterface) == null) || (dVar = this.sW) == null || dVar.iq() == null) {
            return;
        }
        this.sW.iq().gu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onUnbind();
            if (this.tc) {
                this.nM.b(this);
                this.sW.pF();
                this.eF.b(this.td);
                this.eF.b(this.dv);
                com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
                this.nM.b(this.mPlayEndPageListener);
            }
        }
    }
}
