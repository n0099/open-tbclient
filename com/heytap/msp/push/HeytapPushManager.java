package com.heytap.msp.push;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HeytapPushManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HeytapPushManager() {
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

    public static void clearNotificationType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            clearNotificationType(null);
        }
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jSONObject) == null) {
            PushService.getInstance().clearNotificationType(jSONObject);
        }
    }

    public static void clearNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            clearNotifications(null);
        }
    }

    public static void clearNotifications(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) {
            PushService.getInstance().clearNotifications(jSONObject);
        }
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iSetAppNotificationCallBackService) == null) {
            PushService.getInstance().disableAppNotificationSwitch(iSetAppNotificationCallBackService);
        }
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, iSetAppNotificationCallBackService) == null) {
            PushService.getInstance().enableAppNotificationSwitch(iSetAppNotificationCallBackService);
        }
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iGetAppNotificationCallBackService) == null) {
            PushService.getInstance().getAppNotificationSwitch(iGetAppNotificationCallBackService);
        }
    }

    public static String getMcsPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? PushService.getInstance().getMcsPackageName(context) : (String) invokeL.objValue;
    }

    public static void getNotificationStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            getNotificationStatus(null);
        }
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, jSONObject) == null) {
            PushService.getInstance().getNotificationStatus(jSONObject);
        }
    }

    public static ICallBackResultService getPushCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? PushService.getInstance().getPushCallback() : (ICallBackResultService) invokeV.objValue;
    }

    public static void getPushStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            PushService.getInstance().getPushStatus();
        }
    }

    public static int getPushVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? PushService.getInstance().getPushVersionCode() : invokeV.intValue;
    }

    public static String getPushVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? PushService.getInstance().getPushVersionName() : (String) invokeV.objValue;
    }

    public static String getReceiveSdkAction(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? PushService.getInstance().getReceiveSdkAction(context) : (String) invokeL.objValue;
    }

    public static void getRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            getRegister(null);
        }
    }

    public static void getRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, jSONObject) == null) {
            PushService.getInstance().getRegister(jSONObject);
        }
    }

    public static String getRegisterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? PushService.getInstance().getRegisterID() : (String) invokeV.objValue;
    }

    public static int getSDKVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? PushService.getSDKVersionCode() : invokeV.intValue;
    }

    public static String getSDKVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? PushService.getSDKVersionName() : (String) invokeV.objValue;
    }

    public static void init(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, context, z) == null) {
            PushService.getInstance().init(context, z);
        }
    }

    public static boolean isSupportPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? PushService.getInstance().isSupportPushByClient(context) : invokeL.booleanValue;
    }

    public static void openNotificationSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            openNotificationSettings(null);
        }
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, jSONObject) == null) {
            PushService.getInstance().openNotificationSettings(jSONObject);
        }
    }

    public static void pausePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            pausePush(null);
        }
    }

    public static void pausePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, jSONObject) == null) {
            PushService.getInstance().pausePush(jSONObject);
        }
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, null, context, str, str2, iCallBackResultService) == null) {
            register(context, str, str2, null, iCallBackResultService);
        }
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65564, null, context, str, str2, jSONObject, iCallBackResultService) == null) {
            PushService.getInstance().register(context, str, str2, jSONObject, iCallBackResultService);
        }
    }

    public static void requestNotificationPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            PushService.getInstance().requestNotificationPermission();
        }
    }

    public static void resumePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            resumePush(null);
        }
    }

    public static void resumePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, jSONObject) == null) {
            PushService.getInstance().resumePush(jSONObject);
        }
    }

    public static void setAppKeySecret(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, str, str2) == null) {
            PushService.getInstance().setAppKeySecret(str, str2);
        }
    }

    public static void setNotificationType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, null, i) == null) {
            setNotificationType(i, null);
        }
    }

    public static void setNotificationType(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65570, null, i, jSONObject) == null) {
            PushService.getInstance().setNotificationType(i, jSONObject);
        }
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, iCallBackResultService) == null) {
            PushService.getInstance().setPushCallback(iCallBackResultService);
        }
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            setPushTime(list, i, i2, i3, i4, null);
        }
    }

    public static void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jSONObject}) == null) {
            PushService.getInstance().setPushTime(list, i, i2, i3, i4, jSONObject);
        }
    }

    public static void setRegisterID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, str) == null) {
            PushService.getInstance().setRegisterID(str);
        }
    }

    public static void statisticEvent(Context context, String str, DataMessage dataMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65575, null, context, str, dataMessage) == null) {
            StatisticUtils.statisticEvent(context, str, dataMessage);
        }
    }

    @Deprecated
    public static void statisticMessage(Context context, MessageStat messageStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, context, messageStat) == null) {
            StatUtil.statisticMessage(context, messageStat);
        }
    }

    @Deprecated
    public static void statisticMessage(Context context, List<MessageStat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65577, null, context, list) == null) {
            StatUtil.statisticMessage(context, list);
        }
    }

    public static void unRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, null) == null) {
            unRegister(null);
        }
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65579, null, context, str, str2, jSONObject, iCallBackResultService) == null) {
            PushService.getInstance().unRegister(context, str, str2, jSONObject, iCallBackResultService);
        }
    }

    public static void unRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, null, jSONObject) == null) {
            PushService.getInstance().unRegister(jSONObject);
        }
    }
}
