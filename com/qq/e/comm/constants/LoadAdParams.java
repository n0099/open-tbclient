package com.qq.e.comm.constants;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class LoadAdParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginType a;

    /* renamed from: b  reason: collision with root package name */
    public String f57616b;

    /* renamed from: c  reason: collision with root package name */
    public String f57617c;

    /* renamed from: d  reason: collision with root package name */
    public String f57618d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f57619e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f57620f;

    public LoadAdParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Map getDevExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57619e : (Map) invokeV.objValue;
    }

    public String getDevExtraJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return (this.f57619e == null || this.f57619e.size() <= 0) ? "" : new JSONObject(this.f57619e).toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public JSONObject getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57620f : (JSONObject) invokeV.objValue;
    }

    public String getLoginAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57616b : (String) invokeV.objValue;
    }

    public String getLoginOpenid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57617c : (String) invokeV.objValue;
    }

    public LoginType getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (LoginType) invokeV.objValue;
    }

    public String getUin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57618d : (String) invokeV.objValue;
    }

    public void setDevExtra(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            this.f57619e = map;
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            this.f57620f = jSONObject;
        }
    }

    public void setLoginAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f57616b = str;
        }
    }

    public void setLoginOpenid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f57617c = str;
        }
    }

    public void setLoginType(LoginType loginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, loginType) == null) {
            this.a = loginType;
        }
    }

    public void setUin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f57618d = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "LoadAdParams{, loginType=" + this.a + ", loginAppId=" + this.f57616b + ", loginOpenid=" + this.f57617c + ", uin=" + this.f57618d + ", passThroughInfo=" + this.f57619e + ", extraInfo=" + this.f57620f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
