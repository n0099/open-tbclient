package com.kwad.components.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.report.r;
import com.kwad.sdk.core.response.a.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.service.kwai.h;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements com.kwad.sdk.core.download.d {
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

        @Override // com.kwad.sdk.core.download.d
        public final void a(int i, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, adTemplate) == null) && i == 1) {
                com.kwad.sdk.core.report.a.f(adTemplate, (JSONObject) null);
            }
        }
    }

    /* renamed from: com.kwad.components.core.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0593b implements com.kwad.sdk.service.kwai.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0593b() {
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
    }

    /* loaded from: classes8.dex */
    public static class c implements com.kwad.sdk.service.kwai.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean G(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                return aVar != null && aVar.qn();
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getApiVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsAdSDKImpl.get().getApiVersion() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final int getApiVersionCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? KsAdSDKImpl.get().getApiVersionCode() : invokeV.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? KsAdSDKImpl.get().getAppId() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? KsAdSDKImpl.get().getAppName() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? KsAdSDKImpl.get().getContext() : (Context) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean getIsExternal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? KsAdSDKImpl.get().getIsExternal() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String getSDKVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? KsAdSDKImpl.get().getSDKVersion() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final SdkConfig getSdkConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? KsAdSDKImpl.get().getSdkConfig() : (SdkConfig) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isDebugLogEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? KsAdSDKImpl.get().isDebugLogEnable() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isPersonalRecommend() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? KsAdSDKImpl.get().isPersonalRecommend() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean isProgrammaticRecommend() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? KsAdSDKImpl.get().isProgrammaticRecommend() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final e lw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (aVar != null) {
                    return aVar.lw();
                }
                return null;
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean ae(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? com.kwad.sdk.core.config.a.ae(str) : invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int af(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? com.kwad.sdk.core.config.item.c.bm(context) : invokeL.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? KsAdSDKImpl.get().getAppId() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getUserAgent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.config.d.getUserAgent() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? com.kwad.sdk.core.config.d.i(j) : invokeJ.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lA() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.config.d.lA() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String lB() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.config.d.lB() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String lC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.config.d.lC() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final List<String> lD() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.config.d.lD() : (List) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.config.d.lE() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lF() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.config.d.lF() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lG() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.config.d.lG() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lH() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.config.d.se() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lI() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.config.d.lI() : invokeV.floatValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lJ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? com.kwad.sdk.core.config.d.lJ() : invokeV.floatValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lK() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? com.kwad.sdk.core.config.d.lK() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? com.kwad.sdk.core.config.d.lL() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int lM() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.config.d.lM() : invokeV.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int lN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.config.d.lN() : invokeV.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float lO() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.config.d.lO() : invokeV.floatValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lx() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? com.kwad.sdk.core.config.d.lx() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean ly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? com.kwad.sdk.core.config.d.ly() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean lz() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? com.kwad.sdk.core.config.d.lz() : invokeV.booleanValue;
        }
    }

    @NonNull
    public static AdHttpProxy le() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (com.kwad.components.core.a.aw.booleanValue()) {
                return lf();
            }
            try {
                return com.kwad.sdk.core.network.kwai.b.tF() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
            } catch (Throwable unused) {
                return new com.kwad.sdk.core.network.b.a();
            }
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    public static AdHttpProxy lf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return new Random().nextInt(2) == 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    public static void lg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ServiceProvider.put(com.kwad.sdk.service.kwai.e.class, new com.kwad.sdk.service.kwai.e() { // from class: com.kwad.components.core.b.1
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

                @Override // com.kwad.sdk.service.kwai.e
                public final Class<?> getProxyRealClass(Class<?> cls) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) ? KsAdSDKImpl.getProxyRealClass(cls) : (Class) invokeL.objValue;
                }

                @Override // com.kwad.sdk.service.kwai.e
                public final Object lm() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsAdSDKImpl.get().getProxyForHttp() : invokeV.objValue;
                }
            });
        }
    }

    public static void lh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ServiceProvider.put(com.kwad.sdk.service.kwai.d.class, new c((byte) 0));
            ServiceProvider.put(f.class, new d((byte) 0));
        }
    }

    public static void li() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            ServiceProvider.put(com.kwad.sdk.service.kwai.a.class, new com.kwad.sdk.service.kwai.a() { // from class: com.kwad.components.core.b.2
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

                @Override // com.kwad.sdk.service.kwai.a
                public final void a(boolean z, String str, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                        com.kwad.sdk.core.diskcache.a.a.sS().bA(str);
                    }
                }

                @Override // com.kwad.sdk.service.kwai.a
                public final File ad(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? com.kwad.sdk.core.diskcache.a.a.sS().ad(str) : (File) invokeL.objValue;
                }
            });
        }
    }

    public static void lj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ServiceProvider.put(com.kwad.sdk.service.kwai.b.class, new C0593b());
        }
    }

    public static void lk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ServiceProvider.put(h.class, new h() { // from class: com.kwad.components.core.b.3
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

                @Override // com.kwad.sdk.service.kwai.h
                public final boolean ln() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.components.core.l.b.or();
                        return com.kwad.components.core.l.b.ln();
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final int lo() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        com.kwad.components.core.l.b.or();
                        return com.kwad.components.core.l.b.lo();
                    }
                    return invokeV.intValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final int lp() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.components.core.l.b.or().lp() : invokeV.intValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final InputStream wrapInputStream(InputStream inputStream) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, inputStream)) == null) {
                        com.kwad.components.core.l.b.or();
                        return com.kwad.components.core.l.b.wrapInputStream(inputStream);
                    }
                    return (InputStream) invokeL.objValue;
                }
            });
            ServiceProvider.put(l.class, new l() { // from class: com.kwad.components.core.b.4
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

                @Override // com.kwad.sdk.core.network.l
                public final void a(double d2, j jVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), jVar}) == null) {
                        k.b(d2, jVar);
                    }
                }

                @Override // com.kwad.sdk.core.network.l
                public final void a(double d2, com.kwad.sdk.core.network.k kVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), kVar}) == null) {
                        k.b(d2, kVar);
                    }
                }

                @Override // com.kwad.sdk.core.network.l
                public final com.kwad.sdk.core.b lq() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.components.core.k.kwai.c.oq() : (com.kwad.sdk.core.b) invokeV.objValue;
                }
            });
            ll();
        }
    }

    public static void ll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            ServiceProvider.put(r.class, new r() { // from class: com.kwad.components.core.b.5
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

                @Override // com.kwad.sdk.core.report.r
                public final boolean h(long j) {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) {
                        m mVar = com.kwad.sdk.core.config.c.Ui;
                        return m.h(j);
                    }
                    return invokeJ.booleanValue;
                }

                @Override // com.kwad.sdk.core.report.r
                public final int lr() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.config.d.lr() : invokeV.intValue;
                }

                @Override // com.kwad.sdk.core.report.r
                public final int ls() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                        if (aVar != null) {
                            return aVar.ls();
                        }
                        return 0;
                    }
                    return invokeV.intValue;
                }
            });
            ServiceProvider.put(com.kwad.sdk.core.download.d.class, new a((byte) 0));
            ServiceProvider.put(com.kwad.sdk.core.video.kwai.f.class, new com.kwad.sdk.core.video.kwai.f() { // from class: com.kwad.components.core.b.6
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

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean lt() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.config.d.lt() : invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean lu() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.config.d.lu() : invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean lv() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)).lv() : invokeV.booleanValue;
                }
            });
            ServiceProvider.put(com.kwad.sdk.utils.a.b.class, new com.kwad.sdk.utils.a.b() { // from class: com.kwad.components.core.b.7
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

                @Override // com.kwad.sdk.utils.a.b
                public final void a(com.kwad.sdk.utils.a.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                        return;
                    }
                    k.b(aVar);
                }
            });
        }
    }
}
