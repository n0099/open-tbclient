package com.kwad.components.ad.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.n;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static n a;
    public static n b;
    public static n c;
    public static n d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1876272831, "Lcom/kwad/components/ad/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1876272831, "Lcom/kwad/components/ad/c/a;");
                return;
            }
        }
        a = new n("kwaiLogoUrl", null);
        b = new n("attentionTips", "去关注TA");
        c = new n("viewHomeTips", "查看TA的主页");
        d = new n("buyNowTips", "立即抢购");
    }

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
