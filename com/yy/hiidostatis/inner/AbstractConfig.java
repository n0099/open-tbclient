package com.yy.hiidostatis.inner;

import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes10.dex */
public abstract class AbstractConfig {
    public static int MAX_DATA_CACHE_DAY = 62;
    public static int MAX_DATA_RETRY_TIME = 20000;
    public volatile String sdkVer;
    public volatile boolean isEncrypt = true;
    public volatile boolean isEncryptTestServer = false;
    public volatile String testServer = null;
    public volatile String urlConfigServer = "https://config.bigda.com/";
    public volatile String urlLogUpload = "https://config.bigda.com/api/upload";
    public volatile String cacheFileName = "hdcommon_module_used_file";
    public volatile boolean isAbroad = false;
    public volatile int businessType = 100;

    public int getBusinessType() {
        return this.businessType;
    }

    public String getCacheFileName() {
        return this.cacheFileName;
    }

    public String getConfigKey() {
        return getClass().getName();
    }

    public String getMetricsHost() {
        return HiidoSDK.getHiidoHost();
    }

    public String getSdkVer() {
        return this.sdkVer;
    }

    public String getTestServer() {
        return this.testServer;
    }

    public String[] getUrlAddress() {
        return HiidoSDK.getHiidoIps();
    }

    public String getUrlConfigServer() {
        return this.urlConfigServer;
    }

    public boolean isAbroad() {
        return this.isAbroad;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public boolean isEncryptTestServer() {
        return this.isEncryptTestServer;
    }

    public void setAbroad(boolean z) {
        this.isAbroad = z;
    }

    public void setActLogNamePre(String str) {
        ActLog.setLogNamePre(str);
    }

    public void setActLogUploadUrl(String str) {
        ActLog.setUploadUrl(str);
    }

    public void setBusinessType(int i) {
        this.businessType = i;
    }

    public void setDefaultPrefName(String str) {
        DefaultPreference.setPrefName(str);
    }

    public void setLogTag(String str) {
        L.setLogTag(str);
    }
}
