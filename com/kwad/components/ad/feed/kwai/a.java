package com.kwad.components.ad.feed.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.i;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static i b;
    public static i c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-663307651, "Lcom/kwad/components/ad/feed/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-663307651, "Lcom/kwad/components/ad/feed/kwai/a;");
                return;
            }
        }
        a = new d("feedAdClickGuideSwitch", false);
        b = new i("feedDownloadBtnAnimType", 0);
        c = new i("feedNativeRenderSwitch", 0);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
