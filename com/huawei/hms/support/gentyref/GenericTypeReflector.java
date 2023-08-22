package com.huawei.hms.support.gentyref;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes10.dex */
public final class GenericTypeReflector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GenericTypeReflector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Class<?> getType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, type)) == null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) type).getRawType();
            }
            if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                if (typeVariable.getBounds().length == 0) {
                    return Object.class;
                }
                return getType(typeVariable.getBounds()[0]);
            }
            throw new IllegalArgumentException("not supported: " + type.getClass());
        }
        return (Class) invokeL.objValue;
    }
}
