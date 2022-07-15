package com.kwad.components.ad.reward.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.n;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static i a;
    public static i b;
    public static i c;
    public static d d;
    public static n e;
    public static n f;
    public static i g;
    public static i h;
    public static i i;
    public static i j;
    public static i k;
    public static e l;
    public static d m;
    public static i n;
    public static d o;
    public static d p;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-846053170, "Lcom/kwad/components/ad/reward/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-846053170, "Lcom/kwad/components/ad/reward/kwai/a;");
                return;
            }
        }
        a = new i("rewardSkipType", 0);
        b = new i("rewardActiveAppTaskMinSecond", 15);
        c = new i("rewardContentDetainType", 0);
        d = new d("forceGetAudioFocus", false);
        e = new n("rewardSkipTips", "");
        f = new n("fullscreenSkipTips", "");
        g = new i("ecRewardAdOrderSwitch", 0);
        h = new i("ecRewardAdFanSwitch", 0);
        i = new i("ecRewardAdKwaishopStyle", 0);
        j = new i("xdtCouponShowDuration", 3000);
        k = new i("jinniuCloseDialogStyle", 1);
        l = new e("interactionTimeInRewardedVideo", 0.0f);
        m = new d("autoJumpInRewardedVideo", false);
        n = new i("advanceJumpDirectDeliveryMaxCount", 0);
        o = new d("rewardReflowPageShowSwitch", false);
        p = new d("advanceJumpDirectDeliverySwitch", false);
    }

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
