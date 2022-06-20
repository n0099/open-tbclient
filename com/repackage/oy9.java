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
public class oy9<E> extends qy9<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static final long h;
    public static final long i;
    public static final long j;
    public static final int k;
    public static final Object l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755423230, "Lcom/repackage/oy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755423230, "Lcom/repackage/oy9;");
                return;
            }
        }
        g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        l = new Object();
        int b = uy9.a.b(Object[].class);
        if (4 == b) {
            k = 2;
        } else if (8 == b) {
            k = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        j = uy9.a.a(Object[].class);
        try {
            h = uy9.a.g(ty9.class.getDeclaredField("producerIndex"));
            try {
                i = uy9.a.g(qy9.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public oy9(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int b = xx9.b(i2);
        long j2 = b - 1;
        E[] eArr = (E[]) new Object[b + 1];
        this.d = eArr;
        this.c = j2;
        a(b);
        this.f = eArr;
        this.e = j2;
        this.b = j2 - 1;
        n(0L);
    }

    public static long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? j + (j2 << k) : invokeJ.longValue;
    }

    public static long c(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? b(j2 & j3) : invokeCommon.longValue;
    }

    public static <E> Object e(E[] eArr, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, eArr, j2)) == null) ? uy9.a.f(eArr, j2) : invokeLJ.objValue;
    }

    public static void l(Object[] objArr, long j2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{objArr, Long.valueOf(j2), obj}) == null) {
            uy9.a.j(objArr, j2, obj);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.a = Math.min(i2 / 4, g);
        }
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? uy9.a.d(this, i) : invokeV.longValue;
    }

    public final E[] f(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eArr)) == null) ? (E[]) ((Object[]) e(eArr, b(eArr.length - 1))) : (E[]) ((Object[]) invokeL.objValue);
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? uy9.a.d(this, h) : invokeV.longValue;
    }

    public final E h(E[] eArr, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{eArr, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f = eArr;
            return (E) e(eArr, c(j2, j3));
        }
        return (E) invokeCommon.objValue;
    }

    public final E i(E[] eArr, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eArr, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            this.f = eArr;
            long c = c(j2, j3);
            E e = (E) e(eArr, c);
            if (e == null) {
                return null;
            }
            l(eArr, c, null);
            k(j2 + 1);
            return e;
        }
        return (E) invokeCommon.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    public final void j(E[] eArr, long j2, long j3, E e, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eArr, Long.valueOf(j2), Long.valueOf(j3), e, Long.valueOf(j4)}) == null) {
            E[] eArr2 = (E[]) new Object[eArr.length];
            this.d = eArr2;
            this.b = (j4 + j2) - 1;
            l(eArr2, j3, e);
            m(eArr, eArr2);
            l(eArr, j3, l);
            n(j2 + 1);
        }
    }

    public final void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            uy9.a.i(this, i, j2);
        }
    }

    public final void m(E[] eArr, E[] eArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eArr, eArr2) == null) {
            l(eArr, b(eArr.length - 1), eArr2);
        }
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            uy9.a.i(this, h, j2);
        }
    }

    public final boolean o(E[] eArr, E e, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{eArr, e, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            l(eArr, j3, e);
            n(j2 + 1);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e)) == null) {
            if (e != null) {
                E[] eArr = this.d;
                long j2 = this.producerIndex;
                long j3 = this.c;
                long c = c(j2, j3);
                if (j2 < this.b) {
                    return o(eArr, e, j2, c);
                }
                long j4 = this.a + j2;
                if (e(eArr, c(j4, j3)) == null) {
                    this.b = j4 - 1;
                    return o(eArr, e, j2, c);
                } else if (e(eArr, c(1 + j2, j3)) != null) {
                    return o(eArr, e, j2, c);
                } else {
                    j(eArr, j2, c, e, j3);
                    return true;
                }
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public final E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            E[] eArr = this.f;
            long j2 = this.consumerIndex;
            long j3 = this.e;
            E e = (E) e(eArr, c(j2, j3));
            return e == l ? h(f(eArr), j2, j3) : e;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public final E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            E[] eArr = this.f;
            long j2 = this.consumerIndex;
            long j3 = this.e;
            long c = c(j2, j3);
            E e = (E) e(eArr, c);
            boolean z = e == l;
            if (e == null || z) {
                if (z) {
                    return i(f(eArr), j2, j3);
                }
                return null;
            }
            l(eArr, c, null);
            k(j2 + 1);
            return e;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return invokeV.intValue;
        }
        long d = d();
        while (true) {
            long g2 = g();
            long d2 = d();
            if (d == d2) {
                return (int) (g2 - d2);
            }
            d = d2;
        }
    }
}
