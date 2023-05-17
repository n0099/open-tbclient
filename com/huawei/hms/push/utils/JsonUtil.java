package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class JsonUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, jSONObject, str, obj, bundle) == null) {
            if (obj == null) {
                HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "transfer jsonObject to bundle failed, defaultValue is null.");
                return;
            }
            String[] strArr = null;
            String str2 = null;
            int[] iArr = null;
            long[] jArr = null;
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
                bundle.putString(str, getString(jSONObject, str, str2));
            } else if (obj instanceof Integer) {
                bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
            } else if (obj instanceof int[]) {
                int[] iArr2 = (int[]) obj;
                if (iArr2.length != 0) {
                    iArr = iArr2;
                }
                bundle.putIntArray(str, getIntArray(jSONObject, str, iArr));
            } else if (obj instanceof long[]) {
                long[] jArr2 = (long[]) obj;
                if (jArr2.length != 0) {
                    jArr = jArr2;
                }
                bundle.putLongArray(str, getLongArray(jSONObject, str, jArr));
            } else if (obj instanceof String[]) {
                String[] strArr2 = (String[]) obj;
                if (strArr2.length != 0) {
                    strArr = strArr2;
                }
                bundle.putStringArray(str, getStringArray(jSONObject, str, strArr));
            } else {
                HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "transfer jsonObject to bundle failed, invalid data type.");
            }
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, jSONObject, str, i)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(str)) {
                        return jSONObject.getInt(str);
                    }
                    return i;
                } catch (JSONException unused) {
                    HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "JSONException: get " + str + " error.");
                    return i;
                }
            }
            return i;
        }
        return invokeLLI.intValue;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, jSONObject, bundle, hashMap) == null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                a(jSONObject, entry.getKey(), entry.getValue(), bundle);
            }
        }
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, jSONObject, str, iArr)) == null) {
            int[] iArr2 = null;
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(str)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        iArr2 = new int[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            iArr2[i] = ((Integer) jSONArray.get(i)).intValue();
                        }
                    }
                } catch (JSONException unused) {
                    HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "JSONException: get " + str + " error.");
                }
            }
            if (iArr2 != null) {
                return iArr2;
            }
            return iArr;
        }
        return (int[]) invokeLLL.objValue;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, jSONObject, str, jArr)) == null) {
            long[] jArr2 = null;
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(str)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        jArr2 = new long[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            jArr2[i] = jSONArray.getLong(i);
                        }
                    }
                } catch (JSONException unused) {
                    HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "JSONException: get " + str + " error.");
                }
            }
            if (jArr2 != null) {
                return jArr2;
            }
            return jArr;
        }
        return (long[]) invokeLLL.objValue;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, jSONObject, str, str2)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(str) && jSONObject.get(str) != null) {
                        return String.valueOf(jSONObject.get(str));
                    }
                    return str2;
                } catch (JSONException unused) {
                    HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "JSONException: get " + str + " error.");
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, jSONObject, str, strArr)) == null) {
            String[] strArr2 = null;
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(str)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = (String) jSONArray.get(i);
                        }
                    }
                } catch (JSONException unused) {
                    HMSLog.w(com.huawei.hms.utils.JsonUtil.TAG, "JSONException: get " + str + " error.");
                }
            }
            return strArr2;
        }
        return (String[]) invokeLLL.objValue;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (iArr != null && iArr.length != 0) {
                for (int i : iArr) {
                    jSONArray.put(i);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (jArr != null && jArr.length != 0) {
                for (long j : jArr) {
                    jSONArray.put(j);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, strArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
