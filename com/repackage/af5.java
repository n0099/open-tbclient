package com.repackage;

import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class af5 {
    public static /* synthetic */ Interceptable $ic;
    public static final float J;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public TbImageView.h I;
    public float a;
    public float b;
    public int c;
    public int d;
    public float e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public ImageView.ScaleType p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755858687, "Lcom/repackage/af5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755858687, "Lcom/repackage/af5;");
                return;
            }
        }
        J = oi.h(TbadkCoreApplication.getInst());
    }

    public af5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0;
        this.d = 0;
        this.e = 15.0f;
        this.f = false;
        this.g = -1;
        this.h = -1;
        this.i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.u = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.v = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.x = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.y = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.z = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.A = 0;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = 0;
        this.F = false;
    }

    public void a(af5 af5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, af5Var) == null) {
            this.a = af5Var.a;
            this.b = af5Var.b;
            this.c = af5Var.c;
            this.d = af5Var.d;
            this.e = af5Var.e;
            this.g = af5Var.g;
            this.h = af5Var.h;
            this.i = af5Var.i;
            this.j = af5Var.j;
            this.k = af5Var.k;
            this.l = af5Var.l;
            this.m = af5Var.m;
            this.n = af5Var.n;
            this.r = af5Var.r;
            this.o = af5Var.o;
            this.q = af5Var.q;
            this.s = af5Var.s;
            this.t = af5Var.t;
            this.u = af5Var.u;
            this.z = af5Var.z;
            this.A = af5Var.A;
            this.B = af5Var.B;
            this.C = af5Var.d;
            this.D = af5Var.D;
            this.w = af5Var.w;
            this.x = af5Var.x;
            this.y = af5Var.y;
            this.F = af5Var.F;
        }
    }

    public void b(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typedArray) == null) {
            this.d = typedArray.getDimensionPixelSize(6, 0);
            this.c = typedArray.getDimensionPixelSize(10, 0);
            this.a = typedArray.getFloat(8, 1.12f);
            this.e = typedArray.getDimensionPixelSize(11, (int) this.e);
            this.i = typedArray.getColor(9, this.i);
            this.j = typedArray.getDimensionPixelSize(5, this.j);
            this.k = typedArray.getDimensionPixelSize(4, this.k);
            this.l = typedArray.getResourceId(0, 0);
            this.g = typedArray.getDimensionPixelSize(2, this.g);
            this.h = typedArray.getDimensionPixelSize(1, this.h);
            this.m = typedArray.getResourceId(12, 0);
            this.n = typedArray.getBoolean(7, false);
            this.C = this.d;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public int[] e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i, i2, i3, i4)) == null) {
            int[] l = oi.l(i, i2, i3, i4);
            if (l == null) {
                return null;
            }
            int[] iArr = {l[0], l[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (this.s && i3 > i5) {
                float f = J;
                if (f > 1.0f) {
                    float f2 = i5;
                    float f3 = i3;
                    if (f2 * f <= f3) {
                        float f4 = f3 * 0.68f;
                        i3 = f2 * f > f4 ? (int) f4 : (int) (f2 * f);
                    }
                    if (iArr[0] > 0) {
                        i6 = (iArr[1] * i3) / iArr[0];
                    }
                    i5 = i3;
                }
            }
            return new int[]{i5, i6};
        }
        return (int[]) invokeIIII.objValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.v = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.l = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.E = i;
        }
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.g = i;
            this.h = i2;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.D = i;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.B = i;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.C = i;
        }
    }

    public void n(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            this.a = f;
        }
    }

    public void o(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.a = f2;
            this.b = f;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.k = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void r(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            this.t = i;
            this.u = i2;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.d = i;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.q = true;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.z = i;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.e = i;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.F = z;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.m = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.A = i;
        }
    }

    public af5(af5 af5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af5Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0;
        this.d = 0;
        this.e = 15.0f;
        this.f = false;
        this.g = -1;
        this.h = -1;
        this.i = -16777216;
        this.j = 200;
        this.k = 200;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = -9989158;
        this.p = ImageView.ScaleType.CENTER_CROP;
        this.q = false;
        this.t = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.u = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.v = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.w = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.x = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.y = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.z = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.A = 0;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = 0;
        this.F = false;
        if (af5Var != null) {
            a(af5Var);
        }
    }
}
