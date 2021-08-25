package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.c.l1;
import c.i.d.c.m;
import c.i.d.c.o0;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LEFT_IS_GREATER = 1;
    public static final int RIGHT_IS_GREATER = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class IncomparableValueException extends ClassCastException {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends Ordering<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f70514e;

        /* renamed from: f  reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f70515f;

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
            this.f70514e = new AtomicInteger(0);
            MapMaker mapMaker = new MapMaker();
            y0.i(mapMaker);
            this.f70515f = mapMaker.i();
        }

        public final Integer a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                Integer num = this.f70515f.get(obj);
                if (num == null) {
                    Integer valueOf = Integer.valueOf(this.f70514e.getAndIncrement());
                    Integer putIfAbsent = this.f70515f.putIfAbsent(obj, valueOf);
                    return putIfAbsent != null ? putIfAbsent : valueOf;
                }
                return num;
            }
            return (Integer) invokeL.objValue;
        }

        public int b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? System.identityHashCode(obj) : invokeL.intValue;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) {
                if (obj == obj2) {
                    return 0;
                }
                if (obj == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                int b2 = b(obj);
                int b3 = b(obj2);
                if (b2 != b3) {
                    return b2 < b3 ? -1 : 1;
                }
                int compareTo = a(obj).compareTo(a(obj2));
                if (compareTo != 0) {
                    return compareTo;
                }
                throw new AssertionError();
            }
            return invokeLL.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "Ordering.arbitrary()" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Ordering<Object> f70516a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019805948, "Lcom/google/common/collect/Ordering$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1019805948, "Lcom/google/common/collect/Ordering$b;");
                    return;
                }
            }
            f70516a = new a();
        }
    }

    public Ordering() {
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

    public static Ordering<Object> allEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AllEqualOrdering.INSTANCE : (Ordering) invokeV.objValue;
    }

    public static Ordering<Object> arbitrary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f70516a : (Ordering) invokeV.objValue;
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) ? new ExplicitOrdering(list) : (Ordering) invokeL.objValue;
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, comparator)) == null) ? comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator) : (Ordering) invokeL.objValue;
    }

    public static <C extends Comparable> Ordering<C> natural() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? NaturalOrdering.INSTANCE : (Ordering) invokeV.objValue;
    }

    public static Ordering<Object> usingToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? UsingToStringOrdering.INSTANCE : (Ordering) invokeV.objValue;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, t)) == null) ? Collections.binarySearch(list, t, this) : invokeLL.intValue;
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, comparator)) == null) {
            n.p(comparator);
            return new CompoundOrdering(this, comparator);
        }
        return (Ordering) invokeL.objValue;
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, iterable, i2)) == null) ? reverse().leastOf(iterable, i2) : (List) invokeLI.objValue;
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iterable)) == null) ? ImmutableList.sortedCopyOf(this, iterable) : (ImmutableList) invokeL.objValue;
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iterable)) == null) {
            Iterator<? extends T> it = iterable.iterator();
            if (it.hasNext()) {
                T next = it.next();
                while (it.hasNext()) {
                    T next2 = it.next();
                    if (compare(next, next2) > 0) {
                        return false;
                    }
                    next = next2;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iterable)) == null) {
            Iterator<? extends T> it = iterable.iterator();
            if (it.hasNext()) {
                T next = it.next();
                while (it.hasNext()) {
                    T next2 = it.next();
                    if (compare(next, next2) >= 0) {
                        return false;
                    }
                    next = next2;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, iterable, i2)) == null) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                if (collection.size() <= i2 * 2) {
                    Object[] array = collection.toArray();
                    Arrays.sort(array, this);
                    if (array.length > i2) {
                        array = Arrays.copyOf(array, i2);
                    }
                    return Collections.unmodifiableList(Arrays.asList(array));
                }
            }
            return leastOf(iterable.iterator(), i2);
        }
        return (List) invokeLI.objValue;
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new LexicographicalOrdering(this) : (Ordering) invokeV.objValue;
    }

    public <E extends T> E max(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, it)) == null) {
            E next = it.next();
            while (it.hasNext()) {
                next = (E) max(next, it.next());
            }
            return next;
        }
        return (E) invokeL.objValue;
    }

    public <E extends T> E min(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, it)) == null) {
            E next = it.next();
            while (it.hasNext()) {
                next = (E) min(next, it.next());
            }
            return next;
        }
        return (E) invokeL.objValue;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new NullsFirstOrdering(this) : (Ordering) invokeV.objValue;
    }

    public <S extends T> Ordering<S> nullsLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new NullsLastOrdering(this) : (Ordering) invokeV.objValue;
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.n()) : (Ordering) invokeV.objValue;
    }

    public <F> Ordering<F> onResultOf(g<F, ? extends T> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, gVar)) == null) ? new ByFunctionOrdering(gVar, this) : (Ordering) invokeL.objValue;
    }

    public <S extends T> Ordering<S> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new ReverseOrdering(this) : (Ordering) invokeV.objValue;
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, iterable)) == null) {
            Object[] o = o0.o(iterable);
            Arrays.sort(o, this);
            return Lists.j(Arrays.asList(o));
        }
        return (List) invokeL.objValue;
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? new CompoundOrdering(iterable) : (Ordering) invokeL.objValue;
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, tArr)) == null) ? explicit(Lists.a(t, tArr)) : (Ordering) invokeLL.objValue;
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, ordering)) == null) {
            n.p(ordering);
            return ordering;
        }
        return (Ordering) invokeL.objValue;
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, it, i2)) == null) ? reverse().leastOf(it, i2) : (List) invokeLI.objValue;
    }

    public <E extends T> E max(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iterable)) == null) ? (E) max(iterable.iterator()) : (E) invokeL.objValue;
    }

    public <E extends T> E min(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, iterable)) == null) ? (E) min(iterable.iterator()) : (E) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E extends T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E extends T */
    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, e2, e3)) == null) ? compare(e2, e3) >= 0 ? e2 : e3 : (E) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E extends T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E extends T */
    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, e2, e3)) == null) ? compare(e2, e3) <= 0 ? e2 : e3 : (E) invokeLL.objValue;
    }

    public <E extends T> E max(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, e2, e3, e4, eArr)) == null) {
            E e5 = (E) max(max(e2, e3), e4);
            for (E e6 : eArr) {
                e5 = (E) max(e5, e6);
            }
            return e5;
        }
        return (E) invokeLLLL.objValue;
    }

    public <E extends T> E min(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, e2, e3, e4, eArr)) == null) {
            E e5 = (E) min(min(e2, e3), e4);
            for (E e6 : eArr) {
                e5 = (E) min(e5, e6);
            }
            return e5;
        }
        return (E) invokeLLLL.objValue;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, it, i2)) == null) {
            n.p(it);
            m.b(i2, "k");
            if (i2 == 0 || !it.hasNext()) {
                return Collections.emptyList();
            }
            if (i2 >= 1073741823) {
                ArrayList k = Lists.k(it);
                Collections.sort(k, this);
                if (k.size() > i2) {
                    k.subList(i2, k.size()).clear();
                }
                k.trimToSize();
                return Collections.unmodifiableList(k);
            }
            l1 a2 = l1.a(i2, this);
            a2.c(it);
            return a2.f();
        }
        return (List) invokeLI.objValue;
    }
}
