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
public class fa4 extends w84<la4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa4(String str, l74 l74Var, wa4 wa4Var) {
        super(l74Var, wa4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, l74Var, wa4Var};
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
        this.d = str;
    }

    @Override // com.repackage.w84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: v */
    public boolean f(la4 la4Var) {
        InterceptResult invokeL;
        List<q84> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, la4Var)) == null) {
            if (la4Var == null) {
                return false;
            }
            if (la4Var.a == null && (((list = la4Var.b) == null || list.isEmpty()) && la4Var.d == null && la4Var.f == null && la4Var.e == null)) {
                return false;
            }
            p84 p84Var = la4Var.a;
            if (p84Var == null || p84Var.a()) {
                List<q84> list2 = la4Var.b;
                if (list2 != null) {
                    for (q84 q84Var : list2) {
                        if (!q84Var.a()) {
                            return false;
                        }
                    }
                }
                n84 n84Var = la4Var.d;
                if (n84Var == null || n84Var.a()) {
                    l84 l84Var = la4Var.f;
                    if (l84Var == null || l84Var.a()) {
                        PMSAppInfo pMSAppInfo = la4Var.e;
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
    @Override // com.repackage.w84
    /* renamed from: w */
    public boolean s(la4 la4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, la4Var, i)) == null) {
            if (la4Var != null) {
                r(la4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: x */
    public k84 t(la4 la4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, la4Var)) == null) {
            this.a.E();
            yc4 yc4Var = new yc4();
            o(la4Var.a, yc4Var);
            p(la4Var.b, yc4Var);
            n(g(la4Var.c), yc4Var);
            m(la4Var.d, yc4Var);
            l(la4Var.f, yc4Var);
            r(la4Var.e);
            if (yc4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(yc4Var);
            b94.b(la4Var, this.a);
            return null;
        }
        return (k84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: y */
    public la4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? xc4.g(this.d, jSONObject) : (la4) invokeL.objValue;
    }
}
