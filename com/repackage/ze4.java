package com.repackage;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ye4;
/* loaded from: classes7.dex */
public class ze4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, af4Var) == null) {
            layoutInflater.setFactory2(af4Var != null ? new ye4.a(af4Var) : null);
        }
    }
}
