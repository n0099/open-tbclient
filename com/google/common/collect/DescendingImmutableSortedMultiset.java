package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.c.h1;
import d.f.d.c.s0;
/* loaded from: classes6.dex */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ImmutableSortedMultiset<E> forward;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableSortedMultiset};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.forward = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.forward.count(obj) : invokeL.intValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public s0.a<E> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.forward.lastEntry() : (s0.a) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public s0.a<E> getEntry(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.forward.entrySet().asList().reverse().get(i2) : (s0.a) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.forward.isPartialView() : invokeV.booleanValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public s0.a<E> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.forward.firstEntry() : (s0.a) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.forward.size() : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public /* bridge */ /* synthetic */ h1 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public ImmutableSortedMultiset<E> descendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forward : (ImmutableSortedMultiset) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, e2, boundType)) == null) ? this.forward.tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).descendingMultiset() : (ImmutableSortedMultiset) invokeLL.objValue;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.f.d.c.h1
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, e2, boundType)) == null) ? this.forward.headMultiset((ImmutableSortedMultiset<E>) e2, boundType).descendingMultiset() : (ImmutableSortedMultiset) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public ImmutableSortedSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forward.elementSet().descendingSet() : (ImmutableSortedSet) invokeV.objValue;
    }
}
