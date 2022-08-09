package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class af9 implements fl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ af9 a = new af9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ af9() {
    }

    @Override // com.repackage.fl9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? jg9.h(objectInput) : invokeL.objValue;
    }
}
