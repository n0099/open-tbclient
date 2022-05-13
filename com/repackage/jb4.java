package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jb4 extends y94<pb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb4(String str, n84 n84Var, yb4 yb4Var) {
        super(n84Var, yb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, n84Var, yb4Var};
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
        this.d = str;
    }

    @Override // com.repackage.y94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: v */
    public boolean f(pb4 pb4Var) {
        InterceptResult invokeL;
        List<s94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pb4Var)) == null) {
            if (pb4Var == null || (list = pb4Var.a) == null) {
                return false;
            }
            for (s94 s94Var : list) {
                if (!s94Var.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: w */
    public m94 t(pb4 pb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pb4Var)) == null) {
            this.a.F();
            ae4 ae4Var = new ae4();
            p(pb4Var.a, ae4Var);
            if (ae4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(ae4Var);
            da4.d(pb4Var, this.a);
            return null;
        }
        return (m94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: x */
    public pb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? zd4.i(this.d, jSONObject) : (pb4) invokeL.objValue;
    }
}
