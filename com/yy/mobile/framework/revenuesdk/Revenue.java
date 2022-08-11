package com.yy.mobile.framework.revenuesdk;

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
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatistics;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatistics;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatistics;
import com.yy.mobile.framework.revenuesdk.statistics.PayMetricsStatistics;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class Revenue implements IRevenue, IRevenueDataReceiver, IRevenueDataSender {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Revenue";
    public transient /* synthetic */ FieldHolder $fh;
    public IAppPayService iAppPayService;
    public int mAppId;
    public IPayEventStatistics mPayEventStatistics;
    public IPayMetricsStatistics mPayMetricsStatistics;
    public ProtocolType mProtocolType;
    public int mUsedChannel;

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

    private void initLogConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, revenueConfig) == null) {
            CloudLogUtil.mAppId = String.valueOf(this.mAppId);
            CloudLogUtil.mAppName = revenueConfig.getAppName();
            CloudLogUtil.mDevice = Build.MANUFACTURER + "_" + Build.MODEL;
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append(Build.VERSION.RELEASE);
            CloudLogUtil.mOS = sb.toString();
            CloudLogUtil.mClientVer = revenueConfig.getClientVerion();
            CloudLogUtil.mUid = XorUtil.encode(String.valueOf(revenueConfig.getUid()));
            CloudLogUtil.mSdkVersion = BuildConfig.VERSION_NAME;
            CloudLogUtil.mDeviceId = revenueConfig.getDeviceId();
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
    public IPayEventStatistics getPayEventStatistic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPayEventStatistics : (IPayEventStatistics) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IPayServiceStatistics getPayServiceStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IAppPayService iAppPayService = this.iAppPayService;
            if (iAppPayService == null) {
                RLog.error(TAG, "getPayServiceStatistics error iAppPayService null", new Object[0]);
                return null;
            }
            return iAppPayService.getPayServiceStatistics();
        }
        return (IPayServiceStatistics) invokeV.objValue;
    }

    public void initConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, revenueConfig) == null) {
            if (revenueConfig != null) {
                if (revenueConfig.getDataSender() != null) {
                    this.mPayEventStatistics = new PayEventStatistics(revenueConfig);
                    this.mPayMetricsStatistics = new PayMetricsStatistics(revenueConfig);
                    this.mProtocolType = revenueConfig.getProtoType();
                    RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                    initLogConfig(revenueConfig);
                    RLog.info(TAG, "initConfig versionName:4.3.30-bdpay-fix.2-SNAPSHOT config:" + revenueConfig.toString());
                    this.iAppPayService = new AppPayServiceImpl(this.mAppId, this.mUsedChannel, false, this, this.mPayMetricsStatistics, this.mPayEventStatistics, this.mProtocolType);
                    return;
                }
                throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
            }
            RLog.error(TAG, "initConfig versionName:4.3.30-bdpay-fix.2-SNAPSHOT config null", new Object[0]);
            throw new IllegalArgumentException("init Revenue config == null!");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
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
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, pSCIMessageResponse) == null) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        RevenueConfig config;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, bArr}) == null) || (config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel)) == null || config.getDataSender() == null) {
            return;
        }
        config.getDataSender().sendData(this.mAppId, i2, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, revenueConfig) == null) {
            if (revenueConfig != null) {
                RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                if (revenueConfig.getDataSender() == null) {
                    throw new IllegalArgumentException("Data Sender == null,Revenue update fail!");
                }
                return;
            }
            throw new IllegalArgumentException("update Revenue config == null!");
        }
    }
}
