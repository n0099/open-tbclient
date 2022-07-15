package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes5.dex */
public class ar4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    public ar4() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            jSONObject.optLong("end_time");
            this.a = jSONObject.optString("activity_banner");
            jSONObject.optString("activity_url");
            jSONObject.optString("activity_desc");
            this.b = jSONObject.optString("activity_button");
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void d(YulePostActivity yulePostActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, yulePostActivity) == null) || yulePostActivity == null) {
            return;
        }
        Long l = yulePostActivity.start_time;
        if (l != null) {
            l.longValue();
        }
        Long l2 = yulePostActivity.end_time;
        if (l2 != null) {
            l2.longValue();
        }
        this.a = yulePostActivity.activity_banner;
        String str = yulePostActivity.activity_url;
        String str2 = yulePostActivity.activity_desc;
        this.b = yulePostActivity.activity_button;
    }
}
