package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y3 extends a4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] h;
    public final i3 i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;

    public y3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new float[20];
        this.i = new i3(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        t(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void A(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.j += f;
            this.k += f2;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float[] fArr = this.h;
                fArr[0] = fArr[0] + f;
                fArr[1] = fArr[1] + f2;
                fArr[5] = fArr[5] + f;
                fArr[6] = fArr[6] + f2;
                fArr[10] = fArr[10] + f;
                fArr[11] = fArr[11] + f2;
                fArr[15] = fArr[15] + f;
                fArr[16] = fArr[16] + f2;
                return;
            }
            this.s = true;
        }
    }

    @Override // com.repackage.a4
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.a(z, z2);
            float[] fArr = this.h;
            if (z) {
                float f = fArr[3];
                fArr[3] = fArr[13];
                fArr[13] = f;
                float f2 = fArr[8];
                fArr[8] = fArr[18];
                fArr[18] = f2;
            }
            if (z2) {
                float f3 = fArr[4];
                fArr[4] = fArr[14];
                fArr[14] = f3;
                float f4 = fArr[9];
                fArr[9] = fArr[19];
                fArr[19] = f4;
            }
        }
    }

    @Override // com.repackage.a4
    public void g(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            super.g(f, f2, f3, f4);
            float[] fArr = this.h;
            fArr[3] = f;
            fArr[4] = f4;
            fArr[8] = f;
            fArr[9] = f2;
            fArr[13] = f3;
            fArr[14] = f2;
            fArr[18] = f3;
            fArr[19] = f4;
        }
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.floatValue;
    }

    public float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.floatValue;
    }

    public float p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.floatValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            float[] fArr = this.h;
            if (z) {
                float f = fArr[4];
                fArr[4] = fArr[19];
                fArr[19] = fArr[14];
                fArr[14] = fArr[9];
                fArr[9] = f;
                float f2 = fArr[3];
                fArr[3] = fArr[18];
                fArr[18] = fArr[13];
                fArr[13] = fArr[8];
                fArr[8] = f2;
                return;
            }
            float f3 = fArr[4];
            fArr[4] = fArr[9];
            fArr[9] = fArr[14];
            fArr[14] = fArr[19];
            fArr[19] = f3;
            float f4 = fArr[3];
            fArr[3] = fArr[8];
            fArr[8] = fArr[13];
            fArr[13] = fArr[18];
            fArr[18] = f4;
        }
    }

    public void r(y3 y3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, y3Var) == null) {
            if (y3Var != null) {
                System.arraycopy(y3Var.h, 0, this.h, 0, 20);
                this.a = y3Var.a;
                this.b = y3Var.b;
                this.c = y3Var.c;
                this.d = y3Var.d;
                this.e = y3Var.e;
                this.j = y3Var.j;
                this.k = y3Var.k;
                this.l = y3Var.l;
                this.m = y3Var.m;
                this.f = y3Var.f;
                this.g = y3Var.g;
                this.n = y3Var.n;
                this.o = y3Var.o;
                this.p = y3Var.p;
                this.q = y3Var.q;
                this.r = y3Var.r;
                this.i.e(y3Var.i);
                this.s = y3Var.s;
                return;
            }
            throw new IllegalArgumentException("sprite cannot be null.");
        }
    }

    public void s(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.j = f;
            this.k = f2;
            this.l = f3;
            this.m = f4;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float f5 = f3 + f;
                float f6 = f4 + f2;
                float[] fArr = this.h;
                fArr[0] = f;
                fArr[1] = f2;
                fArr[5] = f;
                fArr[6] = f6;
                fArr[10] = f5;
                fArr[11] = f6;
                fArr[15] = f5;
                fArr[16] = f2;
                return;
            }
            this.s = true;
        }
    }

    public void t(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.i.d(f, f2, f3, f4);
            float f5 = this.i.f();
            float[] fArr = this.h;
            fArr[2] = f5;
            fArr[7] = f5;
            fArr[12] = f5;
            fArr[17] = f5;
        }
    }

    public void u(i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i3Var) == null) {
            this.i.e(i3Var);
            float f = i3Var.f();
            float[] fArr = this.h;
            fArr[2] = f;
            fArr[7] = f;
            fArr[12] = f;
            fArr[17] = f;
        }
    }

    public void v(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.n = f;
            this.o = f2;
            this.s = true;
        }
    }

    public void w(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.p = f;
            this.s = true;
        }
    }

    public void x(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.q = f;
            this.r = f;
            this.s = true;
        }
    }

    public void y(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.q = f;
            this.r = f2;
            this.s = true;
        }
    }

    public void z(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.l = f;
            this.m = f2;
            if (this.s) {
                return;
            }
            if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
                float f3 = this.j;
                float f4 = f + f3;
                float f5 = this.k;
                float f6 = f2 + f5;
                float[] fArr = this.h;
                fArr[0] = f3;
                fArr[1] = f5;
                fArr[5] = f3;
                fArr[6] = f6;
                fArr[10] = f4;
                fArr[11] = f6;
                fArr[15] = f4;
                fArr[16] = f5;
                return;
            }
            this.s = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y3(Texture texture) {
        this(texture, 0, 0, texture.x(), texture.u());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Texture) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public y3(Texture texture, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = new float[20];
        this.i = new i3(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        if (texture != null) {
            this.a = texture;
            h(i, i2, i3, i4);
            t(1.0f, 1.0f, 1.0f, 1.0f);
            z(Math.abs(i3), Math.abs(i4));
            v(this.l / 2.0f, this.m / 2.0f);
            return;
        }
        throw new IllegalArgumentException("texture cannot be null.");
    }

    public y3(a4 a4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a4Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.h = new float[20];
        this.i = new i3(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        i(a4Var);
        t(1.0f, 1.0f, 1.0f, 1.0f);
        z(a4Var.c(), a4Var.b());
        v(this.l / 2.0f, this.m / 2.0f);
    }

    public y3(y3 y3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y3Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.h = new float[20];
        this.i = new i3(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.s = true;
        r(y3Var);
    }
}
