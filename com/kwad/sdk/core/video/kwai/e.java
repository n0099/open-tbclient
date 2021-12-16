package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f58439b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-939692056, "Lcom/kwad/sdk/core/video/kwai/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-939692056, "Lcom/kwad/sdk/core/video/kwai/e;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            com.kwad.sdk.core.d.a.a("kp init");
            KSVodPlayerCoreInitConfig.updatePlayerConfig(com.kwad.sdk.core.config.b.g());
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
            AtomicBoolean atomicBoolean = f58439b;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            f58439b = atomicBoolean2;
            return atomicBoolean2.get();
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.get() || KsAdSDKImpl.get().getIsExternal() || com.kwad.sdk.b.f57627e.booleanValue() : invokeV.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            try {
                d.a(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    public static void d(Context context) {
        String v;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            if (AbiUtil.b()) {
                v = com.kwad.sdk.core.config.b.w();
                if (TextUtils.isEmpty(v)) {
                    v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArm64v8aRelease-3.3.20.apk";
                }
                str = "kwaiplayer-v8a";
            } else {
                v = com.kwad.sdk.core.config.b.v();
                if (TextUtils.isEmpty(v)) {
                    v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.20.apk";
                }
                str = "kwaiplayer-v7a";
            }
            com.kwai.sodler.kwai.b.a(context);
            com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
            bVar.f60665c = v;
            bVar.f60667e = true;
            bVar.a = str;
            bVar.f60664b = "3.4";
            bVar.f60669g = true;
            com.kwai.sodler.kwai.b.a(str, bVar, new b.a(context) { // from class: com.kwad.sdk.core.video.kwai.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

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
                    this.a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar) == null) {
                        super.a(hVar);
                        e.a.set(false);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar, PluginError pluginError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, pluginError) == null) {
                        e.a.set(false);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void a(h hVar, g gVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, gVar) == null) {
                        e.a.set(true);
                        e.c(this.a);
                        e.e();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
                public void b(h hVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, hVar) == null) {
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
