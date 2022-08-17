package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r5) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, str)) == null) {
            short b = b(i);
            int i2 = R.string.obfuscated_res_0x7f0f0acf;
            if (b != 2) {
                if (b != 9) {
                    if (b == 4) {
                        i2 = R.string.obfuscated_res_0x7f0f0ad1;
                    } else if (b != 5) {
                        if (b == 6) {
                            i2 = R.string.obfuscated_res_0x7f0f0ad0;
                        }
                        i2 = -1;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f0ad2;
                    }
                }
            }
            return i2 != -1 ? TbadkCoreApplication.getInst().getResources().getString(i2) : str;
        }
        return (String) invokeIL.objValue;
    }

    public static short b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case -100000306:
                    return (short) 6;
                case -100000303:
                    return (short) 2;
                case 3160010:
                    return (short) 5;
                case 3160011:
                    return (short) 4;
                default:
                    return (short) 9;
            }
        }
        return invokeI.shortValue;
    }
}
