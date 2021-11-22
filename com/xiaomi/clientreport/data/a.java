package com.xiaomi.clientreport.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.push.bq;
import com.xiaomi.push.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String clientInterfaceId;
    public String miuiVersion;
    public String os;
    public String pkgName;
    public int production;
    public int reportType;
    public String sdkVersion;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.os = bq.a();
        this.miuiVersion = l.m535a();
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.pkgName : (String) invokeV.objValue;
    }

    public void setAppPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.pkgName = str;
        }
    }

    public void setSdkVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.sdkVersion = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("production", this.production);
                jSONObject.put("reportType", this.reportType);
                jSONObject.put("clientInterfaceId", this.clientInterfaceId);
                jSONObject.put("os", this.os);
                jSONObject.put("miuiVersion", this.miuiVersion);
                jSONObject.put("pkgName", this.pkgName);
                jSONObject.put(CommandMessage.SDK_VERSION, this.sdkVersion);
                return jSONObject;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject json = toJson();
            return json == null ? "" : json.toString();
        }
        return (String) invokeV.objValue;
    }
}
