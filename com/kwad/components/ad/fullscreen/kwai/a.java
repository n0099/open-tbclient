package com.kwad.components.ad.fullscreen.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.j;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static j ej;
    public static j ek;
    public static j el;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(491408602, "Lcom/kwad/components/ad/fullscreen/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(491408602, "Lcom/kwad/components/ad/fullscreen/kwai/a;");
                return;
            }
        }
        ej = new j("fullscreenSkipType", 0);
        ek = new j("fullscreenSkipShowTime", 5);
        el = new j("fullScreenShakeMaxCount", 0);
    }

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
