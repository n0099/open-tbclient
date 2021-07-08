package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableSortedMultiset;
/* loaded from: classes6.dex */
public abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImmutableSortedMultisetFauxverideShim() {
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

    @Deprecated
    public static <E> ImmutableSortedMultiset.a<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset.a) invokeV.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public abstract /* synthetic */ int count(Object obj);

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2, e3)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, e2, e3, e4)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, e2, e3, e4, e5)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeLLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, e2, e3, e4, e5, e6)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeLLLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{e2, e3, e4, e5, e6, e7, eArr})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMultiset) invokeCommon.objValue;
    }
}
