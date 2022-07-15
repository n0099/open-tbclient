package com.kwad.components.ad.interstitial.kwai;

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
    public static i a;
    public static i b;
    public static i c;
    public static i d;
    public static i e;
    public static i f;
    public static d g;
    public static i h;
    public static i i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19061493, "Lcom/kwad/components/ad/interstitial/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-19061493, "Lcom/kwad/components/ad/interstitial/kwai/a;");
                return;
            }
        }
        a = new i("interstitialAdSkipCloseType", 0);
        b = new i("interstitialAdSkipCloseArea", 0);
        c = new i("interstitialAdFullClick", 1);
        d = new i("interstitialAdBackPressSwitch", 0);
        e = new i("interstitialPlayableTime", 999);
        f = new i("interstitialAdClickShutDown", 0);
        g = new d("interstitialAutoStartSwitch", false);
        h = new i("ecInterstitialAdOrderSwitch", 0);
        i = new i("interstitialCycleAggregateMaxCount", 3);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
