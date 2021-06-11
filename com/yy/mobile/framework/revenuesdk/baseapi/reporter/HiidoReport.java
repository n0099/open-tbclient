package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import java.util.Random;
/* loaded from: classes7.dex */
public class HiidoReport {
    public static final String TAG = "hiidoReport";
    public static volatile HiidoReport sInstance;
    public Random random = new Random();

    /* loaded from: classes7.dex */
    public static final class CReportConfig {
        public static Float mReportRatio = Float.valueOf(1.0f);
        public static String mAppName = "";
    }

    /* loaded from: classes7.dex */
    public static final class CReportParam {
        public static String ACT = "revenuepay";
        public static int INTER_SCODE = 50319;
        public static int REVENUE_SCODE = 50552;
        public static int SUMMARY_SCODE = 50321;
    }

    /* loaded from: classes7.dex */
    public static final class CReportResponse {
        public static String mAppId = "";
        public static String mAppKey = "";
        public static String mCountry = "";
        public static String mDevice = "";
        public static String mOS = "";
        public static int mSys;
        public String mEventId = "";
        public String mErrCode = "0";
        public String mErrMsg = "";
        public long mUid = 0;
        public int mPaysource = 0;
        public int mRetry = 0;
        public String mClientver = "";
        public String mArea = "";
        public String mSdkver = "";
        public String mEventaliae = "";
        public String mAppalias = "";
        public String mNtm = "";
        public int mNet = 0;
        public String mDelay = "0";
        public String mOrderId = "";
        public String mGPOrderId = "";
        public String mPurchaseTime = "0";
        public String mServiceName = "";
        public String mFunctionName = "";
        public String mPageId = "";
        public String mConfigTraceId = "";
        public String mPayTraceId = "";
        public int mCmd = 0;
    }

    public static synchronized HiidoReport getInstance() {
        HiidoReport hiidoReport;
        synchronized (HiidoReport.class) {
            if (sInstance == null) {
                sInstance = new HiidoReport();
            }
            hiidoReport = sInstance;
        }
        return hiidoReport;
    }

    public String getSummaryUri(String str, CReportResponse cReportResponse) {
        return CReportConfig.mAppName + "/" + str;
    }

    public String getUri(String str, CReportResponse cReportResponse) {
        return CReportConfig.mAppName + "/" + str;
    }

    public boolean isReportByRandomRatio() {
        if (CReportConfig.mReportRatio.floatValue() <= 0.0f) {
            return false;
        }
        if (CReportConfig.mReportRatio.floatValue() >= 1.0f) {
            return true;
        }
        int floatValue = (int) (CReportConfig.mReportRatio.floatValue() * 100.0f);
        int nextInt = this.random.nextInt(100);
        return nextInt >= 0 && nextInt < floatValue;
    }
}
