package com.ksad.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.r;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final PathMeasure f31897a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    public static final Path f31898b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public static final Path f31899c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f31900d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    public static final float f31901e = (float) Math.sqrt(2.0d);

    /* renamed from: f  reason: collision with root package name */
    public static float f31902f = -1.0f;

    public static float a() {
        if (f31902f == -1.0f) {
            f31902f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f31902f;
    }

    public static float a(Matrix matrix) {
        float[] fArr = f31900d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f31901e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = f31900d;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static int a(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
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

    public static void a(Path path, float f2, float f3, float f4) {
        com.ksad.lottie.c.c("applyTrimPathIfNeeded");
        f31897a.setPath(path, false);
        float length = f31897a.getLength();
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
                f31898b.reset();
                f31897a.getSegment(min, max, f31898b, true);
                if (max > length) {
                    f31899c.reset();
                    f31897a.getSegment(0.0f, max % length, f31899c, true);
                } else {
                    if (min < 0.0f) {
                        f31899c.reset();
                        f31897a.getSegment(min + length, length, f31899c, true);
                    }
                    path.set(f31898b);
                }
                f31898b.addPath(f31899c);
                path.set(f31898b);
            }
            com.ksad.lottie.c.d("applyTrimPathIfNeeded");
        }
    }

    public static void a(Path path, @Nullable r rVar) {
        if (rVar == null) {
            return;
        }
        a(path, rVar.c().e().floatValue() / 100.0f, rVar.d().e().floatValue() / 100.0f, rVar.e().e().floatValue() / 360.0f);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
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
}
