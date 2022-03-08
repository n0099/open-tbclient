package com.google.common.collect;

import c.i.c.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ReverseNaturalOrdering INSTANCE;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025725267, "Lcom/google/common/collect/ReverseNaturalOrdering;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2025725267, "Lcom/google/common/collect/ReverseNaturalOrdering;");
                return;
            }
        }
        INSTANCE = new ReverseNaturalOrdering();
    }

    public ReverseNaturalOrdering() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private Object readResolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterable iterable) {
        return max((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterable iterable) {
        return min((Iterable<Comparable>) iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Ordering.natural() : (Ordering) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "Ordering.natural().reverse()" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, comparable, comparable2)) == null) {
            n.p(comparable);
            if (comparable == comparable2) {
                return 0;
            }
            return comparable2.compareTo(comparable);
        }
        return invokeLL.intValue;
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterator it) {
        return max((Iterator<Comparable>) it);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterator it) {
        return min((Iterator<Comparable>) it);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, e2, e3)) == null) ? (E) NaturalOrdering.INSTANCE.min(e2, e3) : (E) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, e2, e3)) == null) ? (E) NaturalOrdering.INSTANCE.max(e2, e3) : (E) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, e2, e3, e4, eArr)) == null) ? (E) NaturalOrdering.INSTANCE.min(e2, e3, e4, eArr) : (E) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e2, E e3, E e4, E... eArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, e2, e3, e4, eArr)) == null) ? (E) NaturalOrdering.INSTANCE.max(e2, e3, e4, eArr) : (E) invokeLLLL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, it)) == null) ? (E) NaturalOrdering.INSTANCE.min(it) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, it)) == null) ? (E) NaturalOrdering.INSTANCE.max(it) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iterable)) == null) ? (E) NaturalOrdering.INSTANCE.min(iterable) : (E) invokeL.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iterable)) == null) ? (E) NaturalOrdering.INSTANCE.max(iterable) : (E) invokeL.objValue;
    }
}
