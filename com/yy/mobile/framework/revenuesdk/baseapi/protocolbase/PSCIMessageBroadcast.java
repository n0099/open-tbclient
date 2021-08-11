package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PSCIMessageBroadcast extends ResponsePacket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject data;
    public String jsonData;
    public long uri;

    public PSCIMessageBroadcast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jsonData = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.data = jSONObject;
            this.uri = jSONObject.optLong("uri", 0L);
        } catch (Exception e2) {
            RLog.error("PSCIMessageBroadcast", "popPacketData error.", e2);
        }
    }

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (JSONObject) invokeV.objValue;
    }

    public String getJsonData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.jsonData : (String) invokeV.objValue;
    }

    public long getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.uri : invokeV.longValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.ResponsePacket
    public void popPacketData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.jsonData = popStingWithOutLength();
                JSONObject jSONObject = new JSONObject(this.jsonData);
                this.data = jSONObject;
                this.uri = jSONObject.optLong("uri", 0L);
            } catch (Exception e2) {
                RLog.error("PSCIMessageBroadcast", "popPacketData error.", e2);
            }
        }
    }

    public void setUri(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.uri = j2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "PSCIMessageBroadcast{uri=" + this.uri + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
