package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sj5() {
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

    public static void b(sx4 sx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, sx4Var) == null) || sx4Var == null) {
            return;
        }
        if (sx4Var.b != 0) {
            ru4.k().y("app_entrance_nologin", sx4Var.b + "");
        }
        if (sx4Var.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ru4.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), sx4Var.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = ru4.k().q("app_entrance_nologin", "");
            } else {
                ru4 k = ru4.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = og.e(q, 0);
            return (e != 1 && e == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
