package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public float i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225481, "Lcom/repackage/vn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225481, "Lcom/repackage/vn2;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public vn2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = 0;
        this.i = 1.0f;
    }

    public static vn2 a(JSONObject jSONObject, vn2 vn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, vn2Var)) == null) {
            vn2 vn2Var2 = new vn2();
            if (jSONObject != null) {
                vn2Var2.a = jSONObject.optString("audioId", vn2Var.a);
                vn2Var2.b = jSONObject.optString("slaveId", vn2Var.b);
                vn2Var2.e = jSONObject.optBoolean("autoplay", vn2Var.e);
                vn2Var2.f = jSONObject.optBoolean("loop", vn2Var.f);
                vn2Var2.c = jSONObject.optString("src", vn2Var.c);
                vn2Var2.d = jSONObject.optInt(FetchLog.START_TIME, vn2Var.d);
                vn2Var2.g = jSONObject.optBoolean("obeyMuteSwitch", vn2Var.g);
                vn2Var2.h = jSONObject.optInt("position", vn2Var.h);
                vn2Var2.i = (float) jSONObject.optDouble("volume", vn2Var.i);
                vn2Var2.j = jSONObject.optString("cb", vn2Var.j);
            }
            return vn2Var2;
        }
        return (vn2) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "playerId : " + this.a + "; slaveId : " + this.b + "; url : " + this.c + "; AutoPlay : " + this.e + "; Loop : " + this.f + "; startTime : " + this.d + "; ObeyMute : " + this.g + "; pos : " + this.h;
        }
        return (String) invokeV.objValue;
    }
}
