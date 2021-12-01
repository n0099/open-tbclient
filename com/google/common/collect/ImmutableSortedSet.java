package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.f1;
import c.i.d.c.g1;
import c.i.d.c.o0;
import c.i.d.c.o1;
import c.i.d.c.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
/* loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, f1<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient Comparator<? super E> comparator;
    public transient ImmutableSortedSet<E> descendingSet;

    /* loaded from: classes2.dex */
    public static class SerializedForm<E> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Comparator<? super E> comparator;
        public final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {comparator, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableSortedSet$a */
        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = new a(this.comparator);
                aVar.n(this.elements);
                return aVar.l();
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<E> extends ImmutableSet.a<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final Comparator<? super E> f56230f;

        public a(Comparator<? super E> comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(comparator);
            this.f56230f = comparator;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            m(obj);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a
        public /* bridge */ /* synthetic */ ImmutableSet.a h(Object obj) {
            m(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        public /* bridge */ /* synthetic */ ImmutableSet.a j(Iterator it) {
            o(it);
            return this;
        }

        public a<E> m(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2)) == null) {
                super.a(e2);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> n(E... eArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eArr)) == null) {
                super.i(eArr);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<E> o(Iterator<? extends E> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, it)) == null) {
                super.j(it);
                return this;
            }
            return (a) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet.a
        /* renamed from: p */
        public ImmutableSortedSet<E> l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.f56230f, this.f56187b, this.a);
                this.f56187b = construct.size();
                this.f56188c = true;
                return construct;
            }
            return (ImmutableSortedSet) invokeV.objValue;
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.comparator = comparator;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i2, E... eArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, comparator, i2, eArr)) == null) {
            if (i2 == 0) {
                return emptySet(comparator);
            }
            u0.c(eArr, i2);
            Arrays.sort(eArr, 0, i2, comparator);
            int i3 = 1;
            for (int i4 = 1; i4 < i2; i4++) {
                Object obj = (Object) eArr[i4];
                if (comparator.compare(obj, (Object) eArr[i3 - 1]) != 0) {
                    eArr[i3] = obj;
                    i3++;
                }
            }
            Arrays.fill(eArr, i3, i2, (Object) null);
            if (i3 < eArr.length / 2) {
                eArr = (E[]) Arrays.copyOf(eArr, i3);
            }
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i3), comparator);
        }
        return (ImmutableSortedSet) invokeLIL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, comparableArr)) == null) ? construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone()) : (ImmutableSortedSet) invokeL.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sortedSet)) == null) {
            Comparator a2 = g1.a(sortedSet);
            ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
            if (copyOf.isEmpty()) {
                return emptySet(a2);
            }
            return new RegularImmutableSortedSet(copyOf, a2);
        }
        return (ImmutableSortedSet) invokeL.objValue;
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, comparator)) == null) {
            if (Ordering.natural().equals(comparator)) {
                return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
            }
            return new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
        }
        return (RegularImmutableSortedSet) invokeL.objValue;
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new a<>(Ordering.natural()) : (a) invokeV.objValue;
    }

    public static <E> ImmutableSortedSet<E> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? RegularImmutableSortedSet.NATURAL_EMPTY_SET : (ImmutableSortedSet) invokeV.objValue;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, comparator)) == null) ? new a<>(comparator) : (a) invokeL.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, objectInputStream) == null) {
            throw new InvalidObjectException("Use SerializedForm");
        }
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? new a<>(Collections.reverseOrder()) : (a) invokeV.objValue;
    }

    public E ceiling(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) ? (E) o0.f(tailSet((ImmutableSortedSet<E>) e2, true), null) : (E) invokeL.objValue;
    }

    @Override // java.util.SortedSet, c.i.d.c.f1
    public Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.comparator : (Comparator) invokeV.objValue;
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableSet
    public abstract o1<E> descendingIterator();

    public E first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? iterator().next() : (E) invokeV.objValue;
    }

    public E floor(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) ? (E) Iterators.o(headSet((ImmutableSortedSet<E>) e2, true).descendingIterator(), null) : (E) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return headSet((ImmutableSortedSet<E>) obj, z);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e2, boolean z);

    public E higher(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) ? (E) o0.f(tailSet((ImmutableSortedSet<E>) e2, false), null) : (E) invokeL.objValue;
    }

    public abstract int indexOf(Object obj);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract o1<E> iterator();

    public E last() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? descendingIterator().next() : (E) invokeV.objValue;
    }

    public E lower(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, e2)) == null) ? (E) Iterators.o(headSet((ImmutableSortedSet<E>) e2, false).descendingIterator(), null) : (E) invokeL.objValue;
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) obj, z, (boolean) obj2, z2);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e2, boolean z, E e3, boolean z2);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return tailSet((ImmutableSortedSet<E>) obj, z);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E e2, boolean z);

    public int unsafeCompare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, obj, obj2)) == null) ? unsafeCompare(this.comparator, obj, obj2) : invokeLL.intValue;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new SerializedForm(this.comparator, toArray()) : invokeV.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iterable)) == null) ? copyOf(Ordering.natural(), iterable) : (ImmutableSortedSet) invokeL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, comparable)) == null) ? new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural()) : (ImmutableSortedSet) invokeL.objValue;
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, comparator, obj, obj2)) == null) ? comparator.compare(obj, obj2) : invokeLLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
            if (immutableSortedSet == null) {
                ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
                this.descendingSet = createDescendingSet;
                createDescendingSet.descendingSet = this;
                return createDescendingSet;
            }
            return immutableSortedSet;
        }
        return (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, comparable, comparable2)) == null) ? construct(Ordering.natural(), 2, comparable, comparable2) : (ImmutableSortedSet) invokeLL.objValue;
    }

    public ImmutableSortedSet<E> headSet(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e2)) == null) ? headSet((ImmutableSortedSet<E>) e2, false) : (ImmutableSortedSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, e2, e3)) == null) ? subSet((boolean) e2, true, (boolean) e3, false) : (ImmutableSortedSet) invokeLL.objValue;
    }

    public ImmutableSortedSet<E> tailSet(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, e2)) == null) ? tailSet((ImmutableSortedSet<E>) e2, true) : (ImmutableSortedSet) invokeL.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, collection)) == null) ? copyOf((Comparator) Ordering.natural(), (Collection) collection) : (ImmutableSortedSet) invokeL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, comparable, comparable2, comparable3)) == null) ? construct(Ordering.natural(), 3, comparable, comparable2, comparable3) : (ImmutableSortedSet) invokeLLL.objValue;
    }

    public ImmutableSortedSet<E> headSet(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, e2, z)) == null) {
            n.p(e2);
            return headSetImpl(e2, z);
        }
        return (ImmutableSortedSet) invokeLZ.objValue;
    }

    public ImmutableSortedSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{e2, Boolean.valueOf(z), e3, Boolean.valueOf(z2)})) == null) {
            n.p(e2);
            n.p(e3);
            n.d(this.comparator.compare(e2, e3) <= 0);
            return subSetImpl(e2, z, e3, z2);
        }
        return (ImmutableSortedSet) invokeCommon.objValue;
    }

    public ImmutableSortedSet<E> tailSet(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, e2, z)) == null) {
            n.p(e2);
            return tailSetImpl(e2, z);
        }
        return (ImmutableSortedSet) invokeLZ.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, comparable, comparable2, comparable3, comparable4)) == null) ? construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4) : (ImmutableSortedSet) invokeLLLL.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, it)) == null) ? copyOf(Ordering.natural(), it) : (ImmutableSortedSet) invokeL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65553, null, comparable, comparable2, comparable3, comparable4, comparable5)) == null) ? construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5) : (ImmutableSortedSet) invokeLLLLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{comparable, comparable2, comparable3, comparable4, comparable5, comparable6, comparableArr})) == null) {
            int length = comparableArr.length + 6;
            Comparable[] comparableArr2 = new Comparable[length];
            comparableArr2[0] = comparable;
            comparableArr2[1] = comparable2;
            comparableArr2[2] = comparable3;
            comparableArr2[3] = comparable4;
            comparableArr2[4] = comparable5;
            comparableArr2[5] = comparable6;
            System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
            return construct(Ordering.natural(), length, comparableArr2);
        }
        return (ImmutableSortedSet) invokeCommon.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, comparator, it)) == null) {
            a aVar = new a(comparator);
            aVar.o(it);
            return aVar.l();
        }
        return (ImmutableSortedSet) invokeLL.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, comparator, iterable)) == null) {
            n.p(comparator);
            if (g1.b(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
                ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
                if (!immutableSortedSet.isPartialView()) {
                    return immutableSortedSet;
                }
            }
            Object[] o = o0.o(iterable);
            return construct(comparator, o.length, o);
        }
        return (ImmutableSortedSet) invokeLL.objValue;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, comparator, collection)) == null) ? copyOf((Comparator) comparator, (Iterable) collection) : (ImmutableSortedSet) invokeLL.objValue;
    }
}
