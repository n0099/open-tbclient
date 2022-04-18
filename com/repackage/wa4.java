package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wa4 extends n94<cb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa4(String str, c84 c84Var, nb4 nb4Var) {
        super(c84Var, nb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, c84Var, nb4Var};
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
        this.d = str;
    }

    @Override // com.repackage.n94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: v */
    public boolean f(cb4 cb4Var) {
        InterceptResult invokeL;
        List<h94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cb4Var)) == null) {
            if (cb4Var == null) {
                return false;
            }
            if (cb4Var.a == null && (((list = cb4Var.b) == null || list.isEmpty()) && cb4Var.d == null && cb4Var.f == null && cb4Var.e == null)) {
                return false;
            }
            g94 g94Var = cb4Var.a;
            if (g94Var == null || g94Var.a()) {
                List<h94> list2 = cb4Var.b;
                if (list2 != null) {
                    for (h94 h94Var : list2) {
                        if (!h94Var.a()) {
                            return false;
                        }
                    }
                }
                e94 e94Var = cb4Var.d;
                if (e94Var == null || e94Var.a()) {
                    c94 c94Var = cb4Var.f;
                    if (c94Var == null || c94Var.a()) {
                        PMSAppInfo pMSAppInfo = cb4Var.e;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: w */
    public boolean s(cb4 cb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cb4Var, i)) == null) {
            if (cb4Var != null) {
                r(cb4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: x */
    public b94 t(cb4 cb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cb4Var)) == null) {
            this.a.F();
            pd4 pd4Var = new pd4();
            o(cb4Var.a, pd4Var);
            p(cb4Var.b, pd4Var);
            n(g(cb4Var.c), pd4Var);
            m(cb4Var.d, pd4Var);
            l(cb4Var.f, pd4Var);
            r(cb4Var.e);
            if (pd4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(pd4Var);
            s94.b(cb4Var, this.a);
            return null;
        }
        return (b94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: y */
    public cb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? od4.g(this.d, jSONObject) : (cb4) invokeL.objValue;
    }
}
