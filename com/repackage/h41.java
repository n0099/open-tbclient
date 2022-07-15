package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h41 extends e41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k41 n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h41() {
        this(new k41());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((k41) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e41
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k41 k41Var = this.n;
            CharSequence charSequence = k41Var.q;
            int B = k41Var.B();
            k41 k41Var2 = this.n;
            k41Var.C(charSequence, B, k41Var2.r, k41Var2.s);
        }
    }

    @Override // com.repackage.e41
    public void p() {
        k41 k41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k41Var = this.n) != null && k41Var.h()) {
            super.p();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e41
    /* renamed from: r */
    public k41 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (k41) invokeV.objValue;
    }

    public void s(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            k41 k41Var = this.n;
            k41Var.r = i;
            k41Var.s = f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h41(k41 k41Var) {
        super(k41Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k41Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((i41) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = k41Var;
    }
}
