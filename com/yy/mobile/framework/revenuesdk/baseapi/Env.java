package com.yy.mobile.framework.revenuesdk.baseapi;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes9.dex */
public class Env {
    public String[] BACKUP_DOMAIN_POOL;
    public final String PRODUCE_REVENUE_HTTP_URL;
    public String REVENUE_HTTP_URL;
    public int SERVICE_REVENUE;
    public final String TAG;
    public String TEST_REVENUE_HTTP_URL;
    public final long YY_REQUEST_HREADER_URI;
    public final long YY_RESPONSE_HREADER_URI;
    public boolean isTestEnv;

    /* loaded from: classes9.dex */
    public static class Holder {
        public static final Env instance = new Env();
    }

    public Env() {
        this.TAG = "Revenue-Env";
        this.SERVICE_REVENUE = IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL;
        this.YY_REQUEST_HREADER_URI = 4041273699L;
        this.YY_RESPONSE_HREADER_URI = 4040225123L;
        this.REVENUE_HTTP_URL = "";
        this.TEST_REVENUE_HTTP_URL = "https://turnover-pre.yy.com";
        this.PRODUCE_REVENUE_HTTP_URL = "https://turnover.yy.com";
        this.BACKUP_DOMAIN_POOL = new String[]{"https://api-turnover.zhiniu8.com", "https://turnover.myzhiniu.com"};
        RLog.debug("Revenue-Env", " env init()");
    }

    public static Env instance() {
        return Holder.instance;
    }

    public boolean isTestEnv() {
        return this.isTestEnv;
    }

    public synchronized void init(boolean z, String str) {
        int i;
        String str2;
        RLog.info("Revenue-Env", "init isTestEnv:" + z + " testUrl:" + str);
        this.isTestEnv = z;
        if (z) {
            i = IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL;
        } else {
            i = 30079;
        }
        this.SERVICE_REVENUE = i;
        if (!TextUtils.isEmpty(str)) {
            this.TEST_REVENUE_HTTP_URL = str;
        }
        if (this.isTestEnv) {
            str2 = this.TEST_REVENUE_HTTP_URL;
        } else {
            str2 = "https://turnover.yy.com";
        }
        this.REVENUE_HTTP_URL = str2;
        RLog.info("Revenue-Env", "init REVENUE_HTTP_URL:" + this.REVENUE_HTTP_URL);
    }
}
