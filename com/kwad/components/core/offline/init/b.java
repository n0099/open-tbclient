package com.kwad.components.core.offline.init;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.offline.init.kwai.g;
import com.kwad.components.offline.api.OfflineHostProvider;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean EL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-254554929, "Lcom/kwad/components/core/offline/init/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-254554929, "Lcom/kwad/components/core/offline/init/b;");
                return;
            }
        }
        EL = new AtomicBoolean();
    }

    @ForInvoker(methodId = "initOC")
    public static void ao(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            com.kwad.components.offline.obiwan.a.aC(context);
            com.kwad.components.offline.tk.a.aC(context);
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || EL.get()) {
            return;
        }
        EL.set(true);
        OfflineHostProvider.get().init(context, new g());
        ao(context);
    }
}
