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
public class pb4 extends da4<vb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public s84 d;
    @Nullable
    public s84 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb4(s84 s84Var, dc4 dc4Var, @Nullable s84 s84Var2, @Nullable s84 s84Var3) {
        super(s84Var, dc4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s84Var, dc4Var, s84Var2, s84Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s84) objArr2[0], (dc4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = s84Var2;
        this.e = s84Var3;
    }

    @Override // com.repackage.da4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: v */
    public boolean f(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vb4Var)) == null) ? vb4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: w */
    public r94 t(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vb4Var)) == null) {
            this.a.E();
            yd4.e(this.b.a(), vb4Var.a);
            s84 s84Var = this.a;
            if (s84Var == this.d || s84Var == this.e) {
                s84Var = null;
            }
            kc4.c(vb4Var.b, s84Var, this.d, this.e);
            return null;
        }
        return (r94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: x */
    public vb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? ee4.q(jSONObject) : (vb4) invokeL.objValue;
    }
}
