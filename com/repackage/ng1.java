package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ng1 implements cg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public mg1 b;

    public ng1() {
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

    @Override // com.repackage.cg1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mg1 mg1Var = this.b;
            return mg1Var.a(this.a, mg1Var.c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.cg1
    public void a(Context context, dg1 dg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dg1Var) == null) {
            this.a = context;
            mg1 mg1Var = new mg1();
            this.b = mg1Var;
            mg1Var.c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                mg1Var.b = cls;
                mg1Var.a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                mg1Var.c = mg1Var.b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                mg1Var.b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                mg1Var.b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (dg1Var != null) {
                dg1Var.a();
            }
        }
    }
}
