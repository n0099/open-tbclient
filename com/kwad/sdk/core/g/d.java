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
/* loaded from: classes10.dex */
public class d implements KsLoadManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f71636a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.g.d$5  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass5 implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f71706a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f71707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f71708c;

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
            this.f71708c = dVar;
            this.f71706a = feedAdListener;
            this.f71707b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.5.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f71709a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f71710b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass5 f71711c;

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
                        this.f71711c = this;
                        this.f71709a = i2;
                        this.f71710b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71709a), this.f71710b));
                            this.f71711c.f71706a.onError(this.f71709a, this.f71710b);
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
                            KsScene ksScene = this.f71707b;
                            if (ksScene instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene;
                            }
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f71707b.getWidth(), true));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(i2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.f71636a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.5.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f71712a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f71713b;

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
                            this.f71713b = this;
                            this.f71712a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.f71712a.size();
                                if (size == 0) {
                                    this.f71713b.f71706a.onFeedAdLoad(this.f71712a);
                                    return;
                                }
                                b.a aVar = new b.a(size);
                                for (KsFeedAd ksFeedAd : this.f71712a) {
                                    ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC2008b(this, aVar) { // from class: com.kwad.sdk.core.g.d.5.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ b.a f71714a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass2 f71715b;

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
                                            this.f71715b = this;
                                            this.f71714a = aVar;
                                        }

                                        @Override // com.kwad.sdk.feed.b.InterfaceC2008b
                                        public void a() {
                                            Interceptable interceptable3 = $ic;
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.f71714a.a()) {
                                                AnonymousClass2 anonymousClass2 = this.f71715b;
                                                anonymousClass2.f71713b.f71706a.onFeedAdLoad(anonymousClass2.f71712a);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i3 = f.f71809e.m;
                a(i3, f.f71809e.n + str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f71741a;

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
            this.f71741a = false;
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
        f71636a = new Handler(Looper.getMainLooper());
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
                kVar.f71626a = r0;
            }
            return kVar;
        }
        return (k) invokeLZ.objValue;
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar, aVar, z) == null) {
            a(fVar, null, false, z, a((KsScene) fVar.f71602a, false), aVar);
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, List<String> list, boolean z, boolean z2, @Nullable k kVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{fVar, list, Boolean.valueOf(z), Boolean.valueOf(z2), kVar, aVar}) == null) {
            new i<com.kwad.sdk.core.g.a, AdResultData>(fVar, list, z, kVar, z2) { // from class: com.kwad.sdk.core.g.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.f f71735a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f71736b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f71737c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ k f71738d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f71739e;

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
                    this.f71735a = fVar;
                    this.f71736b = list;
                    this.f71737c = z;
                    this.f71738d = kVar;
                    this.f71739e = z2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.core.g.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.sdk.core.g.a aVar2 = new com.kwad.sdk.core.g.a(this.f71735a, this.f71736b, this.f71737c, null, this.f71738d);
                        aVar2.a(this.f71739e ? 1 : 0);
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
                        AdResultData adResultData = new AdResultData(this.f71735a.f71602a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            }.a(new j<com.kwad.sdk.core.g.a, AdResultData>(aVar) { // from class: com.kwad.sdk.core.g.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f71740a;

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
                    this.f71740a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar2, i2, str) == null) {
                        this.f71740a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.f71740a.a(adResultData);
                            return;
                        }
                        a aVar3 = this.f71740a;
                        f fVar2 = f.f71809e;
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
                f71636a.post(runnable);
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

    public static void b(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, adResultData, j2) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
                return;
            }
            com.kwad.sdk.core.report.d.a(adTemplate, elapsedRealtime - j2);
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
                public final /* synthetic */ d f71656a;

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
                    this.f71656a = this;
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
                public final /* synthetic */ KsLoadManager.DrawAdListener f71716a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f71717b;

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
                    this.f71717b = this;
                    this.f71716a = drawAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71718a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71719b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f71720c;

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
                                this.f71720c = this;
                                this.f71718a = i2;
                                this.f71719b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71718a), this.f71719b));
                                    this.f71720c.f71716a.onError(this.f71718a, this.f71719b);
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
                            d.f71636a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.6.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f71721a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass6 f71722b;

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
                                    this.f71722b = this;
                                    this.f71721a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f71722b.f71716a.onDrawAdLoad(this.f71721a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = f.f71809e.m;
                        a(i2, f.f71809e.n + "(无视频资源)");
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
                public final /* synthetic */ KsLoadManager.FeedAdListener f71698a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f71699b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f71700c;

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
                    this.f71700c = this;
                    this.f71698a = feedAdListener;
                    this.f71699b = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71701a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71702b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f71703c;

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
                                this.f71703c = this;
                                this.f71701a = i2;
                                this.f71702b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71701a), this.f71702b));
                                    this.f71703c.f71698a.onError(this.f71701a, this.f71702b);
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
                                    KsScene ksScene2 = this.f71699b;
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
                            d.f71636a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f71704a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f71705b;

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
                                    this.f71705b = this;
                                    this.f71704a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f71705b.f71698a.onFeedAdLoad(this.f71704a);
                                    }
                                }
                            });
                            return;
                        }
                        int i3 = f.f71809e.m;
                        a(i3, f.f71809e.n + str);
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
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener f71657a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f71658b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f71659c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f71660d;

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
                    this.f71660d = this;
                    this.f71657a = fullScreenVideoAdListener;
                    this.f71658b = ksScene;
                    this.f71659c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71661a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71662b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f71663c;

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
                                this.f71663c = this;
                                this.f71661a = i2;
                                this.f71662b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71661a), this.f71662b));
                                    this.f71663c.f71657a.onError(this.f71661a, this.f71662b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f71636a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.13.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f71664a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f71665b;

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
                                this.f71665b = this;
                                this.f71664a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f71665b.f71657a.onRequestResult(this.f71664a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f71658b;
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
                                d.f71636a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.13.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ List f71666a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f71667b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass13 f71668c;

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
                                        this.f71668c = this;
                                        this.f71666a = arrayList;
                                        this.f71667b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f71668c.f71657a.onFullScreenVideoAdLoad(this.f71666a);
                                            d.b(this.f71667b, this.f71668c.f71659c);
                                            try {
                                                d.b(this.f71667b);
                                            } catch (Throwable th) {
                                                com.kwad.sdk.core.d.a.a(th);
                                            }
                                        }
                                    }
                                });
                                return;
                            }
                            f fVar = f.f71810f;
                            a(fVar.m, fVar.n);
                            return;
                        }
                        int i2 = f.f71809e.m;
                        a(i2, f.f71809e.n + "(无视频资源)");
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
                public final /* synthetic */ KsLoadManager.InterstitialAdListener f71723a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f71724b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f71725c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f71726d;

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
                    this.f71726d = this;
                    this.f71723a = interstitialAdListener;
                    this.f71724b = ksScene;
                    this.f71725c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71727a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71728b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f71729c;

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
                                this.f71729c = this;
                                this.f71727a = i2;
                                this.f71728b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71727a), this.f71728b));
                                    this.f71729c.f71723a.onError(this.f71727a, this.f71728b);
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
                        d.f71636a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.7.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f71730a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass7 f71731b;

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
                                this.f71731b = this;
                                this.f71730a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f71731b.f71723a.onRequestResult(this.f71730a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f71724b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a3 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate));
                                if (TextUtils.isEmpty(a3)) {
                                    aVar = new com.kwad.sdk.a.a(this.f71724b, adTemplate);
                                } else if (C >= 0) {
                                    if (C > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    }
                                    aVar = new com.kwad.sdk.a.a(this.f71724b, adTemplate);
                                } else if (g.a(adTemplate)) {
                                    aVar = new com.kwad.sdk.a.a(this.f71724b, adTemplate);
                                }
                                arrayList.add(aVar);
                            }
                        }
                        if (arrayList.size() != 0) {
                            d.f71636a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.7.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f71732a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f71733b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass7 f71734c;

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
                                    this.f71734c = this;
                                    this.f71732a = arrayList;
                                    this.f71733b = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f71734c.f71723a.onInterstitialAdLoad(this.f71732a);
                                        d.b(this.f71733b, this.f71734c.f71725c);
                                    }
                                }
                            });
                            return;
                        }
                        f fVar = f.f71809e;
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
                public final /* synthetic */ KsLoadManager.NativeAdListener f71681a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f71682b;

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
                    this.f71682b = this;
                    this.f71681a = nativeAdListener;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71683a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71684b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f71685c;

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
                                this.f71685c = this;
                                this.f71683a = i2;
                                this.f71684b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71683a), this.f71684b));
                                    this.f71685c.f71681a.onError(this.f71683a, this.f71684b);
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
                        d.f71636a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.d.15.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f71686a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f71687b;

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
                                this.f71687b = this;
                                this.f71686a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f71687b.f71681a.onNativeAdLoad(this.f71686a);
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
                    public final /* synthetic */ KsLoadManager.NativeAdListener f71688a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f71689b;

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
                        this.f71689b = this;
                        this.f71688a = nativeAdListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                            KsLoadManager.NativeAdListener nativeAdListener2 = this.f71688a;
                            f fVar = f.f71809e;
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
                        public final /* synthetic */ AdResultData f71690a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ KsLoadManager.NativeAdListener f71691b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f71692c;

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
                            this.f71692c = this;
                            this.f71690a = adResultData;
                            this.f71691b = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(this.f71690a.result), this.f71690a.errorMsg));
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f71691b;
                                AdResultData adResultData2 = this.f71690a;
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
                        public final /* synthetic */ KsLoadManager.NativeAdListener f71693a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f71694b;

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
                            this.f71694b = this;
                            this.f71693a = nativeAdListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                KsLoadManager.NativeAdListener nativeAdListener2 = this.f71693a;
                                f fVar = f.f71809e;
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
                        public final /* synthetic */ KsLoadManager.NativeAdListener f71695a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ List f71696b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f71697c;

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
                            this.f71697c = this;
                            this.f71695a = nativeAdListener;
                            this.f71696b = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f71695a.onNativeAdLoad(this.f71696b);
                            }
                        }
                    };
                }
                a(runnable);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                f fVar = f.f71808d;
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
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener f71669a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f71670b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f71671c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ d f71672d;

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
                    this.f71672d = this;
                    this.f71669a = rewardVideoAdListener;
                    this.f71670b = ksScene;
                    this.f71671c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.14.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f71673a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f71674b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f71675c;

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
                                this.f71675c = this;
                                this.f71673a = i2;
                                this.f71674b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71673a), this.f71674b));
                                    this.f71675c.f71669a.onError(this.f71673a, this.f71674b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        d.f71636a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.14.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f71676a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f71677b;

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
                                this.f71677b = this;
                                this.f71676a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        this.f71677b.f71669a.onRequestResult(this.f71676a.adTemplateList.size());
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
                                    KsScene ksScene2 = this.f71670b;
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
                                int i3 = f.f71809e.m;
                                a(i3, f.f71809e.n + "(无视频资源)");
                                return;
                            } else if (!z3) {
                                f fVar = f.f71810f;
                                a(fVar.m, fVar.n);
                                return;
                            }
                        }
                        d.f71636a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.d.14.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f71678a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f71679b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass14 f71680c;

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
                                this.f71680c = this;
                                this.f71678a = arrayList;
                                this.f71679b = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f71680c.f71669a.onRewardVideoAdLoad(this.f71678a);
                                    d.b(this.f71679b, this.f71680c.f71671c);
                                    try {
                                        d.b(this.f71679b);
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
            f71636a.postDelayed(new Runnable(this, ksScene) { // from class: com.kwad.sdk.core.g.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsScene f71637a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f71638b;

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
                    this.f71638b = this;
                    this.f71637a = ksScene;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71638b.a(this.f71637a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(this, bVar, splashScreenAdListener) { // from class: com.kwad.sdk.core.g.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71639a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f71640b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f71641c;

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
                    this.f71641c = this;
                    this.f71639a = bVar;
                    this.f71640b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71639a.f71741a = true;
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.f71640b;
                        f fVar = f.f71811g;
                        splashScreenAdListener2.onError(fVar.m, fVar.n);
                        com.kwad.sdk.core.report.d.a(4);
                    }
                }
            };
            f71636a.postDelayed(runnable, com.kwad.sdk.core.config.c.l());
            a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, a2, a(ksScene, false), new a(this, bVar, runnable, splashScreenAdListener, ksScene) { // from class: com.kwad.sdk.core.g.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f71642a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Runnable f71643b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f71644c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ KsScene f71645d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d f71646e;

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
                    this.f71646e = this;
                    this.f71642a = bVar;
                    this.f71643b = runnable;
                    this.f71644c = splashScreenAdListener;
                    this.f71645d = ksScene;
                }

                @Override // com.kwad.sdk.core.g.d.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (!this.f71642a.f71741a) {
                            d.f71636a.removeCallbacks(this.f71643b);
                            d.f71636a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.d.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ int f71647a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f71648b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f71649c;

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
                                    this.f71649c = this;
                                    this.f71647a = i2;
                                    this.f71648b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f71647a), this.f71648b));
                                        this.f71649c.f71644c.onError(this.f71647a, this.f71648b);
                                        if (this.f71647a == f.f71812h.m) {
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
                            com.kwad.sdk.splashscreen.b bVar2 = new com.kwad.sdk.splashscreen.b(this.f71645d, adResultData);
                            d.f71636a.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.core.g.d.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AdResultData f71650a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f71651b;

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
                                    this.f71651b = this;
                                    this.f71650a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            this.f71651b.f71644c.onRequestResult(this.f71650a.adTemplateList.size());
                                        } catch (Throwable th) {
                                            com.kwad.sdk.core.d.a.b(th);
                                        }
                                    }
                                }
                            });
                            boolean a3 = SplashPreloadManager.b().a(adResultData);
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a3);
                            if (a3) {
                                if (this.f71642a.f71741a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f71636a.removeCallbacks(this.f71643b);
                                d.f71636a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ KsSplashScreenAd f71652a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass11 f71653b;

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
                                        this.f71653b = this;
                                        this.f71652a = bVar2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f71653b.f71644c.onSplashScreenAdLoad(this.f71652a);
                                        }
                                    }
                                });
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                                com.kwad.sdk.core.report.d.a(1);
                                return;
                            } else if (SplashPreloadManager.b().b(adResultData)) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                                int a4 = SplashPreloadManager.b().a(adResultData, true);
                                if (this.f71642a.f71741a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                d.f71636a.removeCallbacks(this.f71643b);
                                if (a4 > 0) {
                                    d.f71636a.post(new Runnable(this, bVar2) { // from class: com.kwad.sdk.core.g.d.11.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ KsSplashScreenAd f71654a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass11 f71655b;

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
                                            this.f71655b = this;
                                            this.f71654a = bVar2;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f71655b.f71644c.onSplashScreenAdLoad(this.f71654a);
                                            }
                                        }
                                    });
                                    com.kwad.sdk.core.report.d.a(2);
                                    return;
                                }
                                f fVar = f.f71812h;
                                a(fVar.m, fVar.n);
                                return;
                            } else if (this.f71642a.f71741a) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                return;
                            } else {
                                d.f71636a.removeCallbacks(this.f71643b);
                                a(f.f71810f.m, "请求成功，但缓存未命中");
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                            }
                        } else if (this.f71642a.f71741a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        } else {
                            d.f71636a.removeCallbacks(this.f71643b);
                            f fVar2 = f.f71809e;
                            a(fVar2.m, fVar2.n);
                        }
                        com.kwad.sdk.core.report.d.a(3);
                    }
                }
            });
        }
    }
}
