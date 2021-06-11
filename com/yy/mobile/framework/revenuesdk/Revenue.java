package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class Revenue implements IRevenue, IRevenueDataReceiver, IRevenueDataSender {
    public static final String TAG = "Revenue";
    public String clientVer;
    public String countryCode;
    public int currencyType;
    public String functionName;
    public IAppPayService iAppPayService;
    public SDKReporter innerReporter;
    public int mAppId;
    public ProtocolType mProtocolType = ProtocolType.UNKNOW;
    public int mUsedChannel;
    @Nullable
    public IReporter outerReporter;
    public String serviceName;
    public long uid;

    public Revenue(int i2, int i3) {
        this.mAppId = i2;
        this.mUsedChannel = i3;
        RLog.info(TAG, "construct mAppId:" + this.mAppId + " mUsedChannel:" + this.mUsedChannel);
    }

    private void createService(Context context, String str, String str2, boolean z, boolean z2) {
        this.iAppPayService = new AppPayServiceImpl(this.mAppId, this.mUsedChannel, this.countryCode, this.clientVer, str, str2, z, z2, this, this.outerReporter, this.innerReporter, this.mProtocolType);
    }

    private void initLogConfig(RevenueConfig revenueConfig) {
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

    private void initReportConfig(RevenueConfig revenueConfig) {
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

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public IAppPayService getAppPayService() {
        return this.iAppPayService;
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public ISDKReporter getSDKReporter() {
        return this.innerReporter;
    }

    public void initConfig(RevenueConfig revenueConfig) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onBroadcastData(int i2, PSCIMessageBroadcast pSCIMessageBroadcast) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i2, String str, int i3, int i4, String str2) {
        IAppPayService iAppPayService = this.iAppPayService;
        if (iAppPayService instanceof IRevenueDataReceiver) {
            ((IRevenueDataReceiver) iAppPayService).onRequestError(i2, str, i3, i4, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i2, PSCIMessageResponse pSCIMessageResponse) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onUnicastData(int i2, PSCIMessageUnicast pSCIMessageUnicast) {
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

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        RevenueConfig config = RevenueConfigCenter.getConfig(this.mAppId, this.mUsedChannel);
        if (config == null || config.getDataSender() == null) {
            return;
        }
        config.getDataSender().sendData(this.mAppId, i3, str, arrayList, bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.IRevenue
    public void updateConfig(RevenueConfig revenueConfig) {
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
