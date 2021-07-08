package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import d.f.d.a.n;
import d.f.d.c.h1;
import d.f.d.c.s0;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET;
    public static final long[] ZERO_CUMULATIVE_COUNTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient long[] cumulativeCounts;
    public final transient RegularImmutableSortedSet<E> elementSet;
    public final transient int length;
    public final transient int offset;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1473255682, "Lcom/google/common/collect/RegularImmutableSortedMultiset;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1473255682, "Lcom/google/common/collect/RegularImmutableSortedMultiset;");
                return;
            }
        }
        ZERO_CUMULATIVE_COUNTS = new long[]{0};
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            long[] jArr = this.cumulativeCounts;
            int i3 = this.offset;
            return (int) (jArr[(i3 + i2) + 1] - jArr[i3 + i2]);
        }
        return invokeI.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            int indexOf = this.elementSet.indexOf(obj);
            if (indexOf >= 0) {
                return getCount(indexOf);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public s0.a<E> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isEmpty()) {
                return null;
            }
            return getEntry(0);
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public s0.a<E> getEntry(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? Multisets.h(this.elementSet.asList().get(i2), getCount(i2)) : (s0.a) invokeI.objValue;
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            n.v(i2, i3, this.length);
            if (i2 == i3) {
                return ImmutableSortedMultiset.emptyMultiset(comparator());
            }
            return (i2 == 0 && i3 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i2, i3), this.cumulativeCounts, this.offset + i2, i3 - i2);
        }
        return (ImmutableSortedMultiset) invokeII.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.offset > 0 || this.length < this.cumulativeCounts.length - 1 : invokeV.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public s0.a<E> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isEmpty()) {
                return null;
            }
            return getEntry(this.length - 1);
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            long[] jArr = this.cumulativeCounts;
            int i2 = this.offset;
            return Ints.j(jArr[this.length + i2] - jArr[i2]);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, e2, boundType)) == null) {
            RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
            n.p(boundType);
            return getSubMultiset(0, regularImmutableSortedSet.headIndex(e2, boundType == BoundType.CLOSED));
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, e2, boundType)) == null) {
            RegularImmutableSortedSet<E> regularImmutableSortedSet = this.elementSet;
            n.p(boundType);
            return getSubMultiset(regularImmutableSortedSet.tailIndex(e2, boundType == BoundType.CLOSED), this.length);
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public ImmutableSortedSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.elementSet : (ImmutableSortedSet) invokeV.objValue;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {regularImmutableSortedSet, jArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i2;
        this.length = i3;
    }
}
