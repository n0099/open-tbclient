package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ky3 implements vh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public ky3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    @Override // com.repackage.vh1
    public void a(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, os1Var) == null) || os1Var == null) {
            return;
        }
        d(os1Var.B("action"), os1Var.B("menuItemName"));
    }

    @Override // com.repackage.vh1
    public void b(m64 m64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m64Var) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (m64Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                m64Var.l(id.intValue());
            }
        }
    }

    public final boolean c(m64 m64Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m64Var, str)) == null) {
            Integer a = ly3.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (m64Var != null) {
                    m64Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                ul2 U = ul2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                qz1 V = U.V();
                dw3 dw3Var = V != null ? (dw3) V.n(dw3.class) : null;
                m64 x3 = dw3Var != null ? dw3Var.x3() : null;
                if (x3 != null && dw3Var != null) {
                    dw3Var.J3(true);
                }
                return c(x3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
