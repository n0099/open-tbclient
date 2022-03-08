package com.xiaomi.push;

import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, editor) == null) {
            if (Build.VERSION.SDK_INT > 8) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }
}
