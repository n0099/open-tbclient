package h.o.d.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class z<E> extends b0<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final int o;
    public static final Object p;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413047364, "Lh/o/d/j/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413047364, "Lh/o/d/j/z;");
                return;
            }
        }
        k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        p = new Object();
        int b2 = f0.f72119a.b(Object[].class);
        if (4 == b2) {
            o = 2;
        } else if (8 == b2) {
            o = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        n = f0.f72119a.a(Object[].class);
        try {
            l = f0.f72119a.g(e0.class.getDeclaredField("producerIndex"));
            try {
                m = f0.f72119a.g(b0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e2) {
                InternalError internalError = new InternalError();
                internalError.initCause(e2);
                throw internalError;
            }
        } catch (NoSuchFieldException e3) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e3);
            throw internalError2;
        }
    }

    public z(int i2) {
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
        int b2 = i.b(i2);
        long j = b2 - 1;
        E[] eArr = (E[]) new Object[b2 + 1];
        this.f72112h = eArr;
        this.f72111g = j;
        a(b2);
        this.j = eArr;
        this.f72107i = j;
        this.f72110f = j - 1;
        n(0L);
    }

    public static long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? n + (j << o) : invokeJ.longValue;
    }

    public static long c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? b(j & j2) : invokeCommon.longValue;
    }

    public static <E> Object e(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, eArr, j)) == null) ? f0.f72119a.f(eArr, j) : invokeLJ.objValue;
    }

    public static void l(Object[] objArr, long j, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{objArr, Long.valueOf(j), obj}) == null) {
            f0.f72119a.j(objArr, j, obj);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f72109e = Math.min(i2 / 4, k);
        }
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f0.f72119a.d(this, m) : invokeV.longValue;
    }

    public final E[] f(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eArr)) == null) ? (E[]) ((Object[]) e(eArr, b(eArr.length - 1))) : (E[]) ((Object[]) invokeL.objValue);
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f0.f72119a.d(this, l) : invokeV.longValue;
    }

    public final E h(E[] eArr, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{eArr, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.j = eArr;
            return (E) e(eArr, c(j, j2));
        }
        return (E) invokeCommon.objValue;
    }

    public final E i(E[] eArr, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eArr, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.j = eArr;
            long c2 = c(j, j2);
            E e2 = (E) e(eArr, c2);
            if (e2 == null) {
                return null;
            }
            l(eArr, c2, null);
            k(j + 1);
            return e2;
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

    public final void j(E[] eArr, long j, long j2, E e2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eArr, Long.valueOf(j), Long.valueOf(j2), e2, Long.valueOf(j3)}) == null) {
            E[] eArr2 = (E[]) new Object[eArr.length];
            this.f72112h = eArr2;
            this.f72110f = (j3 + j) - 1;
            l(eArr2, j2, e2);
            m(eArr, eArr2);
            l(eArr, j2, p);
            n(j + 1);
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            f0.f72119a.i(this, m, j);
        }
    }

    public final void m(E[] eArr, E[] eArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eArr, eArr2) == null) {
            l(eArr, b(eArr.length - 1), eArr2);
        }
    }

    public final void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            f0.f72119a.i(this, l, j);
        }
    }

    public final boolean o(E[] eArr, E e2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{eArr, e2, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            l(eArr, j2, e2);
            n(j + 1);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) {
            if (e2 != null) {
                E[] eArr = this.f72112h;
                long j = this.producerIndex;
                long j2 = this.f72111g;
                long c2 = c(j, j2);
                if (j < this.f72110f) {
                    return o(eArr, e2, j, c2);
                }
                long j3 = this.f72109e + j;
                if (e(eArr, c(j3, j2)) == null) {
                    this.f72110f = j3 - 1;
                    return o(eArr, e2, j, c2);
                } else if (e(eArr, c(1 + j, j2)) != null) {
                    return o(eArr, e2, j, c2);
                } else {
                    j(eArr, j, c2, e2, j2);
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
            E[] eArr = this.j;
            long j = this.consumerIndex;
            long j2 = this.f72107i;
            E e2 = (E) e(eArr, c(j, j2));
            return e2 == p ? h(f(eArr), j, j2) : e2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public final E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            E[] eArr = this.j;
            long j = this.consumerIndex;
            long j2 = this.f72107i;
            long c2 = c(j, j2);
            E e2 = (E) e(eArr, c2);
            boolean z = e2 == p;
            if (e2 == null || z) {
                if (z) {
                    return i(f(eArr), j, j2);
                }
                return null;
            }
            l(eArr, c2, null);
            k(j + 1);
            return e2;
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
        long d2 = d();
        while (true) {
            long g2 = g();
            long d3 = d();
            if (d2 == d3) {
                return (int) (g2 - d3);
            }
            d2 = d3;
        }
    }
}
