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
public class ya4 extends m94<eb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b84 d;
    @Nullable
    public b84 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya4(b84 b84Var, mb4 mb4Var, @Nullable b84 b84Var2, @Nullable b84 b84Var3) {
        super(b84Var, mb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b84Var, mb4Var, b84Var2, b84Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b84) objArr2[0], (mb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = b84Var2;
        this.e = b84Var3;
    }

    @Override // com.repackage.m94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: v */
    public boolean f(eb4 eb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eb4Var)) == null) ? eb4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: w */
    public a94 t(eb4 eb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eb4Var)) == null) {
            this.a.E();
            hd4.e(this.b.a(), eb4Var.a);
            b84 b84Var = this.a;
            if (b84Var == this.d || b84Var == this.e) {
                b84Var = null;
            }
            tb4.c(eb4Var.b, b84Var, this.d, this.e);
            return null;
        }
        return (a94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: x */
    public eb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? nd4.q(jSONObject) : (eb4) invokeL.objValue;
    }
}
