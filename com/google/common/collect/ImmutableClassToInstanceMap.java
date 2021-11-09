package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.c.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends d0<Class<? extends B>, B> implements Object<B>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableClassToInstanceMap<Object> EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class b<B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ImmutableMap.b<Class<? extends B>, B> f63337a;

        public b() {
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
            this.f63337a = ImmutableMap.builder();
        }

        public static <B, T extends B> T b(Class<T> cls, B b2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, b2)) == null) ? (T) b.i.d.g.a.d(cls).cast(b2) : (T) invokeLL.objValue;
        }

        public ImmutableClassToInstanceMap<B> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ImmutableMap<Class<? extends B>, B> a2 = this.f63337a.a();
                if (a2.isEmpty()) {
                    return ImmutableClassToInstanceMap.of();
                }
                return new ImmutableClassToInstanceMap<>(a2, null);
            }
            return (ImmutableClassToInstanceMap) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.ImmutableMap$b<java.lang.Class<? extends B>, B> */
        /* JADX WARN: Multi-variable type inference failed */
        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
                for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                    Class<? extends T> key = entry.getKey();
                    this.f63337a.c(key, b(key, entry.getValue()));
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1517706830, "Lcom/google/common/collect/ImmutableClassToInstanceMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1517706830, "Lcom/google/common/collect/ImmutableClassToInstanceMap;");
                return;
            }
        }
        EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap immutableMap, a aVar) {
        this(immutableMap);
    }

    public static <B> b<B> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new b<>() : (b) invokeV.objValue;
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map instanceof ImmutableClassToInstanceMap) {
                return (ImmutableClassToInstanceMap) map;
            }
            b bVar = new b();
            bVar.c(map);
            return bVar.a();
        }
        return (ImmutableClassToInstanceMap) invokeL.objValue;
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ImmutableClassToInstanceMap<B>) EMPTY : (ImmutableClassToInstanceMap) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T extends B, java.lang.Object] */
    public <T extends B> T getInstance(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            ImmutableMap<Class<? extends B>, B> immutableMap = this.delegate;
            n.p(cls);
            return immutableMap.get(cls);
        }
        return (T) invokeL.objValue;
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, t)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeLL.objValue;
    }

    public Object readResolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? isEmpty() ? of() : this : invokeV.objValue;
    }

    public ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, t)) == null) ? new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t)) : (ImmutableClassToInstanceMap) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.d0, b.i.d.c.h0
    public Map<Class<? extends B>, B> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.delegate : (Map) invokeV.objValue;
    }
}
