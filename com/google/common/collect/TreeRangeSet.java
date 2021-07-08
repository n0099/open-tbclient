package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.j;
import d.f.d.a.n;
import d.f.d.c.b1;
import d.f.d.c.f;
import d.f.d.c.x0;
import d.f.d.c.y;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient b1<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes6.dex */
    public final class Complement extends TreeRangeSet<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TreeRangeSet this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complement(TreeRangeSet treeRangeSet) {
            super(new c(treeRangeSet.rangesByLowerBound), null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeRangeSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((NavigableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = treeRangeSet;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                this.this$0.remove(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.b1
        public b1<C> complement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0 : (b1) invokeV.objValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? !this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public void remove(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, range) == null) {
                this.this$0.add(range);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class SubRangeSet extends TreeRangeSet<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Range<C> restriction;
        public final /* synthetic */ TreeRangeSet this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubRangeSet(TreeRangeSet treeRangeSet, Range<C> range) {
            super(new e(Range.all(), range, treeRangeSet.rangesByLowerBound, null), null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeRangeSet, range};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((NavigableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = treeRangeSet;
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                n.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
                super.add(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.remove(this.restriction);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? this.restriction.contains(c2) && this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f, d.f.d.c.b1
        public boolean encloses(Range<C> range) {
            InterceptResult invokeL;
            Range rangeEnclosing;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, range)) == null) ? (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = this.this$0.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public Range<C> rangeContaining(C c2) {
            InterceptResult invokeL;
            Range<C> rangeContaining;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2)) == null) {
                if (this.restriction.contains(c2) && (rangeContaining = this.this$0.rangeContaining(c2)) != null) {
                    return rangeContaining.intersection(this.restriction);
                }
                return null;
            }
            return (Range) invokeL.objValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, d.f.d.c.f
        public void remove(Range<C> range) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, range) == null) && range.isConnected(this.restriction)) {
                this.this$0.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public b1<C> subRangeSet(Range<C> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, range)) == null) {
                if (range.encloses(this.restriction)) {
                    return this;
                }
                if (range.isConnected(this.restriction)) {
                    return new SubRangeSet(this, this.restriction.intersection(range));
                }
                return ImmutableRangeSet.of();
            }
            return (b1) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class b extends y<Range<C>> implements Set<Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Range<C>> f33475e;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeRangeSet, collection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33475e = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? Sets.a(this, obj) : invokeL.booleanValue;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Sets.d(this) : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.c.y, d.f.d.c.h0
        public Collection<Range<C>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33475e : (Collection) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<C extends Comparable<?>> extends d.f.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f33476e;

        /* renamed from: f  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f33477f;

        /* renamed from: g  reason: collision with root package name */
        public final Range<Cut<C>> f33478g;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f33479g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f33480h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f33481i;
            public final /* synthetic */ c j;

            public a(c cVar, Cut cut, x0 x0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cut, x0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = cVar;
                this.f33480h = cut;
                this.f33481i = x0Var;
                this.f33479g = this.f33480h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Range create;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.j.f33478g.upperBound.isLessThan(this.f33479g) && this.f33479g != Cut.aboveAll()) {
                        if (this.f33481i.hasNext()) {
                            Range range = (Range) this.f33481i.next();
                            create = Range.create(this.f33479g, range.lowerBound);
                            this.f33479g = range.upperBound;
                        } else {
                            create = Range.create(this.f33479g, Cut.aboveAll());
                            this.f33479g = Cut.aboveAll();
                        }
                        return Maps.l(create.lowerBound, create);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f33482g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f33483h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f33484i;
            public final /* synthetic */ c j;

            public b(c cVar, Cut cut, x0 x0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cut, x0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.j = cVar;
                this.f33483h = cut;
                this.f33484i = x0Var;
                this.f33482g = this.f33483h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.f33482g == Cut.belowAll()) {
                        return (Map.Entry) b();
                    }
                    if (!this.f33484i.hasNext()) {
                        if (this.j.f33478g.lowerBound.isLessThan(Cut.belowAll())) {
                            Range create = Range.create(Cut.belowAll(), this.f33482g);
                            this.f33482g = Cut.belowAll();
                            return Maps.l(Cut.belowAll(), create);
                        }
                    } else {
                        Range range = (Range) this.f33484i.next();
                        Range create2 = Range.create(range.upperBound, this.f33482g);
                        this.f33482g = range.lowerBound;
                        if (this.j.f33478g.lowerBound.isLessThan(create2.lowerBound)) {
                            return Maps.l(create2.lowerBound, create2);
                        }
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((NavigableMap) objArr2[0], (Range) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Collection<Range<C>> values;
            Cut cut;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f33478g.hasLowerBound()) {
                    values = this.f33477f.tailMap(this.f33478g.lowerEndpoint(), this.f33478g.lowerBoundType() == BoundType.CLOSED).values();
                } else {
                    values = this.f33477f.values();
                }
                x0 s = Iterators.s(values.iterator());
                if (this.f33478g.contains(Cut.belowAll()) && (!s.hasNext() || ((Range) s.peek()).lowerBound != Cut.belowAll())) {
                    cut = Cut.belowAll();
                } else if (s.hasNext()) {
                    cut = ((Range) s.next()).upperBound;
                } else {
                    return Iterators.i();
                }
                return new a(this, cut, s);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // d.f.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Cut<C> aboveAll;
            Cut<C> higherKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f33478g.hasUpperBound()) {
                    aboveAll = this.f33478g.upperEndpoint();
                } else {
                    aboveAll = Cut.aboveAll();
                }
                x0 s = Iterators.s(this.f33477f.headMap(aboveAll, this.f33478g.hasUpperBound() && this.f33478g.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
                if (s.hasNext()) {
                    if (((Range) s.peek()).upperBound == Cut.aboveAll()) {
                        higherKey = ((Range) s.next()).lowerBound;
                    } else {
                        higherKey = this.f33476e.higherKey(((Range) s.peek()).upperBound);
                    }
                } else if (this.f33478g.contains(Cut.belowAll()) && !this.f33476e.containsKey(Cut.belowAll())) {
                    higherKey = this.f33476e.higherKey(Cut.belowAll());
                } else {
                    return Iterators.i();
                }
                return new b(this, (Cut) j.a(higherKey, Cut.aboveAll()), s);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Ordering.natural() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? get(obj) != null : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Range<C> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof Cut) {
                    try {
                        Cut<C> cut = (Cut) obj;
                        Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                        if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                            return firstEntry.getValue();
                        }
                    } catch (ClassCastException unused) {
                    }
                }
                return null;
            }
            return (Range) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, cut, z)) == null) ? g(Range.upTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{cut, Boolean.valueOf(z), cut2, Boolean.valueOf(z2)})) == null) ? g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2))) : (NavigableMap) invokeCommon.objValue;
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, range)) == null) {
                if (!this.f33478g.isConnected(range)) {
                    return ImmutableSortedMap.of();
                }
                return new c(this.f33476e, range.intersection(this.f33478g));
            }
            return (NavigableMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, cut, z)) == null) ? g(Range.downTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Iterators.y(a()) : invokeV.intValue;
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap, range};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33476e = navigableMap;
            this.f33477f = new d(navigableMap);
            this.f33478g = range;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<C extends Comparable<?>> extends d.f.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Range<Cut<C>> f33491e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<C> f33492f;

        /* renamed from: g  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f33493g;

        /* renamed from: h  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f33494h;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f33495g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f33496h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ e f33497i;

            public a(e eVar, Iterator it, Cut cut) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, it, cut};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33497i = eVar;
                this.f33495g = it;
                this.f33496h = cut;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f33495g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f33495g.next();
                    if (!this.f33496h.isLessThan(range.lowerBound)) {
                        Range intersection = range.intersection(this.f33497i.f33492f);
                        return Maps.l(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f33498g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ e f33499h;

            public b(e eVar, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33499h = eVar;
                this.f33498g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f33498g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f33498g.next();
                    if (this.f33499h.f33492f.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                        Range intersection = range.intersection(this.f33499h.f33492f);
                        if (this.f33499h.f33491e.contains(intersection.lowerBound)) {
                            return Maps.l(intersection.lowerBound, intersection);
                        }
                        return (Map.Entry) b();
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        public /* synthetic */ e(Range range, Range range2, NavigableMap navigableMap, a aVar) {
            this(range, range2, navigableMap);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Iterator<Range<C>> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f33492f.isEmpty()) {
                    return Iterators.i();
                }
                if (this.f33491e.upperBound.isLessThan(this.f33492f.lowerBound)) {
                    return Iterators.i();
                }
                if (this.f33491e.lowerBound.isLessThan(this.f33492f.lowerBound)) {
                    it = this.f33494h.tailMap(this.f33492f.lowerBound, false).values().iterator();
                } else {
                    it = this.f33493g.tailMap(this.f33491e.lowerBound.endpoint(), this.f33491e.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(this, it, (Cut) Ordering.natural().min(this.f33491e.upperBound, Cut.belowValue(this.f33492f.upperBound)));
            }
            return (Iterator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.f.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f33492f.isEmpty()) {
                    return Iterators.i();
                }
                Cut cut = (Cut) Ordering.natural().min(this.f33491e.upperBound, Cut.belowValue(this.f33492f.upperBound));
                return new b(this, this.f33493g.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Ordering.natural() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? get(obj) != null : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Range<C> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof Cut) {
                    try {
                        Cut<C> cut = (Cut) obj;
                        if (this.f33491e.contains(cut) && cut.compareTo(this.f33492f.lowerBound) >= 0 && cut.compareTo(this.f33492f.upperBound) < 0) {
                            if (cut.equals(this.f33492f.lowerBound)) {
                                Range range = (Range) Maps.P(this.f33493g.floorEntry(cut));
                                if (range != null && range.upperBound.compareTo((Cut) this.f33492f.lowerBound) > 0) {
                                    return range.intersection(this.f33492f);
                                }
                            } else {
                                Range range2 = (Range) this.f33493g.get(cut);
                                if (range2 != null) {
                                    return range2.intersection(this.f33492f);
                                }
                            }
                        }
                    } catch (ClassCastException unused) {
                    }
                }
                return null;
            }
            return (Range) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, cut, z)) == null) ? h(Range.upTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{cut, Boolean.valueOf(z), cut2, Boolean.valueOf(z2)})) == null) ? h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2))) : (NavigableMap) invokeCommon.objValue;
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, range)) == null) {
                if (!range.isConnected(this.f33491e)) {
                    return ImmutableSortedMap.of();
                }
                return new e(this.f33491e.intersection(range), this.f33492f, this.f33493g);
            }
            return (NavigableMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, cut, z)) == null) ? h(Range.downTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Iterators.y(a()) : invokeV.intValue;
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {range, range2, navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(range);
            this.f33491e = range;
            n.p(range2);
            this.f33492f = range2;
            n.p(navigableMap);
            this.f33493g = navigableMap;
            this.f33494h = new d(navigableMap);
        }
    }

    public /* synthetic */ TreeRangeSet(NavigableMap navigableMap, a aVar) {
        this(navigableMap);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new TreeRangeSet<>(new TreeMap()) : (TreeRangeSet) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, range)) == null) {
            n.p(range);
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
            if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
                return null;
            }
            return floorEntry.getValue();
        }
        return (Range) invokeL.objValue;
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, range) == null) {
            if (range.isEmpty()) {
                this.rangesByLowerBound.remove(range.lowerBound);
            } else {
                this.rangesByLowerBound.put(range.lowerBound, range);
            }
        }
    }

    @Override // d.f.d.c.f
    public void add(Range<C> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
            n.p(range);
            if (range.isEmpty()) {
                return;
            }
            Cut<C> cut = range.lowerBound;
            Cut<C> cut2 = range.upperBound;
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(cut) >= 0) {
                    if (value.upperBound.compareTo(cut2) >= 0) {
                        cut2 = value.upperBound;
                    }
                    cut = value.lowerBound;
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value2.upperBound;
                }
            }
            this.rangesByLowerBound.subMap(cut, cut2).clear();
            replaceRangeWithSameLowerBound(Range.create(cut, cut2));
        }
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ void addAll(b1 b1Var) {
        super.addAll(b1Var);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Set<Range<C>> set = this.asDescendingSetOfRanges;
            if (set == null) {
                b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
                this.asDescendingSetOfRanges = bVar;
                return bVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.b1
    public Set<Range<C>> asRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Set<Range<C>> set = this.asRanges;
            if (set == null) {
                b bVar = new b(this, this.rangesByLowerBound.values());
                this.asRanges = bVar;
                return bVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // d.f.d.c.b1
    public b1<C> complement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b1<C> b1Var = this.complement;
            if (b1Var == null) {
                Complement complement = new Complement(this);
                this.complement = complement;
                return complement;
            }
            return b1Var;
        }
        return (b1) invokeV.objValue;
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // d.f.d.c.f, d.f.d.c.b1
    public boolean encloses(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, range)) == null) {
            n.p(range);
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
            return floorEntry != null && floorEntry.getValue().encloses(range);
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(b1 b1Var) {
        return super.enclosesAll(b1Var);
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // d.f.d.c.f
    public boolean intersects(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, range)) == null) {
            n.p(range);
            Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
            if (ceilingEntry == null || !ceilingEntry.getValue().isConnected(range) || ceilingEntry.getValue().intersection(range).isEmpty()) {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
                return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.f, d.f.d.c.b1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // d.f.d.c.f
    public Range<C> rangeContaining(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, c2)) == null) {
            n.p(c2);
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c2));
            if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
                return null;
            }
            return floorEntry.getValue();
        }
        return (Range) invokeL.objValue;
    }

    @Override // d.f.d.c.f
    public void remove(Range<C> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, range) == null) {
            n.p(range);
            if (range.isEmpty()) {
                return;
            }
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                    if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                        replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                    }
                    replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
                }
            }
            this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    @Override // d.f.d.c.f, d.f.d.c.b1
    public /* bridge */ /* synthetic */ void removeAll(b1 b1Var) {
        super.removeAll(b1Var);
    }

    public Range<C> span() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
            Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
            if (firstEntry != null) {
                return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
            }
            throw new NoSuchElementException();
        }
        return (Range) invokeV.objValue;
    }

    public b1<C> subRangeSet(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, range)) == null) ? range.equals(Range.all()) ? this : new SubRangeSet(this, range) : (b1) invokeL.objValue;
    }

    public TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
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
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b1Var)) == null) {
            TreeRangeSet<C> create = create();
            create.addAll(b1Var);
            return create;
        }
        return (TreeRangeSet) invokeL.objValue;
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // d.f.d.c.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* loaded from: classes6.dex */
    public static final class d<C extends Comparable<?>> extends d.f.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f33485e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<Cut<C>> f33486f;

        /* loaded from: classes6.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f33487g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f33488h;

            public a(d dVar, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33488h = dVar;
                this.f33487g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f33487g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f33487g.next();
                    if (this.f33488h.f33486f.upperBound.isLessThan(range.upperBound)) {
                        return (Map.Entry) b();
                    }
                    return Maps.l(range.upperBound, range);
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ x0 f33489g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f33490h;

            public b(d dVar, x0 x0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, x0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33490h = dVar;
                this.f33489g = x0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f33489g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f33489g.next();
                    if (this.f33490h.f33486f.lowerBound.isLessThan(range.upperBound)) {
                        return Maps.l(range.upperBound, range);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
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
            this.f33485e = navigableMap;
            this.f33486f = Range.all();
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Iterator<Range<C>> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.f33486f.hasLowerBound()) {
                    it = this.f33485e.values().iterator();
                } else {
                    Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f33485e.lowerEntry(this.f33486f.lowerEndpoint());
                    if (lowerEntry == null) {
                        it = this.f33485e.values().iterator();
                    } else if (this.f33486f.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                        it = this.f33485e.tailMap(lowerEntry.getKey(), true).values().iterator();
                    } else {
                        it = this.f33485e.tailMap(this.f33486f.lowerEndpoint(), true).values().iterator();
                    }
                }
                return new a(this, it);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // d.f.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Collection<Range<C>> values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f33486f.hasUpperBound()) {
                    values = this.f33485e.headMap(this.f33486f.upperEndpoint(), false).descendingMap().values();
                } else {
                    values = this.f33485e.descendingMap().values();
                }
                x0 s = Iterators.s(values.iterator());
                if (s.hasNext() && this.f33486f.upperBound.isLessThan(((Range) s.peek()).upperBound)) {
                    s.next();
                }
                return new b(this, s);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Ordering.natural() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? get(obj) != null : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Range<C> get(Object obj) {
            InterceptResult invokeL;
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof Cut) {
                    try {
                        Cut<C> cut = (Cut) obj;
                        if (this.f33486f.contains(cut) && (lowerEntry = this.f33485e.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                            return lowerEntry.getValue();
                        }
                    } catch (ClassCastException unused) {
                    }
                }
                return null;
            }
            return (Range) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, cut, z)) == null) ? g(Range.upTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{cut, Boolean.valueOf(z), cut2, Boolean.valueOf(z2)})) == null) ? g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2))) : (NavigableMap) invokeCommon.objValue;
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, range)) == null) {
                if (range.isConnected(this.f33486f)) {
                    return new d(this.f33485e, range.intersection(this.f33486f));
                }
                return ImmutableSortedMap.of();
            }
            return (NavigableMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, cut, z)) == null) ? g(Range.downTo(cut, BoundType.forBoolean(z))) : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f33486f.equals(Range.all())) {
                    return this.f33485e.isEmpty();
                }
                return !a().hasNext();
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.f33486f.equals(Range.all())) {
                    return this.f33485e.size();
                }
                return Iterators.y(a());
            }
            return invokeV.intValue;
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap, range};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33485e = navigableMap;
            this.f33486f = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iterable)) == null) {
            TreeRangeSet<C> create = create();
            create.addAll(iterable);
            return create;
        }
        return (TreeRangeSet) invokeL.objValue;
    }
}
