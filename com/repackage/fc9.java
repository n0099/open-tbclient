package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class fc9 implements ki9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ fc9 a = new fc9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ fc9() {
    }

    @Override // com.repackage.ki9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? od9.h(objectInput) : invokeL.objValue;
    }
}
