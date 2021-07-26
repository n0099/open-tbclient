package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import d.f.d.a.n;
import d.f.d.c.a1;
import d.f.d.c.o1;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements a1<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableRangeMap<Comparable<?>, Object> EMPTY;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ImmutableList<Range<K>> ranges;
    public final transient ImmutableList<V> values;

    /* loaded from: classes6.dex */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a();
                o1<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Range<K>, V> next = it.next();
                    aVar.b(next.getKey(), next.getValue());
                }
                return aVar.a();
            }
            return invokeV.objValue;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mapOfRanges.isEmpty()) {
                    return ImmutableRangeMap.of();
                }
                return createRangeMap();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<K extends Comparable<?>, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<Range<K>, V>> f33420a;

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
            this.f33420a = Lists.i();
        }

        public ImmutableRangeMap<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Collections.sort(this.f33420a, Range.rangeLexOrdering().onKeys());
                ImmutableList.a aVar = new ImmutableList.a(this.f33420a.size());
                ImmutableList.a aVar2 = new ImmutableList.a(this.f33420a.size());
                for (int i2 = 0; i2 < this.f33420a.size(); i2++) {
                    Range<K> key = this.f33420a.get(i2).getKey();
                    if (i2 > 0) {
                        Range<K> key2 = this.f33420a.get(i2 - 1).getKey();
                        if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                            throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                        }
                    }
                    aVar.h(key);
                    aVar2.h(this.f33420a.get(i2).getValue());
                }
                return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
            }
            return (ImmutableRangeMap) invokeV.objValue;
        }

        public a<K, V> b(Range<K> range, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, range, v)) == null) {
                n.p(range);
                n.p(v);
                n.k(!range.isEmpty(), "Range must not be empty, but was %s", range);
                this.f33420a.add(Maps.l(range, v));
                return this;
            }
            return (a) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1747917209, "Lcom/google/common/collect/ImmutableRangeMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1747917209, "Lcom/google/common/collect/ImmutableRangeMap;");
                return;
            }
        }
        EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList, immutableList2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(a1<K, ? extends V> a1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, a1Var)) == null) {
            if (a1Var instanceof ImmutableRangeMap) {
                return (ImmutableRangeMap) a1Var;
            }
            Map<Range<K>, ? extends V> asMapOfRanges = a1Var.asMapOfRanges();
            ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
            ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
            for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
                aVar.h(entry.getKey());
                aVar2.h(entry.getValue());
            }
            return new ImmutableRangeMap<>(aVar.j(), aVar2.j());
        }
        return (ImmutableRangeMap) invokeL.objValue;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ImmutableRangeMap<K, V>) EMPTY : (ImmutableRangeMap) invokeV.objValue;
    }

    @Deprecated
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof a1) {
                return asMapOfRanges().equals(((a1) obj).asMapOfRanges());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public V get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
            int a2 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
            if (a2 != -1 && this.ranges.get(a2).contains(k)) {
                return this.values.get(a2);
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public Map.Entry<Range<K>, V> getEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) {
            int a2 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
            if (a2 == -1) {
                return null;
            }
            Range<K> range = this.ranges.get(a2);
            if (range.contains(k)) {
                return Maps.l(range, this.values.get(a2));
            }
            return null;
        }
        return (Map.Entry) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? asMapOfRanges().hashCode() : invokeV.intValue;
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, range, v) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public void putAll(a1<K, V> a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, a1Var) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, range, v) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public void remove(Range<K> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, range) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public Range<K> span() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.ranges.isEmpty()) {
                ImmutableList<Range<K>> immutableList = this.ranges;
                return Range.create(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
            }
            throw new NoSuchElementException();
        }
        return (Range) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? asMapOfRanges().toString() : (String) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new SerializedForm(asMapOfRanges()) : invokeV.objValue;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, range, v)) == null) ? new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v)) : (ImmutableRangeMap) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: asDescendingMapOfRanges */
    public ImmutableMap<Range<K>, V> m48asDescendingMapOfRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.ranges.isEmpty()) {
                return ImmutableMap.of();
            }
            return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
        }
        return (ImmutableMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.a1
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.ranges.isEmpty()) {
                return ImmutableMap.of();
            }
            return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
        }
        return (ImmutableMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> m49subRangeMap(Range<K> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, range)) == null) {
            n.p(range);
            if (range.isEmpty()) {
                return of();
            }
            if (this.ranges.isEmpty() || range.encloses(span())) {
                return this;
            }
            int a2 = SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            int a3 = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            if (a2 >= a3) {
                return of();
            }
            return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>(this, a3 - a2, a2, range) { // from class: com.google.common.collect.ImmutableRangeMap.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImmutableRangeMap this$0;
                public final /* synthetic */ int val$len;
                public final /* synthetic */ int val$off;
                public final /* synthetic */ Range val$range;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r7), Integer.valueOf(a2), range};
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
                    this.val$len = r7;
                    this.val$off = a2;
                    this.val$range = range;
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$len : invokeV.intValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.List
                public Range<K> get(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                        n.n(i2, this.val$len);
                        return (i2 == 0 || i2 == this.val$len + (-1)) ? ((Range) this.this$0.ranges.get(i2 + this.val$off)).intersection(this.val$range) : (Range) this.this$0.ranges.get(i2 + this.val$off);
                    }
                    return (Range) invokeI.objValue;
                }
            }, this.values.subList(a2, a3), range, this) { // from class: com.google.common.collect.ImmutableRangeMap.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImmutableRangeMap this$0;
                public final /* synthetic */ ImmutableRangeMap val$outer;
                public final /* synthetic */ Range val$range;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, range, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((ImmutableList) objArr2[0], (ImmutableList) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$range = range;
                    this.val$outer = this;
                }

                @Override // com.google.common.collect.ImmutableRangeMap
                public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                    return super.m48asDescendingMapOfRanges();
                }

                @Override // com.google.common.collect.ImmutableRangeMap, d.f.d.c.a1
                public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                    return super.asMapOfRanges();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.ImmutableRangeMap
                public ImmutableRangeMap<K, V> subRangeMap(Range<K> range2) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, range2)) == null) {
                        if (this.val$range.isConnected(range2)) {
                            return this.val$outer.m49subRangeMap((Range) range2.intersection(this.val$range));
                        }
                        return ImmutableRangeMap.of();
                    }
                    return (ImmutableRangeMap) invokeL2.objValue;
                }
            };
        }
        return (ImmutableRangeMap) invokeL.objValue;
    }
}
