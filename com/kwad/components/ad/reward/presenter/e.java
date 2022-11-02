package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static long pD;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        boolean bJ();
    }

    /* loaded from: classes7.dex */
    public interface b extends a {
        void bI();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1298624868, "Lcom/kwad/components/ad/reward/presenter/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1298624868, "Lcom/kwad/components/ad/reward/presenter/e;");
        }
    }

    public static boolean U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!com.kwad.components.ad.reward.kwai.b.gh()) {
                com.kwad.sdk.core.e.b.e(str, "isEnable false");
                return true;
            }
            int gg = com.kwad.components.ad.reward.kwai.b.gg();
            com.kwad.sdk.core.e.b.d(str, "JumpDirectMaxCount " + gg);
            return gg <= 0 || com.kwad.components.ad.reward.e.a.cp() >= gg;
        }
        return invokeL.booleanValue;
    }

    public static void a(com.kwad.components.ad.reward.k kVar, @NonNull l.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, kVar, bVar) == null) {
            com.kwad.components.ad.reward.j.a aVar = kVar.eF;
            AdTemplate adTemplate = kVar.mAdTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            JSONObject jSONObject = kVar.mReportExtData;
            long Q = com.kwad.sdk.core.response.a.a.Q(bQ);
            if (Q <= 0 || com.kwad.sdk.core.response.a.a.B(bQ) <= Q) {
                str = "观看完整视频即可获取奖励";
            } else {
                str = "观看视频" + Q + "s即可获取奖励";
            }
            l.c a2 = com.kwad.components.ad.reward.l.a(kVar, str);
            com.kwad.components.ad.reward.k.a(kVar, a2, new l.b(kVar, aVar, a2, adTemplate, jSONObject, bVar) { // from class: com.kwad.components.ad.reward.presenter.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate kp;
                public final /* synthetic */ com.kwad.components.ad.reward.k lR;
                public final /* synthetic */ l.c nc;
                public final /* synthetic */ com.kwad.components.ad.reward.j.a pG;
                public final /* synthetic */ JSONObject pH;
                public final /* synthetic */ l.b pI;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar, aVar, a2, adTemplate, jSONObject, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lR = kVar;
                    this.pG = aVar;
                    this.nc = a2;
                    this.kp = adTemplate;
                    this.pH = jSONObject;
                    this.pI = bVar;
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void G(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.lR.mx = false;
                        if (!z) {
                            com.kwad.sdk.core.report.a.r(this.kp, Cea708Decoder.COMMAND_SWA);
                        }
                        l.b bVar2 = this.pI;
                        if (bVar2 != null) {
                            bVar2.G(z);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fH() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.lR.mx = true;
                        this.pG.pause();
                        if (this.nc.getStyle() == 0) {
                            com.kwad.sdk.core.report.a.k(this.kp, this.pH);
                        } else {
                            com.kwad.sdk.core.report.a.c(this.kp, 149, this.pH);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fI() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.pG.resume();
                        if (this.nc.getStyle() == 1 || this.nc.getStyle() == 2 || this.nc.getStyle() == 5 || this.nc.getStyle() == 8) {
                            com.kwad.sdk.core.report.a.r(this.kp, 150);
                        } else {
                            com.kwad.sdk.core.report.a.l(this.kp, this.pH);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.a
                public final void fJ() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        super.fJ();
                        com.kwad.sdk.core.report.a.r(this.kp, 150);
                        com.kwad.components.ad.reward.k kVar2 = this.lR;
                        kVar2.a(kVar2.mContext, Cea708Decoder.COMMAND_DS4, 1);
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.a
                public final void g(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048580, this, i, i2) == null) {
                        super.g(i, i2);
                        com.kwad.components.ad.reward.k kVar2 = this.lR;
                        kVar2.a(kVar2.mContext, i, i2);
                    }
                }
            });
        }
    }

    public static void a(com.kwad.components.ad.reward.k kVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, kVar, bVar) == null) {
            boolean t = com.kwad.components.ad.reward.p.t(kVar.mAdTemplate);
            m(kVar);
            if (t && bVar != null && bVar.bJ()) {
                return;
            }
            a(kVar.EG);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
        r12 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.kwad.components.ad.reward.k kVar, boolean z, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{kVar, Boolean.valueOf(z), aVar}) == null) {
            AdTemplate adTemplate = kVar.mAdTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            IActivityProxy iActivityProxy = kVar.EG;
            if (!kVar.mz) {
                kVar.mAdOpenInteractionListener.onSkippedVideo();
                if (com.kwad.sdk.core.response.a.a.bf(bQ)) {
                    kVar.release();
                    a(iActivityProxy);
                    return;
                } else if (kVar.mA) {
                    i(kVar);
                    return;
                } else {
                    com.kwad.sdk.core.report.a.j(adTemplate, kVar.mReportExtData);
                    kVar.eF.release();
                    kVar.fr();
                    k(kVar);
                    return;
                }
            }
            h(kVar);
            boolean z2 = false;
            boolean z3 = !kVar.mRewardVerifyCalled && z(kVar.mAdTemplate);
            if (o(adTemplate) || p(adTemplate) || kVar.mP < com.kwad.sdk.core.response.a.a.T(bQ)) {
                boolean z4 = kVar.fD() ? false : false;
                if (!z3) {
                    if (com.kwad.sdk.core.response.a.a.bg(bQ)) {
                        kVar.release();
                        a(iActivityProxy);
                        return;
                    }
                    i(kVar);
                    com.kwad.components.ad.reward.n.g(kVar);
                    return;
                }
                if (z4 && aVar != null && aVar.bJ()) {
                    z2 = true;
                }
                if (z2) {
                    return;
                }
                a(kVar, new l.b(bQ, iActivityProxy, kVar) { // from class: com.kwad.components.ad.reward.presenter.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.ad.reward.k lR;
                    public final /* synthetic */ AdInfo pE;
                    public final /* synthetic */ IActivityProxy pF;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {bQ, iActivityProxy, kVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.pE = bQ;
                        this.pF = iActivityProxy;
                        this.lR = kVar;
                    }

                    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                    public final void G(boolean z5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z5) == null) {
                            super.G(z5);
                            if (com.kwad.components.ad.reward.kwai.b.j(this.pE)) {
                                e.a(this.pF);
                            } else if (com.kwad.sdk.core.response.a.a.bg(this.pE)) {
                                this.lR.release();
                                e.a(this.pF);
                            } else {
                                e.i(this.lR);
                                com.kwad.components.ad.reward.n.g(this.lR);
                            }
                        }
                    }
                });
            } else if (kVar.mJ) {
                a(iActivityProxy);
            } else if (!kVar.mQ && kVar.mP < com.kwad.sdk.core.response.a.a.T(bQ)) {
                if (z) {
                    a(iActivityProxy);
                }
            } else {
                if (kVar.mQ) {
                    kVar.L(2);
                } else {
                    kVar.L(1);
                }
                n(kVar);
                if (com.kwad.sdk.core.response.a.a.bg(bQ)) {
                    kVar.release();
                    a(iActivityProxy);
                    return;
                }
                i(kVar);
                com.kwad.components.ad.reward.n.g(kVar);
            }
        }
    }

    public static void a(IActivityProxy iActivityProxy) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, iActivityProxy) == null) || iActivityProxy == null) {
            return;
        }
        iActivityProxy.finish();
    }

    public static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, adTemplate, adInfo)) == null) {
            if (com.kwad.sdk.core.response.a.a.aY(adInfo)) {
                str2 = "is playable return";
            } else if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
                str2 = "is not Download type";
            } else if (adTemplate.mPlayAgain != null) {
                str2 = "is playAgain return";
            } else if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(adInfo))) {
                str2 = "isRewardLaunchAppTask";
            } else if (!com.kwad.sdk.core.response.a.b.cg(adInfo)) {
                return false;
            } else {
                str2 = "is Aggregation return";
            }
            com.kwad.sdk.core.e.b.i(str, str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void b(com.kwad.components.ad.reward.k kVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kVar, bVar) == null) {
            AdTemplate adTemplate = kVar.mAdTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            boolean t = com.kwad.components.ad.reward.p.t(adTemplate);
            if (kVar.mz) {
                int ft = kVar.ft();
                boolean z = true;
                if (!o(adTemplate) && !p(adTemplate)) {
                    if (com.kwad.sdk.core.response.a.b.bx(kVar.mAdTemplate) && kVar.mAdTemplate.mPlayAgain != null && !kVar.fx() && kVar.mRewardVerifyCalled && ft == 2) {
                        if (bVar != null) {
                            bVar.bI();
                            return;
                        }
                        return;
                    }
                    if (kVar.mQ || kVar.mP >= com.kwad.sdk.core.response.a.a.T(bQ)) {
                        n(kVar);
                    }
                    m(kVar);
                    if ((t && bVar != null && bVar.bJ()) ? false : false) {
                        return;
                    }
                    a(kVar.EG);
                    return;
                }
                h(kVar);
                if ((kVar.mRewardVerifyCalled || !z(kVar.mAdTemplate) || kVar.mC) ? false : false) {
                    l(kVar);
                    return;
                }
            }
            m(kVar);
            a(kVar.EG);
        }
    }

    public static void h(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, kVar) == null) {
            long j = kVar.mO;
            int i = j != 0 ? (int) (j / 1000) : 0;
            long j2 = kVar.mP;
            int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
            u.b bVar = new u.b();
            bVar.abE = 69;
            bVar.abP = i;
            bVar.abQ = i2;
            com.kwad.sdk.core.report.a.b(kVar.mAdTemplate, 141, bVar, kVar.mReportExtData);
        }
    }

    public static void i(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, kVar) == null) {
            long j = kVar.mP;
            int i = j != 0 ? (int) (j / 1000) : 0;
            kVar.mC = true;
            AdTemplate adTemplate = kVar.mAdTemplate;
            com.kwad.sdk.core.report.a.d(adTemplate, com.kwad.sdk.core.response.a.a.R(com.kwad.sdk.core.response.a.d.bQ(adTemplate)), i);
            if (g.r(kVar)) {
                bd.runOnUiThreadDelay(new Runnable(kVar) { // from class: com.kwad.components.ad.reward.presenter.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.ad.reward.k lR;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {kVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.lR = kVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.j(this.lR);
                        }
                    }
                }, 200L);
            } else {
                j(kVar);
            }
        }
    }

    public static void j(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, kVar) == null) {
            kVar.eF.skipToEnd();
        }
    }

    public static void k(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, kVar) == null) {
            com.kwad.sdk.core.e.b.d("openAppMarket", "tryOpenAppMarket");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - pD < 300) {
                com.kwad.sdk.core.e.b.d("openAppMarket", "连续点击");
                return;
            }
            pD = elapsedRealtime;
            if (U("openAppMarket")) {
                return;
            }
            AdTemplate adTemplate = kVar.mAdTemplate;
            Context context = kVar.mContext;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (a("openAppMarket", adTemplate, bQ)) {
                return;
            }
            String bO = com.kwad.sdk.core.response.a.a.bO(bQ);
            com.kwad.sdk.core.e.b.i("openAppMarket", "tryOpenMiAppStore url：" + bO);
            if (com.kwad.sdk.utils.d.a(context, bO, adTemplate)) {
                com.kwad.sdk.core.report.a.g(adTemplate, 2);
                com.kwad.sdk.core.report.a.c(adTemplate, 1, 8);
                com.kwad.components.ad.reward.e.a.I(context);
            } else if (!com.kwad.sdk.utils.d.e(context, bO, com.kwad.sdk.core.response.a.a.ag(bQ))) {
                com.kwad.sdk.core.e.b.i("openAppMarket", "tryOpenMiAppStore failed");
            } else {
                com.kwad.sdk.core.report.a.g(adTemplate, 2);
                com.kwad.sdk.core.report.a.c(adTemplate, 0, 8);
                com.kwad.components.ad.reward.e.a.I(context);
            }
        }
    }

    public static void l(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, kVar) == null) {
            com.kwad.components.ad.reward.k.a(kVar, com.kwad.components.ad.reward.l.a(kVar, (String) null), new l.b(kVar, kVar.mAdTemplate) { // from class: com.kwad.components.ad.reward.presenter.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate kp;
                public final /* synthetic */ com.kwad.components.ad.reward.k lR;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lR = kVar;
                    this.kp = r7;
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void G(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.lR.mx = false;
                        if (!z) {
                            com.kwad.sdk.core.report.a.r(this.kp, Cea708Decoder.COMMAND_SWA);
                        }
                        e.m(this.lR);
                        e.a(this.lR.EG);
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fH() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.components.ad.reward.k kVar2 = this.lR;
                        kVar2.mx = true;
                        com.kwad.sdk.core.report.a.c(this.kp, 149, kVar2.mReportExtData);
                    }
                }

                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void fI() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.a.r(this.kp, 150);
                    }
                }
            });
        }
    }

    public static void m(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, kVar) == null) {
            kVar.mAdOpenInteractionListener.j(false);
        }
    }

    public static void n(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, kVar) == null) {
            kVar.mAdOpenInteractionListener.onRewardVerify();
        }
    }

    public static boolean o(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) : invokeL.booleanValue;
    }

    public static boolean p(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.p(adTemplate) : invokeL.booleanValue;
    }

    public static boolean z(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.a.V(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : invokeL.booleanValue;
    }
}
