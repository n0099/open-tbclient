package com.kwad.components.ad.reward;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 12;
    public static int b = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);

        void a(String str);

        void a(@Nullable List<com.kwad.components.ad.reward.b.b> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(608672124, "Lcom/kwad/components/ad/reward/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(608672124, "Lcom/kwad/components/ad/reward/f;");
        }
    }

    public static void a(int i, int i2, @NonNull SceneImpl sceneImpl, int i3, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sceneImpl, Integer.valueOf(i3), aVar}) == null) {
            SceneImpl m1024clone = sceneImpl.m1024clone();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            m1024clone.setAdStyle(i);
            m1024clone.setAdNum(i2);
            a(new com.kwad.components.core.j.kwai.b(m1024clone), null, false, true, new com.kwad.components.core.j.f(aVar, i3, elapsedRealtime) { // from class: com.kwad.components.ad.reward.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;
                public final /* synthetic */ int b;
                public final /* synthetic */ long c;

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
                    this.a = aVar;
                    this.b = i3;
                    this.c = elapsedRealtime;
                }

                @Override // com.kwad.components.core.j.g
                public final void a(int i4, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                        az.a(new Runnable(this, i4, str) { // from class: com.kwad.components.ad.reward.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;
                            public final /* synthetic */ String b;
                            public final /* synthetic */ AnonymousClass1 c;

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
                                this.c = this;
                                this.a = i4;
                                this.b = str;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.b.e("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                                    this.c.a.a(this.b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.components.core.j.g
                public final void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.reward.f.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;
                            public final /* synthetic */ AnonymousClass1 b;

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
                                this.b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.b.a.a(this.a.getAdTemplateList().size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.b(th);
                                    }
                                }
                            }
                        });
                        az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.reward.f.1.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;
                            public final /* synthetic */ AnonymousClass1 b;

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
                                this.b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.b.a.a(f.b(this.a.getAdTemplateList(), this.b.b));
                                    f.b(this.a, this.b.c);
                                }
                            }
                        });
                    }
                }
            }, false);
        }
    }

    public static void a(com.kwad.components.core.j.kwai.b bVar, List<String> list, boolean z, boolean z2, @NonNull com.kwad.components.core.j.f fVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), fVar, Boolean.valueOf(z3)}) == null) {
            new com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData>(bVar, null, false, true) { // from class: com.kwad.components.ad.reward.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.b a;
                public final /* synthetic */ List b;
                public final /* synthetic */ boolean c;
                public final /* synthetic */ boolean d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, r7, Boolean.valueOf(r8), Boolean.valueOf(r9)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                    this.b = r7;
                    this.c = r8;
                    this.d = r9;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.components.core.j.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) {
                        com.kwad.components.core.j.a aVar = new com.kwad.components.core.j.a(this.a, this.b, this.c, null);
                        aVar.a(this.d ? 1 : 0);
                        return aVar;
                    }
                    return (com.kwad.components.core.j.a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                /* renamed from: a */
                public AdResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.a.a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            }.request(new com.kwad.sdk.core.network.m<com.kwad.components.core.j.a, AdResultData>(false, fVar) { // from class: com.kwad.components.ad.reward.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ com.kwad.components.core.j.f b;

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
                    this.a = r6;
                    this.b = fVar;
                }

                private void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65537, this, i, str) == null) {
                        this.b.a(i, str);
                    }
                }

                private void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty() || this.a) {
                            this.b.a(adResultData);
                            return;
                        }
                        com.kwad.components.core.j.f fVar2 = this.b;
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.f;
                        fVar2.a(fVar3.p, fVar3.q);
                    }
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i, String str) {
                    a(i, str);
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    a((AdResultData) baseResultData);
                }
            });
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, sceneImpl, aVar) == null) {
            a(11, a, sceneImpl, com.kwad.components.ad.reward.b.d.c, aVar);
        }
    }

    public static List<com.kwad.components.ad.reward.b.b> b(List<AdTemplate> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, list, i)) == null) {
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : list) {
                arrayList.add(new com.kwad.components.ad.reward.b.b(adTemplate, i));
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static void b(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, adResultData, j) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
                return;
            }
            com.kwad.components.core.i.a.a().a(adTemplate, elapsedRealtime - j);
        }
    }

    public static void b(@NonNull SceneImpl sceneImpl, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sceneImpl, aVar) == null) {
            a(15, b, sceneImpl, com.kwad.components.ad.reward.b.d.b, aVar);
        }
    }
}
