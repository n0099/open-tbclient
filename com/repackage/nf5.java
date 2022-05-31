package com.repackage;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i != 80) {
                return -1;
            }
            return z ? R.anim.obfuscated_res_0x7f0100c5 : R.anim.obfuscated_res_0x7f0100c6;
        }
        return invokeCommon.intValue;
    }
}
