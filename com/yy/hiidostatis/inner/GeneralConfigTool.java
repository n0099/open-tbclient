package com.yy.hiidostatis.inner;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GeneralConfigTool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CODE = "code";
    public static final String KEY_CODE_STATUS_NOT_MODIFIED = "2";
    public static final String KEY_CODE_STATUS_SUCCESS = "1";
    public static final String KEY_DATA = "data";
    public static final String KEY_LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String KEY_MAGIC = "HiidoData";
    public static final String KEY_MSG = "msg";
    public static final String KEY_TIME = "time";
    public static final long MAX_CACHE_TIME = 86400000;
    public static final String PRFKEY_SRV_TM = "PRFKEY_SRV_TM";
    public static Preference preference;
    public transient /* synthetic */ FieldHolder $fh;
    public String URL_CONFIG_SERVER;
    public AbstractConfig mConfig;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(918664997, "Lcom/yy/hiidostatis/inner/GeneralConfigTool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(918664997, "Lcom/yy/hiidostatis/inner/GeneralConfigTool;");
                return;
            }
        }
        preference = new Preference("hdcommon_config_cache_pref", true);
    }

    public GeneralConfigTool(Context context, AbstractConfig abstractConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, abstractConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mConfig = abstractConfig;
        this.URL_CONFIG_SERVER = abstractConfig.getUrlConfigServer();
    }

    private void addLastModifyTimeToParams(String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, str, map) == null) || Util.empty(str)) {
            return;
        }
        if (new JSONObject(str).has(KEY_LAST_MODIFIED_TIME)) {
            String str2 = jSONObject.get(KEY_LAST_MODIFIED_TIME) + "";
            if (Util.empty(str2)) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(KEY_LAST_MODIFIED_TIME, str2);
        }
    }

    private String assblyCacheKey(String str, Map<String, String> map) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, map)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.URL_CONFIG_SERVER);
            if (str == null) {
                str = "";
            }
            stringBuffer.append(str);
            stringBuffer.append("?");
            if (map != null && map.size() > 0) {
                Iterator it = new TreeSet(map.keySet()).iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    stringBuffer.append(str2);
                    stringBuffer.append("=");
                    stringBuffer.append(map.get(str2));
                    stringBuffer.append("&");
                }
            }
            return Coder.encryptMD5(stringBuffer.toString());
        }
        return (String) invokeLL.objValue;
    }

    private String assblyUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            String str2 = this.URL_CONFIG_SERVER;
            if (str != null) {
                return str2 + str;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    private String parseData(JSONObject jSONObject, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, this, jSONObject, z)) == null) {
            if (!"1".equals(jSONObject.getString("code"))) {
                L.error("GeneralConfigTool", "http get fail! code is %s,msg is %s", jSONObject.getString("code"), jSONObject.getString("msg"));
                return null;
            }
            String string = jSONObject.getString("data");
            if (Util.empty(string)) {
                return string;
            }
            if (z) {
                String string2 = jSONObject.getString("time");
                setSrvTime(string2);
                String substring = Coder.encryptMD5(string2 + "HiidoData").toLowerCase().substring(0, 8);
                L.verbose("GeneralConfigTool", "key is %s", substring);
                L.verbose("GeneralConfigTool", "data before decrypt  is %s", string);
                String decryptDES = Coder.decryptDES(string, substring);
                L.verbose("GeneralConfigTool", "data after decrypt  is %s", decryptDES);
                return decryptDES;
            }
            L.verbose("GeneralConfigTool", "data without decrypt  is %s", string);
            return string;
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[Catch: all -> 0x007a, TryCatch #1 {all -> 0x007a, blocks: (B:16:0x002e, B:18:0x0043, B:19:0x004a, B:21:0x0052, B:25:0x0075, B:22:0x005f, B:24:0x0067, B:15:0x0025), top: B:36:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[Catch: all -> 0x007a, TryCatch #1 {all -> 0x007a, blocks: (B:16:0x002e, B:18:0x0043, B:19:0x004a, B:21:0x0052, B:25:0x0075, B:22:0x005f, B:24:0x0067, B:15:0x0025), top: B:36:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f A[Catch: all -> 0x007a, TryCatch #1 {all -> 0x007a, blocks: (B:16:0x002e, B:18:0x0043, B:19:0x004a, B:21:0x0052, B:25:0x0075, B:22:0x005f, B:24:0x0067, B:15:0x0025), top: B:36:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String get(String str, Map<String, String> map, Context context, boolean z) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        JSONObject jSONObject;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, map, context, Boolean.valueOf(z)})) == null) {
            String assblyUrl = assblyUrl(str);
            try {
                str2 = assblyCacheKey(str, map);
                try {
                    str3 = preference.getPrefString(context, str2, null);
                    try {
                        addLastModifyTimeToParams(str3, map);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            L.debug("GeneralConfigTool", "get cache exception %s", th);
                            String str4 = HttpUtil.get(assblyUrl, map);
                            jSONObject = new JSONObject(str4);
                            string = jSONObject.getString("code");
                            if (jSONObject.has("time")) {
                            }
                            if (!"1".equals(string)) {
                            }
                            return parseData(jSONObject, z);
                        } catch (Throwable th2) {
                            L.error("GeneralConfigTool", "http get [%s] error! %s", assblyUrl, th2);
                            return null;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str3 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = null;
                str3 = null;
            }
            String str42 = HttpUtil.get(assblyUrl, map);
            jSONObject = new JSONObject(str42);
            string = jSONObject.getString("code");
            if (jSONObject.has("time")) {
                setSrvTime(jSONObject.getString("time"));
            }
            if (!"1".equals(string)) {
                L.verbose("GeneralConfigTool", "data is modified", new Object[0]);
                preference.setPrefString(context, str2, str42);
            } else if ("2".equals(string)) {
                L.verbose("GeneralConfigTool", "data is not modified,so get the cache data [%s]", str3);
                jSONObject = new JSONObject(str3);
            }
            return parseData(jSONObject, z);
        }
        return (String) invokeCommon.objValue;
    }

    public synchronized String getCache(String str, Map<String, String> map, Context context, boolean z) throws Exception {
        InterceptResult invokeCommon;
        String prefString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, map, context, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                String str2 = "";
                long currentTimeMillis = System.currentTimeMillis();
                String assblyCacheKey = assblyCacheKey(str, map);
                String str3 = "prefKeyTime_" + assblyCacheKey;
                String str4 = "prefKeyData_" + assblyCacheKey;
                long prefLong = preference.getPrefLong(context, str3, 0L);
                prefString = preference.getPrefString(context, str4, "");
                L.brief("prefKeyTime:%s", Long.valueOf(prefLong));
                L.brief("prefKeyData:%s", prefString);
                if (currentTimeMillis - prefLong <= 86400000) {
                    L.verbose("GeneralConfigTool", "get cache success,result is %s", prefString);
                    str2 = prefString;
                }
                if (Util.empty(str2)) {
                    str2 = get(str, map, context, z);
                    if (str2 != null) {
                        L.debug("GeneralConfigTool", "get remote success,result is %s", str2);
                        preference.setPrefLong(context, str3, currentTimeMillis);
                        preference.setPrefString(context, str4, str2);
                    } else {
                        L.verbose("GeneralConfigTool", "get cache because get remote is null", str2);
                    }
                }
                prefString = str2;
            }
            return prefString;
        }
        return (String) invokeCommon.objValue;
    }

    public AbstractConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mConfig : (AbstractConfig) invokeV.objValue;
    }

    public String getSrvTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return DefaultPreference.getPreference().getPrefString(this.mContext, PRFKEY_SRV_TM, null);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void setSrvTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                String srvTime = getSrvTime();
                if (srvTime == null || (str != null && Long.parseLong(str) > Long.parseLong(srvTime))) {
                    DefaultPreference.getPreference().setPrefString(this.mContext, PRFKEY_SRV_TM, str);
                }
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
    }

    public void setmConfig(AbstractConfig abstractConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, abstractConfig) == null) {
            this.mConfig = abstractConfig;
        }
    }
}
