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
/* loaded from: classes6.dex */
public class hb4 extends y94<nb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb4(String str, n84 n84Var, yb4 yb4Var) {
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
    public boolean f(nb4 nb4Var) {
        InterceptResult invokeL;
        List<s94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nb4Var)) == null) {
            if (nb4Var == null) {
                return false;
            }
            if (nb4Var.a == null && (((list = nb4Var.b) == null || list.isEmpty()) && nb4Var.d == null && nb4Var.f == null && nb4Var.e == null)) {
                return false;
            }
            r94 r94Var = nb4Var.a;
            if (r94Var == null || r94Var.a()) {
                List<s94> list2 = nb4Var.b;
                if (list2 != null) {
                    for (s94 s94Var : list2) {
                        if (!s94Var.a()) {
                            return false;
                        }
                    }
                }
                p94 p94Var = nb4Var.d;
                if (p94Var == null || p94Var.a()) {
                    n94 n94Var = nb4Var.f;
                    if (n94Var == null || n94Var.a()) {
                        PMSAppInfo pMSAppInfo = nb4Var.e;
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
    @Override // com.repackage.y94
    /* renamed from: w */
    public boolean s(nb4 nb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, nb4Var, i)) == null) {
            if (nb4Var != null) {
                r(nb4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: x */
    public m94 t(nb4 nb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, nb4Var)) == null) {
            this.a.F();
            ae4 ae4Var = new ae4();
            o(nb4Var.a, ae4Var);
            p(nb4Var.b, ae4Var);
            n(g(nb4Var.c), ae4Var);
            m(nb4Var.d, ae4Var);
            l(nb4Var.f, ae4Var);
            r(nb4Var.e);
            if (ae4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(ae4Var);
            da4.b(nb4Var, this.a);
            return null;
        }
        return (m94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: y */
    public nb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? zd4.g(this.d, jSONObject) : (nb4) invokeL.objValue;
    }
}
