package com.yy.mobile.framework.revenuesdk;

import android.os.Build;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayMetricsStatisticsApi;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.statistics.IPayServiceStatisticsApi;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.AppPayServiceImpl;
import com.yy.mobile.framework.revenuesdk.statistics.PayEventStatisticsApiImpl;
import com.yy.mobile.framework.revenuesdk.statistics.PayMetricsStatisticsApiImpl;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class Revenue implements IRevenue, IRevenueDataReceiver, IRevenueDataSender {
    public static final String TAG = "Revenue";
    public int mAppId;
    public IAppPayService mAppPayService;
    public IPayEventStatisticsApi mPayEventStatistics;
    public IPayMetricsStatisticsApi mPayMetricsStatistics;
    public ProtocolType mProtocolType = ProtocolType.UNKNOW;
    public int mUsedChannel;

    public Revenue(int i, int i2) {
        this.mAppId = i;
        this.mUsedChannel = i2;
        RLog.info(TAG, "create Revenue mAppId:" + this.mAppId + " mUsedChannel:" + this.mUsedChannel);
    }

    private void initLogConfig(RevenueConfig revenueConfig) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i, int i2) {
        RLog.info(TAG, "cancelAllRequest appId:" + i + " useChannel:" + i2);
        RevenueConfig config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel);
        if (config != null && config.getDataSender() != null) {
            config.getDataSender().cancelAllRequest(i, i2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.mAppPayService;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IPayEventStatisticsApi getPayEventStatisticApi() {
        return this.mPayEventStatistics;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IPayServiceStatisticsApi getPayServiceStatisticsApi() {
        IAppPayService iAppPayService = this.mAppPayService;
        if (iAppPayService == null) {
            RLog.error(TAG, "getPayServiceStatistics error iAppPayService null", new Object[0]);
            return null;
        }
        return iAppPayService.getPayServiceStatistics();
    }

    public String toString() {
        return TAG + hashCode();
    }

    public void initConfig(RevenueConfig revenueConfig) {
        if (revenueConfig != null) {
            if (revenueConfig.getDataSender() != null) {
                this.mPayEventStatistics = new PayEventStatisticsApiImpl(revenueConfig);
                this.mPayMetricsStatistics = new PayMetricsStatisticsApiImpl(revenueConfig);
                this.mProtocolType = revenueConfig.getProtoType();
                RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
                initLogConfig(revenueConfig);
                RLog.info(TAG, "initConfig versionName:4.3.47-bdpay config:" + revenueConfig.toString());
                this.mAppPayService = new AppPayServiceImpl(this.mAppId, this.mUsedChannel, false, this, this.mPayMetricsStatistics, this.mPayEventStatistics, this.mProtocolType);
                return;
            }
            throw new IllegalArgumentException("Data Sender == null,Revenue init fail!");
        }
        RLog.error(TAG, "initConfig versionName:4.3.47-bdpay config null", new Object[0]);
        throw new IllegalArgumentException("init Revenue config == null!");
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        if (this.mAppId != i) {
            RLog.debug(TAG, "onRequestError appId not match! mAppId:" + this.mAppId + " appId:" + i);
        } else if (this.mUsedChannel != i2) {
            RLog.debug(TAG, "onRequestError userchannel not match! mUsedChannel:" + this.mUsedChannel + " userchannel:" + i2);
        } else {
            IAppPayService iAppPayService = this.mAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onRequestError(i, i2, str, i3, i4, str2);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse) {
        if (this.mAppId != i) {
            RLog.debug(TAG, "onResponseData appId not match! mAppId:" + this.mAppId + " appId:" + i);
        } else if (this.mUsedChannel != i2) {
            RLog.debug(TAG, "onResponseData userchannel not match! mUsedChannel:" + this.mUsedChannel + " userchannel:" + i2);
        } else {
            IAppPayService iAppPayService = this.mAppPayService;
            if (iAppPayService instanceof IRevenueDataReceiver) {
                ((IRevenueDataReceiver) iAppPayService).onResponseData(i, i2, pSCIMessageResponse);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        RevenueConfig config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel);
        if (config != null && config.getDataSender() != null) {
            config.getDataSender().sendData(this.mAppId, i2, str, arrayList, bArr);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
        if (revenueConfig != null) {
            RevenueConfigCenter.addConfig(this.mAppId, this.mUsedChannel, revenueConfig);
            if (revenueConfig.getDataSender() != null) {
                return;
            }
            throw new IllegalArgumentException("Data Sender == null,Revenue update fail!");
        }
        throw new IllegalArgumentException("update Revenue config == null!");
    }
}
