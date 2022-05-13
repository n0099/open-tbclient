package com.repackage;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public tc4() {
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

    public static tc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (tc4.class) {
                    if (a == null) {
                        a = new tc4();
                    }
                }
            }
            return a;
        }
        return (tc4) invokeV.objValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || d84.b() == null || d84.b().i() == null) {
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(AlbumActivityConfig.FROM_WEB_VIEW);
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("js");
        boolean o = optJSONArray != null ? d84.b().o(false, optJSONArray) : true;
        boolean o2 = optJSONArray2 != null ? d84.b().o(true, optJSONArray2) : true;
        if (o && o2) {
            d84.b().i().putString("key_online_description_fix_version", optString);
        }
    }
}
