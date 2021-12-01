package com.google.gson.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class Primitives {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
    public static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331401061, "Lcom/google/gson/internal/Primitives;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1331401061, "Lcom/google/gson/internal/Primitives;");
                return;
            }
        }
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        add(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        add(hashMap, hashMap2, Byte.TYPE, Byte.class);
        add(hashMap, hashMap2, Character.TYPE, Character.class);
        add(hashMap, hashMap2, Double.TYPE, Double.class);
        add(hashMap, hashMap2, Float.TYPE, Float.class);
        add(hashMap, hashMap2, Integer.TYPE, Integer.class);
        add(hashMap, hashMap2, Long.TYPE, Long.class);
        add(hashMap, hashMap2, Short.TYPE, Short.class);
        add(hashMap, hashMap2, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(hashMap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(hashMap2);
    }

    public Primitives() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    public static void add(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, map, map2, cls, cls2) == null) {
            map.put(cls, cls2);
            map2.put(cls2, cls);
        }
    }

    public static boolean isPrimitive(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, type)) == null) ? PRIMITIVE_TO_WRAPPER_TYPE.containsKey(type) : invokeL.booleanValue;
    }

    public static boolean isWrapperType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, type)) == null) ? WRAPPER_TO_PRIMITIVE_TYPE.containsKey(C$Gson$Preconditions.checkNotNull(type)) : invokeL.booleanValue;
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            Class<T> cls2 = (Class<T>) WRAPPER_TO_PRIMITIVE_TYPE.get(C$Gson$Preconditions.checkNotNull(cls));
            return cls2 == null ? cls : cls2;
        }
        return (Class) invokeL.objValue;
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            Class<T> cls2 = (Class<T>) PRIMITIVE_TO_WRAPPER_TYPE.get(C$Gson$Preconditions.checkNotNull(cls));
            return cls2 == null ? cls : cls2;
        }
        return (Class) invokeL.objValue;
    }
}
