package com.repackage;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragmentActivity, i)) == null) {
            if (TbadkCoreApplication.getInst().appResponseToCmd(i)) {
                return true;
            }
            c(baseFragmentActivity);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean b(BaseFragmentActivity baseFragmentActivity, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, baseFragmentActivity, cls)) == null) {
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(cls)) {
                return true;
            }
            c(baseFragmentActivity);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void c(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, baseFragmentActivity) == null) || baseFragmentActivity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 10) {
            baseFragmentActivity.showToast(R.string.obfuscated_res_0x7f0f0e72);
        } else {
            baseFragmentActivity.showToast(R.string.obfuscated_res_0x7f0f0e71);
        }
    }
}
