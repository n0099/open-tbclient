package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.b1;
import c.i.d.c.f;
import c.i.d.c.o0;
import c.i.d.c.o1;
import c.i.d.c.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public final class ImmutableRangeSet<C extends Comparable> extends f<C> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableRangeSet<Comparable<?>> ALL;
    public static final ImmutableRangeSet<Comparable<?>> EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableRangeSet<C> complement;
    public final transient ImmutableList<Range<C>> ranges;

    /* loaded from: classes3.dex */
    public final class AsSet extends ImmutableSortedSet<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DiscreteDomain<C> domain;
        public transient Integer size;
        public final /* synthetic */ ImmutableRangeSet this$0;

        /* loaded from: classes3.dex */
        public class a extends AbstractIterator<C> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Range<C>> f54682g;

            /* renamed from: h  reason: collision with root package name */
            public Iterator<C> f54683h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ AsSet f54684i;

            public a(AsSet asSet) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {asSet};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54684i = asSet;
                this.f54682g = this.f54684i.this$0.ranges.iterator();
                this.f54683h = Iterators.i();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public C a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    while (!this.f54683h.hasNext()) {
                        if (this.f54682g.hasNext()) {
                            this.f54683h = ContiguousSet.create(this.f54682g.next(), this.f54684i.domain).iterator();
                        } else {
                            return (C) b();
                        }
                    }
                    return this.f54683h.next();
                }
                return (C) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b extends AbstractIterator<C> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Range<C>> f54685g;

            /* renamed from: h  reason: collision with root package name */
            public Iterator<C> f54686h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ AsSet f54687i;

            public b(AsSet asSet) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {asSet};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54687i = asSet;
                this.f54685g = this.f54687i.this$0.ranges.reverse().iterator();
                this.f54686h = Iterators.i();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public C a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    while (!this.f54686h.hasNext()) {
                        if (this.f54685g.hasNext()) {
                            this.f54686h = ContiguousSet.create(this.f54685g.next(), this.f54687i.domain).descendingIterator();
                        } else {
                            return (C) b();
                        }
                    }
                    return this.f54686h.next();
                }
                return (C) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsSet(ImmutableRangeSet immutableRangeSet, DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableRangeSet, discreteDomain};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Comparator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = immutableRangeSet;
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == null) {
                    return false;
                }
                try {
                    return this.this$0.contains((Comparable) obj);
                } catch (ClassCastException unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new DescendingImmutableSortedSet(this) : (ImmutableSortedSet) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
            return headSetImpl((AsSet) ((Comparable) obj), z);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: com.google.common.collect.Range */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (contains(obj)) {
                    Comparable comparable = (Comparable) obj;
                    long j2 = 0;
                    o1 it = this.this$0.ranges.iterator();
                    while (it.hasNext()) {
                        Range range = (Range) it.next();
                        if (range.contains(comparable)) {
                            return Ints.j(j2 + ContiguousSet.create(range, this.domain).indexOf(comparable));
                        }
                        j2 += ContiguousSet.create(range, this.domain).size();
                    }
                    throw new AssertionError("impossible");
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.this$0.ranges.isPartialView() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Integer num = this.size;
                if (num == null) {
                    long j2 = 0;
                    o1 it = this.this$0.ranges.iterator();
                    while (it.hasNext()) {
                        j2 += ContiguousSet.create((Range) it.next(), this.domain).size();
                        if (j2 >= 2147483647L) {
                            break;
                        }
                    }
                    num = Integer.valueOf(Ints.j(j2));
                    this.size = num;
                }
                return num.intValue();
            }
            return invokeV.intValue;
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, range)) == null) ? this.this$0.subRangeSet((Range) range).asSet(this.domain) : (ImmutableSortedSet) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
            return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableRangeSet$AsSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
            return tailSetImpl((AsSet) ((Comparable) obj), z);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.this$0.ranges.toString() : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new AsSetSerializedForm(this.this$0.ranges, this.domain) : invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public o1<C> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new b(this) : (o1) invokeV.objValue;
        }

        public ImmutableSortedSet<C> headSetImpl(C c2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, c2, z)) == null) ? subSet(Range.upTo(c2, BoundType.forBoolean(z))) : (ImmutableSortedSet) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public o1<C> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new a(this) : (o1) invokeV.objValue;
        }

        public ImmutableSortedSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{c2, Boolean.valueOf(z), c3, Boolean.valueOf(z2)})) == null) {
                if (!z && !z2 && Range.compareOrThrow(c2, c3) == 0) {
                    return ImmutableSortedSet.of();
                }
                return subSet(Range.range(c2, BoundType.forBoolean(z), c3, BoundType.forBoolean(z2)));
            }
            return (ImmutableSortedSet) invokeCommon.objValue;
        }

        public ImmutableSortedSet<C> tailSetImpl(C c2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, c2, z)) == null) ? subSet(Range.downTo(c2, BoundType.forBoolean(z))) : (ImmutableSortedSet) invokeLZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DiscreteDomain<C> domain;
        public final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableList, discreteDomain};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ImmutableRangeSet(this.ranges).asSet(this.domain) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean positiveBoundedAbove;
        public final boolean positiveBoundedBelow;
        public final int size;
        public final /* synthetic */ ImmutableRangeSet this$0;

        public ComplementRanges(ImmutableRangeSet immutableRangeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableRangeSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = immutableRangeSet;
            this.positiveBoundedBelow = ((Range) immutableRangeSet.ranges.get(0)).hasLowerBound();
            this.positiveBoundedAbove = ((Range) o0.g(immutableRangeSet.ranges)).hasUpperBound();
            int size = immutableRangeSet.ranges.size() - 1;
            size = this.positiveBoundedBelow ? size + 1 : size;
            this.size = this.positiveBoundedAbove ? size + 1 : size;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.size : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.List
        public Range<C> get(int i2) {
            InterceptResult invokeI;
            Cut<C> cut;
            Cut<C> cut2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                n.n(i2, this.size);
                if (!this.positiveBoundedBelow) {
                    cut = ((Range) this.this$0.ranges.get(i2)).upperBound;
                } else {
                    cut = i2 == 0 ? Cut.belowAll() : ((Range) this.this$0.ranges.get(i2 - 1)).upperBound;
                }
                if (!this.positiveBoundedAbove || i2 != this.size - 1) {
                    cut2 = ((Range) this.this$0.ranges.get(i2 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
                } else {
                    cut2 = Cut.aboveAll();
                }
                return Range.create(cut, cut2);
            }
            return (Range) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ranges = immutableList;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.ranges.isEmpty()) {
                    return ImmutableRangeSet.of();
                }
                if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                    return ImmutableRangeSet.all();
                }
                return new ImmutableRangeSet(this.ranges);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a<C extends Comparable<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Range<C>> a;

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
            this.a = Lists.i();
        }

        public a<C> a(Range<C> range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, range)) == null) {
                n.k(!range.isEmpty(), "range must not be empty, but was %s", range);
                this.a.add(range);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<C> b(Iterable<Range<C>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) {
                for (Range<C> range : iterable) {
                    a(range);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public ImmutableRangeSet<C> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ImmutableList.a aVar = new ImmutableList.a(this.a.size());
                Collections.sort(this.a, Range.rangeLexOrdering());
                x0 s = Iterators.s(this.a.iterator());
                while (s.hasNext()) {
                    Range range = (Range) s.next();
                    while (s.hasNext()) {
                        Range<C> range2 = (Range) s.peek();
                        if (range.isConnected(range2)) {
                            n.l(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                            range = range.span((Range) s.next());
                        }
                    }
                    aVar.h(range);
                }
                ImmutableList j2 = aVar.j();
                if (j2.isEmpty()) {
                    return ImmutableRangeSet.of();
                }
                if (j2.size() == 1 && ((Range) o0.i(j2)).equals(Range.all())) {
                    return ImmutableRangeSet.all();
                }
                return new ImmutableRangeSet<>(j2);
            }
            return (ImmutableRangeSet) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1747734495, "Lcom/google/common/collect/ImmutableRangeSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1747734495, "Lcom/google/common/collect/ImmutableRangeSet;");
                return;
            }
        }
        EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
        ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList};
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
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ALL : (ImmutableRangeSet) invokeV.objValue;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, b1Var)) == null) {
            n.p(b1Var);
            if (b1Var.isEmpty()) {
                return of();
            }
            if (b1Var.encloses(Range.all())) {
                return all();
            }
            if (b1Var instanceof ImmutableRangeSet) {
                ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) b1Var;
                if (!immutableRangeSet.isPartialView()) {
                    return immutableRangeSet;
                }
            }
            return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) b1Var.asRanges()));
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }

    private ImmutableList<Range<C>> intersectRanges(Range<C> range) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, range)) == null) {
            if (!this.ranges.isEmpty() && !range.isEmpty()) {
                if (range.encloses(span())) {
                    return this.ranges;
                }
                int a2 = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
                if (range.hasUpperBound()) {
                    size = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
                } else {
                    size = this.ranges.size();
                }
                int i2 = size - a2;
                if (i2 == 0) {
                    return ImmutableList.of();
                }
                return (ImmutableList<Range<C>>) new ImmutableList<Range<C>>(this, i2, a2, range) { // from class: com.google.common.collect.ImmutableRangeSet.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ImmutableRangeSet this$0;
                    public final /* synthetic */ int val$fromIndex;
                    public final /* synthetic */ int val$length;
                    public final /* synthetic */ Range val$range;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(a2), range};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$length = i2;
                        this.val$fromIndex = a2;
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
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$length : invokeV.intValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.List
                    public Range<C> get(int i3) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i3)) == null) {
                            n.n(i3, this.val$length);
                            return (i3 == 0 || i3 == this.val$length + (-1)) ? ((Range) this.this$0.ranges.get(i3 + this.val$fromIndex)).intersection(this.val$range) : (Range) this.this$0.ranges.get(i3 + this.val$fromIndex);
                        }
                        return (Range) invokeI.objValue;
                    }
                };
            }
            return ImmutableList.of();
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? EMPTY : (ImmutableRangeSet) invokeV.objValue;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iterable)) == null) ? copyOf(TreeRangeSet.create(iterable)) : (ImmutableRangeSet) invokeL.objValue;
    }

    @Override // c.i.d.c.f
    @Deprecated
    public void add(Range<C> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, range) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // c.i.d.c.f
    @Deprecated
    public void addAll(b1<C> b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b1Var) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, discreteDomain)) == null) {
            n.p(discreteDomain);
            if (isEmpty()) {
                return ImmutableSortedSet.of();
            }
            Range<C> canonical = span().canonical(discreteDomain);
            if (canonical.hasLowerBound()) {
                if (!canonical.hasUpperBound()) {
                    try {
                        discreteDomain.maxValue();
                    } catch (NoSuchElementException unused) {
                        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                    }
                }
                return new AsSet(this, discreteDomain);
            }
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        return (ImmutableSortedSet) invokeL.objValue;
    }

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, b1Var)) == null) {
            TreeRangeSet create = TreeRangeSet.create(this);
            create.removeAll(b1Var);
            return copyOf(create);
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }

    @Override // c.i.d.c.f, c.i.d.c.b1
    public boolean encloses(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, range)) == null) {
            int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
            return b2 != -1 && this.ranges.get(b2).encloses(range);
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

    public ImmutableRangeSet<C> intersection(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, b1Var)) == null) {
            TreeRangeSet create = TreeRangeSet.create(this);
            create.removeAll(b1Var.complement());
            return copyOf(create);
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }

    @Override // c.i.d.c.f
    public boolean intersects(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, range)) == null) {
            int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            if (b2 >= this.ranges.size() || !this.ranges.get(b2).isConnected(range) || this.ranges.get(b2).intersection(range).isEmpty()) {
                if (b2 > 0) {
                    int i2 = b2 - 1;
                    if (this.ranges.get(i2).isConnected(range) && !this.ranges.get(i2).intersection(range).isEmpty()) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.d.c.f, c.i.d.c.b1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.ranges.isEmpty() : invokeV.booleanValue;
    }

    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.ranges.isPartialView() : invokeV.booleanValue;
    }

    @Override // c.i.d.c.f
    public Range<C> rangeContaining(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, c2)) == null) {
            int b2 = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c2), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
            if (b2 != -1) {
                Range<C> range = this.ranges.get(b2);
                if (range.contains(c2)) {
                    return range;
                }
                return null;
            }
            return null;
        }
        return (Range) invokeL.objValue;
    }

    @Override // c.i.d.c.f
    @Deprecated
    public void remove(Range<C> range) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, range) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // c.i.d.c.f, c.i.d.c.b1
    @Deprecated
    public void removeAll(b1<C> b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, b1Var) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public Range<C> span() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!this.ranges.isEmpty()) {
                Cut<C> cut = this.ranges.get(0).lowerBound;
                ImmutableList<Range<C>> immutableList = this.ranges;
                return Range.create(cut, immutableList.get(immutableList.size() - 1).upperBound);
            }
            throw new NoSuchElementException();
        }
        return (Range) invokeV.objValue;
    }

    public ImmutableRangeSet<C> union(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, b1Var)) == null) ? unionOf(o0.d(asRanges(), b1Var.asRanges())) : (ImmutableRangeSet) invokeL.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new SerializedForm(this.ranges) : invokeV.objValue;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, range)) == null) {
            n.p(range);
            if (range.isEmpty()) {
                return of();
            }
            if (range.equals(Range.all())) {
                return all();
            }
            return new ImmutableRangeSet<>(ImmutableList.of(range));
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }

    @Override // c.i.d.c.f
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable) == null) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: asDescendingSetOfRanges */
    public ImmutableSet<Range<C>> m115asDescendingSetOfRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.ranges.isEmpty()) {
                return ImmutableSet.of();
            }
            return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
        }
        return (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.b1
    public ImmutableSet<Range<C>> asRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.ranges.isEmpty()) {
                return ImmutableSet.of();
            }
            return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
        }
        return (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.b1
    public ImmutableRangeSet<C> complement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ImmutableRangeSet<C> immutableRangeSet = this.complement;
            if (immutableRangeSet != null) {
                return immutableRangeSet;
            }
            if (this.ranges.isEmpty()) {
                ImmutableRangeSet<C> all = all();
                this.complement = all;
                return all;
            } else if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
                ImmutableRangeSet<C> of = of();
                this.complement = of;
                return of;
            } else {
                ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(this), this);
                this.complement = immutableRangeSet2;
                return immutableRangeSet2;
            }
        }
        return (ImmutableRangeSet) invokeV.objValue;
    }

    @Override // c.i.d.c.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // c.i.d.c.f
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iterable) == null) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, range)) == null) {
            if (!isEmpty()) {
                Range<C> span = span();
                if (range.encloses(span)) {
                    return this;
                }
                if (range.isConnected(span)) {
                    return new ImmutableRangeSet<>(intersectRanges(range));
                }
            }
            return of();
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList, immutableRangeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iterable)) == null) {
            a aVar = new a();
            aVar.b(iterable);
            return aVar.c();
        }
        return (ImmutableRangeSet) invokeL.objValue;
    }
}
