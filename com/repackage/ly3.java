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
public final class ly3 implements wh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public ly3() {
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

    @Override // com.repackage.wh1
    public void a(ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ps1Var) == null) || ps1Var == null) {
            return;
        }
        d(ps1Var.B("action"), ps1Var.B("menuItemName"));
    }

    @Override // com.repackage.wh1
    public void b(n64 n64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n64Var) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (n64Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                n64Var.l(id.intValue());
            }
        }
    }

    public final boolean c(n64 n64Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, n64Var, str)) == null) {
            Integer a = my3.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (n64Var != null) {
                    n64Var.l(a.intValue());
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
                vl2 U = vl2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                rz1 V = U.V();
                ew3 ew3Var = V != null ? (ew3) V.n(ew3.class) : null;
                n64 x3 = ew3Var != null ? ew3Var.x3() : null;
                if (x3 != null && ew3Var != null) {
                    ew3Var.J3(true);
                }
                return c(x3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
