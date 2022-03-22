package g.o.d.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.o.d.j.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class f<T> implements Queue<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicLong a;

    /* renamed from: b  reason: collision with root package name */
    public int f45016b;

    /* renamed from: c  reason: collision with root package name */
    public long f45017c;

    /* renamed from: d  reason: collision with root package name */
    public int f45018d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReferenceArray<Object> f45019e;

    /* renamed from: f  reason: collision with root package name */
    public int f45020f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicReferenceArray<Object> f45021g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicLong f45022h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(609530458, "Lg/o/d/i/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(609530458, "Lg/o/d/i/f;");
                return;
            }
        }
        i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        j = new Object();
    }

    public f(int i2) {
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
        int b2 = i.b(Math.max(8, i2));
        int i5 = b2 - 1;
        this.a = new AtomicLong();
        this.f45022h = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b2 + 1);
        this.f45019e = atomicReferenceArray;
        this.f45018d = i5;
        a(b2);
        this.f45021g = atomicReferenceArray;
        this.f45020f = i5;
        this.f45017c = i5 - 1;
        p(0L);
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 : invokeI.intValue;
    }

    public static int c(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            int i3 = ((int) j2) & i2;
            b(i3);
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReferenceArray, i2)) == null) ? atomicReferenceArray.get(i2) : invokeLI.objValue;
    }

    public static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, atomicReferenceArray, i2, obj) == null) {
            atomicReferenceArray.lazySet(i2, obj);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f45016b = Math.min(i2 / 4, i);
        }
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
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

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45022h.get() : invokeV.longValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.get() : invokeV.longValue;
    }

    @Override // java.util.Queue
    public T element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f45022h.get() : invokeV.longValue;
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, atomicReferenceArray)) == null) {
            int length = atomicReferenceArray.length() - 1;
            b(length);
            return (AtomicReferenceArray) g(atomicReferenceArray, length);
        }
        return (AtomicReferenceArray) invokeL.objValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.get() : invokeV.longValue;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i() == f() : invokeV.booleanValue;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            this.f45021g = atomicReferenceArray;
            return (T) g(atomicReferenceArray, c(j2, i2));
        }
        return (T) invokeCommon.objValue;
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            this.f45021g = atomicReferenceArray;
            int c2 = c(j2, i2);
            T t = (T) g(atomicReferenceArray, c2);
            if (t == null) {
                return null;
            }
            m(j2 + 1);
            n(atomicReferenceArray, c2, null);
            return t;
        }
        return (T) invokeCommon.objValue;
    }

    public final void l(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{atomicReferenceArray, Long.valueOf(j2), Integer.valueOf(i2), t, Long.valueOf(j3)}) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.f45019e = atomicReferenceArray2;
            this.f45017c = (j3 + j2) - 1;
            p(j2 + 1);
            n(atomicReferenceArray2, i2, t);
            o(atomicReferenceArray, atomicReferenceArray2);
            n(atomicReferenceArray, i2, j);
        }
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            this.f45022h.lazySet(j2);
        }
    }

    public final void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, atomicReferenceArray, atomicReferenceArray2) == null) {
            int length = atomicReferenceArray.length() - 1;
            b(length);
            n(atomicReferenceArray, length, atomicReferenceArray2);
        }
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, t)) == null) {
            if (t != null) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f45019e;
                long e2 = e();
                int i2 = this.f45018d;
                int c2 = c(e2, i2);
                if (e2 < this.f45017c) {
                    return q(atomicReferenceArray, t, e2, c2);
                }
                long j2 = this.f45016b + e2;
                if (g(atomicReferenceArray, c(j2, i2)) == null) {
                    this.f45017c = j2 - 1;
                    return q(atomicReferenceArray, t, e2, c2);
                } else if (g(atomicReferenceArray, c(1 + e2, i2)) != null) {
                    return q(atomicReferenceArray, t, e2, c2);
                } else {
                    l(atomicReferenceArray, e2, c2, t, i2);
                    return true;
                }
            }
            throw null;
        }
        return invokeL.booleanValue;
    }

    public final void p(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.a.lazySet(j2);
        }
    }

    @Override // java.util.Queue
    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f45021g;
            long d2 = d();
            int i2 = this.f45020f;
            T t = (T) g(atomicReferenceArray, c(d2, i2));
            return t == j ? j(h(atomicReferenceArray), d2, i2) : t;
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f45021g;
            long d2 = d();
            int i2 = this.f45020f;
            int c2 = c(d2, i2);
            T t = (T) g(atomicReferenceArray, c2);
            boolean z = t == j;
            if (t == null || z) {
                if (z) {
                    return k(h(atomicReferenceArray), d2, i2);
                }
                return null;
            }
            m(d2 + 1);
            n(atomicReferenceArray, c2, null);
            return t;
        }
        return (T) invokeV.objValue;
    }

    public final boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{atomicReferenceArray, t, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            p(j2 + 1);
            n(atomicReferenceArray, i2, t);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048604, this)) != null) {
            return invokeV.intValue;
        }
        long f2 = f();
        while (true) {
            long i2 = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i2 - f3);
            }
            f2 = f3;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, eArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E[]) ((Object[]) invokeL.objValue);
    }
}
