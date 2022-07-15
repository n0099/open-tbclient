package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ec4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ec4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ec4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ec4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ec4.class) {
                    if (a == null) {
                        a = new ec4();
                    }
                }
            }
            return a;
        }
        return (ec4) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? q74.b() == null ? "0" : q74.b().i().getString("local_debug_version", "0") : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || q74.b() == null) {
            return;
        }
        q74.b().i().putString("local_debug_version", optString);
        q74.b().i().putString("enable_local_debug_switch", optJSONObject.optString("enable_local_debug_switch"));
        q74.b().i().putString("error_url", optJSONObject.optString("error_url"));
        q74.b().i().putString("auth_white_list", optJSONObject.optString("auth_white_list"));
    }
}
