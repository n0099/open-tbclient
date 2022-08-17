package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.sl9;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class ff9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ ff9 a = new ff9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ ff9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? sl9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
