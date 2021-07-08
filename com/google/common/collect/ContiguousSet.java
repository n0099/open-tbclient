package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableSortedSet;
import d.f.d.a.n;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DiscreteDomain<C> domain;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {discreteDomain};
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
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet.a) invokeV.objValue;
    }

    public static ContiguousSet<Integer> closed(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? create(Range.closed(Integer.valueOf(i2), Integer.valueOf(i3)), DiscreteDomain.integers()) : (ContiguousSet) invokeII.objValue;
    }

    public static ContiguousSet<Integer> closedOpen(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? create(Range.closedOpen(Integer.valueOf(i2), Integer.valueOf(i3)), DiscreteDomain.integers()) : (ContiguousSet) invokeII.objValue;
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, range, discreteDomain)) == null) {
            n.p(range);
            n.p(discreteDomain);
            try {
                Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
                if (!range.hasUpperBound()) {
                    intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
                }
                return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
            } catch (NoSuchElementException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (ContiguousSet) invokeLL.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<C> createDescendingSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DescendingImmutableSortedSet(this) : (ImmutableSortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> headSetImpl(C c2, boolean z);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object obj, boolean z) {
        return headSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    public abstract ContiguousSet<C> subSetImpl(C c2, boolean z, C c3, boolean z2);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object obj, boolean z, Object obj2, boolean z2) {
        return subSetImpl((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> tailSetImpl(C c2, boolean z);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object obj, boolean z) {
        return tailSetImpl((ContiguousSet<C>) ((Comparable) obj), z);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? range().toString() : (String) invokeV.objValue;
    }

    public static ContiguousSet<Long> closed(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs()) : (ContiguousSet) invokeCommon.objValue;
    }

    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs()) : (ContiguousSet) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return subSet((boolean) ((Comparable) obj), z, (boolean) ((Comparable) obj2), z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ContiguousSet<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public ContiguousSet<C> headSet(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2)) == null) {
            n.p(c2);
            return headSetImpl((ContiguousSet<C>) c2, false);
        }
        return (ContiguousSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c2, C c3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, c2, c3)) == null) {
            n.p(c2);
            n.p(c3);
            n.d(comparator().compare(c2, c3) <= 0);
            return subSetImpl((boolean) c2, true, (boolean) c3, false);
        }
        return (ContiguousSet) invokeLL.objValue;
    }

    public ContiguousSet<C> tailSet(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c2)) == null) {
            n.p(c2);
            return tailSetImpl((ContiguousSet<C>) c2, true);
        }
        return (ContiguousSet) invokeL.objValue;
    }

    public ContiguousSet<C> headSet(C c2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, c2, z)) == null) {
            n.p(c2);
            return headSetImpl((ContiguousSet<C>) c2, z);
        }
        return (ContiguousSet) invokeLZ.objValue;
    }

    public ContiguousSet<C> tailSet(C c2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, c2, z)) == null) {
            n.p(c2);
            return tailSetImpl((ContiguousSet<C>) c2, z);
        }
        return (ContiguousSet) invokeLZ.objValue;
    }

    public ContiguousSet<C> subSet(C c2, boolean z, C c3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{c2, Boolean.valueOf(z), c3, Boolean.valueOf(z2)})) == null) {
            n.p(c2);
            n.p(c3);
            n.d(comparator().compare(c2, c3) <= 0);
            return subSetImpl((boolean) c2, z, (boolean) c3, z2);
        }
        return (ContiguousSet) invokeCommon.objValue;
    }
}
