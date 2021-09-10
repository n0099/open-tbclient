package com.yy.gslbsdk.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.restnet.http.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.db.ResultTB;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpDNSProtocolMgr";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpDNSProtocolMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getRequestUrlProtocolV2(String[] strArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, strArr, str, z)) == null) {
            String str2 = "http://" + str + "/dns_query_v3?";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                str2 = str2 + "dns=" + strArr[i2];
                if (i2 != strArr.length - 1) {
                    str2 = str2 + "&";
                }
            }
            if (z) {
                return str2 + "&rescount=-1";
            }
            return str2;
        }
        return (String) invokeLLZ.objValue;
    }

    public static String[] requestHttpDnsV2(String[] strArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, strArr, str, z)) == null) ? requestHttpDnsV2(strArr, str, z, false, "") : (String[]) invokeLLZ.objValue;
    }

    public static int responseProtocolV2(String str, ResInfo resInfo, int i2) {
        InterceptResult invokeLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, resInfo, i2)) == null) {
            String str3 = "ips";
            try {
                if (str != null && resInfo != null) {
                    JSONObject jSONObject = new JSONObject(str);
                    resInfo.setStatus(translateErrCode(jSONObject.getInt("s")));
                    resInfo.setUserIp(jSONObject.getString("u"));
                    resInfo.setUserView(jSONObject.getString("v"));
                    LinkedHashMap<String, DnsInfo> linkedHashMap = new LinkedHashMap<>();
                    JSONArray jSONArray = jSONObject.getJSONArray(b.InterfaceC1615b.f38078b);
                    int i3 = 0;
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        DnsInfo dnsInfo = new DnsInfo();
                        dnsInfo.setView(jSONObject.getString("v"));
                        dnsInfo.setUip(jSONObject.getString("u"));
                        dnsInfo.setHost(jSONObject2.getString("name"));
                        dnsInfo.setTtl(Math.max(jSONObject2.getInt(ResultTB.TTL), GlobalTools.sMinSecondTTL));
                        LinkedList<String> linkedList = new LinkedList<>();
                        if (jSONObject2.isNull(str3)) {
                            str2 = str3;
                        } else {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(str3);
                            str2 = str3;
                            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                linkedList.add(jSONArray2.getString(i4));
                            }
                            dnsInfo.setIps(linkedList);
                        }
                        CmdInfo cmdInfo = new CmdInfo();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("cmd");
                        cmdInfo.setPe(jSONObject3.getBoolean("pe"));
                        cmdInfo.setRe(jSONObject3.getBoolean("re"));
                        dnsInfo.setCmd(cmdInfo);
                        if (resInfo.getNetInfo() != null) {
                            dnsInfo.setNt(resInfo.getNetInfo().getNetType());
                        }
                        dnsInfo.setSource(i2);
                        linkedHashMap.put(dnsInfo.getHost(), dnsInfo);
                        i3++;
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
                        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                            HashMap hashMap = new HashMap();
                            hashMap.put("dm", optJSONObject.optString("dm", ""));
                            hashMap.put("ut", optJSONObject.optString("ut", "0"));
                            resInfo.addRefresh(hashMap);
                        }
                        return 0;
                    }
                    return 0;
                }
                resInfo.setStatus(5);
                return 5;
            } catch (Exception e2) {
                LogTools.printError(TAG, "responseProtocolV2: " + e2.getMessage());
                resInfo.setStatus(3);
                return 3;
            }
        }
        return invokeLLI.intValue;
    }

    public static int translateErrCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 4) {
                        if (i2 != 1002) {
                            return i2 != 2002 ? 8 : 6;
                        }
                        return 5;
                    }
                    return 7;
                }
                return 4;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public static String udpRequestProtocolV2(String[] strArr, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{strArr, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("seq_id", j2);
                    jSONObject.put("version", "v2");
                    JSONArray jSONArray = new JSONArray();
                    for (String str : strArr) {
                        jSONArray.put(str);
                    }
                    jSONObject.put("dns_name", jSONArray);
                    if (z) {
                        jSONObject.put("res_count", -1);
                    }
                    return jSONObject.toString();
                } catch (Exception e2) {
                    LogTools.printError(TAG, "udpRequestProtocolV2: " + e2.getMessage());
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] requestHttpDnsV2(String[] strArr, String str, boolean z, boolean z2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{strArr, str, Boolean.valueOf(z), Boolean.valueOf(z2), str2})) == null) {
            if (GlobalTools.IS_TEST_ENV) {
                str = GlobalTools.HTTPDNS_SERVER_HOST;
            }
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            sb.append("dns=");
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(strArr[i2]);
                if (i2 < length - 1) {
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
            hashMap.put("version", "2.2.18-lianyun");
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
        return (String[]) invokeCommon.objValue;
    }
}
