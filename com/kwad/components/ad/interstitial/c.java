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
import com.kwad.components.core.k.f;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean fq;
    public m<com.kwad.components.core.k.a, AdResultData> fr;

    /* renamed from: com.kwad.components.ad.interstitial.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneImpl fs;
        public final /* synthetic */ b ft;
        public final /* synthetic */ long fu;
        public final /* synthetic */ c fv;

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
            this.fv = cVar;
            this.fs = sceneImpl;
            this.ft = bVar;
            this.fu = j;
        }

        @Override // com.kwad.components.core.k.g
        public final void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adResultData) == null) {
                bd.runOnUiThread(new Runnable(this, adResultData) { // from class: com.kwad.components.ad.interstitial.c.1.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass1 fw;
                    public final /* synthetic */ AdResultData fx;

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
                        this.fw = this;
                        this.fx = adResultData;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : this.fx.getAdTemplateList()) {
                                if (adTemplate != null) {
                                    if (adTemplate.mAdScene == null) {
                                        adTemplate.mAdScene = this.fw.fs;
                                    }
                                    arrayList.add(adTemplate);
                                }
                            }
                            bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.interstitial.c.1.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List aZ;
                                public final /* synthetic */ AnonymousClass2 fy;

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
                                    this.fy = this;
                                    this.aZ = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.fy.fw.ft.onInterstitialAdLoad(this.aZ);
                                        AnonymousClass2 anonymousClass2 = this.fy;
                                        AnonymousClass1 anonymousClass1 = anonymousClass2.fw;
                                        c cVar = anonymousClass1.fv;
                                        c.a(anonymousClass2.fx, anonymousClass1.fu);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.k.g
        public final void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.interstitial.c.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int aW;
                    public final /* synthetic */ String aX;
                    public final /* synthetic */ AnonymousClass1 fw;

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
                        this.fw = this;
                        this.aW = i;
                        this.aX = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.e.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static c fA;
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
            fA = new c((byte) 0);
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdTemplate> list);
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
        this.fq = false;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private void a(com.kwad.components.core.k.kwai.b bVar, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bVar, fVar) == null) {
            com.kwad.components.core.h.a aVar = new com.kwad.components.core.h.a(bVar);
            this.fr = aVar;
            aVar.request(new n<com.kwad.components.core.k.a, AdResultData>(this, fVar) { // from class: com.kwad.components.ad.interstitial.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c fv;
                public final /* synthetic */ f fz;

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
                    this.fv = this;
                    this.fz = fVar;
                }

                private void b(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, adResultData) == null) {
                        this.fv.fq = false;
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.fz.a(adResultData);
                            return;
                        }
                        f fVar2 = this.fz;
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Yd;
                        fVar2.onError(fVar3.errorCode, fVar3.Qd);
                    }
                }

                private void c(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65538, this, i, str) == null) {
                        this.fv.fq = false;
                        this.fz.onError(i, str);
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                    c(i, str);
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
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

    public static c cd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.fA : (c) invokeV.objValue;
    }

    public final void a(int i, int i2, @NonNull SceneImpl sceneImpl, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sceneImpl, bVar}) == null) || this.fq) {
            return;
        }
        SceneImpl m85clone = sceneImpl.m85clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m85clone.setAdStyle(16);
        m85clone.setAdNum(i2);
        a(new com.kwad.components.core.k.kwai.b(m85clone), new AnonymousClass1(this, sceneImpl, bVar, elapsedRealtime));
    }

    public final void release() {
        m<com.kwad.components.core.k.a, AdResultData> mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mVar = this.fr) == null) {
            return;
        }
        mVar.cancel();
    }
}
