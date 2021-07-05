package com.ksad.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.lottie.model.content.h;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? d2 + (d4 * (d3 - d2)) : invokeCommon.doubleValue;
    }

    public static float a(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + (f4 * (f3 - f2)) : invokeCommon.floatValue;
    }

    public static int a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? a((int) f2, (int) f3) : invokeCommon.intValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? i2 - (i3 * b(i2, i3)) : invokeII.intValue;
    }

    public static int a(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? (int) (i2 + (f2 * (i3 - i2))) : invokeCommon.intValue;
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? Math.max(i3, Math.min(i4, i2)) : invokeIII.intValue;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, pointF, pointF2)) == null) ? new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y) : (PointF) invokeLL.objValue;
    }

    public static void a(h hVar, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hVar, path) == null) {
            path.reset();
            PointF a2 = hVar.a();
            path.moveTo(a2.x, a2.y);
            PointF pointF = new PointF(a2.x, a2.y);
            for (int i2 = 0; i2 < hVar.c().size(); i2++) {
                com.ksad.lottie.model.a aVar = hVar.c().get(i2);
                PointF a3 = aVar.a();
                PointF b2 = aVar.b();
                PointF c2 = aVar.c();
                if (a3.equals(pointF) && b2.equals(c2)) {
                    path.lineTo(c2.x, c2.y);
                } else {
                    path.cubicTo(a3.x, a3.y, b2.x, b2.y, c2.x, c2.y);
                }
                pointF.set(c2.x, c2.y);
            }
            if (hVar.b()) {
                path.close();
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.max(f3, Math.min(f4, f2)) : invokeCommon.floatValue;
    }

    public static int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) {
            int i4 = i2 / i3;
            return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
        }
        return invokeII.intValue;
    }

    public static boolean c(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 >= f3 && f2 <= f4 : invokeCommon.booleanValue;
    }
}
