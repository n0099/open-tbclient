package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class za4 extends n94<fb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public c84 d;
    @Nullable
    public c84 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za4(c84 c84Var, nb4 nb4Var, @Nullable c84 c84Var2, @Nullable c84 c84Var3) {
        super(c84Var, nb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c84Var, nb4Var, c84Var2, c84Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c84) objArr2[0], (nb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = c84Var2;
        this.e = c84Var3;
    }

    @Override // com.repackage.n94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: v */
    public boolean f(fb4 fb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fb4Var)) == null) ? fb4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: w */
    public b94 t(fb4 fb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fb4Var)) == null) {
            this.a.F();
            id4.e(this.b.a(), fb4Var.a);
            c84 c84Var = this.a;
            if (c84Var == this.d || c84Var == this.e) {
                c84Var = null;
            }
            ub4.c(fb4Var.b, c84Var, this.d, this.e);
            return null;
        }
        return (b94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: x */
    public fb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? od4.q(jSONObject) : (fb4) invokeL.objValue;
    }
}
