package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
/* loaded from: classes5.dex */
public class ah0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }
}
