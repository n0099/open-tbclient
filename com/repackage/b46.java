package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public HashMap<String, String> b;
    public boolean c;

    public b46() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public HashMap<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (HashMap) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONObject2 = optJSONObject.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.a = optJSONObject2.optString("link");
        this.c = optJSONObject2.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject2.optJSONArray(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.b = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString("rule");
                if (!oi.isEmpty(optString) && !oi.isEmpty(optString2)) {
                    this.b.put(optString, optString2);
                }
            }
        }
    }
}
