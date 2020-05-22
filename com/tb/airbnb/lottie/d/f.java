package com.tb.airbnb.lottie.d;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.r;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class f {
    private static final PathMeasure Cs = new PathMeasure();
    private static final Path Cu = new Path();
    private static final Path FL = new Path();
    private static final float[] points = new float[4];
    private static final float FM = (float) Math.sqrt(2.0d);
    private static float FN = -1.0f;

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static float b(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = FM;
        points[3] = FM;
        matrix.mapPoints(points);
        return ((float) Math.hypot(points[2] - points[0], points[3] - points[1])) / 2.0f;
    }

    public static void a(Path path, @Nullable r rVar) {
        if (rVar != null) {
            a(path, rVar.dIz().getValue().floatValue() / 100.0f, rVar.dIA().getValue().floatValue() / 100.0f, rVar.dIB().getValue().floatValue() / 360.0f);
        }
    }

    public static void a(Path path, float f, float f2, float f3) {
        com.tb.airbnb.lottie.c.beginSection("applyTrimPathIfNeeded");
        Cs.setPath(path, false);
        float length = Cs.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.tb.airbnb.lottie.c.aV("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.tb.airbnb.lottie.c.aV("applyTrimPathIfNeeded");
        } else {
            float f4 = length * f;
            float f5 = length * f2;
            float min = Math.min(f4, f5);
            float max = Math.max(f4, f5);
            float f6 = f3 * length;
            float f7 = min + f6;
            float f8 = max + f6;
            if (f7 >= length && f8 >= length) {
                f7 = e.j(f7, length);
                f8 = e.j(f8, length);
            }
            if (f7 < 0.0f) {
                f7 = e.j(f7, length);
            }
            if (f8 < 0.0f) {
                f8 = e.j(f8, length);
            }
            if (f7 == f8) {
                path.reset();
                com.tb.airbnb.lottie.c.aV("applyTrimPathIfNeeded");
                return;
            }
            if (f7 >= f8) {
                f7 -= length;
            }
            Cu.reset();
            Cs.getSegment(f7, f8, Cu, true);
            if (f8 > length) {
                FL.reset();
                Cs.getSegment(0.0f, f8 % length, FL, true);
                Cu.addPath(FL);
            } else if (f7 < 0.0f) {
                FL.reset();
                Cs.getSegment(f7 + length, length, FL, true);
                Cu.addPath(FL);
            }
            path.set(Cu);
            com.tb.airbnb.lottie.c.aV("applyTrimPathIfNeeded");
        }
    }

    public static boolean c(int i, int i2, int i3, int i4, int i5, int i6) {
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

    public static int d(float f, float f2, float f3, float f4) {
        int i = 17;
        if (f != 0.0f) {
            i = (int) (527 * f);
        }
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            return (int) (i * 31 * f4);
        }
        return i;
    }

    public static float jk() {
        if (FN == -1.0f) {
            FN = Resources.getSystem().getDisplayMetrics().density;
        }
        return FN;
    }
}
