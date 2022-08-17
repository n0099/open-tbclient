package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class if9 implements hl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ if9 a = new if9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ if9() {
    }

    @Override // com.repackage.hl9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? lg9.c(objectInput) : invokeL.objValue;
    }
}
