package com.kwad.sdk.glide.webp;

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
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwai.sodler.lib.a.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f38446a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(749136996, "Lcom/kwad/sdk/glide/webp/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(749136996, "Lcom/kwad/sdk/glide/webp/e;");
                return;
            }
        }
        f38446a = new AtomicBoolean(false);
    }

    public static void a(Context context) {
        String Z;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || f38446a.get() || KsAdSDKImpl.get().getIsExternal()) {
            return;
        }
        f38446a.set(true);
        if (AbiUtil.b()) {
            Z = com.kwad.sdk.core.config.c.aa();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9.apk";
            }
            str = "sowebp-v8a";
        } else {
            Z = com.kwad.sdk.core.config.c.Z();
            if (TextUtils.isEmpty(Z)) {
                Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9.apk";
            }
            str = "sowebp-v7a";
        }
        com.kwai.sodler.a.b.a(context);
        com.kwai.sodler.a.b.a(new b.a(Z, str) { // from class: com.kwad.sdk.glide.webp.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f38447a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f38448b;

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
                this.f38447a = Z;
                this.f38448b = str;
            }

            @Override // com.kwai.sodler.lib.a.b.a
            public com.kwai.sodler.lib.b.b a(String str2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str2)) == null) {
                    com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
                    bVar.f39773c = this.f38447a;
                    bVar.f39775e = true;
                    bVar.f39771a = this.f38448b;
                    bVar.f39772b = "3.0";
                    bVar.f39777g = false;
                    return bVar;
                }
                return (com.kwai.sodler.lib.b.b) invokeL.objValue;
            }
        });
        com.kwai.sodler.a.b.a(str, new b.a() { // from class: com.kwad.sdk.glide.webp.e.2
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
