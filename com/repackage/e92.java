package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static p92 a(@NonNull n92 n92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, n92Var)) == null) {
            int i = n92Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new o92(n92Var);
                        }
                        return new s92(n92Var);
                    }
                    return new q92(n92Var);
                }
                return new t92(n92Var);
            }
            return new r92(n92Var);
        }
        return (p92) invokeL.objValue;
    }
}
