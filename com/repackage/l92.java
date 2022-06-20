package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m92;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l92 implements m92.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public JSONObject b;

    public l92(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        this.b = jSONObject;
        this.a = str;
        try {
            jSONObject.put(IntentConfig.PKG_ID, str);
            if (z) {
                update();
            }
        } catch (JSONException e) {
            if (m92.c0) {
                e.printStackTrace();
            }
        }
    }

    public static l92 query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new l92(str, true) : (l92) invokeL.objValue;
    }

    private void update() throws JSONException {
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && isValid() && (u = n74.i().u(this.a)) != null) {
            this.b.put("app_name", u.appName);
            this.b.put("pkg_vername", u.versionName);
            this.b.put("pkg_vercode", u.versionCode);
            this.b.put("create_time", u.createTime);
            this.b.put("last_launch_time", u.getLastLaunchTime());
            this.b.put("launch_count", u.getLaunchCount());
            this.b.put("install_src", u.getInstallSrc());
        }
    }

    @Override // com.repackage.m92.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.repackage.m92.a
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (JSONObject) invokeV.objValue;
    }

    @Override // com.repackage.m92.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }
}
