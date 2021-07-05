package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import com.kwai.video.ksvodplayerkit.j;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f36622a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f36623b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1198306771, "Lcom/kwad/sdk/core/video/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1198306771, "Lcom/kwad/sdk/core/video/a/e;");
                return;
            }
        }
        f36622a = new AtomicBoolean(false);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            com.kwad.sdk.core.d.a.b("KwaiPlayHelper", "initConfigSync()");
            j.a(com.kwad.sdk.core.config.c.o());
            if (!b()) {
                d(context);
            }
            c(context);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            AtomicBoolean atomicBoolean = f36623b;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            try {
                if (Class.forName("com.kwai.video.player.KsMediaMeta") != null) {
                    f36623b = new AtomicBoolean(true);
                    return true;
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
            f36623b = new AtomicBoolean(false);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f36622a.get() || KsAdSDKImpl.get().getIsExternal() : invokeV.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            try {
                d.a(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    public static void d(Context context) {
        String Z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            if (AbiUtil.b()) {
                Z = com.kwad.sdk.core.config.c.aa();
                if (TextUtils.isEmpty(Z)) {
                    Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArm64v8aRelease-3.3.9.apk";
                }
                str = "kwaiplayer-v8a";
            } else {
                Z = com.kwad.sdk.core.config.c.Z();
                if (TextUtils.isEmpty(Z)) {
                    Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.9.apk";
                }
                str = "kwaiplayer-v7a";
            }
            com.kwai.sodler.a.b.a(context);
            com.kwai.sodler.a.b.a(new b.a(Z, str) { // from class: com.kwad.sdk.core.video.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f36624a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36625b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Z, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36624a = Z;
                    this.f36625b = str;
                }

                @Override // com.kwai.sodler.lib.a.b.a
                public com.kwai.sodler.lib.b.b a(String str2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str2)) == null) {
                        com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                        bVar.f39773c = this.f36624a;
                        bVar.f39775e = true;
                        bVar.f39771a = this.f36625b;
                        bVar.f39772b = "3.0";
                        bVar.f39777g = true;
                        return bVar;
                    }
                    return (com.kwai.sodler.lib.b.b) invokeL.objValue;
                }
            });
            com.kwai.sodler.a.b.a(str, new b.a(context) { // from class: com.kwad.sdk.core.video.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f36626a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36626a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, hVar) == null) {
                        super.a(hVar);
                        e.f36622a.set(false);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar, PluginError pluginError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, hVar, pluginError) == null) {
                        e.f36622a.set(false);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar, g gVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048581, this, hVar, gVar) == null) {
                        e.f36622a.set(true);
                        e.c(this.f36626a);
                        e.e();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void b(h hVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, hVar) == null) {
                        super.b(hVar);
                    }
                }
            });
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
        }
    }
}
