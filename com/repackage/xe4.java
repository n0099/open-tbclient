package com.repackage;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.we4;
/* loaded from: classes7.dex */
public class xe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, ye4 ye4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, ye4Var) == null) {
            layoutInflater.setFactory2(ye4Var != null ? new we4.a(ye4Var) : null);
        }
    }
}
