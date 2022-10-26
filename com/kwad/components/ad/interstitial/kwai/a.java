package com.kwad.components.ad.interstitial.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.j;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static j fJ;
    public static j fK;
    public static j fL;
    public static j fM;
    public static j fN;
    public static j fO;
    public static d fP;
    public static j fQ;
    public static j fR;
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
        fJ = new j("interstitialAdSkipCloseType", 0);
        fK = new j("interstitialAdSkipCloseArea", 0);
        fL = new j("interstitialAdFullClick", 1);
        fM = new j("interstitialAdBackPressSwitch", 0);
        fN = new j("interstitialPlayableTime", 999);
        fO = new j("interstitialAdClickShutDown", 0);
        fP = new d("interstitialAutoStartSwitch", false);
        fQ = new j("ecInterstitialAdOrderSwitch", 0);
        fR = new j("interstitialCycleAggregateMaxCount", 3);
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
