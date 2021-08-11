package com.yy.mobile.framework.revenuesdk.reporter;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.utils.MD5Utils;
import com.yy.mobile.framework.revenuesdk.statistics.PayFlowReporter;
import com.yy.mobile.framework.revenuesdk.statistics.PayUIReporter;
import com.yy.mobile.framework.revenuesdk.statistics.PayUVReporter;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
/* loaded from: classes10.dex */
public class SDKReporter implements ISDKReporter {
    public static /* synthetic */ Interceptable $ic;
    public static StatisAPI mStatisAPI;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public PayFlowReporter mPayFlowReporter;
    public PayUIReporter mPayUIReporter;
    public PayUVReporter mPayUVReporter;

    public SDKReporter(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {revenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "SDKReporter";
        initHiidoConstantContent(revenueConfig);
        initHiidoSdk(revenueConfig);
        BaseHiidoContent createBaseContent = createBaseContent(revenueConfig);
        if (createBaseContent == null) {
            RLog.error("SDKReporter", "new SDKReporter error baseHiidoContent null", new Object[0]);
            return;
        }
        this.mPayUIReporter = new PayUIReporter(createBaseContent);
        this.mPayFlowReporter = new PayFlowReporter(createBaseContent);
        this.mPayUVReporter = new PayUVReporter(createBaseContent);
    }

    private BaseHiidoContent createBaseContent(RevenueConfig revenueConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, revenueConfig)) == null) {
            if (revenueConfig == null) {
                RLog.error("SDKReporter", "createBaseContent config null", new Object[0]);
                return null;
            }
            BaseHiidoContent.BaseHiidoContentBuilder act = new BaseHiidoContent.BaseHiidoContentBuilder().setAct(HiidoConstantContent.ACT_LPF_REVENUE_PAY_ORIGINAL);
            BaseHiidoContent.BaseHiidoContentBuilder appId = act.setAppId(revenueConfig.getAppId() + "");
            return appId.setUseChannel(revenueConfig.getUsedChannel() + "").setUid(XorUtil.encode(String.valueOf(revenueConfig.getUid()))).build();
        }
        return (BaseHiidoContent) invokeL.objValue;
    }

    private void initHiidoConstantContent(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, revenueConfig) == null) {
            if (revenueConfig == null) {
                RLog.error("SDKReporter", "initHiidoConstantContent config null", new Object[0]);
                return;
            }
            HiidoConstantContent.mClientVer = revenueConfig.getClientVerion();
            HiidoConstantContent.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            HiidoConstantContent.mMBOS = sb.toString();
            if (revenueConfig.getReportConfig() != null) {
                HiidoConstantContent.mPackage = revenueConfig.getReportConfig().getAppName();
            }
            HiidoConstantContent.mSdkVer = BuildConfig.VERSION_NAME;
            HiidoConstantContent.mOpenId = MD5Utils.getMD5String(String.valueOf(revenueConfig.getUid()));
            HiidoConstantContent.mUserType = revenueConfig.getAuthType() == 4 ? "1" : "2";
        }
    }

    private void initHiidoSdk(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, revenueConfig) == null) && mStatisAPI == null) {
            if (revenueConfig == null) {
                RLog.error("SDKReporter", "initHiidoSdk error config null", new Object[0]);
            } else if (revenueConfig.getContext() == null) {
                RLog.error("SDKReporter", "initHiidoSdk error config.getContext() null", new Object[0]);
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

    public static void reportStatisticContent(String str, StatisContent statisContent) {
        StatisAPI statisAPI;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, statisContent) == null) || (statisAPI = mStatisAPI) == null) {
            return;
        }
        statisAPI.reportStatisticContent(str, statisContent, true, true);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter
    public void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            PayFlowReporter payFlowReporter = this.mPayFlowReporter;
            if (payFlowReporter == null) {
                RLog.error("SDKReporter", "reportPayFlow mPayEventReporter null", new Object[0]);
            } else {
                payFlowReporter.reportPayFlow(str, str2, str3, str4, str5, str6, str7, str8);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter
    public void reportUiEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            PayUIReporter payUIReporter = this.mPayUIReporter;
            if (payUIReporter == null) {
                RLog.error("SDKReporter", "reportUiEvent mUiEventReporter null", new Object[0]);
            } else {
                payUIReporter.reportUIEvent(str);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter
    public void reportUvEvent(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            PayUVReporter payUVReporter = this.mPayUVReporter;
            if (payUVReporter == null) {
                RLog.error("SDKReporter", "reportProductEvent mProductEventReporter null", new Object[0]);
            } else {
                payUVReporter.report(str, str2, str3, str4);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter
    public void reportUiEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            PayUIReporter payUIReporter = this.mPayUIReporter;
            if (payUIReporter == null) {
                RLog.error("SDKReporter", "reportUiEvent mUiEventReporter null", new Object[0]);
            } else {
                payUIReporter.reportUIEvent(str, str2);
            }
        }
    }
}
