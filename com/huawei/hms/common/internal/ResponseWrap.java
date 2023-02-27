package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponseWrap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ResponseWrap";
    public transient /* synthetic */ FieldHolder $fh;
    public String body;
    public ResponseHeader responseHeader;

    public ResponseWrap(ResponseHeader responseHeader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {responseHeader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.responseHeader = responseHeader;
    }

    public void setBody(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.body = str;
        }
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responseHeader) == null) {
            this.responseHeader = responseHeader;
        }
    }

    public boolean fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.responseHeader.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
                this.responseHeader.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
                this.responseHeader.setErrorReason(JsonUtil.getStringValue(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON));
                this.responseHeader.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
                this.responseHeader.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
                this.responseHeader.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
                this.responseHeader.setPkgName(JsonUtil.getStringValue(jSONObject, EmotionResourceInfo.JSON_KEY_PKG_NAME));
                this.responseHeader.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
                this.responseHeader.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
                this.responseHeader.setResolution(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION));
                this.body = JsonUtil.getStringValue(jSONObject, "body");
                return true;
            } catch (JSONException e) {
                HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.body)) {
                this.body = new JSONObject().toString();
            }
            return this.body;
        }
        return (String) invokeV.objValue;
    }

    public ResponseHeader getResponseHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.responseHeader;
        }
        return (ResponseHeader) invokeV.objValue;
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status_code", this.responseHeader.getStatusCode());
                jSONObject.put("error_code", this.responseHeader.getErrorCode());
                jSONObject.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, this.responseHeader.getErrorReason());
                jSONObject.put("srv_name", this.responseHeader.getSrvName());
                jSONObject.put("api_name", this.responseHeader.getApiName());
                jSONObject.put("app_id", this.responseHeader.getAppID());
                jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.responseHeader.getPkgName());
                jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.responseHeader.getTransactionId());
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.responseHeader.getResolution());
                String sessionId = this.responseHeader.getSessionId();
                if (!TextUtils.isEmpty(sessionId)) {
                    jSONObject.put("session_id", sessionId);
                }
                if (!TextUtils.isEmpty(this.body)) {
                    jSONObject.put("body", this.body);
                }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ResponseWrap{body='" + this.body + "', responseHeader=" + this.responseHeader + '}';
        }
        return (String) invokeV.objValue;
    }
}
