package com.kwad.sdk.glide.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-796780048, "Lcom/kwad/sdk/glide/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-796780048, "Lcom/kwad/sdk/glide/kwai/a;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public static void a(Context context) {
        String v;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        a.set(true);
        if (AbiUtil.b()) {
            v = b.w();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            v = b.v();
            if (TextUtils.isEmpty(v)) {
                v = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f60084c = v;
        bVar.f60086e = true;
        bVar.a = str;
        bVar.f60083b = "3.0";
        bVar.f60088g = false;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a() { // from class: com.kwad.sdk.glide.kwai.a.1
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar) == null) {
                    super.a(hVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, pluginError) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(h hVar, g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, gVar) == null) {
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
