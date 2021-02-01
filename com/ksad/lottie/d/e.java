package com.ksad.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.ksad.lottie.model.content.h;
/* loaded from: classes3.dex */
public class e {
    public static double a(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return ((d2 - d) * d3) + d;
    }

    public static float a(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f, float f2) {
        return a((int) f, (int) f2);
    }

    private static int a(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    public static int a(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + ((i2 - i) * f));
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF a2 = hVar.a();
        path.moveTo(a2.x, a2.y);
        PointF pointF = new PointF(a2.x, a2.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.c().size()) {
                break;
            }
            com.ksad.lottie.model.a aVar = hVar.c().get(i2);
            PointF a3 = aVar.a();
            PointF b2 = aVar.b();
            PointF c = aVar.c();
            if (a3.equals(pointF) && b2.equals(c)) {
                path.lineTo(c.x, c.y);
            } else {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c.x, c.y);
            }
            pointF.set(c.x, c.y);
            i = i2 + 1;
        }
        if (hVar.b()) {
            path.close();
        }
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }
}
