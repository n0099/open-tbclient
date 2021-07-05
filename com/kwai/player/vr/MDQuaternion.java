package com.kwai.player.vr;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.math.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MDQuaternion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] q;

    public MDQuaternion() {
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
        this.q = new float[4];
        idt();
    }

    public MDQuaternion(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = r0;
        float[] fArr = {f2, f3, f4, f5};
    }

    public static float calcAngle(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, fArr, fArr2)) == null) ? (float) Math.acos(Math.min(dot(normal(fArr), normal(fArr2)), 1.0f)) : invokeLL.floatValue;
    }

    public static float[] calcAxis(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, fArr, fArr2)) == null) ? normal(cross(normal(fArr), normal(fArr2))) : (float[]) invokeLL.objValue;
    }

    public static float[] cross(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, fArr, fArr2)) == null) ? new float[]{(fArr[1] * fArr2[2]) - (fArr2[1] * fArr[2]), (fArr[2] * fArr2[0]) - (fArr2[2] * fArr[0]), (fArr[0] * fArr2[1]) - (fArr2[0] * fArr[1])} : (float[]) invokeLL.objValue;
    }

    public static float dot(float[] fArr, float[] fArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, fArr, fArr2)) == null) ? (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]) : invokeLL.floatValue;
    }

    public static float[] normal(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fArr)) == null) {
            float sqrt = (float) Math.sqrt(dot(fArr, fArr));
            return new float[]{fArr[0] / sqrt, fArr[1] / sqrt, fArr[2] / sqrt};
        }
        return (float[]) invokeL.objValue;
    }

    private void set(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = this.q;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
        }
    }

    private void set(float f2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Float.valueOf(f2), fArr}) == null) {
            double d2 = f2 / 2.0f;
            this.q[0] = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float[] fArr2 = this.q;
            fArr2[1] = fArr[0] * sin;
            fArr2[2] = fArr[1] * sin;
            fArr2[3] = fArr[2] * sin;
        }
    }

    private void set(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, fArr, fArr2) == null) {
            float[] normal = normal(fArr);
            float[] normal2 = normal(fArr2);
            set((float) Math.acos(dot(normal, normal2)), normal(cross(normal, normal2)));
        }
    }

    private void setFromAxes(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10)}) == null) {
            if (z) {
                float len = 1.0f / MDVector3D.len(f2, f3, f4);
                float len2 = 1.0f / MDVector3D.len(f5, f6, f7);
                float len3 = 1.0f / MDVector3D.len(f8, f9, f10);
                f2 *= len;
                f3 *= len;
                f4 *= len;
                f5 *= len2;
                f6 *= len2;
                f7 *= len2;
                f8 *= len3;
                f9 *= len3;
                f10 *= len3;
            }
            float f16 = f2 + f6 + f10;
            if (f16 >= 0.0f) {
                float sqrt = (float) Math.sqrt(f16 + 1.0f);
                f15 = sqrt * 0.5f;
                float f17 = 0.5f / sqrt;
                f13 = (f9 - f7) * f17;
                f11 = (f4 - f8) * f17;
                f14 = (f5 - f3) * f17;
            } else {
                if (f2 > f6 && f2 > f10) {
                    float sqrt2 = (float) Math.sqrt(((f2 + 1.0d) - f6) - f10);
                    float f18 = sqrt2 * 0.5f;
                    float f19 = 0.5f / sqrt2;
                    float f20 = (f5 + f3) * f19;
                    f14 = (f4 + f8) * f19;
                    f12 = (f9 - f7) * f19;
                    f11 = f20;
                    f13 = f18;
                } else if (f6 > f10) {
                    float sqrt3 = (float) Math.sqrt(((f6 + 1.0d) - f2) - f10);
                    float f21 = sqrt3 * 0.5f;
                    float f22 = 0.5f / sqrt3;
                    float f23 = (f5 + f3) * f22;
                    f14 = (f9 + f7) * f22;
                    f12 = (f4 - f8) * f22;
                    f13 = f23;
                    f11 = f21;
                } else {
                    float sqrt4 = (float) Math.sqrt(((f10 + 1.0d) - f2) - f6);
                    float f24 = sqrt4 * 0.5f;
                    float f25 = 0.5f / sqrt4;
                    float f26 = (f4 + f8) * f25;
                    f11 = (f9 + f7) * f25;
                    f12 = (f5 - f3) * f25;
                    f13 = f26;
                    f14 = f24;
                }
                f15 = f12;
            }
            set(f15, f13, f11, f14);
        }
    }

    public void clone(MDQuaternion mDQuaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mDQuaternion) == null) {
            float[] fArr = mDQuaternion.q;
            float[] fArr2 = this.q;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        }
    }

    public MDQuaternion conjugate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float[] fArr = this.q;
            return new MDQuaternion(fArr[0], -fArr[1], -fArr[2], -fArr[3]);
        }
        return (MDQuaternion) invokeV.objValue;
    }

    public MDQuaternion divides(MDQuaternion mDQuaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mDQuaternion)) == null) ? inverse().times(mDQuaternion) : (MDQuaternion) invokeL.objValue;
    }

    public void fromMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) {
            setFromAxes(false, fArr[0], fArr[1], fArr[2], fArr[4], fArr[5], fArr[6], fArr[8], fArr[9], fArr[10]);
        }
    }

    public int getGimbalPole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float[] fArr = this.q;
            float f2 = (fArr[2] * fArr[1]) + (fArr[3] * fArr[0]);
            if (f2 > 0.499f) {
                return 1;
            }
            return f2 < -0.499f ? -1 : 0;
        }
        return invokeV.intValue;
    }

    public float getPitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPitchRad() * 57.295776f : invokeV.floatValue;
    }

    public float getPitchRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            int gimbalPole = getGimbalPole();
            return gimbalPole == 0 ? (float) Math.asin(a.b(((f2 * f3) - (f5 * f4)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
        }
        return invokeV.floatValue;
    }

    public float getRoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getRollRad() * 57.295776f : invokeV.floatValue;
    }

    public float getRollRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            int gimbalPole = getGimbalPole();
            return gimbalPole == 0 ? a.a(((f2 * f5) + (f4 * f3)) * 2.0f, 1.0f - (((f3 * f3) + (f5 * f5)) * 2.0f)) : gimbalPole * 2.0f * a.a(f4, f2);
        }
        return invokeV.floatValue;
    }

    public float getYaw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getYawRad() * 57.295776f : invokeV.floatValue;
    }

    public float getYawRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            if (getGimbalPole() == 0) {
                return a.a(((f2 * f4) + (f5 * f3)) * 2.0f, 1.0f - (((f4 * f4) + (f3 * f3)) * 2.0f));
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public void idt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            set(1.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public MDQuaternion inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            float[] fArr = this.q;
            float f2 = (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]) + (fArr[3] * fArr[3]);
            return new MDQuaternion(fArr[0] / f2, (-fArr[1]) / f2, (-fArr[2]) / f2, (-fArr[3]) / f2);
        }
        return (MDQuaternion) invokeV.objValue;
    }

    public void nor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            float f6 = (f3 * f3) + (f4 * f4) + (f5 * f5) + (f2 * f2);
            if (f6 != 0.0f && !a.c(f6, 1.0f)) {
                float sqrt = (float) Math.sqrt(f6);
                f2 /= sqrt;
                f3 /= sqrt;
                f4 /= sqrt;
                f5 /= sqrt;
            }
            set(f2, f3, f4, f5);
        }
    }

    public MDQuaternion plus(MDQuaternion mDQuaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, mDQuaternion)) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float[] fArr2 = mDQuaternion.q;
            return new MDQuaternion(f2 + fArr2[0], fArr[1] + fArr2[1], fArr[2] + fArr2[2], fArr[3] + fArr2[3]);
        }
        return (MDQuaternion) invokeL.objValue;
    }

    public float[] rotateVec(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float[] fArr2 = this.q;
            float f5 = (fArr2[1] * f2) + (fArr2[2] * f3) + (fArr2[3] * f4);
            return new float[]{(((fArr2[0] * ((fArr2[0] * f2) - ((fArr2[2] * f4) - (fArr2[3] * f3)))) + (fArr2[1] * f5)) * 2.0f) - f2, (((fArr2[0] * ((fArr2[0] * f3) - ((fArr2[3] * f2) - (fArr2[1] * f4)))) + (fArr2[2] * f5)) * 2.0f) - f3, (((fArr2[0] * ((fArr2[0] * f4) - ((fArr2[1] * f3) - (fArr2[2] * f2)))) + (f5 * fArr2[3])) * 2.0f) - f4};
        }
        return (float[]) invokeL.objValue;
    }

    public void setEulerAngles(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            setEulerAnglesRad(f2 * 0.017453292f, f3 * 0.017453292f, f4 * 0.017453292f);
        }
    }

    public void setEulerAnglesRad(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            double d2 = f4 * 0.5f;
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            double d3 = f2 * 0.5f;
            float sin2 = (float) Math.sin(d3);
            float cos2 = (float) Math.cos(d3);
            double d4 = f3 * 0.5f;
            float sin3 = (float) Math.sin(d4);
            float cos3 = (float) Math.cos(d4);
            float f5 = cos3 * sin2;
            float f6 = sin3 * cos2;
            float f7 = cos3 * cos2;
            float f8 = sin3 * sin2;
            float[] fArr = this.q;
            fArr[1] = (f5 * cos) + (f6 * sin);
            fArr[2] = (f6 * cos) - (f5 * sin);
            fArr[3] = (f7 * sin) - (f8 * cos);
            fArr[0] = (f7 * cos) + (f8 * sin);
        }
    }

    public void setFromAxis(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            setFromAxisRad(f2, f3, f4, f5 * 0.017453292f);
        }
    }

    public void setFromAxisRad(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float len = MDVector3D.len(f2, f3, f4);
            if (len == 0.0f) {
                idt();
                return;
            }
            float f6 = 1.0f / len;
            double d2 = (f5 < 0.0f ? 6.2831855f - ((-f5) % 6.2831855f) : f5 % 6.2831855f) / 2.0f;
            float sin = (float) Math.sin(d2);
            set((float) Math.cos(d2), f2 * f6 * sin, f3 * f6 * sin, f6 * f4 * sin);
            nor();
        }
    }

    public MDQuaternion times(MDQuaternion mDQuaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, mDQuaternion)) == null) {
            float[] fArr = this.q;
            float f2 = fArr[0];
            float[] fArr2 = mDQuaternion.q;
            return new MDQuaternion((((f2 * fArr2[0]) - (fArr[1] * fArr2[1])) - (fArr[2] * fArr2[2])) - (fArr[3] * fArr2[3]), (((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[0])) + (fArr[2] * fArr2[3])) - (fArr[3] * fArr2[2]), ((fArr[0] * fArr2[2]) - (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[0]) + (fArr[3] * fArr2[1]), (((fArr[0] * fArr2[3]) + (fArr[1] * fArr2[2])) - (fArr[2] * fArr2[1])) + (fArr[3] * fArr2[0]));
        }
        return (MDQuaternion) invokeL.objValue;
    }

    public void toMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fArr) == null) {
            float[] fArr2 = this.q;
            float f2 = fArr2[1] * fArr2[1];
            float f3 = fArr2[1] * fArr2[2];
            float f4 = fArr2[1] * fArr2[3];
            float f5 = fArr2[1] * fArr2[0];
            float f6 = fArr2[2] * fArr2[2];
            float f7 = fArr2[2] * fArr2[3];
            float f8 = fArr2[2] * fArr2[0];
            float f9 = fArr2[3] * fArr2[3];
            float f10 = fArr2[3] * fArr2[0];
            fArr[0] = 1.0f - ((f6 + f9) * 2.0f);
            fArr[1] = (f3 - f10) * 2.0f;
            fArr[2] = (f4 + f8) * 2.0f;
            fArr[4] = (f3 + f10) * 2.0f;
            fArr[5] = 1.0f - ((f9 + f2) * 2.0f);
            fArr[6] = (f7 - f5) * 2.0f;
            fArr[8] = (f4 - f8) * 2.0f;
            fArr[9] = (f7 + f5) * 2.0f;
            fArr[10] = 1.0f - ((f2 + f6) * 2.0f);
            fArr[14] = 0.0f;
            fArr[13] = 0.0f;
            fArr[12] = 0.0f;
            fArr[11] = 0.0f;
            fArr[7] = 0.0f;
            fArr[3] = 0.0f;
            fArr[15] = 1.0f;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? String.format("MDQuaternion w=%f x=%f, y=%f, z=%f", Float.valueOf(this.q[0]), Float.valueOf(this.q[1]), Float.valueOf(this.q[2]), Float.valueOf(this.q[3])) : (String) invokeV.objValue;
    }
}
