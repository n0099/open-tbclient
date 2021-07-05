package d.f.e.a.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public double[] f73872a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73872a = new double[9];
    }

    public static void h(c cVar, c cVar2, c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, cVar, cVar2, cVar3) == null) {
            double[] dArr = cVar3.f73872a;
            double[] dArr2 = cVar.f73872a;
            double d2 = dArr2[0];
            double[] dArr3 = cVar2.f73872a;
            dArr[0] = d2 + dArr3[0];
            dArr[1] = dArr2[1] + dArr3[1];
            dArr[2] = dArr2[2] + dArr3[2];
            dArr[3] = dArr2[3] + dArr3[3];
            dArr[4] = dArr2[4] + dArr3[4];
            dArr[5] = dArr2[5] + dArr3[5];
            dArr[6] = dArr2[6] + dArr3[6];
            dArr[7] = dArr2[7] + dArr3[7];
            dArr[8] = dArr2[8] + dArr3[8];
        }
    }

    public static void i(c cVar, g gVar, g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, cVar, gVar, gVar2) == null) {
            double[] dArr = cVar.f73872a;
            double d2 = dArr[0];
            double d3 = gVar.f73891a;
            double d4 = dArr[1];
            double d5 = gVar.f73892b;
            double d6 = (d2 * d3) + (d4 * d5);
            double d7 = dArr[2];
            double d8 = gVar.f73893c;
            double d9 = d6 + (d7 * d8);
            double d10 = (dArr[3] * d3) + (dArr[4] * d5) + (dArr[5] * d8);
            gVar2.f73891a = d9;
            gVar2.f73892b = d10;
            gVar2.f73893c = (dArr[6] * d3) + (dArr[7] * d5) + (dArr[8] * d8);
        }
    }

    public static void m(c cVar, c cVar2, c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, cVar, cVar2, cVar3) == null) {
            double[] dArr = cVar.f73872a;
            double d2 = dArr[0];
            double[] dArr2 = cVar2.f73872a;
            cVar3.d((d2 * dArr2[0]) + (dArr[1] * dArr2[3]) + (dArr[2] * dArr2[6]), (dArr[0] * dArr2[1]) + (dArr[1] * dArr2[4]) + (dArr[2] * dArr2[7]), (dArr[0] * dArr2[2]) + (dArr[1] * dArr2[5]) + (dArr[2] * dArr2[8]), (dArr[3] * dArr2[0]) + (dArr[4] * dArr2[3]) + (dArr[5] * dArr2[6]), (dArr[3] * dArr2[1]) + (dArr[4] * dArr2[4]) + (dArr[5] * dArr2[7]), (dArr[3] * dArr2[2]) + (dArr[4] * dArr2[5]) + (dArr[5] * dArr2[8]), (dArr[6] * dArr2[0]) + (dArr[7] * dArr2[3]) + (dArr[8] * dArr2[6]), (dArr[6] * dArr2[1]) + (dArr[7] * dArr2[4]) + (dArr[8] * dArr2[7]), (dArr[6] * dArr2[2]) + (dArr[7] * dArr2[5]) + (dArr[8] * dArr2[8]));
        }
    }

    public double a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? this.f73872a[(i2 * 3) + i3] : invokeII.doubleValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            double[] dArr = this.f73872a;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
            dArr[3] = 0.0d;
            dArr[4] = 0.0d;
            dArr[5] = 0.0d;
            dArr[6] = 0.0d;
            dArr[7] = 0.0d;
            dArr[8] = 0.0d;
        }
    }

    public void c(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) {
            double[] dArr = this.f73872a;
            dArr[0] = d2;
            dArr[4] = d2;
            dArr[8] = d2;
        }
    }

    public void d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)}) == null) {
            double[] dArr = this.f73872a;
            dArr[0] = d2;
            dArr[1] = d3;
            dArr[2] = d4;
            dArr[3] = d5;
            dArr[4] = d6;
            dArr[5] = d7;
            dArr[6] = d8;
            dArr[7] = d9;
            dArr[8] = d10;
        }
    }

    public void e(int i2, int i3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)}) == null) {
            this.f73872a[(i2 * 3) + i3] = d2;
        }
    }

    public void f(int i2, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, gVar) == null) {
            double[] dArr = this.f73872a;
            dArr[i2] = gVar.f73891a;
            dArr[i2 + 3] = gVar.f73892b;
            dArr[i2 + 6] = gVar.f73893c;
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            double[] dArr = this.f73872a;
            double[] dArr2 = cVar.f73872a;
            dArr[0] = dArr2[0];
            dArr[1] = dArr2[1];
            dArr[2] = dArr2[2];
            dArr[3] = dArr2[3];
            dArr[4] = dArr2[4];
            dArr[5] = dArr2[5];
            dArr[6] = dArr2[6];
            dArr[7] = dArr2[7];
            dArr[8] = dArr2[8];
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            double[] dArr = this.f73872a;
            dArr[0] = 1.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
            dArr[3] = 0.0d;
            dArr[4] = 1.0d;
            dArr[5] = 0.0d;
            dArr[6] = 0.0d;
            dArr[7] = 0.0d;
            dArr[8] = 1.0d;
        }
    }

    public void k(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                double[] dArr = this.f73872a;
                dArr[i2] = dArr[i2] * d2;
            }
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                double[] dArr = this.f73872a;
                dArr[i2] = dArr[i2] + cVar.f73872a[i2];
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            double[] dArr = this.f73872a;
            double d2 = dArr[1];
            dArr[1] = dArr[3];
            dArr[3] = d2;
            double d3 = dArr[2];
            dArr[2] = dArr[6];
            dArr[6] = d3;
            double d4 = dArr[5];
            dArr[5] = dArr[7];
            dArr[7] = d4;
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            for (int i2 = 0; i2 < 9; i2++) {
                double[] dArr = this.f73872a;
                dArr[i2] = dArr[i2] - cVar.f73872a[i2];
            }
        }
    }

    public double p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ((a(0, 0) * ((a(1, 1) * a(2, 2)) - (a(2, 1) * a(1, 2)))) - (a(0, 1) * ((a(1, 0) * a(2, 2)) - (a(1, 2) * a(2, 0))))) + (a(0, 2) * ((a(1, 0) * a(2, 1)) - (a(1, 1) * a(2, 0)))) : invokeV.doubleValue;
    }

    public void q(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            double[] dArr = this.f73872a;
            double d2 = dArr[1];
            double d3 = dArr[2];
            double d4 = dArr[5];
            double[] dArr2 = cVar.f73872a;
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[3];
            dArr2[2] = dArr[6];
            dArr2[3] = d2;
            dArr2[4] = dArr[4];
            dArr2[5] = dArr[7];
            dArr2[6] = d3;
            dArr2[7] = d4;
            dArr2[8] = dArr[8];
        }
    }

    public boolean r(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            double p = p();
            if (p == 0.0d) {
                return false;
            }
            double d2 = 1.0d / p;
            double[] dArr = this.f73872a;
            cVar.d(((dArr[4] * dArr[8]) - (dArr[7] * dArr[5])) * d2, (-((dArr[1] * dArr[8]) - (dArr[2] * dArr[7]))) * d2, ((dArr[1] * dArr[5]) - (dArr[2] * dArr[4])) * d2, (-((dArr[3] * dArr[8]) - (dArr[5] * dArr[6]))) * d2, ((dArr[0] * dArr[8]) - (dArr[2] * dArr[6])) * d2, (-((dArr[0] * dArr[5]) - (dArr[3] * dArr[2]))) * d2, ((dArr[3] * dArr[7]) - (dArr[6] * dArr[4])) * d2, (-((dArr[0] * dArr[7]) - (dArr[6] * dArr[1]))) * d2, ((dArr[0] * dArr[4]) - (dArr[3] * dArr[1])) * d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{ ");
            for (int i2 = 0; i2 < 9; i2++) {
                sb.append(Double.toString(this.f73872a[i2]));
                if (i2 < 8) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(" }");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
