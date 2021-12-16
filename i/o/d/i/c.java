package i.o.d.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes4.dex */
public final class c<E> extends a<E> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final Integer f64458k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f64459g;

    /* renamed from: h  reason: collision with root package name */
    public long f64460h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f64461i;

    /* renamed from: j  reason: collision with root package name */
    public final int f64462j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(216503355, "Li/o/d/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(216503355, "Li/o/d/i/c;");
                return;
            }
        }
        f64458k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64459g = new AtomicLong();
        this.f64461i = new AtomicLong();
        this.f64462j = Math.min(i2 / 4, f64458k.intValue());
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64461i.get() : invokeV.longValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64459g.get() : invokeV.longValue;
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f64461i.lazySet(j2);
        }
    }

    public final void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f64459g.lazySet(j2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g() == f() : invokeV.booleanValue;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e2)) == null) {
            if (e2 != null) {
                AtomicReferenceArray<E> atomicReferenceArray = this.f64454e;
                int i2 = this.f64455f;
                long j2 = this.f64459g.get();
                int b2 = b(j2, i2);
                if (j2 >= this.f64460h) {
                    long j3 = this.f64462j + j2;
                    if (d(atomicReferenceArray, b(j3, i2)) == null) {
                        this.f64460h = j3;
                    } else if (d(atomicReferenceArray, b2) != null) {
                        return false;
                    }
                }
                e(atomicReferenceArray, b2, e2);
                i(j2 + 1);
                return true;
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c(a(this.f64461i.get())) : (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j2 = this.f64461i.get();
            int a = a(j2);
            AtomicReferenceArray<E> atomicReferenceArray = this.f64454e;
            E d2 = d(atomicReferenceArray, a);
            if (d2 == null) {
                return null;
            }
            e(atomicReferenceArray, a, null);
            h(j2 + 1);
            return d2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return invokeV.intValue;
        }
        long f2 = f();
        while (true) {
            long g2 = g();
            long f3 = f();
            if (f2 == f3) {
                return (int) (g2 - f3);
            }
            f2 = f3;
        }
    }
}
