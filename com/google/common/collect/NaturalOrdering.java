package com.google.common.collect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final NaturalOrdering INSTANCE;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Ordering<Comparable> nullsFirst;
    public transient Ordering<Comparable> nullsLast;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(472775307, "Lcom/google/common/collect/NaturalOrdering;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(472775307, "Lcom/google/common/collect/NaturalOrdering;");
                return;
            }
        }
        INSTANCE = new NaturalOrdering();
    }

    public NaturalOrdering() {
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
    public <S extends Comparable> Ordering<S> nullsFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Ordering<S> ordering = (Ordering<S>) this.nullsFirst;
            if (ordering == null) {
                Ordering<S> nullsFirst = super.nullsFirst();
                this.nullsFirst = nullsFirst;
                return nullsFirst;
            }
            return ordering;
        }
        return (Ordering) invokeV.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Ordering<S> ordering = (Ordering<S>) this.nullsLast;
            if (ordering == null) {
                Ordering<S> nullsLast = super.nullsLast();
                this.nullsLast = nullsLast;
                return nullsLast;
            }
            return ordering;
        }
        return (Ordering) invokeV.objValue;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ReverseNaturalOrdering.INSTANCE : (Ordering) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Ordering.natural()" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, comparable, comparable2)) == null) {
            n.p(comparable);
            n.p(comparable2);
            return comparable.compareTo(comparable2);
        }
        return invokeLL.intValue;
    }
}
