package com.repackage;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ov5;
/* loaded from: classes7.dex */
public final class rv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;
    public double b;
    public boolean c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i;
    public final ov5.i j;

    public rv5(float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new ov5.i();
        this.i = f;
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (float) this.i : invokeV.floatValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        if (this.i != Double.MAX_VALUE) {
            double d = this.b;
            if (d > 1.0d) {
                double d2 = this.a;
                this.f = ((-d) * d2) + (d2 * Math.sqrt((d * d) - 1.0d));
                double d3 = this.b;
                double d4 = this.a;
                this.g = ((-d3) * d4) - (d4 * Math.sqrt((d3 * d3) - 1.0d));
            } else if (d >= 0.0d && d < 1.0d) {
                this.h = this.a * Math.sqrt(1.0d - (d * d));
            }
            this.c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? ((double) Math.abs(f2)) < this.e && ((double) Math.abs(f - a())) < this.d : invokeCommon.booleanValue;
    }

    public rv5 d(@FloatRange(from = 0.0d) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
            if (f >= 0.0f) {
                this.b = f;
                this.c = false;
                return this;
            }
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        return (rv5) invokeF.objValue;
    }

    public rv5 e(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
            this.i = f;
            return this;
        }
        return (rv5) invokeF.objValue;
    }

    public rv5 f(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (f > 0.0f) {
                this.a = Math.sqrt(f);
                this.c = false;
                return this;
            }
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        return (rv5) invokeF.objValue;
    }

    public void g(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d)}) == null) {
            double abs = Math.abs(d);
            this.d = abs;
            this.e = abs * 62.5d;
        }
    }

    public ov5.i h(double d, double d2, long j) {
        InterceptResult invokeCommon;
        double cos;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Long.valueOf(j)})) == null) {
            b();
            double d4 = j / 1000.0d;
            double d5 = d - this.i;
            double d6 = this.b;
            if (d6 > 1.0d) {
                double d7 = this.g;
                double d8 = this.f;
                double d9 = d5 - (((d7 * d5) - d2) / (d7 - d8));
                double d10 = ((d5 * d7) - d2) / (d7 - d8);
                d3 = (Math.pow(2.718281828459045d, d7 * d4) * d9) + (Math.pow(2.718281828459045d, this.f * d4) * d10);
                double d11 = this.g;
                double pow = d9 * d11 * Math.pow(2.718281828459045d, d11 * d4);
                double d12 = this.f;
                cos = pow + (d10 * d12 * Math.pow(2.718281828459045d, d12 * d4));
            } else if (d6 == 1.0d) {
                double d13 = this.a;
                double d14 = d2 + (d13 * d5);
                double d15 = d5 + (d14 * d4);
                d3 = Math.pow(2.718281828459045d, (-d13) * d4) * d15;
                double pow2 = d15 * Math.pow(2.718281828459045d, (-this.a) * d4);
                double d16 = this.a;
                cos = (d14 * Math.pow(2.718281828459045d, (-d16) * d4)) + (pow2 * (-d16));
            } else {
                double d17 = 1.0d / this.h;
                double d18 = this.a;
                double d19 = d17 * ((d6 * d18 * d5) + d2);
                double pow3 = Math.pow(2.718281828459045d, (-d6) * d18 * d4) * ((Math.cos(this.h * d4) * d5) + (Math.sin(this.h * d4) * d19));
                double d20 = this.a;
                double d21 = this.b;
                double d22 = (-d20) * pow3 * d21;
                double pow4 = Math.pow(2.718281828459045d, (-d21) * d20 * d4);
                double d23 = this.h;
                double sin = (-d23) * d5 * Math.sin(d23 * d4);
                double d24 = this.h;
                cos = d22 + (pow4 * (sin + (d19 * d24 * Math.cos(d24 * d4))));
                d3 = pow3;
            }
            ov5.i iVar = this.j;
            iVar.a = (float) (d3 + this.i);
            iVar.b = (float) cos;
            return iVar;
        }
        return (ov5.i) invokeCommon.objValue;
    }
}
