package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.k;
import c.i.d.c.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements k<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ImmutableMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMap(new a()) : invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b c(Object obj, Object obj2) {
            i(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b d(Map.Entry entry) {
            j(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b e(Iterable iterable) {
            k(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b f(Map map) {
            l(map);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: h */
        public ImmutableBiMap<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f70814c == 0) {
                    return ImmutableBiMap.of();
                }
                g();
                this.f70815d = true;
                return new RegularImmutableBiMap(this.f70813b, this.f70814c);
            }
            return (ImmutableBiMap) invokeV.objValue;
        }

        public a<K, V> i(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, k, v)) == null) {
                super.c(k, v);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, entry)) == null) {
                super.d(entry);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iterable)) == null) {
                super.e(iterable);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<K, V> l(Map<? extends K, ? extends V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, map)) == null) {
                super.f(map);
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    public ImmutableBiMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <K, V> a<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            m.b(i2, "expectedSize");
            return new a<>(i2);
        }
        return (a) invokeI.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map instanceof ImmutableBiMap) {
                ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
                if (!immutableBiMap.isPartialView()) {
                    return immutableBiMap;
                }
            }
            return copyOf((Iterable) map.entrySet());
        }
        return (ImmutableBiMap) invokeL.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? RegularImmutableBiMap.EMPTY : (ImmutableBiMap) invokeV.objValue;
    }

    @Override // c.i.d.c.k
    @Deprecated
    public V forcePut(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.k
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, k, v)) == null) {
            m.a(k, v);
            return new RegularImmutableBiMap(new Object[]{k, v}, 1);
        }
        return (ImmutableBiMap) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (ImmutableSet) invokeV.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, k, v, k2, v2)) == null) {
            m.a(k, v);
            m.a(k2, v2);
            return new RegularImmutableBiMap(new Object[]{k, v, k2, v2}, 2);
        }
        return (ImmutableBiMap) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map, c.i.d.c.k
    public ImmutableSet<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? inverse().keySet() : (ImmutableSet) invokeV.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
            aVar.k(iterable);
            return aVar.a();
        }
        return (ImmutableBiMap) invokeL.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            m.a(k, v);
            m.a(k2, v2);
            m.a(k3, v3);
            return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3}, 3);
        }
        return (ImmutableBiMap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4})) == null) {
            m.a(k, v);
            m.a(k2, v2);
            m.a(k3, v3);
            m.a(k4, v4);
            return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
        }
        return (ImmutableBiMap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5})) == null) {
            m.a(k, v);
            m.a(k2, v2);
            m.a(k3, v3);
            m.a(k4, v4);
            m.a(k5, v5);
            return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
        }
        return (ImmutableBiMap) invokeCommon.objValue;
    }
}
