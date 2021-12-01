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
/* loaded from: classes2.dex */
public class CubicBezierInterpolator implements Interpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PointF a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f62129b;

    /* renamed from: c  reason: collision with root package name */
    public PointF f62130c;
    public PointF end;
    public PointF start;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CubicBezierInterpolator(double d2, double d3, double d4, double d5) {
        this((float) d2, (float) d3, (float) d4, (float) d5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CubicBezierInterpolator(float f2, float f3, float f4, float f5) {
        this(new PointF(f2, f3), new PointF(f4, f5));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new PointF();
        this.f62129b = new PointF();
        this.f62130c = new PointF();
        float f2 = pointF.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f3 = pointF2.x;
        if (f3 < 0.0f || f3 > 1.0f) {
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

    private float getBezierCoordinateX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f2)) == null) {
            PointF pointF = this.f62130c;
            PointF pointF2 = this.start;
            float f3 = pointF2.x * 3.0f;
            pointF.x = f3;
            PointF pointF3 = this.f62129b;
            float f4 = ((this.end.x - pointF2.x) * 3.0f) - f3;
            pointF3.x = f4;
            PointF pointF4 = this.a;
            float f5 = (1.0f - pointF.x) - f4;
            pointF4.x = f5;
            return f2 * (pointF.x + ((pointF3.x + (f5 * f2)) * f2));
        }
        return invokeF.floatValue;
    }

    private float getXDerivate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65545, this, f2)) == null) ? this.f62130c.x + (f2 * ((this.f62129b.x * 2.0f) + (this.a.x * 3.0f * f2))) : invokeF.floatValue;
    }

    public float getBezierCoordinateY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            PointF pointF = this.f62130c;
            PointF pointF2 = this.start;
            float f3 = pointF2.y * 3.0f;
            pointF.y = f3;
            PointF pointF3 = this.f62129b;
            float f4 = ((this.end.y - pointF2.y) * 3.0f) - f3;
            pointF3.y = f4;
            PointF pointF4 = this.a;
            float f5 = (1.0f - pointF.y) - f4;
            pointF4.y = f5;
            return f2 * (pointF.y + ((pointF3.y + (f5 * f2)) * f2));
        }
        return invokeF.floatValue;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? getBezierCoordinateY(getXForTime(f2)) : invokeF.floatValue;
    }

    public float getXForTime(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            float f3 = f2;
            for (int i2 = 1; i2 < 14; i2++) {
                float bezierCoordinateX = getBezierCoordinateX(f3) - f2;
                if (Math.abs(bezierCoordinateX) < 0.001d) {
                    break;
                }
                f3 -= bezierCoordinateX / getXDerivate(f3);
            }
            return f3;
        }
        return invokeF.floatValue;
    }
}
