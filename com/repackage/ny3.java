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
public final class ny3 implements xh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public ny3() {
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

    @Override // com.repackage.xh1
    public void a(qs1 qs1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qs1Var) == null) || qs1Var == null) {
            return;
        }
        d(qs1Var.B("action"), qs1Var.B("menuItemName"));
    }

    @Override // com.repackage.xh1
    public void b(p64 p64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p64Var) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (p64Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                p64Var.m(id.intValue());
            }
        }
    }

    public final boolean c(p64 p64Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, p64Var, str)) == null) {
            Integer a = oy3.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (p64Var != null) {
                    p64Var.m(a.intValue());
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
                wl2 U = wl2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                sz1 V = U.V();
                fw3 fw3Var = V != null ? (fw3) V.n(fw3.class) : null;
                p64 w3 = fw3Var != null ? fw3Var.w3() : null;
                if (w3 != null && fw3Var != null) {
                    fw3Var.I3(true);
                }
                return c(w3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
