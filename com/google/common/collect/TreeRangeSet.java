package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.j;
import b.i.d.a.n;
import b.i.d.c.b1;
import b.i.d.c.f;
import b.i.d.c.x0;
import b.i.d.c.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient b1<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes2.dex */
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

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                this.this$0.remove(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.b1
        public b1<C> complement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0 : (b1) invokeV.objValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? !this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public void remove(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, range) == null) {
                this.this$0.add(range);
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                n.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
                super.add(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.remove(this.restriction);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? this.restriction.contains(c2) && this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f, b.i.d.c.b1
        public boolean encloses(Range<C> range) {
            InterceptResult invokeL;
            Range rangeEnclosing;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, range)) == null) ? (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = this.this$0.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
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

        @Override // com.google.common.collect.TreeRangeSet, b.i.d.c.f
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

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public final class b extends y<Range<C>> implements Set<Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Range<C>> f63613e;

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
            this.f63613e = collection;
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
        @Override // b.i.d.c.y, b.i.d.c.h0
        public Collection<Range<C>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63613e : (Collection) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<C extends Comparable<?>> extends b.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f63614e;

        /* renamed from: f  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f63615f;

        /* renamed from: g  reason: collision with root package name */
        public final Range<Cut<C>> f63616g;

        /* loaded from: classes2.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f63617g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f63618h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f63619i;
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
                this.f63618h = cut;
                this.f63619i = x0Var;
                this.f63617g = this.f63618h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Range create;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.j.f63616g.upperBound.isLessThan(this.f63617g) && this.f63617g != Cut.aboveAll()) {
                        if (this.f63619i.hasNext()) {
                            Range range = (Range) this.f63619i.next();
                            create = Range.create(this.f63617g, range.lowerBound);
                            this.f63617g = range.upperBound;
                        } else {
                            create = Range.create(this.f63617g, Cut.aboveAll());
                            this.f63617g = Cut.aboveAll();
                        }
                        return Maps.l(create.lowerBound, create);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f63620g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f63621h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f63622i;
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
                this.f63621h = cut;
                this.f63622i = x0Var;
                this.f63620g = this.f63621h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.f63620g == Cut.belowAll()) {
                        return (Map.Entry) b();
                    }
                    if (!this.f63622i.hasNext()) {
                        if (this.j.f63616g.lowerBound.isLessThan(Cut.belowAll())) {
                            Range create = Range.create(Cut.belowAll(), this.f63620g);
                            this.f63620g = Cut.belowAll();
                            return Maps.l(Cut.belowAll(), create);
                        }
                    } else {
                        Range range = (Range) this.f63622i.next();
                        Range create2 = Range.create(range.upperBound, this.f63620g);
                        this.f63620g = range.lowerBound;
                        if (this.j.f63616g.lowerBound.isLessThan(create2.lowerBound)) {
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
                if (this.f63616g.hasLowerBound()) {
                    values = this.f63615f.tailMap(this.f63616g.lowerEndpoint(), this.f63616g.lowerBoundType() == BoundType.CLOSED).values();
                } else {
                    values = this.f63615f.values();
                }
                x0 s = Iterators.s(values.iterator());
                if (this.f63616g.contains(Cut.belowAll()) && (!s.hasNext() || ((Range) s.peek()).lowerBound != Cut.belowAll())) {
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

        @Override // b.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Cut<C> aboveAll;
            Cut<C> higherKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f63616g.hasUpperBound()) {
                    aboveAll = this.f63616g.upperEndpoint();
                } else {
                    aboveAll = Cut.aboveAll();
                }
                x0 s = Iterators.s(this.f63615f.headMap(aboveAll, this.f63616g.hasUpperBound() && this.f63616g.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
                if (s.hasNext()) {
                    if (((Range) s.peek()).upperBound == Cut.aboveAll()) {
                        higherKey = ((Range) s.next()).lowerBound;
                    } else {
                        higherKey = this.f63614e.higherKey(((Range) s.peek()).upperBound);
                    }
                } else if (this.f63616g.contains(Cut.belowAll()) && !this.f63614e.containsKey(Cut.belowAll())) {
                    higherKey = this.f63614e.higherKey(Cut.belowAll());
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
                if (!this.f63616g.isConnected(range)) {
                    return ImmutableSortedMap.of();
                }
                return new c(this.f63614e, range.intersection(this.f63616g));
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
            this.f63614e = navigableMap;
            this.f63615f = new d(navigableMap);
            this.f63616g = range;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<C extends Comparable<?>> extends b.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Range<Cut<C>> f63629e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<C> f63630f;

        /* renamed from: g  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f63631g;

        /* renamed from: h  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f63632h;

        /* loaded from: classes2.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f63633g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f63634h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ e f63635i;

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
                this.f63635i = eVar;
                this.f63633g = it;
                this.f63634h = cut;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f63633g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f63633g.next();
                    if (!this.f63634h.isLessThan(range.lowerBound)) {
                        Range intersection = range.intersection(this.f63635i.f63630f);
                        return Maps.l(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f63636g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ e f63637h;

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
                this.f63637h = eVar;
                this.f63636g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f63636g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f63636g.next();
                    if (this.f63637h.f63630f.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                        Range intersection = range.intersection(this.f63637h.f63630f);
                        if (this.f63637h.f63629e.contains(intersection.lowerBound)) {
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
                if (this.f63630f.isEmpty()) {
                    return Iterators.i();
                }
                if (this.f63629e.upperBound.isLessThan(this.f63630f.lowerBound)) {
                    return Iterators.i();
                }
                if (this.f63629e.lowerBound.isLessThan(this.f63630f.lowerBound)) {
                    it = this.f63632h.tailMap(this.f63630f.lowerBound, false).values().iterator();
                } else {
                    it = this.f63631g.tailMap(this.f63629e.lowerBound.endpoint(), this.f63629e.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(this, it, (Cut) Ordering.natural().min(this.f63629e.upperBound, Cut.belowValue(this.f63630f.upperBound)));
            }
            return (Iterator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f63630f.isEmpty()) {
                    return Iterators.i();
                }
                Cut cut = (Cut) Ordering.natural().min(this.f63629e.upperBound, Cut.belowValue(this.f63630f.upperBound));
                return new b(this, this.f63631g.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
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
                        if (this.f63629e.contains(cut) && cut.compareTo(this.f63630f.lowerBound) >= 0 && cut.compareTo(this.f63630f.upperBound) < 0) {
                            if (cut.equals(this.f63630f.lowerBound)) {
                                Range range = (Range) Maps.P(this.f63631g.floorEntry(cut));
                                if (range != null && range.upperBound.compareTo((Cut) this.f63630f.lowerBound) > 0) {
                                    return range.intersection(this.f63630f);
                                }
                            } else {
                                Range range2 = (Range) this.f63631g.get(cut);
                                if (range2 != null) {
                                    return range2.intersection(this.f63630f);
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
                if (!range.isConnected(this.f63629e)) {
                    return ImmutableSortedMap.of();
                }
                return new e(this.f63629e.intersection(range), this.f63630f, this.f63631g);
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
            this.f63629e = range;
            n.p(range2);
            this.f63630f = range2;
            n.p(navigableMap);
            this.f63631g = navigableMap;
            this.f63632h = new d(navigableMap);
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

    @Override // b.i.d.c.f
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

    @Override // b.i.d.c.f
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

    @Override // b.i.d.c.b1
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

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // b.i.d.c.b1
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

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // b.i.d.c.f, b.i.d.c.b1
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

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(b1 b1Var) {
        return super.enclosesAll(b1Var);
    }

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // b.i.d.c.f
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

    @Override // b.i.d.c.f, b.i.d.c.b1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // b.i.d.c.f
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

    @Override // b.i.d.c.f
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

    @Override // b.i.d.c.f, b.i.d.c.b1
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

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // b.i.d.c.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* loaded from: classes2.dex */
    public static final class d<C extends Comparable<?>> extends b.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f63623e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<Cut<C>> f63624f;

        /* loaded from: classes2.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f63625g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f63626h;

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
                this.f63626h = dVar;
                this.f63625g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f63625g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f63625g.next();
                    if (this.f63626h.f63624f.upperBound.isLessThan(range.upperBound)) {
                        return (Map.Entry) b();
                    }
                    return Maps.l(range.upperBound, range);
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ x0 f63627g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f63628h;

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
                this.f63628h = dVar;
                this.f63627g = x0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f63627g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f63627g.next();
                    if (this.f63628h.f63624f.lowerBound.isLessThan(range.upperBound)) {
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
            this.f63623e = navigableMap;
            this.f63624f = Range.all();
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Iterator<Range<C>> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.f63624f.hasLowerBound()) {
                    it = this.f63623e.values().iterator();
                } else {
                    Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f63623e.lowerEntry(this.f63624f.lowerEndpoint());
                    if (lowerEntry == null) {
                        it = this.f63623e.values().iterator();
                    } else if (this.f63624f.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                        it = this.f63623e.tailMap(lowerEntry.getKey(), true).values().iterator();
                    } else {
                        it = this.f63623e.tailMap(this.f63624f.lowerEndpoint(), true).values().iterator();
                    }
                }
                return new a(this, it);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // b.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Collection<Range<C>> values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f63624f.hasUpperBound()) {
                    values = this.f63623e.headMap(this.f63624f.upperEndpoint(), false).descendingMap().values();
                } else {
                    values = this.f63623e.descendingMap().values();
                }
                x0 s = Iterators.s(values.iterator());
                if (s.hasNext() && this.f63624f.upperBound.isLessThan(((Range) s.peek()).upperBound)) {
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
                        if (this.f63624f.contains(cut) && (lowerEntry = this.f63623e.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
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
                if (range.isConnected(this.f63624f)) {
                    return new d(this.f63623e, range.intersection(this.f63624f));
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
                if (this.f63624f.equals(Range.all())) {
                    return this.f63623e.isEmpty();
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
                if (this.f63624f.equals(Range.all())) {
                    return this.f63623e.size();
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
            this.f63623e = navigableMap;
            this.f63624f = range;
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
