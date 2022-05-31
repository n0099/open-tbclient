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
public class u94 extends l84<aa4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u94(String str, a74 a74Var, la4 la4Var) {
        super(a74Var, la4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, a74Var, la4Var};
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
        this.d = str;
    }

    @Override // com.repackage.l84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: v */
    public boolean f(aa4 aa4Var) {
        InterceptResult invokeL;
        List<f84> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aa4Var)) == null) {
            if (aa4Var == null) {
                return false;
            }
            if (aa4Var.a == null && (((list = aa4Var.b) == null || list.isEmpty()) && aa4Var.d == null && aa4Var.f == null && aa4Var.e == null)) {
                return false;
            }
            e84 e84Var = aa4Var.a;
            if (e84Var == null || e84Var.a()) {
                List<f84> list2 = aa4Var.b;
                if (list2 != null) {
                    for (f84 f84Var : list2) {
                        if (!f84Var.a()) {
                            return false;
                        }
                    }
                }
                c84 c84Var = aa4Var.d;
                if (c84Var == null || c84Var.a()) {
                    a84 a84Var = aa4Var.f;
                    if (a84Var == null || a84Var.a()) {
                        PMSAppInfo pMSAppInfo = aa4Var.e;
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
    @Override // com.repackage.l84
    /* renamed from: w */
    public boolean s(aa4 aa4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, aa4Var, i)) == null) {
            if (aa4Var != null) {
                r(aa4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: x */
    public z74 t(aa4 aa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aa4Var)) == null) {
            this.a.F();
            nc4 nc4Var = new nc4();
            o(aa4Var.a, nc4Var);
            p(aa4Var.b, nc4Var);
            n(g(aa4Var.c), nc4Var);
            m(aa4Var.d, nc4Var);
            l(aa4Var.f, nc4Var);
            r(aa4Var.e);
            if (nc4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(nc4Var);
            q84.b(aa4Var, this.a);
            return null;
        }
        return (z74) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: y */
    public aa4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? mc4.g(this.d, jSONObject) : (aa4) invokeL.objValue;
    }
}
