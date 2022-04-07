package com.repackage;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ry4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (ni.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return wt4.k().l("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
                return -1;
            }
            int a = a();
            return a != 2 ? a != 3 ? a != 4 ? a != 6 ? a != 8 ? R.drawable.obfuscated_res_0x7f080827 : R.drawable.obfuscated_res_0x7f080824 : R.drawable.obfuscated_res_0x7f080828 : R.drawable.obfuscated_res_0x7f080825 : R.drawable.obfuscated_res_0x7f080827 : R.drawable.obfuscated_res_0x7f080823;
        }
        return invokeV.intValue;
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, null, i) == null) || i <= 0 || ni.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        wt4.k().w("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
    }
}
