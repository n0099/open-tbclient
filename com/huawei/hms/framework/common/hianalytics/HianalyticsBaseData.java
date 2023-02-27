package com.huawei.hms.framework.common.hianalytics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class HianalyticsBaseData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_ID = "url_request";
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    public static final String TAG = "HianalyticsBaseData";
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, String> data;

    public HianalyticsBaseData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        this.data = linkedHashMap;
        linkedHashMap.put("sdk_type", "UxPP");
        this.data.put(SDK_NAME, "networkkit");
    }

    public LinkedHashMap<String, String> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.data;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public HianalyticsBaseData put(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (str == null) {
                Logger.v(TAG, "key = null : value = " + j);
            } else {
                LinkedHashMap<String, String> linkedHashMap = this.data;
                linkedHashMap.put(str, "" + j);
            }
            return this;
        }
        return (HianalyticsBaseData) invokeLJ.objValue;
    }

    public HianalyticsBaseData put(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                this.data.put(str, str2);
            } else {
                Logger.v(TAG, "key = " + str + " : value = " + str2);
            }
            return this;
        }
        return (HianalyticsBaseData) invokeLL.objValue;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, linkedHashMap)) == null) {
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.data.putAll(linkedHashMap);
            } else {
                Logger.v(TAG, ADConfigError.REASON_NULL_DATA);
            }
            return this;
        }
        return (HianalyticsBaseData) invokeL.objValue;
    }

    public HianalyticsBaseData putIfNotDefault(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j == j2) {
                return this;
            }
            return put(str, j);
        }
        return (HianalyticsBaseData) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : get().entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                Logger.w(TAG, "catch JSONException", e);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
