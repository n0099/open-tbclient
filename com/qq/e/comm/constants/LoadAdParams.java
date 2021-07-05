package com.qq.e.comm.constants;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LoadAdParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40929a;

    /* renamed from: b  reason: collision with root package name */
    public LoginType f40930b;

    /* renamed from: c  reason: collision with root package name */
    public String f40931c;

    /* renamed from: d  reason: collision with root package name */
    public String f40932d;

    /* renamed from: e  reason: collision with root package name */
    public String f40933e;

    /* renamed from: f  reason: collision with root package name */
    public int f40934f;

    /* renamed from: g  reason: collision with root package name */
    public String f40935g;

    /* renamed from: h  reason: collision with root package name */
    public Map f40936h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40937i;
    public JSONObject j;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40934f : invokeV.intValue;
    }

    public JSONObject getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (JSONObject) invokeV.objValue;
    }

    public int getFlowSourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40929a : invokeV.intValue;
    }

    public String getLoginAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40931c : (String) invokeV.objValue;
    }

    public String getLoginOpenid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40932d : (String) invokeV.objValue;
    }

    public LoginType getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40930b : (LoginType) invokeV.objValue;
    }

    public Map getPassThroughInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40936h : (Map) invokeV.objValue;
    }

    public String getPassThroughInfoJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                if (this.f40936h == null || this.f40936h.size() <= 0) {
                    return null;
                }
                return new JSONObject(this.f40936h).toString();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40933e : (String) invokeV.objValue;
    }

    public String getWXAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40935g : (String) invokeV.objValue;
    }

    public boolean isHotStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40937i : invokeV.booleanValue;
    }

    public void setBlockEffectValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f40934f = i2;
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.j = jSONObject;
        }
    }

    public void setFlowSourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f40929a = i2;
        }
    }

    public void setHotStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f40937i = z;
        }
    }

    public void setLoginAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f40931c = str;
        }
    }

    public void setLoginOpenid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f40932d = str;
        }
    }

    public void setLoginType(LoginType loginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, loginType) == null) {
            this.f40930b = loginType;
        }
    }

    public void setPassThroughInfo(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, map) == null) {
            this.f40936h = map;
        }
    }

    public void setUin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f40933e = str;
        }
    }

    public void setWXAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f40935g = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "LoadAdParams{flowSourceId=" + this.f40929a + ", loginType=" + this.f40930b + ", loginAppId=" + this.f40931c + ", loginOpenid=" + this.f40932d + ", uin=" + this.f40933e + ", blockEffect=" + this.f40934f + ", passThroughInfo=" + this.f40936h + ", extraInfo=" + this.j + '}';
        }
        return (String) invokeV.objValue;
    }
}
