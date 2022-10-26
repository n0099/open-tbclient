package com.kwad.components.ad.reward.kwai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static j nR;
    public static j nS;
    public static j nT;
    public static d nU;
    public static o nV;
    public static o nW;
    public static j nX;
    public static j nY;
    public static j nZ;
    public static j oa;
    public static j ob;
    public static f oc;
    public static d od;
    public static j oe;
    public static d of;
    public static d og;
    public static j oh;
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
        nR = new j("rewardSkipType", 0);
        nS = new j("rewardActiveAppTaskMinSecond", 15);
        nT = new j("rewardContentDetainType", 0);
        nU = new d("forceGetAudioFocus", false);
        nV = new o("rewardSkipTips", "");
        nW = new o("fullscreenSkipTips", "");
        nX = new j("ecRewardAdOrderSwitch", 0);
        nY = new j("ecRewardAdFanSwitch", 0);
        nZ = new j("ecRewardAdKwaishopStyle", 0);
        oa = new j("xdtCouponShowDuration", 3000);
        ob = new j("jinniuCloseDialogStyle", 1);
        oc = new f("interactionTimeInRewardedVideo", 0.0f);
        od = new d("autoJumpInRewardedVideo", false);
        oe = new j("advanceJumpDirectDeliveryMaxCount", 0);
        of = new d("rewardReflowPageShowSwitch", false);
        og = new d("advanceJumpDirectDeliverySwitch", false);
        oh = new j("shortVideoFollowRewardPlayStyle", 0);
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }
}
