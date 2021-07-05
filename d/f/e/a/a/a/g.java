package d.f.e.a.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public double f73891a;

    /* renamed from: b  reason: collision with root package name */
    public double f73892b;

    /* renamed from: c  reason: collision with root package name */
    public double f73893c;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static double a(g gVar, g gVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gVar, gVar2)) == null) ? (gVar.f73891a * gVar2.f73891a) + (gVar.f73892b * gVar2.f73892b) + (gVar.f73893c * gVar2.f73893c) : invokeLL.doubleValue;
    }

    public static void g(g gVar, g gVar2, g gVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, gVar, gVar2, gVar3) == null) {
            gVar3.d(gVar.f73891a + gVar2.f73891a, gVar.f73892b + gVar2.f73892b, gVar.f73893c + gVar2.f73893c);
        }
    }

    public static int h(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gVar)) == null) {
            double abs = Math.abs(gVar.f73891a);
            double abs2 = Math.abs(gVar.f73892b);
            double abs3 = Math.abs(gVar.f73893c);
            return abs > abs2 ? abs > abs3 ? 0 : 2 : abs2 > abs3 ? 1 : 2;
        }
        return invokeL.intValue;
    }

    public static void j(g gVar, g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, gVar, gVar2) == null) {
            int h2 = h(gVar) - 1;
            if (h2 < 0) {
                h2 = 2;
            }
            gVar2.b();
            gVar2.e(h2, 1.0d);
            m(gVar, gVar2, gVar2);
            gVar2.i();
        }
    }

    public static void k(g gVar, g gVar2, g gVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, gVar, gVar2, gVar3) == null) {
            gVar3.d(gVar.f73891a - gVar2.f73891a, gVar.f73892b - gVar2.f73892b, gVar.f73893c - gVar2.f73893c);
        }
    }

    public static void m(g gVar, g gVar2, g gVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, gVar, gVar2, gVar3) == null) {
            double d2 = gVar.f73892b;
            double d3 = gVar2.f73893c;
            double d4 = gVar.f73893c;
            double d5 = gVar2.f73892b;
            double d6 = gVar2.f73891a;
            double d7 = gVar.f73891a;
            gVar3.d((d2 * d3) - (d4 * d5), (d4 * d6) - (d3 * d7), (d7 * d5) - (d2 * d6));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f73893c = 0.0d;
            this.f73892b = 0.0d;
            this.f73891a = 0.0d;
        }
    }

    public void c(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f73891a *= d2;
            this.f73892b *= d2;
            this.f73893c *= d2;
        }
    }

    public void d(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) {
            this.f73891a = d2;
            this.f73892b = d3;
            this.f73893c = d4;
        }
    }

    public void e(int i2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
            if (i2 == 0) {
                this.f73891a = d2;
            } else if (i2 == 1) {
                this.f73892b = d2;
            } else {
                this.f73893c = d2;
            }
        }
    }

    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.f73891a = gVar.f73891a;
            this.f73892b = gVar.f73892b;
            this.f73893c = gVar.f73893c;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            double l = l();
            if (l != 0.0d) {
                c(1.0d / l);
            }
        }
    }

    public double l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            double d2 = this.f73891a;
            double d3 = this.f73892b;
            double d4 = (d2 * d2) + (d3 * d3);
            double d5 = this.f73893c;
            return Math.sqrt(d4 + (d5 * d5));
        }
        return invokeV.doubleValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "{ " + Double.toString(this.f73891a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f73892b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + Double.toString(this.f73893c) + " }";
        }
        return (String) invokeV.objValue;
    }
}
