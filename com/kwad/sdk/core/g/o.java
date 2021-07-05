package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendFeedResultData;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.response.model.TrendListResultData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36301a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f36302b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull TrendFeedResultData trendFeedResultData);
    }

    /* loaded from: classes7.dex */
    public interface b {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull TrendListResultData trendListResultData);
    }

    /* loaded from: classes7.dex */
    public interface c {
        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(@NonNull List<AdTemplate> list);
    }

    /* loaded from: classes7.dex */
    public interface d {
        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(@NonNull List<TrendInfo> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1890041929, "Lcom/kwad/sdk/core/g/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1890041929, "Lcom/kwad/sdk/core/g/o;");
                return;
            }
        }
        f36301a = new Handler(Looper.getMainLooper());
        f36302b = false;
    }

    public static void a(h.a aVar, @NonNull TrendInfo trendInfo, @NonNull a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, aVar, trendInfo, aVar2) == null) {
            new com.kwad.sdk.core.network.i<m, TrendFeedResultData>(aVar, trendInfo) { // from class: com.kwad.sdk.core.g.o.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h.a f36317a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TrendInfo f36318b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, trendInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36317a = aVar;
                    this.f36318b = trendInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public TrendFeedResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        TrendFeedResultData trendFeedResultData = new TrendFeedResultData(this.f36317a.f36273a.get(0).f36138a, this.f36318b);
                        trendFeedResultData.parseJson(jSONObject);
                        return trendFeedResultData;
                    }
                    return (TrendFeedResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public m b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new m(this.f36317a, this.f36318b.trendId) : (m) invokeV.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<m, TrendFeedResultData>(aVar2) { // from class: com.kwad.sdk.core.g.o.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36319a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36319a = aVar2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull m mVar, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, mVar, i2, str) == null) {
                        this.f36319a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull m mVar, @NonNull TrendFeedResultData trendFeedResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, trendFeedResultData) == null) {
                        this.f36319a.a(trendFeedResultData);
                    }
                }
            });
        }
    }

    public static void a(h.a aVar, @NonNull TrendInfo trendInfo, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, aVar, trendInfo, cVar) == null) {
            a(aVar, trendInfo, new a(cVar) { // from class: com.kwad.sdk.core.g.o.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f36311a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36311a = cVar;
                }

                @Override // com.kwad.sdk.core.g.o.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        o.f36301a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.o.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f36312a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f36313b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f36314c;

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
                                this.f36314c = this;
                                this.f36312a = i2;
                                this.f36313b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.d.a.d("TrendRequestManager", "loadFeedByTrendId onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36312a), this.f36313b));
                                    this.f36314c.f36311a.a(this.f36312a, this.f36313b);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.g.o.a
                public void a(@NonNull TrendFeedResultData trendFeedResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trendFeedResultData) == null) {
                        if (trendFeedResultData.result != 1) {
                            int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                            a(i2, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                        } else if (!trendFeedResultData.adTemplateList.isEmpty()) {
                            o.f36301a.post(new Runnable(this, trendFeedResultData) { // from class: com.kwad.sdk.core.g.o.4.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ TrendFeedResultData f36315a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f36316b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, trendFeedResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f36316b = this;
                                    this.f36315a = trendFeedResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f36316b.f36311a.a(this.f36315a.adTemplateList);
                                    }
                                }
                            });
                        } else {
                            int i3 = com.kwad.sdk.core.network.f.f36360c.k;
                            a(i3, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                        }
                    }
                }
            });
        }
    }

    public static void a(boolean z, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65540, null, z, bVar) == null) {
            new com.kwad.sdk.core.network.i<n, TrendListResultData>(z) { // from class: com.kwad.sdk.core.g.o.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f36309a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36309a = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public TrendListResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        TrendListResultData trendListResultData = new TrendListResultData();
                        trendListResultData.parseJson(jSONObject);
                        return trendListResultData;
                    }
                    return (TrendListResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public n b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new n(this.f36309a) : (n) invokeV.objValue;
                }
            }.a(new com.kwad.sdk.core.network.j<n, TrendListResultData>(bVar) { // from class: com.kwad.sdk.core.g.o.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36310a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36310a = bVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull n nVar, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, nVar, i2, str) == null) {
                        this.f36310a.a(i2, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull n nVar, @NonNull TrendListResultData trendListResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar, trendListResultData) == null) {
                        this.f36310a.a(trendListResultData);
                    }
                }
            });
        }
    }

    public static void a(boolean z, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(AdIconUtil.AD_TEXT_ID, null, z, dVar) == null) || f36302b) {
            return;
        }
        f36302b = true;
        a(z, new b(dVar) { // from class: com.kwad.sdk.core.g.o.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f36303a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36303a = dVar;
            }

            @Override // com.kwad.sdk.core.g.o.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    boolean unused = o.f36302b = false;
                    o.f36301a.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.core.g.o.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f36304a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f36305b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f36306c;

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
                            this.f36306c = this;
                            this.f36304a = i2;
                            this.f36305b = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.d("TrendRequestManager", "loadTrendList onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.f36304a), this.f36305b));
                                this.f36306c.f36303a.a(this.f36304a, this.f36305b);
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.g.o.b
            public void a(@NonNull TrendListResultData trendListResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trendListResultData) == null) {
                    if (trendListResultData.result != 1) {
                        int i2 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i2, com.kwad.sdk.core.network.f.f36360c.l + "(无视频资源)");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (TrendInfo trendInfo : trendListResultData.trends) {
                        if (trendInfo != null) {
                            arrayList.add(trendInfo);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        int i3 = com.kwad.sdk.core.network.f.f36360c.k;
                        a(i3, com.kwad.sdk.core.network.f.f36360c.l + "(无热点资源)");
                    } else {
                        o.f36301a.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.core.g.o.1.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f36307a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f36308b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f36308b = this;
                                this.f36307a = arrayList;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f36308b.f36303a.a(this.f36307a);
                                }
                            }
                        });
                    }
                    boolean unused = o.f36302b = false;
                }
            }
        });
    }
}
