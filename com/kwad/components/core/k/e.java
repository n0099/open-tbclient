package com.kwad.components.core.k;

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
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean HJ;
    public static volatile boolean HK;
    public static volatile boolean HL;
    public static final List<a> HM;
    public static Context ab;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull SdkConfigData sdkConfigData);

        void no();
    }

    /* loaded from: classes7.dex */
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
                try {
                    com.kwad.sdk.core.config.d.aV(e.ab);
                    boolean unused = e.HK = true;
                    for (a aVar : e.HM) {
                        if (aVar != null) {
                            aVar.no();
                        }
                    }
                    e.ok();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTrace(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273781495, "Lcom/kwad/components/core/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273781495, "Lcom/kwad/components/core/k/e;");
                return;
            }
        }
        HM = new CopyOnWriteArrayList();
    }

    public static synchronized void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) {
            synchronized (e.class) {
                if (HJ) {
                    com.kwad.sdk.core.e.b.d("ConfigRequestManager", "config request manager has init-ed");
                    return;
                }
                HJ = true;
                ab = context;
                w.f(context, w.cn(context) + 1);
                HM.add(aVar);
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new b());
            }
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            HM.add(aVar);
            if (HK) {
                aVar.no();
            }
            if (HL) {
                aVar.a(com.kwad.sdk.core.config.d.rZ());
            }
        }
    }

    public static void ok() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            com.kwad.sdk.core.e.b.d("ConfigRequestManager", "load()");
            new m<d, SdkConfigData>() { // from class: com.kwad.components.core.k.e.1
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
                public static SdkConfigData au(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, null, str)) == null) {
                        w.N(e.ab, str);
                        JSONObject jSONObject = new JSONObject(str);
                        SdkConfigData sdkConfigData = new SdkConfigData();
                        sdkConfigData.parseJson(jSONObject);
                        try {
                            com.kwad.sdk.core.config.d.lt();
                            com.kwad.sdk.core.config.d.rH();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTrace(th);
                        }
                        return sdkConfigData;
                    }
                    return (SdkConfigData) invokeL.objValue;
                }

                @NonNull
                public static d on() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65538, null)) == null) ? new d() : (d) invokeV.objValue;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                    return on();
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.m
                @NonNull
                public final /* synthetic */ SdkConfigData parseData(String str) {
                    return au(str);
                }
            }.request(new n<d, SdkConfigData>() { // from class: com.kwad.components.core.k.e.2
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
                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, dVar) == null) {
                        com.kwad.sdk.core.e.b.d("ConfigRequestManager", "onStartRequest request url = " + dVar.getUrl());
                        super.onStartRequest(dVar);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull d dVar, int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(65538, this, dVar, i, str) == null) {
                        super.onError(dVar, i, str);
                        com.kwad.sdk.core.e.b.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                    }
                }

                public static void b(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65539, null, sdkConfigData) == null) {
                        com.kwad.sdk.core.config.b.aT(e.ab);
                        com.kwad.sdk.core.config.d.c(sdkConfigData);
                        boolean unused = e.HL = true;
                        for (a aVar : e.HM) {
                            if (aVar != null) {
                                aVar.a(sdkConfigData);
                            }
                        }
                        if (sdkConfigData != null) {
                            com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                        }
                        v.zu();
                        v.zp();
                        w.f(e.ab, 0);
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    b((SdkConfigData) baseResultData);
                }
            });
        }
    }
}
