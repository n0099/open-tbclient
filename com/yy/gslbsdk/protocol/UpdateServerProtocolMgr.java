package com.yy.gslbsdk.protocol;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UpdateServerProtocolMgr {
    public static final String TAG = "UpdateServerProtocolMgr";

    public static int translateErrCode(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? 8 : 7;
                    }
                    return 5;
                }
                return 6;
            }
            return 4;
        }
        return 0;
    }

    public static String[] requestProtocol(String str, boolean z) {
        String str2 = GlobalTools.APP_LOCALIZE_CODE;
        str2 = (str2 == null || str2.trim().length() < 1) ? "" : "";
        if (IpVersionController.tellIpVer(str) == 6) {
            str = PreferencesUtil.LEFT_MOUNT + str + PreferencesUtil.RIGHT_MOUNT;
        }
        String str3 = str + "/srv_query_v2?usercfg=" + str2;
        HashMap hashMap = new HashMap();
        hashMap.put("host", GlobalTools.HTTPDNS_SERVER_HOST);
        hashMap.put("p", "a");
        hashMap.put("devid", GlobalTools.APP_DEV_ID);
        hashMap.put("gslbid", DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT));
        hashMap.put("appid", GlobalTools.ACCOUNT_ID);
        hashMap.put("version", "2.2.28-live");
        if (z) {
            return HTTPMgr.getHttps("https://" + str3, GlobalTools.HTTPDNS_SERVER_HOST, hashMap);
        }
        return HTTPMgr.getHttp("http://" + str3, hashMap);
    }

    public static int responseProtocol(String str, LinkedHashMap<Integer, UpdateServerInfo> linkedHashMap) {
        if (str != null && linkedHashMap != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int translateErrCode = translateErrCode(jSONObject.getInt("s"));
                int i = jSONObject.getInt("ver");
                JSONArray jSONArray = jSONObject.getJSONArray(DnsCacheHelper.DIR_NAME);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    int i3 = jSONObject2.getInt("v");
                    if (!linkedHashMap.containsKey(Integer.valueOf(i3))) {
                        UpdateServerInfo updateServerInfo = new UpdateServerInfo();
                        updateServerInfo.setVer(i);
                        updateServerInfo.setIsp(i3);
                        linkedHashMap.put(Integer.valueOf(i3), updateServerInfo);
                    }
                    linkedHashMap.get(Integer.valueOf(i3)).getIps().add(jSONObject2.getString("ip"));
                }
                return translateErrCode;
            } catch (Exception e) {
                LogTools.printError(TAG, "UpdateServerProtocolMgr.responseProtocol: " + e.getMessage());
                return 3;
            }
        }
        return 5;
    }

    public static int responseProtocolV6(String str, LinkedHashMap<Integer, UpdateServerInfo> linkedHashMap) {
        if (str != null && linkedHashMap != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int translateErrCode = translateErrCode(jSONObject.getInt("s"));
                int i = jSONObject.getInt("ver");
                JSONArray jSONArray = jSONObject.getJSONArray("dns_v6");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    int i3 = jSONObject2.getInt("v");
                    if (!linkedHashMap.containsKey(Integer.valueOf(i3))) {
                        UpdateServerInfo updateServerInfo = new UpdateServerInfo();
                        updateServerInfo.setVer(i);
                        updateServerInfo.setIsp(i3);
                        linkedHashMap.put(Integer.valueOf(i3), updateServerInfo);
                    }
                    linkedHashMap.get(Integer.valueOf(i3)).getIps().add(jSONObject2.getString("ip"));
                }
                return translateErrCode;
            } catch (Exception e) {
                LogTools.printError(TAG, "UpdateServerProtocolMgr.responseProtocol: " + e.getMessage());
                return 3;
            }
        }
        return 5;
    }
}
