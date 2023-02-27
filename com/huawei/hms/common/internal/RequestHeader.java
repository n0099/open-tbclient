package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class RequestHeader implements IMessageEntity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequestHeader";
    public transient /* synthetic */ FieldHolder $fh;
    @Packed
    public int apiLevel;
    @Packed
    public String api_name;
    @Packed
    public String app_id;
    @Packed
    public int kitSdkVersion;
    public Parcelable parcelable;
    @Packed
    public String pkg_name;
    @Packed
    public int sdk_version;
    @Packed
    public String session_id;
    @Packed
    public String srv_name;
    @Packed
    public String transaction_id;
    @Packed
    public String version;

    public RequestHeader() {
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
        this.version = "4.0";
        this.sdk_version = 60500300;
    }

    public int getApiLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.apiLevel;
        }
        return invokeV.intValue;
    }

    public String getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.api_name;
        }
        return (String) invokeV.objValue;
    }

    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.app_id;
        }
        return (String) invokeV.objValue;
    }

    public int getKitSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.kitSdkVersion;
        }
        return invokeV.intValue;
    }

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

    public int getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sdk_version;
        }
        return invokeV.intValue;
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

    public String getTransactionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.transaction_id;
        }
        return (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.version;
        }
        return (String) invokeV.objValue;
    }

    public boolean fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.version = JsonUtil.getStringValue(jSONObject, "version");
                this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
                this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
                this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
                this.pkg_name = JsonUtil.getStringValue(jSONObject, EmotionResourceInfo.JSON_KEY_PKG_NAME);
                this.sdk_version = JsonUtil.getIntValue(jSONObject, "sdk_version");
                this.kitSdkVersion = JsonUtil.getIntValue(jSONObject, "kitSdkVersion");
                this.apiLevel = JsonUtil.getIntValue(jSONObject, "apiLevel");
                this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
                this.transaction_id = JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID);
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

    public void setApiLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.apiLevel = i;
        }
    }

    public void setApiName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.api_name = str;
        }
    }

    public void setAppID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.app_id = str;
        }
    }

    public void setKitSdkVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.kitSdkVersion = i;
        }
    }

    public void setParcelable(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, parcelable) == null) {
            this.parcelable = parcelable;
        }
    }

    public void setPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.pkg_name = str;
        }
    }

    public void setSdkVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.sdk_version = i;
        }
    }

    public void setSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.session_id = str;
        }
    }

    public void setSrvName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.srv_name = str;
        }
    }

    public void setTransactionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.transaction_id = str;
        }
    }

    public void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.version = str;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.version);
                jSONObject.put("srv_name", this.srv_name);
                jSONObject.put("api_name", this.api_name);
                jSONObject.put("app_id", this.app_id);
                jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.pkg_name);
                jSONObject.put("sdk_version", this.sdk_version);
                jSONObject.put("kitSdkVersion", this.kitSdkVersion);
                jSONObject.put("apiLevel", this.apiLevel);
                if (!TextUtils.isEmpty(this.session_id)) {
                    jSONObject.put("session_id", this.session_id);
                }
                jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return "api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", sdk_version:" + this.sdk_version + ", session_id:*, transaction_id:" + this.transaction_id + ", kitSdkVersion:" + this.kitSdkVersion + ", apiLevel:" + this.apiLevel;
        }
        return (String) invokeV.objValue;
    }
}
