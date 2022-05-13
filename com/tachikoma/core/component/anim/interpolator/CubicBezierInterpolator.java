package com.tachikoma.core.component.anim.interpolator;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CubicBezierInterpolator implements Interpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PointF a;
    public PointF b;
    public PointF c;
    public PointF end;
    public PointF start;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CubicBezierInterpolator(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((PointF) objArr2[0], (PointF) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pointF, pointF2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        float f = pointF.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = pointF2.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.start = pointF;
        this.end = pointF2;
    }

    public static CubicBezierInterpolator buildDefaultEaseInInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new CubicBezierInterpolator(0.42f, 0.0f, 1.0f, 1.0f) : (CubicBezierInterpolator) invokeV.objValue;
    }

    public static CubicBezierInterpolator buildDefaultEaseInOutInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new CubicBezierInterpolator(0.42f, 0.0f, 0.58f, 1.0f) : (CubicBezierInterpolator) invokeV.objValue;
    }

    public static CubicBezierInterpolator buildDefaultEaseInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new CubicBezierInterpolator(0.25f, 0.1f, 0.25f, 1.0f) : (CubicBezierInterpolator) invokeV.objValue;
    }

    public static CubicBezierInterpolator buildDefaultEaseOutInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new CubicBezierInterpolator(0.0f, 0.0f, 0.58f, 1.0f) : (CubicBezierInterpolator) invokeV.objValue;
    }

    public static CubicBezierInterpolator buildDefaultLinearInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CubicBezierInterpolator(0.0f, 0.0f, 1.0f, 1.0f) : (CubicBezierInterpolator) invokeV.objValue;
    }

    private float getBezierCoordinateX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f)) == null) {
            PointF pointF = this.c;
            PointF pointF2 = this.start;
            float f2 = pointF2.x * 3.0f;
            pointF.x = f2;
            PointF pointF3 = this.b;
            float f3 = ((this.end.x - pointF2.x) * 3.0f) - f2;
            pointF3.x = f3;
            PointF pointF4 = this.a;
            float f4 = (1.0f - pointF.x) - f3;
            pointF4.x = f4;
            return f * (pointF.x + ((pointF3.x + (f4 * f)) * f));
        }
        return invokeF.floatValue;
    }

    private float getXDerivate(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65545, this, f)) == null) ? this.c.x + (f * ((this.b.x * 2.0f) + (this.a.x * 3.0f * f))) : invokeF.floatValue;
    }

    public float getBezierCoordinateY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            PointF pointF = this.c;
            PointF pointF2 = this.start;
            float f2 = pointF2.y * 3.0f;
            pointF.y = f2;
            PointF pointF3 = this.b;
            float f3 = ((this.end.y - pointF2.y) * 3.0f) - f2;
            pointF3.y = f3;
            PointF pointF4 = this.a;
            float f4 = (1.0f - pointF.y) - f3;
            pointF4.y = f4;
            return f * (pointF.y + ((pointF3.y + (f4 * f)) * f));
        }
        return invokeF.floatValue;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) ? getBezierCoordinateY(getXForTime(f)) : invokeF.floatValue;
    }

    public float getXForTime(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
            float f2 = f;
            for (int i = 1; i < 14; i++) {
                float bezierCoordinateX = getBezierCoordinateX(f2) - f;
                if (Math.abs(bezierCoordinateX) < 0.001d) {
                    break;
                }
                f2 -= bezierCoordinateX / getXDerivate(f2);
            }
            return f2;
        }
        return invokeF.floatValue;
    }
}
