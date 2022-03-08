package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.c.a.o;
import c.i.c.c.l0;
import c.i.c.c.n;
import c.i.c.c.o0;
import c.i.c.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class Sets {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a<E> extends n.a<E> implements Set<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set<E> set, o<? super E> oVar) {
            super(set, oVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], (o) objArr2[1]);
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

    /* loaded from: classes7.dex */
    public static class b<E> extends a<E> implements SortedSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SortedSet<E> sortedSet, o<? super E> oVar) {
            super(sortedSet, oVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedSet, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Set) objArr2[0], (o) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((SortedSet) this.f28692e).comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public E first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (E) Iterators.m(this.f28692e.iterator(), this.f28693f) : (E) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2)) == null) ? new b(((SortedSet) this.f28692e).headSet(e2), this.f28693f) : (SortedSet) invokeL.objValue;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [E, java.lang.Object] */
        @Override // java.util.SortedSet
        public E last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
                return (E) invokeV.objValue;
            }
            SortedSet sortedSet = (SortedSet) this.f28692e;
            while (true) {
                ?? r1 = (Object) sortedSet.last();
                if (this.f28693f.apply(r1)) {
                    return r1;
                }
                sortedSet = sortedSet.headSet(r1);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e2, E e3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, e2, e3)) == null) ? new b(((SortedSet) this.f28692e).subSet(e2, e3), this.f28693f) : (SortedSet) invokeLL.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e2)) == null) ? new b(((SortedSet) this.f28692e).tailSet(e2), this.f28693f) : (SortedSet) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c<E> extends AbstractSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) ? Sets.k(this, collection) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                c.i.c.a.n.p(collection);
                return super.retainAll(collection);
            }
            return invokeL.booleanValue;
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, set, obj)) == null) {
            if (set == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set2 = (Set) obj;
                try {
                    if (set.size() == set2.size()) {
                        if (set.containsAll(set2)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <E> Set<E> b(Set<E> set, o<? super E> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, set, oVar)) == null) {
            if (set instanceof SortedSet) {
                return c((SortedSet) set, oVar);
            }
            if (set instanceof a) {
                a aVar = (a) set;
                return new a((Set) aVar.f28692e, Predicates.c(aVar.f28693f, oVar));
            }
            c.i.c.a.n.p(set);
            c.i.c.a.n.p(oVar);
            return new a(set, oVar);
        }
        return (Set) invokeLL.objValue;
    }

    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, o<? super E> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sortedSet, oVar)) == null) {
            if (sortedSet instanceof a) {
                a aVar = (a) sortedSet;
                return new b((SortedSet) aVar.f28692e, Predicates.c(aVar.f28693f, oVar));
            }
            c.i.c.a.n.p(sortedSet);
            c.i.c.a.n.p(oVar);
            return new b(sortedSet, oVar);
        }
        return (SortedSet) invokeLL.objValue;
    }

    public static int d(Set<?> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, set)) == null) {
            Iterator<?> it = set.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static <E> Set<E> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Collections.newSetFromMap(new ConcurrentHashMap()) : (Set) invokeV.objValue;
    }

    public static <E> HashSet<E> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new HashSet<>() : (HashSet) invokeV.objValue;
    }

    public static <E> HashSet<E> g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? new HashSet<>(Maps.e(i2)) : (HashSet) invokeI.objValue;
    }

    public static <E> Set<E> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Collections.newSetFromMap(Maps.u()) : (Set) invokeV.objValue;
    }

    public static <E> LinkedHashSet<E> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new LinkedHashSet<>() : (LinkedHashSet) invokeV.objValue;
    }

    public static <E> LinkedHashSet<E> j(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return new LinkedHashSet<>(n.a(iterable));
            }
            LinkedHashSet<E> i2 = i();
            o0.a(i2, iterable);
            return i2;
        }
        return (LinkedHashSet) invokeL.objValue;
    }

    public static boolean k(Set<?> set, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, set, collection)) == null) {
            c.i.c.a.n.p(collection);
            if (collection instanceof s0) {
                collection = ((s0) collection).elementSet();
            }
            if ((collection instanceof Set) && collection.size() > set.size()) {
                return Iterators.u(set.iterator(), collection);
            }
            return l(set, collection.iterator());
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(Set<?> set, Iterator<?> it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, set, it)) == null) {
            boolean z = false;
            while (it.hasNext()) {
                z |= set.remove(it.next());
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static <E> NavigableSet<E> m(NavigableSet<E> navigableSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, navigableSet)) == null) ? ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet) : (NavigableSet) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class UnmodifiableNavigableSet<E> extends l0<E> implements NavigableSet<E>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final NavigableSet<E> delegate;
        public transient UnmodifiableNavigableSet<E> descendingSet;
        public final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.c.a.n.p(navigableSet);
            this.delegate = navigableSet;
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) ? this.delegate.ceiling(e2) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Iterators.B(this.delegate.descendingIterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
                if (unmodifiableNavigableSet == null) {
                    UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
                    this.descendingSet = unmodifiableNavigableSet2;
                    unmodifiableNavigableSet2.descendingSet = this;
                    return unmodifiableNavigableSet2;
                }
                return unmodifiableNavigableSet;
            }
            return (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2)) == null) ? this.delegate.floor(e2) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2, z)) == null) ? Sets.m(this.delegate.headSet(e2, z)) : (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e2)) == null) ? this.delegate.higher(e2) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) ? this.delegate.lower(e2) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{e2, Boolean.valueOf(z), e3, Boolean.valueOf(z2)})) == null) ? Sets.m(this.delegate.subSet(e2, z, e3, z2)) : (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, e2, z)) == null) ? Sets.m(this.delegate.tailSet(e2, z)) : (NavigableSet) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.c.c.l0, c.i.c.c.j0, c.i.c.c.y, c.i.c.c.h0
        public SortedSet<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.unmodifiableDelegate : (SortedSet) invokeV.objValue;
        }
    }
}
