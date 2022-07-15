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
public class ua4 extends l94<ab4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua4(String str, a84 a84Var, lb4 lb4Var) {
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
    public boolean f(ab4 ab4Var) {
        InterceptResult invokeL;
        List<f94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ab4Var)) == null) {
            if (ab4Var == null) {
                return false;
            }
            if (ab4Var.a == null && (((list = ab4Var.b) == null || list.isEmpty()) && ab4Var.d == null && ab4Var.f == null && ab4Var.e == null)) {
                return false;
            }
            e94 e94Var = ab4Var.a;
            if (e94Var == null || e94Var.a()) {
                List<f94> list2 = ab4Var.b;
                if (list2 != null) {
                    for (f94 f94Var : list2) {
                        if (!f94Var.a()) {
                            return false;
                        }
                    }
                }
                c94 c94Var = ab4Var.d;
                if (c94Var == null || c94Var.a()) {
                    a94 a94Var = ab4Var.f;
                    if (a94Var == null || a94Var.a()) {
                        PMSAppInfo pMSAppInfo = ab4Var.e;
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
    @Override // com.repackage.l94
    /* renamed from: w */
    public boolean s(ab4 ab4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, ab4Var, i)) == null) {
            if (ab4Var != null) {
                r(ab4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: x */
    public z84 t(ab4 ab4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ab4Var)) == null) {
            this.a.E();
            nd4 nd4Var = new nd4();
            o(ab4Var.a, nd4Var);
            p(ab4Var.b, nd4Var);
            n(g(ab4Var.c), nd4Var);
            m(ab4Var.d, nd4Var);
            l(ab4Var.f, nd4Var);
            r(ab4Var.e);
            if (nd4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(nd4Var);
            q94.b(ab4Var, this.a);
            return null;
        }
        return (z84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: y */
    public ab4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? md4.g(this.d, jSONObject) : (ab4) invokeL.objValue;
    }
}
