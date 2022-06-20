package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class jy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> T a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            try {
                return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(cls + " can't init new instance by default constructor.", e);
            }
        }
        return (T) invokeL.objValue;
    }
}
