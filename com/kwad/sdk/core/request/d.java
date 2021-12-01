package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.request.model.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.n;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.as;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements KsLoadManager {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.request.d$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsLoadManager.FeedAdListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f57739b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f57740c;

        public AnonymousClass5(d dVar, KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, feedAdListener, ksScene};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57740c = dVar;
            this.a = feedAdListener;
            this.f57739b = ksScene;
        }

        @Override // com.kwad.sdk.core.request.d.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f57741b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass5 f57742c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57742c = this;
                        this.a = i2;
                        this.f57741b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57741b));
                            this.f57742c.a.onError(this.a, this.f57741b);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.request.d.a
        public void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                this.f57740c.c(adResultData, this.f57739b.getPosId());
                ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            KsScene ksScene = this.f57739b;
                            if (ksScene instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene;
                            }
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f57739b.getWidth(), true));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.R(j2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.request.d.5.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ List a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f57743b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f57743b = this;
                            this.a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.a.size();
                                if (size == 0) {
                                    this.f57743b.a.onFeedAdLoad(this.a);
                                    return;
                                }
                                b.a aVar = new b.a(size);
                                for (KsFeedAd ksFeedAd : this.a) {
                                    ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC2041b(this, aVar) { // from class: com.kwad.sdk.core.request.d.5.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ b.a a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass2 f57744b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, aVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f57744b = this;
                                            this.a = aVar;
                                        }

                                        @Override // com.kwad.sdk.feed.b.InterfaceC2041b
                                        public void a() {
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.a.a()) {
                                                AnonymousClass2 anonymousClass2 = this.f57744b;
                                                anonymousClass2.f57743b.a.onFeedAdLoad(anonymousClass2.a);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i2 = f.f57510e.n;
                a(i2, f.f57510e.o + str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(501559308, "Lcom/kwad/sdk/core/request/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(501559308, "Lcom/kwad/sdk/core/request/d;");
                return;
            }
        }
        a = new Handler(Looper.getMainLooper());
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static j a(KsScene ksScene, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, ksScene, z)) == null) {
            boolean o = com.kwad.sdk.core.config.b.o();
            ?? r0 = o;
            if (KsAdSDKImpl.get().getContext() != null) {
                int f2 = as.f(KsAdSDKImpl.get().getContext(), String.valueOf(ksScene.getPosId()));
                r0 = o;
                if (f2 != -1) {
                    r0 = 1;
                    if (f2 != 1) {
                        r0 = 0;
                    }
                }
            }
            j jVar = new j();
            if (z) {
                jVar.a = r0;
            }
            return jVar;
        }
        return (j) invokeLZ.objValue;
    }

    private AdTemplate a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2)) == null) {
            com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
            Object c2 = a2.c("feed_ad_cache_" + j2);
            if (c2 == null || c2 == "") {
                return null;
            }
            AdTemplate adTemplate = new AdTemplate();
            try {
                adTemplate.parseJson(new JSONObject(com.kwad.sdk.core.a.d.b(c2.toString())));
                return adTemplate;
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return null;
            }
        }
        return (AdTemplate) invokeJ.objValue;
    }

    public static void a(com.kwad.sdk.core.request.model.f fVar, @NonNull a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, fVar, aVar, z) == null) {
            a(fVar, null, false, z, a((KsScene) fVar.a, false), aVar);
        }
    }

    public static void a(com.kwad.sdk.core.request.model.f fVar, List<String> list, boolean z, boolean z2, @Nullable j jVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{fVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), jVar, aVar}) == null) {
            a(fVar, list, z, z2, jVar, aVar, false);
        }
    }

    public static void a(com.kwad.sdk.core.request.model.f fVar, List<String> list, boolean z, boolean z2, @Nullable j jVar, @NonNull a aVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{fVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), jVar, aVar, Boolean.valueOf(z3)}) == null) {
            new i<com.kwad.sdk.core.request.a, AdResultData>(fVar, list, z, jVar, z2) { // from class: com.kwad.sdk.core.request.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.request.model.f a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f57757b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f57758c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ j f57759d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f57760e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, list, Boolean.valueOf(z), jVar, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = fVar;
                    this.f57757b = list;
                    this.f57758c = z;
                    this.f57759d = jVar;
                    this.f57760e = z2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.core.request.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.core.request.a aVar2 = new com.kwad.sdk.core.request.a(this.a, this.f57757b, this.f57758c, null, this.f57759d);
                        aVar2.a(this.f57760e ? 1 : 0);
                        return aVar2;
                    }
                    return (com.kwad.sdk.core.request.a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.a.a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.request.a, AdResultData>(z3, aVar) { // from class: com.kwad.sdk.core.request.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f57761b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(z3), aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = z3;
                    this.f57761b = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.request.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, aVar2, i2, str) == null) {
                        this.f57761b.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.request.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty() || this.a) {
                            this.f57761b.a(adResultData);
                            return;
                        }
                        a aVar3 = this.f57761b;
                        f fVar2 = f.f57510e;
                        aVar3.a(fVar2.n, fVar2.o);
                    }
                }
            });
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, runnable) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                a.post(runnable);
            }
        }
    }

    private boolean a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, adTemplate)) == null) {
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo.adCacheSecond * 1000 > System.currentTimeMillis();
        }
        return invokeL.booleanValue;
    }

    public static void b(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, null, adResultData, j2) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(adTemplate, elapsedRealtime - j2);
        }
    }

    private void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, adTemplate) == null) {
            AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo;
            adBaseInfo.adCacheSecond = (System.currentTimeMillis() / 1000) + adBaseInfo.adCacheSecond;
            com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
            a2.a("feed_ad_cache_" + adTemplate.posId, com.kwad.sdk.core.a.d.a(adTemplate.toJson().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdResultData adResultData, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, this, adResultData, j2) == null) {
            AdTemplate a2 = a(j2);
            if (adResultData.adTemplateList.isEmpty() && a(a2)) {
                adResultData.adTemplateList.add(a2);
            } else if (adResultData.adTemplateList.isEmpty()) {
            } else {
                AdTemplate adTemplate = adResultData.adTemplateList.get(0);
                if (com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo.adCacheSwitch == 0) {
                    return;
                }
                if (a2 == null) {
                    b(adTemplate);
                    return;
                }
                int F = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(adTemplate));
                int F2 = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(a2));
                if (!a(a2) || F2 <= F) {
                    b(adTemplate);
                } else {
                    adResultData.adTemplateList.set(0, a2);
                }
            }
        }
    }

    public void a(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksScene) == null) {
            com.kwad.sdk.core.report.d.b();
            ksScene.setAdStyle(4);
            ksScene.setAdNum(5);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
            a(new com.kwad.sdk.core.request.model.f(ksScene), new ArrayList(), false, false, a(ksScene, false), new a(this) { // from class: com.kwad.sdk.core.request.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) || adResultData.adTemplateList.size() <= 0) {
                        return;
                    }
                    int a2 = SplashPreloadManager.b().a(adResultData, false);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onSuccess:" + adResultData.adTemplateList.size() + " saved " + a2);
                    com.kwad.sdk.core.report.d.b(adResultData.adTemplateList.size());
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene, feedAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadConfigFeedAd");
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.request.model.f(ksScene), null, false, a2, a(ksScene, true), new AnonymousClass5(this, feedAdListener, ksScene), true);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksScene, drawAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadDrawAd");
            ksScene.setAdStyle(6);
            a(new com.kwad.sdk.core.request.model.f(ksScene), new a(this, drawAdListener) { // from class: com.kwad.sdk.core.request.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.DrawAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f57745b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, drawAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57745b = this;
                    this.a = drawAdListener;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57746b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f57747c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57747c = this;
                                this.a = i2;
                                this.f57746b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57746b));
                                    this.f57747c.a.onError(this.a, this.f57746b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)))) {
                                arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            d.a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.request.d.6.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass6 f57748b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57748b = this;
                                    this.a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f57748b.a.onDrawAdLoad(this.a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = f.f57510e.n;
                        a(i2, f.f57510e.o + "(无视频资源)");
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, ksScene, feedAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadFeedAd");
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.request.model.f(ksScene), null, false, a2, a(ksScene, true), new a(this, feedAdListener, ksScene) { // from class: com.kwad.sdk.core.request.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.FeedAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f57734b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f57735c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, feedAdListener, ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57735c = this;
                    this.a = feedAdListener;
                    this.f57734b = ksScene;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57736b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f57737c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57737c = this;
                                this.a = i2;
                                this.f57736b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57736b));
                                    this.f57737c.a.onError(this.a, this.f57736b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        this.f57735c.c(adResultData, this.f57734b.getPosId());
                        ArrayList arrayList = new ArrayList();
                        String str = null;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                                if (FeedType.checkTypeValid(adTemplate)) {
                                    KsScene ksScene2 = this.f57734b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                    arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                                } else {
                                    str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.R(j2)), FeedType.fromInt(adTemplate.type));
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            d.a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.request.d.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f57738b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57738b = this;
                                    this.a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f57738b.a.onFeedAdLoad(this.a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = f.f57510e.n;
                        a(i2, f.f57510e.o + str);
                    }
                }
            }, true);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ksScene, fullScreenVideoAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadFullScreenVideoAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(3);
            a(new com.kwad.sdk.core.request.model.f(ksScene), new a(this, fullScreenVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.request.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f57708b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f57709c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f57710d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fullScreenVideoAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57710d = this;
                    this.a = fullScreenVideoAdListener;
                    this.f57708b = ksScene;
                    this.f57709c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57711b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f57712c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57712c = this;
                                this.a = i2;
                                this.f57711b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57711b));
                                    this.f57712c.a.onError(this.a, this.f57711b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.request.d.13.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f57713b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57713b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f57713b.a.onRequestResult(this.a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.b.C();
                        boolean z = false;
                        boolean z2 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f57708b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate));
                                com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " videoUrl:" + a3);
                                if (!TextUtils.isEmpty(a3)) {
                                    com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " preSize:" + C);
                                    if (C >= 0) {
                                        if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                            z = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else if (n.a(adTemplate)) {
                                        arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                        }
                        com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " downloadVideo finish");
                        if (z) {
                            if (z2) {
                                d.a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.request.d.13.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ List a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f57714b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass13 f57715c;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, arrayList, adResultData};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f57715c = this;
                                        this.a = arrayList;
                                        this.f57714b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f57715c.a.onFullScreenVideoAdLoad(this.a);
                                            d.b(this.f57714b, this.f57715c.f57709c);
                                        }
                                    }
                                });
                                return;
                            }
                            f fVar = f.f57511f;
                            a(fVar.n, fVar.o);
                            return;
                        }
                        int i2 = f.f57510e.n;
                        a(i2, f.f57510e.o + "(无视频资源)");
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ksScene, interstitialAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadInterstitialAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(13);
            a(new com.kwad.sdk.core.request.model.f(ksScene), new a(this, interstitialAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.request.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.InterstitialAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f57749b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f57750c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f57751d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, interstitialAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57751d = this;
                    this.a = interstitialAdListener;
                    this.f57749b = ksScene;
                    this.f57750c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57752b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f57753c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57753c = this;
                                this.a = i2;
                                this.f57752b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57752b));
                                    this.f57753c.a.onError(this.a, this.f57752b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    com.kwad.sdk.d.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.request.d.7.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f57754b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57754b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f57754b.a.onRequestResult(this.a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.b.C();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f57749b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate));
                                if (TextUtils.isEmpty(a3)) {
                                    aVar = new com.kwad.sdk.d.a(this.f57749b, adTemplate);
                                } else if (C >= 0) {
                                    if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    }
                                    aVar = new com.kwad.sdk.d.a(this.f57749b, adTemplate);
                                } else if (n.a(adTemplate)) {
                                    aVar = new com.kwad.sdk.d.a(this.f57749b, adTemplate);
                                }
                                arrayList.add(aVar);
                            }
                        }
                        if (arrayList.size() != 0) {
                            d.a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.request.d.7.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ List a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f57755b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass7 f57756c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList, adResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57756c = this;
                                    this.a = arrayList;
                                    this.f57755b = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f57756c.a.onInterstitialAdLoad(this.a);
                                        d.b(this.f57755b, this.f57756c.f57750c);
                                    }
                                }
                            });
                            return;
                        }
                        f fVar = f.f57510e;
                        a(fVar.n, fVar.o);
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ksScene, nativeAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadNativeAd");
            ksScene.setAdStyle(10000);
            a(new com.kwad.sdk.core.request.model.f(ksScene), new a(this, nativeAdListener) { // from class: com.kwad.sdk.core.request.d.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.NativeAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f57724b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, nativeAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57724b = this;
                    this.a = nativeAdListener;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57725b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f57726c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57726c = this;
                                this.a = i2;
                                this.f57725b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57725b));
                                    this.f57726c.a.onError(this.a, this.f57725b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                arrayList.add(new com.kwad.sdk.f.a(adTemplate));
                            }
                        }
                        d.a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.request.d.15.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f57727b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57727b = this;
                                this.a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f57727b.a.onNativeAdLoad(this.a);
                                }
                            }
                        });
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, nativeAdListener) == null) {
            if (ap.a().a(null, "loadNativeAdByJson") && ap.a().b() == 1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(new Runnable(this, nativeAdListener) { // from class: com.kwad.sdk.core.request.d.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsLoadManager.NativeAdListener a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f57728b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, nativeAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57728b = this;
                        this.a = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.a;
                            f fVar = f.f57510e;
                            nativeAdListener2.onError(fVar.n, fVar.o);
                        }
                    }
                });
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData();
                adResultData.parseJson(jSONObject);
                if (adResultData.result != 1) {
                    a(new Runnable(this, adResultData, nativeAdListener) { // from class: com.kwad.sdk.core.request.d.17
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdResultData a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f57729b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f57730c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, adResultData, nativeAdListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f57730c = this;
                            this.a = adResultData;
                            this.f57729b = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.a.result), this.a.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f57729b;
                                AdResultData adResultData2 = this.a;
                                nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                            }
                        }
                    });
                    return;
                }
                if (adResultData.isAdResultDataEmpty()) {
                    runnable = new Runnable(this, nativeAdListener) { // from class: com.kwad.sdk.core.request.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KsLoadManager.NativeAdListener a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f57731b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, nativeAdListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f57731b = this;
                            this.a = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.a;
                                f fVar = f.f57510e;
                                nativeAdListener2.onError(fVar.n, fVar.o);
                            }
                        }
                    };
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        if (adTemplate != null) {
                            arrayList.add(new com.kwad.sdk.f.a(adTemplate));
                        }
                    }
                    runnable = new Runnable(this, nativeAdListener, arrayList) { // from class: com.kwad.sdk.core.request.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KsLoadManager.NativeAdListener a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ List f57732b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f57733c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, nativeAdListener, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f57733c = this;
                            this.a = nativeAdListener;
                            this.f57732b = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.onNativeAdLoad(this.f57732b);
                            }
                        }
                    };
                }
                a(runnable);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                f fVar = f.f57509d;
                nativeAdListener.onError(fVar.n, fVar.o);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksScene, rewardVideoAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadRewardVideoAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(2);
            a(new com.kwad.sdk.core.request.model.f(ksScene), new a(this, rewardVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.request.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f57716b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f57717c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f57718d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, rewardVideoAdListener, ksScene, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57718d = this;
                    this.a = rewardVideoAdListener;
                    this.f57716b = ksScene;
                    this.f57717c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f57719b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f57720c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57720c = this;
                                this.a = i2;
                                this.f57719b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57719b));
                                    this.f57720c.a.onError(this.a, this.f57719b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.request.d.14.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AdResultData a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f57721b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57721b = this;
                                this.a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f57721b.a.onRequestResult(this.a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.b.C();
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f57716b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                                String a3 = com.kwad.sdk.core.response.a.a.a(j2);
                                if (com.kwad.sdk.core.response.a.a.as(j2)) {
                                    arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                                    z = true;
                                } else if (!TextUtils.isEmpty(a3)) {
                                    if (C >= 0) {
                                        if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                            z2 = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                                        z2 = true;
                                        z3 = true;
                                    } else if (n.a(adTemplate)) {
                                        arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                                        z2 = true;
                                        z3 = true;
                                    } else {
                                        z2 = true;
                                    }
                                }
                            }
                        }
                        if (!z) {
                            if (!z2) {
                                int i2 = f.f57510e.n;
                                a(i2, f.f57510e.o + "(无视频资源)");
                                return;
                            } else if (!z3) {
                                f fVar = f.f57511f;
                                a(fVar.n, fVar.o);
                                return;
                            }
                        }
                        d.a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.request.d.14.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ List a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f57722b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f57723c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f57723c = this;
                                this.a = arrayList;
                                this.f57722b = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f57723c.a.onRewardVideoAdLoad(this.a);
                                    d.b(this.f57722b, this.f57723c.f57717c);
                                }
                            }
                        });
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ksScene, splashScreenAdListener) == null) {
            boolean a2 = ap.a().a(ksScene, "loadSplashScreenAd");
            ksScene.setAdStyle(4);
            List<String> c2 = SplashPreloadManager.b().c();
            ksScene.setAdNum(1);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
            b bVar = new b();
            com.kwad.sdk.core.report.d.a();
            a.postDelayed(new Runnable(this, ksScene) { // from class: com.kwad.sdk.core.request.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsScene a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f57696b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57696b = this;
                    this.a = ksScene;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57696b.a(this.a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(this, bVar, splashScreenAdListener) { // from class: com.kwad.sdk.core.request.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f57697b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f57698c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, splashScreenAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57698c = this;
                    this.a = bVar;
                    this.f57697b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a = true;
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.f57697b;
                        f fVar = f.f57512g;
                        splashScreenAdListener2.onError(fVar.n, fVar.o);
                        com.kwad.sdk.core.report.d.a(4);
                    }
                }
            };
            a.postDelayed(runnable, com.kwad.sdk.core.config.b.i());
            a(new com.kwad.sdk.core.request.model.f(ksScene), c2, true, a2, a(ksScene, false), new a(this, bVar, runnable, splashScreenAdListener, ksScene) { // from class: com.kwad.sdk.core.request.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Runnable f57699b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f57700c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ KsScene f57701d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d f57702e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, runnable, splashScreenAdListener, ksScene};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57702e = this;
                    this.a = bVar;
                    this.f57699b = runnable;
                    this.f57700c = splashScreenAdListener;
                    this.f57701d = ksScene;
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (!this.a.a) {
                            d.a.removeCallbacks(this.f57699b);
                            d.a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.request.d.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f57703b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f57704c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), str};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57704c = this;
                                    this.a = i2;
                                    this.f57703b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.f57703b));
                                        this.f57704c.f57700c.onError(this.a, this.f57703b);
                                        if (this.a == f.f57513h.n) {
                                            com.kwad.sdk.core.report.d.a(0);
                                        } else {
                                            com.kwad.sdk.core.report.d.a(3);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    }
                }

                @Override // com.kwad.sdk.core.request.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        if (adResultData.adTemplateList.size() > 0) {
                            com.kwad.sdk.splashscreen.c cVar = new com.kwad.sdk.splashscreen.c(this.f57701d, adResultData);
                            d.a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.request.d.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AdResultData a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f57705b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, adResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f57705b = this;
                                    this.a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            this.f57705b.f57700c.onRequestResult(this.a.adTemplateList.size());
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.d.a.b(th);
                                        }
                                    }
                                }
                            });
                            boolean a3 = SplashPreloadManager.b().a(adResultData);
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a3);
                            if (a3) {
                                if (this.a.a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.a.removeCallbacks(this.f57699b);
                                d.a.post(new Runnable(this, cVar) { // from class: com.kwad.sdk.core.request.d.11.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ KsSplashScreenAd a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass11 f57706b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, cVar};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f57706b = this;
                                        this.a = cVar;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f57706b.f57700c.onSplashScreenAdLoad(this.a);
                                        }
                                    }
                                });
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                                com.kwad.sdk.core.report.d.a(1);
                                return;
                            } else if (SplashPreloadManager.b().b(adResultData)) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                                int a4 = SplashPreloadManager.b().a(adResultData, true);
                                if (this.a.a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.a.removeCallbacks(this.f57699b);
                                if (a4 > 0) {
                                    d.a.post(new Runnable(this, cVar) { // from class: com.kwad.sdk.core.request.d.11.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ KsSplashScreenAd a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass11 f57707b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, cVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f57707b = this;
                                            this.a = cVar;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f57707b.f57700c.onSplashScreenAdLoad(this.a);
                                            }
                                        }
                                    });
                                    com.kwad.sdk.core.report.d.a(2);
                                    return;
                                }
                                f fVar = f.f57513h;
                                a(fVar.n, fVar.o);
                                return;
                            } else if (this.a.a) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                return;
                            } else {
                                d.a.removeCallbacks(this.f57699b);
                                a(f.f57511f.n, "请求成功，但缓存未命中");
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                            }
                        } else if (this.a.a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        } else {
                            d.a.removeCallbacks(this.f57699b);
                            f fVar2 = f.f57510e;
                            a(fVar2.n, fVar2.o);
                        }
                        com.kwad.sdk.core.report.d.a(3);
                    }
                }
            });
        }
    }
}
