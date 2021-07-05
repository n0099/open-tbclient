package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageBroadcast;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageUnicast;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ISDKReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl;
import com.yy.mobile.framework.revenuesdk.reporter.SDKReporter;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class Revenue implements IRevenue, IRevenueDataReceiver, IRevenueDataSender {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Revenue";
    public transient /* synthetic */ FieldHolder $fh;
    public String clientVer;
    public String countryCode;
    public int currencyType;
    public String functionName;
    public IAppPayService iAppPayService;
    public SDKReporter innerReporter;
    public int mAppId;
    public ProtocolType mProtocolType;
    public int mUsedChannel;
    @Nullable
    public IReporter outerReporter;
    public String serviceName;
    public long uid;

    public Revenue(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProtocolType = ProtocolType.UNKNOW;
        this.mAppId = i2;
        this.mUsedChannel = i3;
        RLog.info(TAG, "construct mAppId:" + this.mAppId + " mUsedChannel:" + this.mUsedChannel);
    }

    private void createService(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.iAppPayService = new AppPayServiceImpl(this.mAppId, this.mUsedChannel, this.countryCode, this.clientVer, str, str2, z, z2, this, this.outerReporter, this.innerReporter, this.mProtocolType);
        }
    }

    private void initLogConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, revenueConfig) == null) {
            CloudLogUtil.mAppId = String.valueOf(this.mAppId);
            CloudLogUtil.mAppName = revenueConfig.getReportConfig().getAppName();
            CloudLogUtil.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            CloudLogUtil.mOS = sb.toString();
            CloudLogUtil.mClientVer = revenueConfig.getClientVerion();
            CloudLogUtil.mUid = XorUtil.encode(String.valueOf(revenueConfig.getUid()));
            CloudLogUtil.mSdkVersion = BuildConfig.VERSION_NAME;
            CloudLogUtil.mDeviceId = revenueConfig.getReportConfig().getDeviceId();
        }
    }

    private void initReportConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, revenueConfig) == null) {
            HiidoReport.CReportResponse.mAppId = String.valueOf(this.mAppId);
            HiidoReport.CReportResponse.mSys = 2;
            HiidoReport.CReportResponse.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            HiidoReport.CReportResponse.mOS = sb.toString();
            HiidoReport.CReportResponse.mCountry = revenueConfig.getCountryCode();
            HiidoReport.CReportConfig.mReportRatio = Float.valueOf(revenueConfig.getReportConfig().getReportRatio());
            HiidoReport.CReportConfig.mAppName = revenueConfig.getReportConfig().getAppName();
            RLog.debug(TAG, "ReportRatio:" + HiidoReport.CReportConfig.mReportRatio);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.iAppPayService : (IAppPayService) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public ISDKReporter getSDKReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.innerReporter : (ISDKReporter) invokeV.objValue;
    }

    public void initConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, revenueConfig) == null) {
            if (revenueConfig != null) {
                if (revenueConfig.getDataSender() != null) {
                    this.uid = revenueConfig.getUid();
                    this.currencyType = revenueConfig.getCurrencyType();
                    this.clientVer = revenueConfig.getClientVerion();
                    this.serviceName = revenueConfig.getServiceName();
                    this.functionName = revenueConfig.getFunctionName();
                    this.outerReporter = revenueConfig.getReportConfig().getReporter();
                    this.innerReporter = new SDKReporter(revenueConfig);
                    this.countryCode = revenueConfig.getCountryCode();
                    this.mProtocolType = revenueConfig.getProtoType();
                    RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                    initReportConfig(revenueConfig);
                    initLogConfig(revenueConfig);
                    RLog.info(TAG, "initConfig -> versionName:4.2.20-bdpay config:" + revenueConfig.toString());
                    createService(revenueConfig.getContext(), this.serviceName, this.functionName, false, revenueConfig.getIsOpenRisk());
                    return;
                }
                throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
            }
            RLog.error(TAG, "initConfig -> versionName:4.2.20-bdpay config null", new Object[0]);
            throw new IllegalArgumentException("init Revenue config == null!");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onBroadcastData(int i2, PSCIMessageBroadcast pSCIMessageBroadcast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, pSCIMessageBroadcast) == null) {
            int i3 = this.mAppId;
            if (i3 != i2) {
                RLog.debug(TAG, "currentAppId = %d, BroadcastData appId not match!", Integer.valueOf(i3));
                return;
            }
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onBroadcastData(i2, pSCIMessageBroadcast);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onRequestError(i2, str, i3, i4, str2);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i2, PSCIMessageResponse pSCIMessageResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, pSCIMessageResponse) == null) {
            int i3 = this.mAppId;
            if (i3 != i2) {
                RLog.debug(TAG, "currentAppId = %d, ResponseData appId not match!", Integer.valueOf(i3));
                return;
            }
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onResponseData(i2, pSCIMessageResponse);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onUnicastData(int i2, PSCIMessageUnicast pSCIMessageUnicast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, pSCIMessageUnicast) == null) {
            int i3 = this.mAppId;
            if (i3 != i2) {
                RLog.debug(TAG, "currentAppId = %d, UnicastData appId not match!", Integer.valueOf(i3));
                return;
            }
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onUnicastData(i2, pSCIMessageUnicast);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        RevenueConfig config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, arrayList, bArr}) == null) || (config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel)) == null || config.getDataSender() == null) {
            return;
        }
        config.getDataSender().sendData(this.mAppId, i3, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, revenueConfig) == null) {
            if (revenueConfig != null) {
                RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                if (revenueConfig.getDataSender() != null) {
                    this.countryCode = revenueConfig.getCountryCode();
                    this.uid = revenueConfig.getUid();
                    HiidoReport.CReportResponse.mCountry = this.countryCode;
                    return;
                }
                throw new IllegalArgumentException("Data Sender == null,Revenue update fail!");
            }
            throw new IllegalArgumentException("update Revenue config == null!");
        }
    }
}
