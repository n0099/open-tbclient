package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public abstract class zl9<E> extends tl9<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public int b;

    public zl9(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        xl9.b(i2, i, "index");
        this.a = i;
        this.b = i2;
    }

    public abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b < this.a : invokeV.booleanValue;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b > 0 : invokeV.booleanValue;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (hasNext()) {
                int i = this.b;
                this.b = i + 1;
                return a(i);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (hasPrevious()) {
                int i = this.b - 1;
                this.b = i;
                return a(i);
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b - 1 : invokeV.intValue;
    }
}
