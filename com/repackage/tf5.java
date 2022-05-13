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
/* loaded from: classes7.dex */
public class tf5 {
    public static /* synthetic */ Interceptable $ic;
    public static final float K;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public TbImageView.h J;
    public float a;
    public boolean b;
    public float c;
    public int d;
    public int e;
    public float f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public ImageView.ScaleType q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755292658, "Lcom/repackage/tf5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755292658, "Lcom/repackage/tf5;");
                return;
            }
        }
        K = mi.h(TbadkCoreApplication.getInst());
    }

    public tf5() {
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
        this.b = true;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        this.f = 15.0f;
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.j = -16777216;
        this.k = 200;
        this.l = 200;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = -9989158;
        this.q = ImageView.ScaleType.CENTER_CROP;
        this.r = false;
        this.u = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.v = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.w = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.x = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.y = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.z = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.A = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.B = 0;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = 0;
        this.G = false;
    }

    public void a(tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tf5Var) == null) {
            this.a = tf5Var.a;
            this.c = tf5Var.c;
            this.d = tf5Var.d;
            this.e = tf5Var.e;
            this.f = tf5Var.f;
            this.h = tf5Var.h;
            this.i = tf5Var.i;
            this.j = tf5Var.j;
            this.k = tf5Var.k;
            this.l = tf5Var.l;
            this.m = tf5Var.m;
            this.n = tf5Var.n;
            this.o = tf5Var.o;
            this.s = tf5Var.s;
            this.p = tf5Var.p;
            this.r = tf5Var.r;
            this.t = tf5Var.t;
            this.u = tf5Var.u;
            this.v = tf5Var.v;
            this.A = tf5Var.A;
            this.B = tf5Var.B;
            this.C = tf5Var.C;
            this.D = tf5Var.e;
            this.E = tf5Var.E;
            this.x = tf5Var.x;
            this.y = tf5Var.y;
            this.z = tf5Var.z;
            this.G = tf5Var.G;
        }
    }

    public void b(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typedArray) == null) {
            this.e = typedArray.getDimensionPixelSize(7, 0);
            this.b = typedArray.getBoolean(3, true);
            this.d = typedArray.getDimensionPixelSize(11, 0);
            this.a = typedArray.getFloat(9, 1.12f);
            this.f = typedArray.getDimensionPixelSize(12, (int) this.f);
            this.j = typedArray.getColor(10, this.j);
            this.k = typedArray.getDimensionPixelSize(6, this.k);
            this.l = typedArray.getDimensionPixelSize(5, this.l);
            this.m = typedArray.getResourceId(0, 0);
            this.h = typedArray.getDimensionPixelSize(2, this.h);
            this.i = typedArray.getDimensionPixelSize(1, this.i);
            this.n = typedArray.getResourceId(13, 0);
            this.o = typedArray.getBoolean(8, false);
            this.D = this.e;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.G : invokeV.booleanValue;
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
            int[] l = mi.l(i, i2, i3, i4);
            if (l == null) {
                return null;
            }
            int[] iArr = {l[0], l[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (this.t && i3 > i5) {
                float f = K;
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
            this.w = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.F = i;
        }
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.h = i;
            this.i = i2;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.E = i;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.t = z;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.C = i;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.D = i;
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
            this.c = f;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.l = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.k = i;
        }
    }

    public void r(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            this.u = i;
            this.v = i2;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.r = true;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.A = i;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.f = i;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.G = z;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.n = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.B = i;
        }
    }

    public tf5(tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf5Var};
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
        this.b = true;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        this.f = 15.0f;
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.j = -16777216;
        this.k = 200;
        this.l = 200;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = -9989158;
        this.q = ImageView.ScaleType.CENTER_CROP;
        this.r = false;
        this.u = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701be);
        this.v = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.w = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        this.x = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004);
        this.y = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        this.z = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X006);
        this.A = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.B = 0;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = 0;
        this.G = false;
        if (tf5Var != null) {
            a(tf5Var);
        }
    }
}
