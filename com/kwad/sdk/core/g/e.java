package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements KsLoadManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36168a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.g.e$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f36212a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f36213b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f36214c;

        public AnonymousClass2(e eVar, KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, feedAdListener, ksScene};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36214c = eVar;
            this.f36212a = feedAdListener;
            this.f36213b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.e.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f36215a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f36216b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f36217c;

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
                        this.f36217c = this;
                        this.f36215a = i2;
                        this.f36216b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36215a), this.f36216b));
                            this.f36217c.f36212a.onError(this.f36215a, this.f36216b);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.g.e.a
        public void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                ArrayList arrayList = new ArrayList();
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onSuccess:" + adResultData.adTemplateList.size());
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f36213b.getWidth(), true));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.L(j)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onSuccess:" + arrayList.size());
                if (!arrayList.isEmpty()) {
                    e.f36168a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.e.2.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f36218a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f36219b;

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
                            this.f36219b = this;
                            this.f36218a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.f36218a.size();
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "mHandler " + size);
                                if (size == 0) {
                                    this.f36219b.f36212a.onFeedAdLoad(this.f36218a);
                                    return;
                                }
                                b.a aVar = new b.a(size);
                                for (KsFeedAd ksFeedAd : this.f36218a) {
                                    com.kwad.sdk.feed.b bVar = (com.kwad.sdk.feed.b) ksFeedAd;
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "ksFeedAd " + ksFeedAd);
                                    bVar.a(new b.InterfaceC0451b(this, bVar, aVar) { // from class: com.kwad.sdk.core.g.e.2.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ com.kwad.sdk.feed.b f36220a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ b.a f36221b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ RunnableC04312 f36222c;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, bVar, aVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f36222c = this;
                                            this.f36220a = bVar;
                                            this.f36221b = aVar;
                                        }

                                        @Override // com.kwad.sdk.feed.b.InterfaceC0451b
                                        public void a() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                com.kwad.sdk.core.d.a.a("AdRequestManager", "ksFeedAd onLoadFinished" + this.f36220a + " cnt: " + this.f36221b.a());
                                                if (this.f36221b.b()) {
                                                    RunnableC04312 runnableC04312 = this.f36222c;
                                                    runnableC04312.f36219b.f36212a.onFeedAdLoad(runnableC04312.f36218a);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                a(i2, com.kwad.sdk.core.network.f.f36360c.l + str);
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError");
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f36252a;

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
            this.f36252a = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890041619, "Lcom/kwad/sdk/core/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890041619, "Lcom/kwad/sdk/core/g/e;");
                return;
            }
        }
        f36168a = new Handler(Looper.getMainLooper());
    }

    public e() {
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

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fVar, aVar) == null) {
            a(fVar, null, false, aVar);
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, List<String> list, boolean z, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{fVar, list, Boolean.valueOf(z), aVar}) == null) {
            new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.a, AdResultData>(fVar, list, z) { // from class: com.kwad.sdk.core.g.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.g.a.f f36230a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f36231b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f36232c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, list, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36230a = fVar;
                    this.f36231b = list;
                    this.f36232c = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.f36230a.f36138a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public com.kwad.sdk.core.g.a b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new com.kwad.sdk.core.g.a(this.f36230a, this.f36231b, this.f36232c, null) : (com.kwad.sdk.core.g.a) invokeV.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.a, AdResultData>(aVar) { // from class: com.kwad.sdk.core.g.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36233a;

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
                    this.f36233a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, aVar2, i2, str) == null) {
                        this.f36233a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            this.f36233a.a(adResultData);
                            return;
                        }
                        a aVar3 = this.f36233a;
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36360c;
                        aVar3.a(fVar2.k, fVar2.l);
                    }
                }
            });
        }
    }

    public static void b(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, adResultData, j) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
                return;
            }
            com.kwad.sdk.core.report.e.d(adTemplate, elapsedRealtime - j);
        }
    }

    public void a(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksScene) == null) {
            com.kwad.sdk.core.report.e.c();
            ksScene.setAdStyle(4);
            ksScene.setAdNum(5);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
            a(new com.kwad.sdk.core.g.a.f(ksScene), new ArrayList(), false, new a(this) { // from class: com.kwad.sdk.core.g.e.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f36251a;

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
                    this.f36251a = this;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) || adResultData.adTemplateList.size() <= 0) {
                        return;
                    }
                    int a2 = SplashPreloadManager.b().a(adResultData, false);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onSuccess:" + adResultData.adTemplateList.size() + " saved " + a2);
                    com.kwad.sdk.core.report.e.b(adResultData.adTemplateList.size());
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene, feedAdListener) == null) {
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new AnonymousClass2(this, feedAdListener, ksScene));
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksScene)) == null) {
            if (ksScene == null) {
                return null;
            }
            return new com.kwad.sdk.contentalliance.e(ksScene);
        }
        return (KsContentAllianceAd) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPage(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ksScene)) == null) {
            if (ksScene == null) {
                return null;
            }
            return new com.kwad.sdk.contentalliance.f(ksScene);
        }
        return (KsContentPage) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ksScene, str)) == null) {
            if (ksScene == null) {
                return null;
            }
            com.kwad.sdk.contentalliance.f fVar = new com.kwad.sdk.contentalliance.f(ksScene);
            com.kwad.sdk.core.report.e.a(str);
            fVar.a(str);
            return fVar;
        }
        return (KsContentPage) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ksScene, drawAdListener) == null) {
            ksScene.setAdStyle(6);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, drawAdListener) { // from class: com.kwad.sdk.core.g.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.DrawAdListener f36223a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f36224b;

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
                    this.f36224b = this;
                    this.f36223a = drawAdListener;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36225a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36226b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f36227c;

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
                                this.f36227c = this;
                                this.f36225a = i2;
                                this.f36226b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36225a), this.f36226b));
                                    this.f36227c.f36223a.onError(this.f36225a, this.f36226b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)))) {
                                arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            e.f36168a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.e.3.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f36228a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f36229b;

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
                                    this.f36229b = this;
                                    this.f36228a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f36229b.f36223a.onDrawAdLoad(this.f36228a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i2, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, @NonNull KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ksScene, entryElementListener) == null) {
            loadEntryElement(ksScene, entryElementListener, false);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, @NonNull KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, ksScene, entryElementListener, z) == null) {
            h.a aVar = new h.a();
            aVar.f36273a.add(new com.kwad.sdk.core.g.a.f(ksScene));
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f36123a = 1;
            cVar.f36124b = z ? 1 : 0;
            aVar.f36274b = cVar;
            i.a(aVar, new a(this, entryElementListener, aVar) { // from class: com.kwad.sdk.core.g.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.EntryElementListener f36169a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h.a f36170b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f36171c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, entryElementListener, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36171c = this;
                    this.f36169a = entryElementListener;
                    this.f36170b = aVar;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36172a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36173b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f36174c;

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
                                this.f36174c = this;
                                this.f36172a = i2;
                                this.f36173b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadEntryElement onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36172a), this.f36173b));
                                    this.f36174c.f36169a.onError(this.f36172a, this.f36173b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) || adResultData.entryInfo == null) {
                        return;
                    }
                    com.kwad.sdk.entry.a aVar2 = new com.kwad.sdk.entry.a();
                    aVar2.a(this.f36170b);
                    e.f36168a.post(new Runnable(this, aVar2, adResultData) { // from class: com.kwad.sdk.core.g.e.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ com.kwad.sdk.entry.a f36175a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AdResultData f36176b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f36177c;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar2, adResultData};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36177c = this;
                            this.f36175a = aVar2;
                            this.f36176b = adResultData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f36175a.a(this.f36176b.entryInfo);
                                this.f36177c.f36169a.onEntryLoad(this.f36175a);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksScene, feedAdListener) == null) {
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, feedAdListener) { // from class: com.kwad.sdk.core.g.e.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.FeedAdListener f36205a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f36206b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, feedAdListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36206b = this;
                    this.f36205a = feedAdListener;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.13.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36207a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36208b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass13 f36209c;

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
                                this.f36209c = this;
                                this.f36207a = i2;
                                this.f36208b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36207a), this.f36208b));
                                    this.f36209c.f36205a.onError(this.f36207a, this.f36208b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        String str = null;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                                if (FeedType.checkTypeValid(adTemplate)) {
                                    arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                                } else {
                                    str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.L(j)), FeedType.fromInt(adTemplate.type));
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            e.f36168a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.e.13.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ List f36210a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f36211b;

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
                                    this.f36211b = this;
                                    this.f36210a = arrayList;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f36211b.f36205a.onFeedAdLoad(this.f36210a);
                                    }
                                }
                            });
                            return;
                        }
                        int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i2, com.kwad.sdk.core.network.f.f36360c.l + str);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsFeedPage loadFeedPage(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ksScene)) == null) {
            if (ksScene == null) {
                return null;
            }
            return new com.kwad.sdk.feed.a.e(ksScene);
        }
        return (KsFeedPage) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, ksScene, fullScreenVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(3);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, fullScreenVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.g.e.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.FullScreenVideoAdListener f36178a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f36179b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f36180c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f36181d;

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
                    this.f36181d = this;
                    this.f36178a = fullScreenVideoAdListener;
                    this.f36179b = ksScene;
                    this.f36180c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.10.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36182a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36183b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass10 f36184c;

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
                                this.f36184c = this;
                                this.f36182a = i2;
                                this.f36183b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36182a), this.f36183b));
                                    this.f36184c.f36178a.onError(this.f36182a, this.f36183b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        int ae = com.kwad.sdk.core.config.c.ae();
                        boolean z = false;
                        boolean z2 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f36179b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
                                if (!TextUtils.isEmpty(a2)) {
                                    if (ae >= 0) {
                                        if (ae > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, ae * 1024)) {
                                            z = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else if (com.kwad.sdk.reward.f.a(adTemplate)) {
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
                                e.f36168a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.e.10.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ List f36185a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f36186b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass10 f36187c;

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
                                        this.f36187c = this;
                                        this.f36185a = arrayList;
                                        this.f36186b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f36187c.f36178a.onFullScreenVideoAdLoad(this.f36185a);
                                            e.b(this.f36186b, this.f36187c.f36180c);
                                        }
                                    }
                                });
                                return;
                            }
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36361d;
                            a(fVar.k, fVar.l);
                            return;
                        }
                        int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i2, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ksScene, nativeAdListener) == null) {
            ksScene.setAdStyle(1);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, nativeAdListener) { // from class: com.kwad.sdk.core.g.e.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.NativeAdListener f36198a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f36199b;

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
                    this.f36199b = this;
                    this.f36198a = nativeAdListener;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.12.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36200a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36201b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass12 f36202c;

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
                                this.f36202c = this;
                                this.f36200a = i2;
                                this.f36201b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36200a), this.f36201b));
                                    this.f36202c.f36198a.onError(this.f36200a, this.f36201b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                arrayList.add(new com.kwad.sdk.a.a(adTemplate));
                            }
                        }
                        e.f36168a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.e.12.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f36203a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass12 f36204b;

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
                                this.f36204b = this;
                                this.f36203a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f36204b.f36198a.onNativeAdLoad(this.f36203a);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, ksScene, rewardVideoAdListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ksScene.setAdStyle(2);
            a(new com.kwad.sdk.core.g.a.f(ksScene), new a(this, rewardVideoAdListener, ksScene, elapsedRealtime) { // from class: com.kwad.sdk.core.g.e.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.RewardVideoAdListener f36188a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsScene f36189b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f36190c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f36191d;

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
                    this.f36191d = this;
                    this.f36188a = rewardVideoAdListener;
                    this.f36189b = ksScene;
                    this.f36190c = elapsedRealtime;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.11.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36192a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36193b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass11 f36194c;

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
                                this.f36194c = this;
                                this.f36192a = i2;
                                this.f36193b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36192a), this.f36193b));
                                    this.f36194c.f36188a.onError(this.f36192a, this.f36193b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        ArrayList arrayList = new ArrayList();
                        int ae = com.kwad.sdk.core.config.c.ae();
                        boolean z = false;
                        boolean z2 = false;
                        for (AdTemplate adTemplate : adResultData.adTemplateList) {
                            if (adTemplate != null) {
                                if (adTemplate.mAdScene == null) {
                                    KsScene ksScene2 = this.f36189b;
                                    if (ksScene2 instanceof SceneImpl) {
                                        adTemplate.mAdScene = (SceneImpl) ksScene2;
                                    }
                                }
                                String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
                                if (!TextUtils.isEmpty(a2)) {
                                    if (ae >= 0) {
                                        if (ae > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, ae * 1024)) {
                                            z = true;
                                        }
                                        arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                        z = true;
                                        z2 = true;
                                    } else if (com.kwad.sdk.reward.f.a(adTemplate)) {
                                        arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
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
                                e.f36168a.post(new Runnable(this, arrayList, adResultData) { // from class: com.kwad.sdk.core.g.e.11.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ List f36195a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AdResultData f36196b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass11 f36197c;

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
                                        this.f36197c = this;
                                        this.f36195a = arrayList;
                                        this.f36196b = adResultData;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f36197c.f36188a.onRewardVideoAdLoad(this.f36195a);
                                            e.b(this.f36196b, this.f36197c.f36190c);
                                        }
                                    }
                                });
                                return;
                            }
                            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36361d;
                            a(fVar.k, fVar.l);
                            return;
                        }
                        int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i2, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, ksScene, splashScreenAdListener) == null) {
            ksScene.setAdStyle(4);
            List<String> c2 = SplashPreloadManager.b().c();
            ksScene.setAdNum(c2.size() > 0 ? 1 : 5);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
            b bVar = new b();
            com.kwad.sdk.core.report.e.b();
            f36168a.postDelayed(new Runnable(this, ksScene) { // from class: com.kwad.sdk.core.g.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ KsScene f36234a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f36235b;

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
                    this.f36235b = this;
                    this.f36234a = ksScene;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36235b.a(this.f36234a);
                    }
                }
            }, 15000L);
            Runnable runnable = new Runnable(this, bVar, splashScreenAdListener) { // from class: com.kwad.sdk.core.g.e.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36236a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f36237b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f36238c;

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
                    this.f36238c = this;
                    this.f36236a = bVar;
                    this.f36237b = splashScreenAdListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36236a.f36252a = true;
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                        KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = this.f36237b;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36362e;
                        splashScreenAdListener2.onError(fVar.k, fVar.l);
                        com.kwad.sdk.core.report.e.a(4);
                    }
                }
            };
            f36168a.postDelayed(runnable, com.kwad.sdk.core.config.c.s());
            a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, new a(this, bVar, runnable, splashScreenAdListener, ksScene) { // from class: com.kwad.sdk.core.g.e.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36239a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Runnable f36240b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ KsLoadManager.SplashScreenAdListener f36241c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ KsScene f36242d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ e f36243e;

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
                    this.f36243e = this;
                    this.f36239a = bVar;
                    this.f36240b = runnable;
                    this.f36241c = splashScreenAdListener;
                    this.f36242d = ksScene;
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (!this.f36239a.f36252a) {
                            e.f36168a.removeCallbacks(this.f36240b);
                            e.f36168a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.e.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ int f36244a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f36245b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f36246c;

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
                                    this.f36246c = this;
                                    this.f36244a = i2;
                                    this.f36245b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36244a), this.f36245b));
                                        this.f36246c.f36241c.onError(this.f36244a, this.f36245b);
                                        if (this.f36244a == com.kwad.sdk.core.network.f.f36363f.k) {
                                            com.kwad.sdk.core.report.e.a(0);
                                        } else {
                                            com.kwad.sdk.core.report.e.a(3);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    }
                }

                @Override // com.kwad.sdk.core.g.e.a
                public void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                        if (adResultData.adTemplateList.size() > 0) {
                            com.kwad.sdk.splashscreen.a aVar = new com.kwad.sdk.splashscreen.a(this.f36242d, adResultData);
                            boolean a2 = SplashPreloadManager.b().a(adResultData);
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a2);
                            if (a2) {
                                if (this.f36239a.f36252a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                e.f36168a.removeCallbacks(this.f36240b);
                                e.f36168a.post(new Runnable(this, aVar) { // from class: com.kwad.sdk.core.g.e.8.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ KsSplashScreenAd f36247a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass8 f36248b;

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
                                        this.f36248b = this;
                                        this.f36247a = aVar;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f36248b.f36241c.onSplashScreenAdLoad(this.f36247a);
                                        }
                                    }
                                });
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                                com.kwad.sdk.core.report.e.a(1);
                                return;
                            } else if (SplashPreloadManager.b().b(adResultData)) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                                int a3 = SplashPreloadManager.b().a(adResultData, true);
                                if (this.f36239a.f36252a) {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                e.f36168a.removeCallbacks(this.f36240b);
                                if (a3 > 0) {
                                    e.f36168a.post(new Runnable(this, aVar) { // from class: com.kwad.sdk.core.g.e.8.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ KsSplashScreenAd f36249a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass8 f36250b;

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
                                            this.f36250b = this;
                                            this.f36249a = aVar;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f36250b.f36241c.onSplashScreenAdLoad(this.f36249a);
                                            }
                                        }
                                    });
                                    com.kwad.sdk.core.report.e.a(2);
                                    return;
                                }
                                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36363f;
                                a(fVar.k, fVar.l);
                                return;
                            } else if (this.f36239a.f36252a) {
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                                return;
                            } else {
                                e.f36168a.removeCallbacks(this.f36240b);
                                a(com.kwad.sdk.core.network.f.f36361d.k, "请求成功，但缓存未命中");
                                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                            }
                        } else if (this.f36239a.f36252a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        } else {
                            e.f36168a.removeCallbacks(this.f36240b);
                            com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36360c;
                            a(fVar2.k, fVar2.l);
                        }
                        com.kwad.sdk.core.report.e.a(3);
                    }
                }
            });
        }
    }
}
