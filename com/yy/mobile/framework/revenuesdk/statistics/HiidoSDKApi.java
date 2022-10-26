package com.yy.mobile.framework.revenuesdk.statistics;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
/* loaded from: classes8.dex */
public class HiidoSDKApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HiidoSDKApi";
    public static StatisAPI mStatisAPI;
    public transient /* synthetic */ FieldHolder $fh;

    public HiidoSDKApi() {
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

    public static void initHiidoSdk(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, revenueConfig) == null) {
            if (mStatisAPI != null) {
                RLog.info(TAG, "initHiidoSdk mStatisAPI != null ");
            } else if (revenueConfig == null) {
                RLog.error(TAG, "initHiidoSdk error config null", new Object[0]);
            } else if (revenueConfig.getContext() == null) {
                RLog.error(TAG, "initHiidoSdk error config.getContext() null", new Object[0]);
            } else {
                StatisOption statisOption = new StatisOption();
                statisOption.setAppkey(HiidoConstantContent.mAppKey);
                statisOption.setAppId(revenueConfig.getAppId() + "");
                statisOption.setFrom("YYPaySDK");
                statisOption.setVer(HiidoConstantContent.mSdkVer);
                StatisAPI createNewStatisApi = HiidoSDK.instance().createNewStatisApi();
                mStatisAPI = createNewStatisApi;
                createNewStatisApi.init(revenueConfig.getContext(), statisOption);
                RLog.info(TAG, "initHiidoSdk success config:" + revenueConfig);
            }
        }
    }

    public static void reportCount(int i, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)}) == null) {
            StatisAPI statisAPI = mStatisAPI;
            if (statisAPI == null) {
                RLog.error(TAG, "reportCount error mStatisAPI null", new Object[0]);
            } else {
                statisAPI.reportCount(i, str, str2, j);
            }
        }
    }

    public static void reportCount(int i, String str, String str2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            StatisAPI statisAPI = mStatisAPI;
            if (statisAPI == null) {
                RLog.error(TAG, "reportCount error mStatisAPI null", new Object[0]);
            } else {
                statisAPI.reportCount(i, str, str2, j);
            }
        }
    }

    public static void reportReturnCode(int i, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2}) == null) {
            if (mStatisAPI == null) {
                RLog.error(TAG, "reportReturnCode error mStatisAPI null", new Object[0]);
                return;
            }
            RLog.debug(TAG, "reportReturnCode uri:" + str);
            mStatisAPI.reportReturnCode(i, str, j, str2, null);
        }
    }

    public static void reportStatisticContent(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, statisContent) == null) {
            if (mStatisAPI == null) {
                RLog.error(TAG, "reportStatisticContent error mStatisAPI null", new Object[0]);
                return;
            }
            RLog.debug(TAG, "reportStatisticContent content:" + statisContent);
            mStatisAPI.reportStatisticContent(str, statisContent, true, true);
        }
    }
}
