package com.yy.mobile.framework.revenuesdk.statistics;

import android.os.Build;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.payservice.utils.MD5Utils;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
/* loaded from: classes2.dex */
public class PayEventStatisticsApiImpl implements IPayEventStatisticsApi {
    public final String TAG = "PayEventStatisticsApiImpl";
    public IPayFlowEventStatisticApi mPayFlowEventStatisticApi;
    public IPayUIEventStatisticApi mPayUIEventStatisticApi;
    public IPayUVEventStatisticApi mPayUVEventStatisticApi;

    /* loaded from: classes2.dex */
    public interface IPayFlowEventStatisticApi {
        void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);
    }

    /* loaded from: classes2.dex */
    public interface IPayUIEventStatisticApi {
        void reportUIEvent(String str);

        void reportUIEvent(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface IPayUVEventStatisticApi {
        void reportUVEvent(String str, String str2, String str3, String str4);
    }

    public PayEventStatisticsApiImpl(RevenueConfig revenueConfig) {
        initHiidoConstantContent(revenueConfig);
        HiidoSDKApi.initHiidoSdk(revenueConfig);
        BaseHiidoContent createBaseContent = createBaseContent(revenueConfig);
        if (createBaseContent == null) {
            RLog.error("PayEventStatisticsApiImpl", "new SDKReporter error baseHiidoContent null", new Object[0]);
            return;
        }
        this.mPayUIEventStatisticApi = new PayUIEventStatisticApiImpl(createBaseContent);
        this.mPayFlowEventStatisticApi = new PayFlowEventStatisticApiImpl(createBaseContent);
        this.mPayUVEventStatisticApi = new PayUVEventStatisticApiImpl(createBaseContent);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi
    public void reportUiEvent(String str) {
        IPayUIEventStatisticApi iPayUIEventStatisticApi = this.mPayUIEventStatisticApi;
        if (iPayUIEventStatisticApi == null) {
            RLog.error("PayEventStatisticsApiImpl", "reportUiEvent mUiEventReporter null", new Object[0]);
        } else {
            iPayUIEventStatisticApi.reportUIEvent(str);
        }
    }

    private BaseHiidoContent createBaseContent(RevenueConfig revenueConfig) {
        if (revenueConfig == null) {
            RLog.error("PayEventStatisticsApiImpl", "createBaseContent config null", new Object[0]);
            return null;
        }
        BaseHiidoContent.BaseHiidoContentBuilder act = new BaseHiidoContent.BaseHiidoContentBuilder().setAct(HiidoConstantContent.ACT_LPF_REVENUE_PAY_ORIGINAL);
        BaseHiidoContent.BaseHiidoContentBuilder appId = act.setAppId(revenueConfig.getAppId() + "");
        return appId.setUseChannel(revenueConfig.getUsedChannel() + "").setUid(XorUtil.encode(String.valueOf(revenueConfig.getUid()))).build();
    }

    private void initHiidoConstantContent(RevenueConfig revenueConfig) {
        String str;
        if (revenueConfig == null) {
            RLog.error("PayEventStatisticsApiImpl", "initHiidoConstantContent config null", new Object[0]);
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
        if (revenueConfig.getAuthType() == 4) {
            str = "1";
        } else {
            str = "2";
        }
        HiidoConstantContent.mUserType = str;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi
    public void reportPayFlowEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        IPayFlowEventStatisticApi iPayFlowEventStatisticApi = this.mPayFlowEventStatisticApi;
        if (iPayFlowEventStatisticApi == null) {
            RLog.error("PayEventStatisticsApiImpl", "reportPayFlow1 mPayEventReporter null", new Object[0]);
        } else {
            iPayFlowEventStatisticApi.reportPayFlow(str, str2, str3, str4, str5, str6, str7, str8);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi
    public void reportPayFlowEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        IPayFlowEventStatisticApi iPayFlowEventStatisticApi = this.mPayFlowEventStatisticApi;
        if (iPayFlowEventStatisticApi == null) {
            RLog.error("PayEventStatisticsApiImpl", "reportPayFlow2 mPayEventReporter null", new Object[0]);
        } else {
            iPayFlowEventStatisticApi.reportPayFlow(str, str2, str3, str4, str5, str6, str7, str8, str9);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi
    public void reportUiEvent(String str, String str2) {
        IPayUIEventStatisticApi iPayUIEventStatisticApi = this.mPayUIEventStatisticApi;
        if (iPayUIEventStatisticApi == null) {
            RLog.error("PayEventStatisticsApiImpl", "reportUiEvent mUiEventReporter null", new Object[0]);
        } else {
            iPayUIEventStatisticApi.reportUIEvent(str, str2);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi
    public void reportUvEvent(String str, String str2, String str3, String str4) {
        IPayUVEventStatisticApi iPayUVEventStatisticApi = this.mPayUVEventStatisticApi;
        if (iPayUVEventStatisticApi == null) {
            RLog.error("PayEventStatisticsApiImpl", "reportProductEvent mProductEventReporter null", new Object[0]);
        } else {
            iPayUVEventStatisticApi.reportUVEvent(str, str2, str3, str4);
        }
    }
}
