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
/* loaded from: classes7.dex */
public final class xy3 implements ii1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public xy3() {
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

    @Override // com.repackage.ii1
    public void a(bt1 bt1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bt1Var) == null) || bt1Var == null) {
            return;
        }
        d(bt1Var.B("action"), bt1Var.B("menuItemName"));
    }

    @Override // com.repackage.ii1
    public void b(z64 z64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z64Var) == null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (z64Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                z64Var.m(id.intValue());
            }
        }
    }

    public final boolean c(z64 z64Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, z64Var, str)) == null) {
            Integer a = yy3.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (z64Var != null) {
                    z64Var.m(a.intValue());
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
                hm2 U = hm2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                d02 V = U.V();
                qw3 qw3Var = V != null ? (qw3) V.n(qw3.class) : null;
                z64 w3 = qw3Var != null ? qw3Var.w3() : null;
                if (w3 != null && qw3Var != null) {
                    qw3Var.I3(true);
                }
                return c(w3, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
