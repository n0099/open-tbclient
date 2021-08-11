package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.j;
import c.i.d.a.n;
import c.i.d.c.d1;
import c.i.d.c.e1;
import c.i.d.c.o1;
import c.i.d.c.q0;
import c.i.d.c.y0;
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
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements e1<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ImmutableSet<V> emptySet;
    public transient ImmutableSet<Map.Entry<K, V>> entries;
    public transient ImmutableSetMultimap<V, K> inverse;

    /* loaded from: classes10.dex */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient ImmutableSetMultimap<K, V> multimap;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableSetMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return this.multimap.containsEntry(entry.getKey(), entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.multimap.size() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public o1<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.multimap.entryIterator() : (o1) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // com.google.common.collect.ImmutableMultimap.c
        public Collection<V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? y0.g() : (Collection) invokeV.objValue;
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

        public ImmutableSetMultimap<K, V> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Collection entrySet = this.f70126a.entrySet();
                Comparator<? super K> comparator = this.f70127b;
                if (comparator != null) {
                    entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
                }
                return ImmutableSetMultimap.fromMapEntries(entrySet, this.f70128c);
            }
            return (ImmutableSetMultimap) invokeV.objValue;
        }

        public a<K, V> g(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
                super.c(k, v);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, entry)) == null) {
                super.d(entry);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
                super.e(iterable);
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d1.b<ImmutableSetMultimap> f70147a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1989380813, "Lcom/google/common/collect/ImmutableSetMultimap$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1989380813, "Lcom/google/common/collect/ImmutableSetMultimap$b;");
                    return;
                }
            }
            f70147a = d1.a(ImmutableSetMultimap.class, "emptySet");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i2, Comparator<? super V> comparator) {
        super(immutableMap, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableMap, Integer.valueOf(i2), comparator};
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
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, q0Var)) == null) ? copyOf(q0Var, null) : (ImmutableSetMultimap) invokeL.objValue;
    }

    public static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, comparator)) == null) {
            if (comparator == null) {
                return ImmutableSet.of();
            }
            return ImmutableSortedSet.emptySet(comparator);
        }
        return (ImmutableSet) invokeL.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, collection, comparator)) == null) {
            if (collection.isEmpty()) {
                return of();
            }
            ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
            int i2 = 0;
            for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
                K key = entry.getKey();
                ImmutableSet valueSet = valueSet(comparator, entry.getValue());
                if (!valueSet.isEmpty()) {
                    bVar.c(key, valueSet);
                    i2 += valueSet.size();
                }
            }
            return new ImmutableSetMultimap<>(bVar.a(), i2, comparator);
        }
        return (ImmutableSetMultimap) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableSetMultimap$a */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            a builder = builder();
            o1 it = entries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                builder.g(entry.getValue(), entry.getKey());
            }
            ImmutableSetMultimap<V, K> f2 = builder.f();
            f2.inverse = this;
            return f2;
        }
        return (ImmutableSetMultimap) invokeV.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? EmptyImmutableSetMultimap.INSTANCE : (ImmutableSetMultimap) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            Comparator comparator = (Comparator) objectInputStream.readObject();
            int readInt = objectInputStream.readInt();
            if (readInt >= 0) {
                ImmutableMap.b builder = ImmutableMap.builder();
                int i2 = 0;
                for (int i3 = 0; i3 < readInt; i3++) {
                    Object readObject = objectInputStream.readObject();
                    int readInt2 = objectInputStream.readInt();
                    if (readInt2 > 0) {
                        ImmutableSet.a valuesBuilder = valuesBuilder(comparator);
                        for (int i4 = 0; i4 < readInt2; i4++) {
                            valuesBuilder.a(objectInputStream.readObject());
                        }
                        ImmutableSet l = valuesBuilder.l();
                        if (l.size() == readInt2) {
                            builder.c(readObject, l);
                            i2 += readInt2;
                        } else {
                            throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
                        }
                    } else {
                        throw new InvalidObjectException("Invalid value count " + readInt2);
                    }
                }
                try {
                    ImmutableMultimap.d.f70129a.b(this, builder.a());
                    ImmutableMultimap.d.f70130b.a(this, i2);
                    b.f70147a.b(this, emptySet(comparator));
                    return;
                } catch (IllegalArgumentException e2) {
                    throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
                }
            }
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    public static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, comparator, collection)) == null) {
            if (comparator == null) {
                return ImmutableSet.copyOf((Collection) collection);
            }
            return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
        }
        return (ImmutableSet) invokeLL.objValue;
    }

    public static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, comparator)) == null) ? comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.a(comparator) : (ImmutableSet.a) invokeL.objValue;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(valueComparator());
            d1.j(this, objectOutputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    public Comparator<? super V> valueComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ImmutableSet<V> immutableSet = this.emptySet;
            if (immutableSet instanceof ImmutableSortedSet) {
                return ((ImmutableSortedSet) immutableSet).comparator();
            }
            return null;
        }
        return (Comparator) invokeV.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(q0<? extends K, ? extends V> q0Var, Comparator<? super V> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, q0Var, comparator)) == null) {
            n.p(q0Var);
            if (q0Var.isEmpty() && comparator == null) {
                return of();
            }
            if (q0Var instanceof ImmutableSetMultimap) {
                ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) q0Var;
                if (!immutableSetMultimap.isPartialView()) {
                    return immutableSetMultimap;
                }
            }
            return fromMapEntries(q0Var.asMap().entrySet(), comparator);
        }
        return (ImmutableSetMultimap) invokeLL.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, k, v)) == null) {
            a builder = builder();
            builder.g(k, v);
            return builder.f();
        }
        return (ImmutableSetMultimap) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
            if (immutableSetMultimap == null) {
                ImmutableSetMultimap<V, K> invert = invert();
                this.inverse = invert;
                return invert;
            }
            return immutableSetMultimap;
        }
        return (ImmutableSetMultimap) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    public ImmutableSet<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
            if (immutableSet == null) {
                EntrySet entrySet = new EntrySet(this);
                this.entries = entrySet;
                return entrySet;
            }
            return immutableSet;
        }
        return (ImmutableSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    public ImmutableSet<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) ? (ImmutableSet) j.a((ImmutableSet) this.map.get(k), this.emptySet) : (ImmutableSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.q0
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSet) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultimap, c.i.d.c.c, c.i.d.c.q0
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, iterable)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSet) invokeLL.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, k, v, k2, v2)) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            return builder.f();
        }
        return (ImmutableSetMultimap) invokeLLLL.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable)) == null) {
            a aVar = new a();
            aVar.i(iterable);
            return aVar.f();
        }
        return (ImmutableSetMultimap) invokeL.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            return builder.f();
        }
        return (ImmutableSetMultimap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            builder.g(k4, v4);
            return builder.f();
        }
        return (ImmutableSetMultimap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5})) == null) {
            a builder = builder();
            builder.g(k, v);
            builder.g(k2, v2);
            builder.g(k3, v3);
            builder.g(k4, v4);
            builder.g(k5, v5);
            return builder.f();
        }
        return (ImmutableSetMultimap) invokeCommon.objValue;
    }
}
