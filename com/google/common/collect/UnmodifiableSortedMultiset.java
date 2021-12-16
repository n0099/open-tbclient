package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.h1;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.NavigableSet;
/* loaded from: classes3.dex */
public final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements h1<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient UnmodifiableSortedMultiset<E> descendingMultiset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnmodifiableSortedMultiset(h1<E> h1Var) {
        super(h1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((s0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.d.c.h1, c.i.d.c.f1
    public Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? delegate().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> descendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
            if (unmodifiableSortedMultiset == null) {
                UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
                unmodifiableSortedMultiset2.descendingMultiset = this;
                this.descendingMultiset = unmodifiableSortedMultiset2;
                return unmodifiableSortedMultiset2;
            }
            return unmodifiableSortedMultiset;
        }
        return (h1) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? delegate().firstEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> headMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, e2, boundType)) == null) ? Multisets.q(delegate().headMultiset(e2, boundType)) : (h1) invokeLL.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? delegate().lastEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, e2, boundType, e3, boundType2)) == null) ? Multisets.q(delegate().subMultiset(e2, boundType, e3, boundType2)) : (h1) invokeLLLL.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> tailMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, e2, boundType)) == null) ? Multisets.q(delegate().tailMultiset(e2, boundType)) : (h1) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Sets.m(delegate().elementSet()) : (NavigableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, c.i.d.c.g0, c.i.d.c.s0
    public NavigableSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (NavigableSet) super.elementSet() : (NavigableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, c.i.d.c.g0, c.i.d.c.y, c.i.d.c.h0
    public h1<E> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (h1) super.delegate() : (h1) invokeV.objValue;
    }
}
