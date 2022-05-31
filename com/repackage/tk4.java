package com.repackage;

import android.os.Build;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tk4 extends cs4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk4(as4 as4Var) {
        super(as4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {as4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((as4) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @ds4(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MODEL;
            int k = li.k(getContext());
            int i = li.i(getContext());
            String str3 = String.valueOf(k) + "," + String.valueOf(i);
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            try {
                jSONObject.put("systemName", "android");
                jSONObject.put("systemVersion", str);
                jSONObject.put("model", str2);
                jSONObject.put("cuid", cuid);
                jSONObject.put("resolution", str3);
                jSONObject.put("appVersion", versionName);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @ds4(isAsync = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (ji.H()) {
                i = 1;
                str = "WIFI";
            } else if (ji.t()) {
                i = 3;
                str = "2G";
            } else if (ji.u()) {
                i = 4;
                str = "3G";
            } else if (ji.v()) {
                i = 5;
                str = "4G";
            } else {
                i = 0;
                str = "NotReachable";
            }
            try {
                jSONObject.put("netStatus", i);
                jSONObject.put("netDesc", str);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @ds4(isAsync = false, value = "showToast")
    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        BdToast.c(getContext(), jSONObject.optString("message")).n();
    }

    @Override // com.repackage.cs4
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Utils" : (String) invokeV.objValue;
    }
}
