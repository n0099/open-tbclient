package com.kwad.components.ad.interstitial;

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
import com.kwad.components.core.j.f;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public l<com.kwad.components.core.j.a, AdResultData> b;

    /* renamed from: com.kwad.components.ad.interstitial.c$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneImpl a;
        public final /* synthetic */ b b;
        public final /* synthetic */ long c;
        public final /* synthetic */ c d;

        public AnonymousClass1(c cVar, SceneImpl sceneImpl, b bVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, sceneImpl, bVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cVar;
            this.a = sceneImpl;
            this.b = bVar;
            this.c = j;
        }

        @Override // com.kwad.components.core.j.g
        public final void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.interstitial.c.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ AnonymousClass1 c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = i;
                        this.b = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.j.g
        public final void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.interstitial.c.1.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdResultData a;
                    public final /* synthetic */ AnonymousClass1 b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adResultData};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = adResultData;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : this.a.getAdTemplateList()) {
                                if (adTemplate != null) {
                                    if (adTemplate.mAdScene == null) {
                                        adTemplate.mAdScene = this.b.a;
                                    }
                                    arrayList.add(adTemplate);
                                }
                            }
                            az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.interstitial.c.1.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;
                                public final /* synthetic */ AnonymousClass2 b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.b.b.b.a(this.a);
                                        AnonymousClass2 anonymousClass2 = this.b;
                                        AnonymousClass1 anonymousClass1 = anonymousClass2.b;
                                        c cVar = anonymousClass1.d;
                                        c.a(anonymousClass2.a, anonymousClass1.c);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228478949, "Lcom/kwad/components/ad/interstitial/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(228478949, "Lcom/kwad/components/ad/interstitial/c$a;");
                    return;
                }
            }
            a = new c((byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@Nullable List<AdTemplate> list);
    }

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
        this.a = false;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (c) invokeV.objValue;
    }

    private void a(com.kwad.components.core.j.kwai.b bVar, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, fVar) == null) {
            l<com.kwad.components.core.j.a, AdResultData> lVar = new l<com.kwad.components.core.j.a, AdResultData>(this, bVar) { // from class: com.kwad.components.ad.interstitial.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.b a;
                public final /* synthetic */ c b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.components.core.j.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new com.kwad.components.core.j.a(this.a) : (com.kwad.components.core.j.a) invokeV.objValue;
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
            };
            this.b = lVar;
            lVar.request(new m<com.kwad.components.core.j.a, AdResultData>(this, fVar) { // from class: com.kwad.components.ad.interstitial.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;
                public final /* synthetic */ c b;

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
                    this.b = this;
                    this.a = fVar;
                }

                private void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65537, this, i, str) == null) {
                        this.b.a = false;
                        this.a.a(i, str);
                    }
                }

                private void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, adResultData) == null) {
                        this.b.a = false;
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.a.a(adResultData);
                            return;
                        }
                        f fVar2 = this.a;
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.f;
                        fVar2.a(fVar3.p, fVar3.q);
                    }
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                    a(i, str);
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                    a((AdResultData) baseResultData);
                }
            });
        }
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65541, null, adResultData, j) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
                return;
            }
            com.kwad.components.core.i.a.a().a(adTemplate, elapsedRealtime - j);
        }
    }

    public final void a(int i, int i2, @NonNull SceneImpl sceneImpl, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sceneImpl, bVar}) == null) || this.a) {
            return;
        }
        SceneImpl m1024clone = sceneImpl.m1024clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m1024clone.setAdStyle(16);
        m1024clone.setAdNum(i2);
        a(new com.kwad.components.core.j.kwai.b(m1024clone), new AnonymousClass1(this, sceneImpl, bVar, elapsedRealtime));
    }

    public final void b() {
        l<com.kwad.components.core.j.a, AdResultData> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lVar = this.b) == null) {
            return;
        }
        lVar.cancel();
    }
}
