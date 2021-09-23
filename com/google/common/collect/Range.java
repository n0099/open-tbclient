package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.a.o;
import c.i.d.c.o0;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
/* loaded from: classes9.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements o<C>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Range<Comparable> ALL;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* loaded from: classes9.dex */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final Ordering<Range<?>> INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1107672881, "Lcom/google/common/collect/Range$RangeLexOrdering;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1107672881, "Lcom/google/common/collect/Range$RangeLexOrdering;");
                    return;
                }
            }
            INSTANCE = new RangeLexOrdering();
        }

        public RangeLexOrdering() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, range, range2)) == null) ? c.i.d.c.o.f().d(range.lowerBound, range2.lowerBound).d(range.upperBound, range2.upperBound).e() : invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71016a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787244146, "Lcom/google/common/collect/Range$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1787244146, "Lcom/google/common/collect/Range$a;");
                    return;
                }
            }
            int[] iArr = new int[BoundType.values().length];
            f71016a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71016a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements g<Range, Cut> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f71017e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787244115, "Lcom/google/common/collect/Range$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1787244115, "Lcom/google/common/collect/Range$b;");
                    return;
                }
            }
            f71017e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.a.g
        /* renamed from: a */
        public Cut apply(Range range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, range)) == null) ? range.lowerBound : (Cut) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements g<Range, Cut> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c f71018e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787244084, "Lcom/google/common/collect/Range$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1787244084, "Lcom/google/common/collect/Range$c;");
                    return;
                }
            }
            f71018e = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.a.g
        /* renamed from: a */
        public Cut apply(Range range) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, range)) == null) ? range.upperBound : (Cut) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-699065685, "Lcom/google/common/collect/Range;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-699065685, "Lcom/google/common/collect/Range;");
                return;
            }
        }
        ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    }

    public Range(Cut<C> cut, Cut<C> cut2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cut, cut2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.p(cut);
        this.lowerBound = cut;
        n.p(cut2);
        this.upperBound = cut2;
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (Range<C>) ALL : (Range) invokeV.objValue;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c2)) == null) ? create(Cut.belowValue(c2), Cut.aboveAll()) : (Range) invokeL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c2)) == null) ? create(Cut.belowAll(), Cut.aboveValue(c2)) : (Range) invokeL.objValue;
    }

    public static <T> SortedSet<T> cast(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iterable)) == null) ? (SortedSet) iterable : (SortedSet) invokeL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, c2, c3)) == null) ? create(Cut.belowValue(c2), Cut.aboveValue(c3)) : (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, c2, c3)) == null) ? create(Cut.belowValue(c2), Cut.belowValue(c3)) : (Range) invokeLL.objValue;
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, comparable, comparable2)) == null) ? comparable.compareTo(comparable2) : invokeLL.intValue;
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, cut, cut2)) == null) ? new Range<>(cut, cut2) : (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, c2, boundType)) == null) {
            int i2 = a.f71016a[boundType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return atLeast(c2);
                }
                throw new AssertionError();
            }
            return greaterThan(c2);
        }
        return (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iterable)) == null) {
            n.p(iterable);
            if (iterable instanceof SortedSet) {
                SortedSet cast = cast(iterable);
                Comparator comparator = cast.comparator();
                if (Ordering.natural().equals(comparator) || comparator == null) {
                    return closed((Comparable) cast.first(), (Comparable) cast.last());
                }
            }
            Iterator<C> it = iterable.iterator();
            C next = it.next();
            n.p(next);
            C c2 = next;
            Comparable comparable = c2;
            while (it.hasNext()) {
                C next2 = it.next();
                n.p(next2);
                C c3 = next2;
                c2 = (Comparable) Ordering.natural().min(c2, c3);
                comparable = (Comparable) Ordering.natural().max(comparable, c3);
            }
            return closed(c2, comparable);
        }
        return (Range) invokeL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, c2)) == null) ? create(Cut.aboveValue(c2), Cut.aboveAll()) : (Range) invokeL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, c2)) == null) ? create(Cut.belowAll(), Cut.belowValue(c2)) : (Range) invokeL.objValue;
    }

    public static <C extends Comparable<?>> g<Range<C>, Cut<C>> lowerBoundFn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? b.f71017e : (g) invokeV.objValue;
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, c2, c3)) == null) ? create(Cut.aboveValue(c2), Cut.belowValue(c3)) : (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, c2, c3)) == null) ? create(Cut.aboveValue(c2), Cut.aboveValue(c3)) : (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65553, null, c2, boundType, c3, boundType2)) == null) {
            n.p(boundType);
            n.p(boundType2);
            return create(boundType == BoundType.OPEN ? Cut.aboveValue(c2) : Cut.belowValue(c2), boundType2 == BoundType.OPEN ? Cut.belowValue(c3) : Cut.aboveValue(c3));
        }
        return (Range) invokeLLLL.objValue;
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? (Ordering<Range<C>>) RangeLexOrdering.INSTANCE : (Ordering) invokeV.objValue;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, c2)) == null) ? closed(c2, c2) : (Range) invokeL.objValue;
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, c2, boundType)) == null) {
            int i2 = a.f71016a[boundType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return atMost(c2);
                }
                throw new AssertionError();
            }
            return lessThan(c2);
        }
        return (Range) invokeLL.objValue;
    }

    public static <C extends Comparable<?>> g<Range<C>, Cut<C>> upperBoundFn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c.f71018e : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.a.o
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, discreteDomain)) == null) {
            n.p(discreteDomain);
            Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
            Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
            return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
        }
        return (Range) invokeL.objValue;
    }

    public boolean contains(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c2)) == null) {
            n.p(c2);
            return this.lowerBound.isLessThan(c2) && !this.upperBound.isLessThan(c2);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iterable)) == null) {
            if (o0.j(iterable)) {
                return true;
            }
            if (iterable instanceof SortedSet) {
                SortedSet cast = cast(iterable);
                Comparator comparator = cast.comparator();
                if (Ordering.natural().equals(comparator) || comparator == null) {
                    return contains((Comparable) cast.first()) && contains((Comparable) cast.last());
                }
            }
            for (C c2 : iterable) {
                if (!contains(c2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean encloses(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, range)) == null) ? this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0 : invokeL.booleanValue;
    }

    @Override // c.i.d.a.o
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Range<C> gap(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, range)) == null) {
            boolean z = this.lowerBound.compareTo((Cut) range.lowerBound) < 0;
            Range<C> range2 = z ? this : range;
            if (!z) {
                range = this;
            }
            return create(range2.upperBound, range.lowerBound);
        }
        return (Range) invokeL.objValue;
    }

    public boolean hasLowerBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lowerBound != Cut.belowAll() : invokeV.booleanValue;
    }

    public boolean hasUpperBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.upperBound != Cut.aboveAll() : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode() : invokeV.intValue;
    }

    public Range<C> intersection(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, range)) == null) {
            int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
            int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
            if (compareTo < 0 || compareTo2 > 0) {
                if (compareTo > 0 || compareTo2 < 0) {
                    return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
                }
                return range;
            }
            return this;
        }
        return (Range) invokeL.objValue;
    }

    public boolean isConnected(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, range)) == null) ? this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0 : invokeL.booleanValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.lowerBound.equals(this.upperBound) : invokeV.booleanValue;
    }

    public BoundType lowerBoundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.lowerBound.typeAsLowerBound() : (BoundType) invokeV.objValue;
    }

    public C lowerEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.lowerBound.endpoint() : (C) invokeV.objValue;
    }

    public Object readResolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? equals(ALL) ? all() : this : invokeV.objValue;
    }

    public Range<C> span(Range<C> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, range)) == null) {
            int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
            int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
            if (compareTo > 0 || compareTo2 < 0) {
                if (compareTo < 0 || compareTo2 > 0) {
                    return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
                }
                return range;
            }
            return this;
        }
        return (Range) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? toString(this.lowerBound, this.upperBound) : (String) invokeV.objValue;
    }

    public BoundType upperBoundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.upperBound.typeAsUpperBound() : (BoundType) invokeV.objValue;
    }

    public C upperEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.upperBound.endpoint() : (C) invokeV.objValue;
    }

    public static String toString(Cut<?> cut, Cut<?> cut2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, cut, cut2)) == null) {
            StringBuilder sb = new StringBuilder(16);
            cut.describeAsLowerBound(sb);
            sb.append(IStringUtil.TOP_PATH);
            cut2.describeAsUpperBound(sb);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public boolean apply(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2)) == null) ? contains(c2) : invokeL.booleanValue;
    }
}
