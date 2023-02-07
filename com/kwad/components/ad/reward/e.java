package com.kwad.components.ad.reward;

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
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static int lF = 12;
    public static int lG = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void C(String str);

        void e(@Nullable List<com.kwad.components.ad.reward.c.b> list);

        void onRequestResult(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(608672093, "Lcom/kwad/components/ad/reward/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(608672093, "Lcom/kwad/components/ad/reward/e;");
        }
    }

    public static List<com.kwad.components.ad.reward.c.b> a(List<AdTemplate> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : list) {
                arrayList.add(new com.kwad.components.ad.reward.c.b(adTemplate, i));
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static void a(int i, int i2, @NonNull SceneImpl sceneImpl, int i3, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sceneImpl, Integer.valueOf(i3), aVar}) == null) {
            SceneImpl m91clone = sceneImpl.m91clone();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            m91clone.setAdStyle(i);
            m91clone.setAdNum(i2);
            a(new com.kwad.components.core.k.kwai.b(m91clone), null, false, true, new com.kwad.components.core.k.f(aVar, i3, elapsedRealtime) { // from class: com.kwad.components.ad.reward.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long fu;
                public final /* synthetic */ a lH;
                public final /* synthetic */ int lI;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Integer.valueOf(i3), Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lH = aVar;
                    this.lI = i3;
                    this.fu = elapsedRealtime;
                }

                @Override // com.kwad.components.core.k.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, adResultData) == null) {
                        bd.runOnUiThread(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.reward.e.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData fx;
                            public final /* synthetic */ AnonymousClass1 lJ;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.lJ = this;
                                this.fx = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.lJ.lH.onRequestResult(this.fx.getAdTemplateList().size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                                    }
                                }
                            }
                        });
                        bd.runOnUiThread(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.reward.e.1.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData fx;
                            public final /* synthetic */ AnonymousClass1 lJ;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.lJ = this;
                                this.fx = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.lJ.lH.e(e.a(this.fx.getAdTemplateList(), this.lJ.lI));
                                    e.a(this.fx, this.lJ.fu);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.k.g
                public final void onError(int i4, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str) == null) {
                        bd.runOnUiThread(new Runnable(this, i4, str) { // from class: com.kwad.components.ad.reward.e.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int aW;
                            public final /* synthetic */ String aX;
                            public final /* synthetic */ AnonymousClass1 lJ;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i4), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.lJ = this;
                                this.aW = i4;
                                this.aX = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.e("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                                    this.lJ.lH.C(this.aX);
                                }
                            }
                        });
                    }
                }
            }, false);
        }
    }

    public static void a(com.kwad.components.core.k.kwai.b bVar, List<String> list, boolean z, boolean z2, @NonNull com.kwad.components.core.k.f fVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), fVar, Boolean.valueOf(z3)}) == null) {
            new com.kwad.components.core.h.a(bVar, bVar, null, false, true) { // from class: com.kwad.components.ad.reward.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.b lK;
                public final /* synthetic */ List lL;
                public final /* synthetic */ boolean lM;
                public final /* synthetic */ boolean lN;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(bVar);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, bVar, r9, Boolean.valueOf(r10), Boolean.valueOf(r11)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((com.kwad.components.core.k.kwai.b) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lK = bVar;
                    this.lL = r9;
                    this.lM = r10;
                    this.lN = r11;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: fe */
                public final com.kwad.components.core.k.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        com.kwad.components.core.k.a aVar = new com.kwad.components.core.k.a(this.lK, this.lL, this.lM, null);
                        aVar.ao(this.lN ? 1 : 0);
                        return aVar;
                    }
                    return (com.kwad.components.core.k.a) invokeV.objValue;
                }
            }.request(new com.kwad.sdk.core.network.n<com.kwad.components.core.k.a, AdResultData>(false, fVar) { // from class: com.kwad.components.ad.reward.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.f fz;
                public final /* synthetic */ boolean lO;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(r6), fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.lO = r6;
                    this.fz = fVar;
                }

                private void b(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty() || this.lO) {
                            this.fz.a(adResultData);
                            return;
                        }
                        com.kwad.components.core.k.f fVar2 = this.fz;
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Yd;
                        fVar2.onError(fVar3.errorCode, fVar3.Qd);
                    }
                }

                private void c(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65538, this, i, str) == null) {
                        this.fz.onError(i, str);
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i, String str) {
                    c(i, str);
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    b((AdResultData) baseResultData);
                }
            });
        }
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, adResultData, j) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
                return;
            }
            com.kwad.components.core.j.a.og().c(adTemplate, elapsedRealtime - j);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, sceneImpl, aVar) == null) {
            a(11, lF, sceneImpl, com.kwad.components.ad.reward.c.d.REFLOW, aVar);
        }
    }

    public static void b(@NonNull SceneImpl sceneImpl, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sceneImpl, aVar) == null) {
            a(15, lG, sceneImpl, com.kwad.components.ad.reward.c.d.AGGREGATION, aVar);
        }
    }
}
