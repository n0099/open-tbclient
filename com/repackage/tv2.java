package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public Object c;
    public boolean d;
    public String e;

    public tv2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.b = str;
    }

    public static String a(sv2 sv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sv2Var)) == null) {
            if (sv2Var == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("componentId", sv2Var.f);
                jSONObject.put("pluginProvider", sv2Var.b);
                jSONObject.put("args", sv2Var.g);
                jSONObject.put("slaveId", sv2Var.e);
            } catch (JSONException e) {
                aw2.b(Log.getStackTraceString(e));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oa2 oa2Var = new oa2();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "functionPageFinished");
                jSONObject.put("componentId", this.b);
                jSONObject.put("isSuccess", this.d);
                jSONObject.put("data", this.e);
                if (this.c != null) {
                    jSONObject.put("error", this.c.toString());
                }
            } catch (JSONException e) {
                aw2.b(Log.getStackTraceString(e));
            }
            oa2Var.c = jSONObject;
            vl2.U().m(this.a, oa2Var);
            aw2.b("finish event, isSuccess = " + this.d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.b + "', error=" + this.c + ", isSuccess=" + this.d + ", resultData='" + this.e + "'}";
        }
        return (String) invokeV.objValue;
    }
}
