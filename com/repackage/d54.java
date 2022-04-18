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
/* loaded from: classes5.dex */
public class d54 extends u44<xm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755816434, "Lcom/repackage/d54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755816434, "Lcom/repackage/d54;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public d54() {
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

    public static d54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new d54() : (d54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u44
    /* renamed from: d */
    public boolean b(Context context, xm2 xm2Var, sm2 sm2Var, j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xm2Var, sm2Var, j03Var, jSONObject)) == null) ? g(context, xm2Var, sm2Var, j03Var) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(xm2 xm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xm2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", xm2Var.c);
            bundle.putDouble("latitude", xm2Var.j.a);
            bundle.putDouble("longitude", xm2Var.j.b);
            bundle.putDouble(AnimationProperty.SCALE, xm2Var.k);
            bundle.putString("name", xm2Var.z);
            bundle.putString("address", xm2Var.A);
            bundle.putStringArrayList("ignoredApps", xm2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, xm2 xm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, xm2Var, sm2Var, j03Var)) == null) {
            jx1.i("map", "OpenLocationAction start");
            if (!xm2Var.isValid()) {
                jx1.c("map", "model is invalid");
                return false;
            }
            p54.q3(f(xm2Var)).u3();
            jx1.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
