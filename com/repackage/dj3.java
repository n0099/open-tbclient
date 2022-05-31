package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j) == null) {
            cj3.a().edit().putLong("latest_update_time", j).apply();
        }
    }
}
