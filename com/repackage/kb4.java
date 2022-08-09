package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kb4 extends da4<qb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb4(s84 s84Var, dc4 dc4Var) {
        super(s84Var, dc4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s84Var, dc4Var};
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
    }

    @Override // com.repackage.da4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: v */
    public r94 e(String str, qb4 qb4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, qb4Var)) == null) {
            if (qb4Var != null && (i = qb4Var.a) != 0) {
                return new r94(i, qb4Var.b);
            }
            return super.e(str, qb4Var);
        }
        return (r94) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.da4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(qb4 qb4Var) {
        InterceptResult invokeL;
        List<y94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qb4Var)) == null) {
            if (qb4Var == null || (list = qb4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (y94 y94Var : qb4Var.c) {
                if (y94Var == null || !y94Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            dc4 dc4Var = this.b;
            return !(dc4Var instanceof wb4) || ((wb4) dc4Var).f().size() == qb4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: x */
    public r94 t(qb4 qb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qb4Var)) == null) {
            this.a.E();
            fe4 fe4Var = new fe4();
            n(qb4Var.c, fe4Var);
            if (fe4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(fe4Var);
            ia4.f(qb4Var.c, this.a);
            return null;
        }
        return (r94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: y */
    public qb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? ee4.e(jSONObject) : (qb4) invokeL.objValue;
    }
}
