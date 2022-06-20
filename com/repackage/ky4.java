package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ky4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755542549, "Lcom/repackage/ky4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755542549, "Lcom/repackage/ky4;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (oi.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return ht4.k().l("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
                return -1;
            }
            int a2 = a();
            return a2 != 2 ? a2 != 3 ? a2 != 4 ? a2 != 6 ? a2 != 8 ? R.drawable.obfuscated_res_0x7f0807fb : R.drawable.obfuscated_res_0x7f0807f8 : R.drawable.obfuscated_res_0x7f0807fc : R.drawable.obfuscated_res_0x7f0807f9 : R.drawable.obfuscated_res_0x7f0807fb : R.drawable.obfuscated_res_0x7f0807f7;
        }
        return invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            long j = a;
            if (j >= 0) {
                return j;
            }
            if (!oi.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                a = ht4.k().m("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            return a;
        }
        return invokeV.longValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) || i <= 0 || oi.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        ht4.k().w("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
        ht4.k().D("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount());
        a = 0L;
    }

    public static void e(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65541, null, j) == null) || oi.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        ht4.k().x("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), j);
        a = j;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = -1L;
        }
    }
}
