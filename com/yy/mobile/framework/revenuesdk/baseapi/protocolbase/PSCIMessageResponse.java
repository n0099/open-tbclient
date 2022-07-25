package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PSCIMessageResponse extends ResponsePacket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int cmd;
    public String jsonMsg;
    public String responseJson;
    public int result;
    public String seq;
    public int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PSCIMessageResponse(byte[] bArr) {
        super(bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.ResponsePacket
    public void popPacketData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.responseJson = popStingWithOutLength();
                JSONObject jSONObject = new JSONObject(this.responseJson);
                this.seq = jSONObject.optString("seq");
                this.result = jSONObject.optInt(TiebaStatic.LogFields.RESULT);
                this.cmd = jSONObject.optInt("cmd");
                this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                this.version = jSONObject.optInt("version");
                this.jsonMsg = jSONObject.optString("jsonMsg");
            } catch (Exception e) {
                RLog.error("PSCIMessageResponse", "popPacketData error", e);
            }
        }
    }

    public String targetJson(ProtocolType protocolType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, protocolType)) == null) {
            if (protocolType == ProtocolType.HTTP) {
                return this.jsonMsg;
            }
            return protocolType == ProtocolType.SERVICE ? this.responseJson : "";
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "PSCIMessageResponse{result=" + this.result + ", cmd=" + this.cmd + ", appId=" + this.appId + ", version=" + this.version + ", seq=" + this.seq + ",responseJson=" + this.responseJson + '}';
        }
        return (String) invokeV.objValue;
    }
}
