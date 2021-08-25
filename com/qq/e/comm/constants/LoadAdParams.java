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
/* loaded from: classes10.dex */
public class LoadAdParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f75116a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f75117b;

    /* renamed from: c  reason: collision with root package name */
    public String f75118c;

    /* renamed from: d  reason: collision with root package name */
    public String f75119d;

    /* renamed from: e  reason: collision with root package name */
    public String f75120e;

    /* renamed from: f  reason: collision with root package name */
    public int f75121f;

    /* renamed from: g  reason: collision with root package name */
    public String f75122g;

    /* renamed from: h  reason: collision with root package name */
    public Map f75123h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75124i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f75125j;

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

    public int getBlockEffectValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f75121f : invokeV.intValue;
    }

    public JSONObject getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75125j : (JSONObject) invokeV.objValue;
    }

    public int getFlowSourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75116a : invokeV.intValue;
    }

    public String getLoginAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75118c : (String) invokeV.objValue;
    }

    public String getLoginOpenid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75119d : (String) invokeV.objValue;
    }

    public LoginType getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f75117b : (LoginType) invokeV.objValue;
    }

    public Map getPassThroughInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f75123h : (Map) invokeV.objValue;
    }

    public String getPassThroughInfoJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                if (this.f75123h == null || this.f75123h.size() <= 0) {
                    return null;
                }
                return new JSONObject(this.f75123h).toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getUin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f75120e : (String) invokeV.objValue;
    }

    public String getWXAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f75122g : (String) invokeV.objValue;
    }

    public boolean isHotStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f75124i : invokeV.booleanValue;
    }

    public void setBlockEffectValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f75121f = i2;
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.f75125j = jSONObject;
        }
    }

    public void setFlowSourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f75116a = i2;
        }
    }

    public void setHotStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f75124i = z;
        }
    }

    public void setLoginAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f75118c = str;
        }
    }

    public void setLoginOpenid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f75119d = str;
        }
    }

    public void setLoginType(LoginType loginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, loginType) == null) {
            this.f75117b = loginType;
        }
    }

    public void setPassThroughInfo(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, map) == null) {
            this.f75123h = map;
        }
    }

    public void setUin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f75120e = str;
        }
    }

    public void setWXAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f75122g = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "LoadAdParams{flowSourceId=" + this.f75116a + ", loginType=" + this.f75117b + ", loginAppId=" + this.f75118c + ", loginOpenid=" + this.f75119d + ", uin=" + this.f75120e + ", blockEffect=" + this.f75121f + ", passThroughInfo=" + this.f75123h + ", extraInfo=" + this.f75125j + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
