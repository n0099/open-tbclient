package com.ksad.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.r;
import java.io.Closeable;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f5343a = new PathMeasure();
    private static final Path b = new Path();
    private static final Path c = new Path();
    private static final float[] d = new float[4];
    private static final float e = (float) Math.sqrt(2.0d);
    private static float f = -1.0f;

    public static float a() {
        if (f == -1.0f) {
            f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f;
    }

    public static float a(Matrix matrix) {
        d[0] = 0.0f;
        d[1] = 0.0f;
        d[2] = e;
        d[3] = e;
        matrix.mapPoints(d);
        return ((float) Math.hypot(d[2] - d[0], d[3] - d[1])) / 2.0f;
    }

    public static int a(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (i * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i * 31 * f5) : i;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        com.ksad.lottie.c.c("applyTrimPathIfNeeded");
        f5343a.setPath(path, false);
        float length = f5343a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.ksad.lottie.c.d("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.ksad.lottie.c.d("applyTrimPathIfNeeded");
        } else {
            float f5 = length * f2;
            float f6 = length * f3;
            float min = Math.min(f5, f6);
            float max = Math.max(f5, f6);
            float f7 = f4 * length;
            float f8 = min + f7;
            float f9 = max + f7;
            if (f8 >= length && f9 >= length) {
                f8 = e.a(f8, length);
                f9 = e.a(f9, length);
            }
            if (f8 < 0.0f) {
                f8 = e.a(f8, length);
            }
            if (f9 < 0.0f) {
                f9 = e.a(f9, length);
            }
            if (f8 == f9) {
                path.reset();
                com.ksad.lottie.c.d("applyTrimPathIfNeeded");
                return;
            }
            if (f8 >= f9) {
                f8 -= length;
            }
            b.reset();
            f5343a.getSegment(f8, f9, b, true);
            if (f9 > length) {
                c.reset();
                f5343a.getSegment(0.0f, f9 % length, c, true);
                b.addPath(c);
            } else if (f8 < 0.0f) {
                c.reset();
                f5343a.getSegment(f8 + length, length, c, true);
                b.addPath(c);
            }
            path.set(b);
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
            } catch (Exception e3) {
            }
        }
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i <= i4) {
            if (i2 < i5) {
                return false;
            }
            return i2 > i5 || i3 >= i6;
        }
        return true;
    }
}
