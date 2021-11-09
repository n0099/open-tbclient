package h.o.d.j;

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
/* loaded from: classes3.dex */
public abstract class f<E> extends g<E> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f72114g;

    /* renamed from: h  reason: collision with root package name */
    public static final long f72115h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f72116i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f72117e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f72118f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413046744, "Lh/o/d/j/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413046744, "Lh/o/d/j/f;");
                return;
            }
        }
        f72114g = Integer.getInteger("sparse.shift", 0).intValue();
        int b2 = f0.f72119a.b(Object[].class);
        if (4 == b2) {
            f72116i = f72114g + 2;
        } else if (8 == b2) {
            f72116i = f72114g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f72115h = f0.f72119a.a(Object[].class) + (32 << (f72116i - f72114g));
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
        int b2 = i.b(i2);
        this.f72117e = b2 - 1;
        this.f72118f = (E[]) new Object[(b2 << f72114g) + 64];
    }

    public final long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? b(j, this.f72117e) : invokeJ.longValue;
    }

    public final long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? f72115h + ((j & j2) << f72116i) : invokeCommon.longValue;
    }

    public final E c(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eArr, j)) == null) ? (E) f0.f72119a.e(eArr, j) : (E) invokeLJ.objValue;
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? e(this.f72118f, j) : (E) invokeJ.objValue;
    }

    public final E e(E[] eArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, eArr, j)) == null) ? (E) f0.f72119a.f(eArr, j) : (E) invokeLJ.objValue;
    }

    public final void f(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            f0.f72119a.j(eArr, j, e2);
        }
    }

    public final void g(E[] eArr, long j, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{eArr, Long.valueOf(j), e2}) == null) {
            f0.f72119a.h(eArr, j, e2);
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
