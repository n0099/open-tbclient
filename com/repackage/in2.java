package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class in2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755612764, "Lcom/repackage/in2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755612764, "Lcom/repackage/in2;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public in2() {
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

    public static in2 a(JSONObject jSONObject, in2 in2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, in2Var)) == null) {
            in2 in2Var2 = new in2();
            if (jSONObject != null) {
                in2Var2.a = jSONObject.optString("audioId", in2Var.a);
                in2Var2.b = jSONObject.optString("slaveId", in2Var.b);
                in2Var2.e = jSONObject.optBoolean("autoplay", in2Var.e);
                in2Var2.f = jSONObject.optBoolean("loop", in2Var.f);
                in2Var2.c = jSONObject.optString("src", in2Var.c);
                in2Var2.d = jSONObject.optInt(FetchLog.START_TIME, in2Var.d);
                in2Var2.g = jSONObject.optBoolean("obeyMuteSwitch", in2Var.g);
                in2Var2.h = jSONObject.optInt(CriusAttrConstants.POSITION, in2Var.h);
                in2Var2.i = (float) jSONObject.optDouble("volume", in2Var.i);
                in2Var2.j = jSONObject.optString("cb", in2Var.j);
            }
            return in2Var2;
        }
        return (in2) invokeLL.objValue;
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
