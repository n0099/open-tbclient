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
public class m44 extends d44<gm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549276, "Lcom/repackage/m44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549276, "Lcom/repackage/m44;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    public m44() {
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

    public static m44 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new m44() : (m44) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d44
    /* renamed from: d */
    public boolean b(Context context, gm2 gm2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gm2Var, bm2Var, sz2Var, jSONObject)) == null) ? g(context, gm2Var, bm2Var, sz2Var) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(gm2 gm2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gm2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", gm2Var.c);
            bundle.putDouble("latitude", gm2Var.j.a);
            bundle.putDouble("longitude", gm2Var.j.b);
            bundle.putDouble(AnimationProperty.SCALE, gm2Var.k);
            bundle.putString("name", gm2Var.z);
            bundle.putString("address", gm2Var.A);
            bundle.putStringArrayList("ignoredApps", gm2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, gm2 gm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, gm2Var, bm2Var, sz2Var)) == null) {
            sw1.i("map", "OpenLocationAction start");
            if (!gm2Var.isValid()) {
                sw1.c("map", "model is invalid");
                return false;
            }
            y44.r3(f(gm2Var)).v3();
            sw1.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
