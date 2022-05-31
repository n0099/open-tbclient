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
public class x94 extends l84<da4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public a74 d;
    @Nullable
    public a74 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x94(a74 a74Var, la4 la4Var, @Nullable a74 a74Var2, @Nullable a74 a74Var3) {
        super(a74Var, la4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a74Var, la4Var, a74Var2, a74Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a74) objArr2[0], (la4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = a74Var2;
        this.e = a74Var3;
    }

    @Override // com.repackage.l84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: v */
    public boolean f(da4 da4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, da4Var)) == null) ? da4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: w */
    public z74 t(da4 da4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, da4Var)) == null) {
            this.a.F();
            gc4.e(this.b.a(), da4Var.a);
            a74 a74Var = this.a;
            if (a74Var == this.d || a74Var == this.e) {
                a74Var = null;
            }
            sa4.c(da4Var.b, a74Var, this.d, this.e);
            return null;
        }
        return (z74) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: x */
    public da4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? mc4.q(jSONObject) : (da4) invokeL.objValue;
    }
}
