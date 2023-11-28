package com.yy.hiidostatis.pref;

import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.message.log.TraceLog;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class HdStatisConfig extends AbstractConfig {
    public static final String META_DATA_KEY_APP_KEY = "HIIDO_APPKEY";
    public static final String META_DATA_KEY_CHANNEL = "HIIDO_CHANNEL";
    public static final String PREF_CPAGE = "PREF_CPAGE";
    public static final String SDK_TYPE = "11";
    public static Hashtable<String, AbstractConfig> table = new Hashtable<>();
    public String mAppkey;

    @Override // com.yy.hiidostatis.inner.AbstractConfig
    public String getConfigKey() {
        return this.mAppkey;
    }

    public HdStatisConfig(String str) {
        this.mAppkey = null;
        this.mAppkey = str;
        this.isEncrypt = true;
        this.isEncryptTestServer = false;
        this.testServer = null;
        this.urlConfigServer = "https://config.bigda.com/";
        this.urlLogUpload = "https://config.bigda.com/api/upload";
        this.cacheFileName = "hdstatis_cache_" + str;
        this.sdkVer = "3.5.23";
        setDefaultPrefName("hd_default_pref");
        setActLogNamePre(TraceLog.LOG_FILE_SUB_PATH);
        setActLogUploadUrl(this.urlLogUpload);
    }

    public static AbstractConfig getConfig(String str) {
        if (str != null && table.size() <= 100) {
            if (str.length() > 8) {
                str = str.substring(0, 8);
            }
        } else {
            str = "def_appkey";
        }
        if (!table.containsKey(str)) {
            table.put(str, new HdStatisConfig(str));
        }
        return table.get(str);
    }

    public void setTestServer(String str) {
        this.testServer = str;
    }
}
