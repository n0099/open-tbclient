package com.kwad.components.core.a;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements com.kwad.components.core.a.c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d CY;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public SparseArray<com.kwad.components.core.a.c> CX;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<AdTemplate> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, adTemplate, adTemplate2)) == null) {
                int cf = com.kwad.sdk.core.response.a.d.cf(adTemplate2) - com.kwad.sdk.core.response.a.d.cf(adTemplate);
                if (cf != 0) {
                    return cf;
                }
                if (adTemplate.fromCache && adTemplate2.fromCache) {
                    return 0;
                }
                return adTemplate.fromCache ? 1 : -1;
            }
            return invokeLL.intValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends n<com.kwad.components.core.k.a, AdResultData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwad.components.core.k.kwai.a Dd;

        public b(com.kwad.components.core.k.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.Dd = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.k.a aVar, @NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, aVar, adResultData) == null) {
                super.onSuccess(aVar, adResultData);
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, adResultData) { // from class: com.kwad.components.core.a.d.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdResultData De;
                    public final /* synthetic */ b Df;

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
                        this.Df = this;
                        this.De = adResultData;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b bVar = this.Df;
                            b.c(this.De);
                        }
                    }
                });
                if (a(this.Dd, adResultData)) {
                    return;
                }
                com.kwad.components.core.k.kwai.a.a(this.Dd, adResultData, false);
            }
        }

        @WorkerThread
        public static void c(AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, adResultData) == null) {
                List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
                com.kwad.components.core.a.a lP = com.kwad.components.core.a.a.lP();
                if (lP == null || proceedTemplateList.size() <= 0) {
                    return;
                }
                com.kwad.components.core.a.e k = com.kwad.components.core.a.e.k(adResultData.getPosId());
                lP.lQ();
                lP.h(g.a(k, adResultData));
                lP.a(com.kwad.components.core.a.e.H(proceedTemplateList.get(0)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.k.a aVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, aVar, i, str) == null) {
                super.onError(aVar, i, str);
                com.kwad.components.core.k.kwai.a.a(this.Dd, i, str, false);
            }
        }

        public boolean a(com.kwad.components.core.k.kwai.a aVar, AdResultData adResultData) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adResultData)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void lV();
    }

    /* renamed from: com.kwad.components.core.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0571d implements com.kwad.components.core.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0571d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.components.core.a.c
        public final void c(com.kwad.components.core.k.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a(aVar, new b(aVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements com.kwad.components.core.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.components.core.a.c
        public final void c(com.kwad.components.core.k.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, aVar) { // from class: com.kwad.components.core.a.d.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ e Dg;
                    public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.Dg = this;
                        this.aB = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AdResultData d = d.d(this.aB);
                            if (d != null && !d.isAdResultDataEmpty()) {
                                com.kwad.components.core.k.kwai.a.a(this.aB, d, true);
                                return;
                            }
                            com.kwad.components.core.k.kwai.a aVar2 = this.aB;
                            d.a(aVar2, new b(aVar2));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements com.kwad.components.core.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.kwad.components.core.a.d$f$1  reason: invalid class name */
        /* loaded from: classes7.dex */
        public class AnonymousClass1 extends b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f Dh;
            public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(f fVar, com.kwad.components.core.k.kwai.a aVar, com.kwad.components.core.k.kwai.a aVar2) {
                super(aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((com.kwad.components.core.k.kwai.a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.Dh = fVar;
                this.aB = aVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLIL(65538, this, sceneImpl, adResultData, i, cVar) == null) {
                    AdResultData d = d.d(this.aB);
                    if (d == null || d.isAdResultDataEmpty()) {
                        if (cVar != null) {
                            cVar.lV();
                            return;
                        }
                        return;
                    }
                    List a = d.a(d.getProceedTemplateList());
                    List subList = a.subList(0, Math.min(i, a.size()));
                    if (subList.size() > 0) {
                        if (adResultData == null) {
                            adResultData = new AdResultData(sceneImpl);
                        }
                        com.kwad.components.core.k.kwai.a.a(this.aB, new AdResultData(adResultData, sceneImpl, subList), false);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.a.d.b, com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public final void onError(@NonNull com.kwad.components.core.k.a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, aVar, i, str) == null) {
                    com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, aVar, i, str) { // from class: com.kwad.components.core.a.d.f.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 Dk;
                        public final /* synthetic */ com.kwad.components.core.k.a Dm;
                        public final /* synthetic */ int Dn;
                        public final /* synthetic */ String Do;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar, Integer.valueOf(i), str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.Dk = this;
                            this.Dm = aVar;
                            this.Dn = i;
                            this.Do = str;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.Dk.a(this.Dm.getScene(), null, this.Dm.getAdNum(), new c(this) { // from class: com.kwad.components.core.a.d.f.1.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 Dp;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.Dp = this;
                                    }

                                    @Override // com.kwad.components.core.a.d.c
                                    public final void lV() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            AnonymousClass2 anonymousClass2 = this.Dp;
                                            com.kwad.components.core.k.kwai.a.a(anonymousClass2.Dk.aB, anonymousClass2.Dn, anonymousClass2.Do, false);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.a.d.b
            public final boolean a(com.kwad.components.core.k.kwai.a aVar, AdResultData adResultData) {
                InterceptResult invokeLL;
                AdResultData d;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adResultData)) == null) {
                    SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                    int adNum = adScene.getAdNum();
                    if (adResultData.isAdResultDataEmpty()) {
                        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, adScene, adResultData, adNum, aVar) { // from class: com.kwad.components.core.a.d.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SceneImpl Di;
                            public final /* synthetic */ int Dj;
                            public final /* synthetic */ AnonymousClass1 Dk;
                            public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;
                            public final /* synthetic */ AdResultData fx;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adScene, adResultData, Integer.valueOf(adNum), aVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.Dk = this;
                                this.Di = adScene;
                                this.fx = adResultData;
                                this.Dj = adNum;
                                this.aB = aVar;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.Dk.a(this.Di, this.fx, this.Dj, new c(this) { // from class: com.kwad.components.core.a.d.f.1.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ RunnableC05721 Dl;

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
                                            this.Dl = this;
                                        }

                                        @Override // com.kwad.components.core.a.d.c
                                        public final void lV() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                RunnableC05721 runnableC05721 = this.Dl;
                                                com.kwad.components.core.k.kwai.a.a(runnableC05721.aB, runnableC05721.fx, false);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    }
                    if (adResultData.isBidding() && (d = d.d(aVar)) != null && !d.isAdResultDataEmpty()) {
                        List a = d.a(d.getProceedTemplateList(), adResultData.getProceedTemplateList());
                        List subList = a.subList(0, Math.min(adNum, a.size()));
                        if (subList != null && subList.size() > 0) {
                            com.kwad.components.core.k.kwai.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                            return true;
                        }
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

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
                }
            }
        }

        @Override // com.kwad.components.core.a.c
        public final void c(com.kwad.components.core.k.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a(aVar, new AnonymousClass1(this, aVar, aVar));
            }
        }
    }

    public d() {
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
        SparseArray<com.kwad.components.core.a.c> sparseArray = new SparseArray<>();
        this.CX = sparseArray;
        sparseArray.append(1, new f());
        this.CX.append(2, new e());
        this.CX.append(0, new C0571d());
    }

    public static <T extends com.kwad.components.core.k.a> T a(com.kwad.sdk.d.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? bVar.get() : (T) invokeL.objValue;
    }

    public static List<AdTemplate> a(List<AdTemplate>... listArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, listArr)) == null) {
            if (listArr == null) {
                return null;
            }
            ArrayList<AdTemplate> arrayList = new ArrayList();
            for (List<AdTemplate> list : listArr) {
                arrayList.addAll(list);
            }
            Collections.sort(arrayList, new a((byte) 0));
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            for (AdTemplate adTemplate : arrayList) {
                long ca = com.kwad.sdk.core.response.a.d.ca(adTemplate);
                if (!hashSet.contains(Long.valueOf(ca))) {
                    hashSet.add(Long.valueOf(ca));
                    arrayList2.add(adTemplate);
                }
            }
            return arrayList2;
        }
        return (List) invokeL.objValue;
    }

    public static void a(com.kwad.components.core.k.kwai.a aVar, @NonNull n<com.kwad.components.core.k.a, AdResultData> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, nVar) == null) {
            new com.kwad.components.core.h.a(aVar.EI, aVar) { // from class: com.kwad.components.core.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, aVar};
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
                    this.aB = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.m
                @NonNull
                /* renamed from: ah */
                public final AdResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? AdResultData.createFromResponseJson(str, this.aB.EI.HS) : (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: fe */
                public final com.kwad.components.core.k.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a(new com.kwad.sdk.d.b<com.kwad.components.core.k.a>(this) { // from class: com.kwad.components.core.a.d.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 CZ;

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
                            this.CZ = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.d.b
                        /* renamed from: lU */
                        public com.kwad.components.core.k.a get() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeV2 = interceptable3.invokeV(65537, this)) == null) {
                                if (this.CZ.aB.getAdStyle() == 4) {
                                    this.CZ.aB.HO = SplashPreloadManager.qD().qE();
                                }
                                return new com.kwad.components.core.k.a(this.CZ.aB);
                            }
                            return (com.kwad.components.core.k.a) invokeV2.objValue;
                        }
                    }) : (com.kwad.components.core.k.a) invokeV.objValue;
                }
            }.request(nVar);
        }
    }

    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.k.kwai.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aVar)) == null) {
            com.kwad.components.core.a.a lP = com.kwad.components.core.a.a.lP();
            if (lP == null) {
                return null;
            }
            int adNum = aVar.getAdNum();
            List<g> a2 = lP.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.a.e.k(aVar.getPosId()).lY());
            if (com.kwad.sdk.core.config.d.sw()) {
                i(a2);
            }
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            Collections.sort(a2);
            return g.j(a2.subList(0, Math.min(a2.size(), adNum)));
        }
        return (AdResultData) invokeL.objValue;
    }

    public static void i(List<g> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, list) == null) || list == null) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (com.kwad.components.core.a.f.mb().a(next)) {
                com.kwad.sdk.core.e.b.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mi());
                it.remove();
            }
        }
    }

    public static d lS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (CY == null) {
                synchronized (d.class) {
                    if (CY == null) {
                        CY = new d();
                    }
                }
            }
            return CY;
        }
        return (d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.a.c lT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.CX.get(0) : (com.kwad.components.core.a.c) invokeV.objValue;
    }

    @Override // com.kwad.components.core.a.c
    public final void c(com.kwad.components.core.k.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, aVar) { // from class: com.kwad.components.core.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Da;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Da = this;
                    this.aB = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.components.core.a.e k = com.kwad.components.core.a.e.k(this.aB.getPosId());
                        bd.runOnUiThread(new Runnable(this, k) { // from class: com.kwad.components.core.a.d.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ com.kwad.components.core.a.e Db;
                            public final /* synthetic */ AnonymousClass2 Dc;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, k};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.Dc = this;
                                this.Db = k;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.components.core.a.b.b(this.Db);
                                }
                            }
                        });
                        com.kwad.components.core.a.c lT = (k.isDefault() || k.isEnable()) ? (com.kwad.components.core.a.c) this.Da.CX.get(k.lX()) : this.Da.lT();
                        if (lT == null) {
                            lT = (com.kwad.components.core.a.c) this.Da.CX.get(1);
                        }
                        lT.c(this.aB);
                    }
                }
            });
        }
    }
}
