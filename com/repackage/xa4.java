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
public class xa4 extends l94<db4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public a84 d;
    @Nullable
    public a84 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xa4(a84 a84Var, lb4 lb4Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        super(a84Var, lb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a84Var, lb4Var, a84Var2, a84Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a84) objArr2[0], (lb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = a84Var2;
        this.e = a84Var3;
    }

    @Override // com.repackage.l94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: v */
    public boolean f(db4 db4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, db4Var)) == null) ? db4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: w */
    public z84 t(db4 db4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, db4Var)) == null) {
            this.a.E();
            gd4.e(this.b.a(), db4Var.a);
            a84 a84Var = this.a;
            if (a84Var == this.d || a84Var == this.e) {
                a84Var = null;
            }
            sb4.c(db4Var.b, a84Var, this.d, this.e);
            return null;
        }
        return (z84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: x */
    public db4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? md4.q(jSONObject) : (db4) invokeL.objValue;
    }
}
