package com.kwad.sdk.core.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.g;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f71632a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f71633b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f71634c;

    /* renamed from: d  reason: collision with root package name */
    public static a f71635d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void a(@NonNull SdkConfigData sdkConfigData);
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.kwad.sdk.core.config.c.a(c.f71634c);
                if (c.f71635d != null) {
                    c.f71635d.a();
                }
                if (!c.f71632a) {
                    com.kwad.sdk.core.report.d.b(c.f71634c);
                    boolean unused = c.f71632a = true;
                }
                c.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1890041557, "Lcom/kwad/sdk/core/g/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1890041557, "Lcom/kwad/sdk/core/g/c;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            com.kwad.sdk.core.d.a.a("ConfigRequestManager", "load()");
            new i<com.kwad.sdk.core.g.b, SdkConfigData>() { // from class: com.kwad.sdk.core.g.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.core.g.b b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new com.kwad.sdk.core.g.b() : (com.kwad.sdk.core.g.b) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public SdkConfigData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        SdkConfigData sdkConfigData = new SdkConfigData();
                        sdkConfigData.parseJson(jSONObject);
                        try {
                            boolean k = com.kwad.sdk.core.config.c.k();
                            String j2 = com.kwad.sdk.core.config.c.j();
                            if (k && !TextUtils.isEmpty(j2)) {
                                KSVodPlayerCoreInitConfig.updatePlayerConfig(j2);
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.a(th);
                        }
                        return sdkConfigData;
                    }
                    return (SdkConfigData) invokeL.objValue;
                }
            }.a(new j<com.kwad.sdk.core.g.b, SdkConfigData>() { // from class: com.kwad.sdk.core.g.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onStartRequest request url = " + bVar.a());
                        super.a((AnonymousClass2) bVar);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.b bVar, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2, str) == null) {
                        super.a((AnonymousClass2) bVar, i2, str);
                        com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.g.b bVar, @NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, sdkConfigData) == null) {
                        com.kwad.sdk.core.config.b.a(c.f71634c);
                        com.kwad.sdk.core.config.c.a(sdkConfigData);
                        com.kwad.sdk.core.config.c.a(c.f71634c, sdkConfigData);
                        if (c.f71635d != null) {
                            c.f71635d.a(sdkConfigData);
                        }
                    }
                }
            });
        }
    }

    public static synchronized void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, aVar) == null) {
            synchronized (c.class) {
                if (f71633b) {
                    com.kwad.sdk.core.d.a.a("ConfigRequestManager", "config request manager has init-ed");
                    return;
                }
                f71633b = true;
                f71634c = context;
                f71635d = aVar;
                g.a(new b());
            }
        }
    }
}
