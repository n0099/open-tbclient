package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.android.imsdk.IMConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes7.dex */
public class Env {
    public String[] BACKUP_DOMAIN_POOL;
    public final String PRODUCE_REVENUE_HTTP_URL;
    public String REVENUE_HTTP_REPORT_TAG;
    public String REVENUE_HTTP_URL;
    public int SERVICE_REVENUE;
    public String SERVICE_REVENUE_REPORT_TAG;
    public final String TAG;
    public final String TEST_REVENUE_HTTP_URL;
    public final long YY_REQUEST_HREADER_URI;
    public final long YY_RESPONSE_HREADER_URI;
    public boolean isTestEnv;

    /* loaded from: classes7.dex */
    public static class Holder {
        public static final Env instance = new Env();
    }

    public static Env instance() {
        return Holder.instance;
    }

    public synchronized void init(boolean z) {
        this.isTestEnv = z;
        this.SERVICE_REVENUE = z ? IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL : 30079;
        this.SERVICE_REVENUE_REPORT_TAG = this.SERVICE_REVENUE + "";
        RLog.debug("Revenue-Env", "SERVICE_REVENUE_REPORT_TAG:" + this.SERVICE_REVENUE_REPORT_TAG);
        this.REVENUE_HTTP_URL = this.isTestEnv ? "https://turnover-pre.yy.com" : "https://turnover.yy.com";
        RLog.debug("Revenue-Env", "REVENUE_HTTP_REPORT_TAG:" + this.REVENUE_HTTP_REPORT_TAG);
    }

    public boolean isTestEnv() {
        return this.isTestEnv;
    }

    public Env() {
        this.TAG = "Revenue-Env";
        this.SERVICE_REVENUE = IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL;
        this.SERVICE_REVENUE_REPORT_TAG = "";
        this.YY_REQUEST_HREADER_URI = 4041273699L;
        this.YY_RESPONSE_HREADER_URI = 4040225123L;
        this.REVENUE_HTTP_URL = "";
        this.REVENUE_HTTP_REPORT_TAG = "";
        this.TEST_REVENUE_HTTP_URL = "https://turnover-pre.yy.com";
        this.PRODUCE_REVENUE_HTTP_URL = "https://turnover.yy.com";
        this.BACKUP_DOMAIN_POOL = new String[]{"https://api-turnover.zhiniu8.com", "https://turnover.myzhiniu.com"};
        RLog.debug("Revenue-Env", " env init()");
    }
}
