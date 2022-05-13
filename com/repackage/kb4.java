package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kb4 extends y94<qb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public n84 d;
    @Nullable
    public n84 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb4(n84 n84Var, yb4 yb4Var, @Nullable n84 n84Var2, @Nullable n84 n84Var3) {
        super(n84Var, yb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n84Var, yb4Var, n84Var2, n84Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((n84) objArr2[0], (yb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = n84Var2;
        this.e = n84Var3;
    }

    @Override // com.repackage.y94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: v */
    public boolean f(qb4 qb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qb4Var)) == null) ? qb4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: w */
    public m94 t(qb4 qb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qb4Var)) == null) {
            this.a.F();
            td4.e(this.b.a(), qb4Var.a);
            n84 n84Var = this.a;
            if (n84Var == this.d || n84Var == this.e) {
                n84Var = null;
            }
            fc4.c(qb4Var.b, n84Var, this.d, this.e);
            return null;
        }
        return (m94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: x */
    public qb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? zd4.q(jSONObject) : (qb4) invokeL.objValue;
    }
}
