package com.repackage;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ks0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65536, null, activity, z) == null) || activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().addFlags(128);
        } else {
            activity.getWindow().clearFlags(128);
        }
    }
}
