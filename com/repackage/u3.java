package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float[] q;
    public int r;
    public final i3 s;
    public float t;
    public float u;
    public float v;
    public float w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964027545, "Lcom/repackage/u3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964027545, "Lcom/repackage/u3;");
            }
        }
    }

    public u3(a4 a4Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {a4Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new i3(i3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (a4Var != null) {
            int c = (a4Var.c() - i) - i2;
            int b = (a4Var.b() - i3) - i4;
            a4[] a4VarArr = new a4[9];
            if (i3 > 0) {
                if (i > 0) {
                    a4VarArr[0] = new a4(a4Var, 0, 0, i, i3);
                }
                if (c > 0) {
                    a4VarArr[1] = new a4(a4Var, i, 0, c, i3);
                }
                if (i2 > 0) {
                    a4VarArr[2] = new a4(a4Var, i + c, 0, i2, i3);
                }
            }
            if (b > 0) {
                if (i > 0) {
                    a4VarArr[3] = new a4(a4Var, 0, i3, i, b);
                }
                if (c > 0) {
                    a4VarArr[4] = new a4(a4Var, i, i3, c, b);
                }
                if (i2 > 0) {
                    a4VarArr[5] = new a4(a4Var, i + c, i3, i2, b);
                }
            }
            if (i4 > 0) {
                if (i > 0) {
                    a4VarArr[6] = new a4(a4Var, 0, i3 + b, i, i4);
                }
                if (c > 0) {
                    a4VarArr[7] = new a4(a4Var, i, i3 + b, c, i4);
                }
                if (i2 > 0) {
                    a4VarArr[8] = new a4(a4Var, i + c, i3 + b, i2, i4);
                }
            }
            if (i == 0 && c == 0) {
                a4VarArr[1] = a4VarArr[2];
                a4VarArr[4] = a4VarArr[5];
                a4VarArr[7] = a4VarArr[8];
                a4VarArr[2] = null;
                a4VarArr[5] = null;
                a4VarArr[8] = null;
            }
            if (i3 == 0 && b == 0) {
                a4VarArr[3] = a4VarArr[6];
                a4VarArr[4] = a4VarArr[7];
                a4VarArr[5] = a4VarArr[8];
                a4VarArr[6] = null;
                a4VarArr[7] = null;
                a4VarArr[8] = null;
            }
            l(a4VarArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public final int a(a4 a4Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{a4Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Texture texture = this.a;
            if (texture == null) {
                this.a = a4Var.f();
            } else if (texture != a4Var.f()) {
                throw new IllegalArgumentException("All regions must be from the same texture.");
            }
            float f = a4Var.b;
            float f2 = a4Var.e;
            float f3 = a4Var.d;
            float f4 = a4Var.c;
            if (this.a.f() == Texture.TextureFilter.Linear || this.a.h() == Texture.TextureFilter.Linear) {
                if (z) {
                    float x = 0.5f / this.a.x();
                    f += x;
                    f3 -= x;
                }
                if (z2) {
                    float u = 0.5f / this.a.u();
                    f2 -= u;
                    f4 += u;
                }
            }
            float[] fArr = this.q;
            int i = this.r;
            fArr[i + 3] = f;
            fArr[i + 4] = f2;
            fArr[i + 8] = f;
            fArr[i + 9] = f4;
            fArr[i + 13] = f3;
            fArr[i + 14] = f4;
            fArr[i + 18] = f3;
            fArr[i + 19] = f2;
            this.r = i + 20;
            return i;
        }
        return invokeCommon.intValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.w;
            return f == -1.0f ? b() : f;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.t;
            return f == -1.0f ? c() : f;
        }
        return invokeV.floatValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f = this.u;
            return f == -1.0f ? h() : f;
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.v;
            return f == -1.0f ? i() : f;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o + this.n + this.p : invokeV.floatValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k + this.m + this.l : invokeV.floatValue;
    }

    public final void l(a4[] a4VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, a4VarArr) == null) {
            if (a4VarArr[6] != null) {
                this.b = a(a4VarArr[6], false, false);
                this.k = a4VarArr[6].c();
                this.p = a4VarArr[6].b();
            } else {
                this.b = -1;
            }
            if (a4VarArr[7] != null) {
                this.c = a(a4VarArr[7], (a4VarArr[6] == null && a4VarArr[8] == null) ? false : true, false);
                this.m = Math.max(this.m, a4VarArr[7].c());
                this.p = Math.max(this.p, a4VarArr[7].b());
            } else {
                this.c = -1;
            }
            if (a4VarArr[8] != null) {
                this.d = a(a4VarArr[8], false, false);
                this.l = Math.max(this.l, a4VarArr[8].c());
                this.p = Math.max(this.p, a4VarArr[8].b());
            } else {
                this.d = -1;
            }
            if (a4VarArr[3] != null) {
                this.e = a(a4VarArr[3], false, (a4VarArr[0] == null && a4VarArr[6] == null) ? false : true);
                this.k = Math.max(this.k, a4VarArr[3].c());
                this.n = Math.max(this.n, a4VarArr[3].b());
            } else {
                this.e = -1;
            }
            if (a4VarArr[4] != null) {
                this.f = a(a4VarArr[4], (a4VarArr[3] == null && a4VarArr[5] == null) ? false : true, (a4VarArr[1] == null && a4VarArr[7] == null) ? false : true);
                this.m = Math.max(this.m, a4VarArr[4].c());
                this.n = Math.max(this.n, a4VarArr[4].b());
            } else {
                this.f = -1;
            }
            if (a4VarArr[5] != null) {
                this.g = a(a4VarArr[5], false, (a4VarArr[2] == null && a4VarArr[8] == null) ? false : true);
                this.l = Math.max(this.l, a4VarArr[5].c());
                this.n = Math.max(this.n, a4VarArr[5].b());
            } else {
                this.g = -1;
            }
            if (a4VarArr[0] != null) {
                this.h = a(a4VarArr[0], false, false);
                this.k = Math.max(this.k, a4VarArr[0].c());
                this.o = Math.max(this.o, a4VarArr[0].b());
            } else {
                this.h = -1;
            }
            if (a4VarArr[1] != null) {
                this.i = a(a4VarArr[1], (a4VarArr[0] == null && a4VarArr[2] == null) ? false : true, false);
                this.m = Math.max(this.m, a4VarArr[1].c());
                this.o = Math.max(this.o, a4VarArr[1].b());
            } else {
                this.i = -1;
            }
            if (a4VarArr[2] != null) {
                this.j = a(a4VarArr[2], false, false);
                this.l = Math.max(this.l, a4VarArr[2].c());
                this.o = Math.max(this.o, a4VarArr[2].b());
            } else {
                this.j = -1;
            }
            int i = this.r;
            float[] fArr = this.q;
            if (i < fArr.length) {
                float[] fArr2 = new float[i];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                this.q = fArr2;
            }
        }
    }

    public void m(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k *= f;
            this.l *= f;
            this.o *= f2;
            this.p *= f2;
            this.m *= f;
            this.n *= f2;
            float f3 = this.t;
            if (f3 != -1.0f) {
                this.t = f3 * f;
            }
            float f4 = this.u;
            if (f4 != -1.0f) {
                this.u = f4 * f;
            }
            float f5 = this.v;
            if (f5 != -1.0f) {
                this.v = f5 * f2;
            }
            float f6 = this.w;
            if (f6 != -1.0f) {
                this.w = f6 * f2;
            }
        }
    }

    public void n(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.t = f;
            this.u = f2;
            this.v = f3;
            this.w = f4;
        }
    }

    public u3(a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new i3(i3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        l(new a4[]{null, null, null, null, a4Var, null, null, null, null});
    }

    public u3(u3 u3Var, i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u3Var, i3Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new i3(i3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = u3Var.a;
        this.b = u3Var.b;
        this.c = u3Var.c;
        this.d = u3Var.d;
        this.e = u3Var.e;
        this.f = u3Var.f;
        this.g = u3Var.g;
        this.h = u3Var.h;
        this.i = u3Var.i;
        this.j = u3Var.j;
        this.k = u3Var.k;
        this.l = u3Var.l;
        this.m = u3Var.m;
        this.n = u3Var.n;
        this.o = u3Var.o;
        this.p = u3Var.p;
        this.t = u3Var.t;
        this.v = u3Var.v;
        this.w = u3Var.w;
        this.u = u3Var.u;
        float[] fArr = new float[u3Var.q.length];
        this.q = fArr;
        float[] fArr2 = u3Var.q;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = u3Var.r;
        this.s.e(i3Var);
    }
}
