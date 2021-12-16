package com.yy.gslbsdk.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.restnet.http.b;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UpdateServerProtocolMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UpdateServerProtocolMgr";
    public transient /* synthetic */ FieldHolder $fh;

    public UpdateServerProtocolMgr() {
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

    public static String[] requestProtocol(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) {
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
            hashMap.put("version", "2.2.18-lianyun");
            if (z) {
                return HTTPMgr.getHttps("https://" + str3, GlobalTools.HTTPDNS_SERVER_HOST, hashMap);
            }
            return HTTPMgr.getHttp("http://" + str3, hashMap);
        }
        return (String[]) invokeLZ.objValue;
    }

    public static int responseProtocol(String str, LinkedHashMap<Integer, UpdateServerInfo> linkedHashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, linkedHashMap)) == null) {
            if (str == null || linkedHashMap == null) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int translateErrCode = translateErrCode(jSONObject.getInt("s"));
                int i2 = jSONObject.getInt("ver");
                JSONArray jSONArray = jSONObject.getJSONArray(b.c.f33492b);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i4 = jSONObject2.getInt("v");
                    if (!linkedHashMap.containsKey(Integer.valueOf(i4))) {
                        UpdateServerInfo updateServerInfo = new UpdateServerInfo();
                        updateServerInfo.setVer(i2);
                        updateServerInfo.setIsp(i4);
                        linkedHashMap.put(Integer.valueOf(i4), updateServerInfo);
                    }
                    linkedHashMap.get(Integer.valueOf(i4)).getIps().add(jSONObject2.getString("ip"));
                }
                return translateErrCode;
            } catch (Exception e2) {
                LogTools.printError(TAG, "UpdateServerProtocolMgr.responseProtocol: " + e2.getMessage());
                return 3;
            }
        }
        return invokeLL.intValue;
    }

    public static int responseProtocolV6(String str, LinkedHashMap<Integer, UpdateServerInfo> linkedHashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, linkedHashMap)) == null) {
            if (str == null || linkedHashMap == null) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int translateErrCode = translateErrCode(jSONObject.getInt("s"));
                int i2 = jSONObject.getInt("ver");
                JSONArray jSONArray = jSONObject.getJSONArray("dns_v6");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    int i4 = jSONObject2.getInt("v");
                    if (!linkedHashMap.containsKey(Integer.valueOf(i4))) {
                        UpdateServerInfo updateServerInfo = new UpdateServerInfo();
                        updateServerInfo.setVer(i2);
                        updateServerInfo.setIsp(i4);
                        linkedHashMap.put(Integer.valueOf(i4), updateServerInfo);
                    }
                    linkedHashMap.get(Integer.valueOf(i4)).getIps().add(jSONObject2.getString("ip"));
                }
                return translateErrCode;
            } catch (Exception e2) {
                LogTools.printError(TAG, "UpdateServerProtocolMgr.responseProtocol: " + e2.getMessage());
                return 3;
            }
        }
        return invokeLL.intValue;
    }

    public static int translateErrCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return i2 != 4 ? 8 : 7;
                        }
                        return 5;
                    }
                    return 6;
                }
                return 4;
            }
            return 0;
        }
        return invokeI.intValue;
    }
}
