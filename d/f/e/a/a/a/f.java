package d.f.e.a.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1828934185, "Ld/f/e/a/a/a/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1828934185, "Ld/f/e/a/a/a/f;");
        }
    }

    public static void a(g gVar, double d2, double d3, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{gVar, Double.valueOf(d2), Double.valueOf(d3), cVar}) == null) {
            double d4 = gVar.f73891a;
            double d5 = d4 * d4;
            double d6 = gVar.f73892b;
            double d7 = d6 * d6;
            double d8 = gVar.f73893c;
            double d9 = d8 * d8;
            cVar.e(0, 0, 1.0d - ((d7 + d9) * d3));
            cVar.e(1, 1, 1.0d - ((d9 + d5) * d3));
            cVar.e(2, 2, 1.0d - ((d5 + d7) * d3));
            double d10 = gVar.f73893c * d2;
            double d11 = gVar.f73891a * gVar.f73892b * d3;
            cVar.e(0, 1, d11 - d10);
            cVar.e(1, 0, d11 + d10);
            double d12 = gVar.f73892b * d2;
            double d13 = gVar.f73891a * gVar.f73893c * d3;
            cVar.e(0, 2, d13 + d12);
            cVar.e(2, 0, d13 - d12);
            double d14 = gVar.f73891a * d2;
            double d15 = gVar.f73892b * gVar.f73893c * d3;
            cVar.e(1, 2, d15 - d14);
            cVar.e(2, 1, d15 + d14);
        }
    }

    public static void b(g gVar, c cVar) {
        double cos;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, gVar, cVar) == null) {
            double a2 = g.a(gVar, gVar);
            double sqrt = Math.sqrt(a2);
            double d4 = 0.5d;
            if (a2 < 1.0E-8d) {
                d3 = a2 * 0.1666666716337204d;
            } else if (a2 >= 1.0E-6d) {
                double d5 = 1.0d / sqrt;
                double sin = Math.sin(sqrt) * d5;
                cos = d5 * d5 * (1.0d - Math.cos(sqrt));
                d2 = sin;
                a(gVar, d2, cos, cVar);
            } else {
                d4 = 0.5d - (0.0416666679084301d * a2);
                double d6 = a2 * 0.1666666716337204d;
                d3 = d6 * (1.0d - d6);
            }
            d2 = 1.0d - d3;
            cos = d4;
            a(gVar, d2, cos, cVar);
        }
    }
}
