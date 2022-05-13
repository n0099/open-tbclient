package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static ca2 a(@NonNull aa2 aa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aa2Var)) == null) {
            int i = aa2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new ba2(aa2Var);
                        }
                        return new fa2(aa2Var);
                    }
                    return new da2(aa2Var);
                }
                return new ga2(aa2Var);
            }
            return new ea2(aa2Var);
        }
        return (ca2) invokeL.objValue;
    }
}
