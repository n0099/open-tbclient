package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PSCIMessageRequest extends RequestPacket {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PSCIMessageRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int cmd;
    public String jsonMsg;
    public ProtocolType protocolType;
    public String requestJson;
    public String ticket;
    public String traceid;
    public int version;

    public PSCIMessageRequest(ProtocolType protocolType, int i2, int i3, int i4, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protocolType, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.protocolType = ProtocolType.UNKNOW;
        this.cmd = i2;
        this.appId = i3;
        this.version = i4;
        this.ticket = str;
        this.traceid = str2;
        this.jsonMsg = str3;
        this.protocolType = protocolType;
        RLog.debug("PSCIMessageRequest", "request info: cmd = %d, appId = %d, version = %d, traceid = %d,jsonMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, str3);
        packageRequestJson();
    }

    private void packageHttpRequestJson() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", this.cmd);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("version", this.version);
                jSONObject.put("ticket", this.ticket);
                jSONObject.put("traceid", this.traceid);
                jSONObject.put("jsonMsg", this.jsonMsg);
                this.requestJson = jSONObject.toString();
            } catch (JSONException e2) {
                RLog.error("PSCIMessageRequest", "packageRequestJson error", e2);
            }
        }
    }

    private void packageRequestJson() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ProtocolType protocolType = this.protocolType;
            if (protocolType == ProtocolType.HTTP) {
                packageHttpRequestJson();
            } else if (protocolType == ProtocolType.SERVICE) {
                this.requestJson = this.jsonMsg;
            } else {
                RLog.error("PSCIMessageRequest", "packageRequestJson ProtocolType error ", new Object[0]);
            }
        }
    }

    public int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : invokeV.intValue;
    }

    public int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cmd : invokeV.intValue;
    }

    public String getJsonMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.jsonMsg : (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.RequestPacket
    public int getPacketSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.requestJson;
            if (str == null) {
                RLog.error("PSCIMessageRequest", "getPacketSize requestJson null", new Object[0]);
                return 0;
            }
            return str.getBytes().length + 4;
        }
        return invokeV.intValue;
    }

    public String getRequestJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.requestJson : (String) invokeV.objValue;
    }

    public String getTicket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ticket : (String) invokeV.objValue;
    }

    public String getTraceid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.traceid : (String) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.version : invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.RequestPacket
    public void pushPacketData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            pushString32(this.requestJson);
        }
    }

    public void setTicket(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.ticket = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "PSCIMessageRequest{cmd=" + this.cmd + ", appId=" + this.appId + ", version=" + this.version + ", traceid=" + this.traceid + ", jsonMsg='" + this.jsonMsg + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public PSCIMessageRequest(byte[] bArr, ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, protocolType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.protocolType = ProtocolType.UNKNOW;
        this.protocolType = protocolType;
        unmarshall(bArr);
        try {
            String popString32 = popString32();
            JSONObject jSONObject = new JSONObject(popString32);
            this.cmd = jSONObject.optInt("cmd");
            this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            this.version = jSONObject.optInt("version");
            this.ticket = jSONObject.optString("ticket");
            this.traceid = jSONObject.optString("traceId");
            if (protocolType == ProtocolType.SERVICE) {
                this.jsonMsg = popString32;
            } else if (protocolType == ProtocolType.HTTP) {
                this.jsonMsg = jSONObject.optString("jsonMsg");
            } else {
                RLog.error("PSCIMessageRequest", "PSCIMessageRequest construct ProtocolType error ", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
