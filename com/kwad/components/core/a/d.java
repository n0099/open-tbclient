package com.kwad.components.core.a;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements com.kwad.components.core.a.c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public SparseArray<com.kwad.components.core.a.c> a;

    /* loaded from: classes5.dex */
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
                int y = com.kwad.sdk.core.response.a.d.y(adTemplate2) - com.kwad.sdk.core.response.a.d.y(adTemplate);
                if (y != 0) {
                    return y;
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

    /* loaded from: classes5.dex */
    public static class b extends m<com.kwad.components.core.j.a, AdResultData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwad.components.core.j.kwai.a a;

        public b(com.kwad.components.core.j.kwai.a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.j.a aVar, @NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, aVar, adResultData) == null) {
                super.onSuccess(aVar, adResultData);
                com.kwad.sdk.utils.g.a(new Runnable(this, adResultData) { // from class: com.kwad.components.core.a.d.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdResultData a;
                    public final /* synthetic */ b b;

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
                            b bVar = this.b;
                            b.a(this.a);
                        }
                    }
                });
                if (a(this.a, adResultData)) {
                    return;
                }
                com.kwad.components.core.j.kwai.a.a(this.a, adResultData, false);
            }
        }

        @WorkerThread
        public static void a(AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, adResultData) == null) {
                List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
                com.kwad.components.core.a.a a = com.kwad.components.core.a.a.a();
                if (a == null || proceedTemplateList.size() <= 0) {
                    return;
                }
                com.kwad.components.core.a.e a2 = com.kwad.components.core.a.e.a(adResultData.getPosId());
                a.b();
                a.a(com.kwad.components.core.a.f.a(a2, adResultData));
                a.a(com.kwad.components.core.a.e.a(proceedTemplateList.get(0)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.j.a aVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, aVar, i, str) == null) {
                super.onError(aVar, i, str);
                com.kwad.components.core.j.kwai.a.a(this.a, i, str, false);
            }
        }

        public boolean a(com.kwad.components.core.j.kwai.a aVar, AdResultData adResultData) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adResultData)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* renamed from: com.kwad.components.core.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0501d implements com.kwad.components.core.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0501d() {
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
        public final void a(com.kwad.components.core.j.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.b(aVar, new b(aVar));
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public final void a(com.kwad.components.core.j.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                com.kwad.sdk.utils.g.a(new Runnable(this, aVar) { // from class: com.kwad.components.core.a.d.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.core.j.kwai.a a;
                    public final /* synthetic */ e b;

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
                        this.b = this;
                        this.a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AdResultData c = d.c(this.a);
                            if (c != null && !c.isAdResultDataEmpty()) {
                                com.kwad.components.core.j.kwai.a.a(this.a, c, true);
                                return;
                            }
                            com.kwad.components.core.j.kwai.a aVar2 = this.a;
                            d.b(aVar2, new b(aVar2));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements com.kwad.components.core.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.kwad.components.core.a.d$f$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public class AnonymousClass1 extends b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.kwad.components.core.j.kwai.a a;
            public final /* synthetic */ f b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(f fVar, com.kwad.components.core.j.kwai.a aVar, com.kwad.components.core.j.kwai.a aVar2) {
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
                        super((com.kwad.components.core.j.kwai.a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = aVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLIL(65538, this, sceneImpl, adResultData, i, cVar) == null) {
                    AdResultData c = d.c(this.a);
                    if (c == null || c.isAdResultDataEmpty()) {
                        if (cVar != null) {
                            cVar.a();
                            return;
                        }
                        return;
                    }
                    List b = d.b(c.getProceedTemplateList());
                    List subList = b.subList(0, Math.min(i, b.size()));
                    if (subList.size() > 0) {
                        if (adResultData == null) {
                            adResultData = new AdResultData(sceneImpl);
                        }
                        com.kwad.components.core.j.kwai.a.a(this.a, new AdResultData(adResultData, sceneImpl, subList), false);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.a.d.b, com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public final void onError(@NonNull com.kwad.components.core.j.a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, aVar, i, str) == null) {
                    com.kwad.sdk.utils.g.a(new Runnable(this, aVar, i, str) { // from class: com.kwad.components.core.a.d.f.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.components.core.j.a a;
                        public final /* synthetic */ int b;
                        public final /* synthetic */ String c;
                        public final /* synthetic */ AnonymousClass1 d;

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
                            this.d = this;
                            this.a = aVar;
                            this.b = i;
                            this.c = str;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.d.a(this.a.getScene(), null, this.a.a(), new c(this) { // from class: com.kwad.components.core.a.d.f.1.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 a;

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
                                        this.a = this;
                                    }

                                    @Override // com.kwad.components.core.a.d.c
                                    public final void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            AnonymousClass2 anonymousClass2 = this.a;
                                            com.kwad.components.core.j.kwai.a.a(anonymousClass2.d.a, anonymousClass2.b, anonymousClass2.c, false);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.a.d.b
            public final boolean a(com.kwad.components.core.j.kwai.a aVar, AdResultData adResultData) {
                InterceptResult invokeLL;
                AdResultData c;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adResultData)) == null) {
                    SceneImpl adScene = adResultData.getAdScene(aVar.a());
                    int adNum = adScene.getAdNum();
                    if (adResultData.isAdResultDataEmpty()) {
                        com.kwad.sdk.utils.g.a(new Runnable(this, adScene, adResultData, adNum, aVar) { // from class: com.kwad.components.core.a.d.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SceneImpl a;
                            public final /* synthetic */ AdResultData b;
                            public final /* synthetic */ int c;
                            public final /* synthetic */ com.kwad.components.core.j.kwai.a d;
                            public final /* synthetic */ AnonymousClass1 e;

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
                                this.e = this;
                                this.a = adScene;
                                this.b = adResultData;
                                this.c = adNum;
                                this.d = aVar;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.e.a(this.a, this.b, this.c, new c(this) { // from class: com.kwad.components.core.a.d.f.1.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ RunnableC05021 a;

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
                                            this.a = this;
                                        }

                                        @Override // com.kwad.components.core.a.d.c
                                        public final void a() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                RunnableC05021 runnableC05021 = this.a;
                                                com.kwad.components.core.j.kwai.a.a(runnableC05021.d, runnableC05021.b, false);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    }
                    if (adResultData.isBidding() && (c = d.c(aVar)) != null && !c.isAdResultDataEmpty()) {
                        List b = d.b(c.getProceedTemplateList(), adResultData.getProceedTemplateList());
                        List subList = b.subList(0, Math.min(adNum, b.size()));
                        if (subList != null && subList.size() > 0) {
                            com.kwad.components.core.j.kwai.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
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
        public final void a(com.kwad.components.core.j.kwai.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.b(aVar, new AnonymousClass1(this, aVar, aVar));
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
        this.a = sparseArray;
        sparseArray.append(1, new f());
        this.a.append(2, new e());
        this.a.append(0, new C0501d());
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (d.class) {
                    if (b == null) {
                        b = new d();
                    }
                }
            }
            return b;
        }
        return (d) invokeV.objValue;
    }

    private com.kwad.components.core.a.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.a.get(0) : (com.kwad.components.core.a.c) invokeV.objValue;
    }

    public static <T extends com.kwad.components.core.j.a> T b(com.kwad.sdk.d.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bVar)) == null) ? bVar.a() : (T) invokeL.objValue;
    }

    public static List<AdTemplate> b(List<AdTemplate>... listArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, listArr)) == null) {
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
                long t = com.kwad.sdk.core.response.a.d.t(adTemplate);
                if (!hashSet.contains(Long.valueOf(t))) {
                    hashSet.add(Long.valueOf(t));
                    arrayList2.add(adTemplate);
                }
            }
            return arrayList2;
        }
        return (List) invokeL.objValue;
    }

    public static void b(com.kwad.components.core.j.kwai.a aVar, @NonNull m<com.kwad.components.core.j.a, AdResultData> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, aVar, mVar) == null) {
            new l<com.kwad.components.core.j.a, AdResultData>(aVar) { // from class: com.kwad.components.core.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.components.core.j.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? d.b(new com.kwad.sdk.d.b<com.kwad.components.core.j.a>(this) { // from class: com.kwad.components.core.a.d.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 a;

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
                            this.a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.d.b
                        /* renamed from: b */
                        public com.kwad.components.core.j.a a() {
                            InterceptResult invokeV2;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeV2 = interceptable3.invokeV(65537, this)) == null) ? new com.kwad.components.core.j.a(this.a.a) : (com.kwad.components.core.j.a) invokeV2.objValue;
                        }
                    }) : (com.kwad.components.core.j.a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                /* renamed from: a */
                public AdResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, str)) == null) ? AdResultData.createFromResponseJson(str, this.a.a.a) : (AdResultData) invokeL.objValue;
                }
            }.request(mVar);
        }
    }

    @Nullable
    @WorkerThread
    public static AdResultData c(com.kwad.components.core.j.kwai.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) {
            com.kwad.components.core.a.a a2 = com.kwad.components.core.a.a.a();
            if (a2 == null) {
                return null;
            }
            int b2 = aVar.b();
            List<com.kwad.components.core.a.f> a3 = a2.a(String.valueOf(aVar.a()), System.currentTimeMillis() / 1000, com.kwad.components.core.a.e.a(aVar.a()).b());
            if (a3 == null || a3.size() <= 0) {
                return null;
            }
            Collections.sort(a3);
            return com.kwad.components.core.a.f.a(a3.subList(0, Math.min(a3.size(), b2)));
        }
        return (AdResultData) invokeL.objValue;
    }

    @Override // com.kwad.components.core.a.c
    public final void a(com.kwad.components.core.j.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            com.kwad.components.core.a.e a2 = com.kwad.components.core.a.e.a(aVar.a());
            com.kwad.components.core.a.b.a(a2);
            com.kwad.components.core.a.c b2 = (a2.e() || a2.d()) ? this.a.get(a2.a()) : b();
            if (b2 == null) {
                b2 = this.a.get(1);
            }
            b2.a(aVar);
        }
    }
}
