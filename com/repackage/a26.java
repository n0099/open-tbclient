package com.repackage;

import android.os.Trace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && tm4.e()) {
            Trace.endSection();
        }
    }

    public static final void b(String name) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, name) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (tm4.e()) {
                Trace.beginSection(name);
            }
        }
    }
}
