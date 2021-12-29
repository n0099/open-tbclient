package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.d0;
import c.i.d.c.e0;
import c.i.d.c.j0;
import c.i.d.c.k0;
import c.i.d.c.m1;
import c.i.d.c.o1;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Converter;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public final class Maps {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.d.c.k<A, B> bimap;

        public BiMapConverter(c.i.d.c.k<A, B> kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.d.a.n.p(kVar);
            this.bimap = kVar;
        }

        public static <X, Y> Y convert(c.i.d.c.k<X, Y> kVar, X x) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, kVar, x)) == null) {
                Y y = kVar.get(x);
                c.i.d.a.n.k(y != null, "No non-null mapping present for input: %s", x);
                return y;
            }
            return (Y) invokeLL.objValue;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2)) == null) ? (A) convert(this.bimap.inverse(), b2) : (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a)) == null) ? (B) convert(this.bimap, a) : (B) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter, c.i.d.a.g
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof BiMapConverter) {
                    return this.bimap.equals(((BiMapConverter) obj).bimap);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bimap.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Maps.asConverter(" + this.bimap + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static abstract class EntryFunction implements c.i.d.a.g<Map.Entry<?, ?>, Object> {
        public static final /* synthetic */ EntryFunction[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EntryFunction KEY;
        public static final EntryFunction VALUE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1616910863, "Lcom/google/common/collect/Maps$EntryFunction;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1616910863, "Lcom/google/common/collect/Maps$EntryFunction;");
                    return;
                }
            }
            KEY = new EntryFunction("KEY", 0) { // from class: com.google.common.collect.Maps.EntryFunction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (c) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.Maps.EntryFunction, c.i.d.a.g
                public Object apply(Map.Entry<?, ?> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getKey() : invokeL.objValue;
                }
            };
            EntryFunction entryFunction = new EntryFunction("VALUE", 1) { // from class: com.google.common.collect.Maps.EntryFunction.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (c) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.Maps.EntryFunction, c.i.d.a.g
                public Object apply(Map.Entry<?, ?> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getValue() : invokeL.objValue;
                }
            };
            VALUE = entryFunction;
            $VALUES = new EntryFunction[]{KEY, entryFunction};
        }

        public EntryFunction(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EntryFunction valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (EntryFunction) Enum.valueOf(EntryFunction.class, str) : (EntryFunction) invokeL.objValue;
        }

        public static EntryFunction[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (EntryFunction[]) $VALUES.clone() : (EntryFunction[]) invokeV.objValue;
        }

        @Override // c.i.d.a.g
        public abstract /* synthetic */ T apply(F f2);

        public /* synthetic */ EntryFunction(String str, int i2, c cVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class UnmodifiableBiMap<K, V> extends d0<K, V> implements c.i.d.c.k<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.d.c.k<? extends K, ? extends V> delegate;
        public c.i.d.c.k<V, K> inverse;
        public final Map<K, V> unmodifiableMap;
        public transient Set<V> values;

        public UnmodifiableBiMap(c.i.d.c.k<? extends K, ? extends V> kVar, c.i.d.c.k<V, K> kVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, kVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.unmodifiableMap = Collections.unmodifiableMap(kVar);
            this.delegate = kVar;
            this.inverse = kVar2;
        }

        @Override // c.i.d.c.k
        public V forcePut(K k2, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k2, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V) invokeLL.objValue;
        }

        @Override // c.i.d.c.k
        public c.i.d.c.k<V, K> inverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.i.d.c.k<V, K> kVar = this.inverse;
                if (kVar == null) {
                    UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
                    this.inverse = unmodifiableBiMap;
                    return unmodifiableBiMap;
                }
                return kVar;
            }
            return (c.i.d.c.k) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.d0, c.i.d.c.h0
        public Map<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.unmodifiableMap : (Map) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.d0, java.util.Map
        public Set<V> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Set<V> set = this.values;
                if (set == null) {
                    Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
                    this.values = unmodifiableSet;
                    return unmodifiableSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class UnmodifiableNavigableMap<K, V> extends k0<K, V> implements NavigableMap<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NavigableMap<K, ? extends V> delegate;
        public transient UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) ? Maps.M(this.delegate.ceilingEntry(k2)) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2)) == null) ? this.delegate.ceilingKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Sets.m(this.delegate.descendingKeySet()) : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
                if (unmodifiableNavigableMap == null) {
                    UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
                    this.descendingMap = unmodifiableNavigableMap2;
                    return unmodifiableNavigableMap2;
                }
                return unmodifiableNavigableMap;
            }
            return (NavigableMap) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Maps.M(this.delegate.firstEntry()) : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k2)) == null) ? Maps.M(this.delegate.floorEntry(k2)) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k2)) == null) ? this.delegate.floorKey(k2) : (K) invokeL.objValue;
        }

        @Override // c.i.d.c.k0, java.util.SortedMap
        public SortedMap<K, V> headMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k2)) == null) ? headMap(k2, false) : (SortedMap) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, k2)) == null) ? Maps.M(this.delegate.higherEntry(k2)) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k2)) == null) ? this.delegate.higherKey(k2) : (K) invokeL.objValue;
        }

        @Override // c.i.d.c.d0, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? navigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Maps.M(this.delegate.lastEntry()) : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, k2)) == null) ? Maps.M(this.delegate.lowerEntry(k2)) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k2)) == null) ? this.delegate.lowerKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Sets.m(this.delegate.navigableKeySet()) : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // c.i.d.c.k0, java.util.SortedMap
        public SortedMap<K, V> subMap(K k2, K k3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, k2, k3)) == null) ? subMap(k2, true, k3, false) : (SortedMap) invokeLL.objValue;
        }

        @Override // c.i.d.c.k0, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, k2)) == null) ? tailMap(k2, true) : (SortedMap) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, k2, z)) == null) ? Maps.L(this.delegate.headMap(k2, z)) : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k2, boolean z, K k3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{k2, Boolean.valueOf(z), k3, Boolean.valueOf(z2)})) == null) ? Maps.L(this.delegate.subMap(k2, z, k3, z2)) : (NavigableMap) invokeCommon.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, k2, z)) == null) ? Maps.L(this.delegate.tailMap(k2, z)) : (NavigableMap) invokeLZ.objValue;
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap, unmodifiableNavigableMap};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.k0, c.i.d.c.d0, c.i.d.c.h0
        public SortedMap<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.unmodifiableSortedMap(this.delegate) : (SortedMap) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends c.i.d.c.b<K, V2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f56907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f56908f;

        public a(Map.Entry entry, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56907e = entry;
            this.f56908f = lVar;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, K] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, K] */
        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56907e.getKey() : invokeV.objValue;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, V2] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, V2] */
        @Override // c.i.d.c.b, java.util.Map.Entry
        public V2 getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56908f.a(this.f56907e.getKey(), this.f56907e.getValue()) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c.i.d.a.g<Map.Entry<K, V1>, Map.Entry<K, V2>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f56909e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56909e = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.a.g
        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? Maps.F(this.f56909e, entry) : (Map.Entry) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends m1<Map.Entry<K, V>, K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, K] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, K] */
        @Override // c.i.d.c.m1
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getKey() : invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends m1<Map.Entry<K, V>, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [V, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [V, java.lang.Object] */
        @Override // c.i.d.c.m1
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.getValue() : invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends m1<K, Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.i.d.a.g f56910f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Iterator it, c.i.d.a.g gVar) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56910f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.m1
        /* renamed from: b */
        public Map.Entry<K, V> a(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2)) == null) ? Maps.l(k2, this.f56910f.apply(k2)) : (Map.Entry) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c.i.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f56911e;

        public f(Map.Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56911e = entry;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, K] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, K] */
        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56911e.getKey() : invokeV.objValue;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [V, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [V, java.lang.Object] */
        @Override // c.i.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56911e.getValue() : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends o1<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterator f56912e;

        public g(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56912e = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Maps.I((Map.Entry) this.f56912e.next()) : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56912e.hasNext() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements l<K, V1, V2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.i.d.a.g a;

        public h(c.i.d.a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, V2] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, V2] */
        @Override // com.google.common.collect.Maps.l
        public V2 a(K k2, V1 v1) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k2, v1)) == null) ? this.a.apply(v1) : invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class i<K, V> extends y<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final Map<K, V> f56913h;

        /* renamed from: i  reason: collision with root package name */
        public final c.i.d.a.o<? super Map.Entry<K, V>> f56914i;

        public i(Map<K, V> map, c.i.d.a.o<? super Map.Entry<K, V>> oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56913h = map;
            this.f56914i = oVar;
        }

        @Override // com.google.common.collect.Maps.y
        public Collection<V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new o(this, this.f56913h, this.f56914i) : (Collection) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f56913h.containsKey(obj) && d(obj, this.f56913h.get(obj)) : invokeL.booleanValue;
        }

        public boolean d(Object obj, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, v)) == null) ? this.f56914i.apply(Maps.l(obj, v)) : invokeLL.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                V v = this.f56913h.get(obj);
                if (v == null || !d(obj, v)) {
                    return null;
                }
                return v;
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? entrySet().isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k2, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k2, v)) == null) {
                c.i.d.a.n.d(d(k2, v));
                return this.f56913h.put(k2, v);
            }
            return (V) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
                for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                    c.i.d.a.n.d(d(entry.getKey(), entry.getValue()));
                }
                this.f56913h.putAll(map);
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (containsKey(obj)) {
                    return this.f56913h.remove(obj);
                }
                return null;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class j<K, V> extends d0<K, V> implements NavigableMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public transient Comparator<? super K> f56915e;

        /* renamed from: f  reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f56916f;

        /* renamed from: g  reason: collision with root package name */
        public transient NavigableSet<K> f56917g;

        /* loaded from: classes3.dex */
        public class a extends k<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f56918e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56918e = jVar;
            }

            @Override // com.google.common.collect.Maps.k
            public Map<K, V> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56918e : (Map) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56918e.e() : (Iterator) invokeV.objValue;
            }
        }

        public j() {
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

        public static <T> Ordering<T> g(Comparator<T> comparator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, comparator)) == null) ? Ordering.from(comparator).reverse() : (Ordering) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) ? f().floorEntry(k2) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2)) == null) ? f().floorKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Comparator<? super K> comparator = this.f56915e;
                if (comparator == null) {
                    Comparator<? super K> comparator2 = f().comparator();
                    if (comparator2 == null) {
                        comparator2 = Ordering.natural();
                    }
                    Ordering g2 = g(comparator2);
                    this.f56915e = g2;
                    return g2;
                }
                return comparator;
            }
            return (Comparator) invokeV.objValue;
        }

        public Set<Map.Entry<K, V>> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f().navigableKeySet() : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f() : (NavigableMap) invokeV.objValue;
        }

        public abstract Iterator<Map.Entry<K, V>> e();

        @Override // c.i.d.c.d0, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Set<Map.Entry<K, V>> set = this.f56916f;
                if (set == null) {
                    Set<Map.Entry<K, V>> d2 = d();
                    this.f56916f = d2;
                    return d2;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        public abstract NavigableMap<K, V> f();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? f().lastEntry() : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f().lastKey() : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k2)) == null) ? f().ceilingEntry(k2) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, k2)) == null) ? f().ceilingKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, k2, z)) == null) ? f().tailMap(k2, z).descendingMap() : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k2)) == null) ? f().lowerEntry(k2) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, k2)) == null) ? f().lowerKey(k2) : (K) invokeL.objValue;
        }

        @Override // c.i.d.c.d0, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? navigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? f().firstEntry() : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? f().firstKey() : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, k2)) == null) ? f().higherEntry(k2) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, k2)) == null) ? f().higherKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                NavigableSet<K> navigableSet = this.f56917g;
                if (navigableSet == null) {
                    r rVar = new r(this);
                    this.f56917g = rVar;
                    return rVar;
                }
                return navigableSet;
            }
            return (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? f().pollLastEntry() : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? f().pollFirstEntry() : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k2, boolean z, K k3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{k2, Boolean.valueOf(z), k3, Boolean.valueOf(z2)})) == null) ? f().subMap(k3, z2, k2, z).descendingMap() : (NavigableMap) invokeCommon.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, k2, z)) == null) ? f().headMap(k2, z).descendingMap() : (NavigableMap) invokeLZ.objValue;
        }

        @Override // c.i.d.c.h0, java.lang.Object
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? standardToString() : (String) invokeV.objValue;
        }

        @Override // c.i.d.c.d0, java.util.Map
        public Collection<V> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? new x(this) : (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.d0, c.i.d.c.h0
        public final Map<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f() : (Map) invokeV.objValue;
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, k2)) == null) ? headMap(k2, false) : (SortedMap) invokeL.objValue;
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k2, K k3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, k2, k3)) == null) ? subMap(k2, true, k3, false) : (SortedMap) invokeLL.objValue;
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, k2)) == null) ? tailMap(k2, true) : (SortedMap) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class k<K, V> extends Sets.c<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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

        public abstract Map<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object A = Maps.A(b(), key);
                    if (c.i.d.a.k.a(A, entry.getValue())) {
                        return A != null || b().containsKey(key);
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (contains(obj)) {
                    return b().keySet().remove(((Map.Entry) obj).getKey());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
                try {
                    c.i.d.a.n.p(collection);
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    return Sets.l(this, collection.iterator());
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
                try {
                    c.i.d.a.n.p(collection);
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet g2 = Sets.g(collection.size());
                    for (Object obj : collection) {
                        if (contains(obj)) {
                            g2.add(((Map.Entry) obj).getKey());
                        }
                    }
                    return b().keySet().retainAll(g2);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface l<K, V1, V2> {
        V2 a(K k2, V1 v1);
    }

    /* loaded from: classes3.dex */
    public static class m<K, V> extends i<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f56919j;

        /* loaded from: classes3.dex */
        public class a extends j0<Map.Entry<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f56920e;

            /* renamed from: com.google.common.collect.Maps$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C2050a extends m1<Map.Entry<K, V>, Map.Entry<K, V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f56921f;

                /* renamed from: com.google.common.collect.Maps$m$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public class C2051a extends e0<K, V> {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Map.Entry f56922e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C2050a f56923f;

                    public C2051a(C2050a c2050a, Map.Entry entry) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c2050a, entry};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f56923f = c2050a;
                        this.f56922e = entry;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // c.i.d.c.h0
                    /* renamed from: d */
                    public Map.Entry<K, V> delegate() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56922e : (Map.Entry) invokeV.objValue;
                    }

                    @Override // c.i.d.c.e0, java.util.Map.Entry
                    public V setValue(V v) {
                        InterceptResult invokeL;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
                            c.i.d.a.n.d(this.f56923f.f56921f.f56920e.d(getKey(), v));
                            return (V) super.setValue(v);
                        }
                        return (V) invokeL.objValue;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C2050a(a aVar, Iterator it) {
                    super(it);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, it};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Iterator) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f56921f = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.i.d.c.m1
                /* renamed from: b */
                public Map.Entry<K, V> a(Map.Entry<K, V> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? new C2051a(this, entry) : (Map.Entry) invokeL.objValue;
                }
            }

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56920e = mVar;
            }

            @Override // c.i.d.c.y, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
            public Iterator<Map.Entry<K, V>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C2050a(this, this.f56920e.f56919j.iterator()) : (Iterator) invokeV.objValue;
            }

            public /* synthetic */ a(m mVar, c cVar) {
                this(mVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.j0, c.i.d.c.y, c.i.d.c.h0
            public Set<Map.Entry<K, V>> delegate() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56920e.f56919j : (Set) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends q<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f56924f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(m mVar) {
                super(mVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56924f = mVar;
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (this.f56924f.containsKey(obj)) {
                        this.f56924f.f56913h.remove(obj);
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                    m mVar = this.f56924f;
                    return m.e(mVar.f56913h, mVar.f56914i, collection);
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                    m mVar = this.f56924f;
                    return m.f(mVar.f56913h, mVar.f56914i, collection);
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Lists.k(iterator()).toArray() : (Object[]) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) ? (T[]) Lists.k(iterator()).toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Map<K, V> map, c.i.d.a.o<? super Map.Entry<K, V>> oVar) {
            super(map, oVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (c.i.d.a.o) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56919j = Sets.b(map.entrySet(), this.f56914i);
        }

        public static <K, V> boolean e(Map<K, V> map, c.i.d.a.o<? super Map.Entry<K, V>> oVar, Collection<?> collection) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, map, oVar, collection)) == null) {
                Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (oVar.apply(next) && collection.contains(next.getKey())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeLLL.booleanValue;
        }

        public static <K, V> boolean f(Map<K, V> map, c.i.d.a.o<? super Map.Entry<K, V>> oVar, Collection<?> collection) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, map, oVar, collection)) == null) {
                Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (oVar.apply(next) && !collection.contains(next.getKey())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<K, V>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class n<K, V> extends i<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final c.i.d.a.o<? super K> f56925j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Map<K, V> map, c.i.d.a.o<? super K> oVar, c.i.d.a.o<? super Map.Entry<K, V>> oVar2) {
            super(map, oVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, oVar, oVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (c.i.d.a.o) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56925j = oVar;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<K, V>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Sets.b(this.f56913h.entrySet(), this.f56914i) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Sets.b(this.f56913h.keySet(), this.f56925j) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.i, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f56913h.containsKey(obj) && this.f56925j.apply(obj) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o<K, V> extends x<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final Map<K, V> f56926f;

        /* renamed from: g  reason: collision with root package name */
        public final c.i.d.a.o<? super Map.Entry<K, V>> f56927g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Map<K, V> map, Map<K, V> map2, c.i.d.a.o<? super Map.Entry<K, V>> oVar) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, map2, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56926f = map2;
            this.f56927g = oVar;
        }

        @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                Iterator<Map.Entry<K, V>> it = this.f56926f.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (this.f56927g.apply(next) && c.i.d.a.k.a(next.getValue(), obj)) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                Iterator<Map.Entry<K, V>> it = this.f56926f.entrySet().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (this.f56927g.apply(next) && collection.contains(next.getValue())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                Iterator<Map.Entry<K, V>> it = this.f56926f.entrySet().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (this.f56927g.apply(next) && !collection.contains(next.getValue())) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Lists.k(iterator()).toArray() : (Object[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) ? (T[]) Lists.k(iterator()).toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class p<K, V> extends AbstractMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public class a extends k<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f56928e;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56928e = pVar;
            }

            @Override // com.google.common.collect.Maps.k
            public Map<K, V> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56928e : (Map) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56928e.a() : (Iterator) invokeV.objValue;
            }
        }

        public p() {
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

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Iterators.e(a());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class q<K, V> extends Sets.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V> f56929e;

        public q(Map<K, V> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.d.a.n.p(map);
            this.f56929e = map;
        }

        public Map<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56929e : (Map) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? b().containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Maps.o(b().entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (contains(obj)) {
                    b().remove(obj);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class r<K, V> extends s<K, V> implements NavigableSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((SortedMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k2)) == null) ? c().ceilingKey(k2) : (K) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.s
        /* renamed from: d */
        public NavigableMap<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (NavigableMap) this.f56929e : (NavigableMap) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? descendingSet().iterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c().descendingKeySet() : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public K floor(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k2)) == null) ? c().floorKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, k2, z)) == null) ? c().headMap(k2, z).navigableKeySet() : (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public K higher(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k2)) == null) ? c().higherKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public K lower(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k2)) == null) ? c().lowerKey(k2) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (K) Maps.p(c().pollFirstEntry()) : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (K) Maps.p(c().pollLastEntry()) : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k2, boolean z, K k3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{k2, Boolean.valueOf(z), k3, Boolean.valueOf(z2)})) == null) ? c().subMap(k2, z, k3, z2).navigableKeySet() : (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, k2, z)) == null) ? c().tailMap(k2, z).navigableKeySet() : (NavigableSet) invokeLZ.objValue;
        }

        @Override // com.google.common.collect.Maps.s, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k2)) == null) ? headSet(k2, false) : (SortedSet) invokeL.objValue;
        }

        @Override // com.google.common.collect.Maps.s, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k2, K k3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k2, k3)) == null) ? subSet(k2, true, k3, false) : (SortedSet) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Maps.s, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, k2)) == null) ? tailSet(k2, true) : (SortedSet) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class s<K, V> extends q<K, V> implements SortedSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(SortedMap<K, V> sortedMap) {
            super(sortedMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.q
        /* renamed from: c */
        public SortedMap<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (SortedMap) super.b() : (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public K first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().firstKey() : (K) invokeV.objValue;
        }

        public SortedSet<K> headSet(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k2)) == null) ? new s(b().headMap(k2)) : (SortedSet) invokeL.objValue;
        }

        @Override // java.util.SortedSet
        public K last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b().lastKey() : (K) invokeV.objValue;
        }

        public SortedSet<K> subSet(K k2, K k3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, k2, k3)) == null) ? new s(b().subMap(k2, k3)) : (SortedSet) invokeLL.objValue;
        }

        public SortedSet<K> tailSet(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k2)) == null) ? new s(b().tailMap(k2)) : (SortedSet) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class t<K, V1, V2> extends p<K, V2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V1> f56930e;

        /* renamed from: f  reason: collision with root package name */
        public final l<? super K, ? super V1, V2> f56931f;

        public t(Map<K, V1> map, l<? super K, ? super V1, V2> lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.d.a.n.p(map);
            this.f56930e = map;
            c.i.d.a.n.p(lVar);
            this.f56931f = lVar;
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V2>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Iterators.A(this.f56930e.entrySet().iterator(), Maps.b(this.f56931f)) : (Iterator) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f56930e.clear();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f56930e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                V1 v1 = this.f56930e.get(obj);
                if (v1 != null || this.f56930e.containsKey(obj)) {
                    return this.f56931f.a(obj, v1);
                }
                return null;
            }
            return (V2) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56930e.keySet() : (Set) invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: V1, ? super V1 */
        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this.f56930e.containsKey(obj)) {
                    return this.f56931f.a(obj, (V1) this.f56930e.remove(obj));
                }
                return null;
            }
            return (V2) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56930e.size() : invokeV.intValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new x(this) : (Collection) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class u<K, V1, V2> extends t<K, V1, V2> implements SortedMap<K, V2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(SortedMap<K, V1> sortedMap, l<? super K, ? super V1, V2> lVar) {
            super(sortedMap, lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedMap, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (l) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public SortedMap<K, V1> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (SortedMap) this.f56930e : (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b().firstKey() : (K) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k2)) == null) ? Maps.E(b().headMap(k2), this.f56931f) : (SortedMap) invokeL.objValue;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b().lastKey() : (K) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K k2, K k3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k2, k3)) == null) ? Maps.E(b().subMap(k2, k3), this.f56931f) : (SortedMap) invokeLL.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K k2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k2)) == null) ? Maps.E(b().tailMap(k2), this.f56931f) : (SortedMap) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class v<K, V> extends c.i.d.c.y<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f56932e;

        public v(Collection<Map.Entry<K, V>> collection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56932e = collection;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Maps.J(this.f56932e.iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? standardToArray() : (Object[]) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.y, c.i.d.c.h0
        public Collection<Map.Entry<K, V>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56932e : (Collection) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) ? (T[]) standardToArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes3.dex */
    public static class w<K, V> extends v<K, V> implements Set<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Set<Map.Entry<K, V>> set) {
            super(set);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Collection) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Sets.a(this, obj) : invokeL.booleanValue;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Sets.d(this) : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class x<K, V> extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Map<K, V> f56933e;

        public x(Map<K, V> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.d.a.n.p(map);
            this.f56933e = map;
        }

        public final Map<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56933e : (Map) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? b().containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Maps.O(b().entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry<K, V> entry : b().entrySet()) {
                        if (c.i.d.a.k.a(obj, entry.getValue())) {
                            b().remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
                try {
                    c.i.d.a.n.p(collection);
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet f2 = Sets.f();
                    for (Map.Entry<K, V> entry : b().entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            f2.add(entry.getKey());
                        }
                    }
                    return b().keySet().removeAll(f2);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, collection)) == null) {
                try {
                    c.i.d.a.n.p(collection);
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet f2 = Sets.f();
                    for (Map.Entry<K, V> entry : b().entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            f2.add(entry.getKey());
                        }
                    }
                    return b().keySet().retainAll(f2);
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? b().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class y<K, V> extends AbstractMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f56934e;

        /* renamed from: f  reason: collision with root package name */
        public transient Set<K> f56935f;

        /* renamed from: g  reason: collision with root package name */
        public transient Collection<V> f56936g;

        public y() {
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

        public abstract Set<Map.Entry<K, V>> a();

        public Set<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new q(this) : (Set) invokeV.objValue;
        }

        public Collection<V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new x(this) : (Collection) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Set<Map.Entry<K, V>> set = this.f56934e;
                if (set == null) {
                    Set<Map.Entry<K, V>> a = a();
                    this.f56934e = a;
                    return a;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Set<K> set = this.f56935f;
                if (set == null) {
                    Set<K> b2 = b();
                    this.f56935f = b2;
                    return b2;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Collection<V> collection = this.f56936g;
                if (collection == null) {
                    Collection<V> c2 = c();
                    this.f56936g = c2;
                    return c2;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }
    }

    public static <V> V A(Map<?, V> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, map, obj)) == null) {
            c.i.d.a.n.p(map);
            try {
                return map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }
        return (V) invokeLL.objValue;
    }

    public static <V> V B(Map<?, V> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, obj)) == null) {
            c.i.d.a.n.p(map);
            try {
                return map.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        }
        return (V) invokeLL.objValue;
    }

    public static String C(Map<?, ?> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            StringBuilder d2 = c.i.d.c.n.d(map.size());
            d2.append(ExtendedMessageFormat.START_FE);
            boolean z = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!z) {
                    d2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                z = false;
                d2.append(entry.getKey());
                d2.append(com.alipay.sdk.encrypt.a.f31864h);
                d2.append(entry.getValue());
            }
            d2.append(ExtendedMessageFormat.END_FE);
            return d2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static <K, V1, V2> Map<K, V2> D(Map<K, V1> map, l<? super K, ? super V1, V2> lVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, lVar)) == null) ? new t(map, lVar) : (Map) invokeLL.objValue;
    }

    public static <K, V1, V2> SortedMap<K, V2> E(SortedMap<K, V1> sortedMap, l<? super K, ? super V1, V2> lVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sortedMap, lVar)) == null) ? new u(sortedMap, lVar) : (SortedMap) invokeLL.objValue;
    }

    public static <V2, K, V1> Map.Entry<K, V2> F(l<? super K, ? super V1, V2> lVar, Map.Entry<K, V1> entry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lVar, entry)) == null) {
            c.i.d.a.n.p(lVar);
            c.i.d.a.n.p(entry);
            return new a(entry, lVar);
        }
        return (Map.Entry) invokeLL.objValue;
    }

    public static <K, V1, V2> Map<K, V2> G(Map<K, V1> map, c.i.d.a.g<? super V1, V2> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, map, gVar)) == null) ? D(map, c(gVar)) : (Map) invokeLL.objValue;
    }

    public static <K, V1, V2> SortedMap<K, V2> H(SortedMap<K, V1> sortedMap, c.i.d.a.g<? super V1, V2> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, sortedMap, gVar)) == null) ? E(sortedMap, c(gVar)) : (SortedMap) invokeLL.objValue;
    }

    public static <K, V> Map.Entry<K, V> I(Map.Entry<? extends K, ? extends V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, entry)) == null) {
            c.i.d.a.n.p(entry);
            return new f(entry);
        }
        return (Map.Entry) invokeL.objValue;
    }

    public static <K, V> o1<Map.Entry<K, V>> J(Iterator<Map.Entry<K, V>> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, it)) == null) ? new g(it) : (o1) invokeL.objValue;
    }

    public static <K, V> Set<Map.Entry<K, V>> K(Set<Map.Entry<K, V>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, set)) == null) ? new w(Collections.unmodifiableSet(set)) : (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.NavigableMap<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> NavigableMap<K, V> L(NavigableMap<K, ? extends V> navigableMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, navigableMap)) == null) {
            c.i.d.a.n.p(navigableMap);
            return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
        }
        return (NavigableMap) invokeL.objValue;
    }

    public static <K, V> Map.Entry<K, V> M(Map.Entry<K, ? extends V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, entry)) == null) {
            if (entry == null) {
                return null;
            }
            return I(entry);
        }
        return (Map.Entry) invokeL.objValue;
    }

    public static <V> c.i.d.a.g<Map.Entry<?, V>, V> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? EntryFunction.VALUE : (c.i.d.a.g) invokeV.objValue;
    }

    public static <K, V> Iterator<V> O(Iterator<Map.Entry<K, V>> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, it)) == null) ? new d(it) : (Iterator) invokeL.objValue;
    }

    public static <V> V P(Map.Entry<?, V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, entry)) == null) {
            if (entry == null) {
                return null;
            }
            return entry.getValue();
        }
        return (V) invokeL.objValue;
    }

    public static <V> c.i.d.a.o<Map.Entry<?, V>> Q(c.i.d.a.o<? super V> oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, oVar)) == null) ? Predicates.e(oVar, N()) : (c.i.d.a.o) invokeL.objValue;
    }

    public static <K, V1, V2> c.i.d.a.g<Map.Entry<K, V1>, Map.Entry<K, V2>> b(l<? super K, ? super V1, V2> lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, lVar)) == null) {
            c.i.d.a.n.p(lVar);
            return new b(lVar);
        }
        return (c.i.d.a.g) invokeL.objValue;
    }

    public static <K, V1, V2> l<K, V1, V2> c(c.i.d.a.g<? super V1, V2> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, gVar)) == null) {
            c.i.d.a.n.p(gVar);
            return new h(gVar);
        }
        return (l) invokeL.objValue;
    }

    public static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, c.i.d.a.g<? super K, V> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, set, gVar)) == null) ? new e(set.iterator(), gVar) : (Iterator) invokeLL.objValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            if (i2 < 3) {
                c.i.d.c.m.b(i2, "expectedSize");
                return i2 + 1;
            } else if (i2 < 1073741824) {
                return (int) ((i2 / 0.75f) + 1.0f);
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return invokeI.intValue;
    }

    public static <K, V> boolean f(Collection<Map.Entry<K, V>> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, collection, obj)) == null) {
            if (obj instanceof Map.Entry) {
                return collection.contains(I((Map.Entry) obj));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, map, obj)) == null) ? Iterators.g(o(map.entrySet().iterator()), obj) : invokeLL.booleanValue;
    }

    public static boolean h(Map<?, ?> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, map, obj)) == null) ? Iterators.g(O(map.entrySet().iterator()), obj) : invokeLL.booleanValue;
    }

    public static boolean i(Map<?, ?> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, map, obj)) == null) {
            if (map == obj) {
                return true;
            }
            if (obj instanceof Map) {
                return map.entrySet().equals(((Map) obj).entrySet());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> Map<K, V> j(i<K, V> iVar, c.i.d.a.o<? super Map.Entry<K, V>> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, iVar, oVar)) == null) ? new m(iVar.f56913h, Predicates.c(iVar.f56914i, oVar)) : (Map) invokeLL.objValue;
    }

    public static <K, V> Map<K, V> k(Map<K, V> map, c.i.d.a.o<? super K> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, map, oVar)) == null) {
            c.i.d.a.n.p(oVar);
            c.i.d.a.o q2 = q(oVar);
            if (map instanceof i) {
                return j((i) map, q2);
            }
            c.i.d.a.n.p(map);
            return new n(map, oVar, q2);
        }
        return (Map) invokeLL.objValue;
    }

    public static <K, V> Map.Entry<K, V> l(K k2, V v2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, k2, v2)) == null) ? new ImmutableEntry(k2, v2) : (Map.Entry) invokeLL.objValue;
    }

    public static <E> ImmutableMap<E, Integer> m(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, collection)) == null) {
            ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
            int i2 = 0;
            for (E e2 : collection) {
                bVar.c(e2, Integer.valueOf(i2));
                i2++;
            }
            return bVar.a();
        }
        return (ImmutableMap) invokeL.objValue;
    }

    public static <K> c.i.d.a.g<Map.Entry<K, ?>, K> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? EntryFunction.KEY : (c.i.d.a.g) invokeV.objValue;
    }

    public static <K, V> Iterator<K> o(Iterator<Map.Entry<K, V>> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, it)) == null) ? new c(it) : (Iterator) invokeL.objValue;
    }

    public static <K> K p(Map.Entry<K, ?> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, entry)) == null) {
            if (entry == null) {
                return null;
            }
            return entry.getKey();
        }
        return (K) invokeL.objValue;
    }

    public static <K> c.i.d.a.o<Map.Entry<K, ?>> q(c.i.d.a.o<? super K> oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, oVar)) == null) ? Predicates.e(oVar, n()) : (c.i.d.a.o) invokeL.objValue;
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> r(Class<K> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, cls)) == null) {
            c.i.d.a.n.p(cls);
            return new EnumMap<>(cls);
        }
        return (EnumMap) invokeL.objValue;
    }

    public static <K, V> HashMap<K, V> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? new HashMap<>() : (HashMap) invokeV.objValue;
    }

    public static <K, V> HashMap<K, V> t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65572, null, i2)) == null) ? new HashMap<>(e(i2)) : (HashMap) invokeI.objValue;
    }

    public static <K, V> IdentityHashMap<K, V> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? new IdentityHashMap<>() : (IdentityHashMap) invokeV.objValue;
    }

    public static <K, V> LinkedHashMap<K, V> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? new LinkedHashMap<>() : (LinkedHashMap) invokeV.objValue;
    }

    public static <K, V> LinkedHashMap<K, V> w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65575, null, i2)) == null) ? new LinkedHashMap<>(e(i2)) : (LinkedHashMap) invokeI.objValue;
    }

    public static <K, V> void x(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, map, map2) == null) {
            for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static <K, V> boolean y(Collection<Map.Entry<K, V>> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, collection, obj)) == null) {
            if (obj instanceof Map.Entry) {
                return collection.remove(I((Map.Entry) obj));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean z(Map<?, ?> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, map, obj)) == null) {
            c.i.d.a.n.p(map);
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
