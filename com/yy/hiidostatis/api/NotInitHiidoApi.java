package com.yy.hiidostatis.api;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class NotInitHiidoApi implements HiidoApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NotInitHiidoApi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            return null;
        }
        return (MetricsWorker) invokeLJ.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, statisOption, onStatisListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void beginSession(String str, String str2, long j, Map<String, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j), map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void closeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisAPI createNewStatisApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (StatisAPI) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSession(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSessionAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void getHdid(Context context, HiidoSDK.HdidReceiver hdidReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, hdidReceiver) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public OnStatisListener getOnStatisListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (OnStatisListener) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getOnlineConfigParams(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, context, str)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisOption getStatisOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(Activity activity, HiidoSDK.PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, activity, pageActionReportOption) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(String str, HiidoSDK.PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, pageActionReportOption) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048598, this, j, activity) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048599, this, j, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenMonitor(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, motionEvent) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenPause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenResume(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{str, str2, calAction, str3, number, map, map2})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048604, this, str, str2, list, map, map2)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean registerActivityLifecycleMonitor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void removeActAdditionListerner(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, actListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d2), str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d2), str2, property}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048614, this, j, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048615, this, j, th) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCustomContent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportErrorEvent(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean reportFeedBack(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048619, this, str, str2, str3)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i), str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLocation(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLogin(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportPushToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048624, this, str, str2, str3, map) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2, map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), str3, map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{str, Integer.valueOf(i), str2, shareType, str3, str4, str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, statisContent) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, str, statisContent, z) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, statisContent) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048633, this, context, str, statisContent) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2), str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048636, this, j, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Long.valueOf(j), str, str2, property}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, hiidoSdkAdditionDelegate) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setBdCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setCurPageParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setHeartbeatField(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, str, str2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setOnLineConfigListener(OnLineConfigListener onLineConfigListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onLineConfigListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void updateOnlineConfigs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, context) == null) {
        }
    }
}
