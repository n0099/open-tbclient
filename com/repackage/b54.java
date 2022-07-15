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
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b54 extends s44<vm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755876016, "Lcom/repackage/b54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755876016, "Lcom/repackage/b54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public b54() {
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

    public static b54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b54() : (b54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s44
    /* renamed from: d */
    public boolean b(Context context, vm2 vm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vm2Var, qm2Var, h03Var, jSONObject)) == null) ? g(context, vm2Var, qm2Var, h03Var) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(vm2 vm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vm2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", vm2Var.c);
            bundle.putDouble("latitude", vm2Var.j.a);
            bundle.putDouble("longitude", vm2Var.j.b);
            bundle.putDouble("scale", vm2Var.k);
            bundle.putString("name", vm2Var.z);
            bundle.putString("address", vm2Var.A);
            bundle.putStringArrayList("ignoredApps", vm2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, vm2 vm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, vm2Var, qm2Var, h03Var)) == null) {
            hx1.i("map", "OpenLocationAction start");
            if (!vm2Var.isValid()) {
                hx1.c("map", "model is invalid");
                return false;
            }
            n54.r3(f(vm2Var)).v3();
            hx1.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
