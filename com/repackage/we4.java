package com.repackage;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ve4;
/* loaded from: classes7.dex */
public class we4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, xe4 xe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, xe4Var) == null) {
            layoutInflater.setFactory2(xe4Var != null ? new ve4.a(xe4Var) : null);
        }
    }
}
