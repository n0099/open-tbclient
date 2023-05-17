package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.WebChromeClient;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ResponseHeader implements IMessageEntity, ResponseErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ResponseHeader";
    public transient /* synthetic */ FieldHolder $fh;
    @Packed
    public String api_name;
    @Packed
    public String app_id;
    @Packed
    public int error_code;
    @Packed
    public String error_reason;
    public Parcelable parcelable;
    @Packed
    public String pkg_name;
    @Packed
    public String resolution;
    @Packed
    public String session_id;
    @Packed
    public String srv_name;
    @Packed
    public int status_code;
    @Packed
    public String transaction_id;

    public ResponseHeader() {
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
        this.app_id = "";
    }

    public String getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.api_name;
        }
        return (String) invokeV.objValue;
    }

    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.app_id;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.error_code;
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getErrorReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.error_reason;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public Parcelable getParcelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.parcelable;
        }
        return (Parcelable) invokeV.objValue;
    }

    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.pkg_name;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.resolution;
        }
        return (String) invokeV.objValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.session_id;
        }
        return (String) invokeV.objValue;
    }

    public String getSrvName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.srv_name;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.status_code;
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getTransactionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.transaction_id;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public boolean hasResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.parcelable != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.status_code == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ResponseHeader(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.app_id = "";
        this.status_code = i;
        this.error_code = i2;
        this.error_reason = str;
    }

    public boolean fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.status_code = JsonUtil.getIntValue(jSONObject, "status_code");
                this.error_code = JsonUtil.getIntValue(jSONObject, "error_code");
                this.error_reason = JsonUtil.getStringValue(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON);
                this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
                this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
                this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
                this.pkg_name = JsonUtil.getStringValue(jSONObject, "pkg_name");
                this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
                this.transaction_id = JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID);
                this.resolution = JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION);
                return true;
            } catch (JSONException e) {
                HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String getActualAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.app_id)) {
                return "";
            }
            String[] split = this.app_id.split(WebChromeClient.PARAM_SEPARATOR);
            if (split.length == 0) {
                return "";
            }
            if (split.length == 1) {
                return split[0];
            }
            return split[1];
        }
        return (String) invokeV.objValue;
    }

    public void setApiName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.api_name = str;
        }
    }

    public void setAppID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.app_id = str;
        }
    }

    public void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.error_code = i;
        }
    }

    public void setErrorReason(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.error_reason = str;
        }
    }

    public void setParcelable(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, parcelable) == null) {
            this.parcelable = parcelable;
        }
    }

    public void setPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.pkg_name = str;
        }
    }

    public void setResolution(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.resolution = str;
        }
    }

    public void setSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.session_id = str;
        }
    }

    public void setSrvName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.srv_name = str;
        }
    }

    public void setStatusCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.status_code = i;
        }
    }

    public void setTransactionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.transaction_id = str;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status_code", this.status_code);
                jSONObject.put("error_code", this.error_code);
                jSONObject.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, this.error_reason);
                jSONObject.put("srv_name", this.srv_name);
                jSONObject.put("api_name", this.api_name);
                jSONObject.put("app_id", this.app_id);
                jSONObject.put("pkg_name", this.pkg_name);
                if (!TextUtils.isEmpty(this.session_id)) {
                    jSONObject.put("session_id", this.session_id);
                }
                jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.resolution);
            } catch (JSONException e) {
                HMSLog.e(TAG, "toJson failed: " + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "status_code:" + this.status_code + ", error_code:" + this.error_code + ", api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", session_id:*, transaction_id:" + this.transaction_id + ", resolution:" + this.resolution;
        }
        return (String) invokeV.objValue;
    }
}
