package d.f.e.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final double f73866f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final double f73867a;

    /* renamed from: b  reason: collision with root package name */
    public final g f73868b;

    /* renamed from: c  reason: collision with root package name */
    public long f73869c;

    /* renamed from: d  reason: collision with root package name */
    public int f73870d;

    /* renamed from: e  reason: collision with root package name */
    public final g f73871e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1828934061, "Ld/f/e/a/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1828934061, "Ld/f/e/a/a/a/b;");
                return;
            }
        }
        f73866f = 1.0d / TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS);
    }

    public b(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73868b = new g();
        this.f73871e = new g();
        this.f73867a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73870d : invokeV.intValue;
    }

    public void b(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, j) == null) {
            c(gVar, j, 1.0d);
        }
    }

    public void c(g gVar, long j, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{gVar, Long.valueOf(j), Double.valueOf(d2)}) == null) {
            int i2 = this.f73870d + 1;
            this.f73870d = i2;
            if (i2 == 1) {
                this.f73868b.f(gVar);
            } else {
                double d3 = d2 * (j - this.f73869c) * f73866f;
                double d4 = d3 / (this.f73867a + d3);
                this.f73868b.c(1.0d - d4);
                this.f73871e.f(gVar);
                this.f73871e.c(d4);
                g gVar2 = this.f73871e;
                g gVar3 = this.f73868b;
                g.g(gVar2, gVar3, gVar3);
            }
            this.f73869c = j;
        }
    }

    public g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73868b : (g) invokeV.objValue;
    }
}
