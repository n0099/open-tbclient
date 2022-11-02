package com.kwad.components.ad.splashscreen.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static j yl;
    public static j ym;
    public static o yn;
    public static o yo;
    public static o yp;
    public static j yq;
    public static j yr;
    public static j ys;
    public static d yt;
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
        yl = new j("splashTimeOutMilliSecond", 5000);
        ym = new j("splashVplusEnterHomeSeconds", 0);
        yn = new o("splashTimerTips", "");
        yo = new o("splashBtnText", "点击跳过详情页或第三方应用");
        yp = new o("splashVplusEnterHomeTips", "");
        yq = new j("shakeCountDaily", 3);
        yr = new j("rotateCountDaily", 3);
        ys = new j("gestureCountDaily", 5);
        yt = new d("splashCropSwitch", true);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
