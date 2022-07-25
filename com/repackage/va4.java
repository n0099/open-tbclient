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
public class va4 extends m94<bb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va4(String str, b84 b84Var, mb4 mb4Var) {
        super(b84Var, mb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, b84Var, mb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b84) objArr2[0], (mb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    @Override // com.repackage.m94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: v */
    public boolean f(bb4 bb4Var) {
        InterceptResult invokeL;
        List<g94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bb4Var)) == null) {
            if (bb4Var == null) {
                return false;
            }
            if (bb4Var.a == null && (((list = bb4Var.b) == null || list.isEmpty()) && bb4Var.d == null && bb4Var.f == null && bb4Var.e == null)) {
                return false;
            }
            f94 f94Var = bb4Var.a;
            if (f94Var == null || f94Var.a()) {
                List<g94> list2 = bb4Var.b;
                if (list2 != null) {
                    for (g94 g94Var : list2) {
                        if (!g94Var.a()) {
                            return false;
                        }
                    }
                }
                d94 d94Var = bb4Var.d;
                if (d94Var == null || d94Var.a()) {
                    b94 b94Var = bb4Var.f;
                    if (b94Var == null || b94Var.a()) {
                        PMSAppInfo pMSAppInfo = bb4Var.e;
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
    @Override // com.repackage.m94
    /* renamed from: w */
    public boolean s(bb4 bb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bb4Var, i)) == null) {
            if (bb4Var != null) {
                r(bb4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: x */
    public a94 t(bb4 bb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bb4Var)) == null) {
            this.a.E();
            od4 od4Var = new od4();
            o(bb4Var.a, od4Var);
            p(bb4Var.b, od4Var);
            n(g(bb4Var.c), od4Var);
            m(bb4Var.d, od4Var);
            l(bb4Var.f, od4Var);
            r(bb4Var.e);
            if (od4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(od4Var);
            r94.b(bb4Var, this.a);
            return null;
        }
        return (a94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m94
    /* renamed from: y */
    public bb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? nd4.g(this.d, jSONObject) : (bb4) invokeL.objValue;
    }
}
