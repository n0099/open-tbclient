package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sg5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, nw4Var) == null) || nw4Var == null) {
            return;
        }
        if (nw4Var.b != 0) {
            wt4.k().y("app_entrance_nologin", nw4Var.b + "");
        }
        if (nw4Var.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        wt4.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), nw4Var.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = wt4.k().q("app_entrance_nologin", "");
            } else {
                wt4 k = wt4.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = mg.e(q, 0);
            return (e != 1 && e == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
