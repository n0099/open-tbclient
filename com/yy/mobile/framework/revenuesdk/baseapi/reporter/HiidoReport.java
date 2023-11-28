package com.yy.mobile.framework.revenuesdk.baseapi.reporter;
/* loaded from: classes2.dex */
public class HiidoReport {
    public static volatile HiidoReport sInstance;

    /* loaded from: classes2.dex */
    public static final class CReportParam {
        public static int REVENUE_SCODE = 50552;
    }

    /* loaded from: classes2.dex */
    public static final class CReportResponse {
        public String mEventId = "";
        public String mErrCode = "0";
        public String mErrMsg = "";
        public long mUid = 0;
        public int mPaysource = 0;
        public String mEventaliae = "";
        public String mDelay = "0";
        public String mOrderId = "";
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

    public String getRevenueUri(int i, int i2, String str) {
        return "paysdk/android/cmd_" + str + "/" + i + "/" + i2;
    }
}
