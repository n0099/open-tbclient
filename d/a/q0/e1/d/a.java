package d.a.q0.e1.d;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f55769f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f55770a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f55771b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f55772c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f55773d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f55774e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621850979, "Ld/a/q0/e1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-621850979, "Ld/a/q0/e1/d/a;");
                return;
            }
        }
        f55769f = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55770a = 0L;
        this.f55771b = new SparseArray<>();
        this.f55772c = new SparseArray<>();
        this.f55773d = new SparseArray<>();
        this.f55774e = new SparseArray<>();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f55769f : (a) invokeV.objValue;
    }

    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Long l = this.f55772c.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55770a : invokeV.longValue;
    }

    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Long l = this.f55771b.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Long l = this.f55774e.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Long l = this.f55773d.get(i2);
            if (l == null) {
                return -1L;
            }
            return l.longValue();
        }
        return invokeI.longValue;
    }

    public void g(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f55772c.put(i2, Long.valueOf(j));
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f55770a = j;
        }
    }

    public void i(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f55771b.put(i2, Long.valueOf(j));
        }
    }

    public void j(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f55774e.put(i2, Long.valueOf(j));
        }
    }

    public void k(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f55773d.put(i2, Long.valueOf(j));
        }
    }
}
