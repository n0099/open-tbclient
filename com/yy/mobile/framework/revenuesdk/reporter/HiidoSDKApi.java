package com.yy.mobile.framework.revenuesdk.reporter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void initHiidoSdk(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, revenueConfig) == null) && mStatisAPI == null) {
            if (revenueConfig == null) {
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
            }
        }
    }
}
