package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.g1;
import c.i.d.c.o1;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes3.dex */
public final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ImmutableList<E> elements;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73185769, "Lcom/google/common/collect/RegularImmutableSortedSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73185769, "Lcom/google/common/collect/RegularImmutableSortedSet;");
                return;
            }
        }
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), Ordering.natural());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList, comparator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.elements = immutableList;
    }

    private int unsafeBinarySearch(Object obj) throws ClassCastException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) ? Collections.binarySearch(this.elements, obj, unsafeComparator()) : invokeL.intValue;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.elements : (ImmutableList) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
            int tailIndex = tailIndex(e2, true);
            if (tailIndex == size()) {
                return null;
            }
            return this.elements.get(tailIndex);
        }
        return (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj != null) {
                try {
                    return unsafeBinarySearch(obj) >= 0;
                } catch (ClassCastException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
            if (collection instanceof s0) {
                collection = ((s0) collection).elementSet();
            }
            if (g1.b(comparator(), collection) && collection.size() > 1) {
                o1<E> it = iterator();
                Iterator<?> it2 = collection.iterator();
                if (it.hasNext()) {
                    Object next = it2.next();
                    E next2 = it.next();
                    while (true) {
                        try {
                            int unsafeCompare = unsafeCompare(next2, next);
                            if (unsafeCompare < 0) {
                                if (!it.hasNext()) {
                                    return false;
                                }
                                next2 = it.next();
                            } else if (unsafeCompare == 0) {
                                if (!it2.hasNext()) {
                                    return true;
                                }
                                next = it2.next();
                            } else if (unsafeCompare > 0) {
                                break;
                            }
                        } catch (ClassCastException | NullPointerException unused) {
                        }
                    }
                    return false;
                }
                return false;
            }
            return super.containsAll(collection);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, objArr, i2)) == null) ? this.elements.copyIntoArray(objArr, i2) : invokeLI.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> createDescendingSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Comparator reverseOrder = Collections.reverseOrder(this.comparator);
            if (isEmpty()) {
                return ImmutableSortedSet.emptySet(reverseOrder);
            }
            return new RegularImmutableSortedSet(this.elements.reverse(), reverseOrder);
        }
        return (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038 A[Catch: ClassCastException | NoSuchElementException -> 0x004a, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x004a, blocks: (B:19:0x002e, B:20:0x0032, B:22:0x0038, B:24:0x0042), top: B:35:0x002e }] */
    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (size() != set.size()) {
                    return false;
                }
                if (isEmpty()) {
                    return true;
                }
                if (g1.b(this.comparator, set)) {
                    Iterator<E> it = set.iterator();
                    try {
                        o1<E> it2 = iterator();
                        while (it2.hasNext()) {
                            E next = it2.next();
                            E next2 = it.next();
                            if (next2 == null || unsafeCompare(next, next2) != 0) {
                                return false;
                            }
                            while (it2.hasNext()) {
                            }
                        }
                        return true;
                    } catch (ClassCastException | NoSuchElementException unused) {
                        return false;
                    }
                }
                return containsAll(set);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!isEmpty()) {
                return this.elements.get(0);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
            int headIndex = headIndex(e2, true) - 1;
            if (headIndex == -1) {
                return null;
            }
            return this.elements.get(headIndex);
        }
        return (E) invokeL.objValue;
    }

    public RegularImmutableSortedSet<E> getSubSet(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == size()) {
                return this;
            }
            if (i2 < i3) {
                return new RegularImmutableSortedSet<>(this.elements.subList(i2, i3), this.comparator);
            }
            return ImmutableSortedSet.emptySet(this.comparator);
        }
        return (RegularImmutableSortedSet) invokeII.objValue;
    }

    public int headIndex(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, e2, z)) == null) {
            ImmutableList<E> immutableList = this.elements;
            n.p(e2);
            int binarySearch = Collections.binarySearch(immutableList, e2, comparator());
            return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : ~binarySearch;
        }
        return invokeLZ.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, e2, z)) == null) ? getSubSet(0, headIndex(e2, z)) : (ImmutableSortedSet) invokeLZ.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) {
            int tailIndex = tailIndex(e2, false);
            if (tailIndex == size()) {
                return null;
            }
            return this.elements.get(tailIndex);
        }
        return (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            try {
                int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
                if (binarySearch >= 0) {
                    return binarySearch;
                }
                return -1;
            } catch (ClassCastException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.elements.internalArray() : (Object[]) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.elements.internalArrayEnd() : invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.elements.internalArrayStart() : invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.elements.isPartialView() : invokeV.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (!isEmpty()) {
                return this.elements.get(size() - 1);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, e2)) == null) {
            int headIndex = headIndex(e2, false) - 1;
            if (headIndex == -1) {
                return null;
            }
            return this.elements.get(headIndex);
        }
        return (E) invokeL.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.elements.size() : invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E e2, boolean z, E e3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{e2, Boolean.valueOf(z), e3, Boolean.valueOf(z2)})) == null) ? tailSetImpl(e2, z).headSetImpl(e3, z2) : (ImmutableSortedSet) invokeCommon.objValue;
    }

    public int tailIndex(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, e2, z)) == null) {
            ImmutableList<E> immutableList = this.elements;
            n.p(e2);
            int binarySearch = Collections.binarySearch(immutableList, e2, comparator());
            return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : ~binarySearch;
        }
        return invokeLZ.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E e2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, e2, z)) == null) ? getSubSet(tailIndex(e2, z), size()) : (ImmutableSortedSet) invokeLZ.objValue;
    }

    public Comparator<Object> unsafeComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.comparator : (Comparator) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public o1<E> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.elements.reverse().iterator() : (o1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public o1<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.elements.iterator() : (o1) invokeV.objValue;
    }
}
