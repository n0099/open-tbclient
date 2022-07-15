package com.repackage;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static q15 a(Context context, u15 u15Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, u15Var, i)) == null) {
            if (i != 1) {
                return new DLauncher(context, u15Var);
            }
            return new BLauncher(context, u15Var);
        }
        return (q15) invokeLLI.objValue;
    }
}
