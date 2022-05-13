package com.repackage;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o54 extends f54<in2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755488733, "Lcom/repackage/o54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755488733, "Lcom/repackage/o54;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public o54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static o54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new o54() : (o54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f54
    /* renamed from: d */
    public boolean b(Context context, in2 in2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, in2Var, dn2Var, u03Var, jSONObject)) == null) ? g(context, in2Var, dn2Var, u03Var) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(in2 in2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, in2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", in2Var.c);
            bundle.putDouble("latitude", in2Var.j.a);
            bundle.putDouble("longitude", in2Var.j.b);
            bundle.putDouble(AnimationProperty.SCALE, in2Var.k);
            bundle.putString("name", in2Var.z);
            bundle.putString("address", in2Var.A);
            bundle.putStringArrayList("ignoredApps", in2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, in2 in2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, in2Var, dn2Var, u03Var)) == null) {
            ux1.i("map", "OpenLocationAction start");
            if (!in2Var.isValid()) {
                ux1.c("map", "model is invalid");
                return false;
            }
            a64.q3(f(in2Var)).u3();
            ux1.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
