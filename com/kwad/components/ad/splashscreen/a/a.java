package com.kwad.components.ad.splashscreen.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.n;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static i a;
    public static i b;
    public static n c;
    public static n d;
    public static n e;
    public static i f;
    public static i g;
    public static i h;
    public static d i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-79028629, "Lcom/kwad/components/ad/splashscreen/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-79028629, "Lcom/kwad/components/ad/splashscreen/a/a;");
                return;
            }
        }
        a = new i("splashTimeOutMilliSecond", 5000);
        b = new i("splashVplusEnterHomeSeconds", 0);
        c = new n("splashTimerTips", "");
        d = new n("splashBtnText", "点击跳过详情页或第三方应用");
        e = new n("splashVplusEnterHomeTips", "");
        f = new i("shakeCountDaily", 3);
        g = new i("rotateCountDaily", 3);
        h = new i("gestureCountDaily", 5);
        i = new d("splashCropSwitch", true);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
