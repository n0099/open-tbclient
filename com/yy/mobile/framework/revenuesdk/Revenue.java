package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import android.os.Build;
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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IEventReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IMonitorReporter;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl;
import com.yy.mobile.framework.revenuesdk.reporter.EventReporter;
import com.yy.mobile.framework.revenuesdk.reporter.MonitorReporter;
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
    public int mAppId;
    public IEventReporter mEventReporter;
    public IMonitorReporter mMonitorReporter;
    public ProtocolType mProtocolType;
    public int mUsedChannel;
    public String serviceName;
    public long uid;

    public Revenue(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProtocolType = ProtocolType.UNKNOW;
        this.mAppId = i;
        this.mUsedChannel = i2;
        RLog.info(TAG, "create Revenue mAppId:" + this.mAppId + " mUsedChannel:" + this.mUsedChannel);
    }

    private void createService(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.iAppPayService = new AppPayServiceImpl(this.mAppId, this.mUsedChannel, this.countryCode, this.clientVer, str, str2, z, z2, this, this.mMonitorReporter, this.mEventReporter, this.mProtocolType);
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            RLog.info(TAG, "cancelAllRequest appId:" + i + " useChannel:" + i2);
            RevenueConfig config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel);
            if (config == null || config.getDataSender() == null) {
                return;
            }
            config.getDataSender().cancelAllRequest(i, i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iAppPayService : (IAppPayService) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IEventReporter getEventReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEventReporter : (IEventReporter) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IPayReporter getPayReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService == null) {
                RLog.error(TAG, "getPayReporter error iAppPayService null", new Object[0]);
                return null;
            }
            return iAppPayService.getPayRepoter();
        }
        return (IPayReporter) invokeV.objValue;
    }

    public void initConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, revenueConfig) == null) {
            if (revenueConfig != null) {
                if (revenueConfig.getDataSender() != null) {
                    this.uid = revenueConfig.getUid();
                    this.currencyType = revenueConfig.getCurrencyType();
                    this.clientVer = revenueConfig.getClientVerion();
                    this.serviceName = revenueConfig.getServiceName();
                    this.functionName = revenueConfig.getFunctionName();
                    this.mEventReporter = new EventReporter(revenueConfig);
                    this.mMonitorReporter = new MonitorReporter(revenueConfig);
                    this.countryCode = revenueConfig.getCountryCode();
                    this.mProtocolType = revenueConfig.getProtoType();
                    RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                    initLogConfig(revenueConfig);
                    RLog.info(TAG, "initConfig versionName:4.3.9-bdpay212004-SNAPSHOT config:" + revenueConfig.toString());
                    createService(revenueConfig.getContext(), this.serviceName, this.functionName, false, revenueConfig.getIsOpenRisk());
                    return;
                }
                throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
            }
            RLog.error(TAG, "initConfig versionName:4.3.9-bdpay212004-SNAPSHOT config null", new Object[0]);
            throw new IllegalArgumentException("init Revenue config == null!");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onBroadcastData(int i, PSCIMessageBroadcast pSCIMessageBroadcast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, pSCIMessageBroadcast) == null) {
            int i2 = this.mAppId;
            if (i2 != i) {
                RLog.debug(TAG, "currentAppId = %d, BroadcastData appId not match!", Integer.valueOf(i2));
                return;
            }
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onBroadcastData(i, pSCIMessageBroadcast);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
            if (this.mAppId != i) {
                RLog.debug(TAG, "onRequestError appId not match! mAppId:" + this.mAppId + " appId:" + i);
            } else if (this.mUsedChannel != i2) {
                RLog.debug(TAG, "onRequestError userchannel not match! mUsedChannel:" + this.mUsedChannel + " userchannel:" + i2);
            } else {
                IAppPayService iAppPayService = this.iAppPayService;
                if (iAppPayService instanceof IRevenueDataReceiver) {
                    ((IRevenueDataReceiver) iAppPayService).onRequestError(i, i2, str, i3, i4, str2);
                }
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, pSCIMessageResponse) == null) {
            if (this.mAppId != i) {
                RLog.debug(TAG, "onResponseData appId not match! mAppId:" + this.mAppId + " appId:" + i);
            } else if (this.mUsedChannel != i2) {
                RLog.debug(TAG, "onResponseData userchannel not match! mUsedChannel:" + this.mUsedChannel + " userchannel:" + i2);
            } else {
                IAppPayService iAppPayService = this.iAppPayService;
                if (iAppPayService instanceof IRevenueDataReceiver) {
                    ((IRevenueDataReceiver) iAppPayService).onResponseData(i, i2, pSCIMessageResponse);
                }
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onUnicastData(int i, PSCIMessageUnicast pSCIMessageUnicast) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, pSCIMessageUnicast) == null) {
            int i2 = this.mAppId;
            if (i2 != i) {
                RLog.debug(TAG, "currentAppId = %d, UnicastData appId not match!", Integer.valueOf(i2));
                return;
            }
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onUnicastData(i, pSCIMessageUnicast);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        RevenueConfig config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, bArr}) == null) || (config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel)) == null || config.getDataSender() == null) {
            return;
        }
        config.getDataSender().sendData(this.mAppId, i2, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, revenueConfig) == null) {
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
