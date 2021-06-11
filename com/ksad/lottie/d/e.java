package com.ksad.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.ksad.lottie.model.content.h;
/* loaded from: classes6.dex */
public class e {
    public static double a(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float a(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(float f2, float f3) {
        return a((int) f2, (int) f3);
    }

    public static int a(int i2, int i3) {
        return i2 - (i3 * b(i2, i3));
    }

    public static int a(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
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

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int b(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    public static boolean c(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }
}
