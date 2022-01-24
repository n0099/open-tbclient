package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.j;
import c.i.d.a.n;
import c.i.d.c.b1;
import c.i.d.c.f;
import c.i.d.c.x0;
import c.i.d.c.y;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Range<C>> asDescendingSetOfRanges;
    public transient Set<Range<C>> asRanges;
    public transient b1<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public final class b extends y<Range<C>> implements Set<Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<Range<C>> f54915e;

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
            this.f54915e = collection;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54915e : (Collection) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f54916e;

        /* renamed from: f  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f54917f;

        /* renamed from: g  reason: collision with root package name */
        public final Range<Cut<C>> f54918g;

        /* loaded from: classes3.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f54919g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f54920h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f54921i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f54922j;

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
                this.f54922j = cVar;
                this.f54920h = cut;
                this.f54921i = x0Var;
                this.f54919g = this.f54920h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Range create;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f54922j.f54918g.upperBound.isLessThan(this.f54919g) && this.f54919g != Cut.aboveAll()) {
                        if (this.f54921i.hasNext()) {
                            Range range = (Range) this.f54921i.next();
                            create = Range.create(this.f54919g, range.lowerBound);
                            this.f54919g = range.upperBound;
                        } else {
                            create = Range.create(this.f54919g, Cut.aboveAll());
                            this.f54919g = Cut.aboveAll();
                        }
                        return Maps.l(create.lowerBound, create);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public Cut<C> f54923g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f54924h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ x0 f54925i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ c f54926j;

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
                this.f54926j = cVar;
                this.f54924h = cut;
                this.f54925i = x0Var;
                this.f54923g = this.f54924h;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.f54923g == Cut.belowAll()) {
                        return (Map.Entry) b();
                    }
                    if (!this.f54925i.hasNext()) {
                        if (this.f54926j.f54918g.lowerBound.isLessThan(Cut.belowAll())) {
                            Range create = Range.create(Cut.belowAll(), this.f54923g);
                            this.f54923g = Cut.belowAll();
                            return Maps.l(Cut.belowAll(), create);
                        }
                    } else {
                        Range range = (Range) this.f54925i.next();
                        Range create2 = Range.create(range.upperBound, this.f54923g);
                        this.f54923g = range.lowerBound;
                        if (this.f54926j.f54918g.lowerBound.isLessThan(create2.lowerBound)) {
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
                if (this.f54918g.hasLowerBound()) {
                    values = this.f54917f.tailMap(this.f54918g.lowerEndpoint(), this.f54918g.lowerBoundType() == BoundType.CLOSED).values();
                } else {
                    values = this.f54917f.values();
                }
                x0 s = Iterators.s(values.iterator());
                if (this.f54918g.contains(Cut.belowAll()) && (!s.hasNext() || ((Range) s.peek()).lowerBound != Cut.belowAll())) {
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
                if (this.f54918g.hasUpperBound()) {
                    aboveAll = this.f54918g.upperEndpoint();
                } else {
                    aboveAll = Cut.aboveAll();
                }
                x0 s = Iterators.s(this.f54917f.headMap(aboveAll, this.f54918g.hasUpperBound() && this.f54918g.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
                if (s.hasNext()) {
                    if (((Range) s.peek()).upperBound == Cut.aboveAll()) {
                        higherKey = ((Range) s.next()).lowerBound;
                    } else {
                        higherKey = this.f54916e.higherKey(((Range) s.peek()).upperBound);
                    }
                } else if (this.f54918g.contains(Cut.belowAll()) && !this.f54916e.containsKey(Cut.belowAll())) {
                    higherKey = this.f54916e.higherKey(Cut.belowAll());
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
                if (!this.f54918g.isConnected(range)) {
                    return ImmutableSortedMap.of();
                }
                return new c(this.f54916e, range.intersection(this.f54918g));
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
            this.f54916e = navigableMap;
            this.f54917f = new d(navigableMap);
            this.f54918g = range;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Range<Cut<C>> f54933e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<C> f54934f;

        /* renamed from: g  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f54935g;

        /* renamed from: h  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f54936h;

        /* loaded from: classes3.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f54937g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Cut f54938h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ e f54939i;

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
                this.f54939i = eVar;
                this.f54937g = it;
                this.f54938h = cut;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f54937g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f54937g.next();
                    if (!this.f54938h.isLessThan(range.lowerBound)) {
                        Range intersection = range.intersection(this.f54939i.f54934f);
                        return Maps.l(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f54940g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ e f54941h;

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
                this.f54941h = eVar;
                this.f54940g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f54940g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f54940g.next();
                    if (this.f54941h.f54934f.lowerBound.compareTo((Cut) range.upperBound) < 0) {
                        Range intersection = range.intersection(this.f54941h.f54934f);
                        if (this.f54941h.f54933e.contains(intersection.lowerBound)) {
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
                if (this.f54934f.isEmpty()) {
                    return Iterators.i();
                }
                if (this.f54933e.upperBound.isLessThan(this.f54934f.lowerBound)) {
                    return Iterators.i();
                }
                if (this.f54933e.lowerBound.isLessThan(this.f54934f.lowerBound)) {
                    it = this.f54936h.tailMap(this.f54934f.lowerBound, false).values().iterator();
                } else {
                    it = this.f54935g.tailMap(this.f54933e.lowerBound.endpoint(), this.f54933e.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(this, it, (Cut) Ordering.natural().min(this.f54933e.upperBound, Cut.belowValue(this.f54934f.upperBound)));
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
                if (this.f54934f.isEmpty()) {
                    return Iterators.i();
                }
                Cut cut = (Cut) Ordering.natural().min(this.f54933e.upperBound, Cut.belowValue(this.f54934f.upperBound));
                return new b(this, this.f54935g.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
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
                        if (this.f54933e.contains(cut) && cut.compareTo(this.f54934f.lowerBound) >= 0 && cut.compareTo(this.f54934f.upperBound) < 0) {
                            if (cut.equals(this.f54934f.lowerBound)) {
                                Range range = (Range) Maps.P(this.f54935g.floorEntry(cut));
                                if (range != null && range.upperBound.compareTo((Cut) this.f54934f.lowerBound) > 0) {
                                    return range.intersection(this.f54934f);
                                }
                            } else {
                                Range range2 = (Range) this.f54935g.get(cut);
                                if (range2 != null) {
                                    return range2.intersection(this.f54934f);
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
                if (!range.isConnected(this.f54933e)) {
                    return ImmutableSortedMap.of();
                }
                return new e(this.f54933e.intersection(range), this.f54934f, this.f54935g);
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
            this.f54933e = range;
            n.p(range2);
            this.f54934f = range2;
            n.p(navigableMap);
            this.f54935g = navigableMap;
            this.f54936h = new d(navigableMap);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, range)) == null) {
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

    /* loaded from: classes3.dex */
    public static final class d<C extends Comparable<?>> extends c.i.d.c.e<Cut<C>, Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f54927e;

        /* renamed from: f  reason: collision with root package name */
        public final Range<Cut<C>> f54928f;

        /* loaded from: classes3.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Iterator f54929g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f54930h;

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
                this.f54930h = dVar;
                this.f54929g = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f54929g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f54929g.next();
                    if (this.f54930h.f54928f.upperBound.isLessThan(range.upperBound)) {
                        return (Map.Entry) b();
                    }
                    return Maps.l(range.upperBound, range);
                }
                return (Map.Entry) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ x0 f54931g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d f54932h;

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
                this.f54932h = dVar;
                this.f54931g = x0Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (!this.f54931g.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) this.f54931g.next();
                    if (this.f54932h.f54928f.lowerBound.isLessThan(range.upperBound)) {
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
            this.f54927e = navigableMap;
            this.f54928f = Range.all();
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            InterceptResult invokeV;
            Iterator<Range<C>> it;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.f54928f.hasLowerBound()) {
                    it = this.f54927e.values().iterator();
                } else {
                    Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f54927e.lowerEntry(this.f54928f.lowerEndpoint());
                    if (lowerEntry == null) {
                        it = this.f54927e.values().iterator();
                    } else if (this.f54928f.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                        it = this.f54927e.tailMap(lowerEntry.getKey(), true).values().iterator();
                    } else {
                        it = this.f54927e.tailMap(this.f54928f.lowerEndpoint(), true).values().iterator();
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
                if (this.f54928f.hasUpperBound()) {
                    values = this.f54927e.headMap(this.f54928f.upperEndpoint(), false).descendingMap().values();
                } else {
                    values = this.f54927e.descendingMap().values();
                }
                x0 s = Iterators.s(values.iterator());
                if (s.hasNext() && this.f54928f.upperBound.isLessThan(((Range) s.peek()).upperBound)) {
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
                        if (this.f54928f.contains(cut) && (lowerEntry = this.f54927e.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
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
                if (range.isConnected(this.f54928f)) {
                    return new d(this.f54927e, range.intersection(this.f54928f));
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
                if (this.f54928f.equals(Range.all())) {
                    return this.f54927e.isEmpty();
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
                if (this.f54928f.equals(Range.all())) {
                    return this.f54927e.size();
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
            this.f54927e = navigableMap;
            this.f54928f = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            TreeRangeSet<C> create = create();
            create.addAll(iterable);
            return create;
        }
        return (TreeRangeSet) invokeL.objValue;
    }
}
