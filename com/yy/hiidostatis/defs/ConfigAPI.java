package com.yy.hiidostatis.defs;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class ConfigAPI implements IConfigAPI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GeneralConfigTool mGeneralConfigTool;

    public ConfigAPI(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGeneralConfigTool = GeneralProxy.getGeneralConfigInstance(context, HdStatisConfig.getConfig(str));
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public String getOnlineConfigs(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("appkey", str);
                return this.mGeneralConfigTool.get("api/getOnlineConfig", hashMap, context, true);
            } catch (Throwable th) {
                L.debug("ConfigAPI", "getSdkVer error! %s", th);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getSdkListConfig(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("sys", "2");
                return getConfig("api/getSdkListConfig", hashMap, context, z, true);
            } catch (Throwable th) {
                L.debug("ConfigAPI", "geSdkListConfig error! %s", th);
                return null;
            }
        }
        return (JSONObject) invokeLZ.objValue;
    }

    private JSONObject getConfig(String str, Map<String, String> map, Context context, boolean z, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, map, context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
        return (JSONObject) invokeCommon.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getAppListConfig(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, context, z)) == null) {
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
        return (JSONObject) invokeLZ.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IConfigAPI
    public JSONObject getSdkVer(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, context, z)) == null) {
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
        return (JSONObject) invokeLZ.objValue;
    }

    public JSONObject getDeviceConfig(Context context, String str, String str2, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
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
        return (JSONObject) invokeCommon.objValue;
    }
}
