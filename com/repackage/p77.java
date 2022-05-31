package com.repackage;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p77 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755456927, "Lcom/repackage/p77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755456927, "Lcom/repackage/p77;");
                return;
            }
        }
        a = String.valueOf(TbadkCoreApplication.getCurrentAccountId());
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            b(str, null);
        }
    }

    public static void b(String str, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, switchState) == null) {
            StatisticItem param = new StatisticItem(str).param("uid", a);
            if (switchState != null) {
                param.param("obj_type", switchState == BdSwitchView.SwitchState.OFF ? 1 : 2);
            }
            TiebaStatic.log(param);
        }
    }
}
