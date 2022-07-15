package com.kwad.components.ad.reward.presenter;

import android.app.Activity;
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
import com.kwad.components.ad.reward.m;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        boolean g();
    }

    /* loaded from: classes5.dex */
    public interface b extends a {
        void c_();
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

    public static void a(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, lVar) == null) {
            com.kwad.sdk.core.d.b.a("openAppMarket", "tryOpenAppMarket");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - b < 300) {
                com.kwad.sdk.core.d.b.a("openAppMarket", "连续点击");
                return;
            }
            b = elapsedRealtime;
            if (a("openAppMarket")) {
                return;
            }
            AdTemplate adTemplate = lVar.g;
            Context context = lVar.M;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (a("openAppMarket", adTemplate, i)) {
                return;
            }
            String be = com.kwad.sdk.core.response.a.a.be(i);
            com.kwad.sdk.core.d.b.c("openAppMarket", "tryOpenMiAppStore url：" + be);
            if (!com.kwad.sdk.utils.d.a(context, be, adTemplate)) {
                com.kwad.sdk.core.d.b.c("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.sdk.core.report.a.a(adTemplate, 2);
            com.kwad.sdk.core.report.a.a(adTemplate, 1, 8);
            a++;
        }
    }

    public static void a(com.kwad.components.ad.reward.l lVar, @NonNull m.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, lVar, bVar) == null) {
            com.kwad.components.ad.reward.h.a aVar = lVar.j;
            AdTemplate adTemplate = lVar.g;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            JSONObject jSONObject = lVar.e;
            long o = com.kwad.sdk.core.response.a.a.o(i);
            if (o <= 0 || com.kwad.sdk.core.response.a.a.c(i) <= o) {
                str = "观看完整视频即可获取奖励";
            } else {
                str = "观看视频" + o + "s即可获取奖励";
            }
            m.c a2 = com.kwad.components.ad.reward.m.a(lVar, str);
            com.kwad.components.ad.reward.l.a(lVar, a2, new m.b(aVar, a2, adTemplate, jSONObject, bVar, lVar) { // from class: com.kwad.components.ad.reward.presenter.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.ad.reward.h.a a;
                public final /* synthetic */ m.c b;
                public final /* synthetic */ AdTemplate c;
                public final /* synthetic */ JSONObject d;
                public final /* synthetic */ m.b e;
                public final /* synthetic */ com.kwad.components.ad.reward.l f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, a2, adTemplate, jSONObject, bVar, lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                    this.b = a2;
                    this.c = adTemplate;
                    this.d = jSONObject;
                    this.e = bVar;
                    this.f = lVar;
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.c();
                        if (this.b.a() == 0) {
                            com.kwad.sdk.core.report.a.i(this.c, this.d);
                        } else {
                            com.kwad.sdk.core.report.a.c(this.c, 149, this.d);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.m.a
                public final void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        super.a(i2, i3);
                        com.kwad.components.ad.reward.l lVar2 = this.f;
                        lVar2.a(lVar2.M, i2, i3);
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (!z) {
                            com.kwad.sdk.core.report.a.k(this.c, Cea708Decoder.COMMAND_SWA);
                        }
                        m.b bVar2 = this.e;
                        if (bVar2 != null) {
                            bVar2.a(z);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.a.b();
                        if (this.b.a() == 1 || this.b.a() == 2 || this.b.a() == 5 || this.b.a() == 8) {
                            com.kwad.sdk.core.report.a.k(this.c, 150);
                        } else {
                            com.kwad.sdk.core.report.a.j(this.c, this.d);
                        }
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.m.a
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        super.c();
                        com.kwad.sdk.core.report.a.k(this.c, 150);
                        com.kwad.components.ad.reward.l lVar2 = this.f;
                        lVar2.a(lVar2.M, Cea708Decoder.COMMAND_DS4, 1);
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.m.a
                public final void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        super.d();
                        com.kwad.sdk.core.report.a.k(this.c, 150);
                        com.kwad.components.ad.reward.l lVar2 = this.f;
                        lVar2.a(lVar2.M, Cea708Decoder.COMMAND_DS4, 1);
                    }
                }
            });
        }
    }

    public static void a(com.kwad.components.ad.reward.l lVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar, bVar) == null) {
            if (com.kwad.components.ad.reward.q.a(lVar.g) && bVar != null && bVar.g()) {
                return;
            }
            b(lVar.L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
        r11 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.kwad.components.ad.reward.l lVar, boolean z, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{lVar, Boolean.valueOf(z), aVar}) == null) {
            AdTemplate adTemplate = lVar.g;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (!lVar.t) {
                lVar.b.b();
                if (com.kwad.sdk.core.response.a.a.aw(i)) {
                    lVar.a();
                    b(lVar.L);
                    return;
                } else if (lVar.u) {
                    f(lVar);
                    return;
                } else {
                    com.kwad.sdk.core.report.a.h(adTemplate, lVar.e);
                    lVar.j.e();
                    lVar.c();
                    a(lVar);
                    return;
                }
            }
            e(lVar);
            boolean z2 = false;
            boolean z3 = !lVar.w && a(lVar.g);
            if (b(adTemplate) || c(adTemplate) || lVar.F < com.kwad.sdk.core.response.a.a.r(i)) {
                boolean z4 = lVar.n() ? false : false;
                if (!z3) {
                    if (com.kwad.sdk.core.response.a.a.ax(i)) {
                        lVar.a();
                        b(lVar.L);
                        return;
                    }
                    f(lVar);
                    com.kwad.components.ad.reward.o.a(lVar);
                    return;
                }
                if (z4 && aVar != null && aVar.g()) {
                    z2 = true;
                }
                if (z2) {
                    return;
                }
                a(lVar, new m.b(lVar, i) { // from class: com.kwad.components.ad.reward.presenter.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.ad.reward.l a;
                    public final /* synthetic */ AdInfo b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lVar, i};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = lVar;
                        this.b = i;
                    }

                    @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                    public final void a(boolean z5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z5) == null) {
                            super.a(z5);
                            if (this.a.A || com.kwad.components.ad.reward.kwai.b.d(this.b)) {
                                e.b(this.a.L);
                            } else if (com.kwad.sdk.core.response.a.a.ax(this.b)) {
                                this.a.a();
                                e.b(this.a.L);
                            } else {
                                e.f(this.a);
                                com.kwad.components.ad.reward.o.a(this.a);
                            }
                        }
                    }
                });
            } else if (lVar.A) {
                b(lVar.L);
            } else if (!lVar.G && lVar.F < com.kwad.sdk.core.response.a.a.r(i)) {
                if (z) {
                    b(lVar.L);
                }
            } else {
                if (lVar.G) {
                    lVar.a(2);
                } else {
                    lVar.a(1);
                }
                j(lVar);
                if (com.kwad.sdk.core.response.a.a.ax(i)) {
                    lVar.a();
                    b(lVar.L);
                    return;
                }
                f(lVar);
                com.kwad.components.ad.reward.o.a(lVar);
            }
        }
    }

    public static boolean a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.a.s(com.kwad.sdk.core.response.a.d.i(adTemplate)) : invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!com.kwad.components.ad.reward.kwai.b.n()) {
                com.kwad.sdk.core.d.b.e(str, "isEnable false");
                return true;
            }
            int m = com.kwad.components.ad.reward.kwai.b.m();
            com.kwad.sdk.core.d.b.a(str, "JumpDirectMaxCount " + m);
            if (m <= 0) {
                return true;
            }
            if (a >= m) {
                com.kwad.sdk.core.d.b.a(str, "has JumpDirect times " + a);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, adTemplate, adInfo)) == null) {
            if (com.kwad.sdk.core.response.a.a.ar(adInfo)) {
                str2 = "is playable return";
            } else if (!com.kwad.sdk.core.response.a.a.I(adInfo)) {
                str2 = "is not Download type";
            } else if (adTemplate.mPlayAgain != null) {
                str2 = "is playAgain return";
            } else if (com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(adInfo))) {
                str2 = "isRewardLaunchAppTask";
            } else if (!com.kwad.sdk.core.response.a.b.n(adInfo)) {
                return false;
            } else {
                str2 = "is Aggregation return";
            }
            com.kwad.sdk.core.d.b.c(str, str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, activity) == null) || activity == null) {
            return;
        }
        activity.finish();
    }

    public static void b(com.kwad.components.ad.reward.l lVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, lVar, bVar) == null) {
            AdTemplate adTemplate = lVar.g;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            boolean a2 = com.kwad.components.ad.reward.q.a(adTemplate);
            if (lVar.t) {
                int d = lVar.d();
                boolean z = true;
                if (!b(adTemplate) && !c(adTemplate)) {
                    if (com.kwad.sdk.core.response.a.b.A(lVar.g) && lVar.g.mPlayAgain != null && !lVar.h() && lVar.w && d == 2) {
                        if (bVar != null) {
                            bVar.c_();
                            return;
                        }
                        return;
                    }
                    if (lVar.G || lVar.F >= com.kwad.sdk.core.response.a.a.r(i)) {
                        j(lVar);
                    }
                    i(lVar);
                    if ((a2 && bVar != null && bVar.g()) ? false : false) {
                        return;
                    }
                    b(lVar.L);
                    return;
                }
                e(lVar);
                if ((lVar.w || !a(lVar.g) || lVar.v) ? false : false) {
                    h(lVar);
                    return;
                }
            }
            i(lVar);
            b(lVar.L);
        }
    }

    public static boolean b(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(com.kwad.sdk.core.response.a.d.i(adTemplate))) : invokeL.booleanValue;
    }

    public static boolean c(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.q(adTemplate) : invokeL.booleanValue;
    }

    public static void e(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, lVar) == null) {
            long j = lVar.E;
            int i = j != 0 ? (int) (j / 1000) : 0;
            long j2 = lVar.F;
            int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
            u.b bVar = new u.b();
            bVar.e = 69;
            bVar.t = i;
            bVar.u = i2;
            com.kwad.sdk.core.report.a.b(lVar.g, Cea708Decoder.COMMAND_DLY, bVar, lVar.e);
        }
    }

    public static void f(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, lVar) == null) {
            long j = lVar.F;
            int i = j != 0 ? (int) (j / 1000) : 0;
            lVar.v = true;
            AdTemplate adTemplate = lVar.g;
            com.kwad.sdk.core.report.a.b(adTemplate, com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.i(adTemplate)), i);
            if (g.a(lVar)) {
                az.a(new Runnable(lVar) { // from class: com.kwad.components.ad.reward.presenter.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.ad.reward.l a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = lVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.g(this.a);
                        }
                    }
                }, 200L);
            } else {
                g(lVar);
            }
        }
    }

    public static void g(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, lVar) == null) {
            lVar.j.d();
        }
    }

    public static void h(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, lVar) == null) {
            com.kwad.components.ad.reward.l.a(lVar, com.kwad.components.ad.reward.m.a(lVar, (String) null), new m.b(lVar.g, lVar) { // from class: com.kwad.components.ad.reward.presenter.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;
                public final /* synthetic */ com.kwad.components.ad.reward.l b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                    this.b = lVar;
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.c(this.a, 149, this.b.e);
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                        if (!z) {
                            com.kwad.sdk.core.report.a.k(this.a, Cea708Decoder.COMMAND_SWA);
                        }
                        e.i(this.b);
                        e.b(this.b.L);
                    }
                }

                @Override // com.kwad.components.ad.reward.m.b, com.kwad.components.ad.reward.e
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.a.k(this.a, 150);
                    }
                }
            });
        }
    }

    public static void i(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, lVar) == null) {
            lVar.b.a(false);
        }
    }

    public static void j(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, lVar) == null) {
            lVar.b.e();
        }
    }
}
