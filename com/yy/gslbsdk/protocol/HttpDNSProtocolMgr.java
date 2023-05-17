package com.yy.gslbsdk.protocol;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.kuaishou.weapon.p0.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HttpDNSProtocolMgr {
    public static final String TAG = "HttpDNSProtocolMgr";

    public static int translateErrCode(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 4) {
                    if (i != 1002) {
                        return i != 2002 ? 8 : 6;
                    }
                    return 5;
                }
                return 7;
            }
            return 4;
        }
        return 0;
    }

    public static String getRequestUrlProtocolV2(String[] strArr, String str, boolean z) {
        String str2 = "http://" + str + "/dns_query_v3?";
        for (int i = 0; i < strArr.length; i++) {
            str2 = str2 + "dns=" + strArr[i];
            if (i != strArr.length - 1) {
                str2 = str2 + "&";
            }
        }
        if (z) {
            return str2 + "&rescount=-1";
        }
        return str2;
    }

    public static String udpRequestProtocolV2(String[] strArr, long j, boolean z) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PushConstants.SEQ_ID, j);
                jSONObject.put("version", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                jSONObject.put("dns_name", jSONArray);
                if (z) {
                    jSONObject.put("res_count", -1);
                }
                return jSONObject.toString();
            } catch (Exception e) {
                LogTools.printError(TAG, "udpRequestProtocolV2: " + e.getMessage());
            }
        }
        return null;
    }

    public static String[] requestHttpDnsV2(String[] strArr, String str, boolean z) {
        return requestHttpDnsV2(strArr, str, z, false, "");
    }

    public static String[] requestHttpDnsV2(String[] strArr, String str, boolean z, boolean z2, String str2) {
        if (GlobalTools.IS_TEST_ENV) {
            str = GlobalTools.HTTPDNS_SERVER_HOST;
        }
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        sb.append("dns=");
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        sb.toString();
        String identity = DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
        HashMap hashMap = new HashMap();
        hashMap.put("host", GlobalTools.HTTPDNS_SERVER_HOST);
        hashMap.put("p", "a");
        hashMap.put("devid", GlobalTools.APP_DEV_ID);
        hashMap.put("gslbid", identity);
        hashMap.put("appid", GlobalTools.ACCOUNT_ID);
        hashMap.put("version", "2.2.28-live");
        String str3 = GlobalTools.APP_LOCALIZE_CODE;
        str3 = (str3 == null || str3.trim().length() < 1) ? "" : "";
        if (IpVersionController.tellIpVer(str) == 6) {
            str = PreferencesUtil.LEFT_MOUNT + str + PreferencesUtil.RIGHT_MOUNT;
        }
        if (z2) {
            String str4 = "https://" + str + "/dns_query_v3?usercfg=" + str3 + "&requestId=" + str2;
            if (z) {
                str4 = str4 + "&rescount=-1";
            }
            return HTTPMgr.postSniHttps(str4, GlobalTools.HTTPDNS_SERVER_HOST, sb.toString(), hashMap);
        }
        String str5 = "http://" + str + "/dns_query_v3?usercfg=" + str3 + "&requestId=" + str2;
        if (z) {
            str5 = str5 + "&rescount=-1";
        }
        return HTTPMgr.postHttp(str5, sb.toString(), hashMap);
    }

    public static int responseProtocolV2(String str, ResInfo resInfo, int i) {
        String str2;
        String str3 = "ips";
        try {
            if (str != null && resInfo != null) {
                JSONObject jSONObject = new JSONObject(str);
                resInfo.setStatus(translateErrCode(jSONObject.getInt("s")));
                resInfo.setUserIp(jSONObject.getString("u"));
                resInfo.setUserView(jSONObject.getString("v"));
                LinkedHashMap<String, DnsInfo> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArray = jSONObject.getJSONArray(DnsCacheHelper.DIR_NAME);
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    DnsInfo dnsInfo = new DnsInfo();
                    dnsInfo.setView(jSONObject.getString("v"));
                    dnsInfo.setUip(jSONObject.getString("u"));
                    dnsInfo.setHost(jSONObject2.getString("name"));
                    dnsInfo.setTtl(Math.max(jSONObject2.getInt("ttl"), GlobalTools.sMinSecondTTL));
                    LinkedList<String> linkedList = new LinkedList<>();
                    if (!jSONObject2.isNull(str3)) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(str3);
                        str2 = str3;
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            linkedList.add(jSONArray2.getString(i3));
                        }
                        dnsInfo.setIps(linkedList);
                    } else {
                        str2 = str3;
                    }
                    CmdInfo cmdInfo = new CmdInfo();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("cmd");
                    cmdInfo.setPe(jSONObject3.getBoolean("pe"));
                    cmdInfo.setRe(jSONObject3.getBoolean("re"));
                    dnsInfo.setCmd(cmdInfo);
                    if (resInfo.getNetInfo() != null) {
                        dnsInfo.setNt(resInfo.getNetInfo().getNetType());
                    }
                    dnsInfo.setSource(i);
                    linkedHashMap.put(dnsInfo.getHost(), dnsInfo);
                    i2++;
                    str3 = str2;
                }
                resInfo.setDns(linkedHashMap);
                JSONObject jSONObject4 = jSONObject.getJSONObject("httpdns");
                HttpDnsInfo httpDnsInfo = new HttpDnsInfo();
                httpDnsInfo.setVer(jSONObject4.getInt("ver"));
                httpDnsInfo.setRe(jSONObject4.getBoolean("re"));
                resInfo.setHttpdns(httpDnsInfo);
                JSONArray optJSONArray = jSONObject.optJSONArray("rd1");
                if (optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                        HashMap hashMap = new HashMap();
                        hashMap.put(u.A, optJSONObject.optString(u.A, ""));
                        hashMap.put("ut", optJSONObject.optString("ut", "0"));
                        resInfo.addRefresh(hashMap);
                    }
                    return 0;
                }
                return 0;
            }
            resInfo.setStatus(5);
            return 5;
        } catch (Exception e) {
            LogTools.printError(TAG, "responseProtocolV2: " + e.getMessage());
            resInfo.setStatus(3);
            return 3;
        }
    }
}
