package com.ksad.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ksad.lottie.a.a.r;
import java.io.Closeable;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final PathMeasure f33758a;

    /* renamed from: b  reason: collision with root package name */
    public static final Path f33759b;

    /* renamed from: c  reason: collision with root package name */
    public static final Path f33760c;

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f33761d;

    /* renamed from: e  reason: collision with root package name */
    public static final float f33762e;

    /* renamed from: f  reason: collision with root package name */
    public static float f33763f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(762599206, "Lcom/ksad/lottie/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(762599206, "Lcom/ksad/lottie/d/f;");
                return;
            }
        }
        f33758a = new PathMeasure();
        f33759b = new Path();
        f33760c = new Path();
        f33761d = new float[4];
        f33762e = (float) Math.sqrt(2.0d);
        f33763f = -1.0f;
    }

    public static float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f33763f == -1.0f) {
                f33763f = Resources.getSystem().getDisplayMetrics().density;
            }
            return f33763f;
        }
        return invokeV.floatValue;
    }

    public static float a(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, matrix)) == null) {
            float[] fArr = f33761d;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f2 = f33762e;
            fArr[2] = f2;
            fArr[3] = f2;
            matrix.mapPoints(fArr);
            float[] fArr2 = f33761d;
            return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
        }
        return invokeL.floatValue;
    }

    public static int a(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
            if (f3 != 0.0f) {
                i2 = (int) (i2 * 31 * f3);
            }
            if (f4 != 0.0f) {
                i2 = (int) (i2 * 31 * f4);
            }
            return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
        }
        return invokeCommon.intValue;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65540, null, pointF, pointF2, pointF3, pointF4)) == null) {
            Path path = new Path();
            path.moveTo(pointF.x, pointF.y);
            if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
                path.lineTo(pointF2.x, pointF2.y);
            } else {
                float f2 = pointF.x;
                float f3 = pointF2.x;
                float f4 = pointF2.y;
                path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
            }
            return path;
        }
        return (Path) invokeLLLL.objValue;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{path, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            com.ksad.lottie.c.c("applyTrimPathIfNeeded");
            f33758a.setPath(path, false);
            float length = f33758a.getLength();
            if (f2 == 1.0f && f3 == 0.0f) {
                com.ksad.lottie.c.d("applyTrimPathIfNeeded");
            } else if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
                com.ksad.lottie.c.d("applyTrimPathIfNeeded");
            } else {
                float f5 = f2 * length;
                float f6 = f3 * length;
                float f7 = f4 * length;
                float min = Math.min(f5, f6) + f7;
                float max = Math.max(f5, f6) + f7;
                if (min >= length && max >= length) {
                    min = e.a(min, length);
                    max = e.a(max, length);
                }
                if (min < 0.0f) {
                    min = e.a(min, length);
                }
                if (max < 0.0f) {
                    max = e.a(max, length);
                }
                int i2 = (min > max ? 1 : (min == max ? 0 : -1));
                if (i2 == 0) {
                    path.reset();
                } else {
                    if (i2 >= 0) {
                        min -= length;
                    }
                    f33759b.reset();
                    f33758a.getSegment(min, max, f33759b, true);
                    if (max > length) {
                        f33760c.reset();
                        f33758a.getSegment(0.0f, max % length, f33760c, true);
                    } else {
                        if (min < 0.0f) {
                            f33760c.reset();
                            f33758a.getSegment(min + length, length, f33760c, true);
                        }
                        path.set(f33759b);
                    }
                    f33759b.addPath(f33760c);
                    path.set(f33759b);
                }
                com.ksad.lottie.c.d("applyTrimPathIfNeeded");
            }
        }
    }

    public static void a(Path path, @Nullable r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, path, rVar) == null) || rVar == null) {
            return;
        }
        a(path, rVar.c().e().floatValue() / 100.0f, rVar.d().e().floatValue() / 100.0f, rVar.e().e().floatValue() / 360.0f);
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            if (i2 < i5) {
                return false;
            }
            if (i2 > i5) {
                return true;
            }
            if (i3 < i6) {
                return false;
            }
            return i3 > i6 || i4 >= i7;
        }
        return invokeCommon.booleanValue;
    }
}
