package com.repackage;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            switch (i) {
                case 2001:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b2);
                case 2002:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b4);
                case 2003:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b1);
                case 2004:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b5);
                case 2005:
                default:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b2);
                case 2006:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b3);
                case 2007:
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f01b0);
            }
        }
        return (String) invokeI.objValue;
    }
}
