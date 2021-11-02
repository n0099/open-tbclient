package com.kwad.sdk.collector;

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
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f64162a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1320780940, "Lcom/kwad/sdk/collector/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1320780940, "Lcom/kwad/sdk/collector/d;");
                return;
            }
        }
        f64162a = new AtomicBoolean(false);
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) || f64162a.get()) {
            return;
        }
        if (KsAdSDKImpl.get().getIsExternal()) {
            b(aVar);
            return;
        }
        f64162a.set(true);
        boolean b2 = AbiUtil.b();
        String str = b2 ? "kwappstatus-v8a" : "kwappstatus-v7a";
        String Z = com.kwad.sdk.core.config.c.Z();
        if (TextUtils.isEmpty(Z)) {
            Z = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
        }
        String aa = com.kwad.sdk.core.config.c.aa();
        if (TextUtils.isEmpty(aa)) {
            aa = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
        }
        if (b2) {
            Z = aa;
        }
        String ab = com.kwad.sdk.core.config.c.ab();
        if (TextUtils.isEmpty(ab)) {
            ab = "3";
        }
        com.kwai.sodler.a.b.a(context);
        com.kwai.sodler.lib.b.b bVar = new com.kwai.sodler.lib.b.b();
        bVar.f67110c = Z;
        bVar.f67112e = true;
        bVar.f67108a = str;
        bVar.f67109b = ab;
        bVar.f67114g = false;
        com.kwai.sodler.a.b.a(str, bVar, new b.a(aVar) { // from class: com.kwad.sdk.collector.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f64163a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64163a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, hVar) == null) {
                    super.a(hVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, hVar, pluginError) == null) {
                    super.a(hVar, pluginError);
                    if (this.f64163a != null) {
                        this.f64163a.a(pluginError == null ? "load error" : pluginError.toString());
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, com.kwai.sodler.lib.g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, hVar, gVar) == null) {
                    super.a(hVar, gVar);
                    d.b(this.f64163a);
                }
            }
        });
    }

    public static void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            try {
                System.loadLibrary("kwappstatus");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                com.kwad.sdk.crash.a.a(th);
            }
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
