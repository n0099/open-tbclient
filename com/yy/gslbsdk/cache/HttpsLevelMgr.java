package com.yy.gslbsdk.cache;

import com.yy.gslbsdk.control.SwitchController;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HttpsLevelMgr {
    public static final String TAG = "HttpsLevelMgr";
    public static HttpsLevelMgr sInstance;

    public static HttpsLevelMgr getInstance() {
        if (sInstance == null) {
            sInstance = new HttpsLevelMgr();
        }
        return sInstance;
    }

    public String[] request() {
        String str = GlobalTools.ACCOUNT_ID;
        if (str == null) {
            str = "";
        }
        String str2 = GlobalTools.APP_DEV_ID;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = GlobalTools.APP_LOCALIZE_CODE;
        String str4 = str3 != null ? str3 : "";
        String identity = DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
        HashMap hashMap = new HashMap();
        hashMap.put("host", GlobalTools.HTTPDNS_SERVER_HOST);
        hashMap.put("p", "a");
        hashMap.put("devid", str2);
        hashMap.put("gslbid", identity);
        hashMap.put("appid", str);
        hashMap.put("version", "2.2.18-lianyun");
        boolean z = true;
        if (GlobalTools.IS_TEST_ENV && !GlobalTools.HTTPDNS_SERVER_HOST.equals(GlobalTools.HTTPDNS_HOST_TEST)) {
            z = false;
        }
        if (z) {
            return HTTPMgr.postSniHttps("https://" + GlobalTools.HTTPDNS_SERVER_HOST + "/https_level?appid=" + str + "&usercfg=" + str4, GlobalTools.HTTPDNS_SERVER_HOST, null, hashMap);
        }
        return HTTPMgr.postHttp("http://" + GlobalTools.HTTPDNS_SERVER_HOST + "/https_level?appid=" + str + "&usercfg=" + str4, null, hashMap);
    }

    public int response(String str) {
        if (str == null || str.length() < 1) {
            return 5;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("s") != 0) {
                SwitchController.getInstance().deal(1);
                return 3;
            }
            int i2 = jSONObject.getInt("level");
            SwitchController.getInstance().deal(i2);
            if (i2 >= 0 && 2 >= i2) {
                setHttpsLevel(i2);
                return 0;
            }
            return 3;
        } catch (Exception e2) {
            LogTools.printWarning(TAG, e2);
            return 3;
        }
    }

    public void setHttpsLevel(int i2) {
        if (i2 < 0 || i2 > 2 || i2 <= GlobalTools.HTTPS_LEVEL) {
            return;
        }
        GlobalTools.HTTPS_LEVEL = i2;
    }

    public int update() {
        ThreadInfo threadInfo = new ThreadInfo("HttpsLevelUpdate");
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.cache.HttpsLevelMgr.1
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str) {
                String[] request = HttpsLevelMgr.this.request();
                if (request == null) {
                    SwitchController.getInstance().deal(1);
                } else {
                    HttpsLevelMgr.this.response(request[1]);
                }
            }
        });
        ThreadPoolMgr.getInstance().addTask(threadInfo);
        return 0;
    }
}
