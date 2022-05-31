package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nf1 implements cf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public mf1 b;

    public nf1() {
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

    @Override // com.repackage.cf1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mf1 mf1Var = this.b;
            return mf1Var.a(this.a, mf1Var.c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.cf1
    public void a(Context context, df1 df1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, df1Var) == null) {
            this.a = context;
            mf1 mf1Var = new mf1();
            this.b = mf1Var;
            mf1Var.c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                mf1Var.b = cls;
                mf1Var.a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                mf1Var.c = mf1Var.b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                mf1Var.b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                mf1Var.b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (df1Var != null) {
                df1Var.a();
            }
        }
    }
}
