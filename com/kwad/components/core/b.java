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
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.download.a;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.report.r;
import com.kwad.sdk.core.response.a.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.service.kwai.h;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.c;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null);
            }
        }
    }

    /* renamed from: com.kwad.components.core.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0506b implements com.kwad.sdk.service.kwai.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0506b() {
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

    /* loaded from: classes5.dex */
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
        public final Context a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? KsAdSDKImpl.get().getContext() : (Context) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate)) == null) {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                return aVar != null && aVar.c();
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? KsAdSDKImpl.get().getAppId() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? KsAdSDKImpl.get().getAppName() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? KsAdSDKImpl.get().getIsExternal() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? KsAdSDKImpl.get().getApiVersion() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? KsAdSDKImpl.get().getApiVersionCode() : invokeV.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? KsAdSDKImpl.get().isPersonalRecommend() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? KsAdSDKImpl.get().isProgrammaticRecommend() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? KsAdSDKImpl.get().getSDKVersion() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? KsAdSDKImpl.get().isDebugLogEnable() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final SdkConfig k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? KsAdSDKImpl.get().getSdkConfig() : (SdkConfig) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.d
        public final e l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                if (aVar != null) {
                    return aVar.d();
                }
                return null;
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public final int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? com.kwad.sdk.core.config.item.c.a(context) : invokeL.intValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.config.d.t() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? com.kwad.sdk.core.config.d.a(j) : invokeJ.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? com.kwad.sdk.core.config.a.a(str) : invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.config.d.u() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.config.d.v() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.config.d.s() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.config.d.y() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.config.d.z() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final List<String> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.config.d.c() : (List) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.config.d.L() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.config.d.M() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.config.d.Q() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.config.d.x() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? KsAdSDKImpl.get().getAppId() : (String) invokeV.objValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? com.kwad.sdk.core.config.d.N() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? com.kwad.sdk.core.config.d.O() : invokeV.floatValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final float o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.config.d.P() : invokeV.floatValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.config.d.ag() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.config.d.ah() : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? com.kwad.sdk.core.config.d.b() : invokeV.intValue;
        }
    }

    @NonNull
    public static AdHttpProxy a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (com.kwad.components.core.a.c.booleanValue()) {
                return g();
            }
            try {
                return com.kwad.sdk.core.network.kwai.b.a() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
            } catch (Throwable unused) {
                return new com.kwad.sdk.core.network.b.a();
            }
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            c.a aVar = new c.a();
            aVar.a("sodler");
            aVar.a(((i) com.kwad.sdk.core.config.d.a(context, com.kwad.sdk.core.config.c.aB)).b().intValue());
            aVar.a(false);
            aVar.b(((com.kwad.sdk.core.config.item.d) com.kwad.sdk.core.config.d.a(context, com.kwad.sdk.core.config.c.aA)).b().booleanValue());
            com.kwai.sodler.kwai.a.a(context, aVar.a());
            com.kwai.sodler.kwai.a.a(new g.a() { // from class: com.kwad.components.core.b.1
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

                @Override // com.kwai.sodler.lib.a.g.a
                public final void a(com.kwai.sodler.lib.a.f fVar, File file) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, fVar, file) == null) {
                        try {
                            com.kwad.sdk.core.download.a.a(fVar.p(), file, (a.b) null, -1, true);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.a("Sodler", "download failed url: " + fVar.p(), th);
                            if (th instanceof Exception) {
                                com.kwad.sdk.core.network.idc.a.a().a(fVar.p(), th);
                            }
                            throw new PluginError.UpdateError(th.getMessage(), -4);
                        }
                    }
                }
            });
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ServiceProvider.a(com.kwad.sdk.service.kwai.e.class, new com.kwad.sdk.service.kwai.e() { // from class: com.kwad.components.core.b.2
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
                public final Class<?> a(Class<?> cls) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) ? KsAdSDKImpl.getProxyRealClass(cls) : (Class) invokeL.objValue;
                }

                @Override // com.kwad.sdk.service.kwai.e
                public final Object a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsAdSDKImpl.get().getProxyForHttp() : invokeV.objValue;
                }
            });
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ServiceProvider.a(com.kwad.sdk.service.kwai.d.class, new c((byte) 0));
            ServiceProvider.a(f.class, new d((byte) 0));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            ServiceProvider.a(com.kwad.sdk.service.kwai.a.class, new com.kwad.sdk.service.kwai.a() { // from class: com.kwad.components.core.b.3
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
                public final File a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? com.kwad.sdk.core.diskcache.a.a.a().b(str) : (File) invokeL.objValue;
                }

                @Override // com.kwad.sdk.service.kwai.a
                public final void a(boolean z, String str, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                        com.kwad.sdk.core.diskcache.a.a.a().a(str);
                    }
                }
            });
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ServiceProvider.a(com.kwad.sdk.service.kwai.b.class, new C0506b());
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ServiceProvider.a(h.class, new h() { // from class: com.kwad.components.core.b.4
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
                public final InputStream a(InputStream inputStream) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, inputStream)) == null) {
                        com.kwad.components.core.k.b.a();
                        return com.kwad.components.core.k.b.a(inputStream);
                    }
                    return (InputStream) invokeL.objValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        com.kwad.components.core.k.b.a();
                        return com.kwad.components.core.k.b.b();
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final int b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        com.kwad.components.core.k.b.a();
                        return com.kwad.components.core.k.b.c();
                    }
                    return invokeV.intValue;
                }

                @Override // com.kwad.sdk.service.kwai.h
                public final int c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? com.kwad.components.core.k.b.a().d() : invokeV.intValue;
                }
            });
            ServiceProvider.a(k.class, new k() { // from class: com.kwad.components.core.b.5
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

                @Override // com.kwad.sdk.core.network.k
                public final com.kwad.sdk.core.b a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? com.kwad.components.core.j.kwai.c.a() : (com.kwad.sdk.core.b) invokeV.objValue;
                }

                @Override // com.kwad.sdk.core.network.k
                public final void a(com.kwad.sdk.core.network.i iVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
                        com.kwad.sdk.core.report.k.a(iVar);
                    }
                }

                @Override // com.kwad.sdk.core.network.k
                public final void a(j jVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
                        com.kwad.sdk.core.report.k.a(jVar);
                    }
                }
            });
            h();
        }
    }

    public static AdHttpProxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return new Random().nextInt(2) == 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ServiceProvider.a(r.class, new r() { // from class: com.kwad.components.core.b.6
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
                public final int a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.config.d.f() : invokeV.intValue;
                }

                @Override // com.kwad.sdk.core.report.r
                public final boolean a(long j) {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                        l lVar = com.kwad.sdk.core.config.c.K;
                        return l.a(j);
                    }
                    return invokeJ.booleanValue;
                }

                @Override // com.kwad.sdk.core.report.r
                public final int b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                        if (aVar != null) {
                            return aVar.a();
                        }
                        return 0;
                    }
                    return invokeV.intValue;
                }
            });
            ServiceProvider.a(com.kwad.sdk.core.download.d.class, new a((byte) 0));
            ServiceProvider.a(com.kwad.sdk.core.video.kwai.f.class, new com.kwad.sdk.core.video.kwai.f() { // from class: com.kwad.components.core.b.7
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
                public final boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.config.d.e() : invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.config.d.p() : invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.config.d.h() : invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.video.kwai.f
                public final boolean d() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class)).b() : invokeV.booleanValue;
                }
            });
        }
    }
}
