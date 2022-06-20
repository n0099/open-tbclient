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
public class ia4 extends w84<oa4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public l74 d;
    @Nullable
    public l74 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia4(l74 l74Var, wa4 wa4Var, @Nullable l74 l74Var2, @Nullable l74 l74Var3) {
        super(l74Var, wa4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l74Var, wa4Var, l74Var2, l74Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((l74) objArr2[0], (wa4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = l74Var2;
        this.e = l74Var3;
    }

    @Override // com.repackage.w84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: v */
    public boolean f(oa4 oa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oa4Var)) == null) ? oa4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: w */
    public k84 t(oa4 oa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, oa4Var)) == null) {
            this.a.E();
            rc4.e(this.b.a(), oa4Var.a);
            l74 l74Var = this.a;
            if (l74Var == this.d || l74Var == this.e) {
                l74Var = null;
            }
            db4.c(oa4Var.b, l74Var, this.d, this.e);
            return null;
        }
        return (k84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: x */
    public oa4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? xc4.q(jSONObject) : (oa4) invokeL.objValue;
    }
}
