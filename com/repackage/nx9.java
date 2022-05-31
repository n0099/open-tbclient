package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class nx9<E> extends ox9<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public static final long d;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final E[] b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755453982, "Lcom/repackage/nx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755453982, "Lcom/repackage/nx9;");
                return;
            }
        }
        c = Integer.getInteger("sparse.shift", 0).intValue();
        int b = ny9.a.b(Object[].class);
        if (4 == b) {
            e = c + 2;
        } else if (8 == b) {
            e = c + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        d = ny9.a.a(Object[].class) + (32 << (e - c));
    }

    public nx9(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int b = qx9.b(i);
        this.a = b - 1;
        this.b = (E[]) new Object[(b << c) + 64];
    }

    public final long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? b(j, this.a) : invokeJ.longValue;
    }

    public final long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? d + ((j & j2) << e) : invokeCommon.longValue;
    }

    public final E c(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eArr, j)) == null) ? (E) ny9.a.e(eArr, j) : (E) invokeLJ.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? e(this.b, j) : (E) invokeJ.objValue;
    }

    public final E e(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, eArr, j)) == null) ? (E) ny9.a.f(eArr, j) : (E) invokeLJ.objValue;
    }

    public final void f(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            ny9.a.j(eArr, j, e2);
        }
    }

    public final void g(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            ny9.a.h(eArr, j, e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }
}
