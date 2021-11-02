package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.core.g.a.k;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.page.widget.webview.KSApiWebView;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements KsLoadManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f64632a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.g.d$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f64702a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f64703b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f64704c;

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
            this.f64704c = dVar;
            this.f64702a = feedAdListener;
            this.f64703b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f64705a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f64706b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass5 f64707c;

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
                        this.f64707c = this;
                        this.f64705a = i2;
                        this.f64706b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64705a), this.f64706b));
                            this.f64707c.f64702a.onError(this.f64705a, this.f64706b);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            KsScene ksScene = this.f64703b;
                            if (ksScene instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene;
                            }
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f64703b.getWidth(), true));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(i2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.f64632a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.5.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f64708a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f64709b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64709b = this;
                            this.f64708a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.f64708a.size();
                                if (size == 0) {
                                    this.f64709b.f64702a.onFeedAdLoad(this.f64708a);
                                    return;
                                }
                                b.a aVar = new b.a(size);
                                for (KsFeedAd ksFeedAd : this.f64708a) {
                                    ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC1924b(this, aVar) { // from class: com.kwad.sdk.core.g.d.5.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ b.a f64710a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass2 f64711b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, aVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f64711b = this;
                                            this.f64710a = aVar;
                                        }

                                        @Override // com.kwad.sdk.feed.b.InterfaceC1924b
                                        public void a() {
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.f64710a.a()) {
                                                AnonymousClass2 anonymousClass2 = this.f64711b;
                                                anonymousClass2.f64709b.f64702a.onFeedAdLoad(anonymousClass2.f64708a);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i3 = f.f64805e.m;
                a(i3, f.f64805e.n + str);
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

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f64737a;

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
            this.f64737a = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890041588, "Lcom/kwad/sdk/core/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890041588, "Lcom/kwad/sdk/core/g/d;");
                return;
            }
        }
        f64632a = new Handler(Looper.getMainLooper());
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
    public static k a(KsScene ksScene, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, ksScene, z)) == null) {
            boolean t = com.kwad.sdk.core.config.c.t();
            ?? r0 = t;
            if (KsAdSDKImpl.get().getContext() != null) {
                int f2 = am.f(KsAdSDKImpl.get().getContext(), String.valueOf(ksScene.getPosId()));
                r0 = t;
                if (f2 != -1) {
                    r0 = 1;
                    if (f2 != 1) {
                        r0 = 0;
                    }
                }
            }
            k kVar = new k();
            if (z) {
                kVar.f64622a = r0;
            }
            return kVar;
        }
        return (k) invokeLZ.objValue;
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar, aVar, z) == null) {
            a(fVar, null, false, z, a((KsScene) fVar.f64599a, false), aVar);
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, List<String> list, boolean z, boolean z2, @Nullable k kVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{fVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), kVar, aVar}) == null) {
            new i<com.kwad.sdk.core.g.a, AdResultData>(fVar, list, z, kVar, z2) { // from class: com.kwad.sdk.core.g.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.f f64731a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f64732b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f64733c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f64734d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f64735e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, list, Boolean.valueOf(z), kVar, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64731a = fVar;
                    this.f64732b = list;
                    this.f64733c = z;
                    this.f64734d = kVar;
                    this.f64735e = z2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.core.g.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.core.g.a aVar2 = new com.kwad.sdk.core.g.a(this.f64731a, this.f64732b, this.f64733c, null, this.f64734d);
                        aVar2.a(this.f64735e ? 1 : 0);
                        return aVar2;
                    }
                    return (com.kwad.sdk.core.g.a) invokeV.objValue;
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
                        AdResultData adResultData = new AdResultData(this.f64731a.f64599a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            }.a(new j<com.kwad.sdk.core.g.a, AdResultData>(aVar) { // from class: com.kwad.sdk.core.g.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f64736a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64736a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar2, i2, str) == null) {
                        this.f64736a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.f64736a.a(adResultData);
                            return;
                        }
                        a aVar3 = this.f64736a;
                        f fVar2 = f.f64805e;
                        aVar3.a(fVar2.m, fVar2.n);
                    }
                }
            });
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, runnable) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                f64632a.post(runnable);
            }
        }
    }

    public static void b(AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, adResultData) == null) || KsAdSDKImpl.get().getContext() == null || adResultData.adTemplateList.size() <= 0) {
            return;
        }
        new KSApiWebView(KsAdSDKImpl.get().getContext()).loadUrl(com.kwad.sdk.core.response.b.c.i(adResultData.adTemplateList.get(0)).adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl);
    }

    public static void b(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, adResultData, j) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(adTemplate, elapsedRealtime - j);
        }
    }

    public void a(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksScene) == null) {
            com.kwad.sdk.core.report.d.b();
            ksScene.setAdStyle(4);
            ksScene.setAdNum(5);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
            a(new com.kwad.sdk.core.g.a.f(ksScene), new ArrayList(), false, false, a(ksScene, false), new a(this) { // from class: com.kwad.sdk.core.g.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f64652a;

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
                    this.f64652a = this;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
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
            boolean a2 = ak.a().a(ksScene, "loadConfigFeedAd");
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), null, false, a2, a(ksScene, true), new AnonymousClass5(this, feedAdListener, ksScene));
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksScene, drawAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadDrawAd");
            ksScene.setAdStyle(6);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, drawAdListener) { // from class: com.kwad.sdk.core.g.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.DrawAdListener f64712a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f64713b;

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
                    this.f64713b = this;
                    this.f64712a = drawAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64714a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64715b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f64716c;

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
                                this.f64716c = this;
                                this.f64714a = i2;
                                this.f64715b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64714a), this.f64715b));
                                    this.f64716c.f64712a.onError(this.f64714a, this.f64715b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate)))) {
                                arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            d.f64632a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.6.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f64717a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass6 f64718b;

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
                                    this.f64718b = this;
                                    this.f64717a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f64718b.f64712a.onDrawAdLoad(this.f64717a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = f.f64805e.m;
                        a(i2, f.f64805e.n + "(无视频资源)");
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, ksScene, feedAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadFeedAd");
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), null, false, a2, a(ksScene, true), new a(this, feedAdListener, ksScene) { // from class: com.kwad.sdk.core.g.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.FeedAdListener f64694a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f64695b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f64696c;

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
                    this.f64696c = this;
                    this.f64694a = feedAdListener;
                    this.f64695b = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64697a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64698b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f64699c;

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
                                this.f64699c = this;
                                this.f64697a = i2;
                                this.f64698b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64697a), this.f64698b));
                                    this.f64699c.f64694a.onError(this.f64697a, this.f64698b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        String str = null;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
                                if (FeedType.checkTypeValid(adTemplate)) {
                                    KsScene ksScene2 = this.f64695b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                    arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                                } else {
                                    str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(i2)), FeedType.fromInt(adTemplate.type));
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            d.f64632a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f64700a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f64701b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, arrayList};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f64701b = this;
                                    this.f64700a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f64701b.f64694a.onFeedAdLoad(this.f64700a);
                                    }
                                }
                            });
                            return;
                        }
                        int i3 = f.f64805e.m;
                        a(i3, f.f64805e.n + str);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ksScene, fullScreenVideoAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadFullScreenVideoAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(3);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, fullScreenVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.g.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener f64653a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f64654b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f64655c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f64656d;

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
                    this.f64656d = this;
                    this.f64653a = fullScreenVideoAdListener;
                    this.f64654b = ksScene;
                    this.f64655c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64657a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64658b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f64659c;

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
                                this.f64659c = this;
                                this.f64657a = i2;
                                this.f64658b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64657a), this.f64658b));
                                    this.f64659c.f64653a.onError(this.f64657a, this.f64658b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f64632a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.13.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f64660a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f64661b;

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
                                this.f64661b = this;
                                this.f64660a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f64661b.f64653a.onRequestResult(this.f64660a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.c.C();
                        boolean z = false;
                        boolean z2 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f64654b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate));
                                if (!TextUtils.isEmpty(a3)) {
                                    if (C >= 0) {
                                        if (C > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                            z = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else if (g.a(adTemplate)) {
                                        arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                        }
                        if (z) {
                            if (z2) {
                                d.f64632a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.13.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ List f64662a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f64663b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass13 f64664c;

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
                                        this.f64664c = this;
                                        this.f64662a = arrayList;
                                        this.f64663b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f64664c.f64653a.onFullScreenVideoAdLoad(this.f64662a);
                                            d.b(this.f64663b, this.f64664c.f64655c);
                                            try {
                                                d.b(this.f64663b);
                                            } catch (Throwable th) {
                                                com.kwad.sdk.core.d.a.a(th);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            f fVar = f.f64806f;
                            a(fVar.m, fVar.n);
                            return;
                        }
                        int i2 = f.f64805e.m;
                        a(i2, f.f64805e.n + "(无视频资源)");
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ksScene, interstitialAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadInterstitialAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(13);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, interstitialAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.g.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.InterstitialAdListener f64719a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f64720b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f64721c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f64722d;

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
                    this.f64722d = this;
                    this.f64719a = interstitialAdListener;
                    this.f64720b = ksScene;
                    this.f64721c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64723a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64724b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f64725c;

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
                                this.f64725c = this;
                                this.f64723a = i2;
                                this.f64724b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64723a), this.f64724b));
                                    this.f64725c.f64719a.onError(this.f64723a, this.f64724b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    com.kwad.sdk.a.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f64632a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.7.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f64726a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f64727b;

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
                                this.f64727b = this;
                                this.f64726a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f64727b.f64719a.onRequestResult(this.f64726a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.c.C();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f64720b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate));
                                if (TextUtils.isEmpty(a3)) {
                                    aVar = new com.kwad.sdk.a.a(this.f64720b, adTemplate);
                                } else if (C >= 0) {
                                    if (C > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    }
                                    aVar = new com.kwad.sdk.a.a(this.f64720b, adTemplate);
                                } else if (g.a(adTemplate)) {
                                    aVar = new com.kwad.sdk.a.a(this.f64720b, adTemplate);
                                }
                                arrayList.add(aVar);
                            }
                        }
                        if (arrayList.size() != 0) {
                            d.f64632a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.7.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f64728a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f64729b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass7 f64730c;

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
                                    this.f64730c = this;
                                    this.f64728a = arrayList;
                                    this.f64729b = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f64730c.f64719a.onInterstitialAdLoad(this.f64728a);
                                        d.b(this.f64729b, this.f64730c.f64721c);
                                    }
                                }
                            });
                            return;
                        }
                        f fVar = f.f64805e;
                        a(fVar.m, fVar.n);
                    }
                }
            }, a2);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ksScene, nativeAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadNativeAd");
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, nativeAdListener) { // from class: com.kwad.sdk.core.g.d.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.NativeAdListener f64677a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f64678b;

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
                    this.f64678b = this;
                    this.f64677a = nativeAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64679a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64680b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f64681c;

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
                                this.f64681c = this;
                                this.f64679a = i2;
                                this.f64680b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64679a), this.f64680b));
                                    this.f64681c.f64677a.onError(this.f64679a, this.f64680b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                arrayList.add(new com.kwad.sdk.b.a(adTemplate));
                            }
                        }
                        d.f64632a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.15.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f64682a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f64683b;

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
                                this.f64683b = this;
                                this.f64682a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f64683b.f64677a.onNativeAdLoad(this.f64682a);
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
            if (ak.a().a(null, "loadNativeAdByJson") && ak.a().b() == 1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(new Runnable(this, nativeAdListener) { // from class: com.kwad.sdk.core.g.d.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ KsLoadManager.NativeAdListener f64684a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f64685b;

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
                        this.f64685b = this;
                        this.f64684a = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.f64684a;
                            f fVar = f.f64805e;
                            nativeAdListener2.onError(fVar.m, fVar.n);
                        }
                    }
                });
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData();
                adResultData.parseJson(jSONObject);
                if (adResultData.result != 1) {
                    a(new Runnable(this, adResultData, nativeAdListener) { // from class: com.kwad.sdk.core.g.d.17
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdResultData f64686a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f64687b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f64688c;

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
                            this.f64688c = this;
                            this.f64686a = adResultData;
                            this.f64687b = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.f64686a.result), this.f64686a.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f64687b;
                                AdResultData adResultData2 = this.f64686a;
                                nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                            }
                        }
                    });
                    return;
                }
                if (adResultData.isAdResultDataEmpty()) {
                    runnable = new Runnable(this, nativeAdListener) { // from class: com.kwad.sdk.core.g.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f64689a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f64690b;

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
                            this.f64690b = this;
                            this.f64689a = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f64689a;
                                f fVar = f.f64805e;
                                nativeAdListener2.onError(fVar.m, fVar.n);
                            }
                        }
                    };
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        if (adTemplate != null) {
                            arrayList.add(new com.kwad.sdk.b.a(adTemplate));
                        }
                    }
                    runnable = new Runnable(this, nativeAdListener, arrayList) { // from class: com.kwad.sdk.core.g.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f64691a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ List f64692b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f64693c;

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
                            this.f64693c = this;
                            this.f64691a = nativeAdListener;
                            this.f64692b = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f64691a.onNativeAdLoad(this.f64692b);
                            }
                        }
                    };
                }
                a(runnable);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                f fVar = f.f64804d;
                nativeAdListener.onError(fVar.m, fVar.n);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksScene, rewardVideoAdListener) == null) {
            boolean a2 = ak.a().a(ksScene, "loadRewardVideoAd");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(2);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, rewardVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.g.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener f64665a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f64666b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f64667c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f64668d;

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
                    this.f64668d = this;
                    this.f64665a = rewardVideoAdListener;
                    this.f64666b = ksScene;
                    this.f64667c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64669a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f64670b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f64671c;

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
                                this.f64671c = this;
                                this.f64669a = i2;
                                this.f64670b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64669a), this.f64670b));
                                    this.f64671c.f64665a.onError(this.f64669a, this.f64670b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f64632a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.14.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f64672a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f64673b;

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
                                this.f64673b = this;
                                this.f64672a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f64673b.f64665a.onRequestResult(this.f64672a.adTemplateList.size());
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.b(th);
                                    }
                                }
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        int C = com.kwad.sdk.core.config.c.C();
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f64666b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
                                String a3 = com.kwad.sdk.core.response.b.a.a(i2);
                                if (com.kwad.sdk.core.response.b.a.af(i2)) {
                                    arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                    z = true;
                                } else if (!TextUtils.isEmpty(a3)) {
                                    if (C >= 0) {
                                        if (C > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                            z2 = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                        z2 = true;
                                        z3 = true;
                                    } else if (g.a(adTemplate)) {
                                        arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
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
                                int i3 = f.f64805e.m;
                                a(i3, f.f64805e.n + "(无视频资源)");
                                return;
                            } else if (!z3) {
                                f fVar = f.f64806f;
                                a(fVar.m, fVar.n);
                                return;
                            }
                        }
                        d.f64632a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.14.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f64674a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f64675b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f64676c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f64676c = this;
                                this.f64674a = arrayList;
                                this.f64675b = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f64676c.f64665a.onRewardVideoAdLoad(this.f64674a);
                                    d.b(this.f64675b, this.f64676c.f64667c);
                                    try {
                                        d.b(this.f64675b);
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.a.a(th);
                                    }
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
            boolean a2 = ak.a().a(ksScene, "loadSplashScreenAd");
            ksScene.setAdStyle(4);
            List<String> c2 = SplashPreloadManager.b().c();
            ksScene.setAdNum(1);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
            b bVar = new b();
            com.kwad.sdk.core.report.d.a();
            f64632a.postDelayed(new Runnable(this, ksScene) { // from class: com.kwad.sdk.core.g.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsScene f64633a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f64634b;

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
                    this.f64634b = this;
                    this.f64633a = ksScene;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64634b.a(this.f64633a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(this, bVar, splashScreenAdListener) { // from class: com.kwad.sdk.core.g.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f64635a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f64636b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f64637c;

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
                    this.f64637c = this;
                    this.f64635a = bVar;
                    this.f64636b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64635a.f64737a = true;
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.f64636b;
                        f fVar = f.f64807g;
                        splashScreenAdListener2.onError(fVar.m, fVar.n);
                        com.kwad.sdk.core.report.d.a(4);
                    }
                }
            };
            f64632a.postDelayed(runnable, com.kwad.sdk.core.config.c.l());
            a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, a2, a(ksScene, false), new a(this, bVar, runnable, splashScreenAdListener, ksScene) { // from class: com.kwad.sdk.core.g.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f64638a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Runnable f64639b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f64640c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ KsScene f64641d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d f64642e;

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
                    this.f64642e = this;
                    this.f64638a = bVar;
                    this.f64639b = runnable;
                    this.f64640c = splashScreenAdListener;
                    this.f64641d = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (!this.f64638a.f64737a) {
                            d.f64632a.removeCallbacks(this.f64639b);
                            d.f64632a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ int f64643a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f64644b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f64645c;

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
                                    this.f64645c = this;
                                    this.f64643a = i2;
                                    this.f64644b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f64643a), this.f64644b));
                                        this.f64645c.f64640c.onError(this.f64643a, this.f64644b);
                                        if (this.f64643a == f.f64808h.m) {
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

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        if (adResultData.adTemplateList.size() > 0) {
                            com.kwad.sdk.splashscreen.b bVar2 = new com.kwad.sdk.splashscreen.b(this.f64641d, adResultData);
                            d.f64632a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f64646a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f64647b;

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
                                    this.f64647b = this;
                                    this.f64646a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            this.f64647b.f64640c.onRequestResult(this.f64646a.adTemplateList.size());
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.d.a.b(th);
                                        }
                                    }
                                }
                            });
                            boolean a3 = SplashPreloadManager.b().a(adResultData);
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a3);
                            if (a3) {
                                if (this.f64638a.f64737a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f64632a.removeCallbacks(this.f64639b);
                                d.f64632a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ KsSplashScreenAd f64648a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass11 f64649b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, bVar2};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f64649b = this;
                                        this.f64648a = bVar2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f64649b.f64640c.onSplashScreenAdLoad(this.f64648a);
                                        }
                                    }
                                });
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                                com.kwad.sdk.core.report.d.a(1);
                                return;
                            } else if (SplashPreloadManager.b().b(adResultData)) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                                int a4 = SplashPreloadManager.b().a(adResultData, true);
                                if (this.f64638a.f64737a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f64632a.removeCallbacks(this.f64639b);
                                if (a4 > 0) {
                                    d.f64632a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ KsSplashScreenAd f64650a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass11 f64651b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, bVar2};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f64651b = this;
                                            this.f64650a = bVar2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f64651b.f64640c.onSplashScreenAdLoad(this.f64650a);
                                            }
                                        }
                                    });
                                    com.kwad.sdk.core.report.d.a(2);
                                    return;
                                }
                                f fVar = f.f64808h;
                                a(fVar.m, fVar.n);
                                return;
                            } else if (this.f64638a.f64737a) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                return;
                            } else {
                                d.f64632a.removeCallbacks(this.f64639b);
                                a(f.f64806f.m, "请求成功，但缓存未命中");
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                            }
                        } else if (this.f64638a.f64737a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        } else {
                            d.f64632a.removeCallbacks(this.f64639b);
                            f fVar2 = f.f64805e;
                            a(fVar2.m, fVar2.n);
                        }
                        com.kwad.sdk.core.report.d.a(3);
                    }
                }
            });
        }
    }
}
