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
public class mb4 extends da4<sb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb4(String str, s84 s84Var, dc4 dc4Var) {
        super(s84Var, dc4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, s84Var, dc4Var};
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
        this.d = str;
    }

    @Override // com.repackage.da4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: v */
    public boolean f(sb4 sb4Var) {
        InterceptResult invokeL;
        List<x94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sb4Var)) == null) {
            if (sb4Var == null) {
                return false;
            }
            if (sb4Var.a == null && (((list = sb4Var.b) == null || list.isEmpty()) && sb4Var.d == null && sb4Var.f == null && sb4Var.e == null)) {
                return false;
            }
            w94 w94Var = sb4Var.a;
            if (w94Var == null || w94Var.a()) {
                List<x94> list2 = sb4Var.b;
                if (list2 != null) {
                    for (x94 x94Var : list2) {
                        if (!x94Var.a()) {
                            return false;
                        }
                    }
                }
                u94 u94Var = sb4Var.d;
                if (u94Var == null || u94Var.a()) {
                    s94 s94Var = sb4Var.f;
                    if (s94Var == null || s94Var.a()) {
                        PMSAppInfo pMSAppInfo = sb4Var.e;
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
    @Override // com.repackage.da4
    /* renamed from: w */
    public boolean s(sb4 sb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, sb4Var, i)) == null) {
            if (sb4Var != null) {
                r(sb4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: x */
    public r94 t(sb4 sb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sb4Var)) == null) {
            this.a.E();
            fe4 fe4Var = new fe4();
            o(sb4Var.a, fe4Var);
            p(sb4Var.b, fe4Var);
            n(g(sb4Var.c), fe4Var);
            m(sb4Var.d, fe4Var);
            l(sb4Var.f, fe4Var);
            r(sb4Var.e);
            if (fe4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(fe4Var);
            ia4.b(sb4Var, this.a);
            return null;
        }
        return (r94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.da4
    /* renamed from: y */
    public sb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? ee4.g(this.d, jSONObject) : (sb4) invokeL.objValue;
    }
}
