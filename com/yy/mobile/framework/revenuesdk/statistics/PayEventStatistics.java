package com.yy.mobile.framework.revenuesdk.statistics;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.utils.MD5Utils;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
/* loaded from: classes8.dex */
public class PayEventStatistics implements IPayEventStatistics {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public IPayFlowEventContent mPayFlowEventContentImpl;
    public IPayUIEventContent mPayUIEventContentImpl;
    public IPayUVEventContent mPayUVEventContentImpl;

    /* loaded from: classes8.dex */
    public interface IPayFlowEventContent {
        void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    /* loaded from: classes8.dex */
    public interface IPayUIEventContent {
        void reportUIEvent(String str);

        void reportUIEvent(String str, String str2);
    }

    /* loaded from: classes8.dex */
    public interface IPayUVEventContent {
        void report(String str, String str2, String str3, String str4);
    }

    public PayEventStatistics(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {revenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayEventStatistics";
        initHiidoConstantContent(revenueConfig);
        HiidoSDKApi.initHiidoSdk(revenueConfig);
        BaseHiidoContent createBaseContent = createBaseContent(revenueConfig);
        if (createBaseContent == null) {
            RLog.error("PayEventStatistics", "new SDKReporter error baseHiidoContent null", new Object[0]);
            return;
        }
        this.mPayUIEventContentImpl = new PayUIEventContentImpl(createBaseContent);
        this.mPayFlowEventContentImpl = new PayFlowEventContentImpl(createBaseContent);
        this.mPayUVEventContentImpl = new PayUVEventContentImpl(createBaseContent);
    }

    private BaseHiidoContent createBaseContent(RevenueConfig revenueConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, revenueConfig)) == null) {
            if (revenueConfig == null) {
                RLog.error("PayEventStatistics", "createBaseContent config null", new Object[0]);
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
                RLog.error("PayEventStatistics", "initHiidoConstantContent config null", new Object[0]);
                return;
            }
            HiidoConstantContent.mClientVer = revenueConfig.getClientVerion();
            HiidoConstantContent.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            HiidoConstantContent.mMBOS = sb.toString();
            HiidoConstantContent.mPackage = revenueConfig.getAppName();
            HiidoConstantContent.mSdkVer = BuildConfig.VERSION_NAME;
            HiidoConstantContent.mOpenId = MD5Utils.getMD5String(String.valueOf(revenueConfig.getUid()));
            HiidoConstantContent.mUserType = revenueConfig.getAuthType() == 4 ? "1" : "2";
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics
    public void reportPayFlowEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            IPayFlowEventContent iPayFlowEventContent = this.mPayFlowEventContentImpl;
            if (iPayFlowEventContent == null) {
                RLog.error("PayEventStatistics", "reportPayFlow mPayEventReporter null", new Object[0]);
            } else {
                iPayFlowEventContent.reportPayFlow(str, str2, str3, str4, str5, str6, str7, str8);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics
    public void reportUiEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            IPayUIEventContent iPayUIEventContent = this.mPayUIEventContentImpl;
            if (iPayUIEventContent == null) {
                RLog.error("PayEventStatistics", "reportUiEvent mUiEventReporter null", new Object[0]);
            } else {
                iPayUIEventContent.reportUIEvent(str);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics
    public void reportUvEvent(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            IPayUVEventContent iPayUVEventContent = this.mPayUVEventContentImpl;
            if (iPayUVEventContent == null) {
                RLog.error("PayEventStatistics", "reportProductEvent mProductEventReporter null", new Object[0]);
            } else {
                iPayUVEventContent.report(str, str2, str3, str4);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics
    public void reportUiEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            IPayUIEventContent iPayUIEventContent = this.mPayUIEventContentImpl;
            if (iPayUIEventContent == null) {
                RLog.error("PayEventStatistics", "reportUiEvent mUiEventReporter null", new Object[0]);
            } else {
                iPayUIEventContent.reportUIEvent(str, str2);
            }
        }
    }
}
