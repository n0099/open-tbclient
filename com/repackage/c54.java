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
public class c54 extends t44<wm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846225, "Lcom/repackage/c54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846225, "Lcom/repackage/c54;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    public c54() {
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

    public static c54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new c54() : (c54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t44
    /* renamed from: d */
    public boolean b(Context context, wm2 wm2Var, rm2 rm2Var, i03 i03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wm2Var, rm2Var, i03Var, jSONObject)) == null) ? g(context, wm2Var, rm2Var, i03Var) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(wm2 wm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wm2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", wm2Var.c);
            bundle.putDouble("latitude", wm2Var.j.a);
            bundle.putDouble("longitude", wm2Var.j.b);
            bundle.putDouble("scale", wm2Var.k);
            bundle.putString("name", wm2Var.z);
            bundle.putString("address", wm2Var.A);
            bundle.putStringArrayList("ignoredApps", wm2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, wm2 wm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, wm2Var, rm2Var, i03Var)) == null) {
            ix1.i("map", "OpenLocationAction start");
            if (!wm2Var.isValid()) {
                ix1.c("map", "model is invalid");
                return false;
            }
            o54.r3(f(wm2Var)).v3();
            ix1.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
