package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fz4 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(LiveRemindRecommendData liveRemindRecommendData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveRemindRecommendData)) == null) {
            if (liveRemindRecommendData == null || StringUtils.isNull(liveRemindRecommendData.getLiveIconScheme())) {
                return null;
            }
            b = liveRemindRecommendData.getShowPage();
            String liveIconScheme = liveRemindRecommendData.getLiveIconScheme();
            if (liveRemindRecommendData.getShowPage() == 3) {
                String b2 = b();
                if (liveIconScheme.contains("closeLink")) {
                    return SchemeActionHelper.replaceUrlParameter(liveIconScheme.replace("VIDEOICONBACK", b2 + "_back"), "source", b2);
                }
                return SchemeActionHelper.replaceUrlParameter(liveIconScheme, "source", b2);
            }
            return liveIconScheme;
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int i = a;
            if (i == 1) {
                return YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL;
            }
            if (i == 2) {
                return YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE;
            }
            int i2 = b;
            return i2 == 1 ? "index_gz" : i2 == 2 ? AddFriendActivityConfig.TYPE_PB_HEAD : YYLiveUtil.SOURCE_NOT_DEFINE;
        }
        return (String) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_LIVE_ICON_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_type", 1).eventStat();
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            a = i;
        }
    }
}
