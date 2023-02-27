package com.yy.mobile.framework.revenuesdk.statistics;

import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.HiidoConstantContent;
/* loaded from: classes9.dex */
public class HiidoSDKApi {
    public static final String TAG = "HiidoSDKApi";
    public static StatisAPI mStatisAPI;

    public static void initHiidoSdk(RevenueConfig revenueConfig) {
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

    public static void reportCount(int i, String str, String str2, long j) {
        StatisAPI statisAPI = mStatisAPI;
        if (statisAPI == null) {
            RLog.error(TAG, "reportCount error mStatisAPI null", new Object[0]);
        } else {
            statisAPI.reportCount(i, str, str2, j);
        }
    }

    public static void reportReturnCode(int i, String str, long j, String str2) {
        if (mStatisAPI == null) {
            RLog.error(TAG, "reportReturnCode error mStatisAPI null", new Object[0]);
            return;
        }
        RLog.debug(TAG, "reportReturnCode uri:" + str);
        mStatisAPI.reportReturnCode(i, str, j, str2, null);
    }

    public static void reportCount(int i, String str, String str2, long j, int i2) {
        StatisAPI statisAPI = mStatisAPI;
        if (statisAPI == null) {
            RLog.error(TAG, "reportCount error mStatisAPI null", new Object[0]);
        } else {
            statisAPI.reportCount(i, str, str2, j);
        }
    }

    public static void reportStatisticContent(String str, StatisContent statisContent) {
        if (mStatisAPI == null) {
            RLog.error(TAG, "reportStatisticContent error mStatisAPI null", new Object[0]);
            return;
        }
        RLog.debug(TAG, "reportStatisticContent content:" + statisContent);
        mStatisAPI.reportStatisticContent(str, statisContent, true, true);
    }
}
