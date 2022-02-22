package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.d1;
import c.i.d.c.o1;
import c.i.d.c.p0;
import c.i.d.c.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements p0<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableListMultimap<V, K> inverse;

    /* loaded from: classes3.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
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
        @Override // com.google.common.collect.ImmutableMultimap.c
        public /* bridge */ /* synthetic */ ImmutableMultimap.c c(Object obj, Object obj2) {
            g(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        public /* bridge */ /* synthetic */ ImmutableMultimap.c d(Map.Entry entry) {
            h(entry);
            return this;
        }

        public ImmutableListMultimap<K, V> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (ImmutableListMultimap) super.a() : (ImmutableListMultimap) invokeV.objValue;
        }

        public a<K, V> g(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
                super.c(k, v);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, entry)) == null) {
                super.d(entry);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iterable)) == null) {
                super.e(iterable);
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i2) {
        super(immutableMap, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableMap, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ImmutableMap) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <K, V> a<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, q0Var)) == null) {
            if (q0Var.isEmpty()) {
                return of();
            }
            if (q0Var instanceof ImmutableListMultimap) {
                ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) q0Var;
                if (!immutableListMultimap.isPartialView()) {
                    return immutableListMultimap;
                }
            }
            return fromMapEntries(q0Var.asMap().entrySet(), null);
        }
        return (ImmutableListMultimap) invokeL.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        InterceptResult invokeLL;
        ImmutableList sortedCopyOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, collection, comparator)) == null) {
            if (collection.isEmpty()) {
                return of();
            }
            ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
            int i2 = 0;
            for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
                K key = entry.getKey();
                Collection<? extends V> value = entry.getValue();
                if (comparator == null) {
                    sortedCopyOf = ImmutableList.copyOf((Collection) value);
                } else {
                    sortedCopyOf = ImmutableList.sortedCopyOf(comparator, value);
                }
                if (!sortedCopyOf.isEmpty()) {
                    bVar.c(key, sortedCopyOf);
                    i2 += sortedCopyOf.size();
                }
            }
            return new ImmutableListMultimap<>(bVar.a(), i2);
        }
        return (ImmutableListMultimap) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableListMultimap$a */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableListMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            a builder = builder();
            o1 it = entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                builder.g(entry.getValue(), entry.getKey());
            }
            ImmutableListMultimap<V, K> f2 = builder.f();
            f2.inverse = this;
            return f2;
        }
        return (ImmutableListMultimap) invokeV.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? EmptyImmutableListMultimap.INSTANCE : (ImmutableListMultimap) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int readInt = objectInputStream.readInt();
            if (readInt >= 0) {
                ImmutableMap.b builder = ImmutableMap.builder();
                int i2 = 0;
                for (int i3 = 0; i3 < readInt; i3++) {
                    Object readObject = objectInputStream.readObject();
                    int readInt2 = objectInputStream.readInt();
                    if (readInt2 > 0) {
                        ImmutableList.a builder2 = ImmutableList.builder();
                        for (int i4 = 0; i4 < readInt2; i4++) {
                            builder2.h(objectInputStream.readObject());
                        }
                        builder.c(readObject, builder2.j());
                        i2 += readInt2;
                    } else {
                        throw new InvalidObjectException("Invalid value count " + readInt2);
                    }
                }
                try {
                    ImmutableMultimap.d.a.b(this, builder.a());
                    ImmutableMultimap.d.f54843b.a(this, i2);
                    return;
                } catch (IllegalArgumentException e2) {
                    throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
                }
            }
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            d1.j(this, objectOutputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, k, v)) == null) {
            a builder = builder();
            builder.g(k, v);
            return builder.f();
        }
        return (ImmutableListMultimap) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
            if (immutableListMultimap == null) {
                ImmutableListMultimap<V, K> invert = invert();
                this.inverse = invert;
                return invert;
            }
            return immutableListMultimap;
        }
        return (ImmutableListMultimap) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public ImmutableList<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
            return immutableList == null ? ImmutableList.of() : immutableList;
        }
        return (ImmutableList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableList) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, iterable)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableList) invokeLL.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, k, v, k2, v2)) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            return builder.f();
        }
        return (ImmutableListMultimap) invokeLLLL.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            a aVar = new a();
            aVar.i(iterable);
            return aVar.f();
        }
        return (ImmutableListMultimap) invokeL.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            return builder.f();
        }
        return (ImmutableListMultimap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            builder.g(k4, v4);
            return builder.f();
        }
        return (ImmutableListMultimap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            builder.g(k4, v4);
            builder.g(k5, v5);
            return builder.f();
        }
        return (ImmutableListMultimap) invokeCommon.objValue;
    }
}
