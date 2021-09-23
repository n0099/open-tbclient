package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import c.i.d.c.o0;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
/* loaded from: classes9.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP;
    public static final Comparator<Comparable> NATURAL_ORDER;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableSortedMap<K, V> descendingMap;
    public final transient RegularImmutableSortedSet<K> keySet;
    public final transient ImmutableList<V> valueList;

    /* loaded from: classes9.dex */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Comparator<Object> comparator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableSortedMap};
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
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMap(new b(this.comparator)) : invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements Comparator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Comparator f70847e;

        public a(Comparator comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70847e = comparator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? this.f70847e.compare(entry.getKey(), entry2.getKey()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b<K, V> extends ImmutableMap.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public transient Object[] f70848e;

        /* renamed from: f  reason: collision with root package name */
        public transient Object[] f70849f;

        /* renamed from: g  reason: collision with root package name */
        public final Comparator<? super K> f70850g;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Comparator<? super K> comparator) {
            this(comparator, 4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Comparator) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
                Object[] objArr = this.f70848e;
                if (i2 > objArr.length) {
                    int e2 = ImmutableCollection.b.e(objArr.length, i2);
                    this.f70848e = Arrays.copyOf(this.f70848e, e2);
                    this.f70849f = Arrays.copyOf(this.f70849f, e2);
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
        public ImmutableSortedMap<K, V> a() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i3 = this.f70814c;
                if (i3 != 0) {
                    if (i3 == 1) {
                        return ImmutableSortedMap.of(this.f70850g, this.f70848e[0], this.f70849f[0]);
                    }
                    Object[] copyOf = Arrays.copyOf(this.f70848e, i3);
                    Arrays.sort(copyOf, this.f70850g);
                    Object[] objArr = new Object[this.f70814c];
                    for (int i4 = 0; i4 < this.f70814c; i4++) {
                        if (i4 > 0) {
                            if (this.f70850g.compare(copyOf[i4 - 1], copyOf[i4]) == 0) {
                                throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i2] + " and " + copyOf[i4]);
                            }
                        }
                        objArr[Arrays.binarySearch(copyOf, this.f70848e[i4], this.f70850g)] = this.f70849f[i4];
                    }
                    return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.f70850g), ImmutableList.asImmutableList(objArr));
                }
                return ImmutableSortedMap.emptyMap(this.f70850g);
            }
            return (ImmutableSortedMap) invokeV.objValue;
        }

        public b<K, V> i(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, k, v)) == null) {
                b(this.f70814c + 1);
                m.a(k, v);
                Object[] objArr = this.f70848e;
                int i2 = this.f70814c;
                objArr[i2] = k;
                this.f70849f[i2] = v;
                this.f70814c = i2 + 1;
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public b<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, entry)) == null) {
                super.d(entry);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iterable)) == null) {
                super.e(iterable);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<K, V> l(Map<? extends K, ? extends V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, map)) == null) {
                super.f(map);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b(Comparator<? super K> comparator, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            n.p(comparator);
            this.f70850g = comparator;
            this.f70848e = new Object[i2];
            this.f70849f = new Object[i2];
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1027345679, "Lcom/google/common/collect/ImmutableSortedMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1027345679, "Lcom/google/common/collect/ImmutableSortedMap;");
                return;
            }
        }
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {regularImmutableSortedSet, immutableList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RegularImmutableSortedSet) objArr2[0], (ImmutableList) objArr2[1], (ImmutableSortedMap) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, map)) == null) ? copyOfInternal(map, (Ordering) NATURAL_ORDER) : (ImmutableSortedMap) invokeL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, map, comparator)) == null) {
            boolean z = false;
            if (map instanceof SortedMap) {
                Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
                if (comparator2 == null) {
                    if (comparator == NATURAL_ORDER) {
                        z = true;
                    }
                } else {
                    z = comparator.equals(comparator2);
                }
            }
            if (z && (map instanceof ImmutableSortedMap)) {
                ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
                if (!immutableSortedMap.isPartialView()) {
                    return immutableSortedMap;
                }
            }
            return fromEntries(comparator, z, map.entrySet());
        }
        return (ImmutableSortedMap) invokeLL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sortedMap)) == null) {
            Comparator<? super K> comparator = sortedMap.comparator();
            if (comparator == null) {
                comparator = NATURAL_ORDER;
            }
            if (sortedMap instanceof ImmutableSortedMap) {
                ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
                if (!immutableSortedMap.isPartialView()) {
                    return immutableSortedMap;
                }
            }
            return fromEntries(comparator, true, sortedMap.entrySet());
        }
        return (ImmutableSortedMap) invokeL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, comparator)) == null) {
            if (Ordering.natural().equals(comparator)) {
                return of();
            }
            return new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
        }
        return (ImmutableSortedMap) invokeL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{comparator, Boolean.valueOf(z), iterable})) == null) {
            Map.Entry[] entryArr = (Map.Entry[]) o0.q(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
            return fromEntries(comparator, z, entryArr, entryArr.length);
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }

    private ImmutableSortedMap<K, V> getSubMap(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65551, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == size()) {
                return this;
            }
            if (i2 == i3) {
                return emptyMap(comparator());
            }
            return new ImmutableSortedMap<>(this.keySet.getSubSet(i2, i3), this.valueList.subList(i2, i3));
        }
        return (ImmutableSortedMap) invokeII.objValue;
    }

    public static <K extends Comparable<?>, V> b<K, V> naturalOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? new b<>(Ordering.natural()) : (b) invokeV.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP : (ImmutableSortedMap) invokeV.objValue;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... entryArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, entryArr)) == null) ? fromEntries(Ordering.natural(), false, entryArr, entryArr.length) : (ImmutableSortedMap) invokeL.objValue;
    }

    public static <K, V> b<K, V> orderedBy(Comparator<K> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, comparator)) == null) ? new b<>(comparator) : (b) invokeL.objValue;
    }

    public static <K extends Comparable<?>, V> b<K, V> reverseOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? new b<>(Ordering.natural().reverse()) : (b) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? tailMap((ImmutableSortedMap<K, V>) k, true).firstEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? (K) Maps.p(ceilingEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? keySet().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet<K, V>(this) { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImmutableSortedMap this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? new ImmutableList<Map.Entry<K, V>>(this) { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C1EntrySet this$1;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean isPartialView() {
                        InterceptResult invokeV3;
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || (invokeV3 = interceptable3.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return true;
                        }
                        return invokeV3.booleanValue;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        InterceptResult invokeV3;
                        Interceptable interceptable3 = $ic;
                        return (interceptable3 == null || (invokeV3 = interceptable3.invokeV(1048579, this)) == null) ? this.this$1.this$0.size() : invokeV3.intValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.List
                    public Map.Entry<K, V> get(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable3 = $ic;
                        return (interceptable3 == null || (invokeI = interceptable3.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new AbstractMap.SimpleImmutableEntry(this.this$1.this$0.keySet.asList().get(i2), this.this$1.this$0.valueList.get(i2)) : (Map.Entry) invokeI.objValue;
                    }
                } : (ImmutableList) invokeV2.objValue;
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> map() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.this$0 : (ImmutableMap) invokeV2.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public o1<Map.Entry<K, V>> iterator() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? asList().iterator() : (o1) invokeV2.objValue;
            }
        } : (ImmutableSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (ImmutableSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (ImmutableCollection) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isEmpty()) {
                return null;
            }
            return entrySet().asList().get(0);
        }
        return (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? keySet().first() : (K) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, k)) == null) ? headMap((ImmutableSortedMap<K, V>) k, true).lastEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, k)) == null) ? (K) Maps.p(floorEntry(k)) : (K) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            int indexOf = this.keySet.indexOf(obj);
            if (indexOf == -1) {
                return null;
            }
            return this.valueList.get(indexOf);
        }
        return (V) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z) {
        return headMap((ImmutableSortedMap<K, V>) obj, z);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, k)) == null) ? tailMap((ImmutableSortedMap<K, V>) k, false).firstEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, k)) == null) ? (K) Maps.p(higherEntry(k)) : (K) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.keySet.isPartialView() || this.valueList.isPartialView() : invokeV.booleanValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (isEmpty()) {
                return null;
            }
            return entrySet().asList().get(size() - 1);
        }
        return (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? keySet().last() : (K) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, k)) == null) ? headMap((ImmutableSortedMap<K, V>) k, false).lastEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, k)) == null) ? (K) Maps.p(lowerEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.valueList.size() : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return subMap((boolean) obj, z, (boolean) obj2, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z);
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {regularImmutableSortedSet, immutableList, immutableSortedMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, comparable, obj)) == null) ? of(Ordering.natural(), comparable, obj) : (ImmutableSortedMap) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.keySet.descendingSet() : (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
            if (immutableSortedMap == null) {
                if (isEmpty()) {
                    return emptyMap(Ordering.from(comparator()).reverse());
                }
                return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
            }
            return immutableSortedMap;
        }
        return (ImmutableSortedMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? super.entrySet() : (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.keySet : (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map, c.i.d.c.k
    public ImmutableCollection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.valueList : (ImmutableCollection) invokeV.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, map, comparator)) == null) {
            n.p(comparator);
            return copyOfInternal(map, comparator);
        }
        return (ImmutableSortedMap) invokeLL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z, Map.Entry<K, V>[] entryArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{comparator, Boolean.valueOf(z), entryArr, Integer.valueOf(i2)})) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    Object[] objArr = new Object[i2];
                    Object[] objArr2 = new Object[i2];
                    if (z) {
                        for (int i3 = 0; i3 < i2; i3++) {
                            K key = entryArr[i3].getKey();
                            V value = entryArr[i3].getValue();
                            m.a(key, value);
                            objArr[i3] = key;
                            objArr2[i3] = value;
                        }
                    } else {
                        Arrays.sort(entryArr, 0, i2, new a(comparator));
                        Object key2 = entryArr[0].getKey();
                        objArr[0] = key2;
                        objArr2[0] = entryArr[0].getValue();
                        m.a(objArr[0], objArr2[0]);
                        int i4 = 1;
                        while (i4 < i2) {
                            Object key3 = entryArr[i4].getKey();
                            V value2 = entryArr[i4].getValue();
                            m.a(key3, value2);
                            objArr[i4] = key3;
                            objArr2[i4] = value2;
                            ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", entryArr[i4 - 1], entryArr[i4]);
                            i4++;
                            key2 = key3;
                        }
                    }
                    return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
                }
                return of(comparator, entryArr[0].getKey(), entryArr[0].getValue());
            }
            return emptyMap(comparator);
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, comparator, k, v)) == null) {
            ImmutableList of = ImmutableList.of(k);
            n.p(comparator);
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(of, comparator), ImmutableList.of(v));
        }
        return (ImmutableSortedMap) invokeLLL.objValue;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k)) == null) ? headMap((ImmutableSortedMap<K, V>) k, false) : (ImmutableSortedMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.keySet : (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, k, k2)) == null) ? subMap((boolean) k, true, (boolean) k2, false) : (ImmutableSortedMap) invokeLL.objValue;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, k)) == null) ? tailMap((ImmutableSortedMap<K, V>) k, true) : (ImmutableSortedMap) invokeL.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iterable)) == null) ? copyOf(iterable, (Ordering) NATURAL_ORDER) : (ImmutableSortedMap) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, k, z)) == null) {
            RegularImmutableSortedSet<K> regularImmutableSortedSet = this.keySet;
            n.p(k);
            return getSubMap(0, regularImmutableSortedSet.headIndex(k, z));
        }
        return (ImmutableSortedMap) invokeLZ.objValue;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{k, Boolean.valueOf(z), k2, Boolean.valueOf(z2)})) == null) {
            n.p(k);
            n.p(k2);
            n.l(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
            return headMap((ImmutableSortedMap<K, V>) k2, z2).tailMap((ImmutableSortedMap<K, V>) k, z);
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048617, this, k, z)) == null) {
            RegularImmutableSortedSet<K> regularImmutableSortedSet = this.keySet;
            n.p(k);
            return getSubMap(regularImmutableSortedSet.tailIndex(k, z), size());
        }
        return (ImmutableSortedMap) invokeLZ.objValue;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, iterable, comparator)) == null) {
            n.p(comparator);
            return fromEntries(comparator, false, iterable);
        }
        return (ImmutableSortedMap) invokeLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, comparable, obj, comparable2, obj2)) == null) ? ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2)) : (ImmutableSortedMap) invokeLLLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{comparable, obj, comparable2, obj2, comparable3, obj3})) == null) ? ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3)) : (ImmutableSortedMap) invokeCommon.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{comparable, obj, comparable2, obj2, comparable3, obj3, comparable4, obj4})) == null) ? ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4)) : (ImmutableSortedMap) invokeCommon.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{comparable, obj, comparable2, obj2, comparable3, obj3, comparable4, obj4, comparable5, obj5})) == null) ? ofEntries(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5)) : (ImmutableSortedMap) invokeCommon.objValue;
    }
}
