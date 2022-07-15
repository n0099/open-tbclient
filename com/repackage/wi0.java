package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public ui0 k;

    public wi0() {
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

    public static String a(@NonNull wi0 wi0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wi0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", wi0Var.a);
                jSONObject.put("cmd", wi0Var.b);
                jSONObject.put("defer_cmd", wi0Var.c);
                jSONObject.put("init_text", wi0Var.d);
                jSONObject.put("opt_icon", wi0Var.e);
                jSONObject.put("opt_text", wi0Var.f);
                jSONObject.put("app_icon_url", wi0Var.g);
                jSONObject.put("app_name", wi0Var.h);
                jSONObject.put("version_code", wi0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, wi0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
