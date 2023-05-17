package com.yy.hiidostatis.defs;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.inner.GeneralConfigTool;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ConfigAPI implements IConfigAPI {
    public GeneralConfigTool mGeneralConfigTool;

    public ConfigAPI(Context context, String str) {
        this.mGeneralConfigTool = GeneralProxy.getGeneralConfigInstance(context, HdStatisConfig.getConfig(str));
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public String getOnlineConfigs(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appkey", str);
            return this.mGeneralConfigTool.get("api/getOnlineConfig", hashMap, context, true);
        } catch (Throwable th) {
            L.debug("ConfigAPI", "getSdkVer error! %s", th);
            return null;
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getSdkListConfig(Context context, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sys", "2");
            return getConfig("api/getSdkListConfig", hashMap, context, z, true);
        } catch (Throwable th) {
            L.debug("ConfigAPI", "geSdkListConfig error! %s", th);
            return null;
        }
    }

    private JSONObject getConfig(String str, Map<String, String> map, Context context, boolean z, boolean z2) throws Exception {
        String str2;
        if (z) {
            str2 = this.mGeneralConfigTool.getCache(str, map, context, z2);
        } else {
            str2 = this.mGeneralConfigTool.get(str, map, context, z2);
        }
        if (str2 != null && str2.length() != 0) {
            return new JSONObject(str2);
        }
        return null;
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getAppListConfig(Context context, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sys", "2");
            String imei = CommonFiller.getIMEI(context);
            if (imei == null || imei.isEmpty()) {
                imei = DeviceProxy.getHdid(context);
            }
            hashMap.put("mid", imei);
            return getConfig("api/getAppConfig", hashMap, context, z, true);
        } catch (Throwable th) {
            L.debug("ConfigAPI", "getAppListConfig error! %s", th);
            return null;
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getSdkVer(Context context, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("sys", "2");
            hashMap.put("type", "11");
            hashMap.put("ver", this.mGeneralConfigTool.getConfig().getSdkVer());
            return getConfig("api/getSdkVer", hashMap, context, z, false);
        } catch (Throwable th) {
            L.debug("ConfigAPI", "getSdkVer error! %s", th);
            return null;
        }
    }

    public JSONObject getDeviceConfig(Context context, String str, String str2, long j, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appkey", str);
            hashMap.put("sys", "2");
            if (str2 != null) {
                hashMap.put("deviceid", str2);
            }
            hashMap.put("uid", j + "");
            return getConfig("api/getDeviceConfig", hashMap, context, z, true);
        } catch (Throwable th) {
            L.debug("ConfigAPI", "getDeviceConfig error! %s", th);
            return null;
        }
    }
}
