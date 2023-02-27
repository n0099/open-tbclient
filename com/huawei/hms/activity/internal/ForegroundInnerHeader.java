package com.huawei.hms.activity.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ForegroundInnerHeader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForegroundInnerHeader";
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public int apkVersion;
    public String responseCallbackKey;

    public ForegroundInnerHeader() {
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

    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.action;
        }
        return (String) invokeV.objValue;
    }

    public int getApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.apkVersion;
        }
        return invokeV.intValue;
    }

    public String getResponseCallbackKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.responseCallbackKey;
        }
        return (String) invokeV.objValue;
    }

    public void fromJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.apkVersion = JsonUtil.getIntValue(jSONObject, "apkVersion");
                this.action = JsonUtil.getStringValue(jSONObject, "action");
                this.responseCallbackKey = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
            } catch (JSONException e) {
                HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
            }
        }
    }

    public void setAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.action = str;
        }
    }

    public void setApkVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.apkVersion = i;
        }
    }

    public void setResponseCallbackKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.responseCallbackKey = str;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("apkVersion", this.apkVersion);
                jSONObject.put("action", this.action);
                jSONObject.put("responseCallbackKey", this.responseCallbackKey);
            } catch (JSONException e) {
                HMSLog.e(TAG, "ForegroundInnerHeader toJson failed: " + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "apkVersion:" + this.apkVersion + ", action:" + this.action + ", responseCallbackKey:" + this.responseCallbackKey;
        }
        return (String) invokeV.objValue;
    }
}
