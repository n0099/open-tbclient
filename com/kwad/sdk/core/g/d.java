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
    public static final Handler f65544a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.g.d$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f65614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f65615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f65616c;

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
            this.f65616c = dVar;
            this.f65614a = feedAdListener;
            this.f65615b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f65617a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f65618b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass5 f65619c;

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
                        this.f65619c = this;
                        this.f65617a = i2;
                        this.f65618b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65617a), this.f65618b));
                            this.f65619c.f65614a.onError(this.f65617a, this.f65618b);
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
                            KsScene ksScene = this.f65615b;
                            if (ksScene instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene;
                            }
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f65615b.getWidth(), true));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(i2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.f65544a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.5.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f65620a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f65621b;

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
                            this.f65621b = this;
                            this.f65620a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.f65620a.size();
                                if (size == 0) {
                                    this.f65621b.f65614a.onFeedAdLoad(this.f65620a);
                                    return;
                                }
                                b.a aVar = new b.a(size);
                                for (KsFeedAd ksFeedAd : this.f65620a) {
                                    ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC1964b(this, aVar) { // from class: com.kwad.sdk.core.g.d.5.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ b.a f65622a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass2 f65623b;

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
                                            this.f65623b = this;
                                            this.f65622a = aVar;
                                        }

                                        @Override // com.kwad.sdk.feed.b.InterfaceC1964b
                                        public void a() {
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.f65622a.a()) {
                                                AnonymousClass2 anonymousClass2 = this.f65623b;
                                                anonymousClass2.f65621b.f65614a.onFeedAdLoad(anonymousClass2.f65620a);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i3 = f.f65717e.m;
                a(i3, f.f65717e.n + str);
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
        public volatile boolean f65649a;

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
            this.f65649a = false;
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
        f65544a = new Handler(Looper.getMainLooper());
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
                kVar.f65534a = r0;
            }
            return kVar;
        }
        return (k) invokeLZ.objValue;
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar, aVar, z) == null) {
            a(fVar, null, false, z, a((KsScene) fVar.f65511a, false), aVar);
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, List<String> list, boolean z, boolean z2, @Nullable k kVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{fVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), kVar, aVar}) == null) {
            new i<com.kwad.sdk.core.g.a, AdResultData>(fVar, list, z, kVar, z2) { // from class: com.kwad.sdk.core.g.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.f f65643a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f65644b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f65645c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f65646d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f65647e;

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
                    this.f65643a = fVar;
                    this.f65644b = list;
                    this.f65645c = z;
                    this.f65646d = kVar;
                    this.f65647e = z2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.core.g.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.core.g.a aVar2 = new com.kwad.sdk.core.g.a(this.f65643a, this.f65644b, this.f65645c, null, this.f65646d);
                        aVar2.a(this.f65647e ? 1 : 0);
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
                        AdResultData adResultData = new AdResultData(this.f65643a.f65511a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            }.a(new j<com.kwad.sdk.core.g.a, AdResultData>(aVar) { // from class: com.kwad.sdk.core.g.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65648a;

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
                    this.f65648a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar2, i2, str) == null) {
                        this.f65648a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.f65648a.a(adResultData);
                            return;
                        }
                        a aVar3 = this.f65648a;
                        f fVar2 = f.f65717e;
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
                f65544a.post(runnable);
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
                public final /* synthetic */ d f65564a;

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
                    this.f65564a = this;
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
                public final /* synthetic */ KsLoadManager.DrawAdListener f65624a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f65625b;

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
                    this.f65625b = this;
                    this.f65624a = drawAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65626a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65627b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f65628c;

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
                                this.f65628c = this;
                                this.f65626a = i2;
                                this.f65627b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65626a), this.f65627b));
                                    this.f65628c.f65624a.onError(this.f65626a, this.f65627b);
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
                            d.f65544a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.6.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f65629a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass6 f65630b;

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
                                    this.f65630b = this;
                                    this.f65629a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f65630b.f65624a.onDrawAdLoad(this.f65629a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = f.f65717e.m;
                        a(i2, f.f65717e.n + "(无视频资源)");
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
                public final /* synthetic */ KsLoadManager.FeedAdListener f65606a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f65607b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f65608c;

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
                    this.f65608c = this;
                    this.f65606a = feedAdListener;
                    this.f65607b = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65609a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65610b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f65611c;

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
                                this.f65611c = this;
                                this.f65609a = i2;
                                this.f65610b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65609a), this.f65610b));
                                    this.f65611c.f65606a.onError(this.f65609a, this.f65610b);
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
                                    KsScene ksScene2 = this.f65607b;
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
                            d.f65544a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f65612a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f65613b;

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
                                    this.f65613b = this;
                                    this.f65612a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f65613b.f65606a.onFeedAdLoad(this.f65612a);
                                    }
                                }
                            });
                            return;
                        }
                        int i3 = f.f65717e.m;
                        a(i3, f.f65717e.n + str);
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
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener f65565a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f65566b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f65567c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f65568d;

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
                    this.f65568d = this;
                    this.f65565a = fullScreenVideoAdListener;
                    this.f65566b = ksScene;
                    this.f65567c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65569a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65570b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f65571c;

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
                                this.f65571c = this;
                                this.f65569a = i2;
                                this.f65570b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65569a), this.f65570b));
                                    this.f65571c.f65565a.onError(this.f65569a, this.f65570b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f65544a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.13.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f65572a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f65573b;

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
                                this.f65573b = this;
                                this.f65572a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f65573b.f65565a.onRequestResult(this.f65572a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f65566b;
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
                                d.f65544a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.13.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ List f65574a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f65575b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass13 f65576c;

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
                                        this.f65576c = this;
                                        this.f65574a = arrayList;
                                        this.f65575b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f65576c.f65565a.onFullScreenVideoAdLoad(this.f65574a);
                                            d.b(this.f65575b, this.f65576c.f65567c);
                                            try {
                                                d.b(this.f65575b);
                                            } catch (Throwable th) {
                                                com.kwad.sdk.core.d.a.a(th);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            f fVar = f.f65718f;
                            a(fVar.m, fVar.n);
                            return;
                        }
                        int i2 = f.f65717e.m;
                        a(i2, f.f65717e.n + "(无视频资源)");
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
                public final /* synthetic */ KsLoadManager.InterstitialAdListener f65631a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f65632b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f65633c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f65634d;

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
                    this.f65634d = this;
                    this.f65631a = interstitialAdListener;
                    this.f65632b = ksScene;
                    this.f65633c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65635a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65636b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f65637c;

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
                                this.f65637c = this;
                                this.f65635a = i2;
                                this.f65636b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65635a), this.f65636b));
                                    this.f65637c.f65631a.onError(this.f65635a, this.f65636b);
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
                        d.f65544a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.7.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f65638a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f65639b;

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
                                this.f65639b = this;
                                this.f65638a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f65639b.f65631a.onRequestResult(this.f65638a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f65632b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate));
                                if (TextUtils.isEmpty(a3)) {
                                    aVar = new com.kwad.sdk.a.a(this.f65632b, adTemplate);
                                } else if (C >= 0) {
                                    if (C > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    }
                                    aVar = new com.kwad.sdk.a.a(this.f65632b, adTemplate);
                                } else if (g.a(adTemplate)) {
                                    aVar = new com.kwad.sdk.a.a(this.f65632b, adTemplate);
                                }
                                arrayList.add(aVar);
                            }
                        }
                        if (arrayList.size() != 0) {
                            d.f65544a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.7.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f65640a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f65641b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass7 f65642c;

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
                                    this.f65642c = this;
                                    this.f65640a = arrayList;
                                    this.f65641b = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f65642c.f65631a.onInterstitialAdLoad(this.f65640a);
                                        d.b(this.f65641b, this.f65642c.f65633c);
                                    }
                                }
                            });
                            return;
                        }
                        f fVar = f.f65717e;
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
                public final /* synthetic */ KsLoadManager.NativeAdListener f65589a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f65590b;

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
                    this.f65590b = this;
                    this.f65589a = nativeAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65591a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65592b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f65593c;

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
                                this.f65593c = this;
                                this.f65591a = i2;
                                this.f65592b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65591a), this.f65592b));
                                    this.f65593c.f65589a.onError(this.f65591a, this.f65592b);
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
                        d.f65544a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.15.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f65594a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f65595b;

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
                                this.f65595b = this;
                                this.f65594a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f65595b.f65589a.onNativeAdLoad(this.f65594a);
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
                    public final /* synthetic */ KsLoadManager.NativeAdListener f65596a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f65597b;

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
                        this.f65597b = this;
                        this.f65596a = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.f65596a;
                            f fVar = f.f65717e;
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
                        public final /* synthetic */ AdResultData f65598a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f65599b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f65600c;

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
                            this.f65600c = this;
                            this.f65598a = adResultData;
                            this.f65599b = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.f65598a.result), this.f65598a.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f65599b;
                                AdResultData adResultData2 = this.f65598a;
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
                        public final /* synthetic */ KsLoadManager.NativeAdListener f65601a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f65602b;

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
                            this.f65602b = this;
                            this.f65601a = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f65601a;
                                f fVar = f.f65717e;
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
                        public final /* synthetic */ KsLoadManager.NativeAdListener f65603a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ List f65604b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f65605c;

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
                            this.f65605c = this;
                            this.f65603a = nativeAdListener;
                            this.f65604b = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f65603a.onNativeAdLoad(this.f65604b);
                            }
                        }
                    };
                }
                a(runnable);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                f fVar = f.f65716d;
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
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener f65577a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f65578b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f65579c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f65580d;

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
                    this.f65580d = this;
                    this.f65577a = rewardVideoAdListener;
                    this.f65578b = ksScene;
                    this.f65579c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f65581a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f65582b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f65583c;

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
                                this.f65583c = this;
                                this.f65581a = i2;
                                this.f65582b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65581a), this.f65582b));
                                    this.f65583c.f65577a.onError(this.f65581a, this.f65582b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f65544a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.14.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f65584a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f65585b;

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
                                this.f65585b = this;
                                this.f65584a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f65585b.f65577a.onRequestResult(this.f65584a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f65578b;
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
                                int i3 = f.f65717e.m;
                                a(i3, f.f65717e.n + "(无视频资源)");
                                return;
                            } else if (!z3) {
                                f fVar = f.f65718f;
                                a(fVar.m, fVar.n);
                                return;
                            }
                        }
                        d.f65544a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.14.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f65586a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f65587b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f65588c;

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
                                this.f65588c = this;
                                this.f65586a = arrayList;
                                this.f65587b = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f65588c.f65577a.onRewardVideoAdLoad(this.f65586a);
                                    d.b(this.f65587b, this.f65588c.f65579c);
                                    try {
                                        d.b(this.f65587b);
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
            f65544a.postDelayed(new Runnable(this, ksScene) { // from class: com.kwad.sdk.core.g.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsScene f65545a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f65546b;

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
                    this.f65546b = this;
                    this.f65545a = ksScene;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65546b.a(this.f65545a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(this, bVar, splashScreenAdListener) { // from class: com.kwad.sdk.core.g.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65547a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f65548b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f65549c;

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
                    this.f65549c = this;
                    this.f65547a = bVar;
                    this.f65548b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65547a.f65649a = true;
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.f65548b;
                        f fVar = f.f65719g;
                        splashScreenAdListener2.onError(fVar.m, fVar.n);
                        com.kwad.sdk.core.report.d.a(4);
                    }
                }
            };
            f65544a.postDelayed(runnable, com.kwad.sdk.core.config.c.l());
            a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, a2, a(ksScene, false), new a(this, bVar, runnable, splashScreenAdListener, ksScene) { // from class: com.kwad.sdk.core.g.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65550a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Runnable f65551b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f65552c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ KsScene f65553d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d f65554e;

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
                    this.f65554e = this;
                    this.f65550a = bVar;
                    this.f65551b = runnable;
                    this.f65552c = splashScreenAdListener;
                    this.f65553d = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (!this.f65550a.f65649a) {
                            d.f65544a.removeCallbacks(this.f65551b);
                            d.f65544a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ int f65555a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f65556b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f65557c;

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
                                    this.f65557c = this;
                                    this.f65555a = i2;
                                    this.f65556b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f65555a), this.f65556b));
                                        this.f65557c.f65552c.onError(this.f65555a, this.f65556b);
                                        if (this.f65555a == f.f65720h.m) {
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
                            com.kwad.sdk.splashscreen.b bVar2 = new com.kwad.sdk.splashscreen.b(this.f65553d, adResultData);
                            d.f65544a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f65558a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f65559b;

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
                                    this.f65559b = this;
                                    this.f65558a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            this.f65559b.f65552c.onRequestResult(this.f65558a.adTemplateList.size());
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.d.a.b(th);
                                        }
                                    }
                                }
                            });
                            boolean a3 = SplashPreloadManager.b().a(adResultData);
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a3);
                            if (a3) {
                                if (this.f65550a.f65649a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f65544a.removeCallbacks(this.f65551b);
                                d.f65544a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ KsSplashScreenAd f65560a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass11 f65561b;

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
                                        this.f65561b = this;
                                        this.f65560a = bVar2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f65561b.f65552c.onSplashScreenAdLoad(this.f65560a);
                                        }
                                    }
                                });
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                                com.kwad.sdk.core.report.d.a(1);
                                return;
                            } else if (SplashPreloadManager.b().b(adResultData)) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                                int a4 = SplashPreloadManager.b().a(adResultData, true);
                                if (this.f65550a.f65649a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f65544a.removeCallbacks(this.f65551b);
                                if (a4 > 0) {
                                    d.f65544a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ KsSplashScreenAd f65562a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass11 f65563b;

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
                                            this.f65563b = this;
                                            this.f65562a = bVar2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f65563b.f65552c.onSplashScreenAdLoad(this.f65562a);
                                            }
                                        }
                                    });
                                    com.kwad.sdk.core.report.d.a(2);
                                    return;
                                }
                                f fVar = f.f65720h;
                                a(fVar.m, fVar.n);
                                return;
                            } else if (this.f65550a.f65649a) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                return;
                            } else {
                                d.f65544a.removeCallbacks(this.f65551b);
                                a(f.f65718f.m, "请求成功，但缓存未命中");
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                            }
                        } else if (this.f65550a.f65649a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        } else {
                            d.f65544a.removeCallbacks(this.f65551b);
                            f fVar2 = f.f65717e;
                            a(fVar2.m, fVar2.n);
                        }
                        com.kwad.sdk.core.report.d.a(3);
                    }
                }
            });
        }
    }
}
