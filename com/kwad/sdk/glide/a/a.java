package com.kwad.sdk.glide.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f65833a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905858477, "Lcom/kwad/sdk/glide/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(905858477, "Lcom/kwad/sdk/glide/a/a;");
                return;
            }
        }
        f65833a = new AtomicBoolean(false);
    }

    public static void a(Context context) {
        String x;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || f65833a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        f65833a.set(true);
        if (AbiUtil.b()) {
            x = c.y();
            if (TextUtils.isEmpty(x)) {
                x = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            x = c.x();
            if (TextUtils.isEmpty(x)) {
                x = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        b.a(context);
        com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
        bVar.f67110c = x;
        bVar.f67112e = true;
        bVar.f67108a = str;
        bVar.f67109b = "3.0";
        bVar.f67114g = false;
        b.a(str, bVar, new b.a() { // from class: com.kwad.sdk.glide.a.a.1
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
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, hVar) == null) {
                    super.a(hVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, hVar, pluginError) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, hVar, gVar) == null) {
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
