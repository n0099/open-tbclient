package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PSCIMessageUnicast extends ResponsePacket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int channelId;
    public JSONObject data;
    public String jsonData;
    public long uri;

    public PSCIMessageUnicast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.appId = this.data.optInt("appid", -1);
            this.channelId = this.data.optInt("usedChannel", 0);
        } catch (Exception e) {
            RLog.error("PSCIMessageUnicast", "popPacketData error.", e);
        }
    }

    public int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : invokeV.intValue;
    }

    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.channelId : invokeV.intValue;
    }

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.data : (JSONObject) invokeV.objValue;
    }

    public String getJsonData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.jsonData : (String) invokeV.objValue;
    }

    public long getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.uri : invokeV.longValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.ResponsePacket
    public void popPacketData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.jsonData = popStingWithOutLength();
                JSONObject jSONObject = new JSONObject(this.jsonData);
                this.data = jSONObject;
                this.uri = jSONObject.optLong("uri", 0L);
                this.appId = this.data.optInt("appid", -1);
                this.channelId = this.data.optInt("usedChannel", 0);
            } catch (Exception e) {
                RLog.error("PSCIMessageUnicast", "popPacketData error.", e);
            }
        }
    }

    public void setUri(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.uri = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "PSCIMessageUnicast{uri=" + this.uri + ", appId=" + this.appId + ", channelId=" + this.channelId + '}';
        }
        return (String) invokeV.objValue;
    }
}
