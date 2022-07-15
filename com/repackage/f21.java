package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class f21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull a31 a31Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, a31Var, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        a31Var.loadUrl(str, null);
    }

    public static <T> void b(@NonNull a31 a31Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{a31Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            a(a31Var, "NadJsControl.visibleRectChange(".concat(String.valueOf(i)).concat(",").concat(String.valueOf(i2)).concat(",").concat(String.valueOf(i3)).concat(",").concat(String.valueOf(i4)).concat(");"));
        }
    }
}
