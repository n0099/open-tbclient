package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ordering};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(ordering);
        this.forwardOrder = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) ? this.forwardOrder.compare(t2, t) : invokeLL.intValue;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ReverseOrdering) {
                return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? -this.forwardOrder.hashCode() : invokeV.intValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, e2, e3)) == null) ? (E) this.forwardOrder.min(e2, e3) : (E) invokeLL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2, e3)) == null) ? (E) this.forwardOrder.max(e2, e3) : (E) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.google.common.collect.Ordering<? super T>, com.google.common.collect.Ordering<S extends T> */
    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (Ordering<? super T>) this.forwardOrder : (Ordering) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.forwardOrder + ".reverse()";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, e2, e3, e4, eArr)) == null) ? (E) this.forwardOrder.min(e2, e3, e4, eArr) : (E) invokeLLLL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, e2, e3, e4, eArr)) == null) ? (E) this.forwardOrder.max(e2, e3, e4, eArr) : (E) invokeLLLL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, it)) == null) ? (E) this.forwardOrder.min(it) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, it)) == null) ? (E) this.forwardOrder.max(it) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iterable)) == null) ? (E) this.forwardOrder.min(iterable) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iterable)) == null) ? (E) this.forwardOrder.max(iterable) : (E) invokeL.objValue;
    }
}
