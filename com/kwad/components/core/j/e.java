package com.kwad.components.core.j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.as;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static Context d;
    public static final List<a> e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(@NonNull SdkConfigData sdkConfigData);
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.kwad.sdk.core.config.d.a(e.d);
                boolean unused = e.b = true;
                for (a aVar : e.e) {
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                e.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273751704, "Lcom/kwad/components/core/j/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273751704, "Lcom/kwad/components/core/j/e;");
                return;
            }
        }
        e = new CopyOnWriteArrayList();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            com.kwad.sdk.core.d.b.a("ConfigRequestManager", "load()");
            new l<d, SdkConfigData>() { // from class: com.kwad.components.core.j.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @NonNull
                public static d a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, null)) == null) ? new d() : (d) invokeV.objValue;
                }

                @NonNull
                public static SdkConfigData a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, null, str)) == null) {
                        as.m(e.d, str);
                        JSONObject jSONObject = new JSONObject(str);
                        SdkConfigData sdkConfigData = new SdkConfigData();
                        sdkConfigData.parseJson(jSONObject);
                        try {
                            com.kwad.sdk.core.config.d.e();
                            com.kwad.sdk.core.config.d.d();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.a(th);
                        }
                        return sdkConfigData;
                    }
                    return (SdkConfigData) invokeL.objValue;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                    return a();
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ SdkConfigData parseData(String str) {
                    return a(str);
                }
            }.request(new m<d, SdkConfigData>() { // from class: com.kwad.components.core.j.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, dVar) == null) {
                        com.kwad.sdk.core.d.b.a("ConfigRequestManager", "onStartRequest request url = " + dVar.getUrl());
                        super.onStartRequest(dVar);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull d dVar, int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(65538, this, dVar, i, str) == null) {
                        super.onError(dVar, i, str);
                        com.kwad.sdk.core.d.b.a("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                    }
                }

                public static void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65539, null, sdkConfigData) == null) {
                        com.kwad.sdk.core.config.b.a(e.d);
                        com.kwad.sdk.core.config.d.a(sdkConfigData);
                        boolean unused = e.c = true;
                        for (a aVar : e.e) {
                            if (aVar != null) {
                                aVar.a(sdkConfigData);
                            }
                        }
                        if (sdkConfigData != null) {
                            com.kwad.sdk.f.kwai.a.a(sdkConfigData.httpDnsInfo);
                        }
                    }
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    a((SdkConfigData) baseResultData);
                }
            });
        }
    }

    public static synchronized void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, aVar) == null) {
            synchronized (e.class) {
                if (a) {
                    com.kwad.sdk.core.d.b.a("ConfigRequestManager", "config request manager has init-ed");
                    return;
                }
                a = true;
                d = context;
                e.add(aVar);
                com.kwad.sdk.utils.g.a(new b());
            }
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            e.add(aVar);
            if (b) {
                aVar.a();
            }
            if (c) {
                aVar.a(com.kwad.sdk.core.config.d.G());
            }
        }
    }
}
