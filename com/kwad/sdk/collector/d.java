package com.kwad.sdk.collector;

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
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
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
        a = new AtomicBoolean(false);
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) || a.get()) {
            return;
        }
        if (KsAdSDKImpl.get().getIsExternal()) {
            b(aVar);
            return;
        }
        a.set(true);
        boolean b2 = AbiUtil.b();
        String str = b2 ? "kwappstatus-v8a" : "kwappstatus-v7a";
        String ad = com.kwad.sdk.core.config.b.ad();
        if (TextUtils.isEmpty(ad)) {
            ad = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
        }
        String ae = com.kwad.sdk.core.config.b.ae();
        if (TextUtils.isEmpty(ae)) {
            ae = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
        }
        if (b2) {
            ad = ae;
        }
        String ah = com.kwad.sdk.core.config.b.ah();
        if (TextUtils.isEmpty(ah)) {
            ah = "3";
        }
        com.kwai.sodler.kwai.b.a(context);
        com.kwai.sodler.lib.a.b bVar = new com.kwai.sodler.lib.a.b();
        bVar.f60084c = ad;
        bVar.f60086e = true;
        bVar.a = str;
        bVar.f60083b = ah;
        bVar.f60088g = false;
        com.kwai.sodler.kwai.b.a(str, bVar, new b.a(aVar) { // from class: com.kwad.sdk.collector.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, hVar) == null) {
                    super.a(hVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, PluginError pluginError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, pluginError) == null) {
                    super.a(hVar, pluginError);
                    if (this.a != null) {
                        this.a.a(pluginError == null ? "load error" : pluginError.toString());
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwai.sodler.lib.ext.b.a, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.h hVar, com.kwai.sodler.lib.g gVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hVar, gVar) == null) {
                    super.a(hVar, gVar);
                    d.b(this.a);
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
