package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wa4 extends l94<cb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa4(String str, a84 a84Var, lb4 lb4Var) {
        super(a84Var, lb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, a84Var, lb4Var};
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
        this.d = str;
    }

    @Override // com.repackage.l94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: v */
    public boolean f(cb4 cb4Var) {
        InterceptResult invokeL;
        List<f94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cb4Var)) == null) {
            if (cb4Var == null || (list = cb4Var.a) == null) {
                return false;
            }
            for (f94 f94Var : list) {
                if (!f94Var.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: w */
    public z84 t(cb4 cb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cb4Var)) == null) {
            this.a.E();
            nd4 nd4Var = new nd4();
            p(cb4Var.a, nd4Var);
            if (nd4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(nd4Var);
            q94.d(cb4Var, this.a);
            return null;
        }
        return (z84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: x */
    public cb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? md4.i(this.d, jSONObject) : (cb4) invokeL.objValue;
    }
}
