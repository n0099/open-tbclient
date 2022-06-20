package com.repackage;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, bool)) == null) {
            if (SwitchManager.getInstance().findType("voice") != 0 || ((str != null && b(str)) || bool == null)) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] stringArray = TbadkCoreApplication.getInst().getApp().getResources().getStringArray(R.array.obfuscated_res_0x7f030014);
            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0646);
            int length = stringArray.length;
            for (int i = 0; i < length; i++) {
                if (stringArray[i].equals(str)) {
                    return true;
                }
                if (str.equals(stringArray[i] + string)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
