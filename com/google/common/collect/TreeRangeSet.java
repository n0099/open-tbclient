package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.j;
import c.i.d.a.n;
import c.i.d.c.b1;
import c.i.d.c.f;
import c.i.d.c.x0;
import c.i.d.c.y;
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
/* loaded from: classes10.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient b1<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes10.dex */
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

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                this.this$0.remove(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.b1
        public b1<C> complement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0 : (b1) invokeV.objValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? !this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public void remove(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, range) == null) {
                this.this$0.add(range);
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public void add(Range<C> range) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
                n.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
                super.add(range);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.remove(this.restriction);
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
        public boolean contains(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? this.restriction.contains(c2) && this.this$0.contains(c2) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f, c.i.d.c.b1
        public boolean encloses(Range<C> range) {
            InterceptResult invokeL;
            Range rangeEnclosing;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, range)) == null) ? (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = this.this$0.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
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

        @Override // com.google.common.collect.TreeRangeSet, c.i.d.c.f
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

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public final class b extends y<Range<C>> implements Set<Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Range<C>> f71125e;

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
            this.f71125e = collection;
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
        @Override // c.i.d.c.y, c.i.d.c.h0
        public Collection<Range<C>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71125e : (Collection) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f71126e;

        /* renamed from: f  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f71127f;

        /* renamed from: g  reason: collision with root package name */
        public final Range<Cut<C>> f71128g;

        /* loaded from: classes10.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f71129g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f71130h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f71131i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f71132j;

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
                this.f71132j = cVar;
                this.f71130h = cut;
                this.f71131i = x0Var;
                this.f71129g = this.f71130h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Range create;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f71132j.f71128g.upperBound.isLessThan(this.f71129g) && this.f71129g != Cut.aboveAll()) {
                        if (this.f71131i.hasNext()) {
                            Range range = (Range) this.f71131i.next();
                            create = Range.create(this.f71129g, range.lowerBound);
                            this.f71129g = range.upperBound;
                        } else {
                            create = Range.create(this.f71129g, Cut.aboveAll());
                            this.f71129g = Cut.aboveAll();
                        }
                        return Maps.l(create.lowerBound, create);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f71133g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f71134h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f71135i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f71136j;

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
                this.f71136j = cVar;
                this.f71134h = cut;
                this.f71135i = x0Var;
                this.f71133g = this.f71134h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.f71133g == Cut.belowAll()) {
                        return (Map.Entry) b();
                    }
                    if (!this.f71135i.hasNext()) {
                        if (this.f71136j.f71128g.lowerBound.isLessThan(Cut.belowAll())) {
                            Range create = Range.create(Cut.belowAll(), this.f71133g);
                            this.f71133g = Cut.belowAll();
                            return Maps.l(Cut.belowAll(), create);
                        }
                    } else {
                        Range range = (Range) this.f71135i.next();
                        Range create2 = Range.create(range.upperBound, this.f71133g);
                        this.f71133g = range.lowerBound;
                        if (this.f71136j.f71128g.lowerBound.isLessThan(create2.lowerBound)) {
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
                if (this.f71128g.hasLowerBound()) {
                    values = this.f71127f.tailMap(this.f71128g.lowerEndpoint(), this.f71128g.lowerBoundType() == BoundType.CLOSED).values();
                } else {
                    values = this.f71127f.values();
                }
                x0 s = Iterators.s(values.iterator());
                if (this.f71128g.contains(Cut.belowAll()) && (!s.hasNext() || ((Range) s.peek()).lowerBound != Cut.belowAll())) {
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

        @Override // c.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Cut<C> aboveAll;
            Cut<C> higherKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f71128g.hasUpperBound()) {
                    aboveAll = this.f71128g.upperEndpoint();
                } else {
                    aboveAll = Cut.aboveAll();
                }
                x0 s = Iterators.s(this.f71127f.headMap(aboveAll, this.f71128g.hasUpperBound() && this.f71128g.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
                if (s.hasNext()) {
                    if (((Range) s.peek()).upperBound == Cut.aboveAll()) {
                        higherKey = ((Range) s.next()).lowerBound;
                    } else {
                        higherKey = this.f71126e.higherKey(((Range) s.peek()).upperBound);
                    }
                } else if (this.f71128g.contains(Cut.belowAll()) && !this.f71126e.containsKey(Cut.belowAll())) {
                    higherKey = this.f71126e.higherKey(Cut.belowAll());
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
                if (!this.f71128g.isConnected(range)) {
                    return ImmutableSortedMap.of();
                }
                return new c(this.f71126e, range.intersection(this.f71128g));
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
            this.f71126e = navigableMap;
            this.f71127f = new d(navigableMap);
            this.f71128g = range;
        }
    }

    /* loaded from: classes10.dex */
    public static final class e<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Range<Cut<C>> f71143e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<C> f71144f;

        /* renamed from: g  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f71145g;

        /* renamed from: h  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f71146h;

        /* loaded from: classes10.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f71147g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f71148h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ e f71149i;

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
                this.f71149i = eVar;
                this.f71147g = it;
                this.f71148h = cut;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f71147g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f71147g.next();
                    if (!this.f71148h.isLessThan(range.lowerBound)) {
                        Range intersection = range.intersection(this.f71149i.f71144f);
                        return Maps.l(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f71150g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ e f71151h;

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
                this.f71151h = eVar;
                this.f71150g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f71150g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f71150g.next();
                    if (this.f71151h.f71144f.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                        Range intersection = range.intersection(this.f71151h.f71144f);
                        if (this.f71151h.f71143e.contains(intersection.lowerBound)) {
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
                if (this.f71144f.isEmpty()) {
                    return Iterators.i();
                }
                if (this.f71143e.upperBound.isLessThan(this.f71144f.lowerBound)) {
                    return Iterators.i();
                }
                if (this.f71143e.lowerBound.isLessThan(this.f71144f.lowerBound)) {
                    it = this.f71146h.tailMap(this.f71144f.lowerBound, false).values().iterator();
                } else {
                    it = this.f71145g.tailMap(this.f71143e.lowerBound.endpoint(), this.f71143e.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(this, it, (Cut) Ordering.natural().min(this.f71143e.upperBound, Cut.belowValue(this.f71144f.upperBound)));
            }
            return (Iterator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f71144f.isEmpty()) {
                    return Iterators.i();
                }
                Cut cut = (Cut) Ordering.natural().min(this.f71143e.upperBound, Cut.belowValue(this.f71144f.upperBound));
                return new b(this, this.f71145g.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
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
                        if (this.f71143e.contains(cut) && cut.compareTo(this.f71144f.lowerBound) >= 0 && cut.compareTo(this.f71144f.upperBound) < 0) {
                            if (cut.equals(this.f71144f.lowerBound)) {
                                Range range = (Range) Maps.P(this.f71145g.floorEntry(cut));
                                if (range != null && range.upperBound.compareTo((Cut) this.f71144f.lowerBound) > 0) {
                                    return range.intersection(this.f71144f);
                                }
                            } else {
                                Range range2 = (Range) this.f71145g.get(cut);
                                if (range2 != null) {
                                    return range2.intersection(this.f71144f);
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
                if (!range.isConnected(this.f71143e)) {
                    return ImmutableSortedMap.of();
                }
                return new e(this.f71143e.intersection(range), this.f71144f, this.f71145g);
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
            this.f71143e = range;
            n.p(range2);
            this.f71144f = range2;
            n.p(navigableMap);
            this.f71145g = navigableMap;
            this.f71146h = new d(navigableMap);
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

    @Override // c.i.d.c.f
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

    @Override // c.i.d.c.f
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

    @Override // c.i.d.c.b1
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

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // c.i.d.c.b1
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

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // c.i.d.c.f, c.i.d.c.b1
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

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(b1 b1Var) {
        return super.enclosesAll(b1Var);
    }

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // c.i.d.c.f
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

    @Override // c.i.d.c.f, c.i.d.c.b1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // c.i.d.c.f
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

    @Override // c.i.d.c.f
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

    @Override // c.i.d.c.f, c.i.d.c.b1
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

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* loaded from: classes10.dex */
    public static final class d<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f71137e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<Cut<C>> f71138f;

        /* loaded from: classes10.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f71139g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f71140h;

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
                this.f71140h = dVar;
                this.f71139g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f71139g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f71139g.next();
                    if (this.f71140h.f71138f.upperBound.isLessThan(range.upperBound)) {
                        return (Map.Entry) b();
                    }
                    return Maps.l(range.upperBound, range);
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ x0 f71141g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f71142h;

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
                this.f71142h = dVar;
                this.f71141g = x0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f71141g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f71141g.next();
                    if (this.f71142h.f71138f.lowerBound.isLessThan(range.upperBound)) {
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
            this.f71137e = navigableMap;
            this.f71138f = Range.all();
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Iterator<Range<C>> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.f71138f.hasLowerBound()) {
                    it = this.f71137e.values().iterator();
                } else {
                    Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f71137e.lowerEntry(this.f71138f.lowerEndpoint());
                    if (lowerEntry == null) {
                        it = this.f71137e.values().iterator();
                    } else if (this.f71138f.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                        it = this.f71137e.tailMap(lowerEntry.getKey(), true).values().iterator();
                    } else {
                        it = this.f71137e.tailMap(this.f71138f.lowerEndpoint(), true).values().iterator();
                    }
                }
                return new a(this, it);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            InterceptResult invokeV;
            Collection<Range<C>> values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f71138f.hasUpperBound()) {
                    values = this.f71137e.headMap(this.f71138f.upperEndpoint(), false).descendingMap().values();
                } else {
                    values = this.f71137e.descendingMap().values();
                }
                x0 s = Iterators.s(values.iterator());
                if (s.hasNext() && this.f71138f.upperBound.isLessThan(((Range) s.peek()).upperBound)) {
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
                        if (this.f71138f.contains(cut) && (lowerEntry = this.f71137e.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
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
                if (range.isConnected(this.f71138f)) {
                    return new d(this.f71137e, range.intersection(this.f71138f));
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
                if (this.f71138f.equals(Range.all())) {
                    return this.f71137e.isEmpty();
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
                if (this.f71138f.equals(Range.all())) {
                    return this.f71137e.size();
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
            this.f71137e = navigableMap;
            this.f71138f = range;
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
