package com.bytedance.sdk.openadsdk.preload.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Class<? super T> f31891b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f31892c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31893d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Type a2 = a(getClass());
        this.f31892c = a2;
        this.f31891b = (Class<? super T>) b.e(a2);
        this.f31893d = this.f31892c.hashCode();
    }

    public static Type a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof Class)) {
                return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            }
            throw new RuntimeException("Missing type parameter.");
        }
        return (Type) invokeL.objValue;
    }

    public final Type b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31892c : (Type) invokeV.objValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof a) && b.a(this.f31892c, ((a) obj).f31892c) : invokeL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31893d : invokeV.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.f(this.f31892c) : (String) invokeV.objValue;
    }

    public static <T> a<T> b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, cls)) == null) ? new a<>(cls) : (a) invokeL.objValue;
    }

    public a(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Type d2 = b.d((Type) com.bytedance.sdk.openadsdk.preload.a.b.a.a(type));
        this.f31892c = d2;
        this.f31891b = (Class<? super T>) b.e(d2);
        this.f31893d = this.f31892c.hashCode();
    }

    public final Class<? super T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31891b : (Class) invokeV.objValue;
    }

    public static a<?> a(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, type)) == null) ? new a<>(type) : (a) invokeL.objValue;
    }
}
