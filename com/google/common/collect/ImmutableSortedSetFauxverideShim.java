package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableSortedSet;
/* loaded from: classes6.dex */
public abstract class ImmutableSortedSetFauxverideShim<E> extends ImmutableSet<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImmutableSortedSetFauxverideShim() {
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
    public static <E> ImmutableSortedSet.a<E> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet.a) invokeV.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet.a) invokeI.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, e2, e3)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2, E e3, E e4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, e2, e3, e4)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2, E e3, E e4, E e5) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, e2, e3, e4, e5)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeLLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, e2, e3, e4, e5, e6)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeLLLLL.objValue;
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{e2, e3, e4, e5, e6, e7, eArr})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedSet) invokeCommon.objValue;
    }
}
