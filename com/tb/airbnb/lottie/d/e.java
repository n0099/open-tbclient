package com.tb.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tb.airbnb.lottie.a.a.j;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static PointF b(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF cX = hVar.cX();
        path.moveTo(cX.x, cX.y);
        PointF pointF = new PointF(cX.x, cX.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.cY().size()) {
                break;
            }
            com.tb.airbnb.lottie.model.a aVar = hVar.cY().get(i2);
            PointF ce = aVar.ce();
            PointF cf = aVar.cf();
            PointF cg = aVar.cg();
            if (ce.equals(pointF) && cf.equals(cg)) {
                path.lineTo(cg.x, cg.y);
            } else {
                path.cubicTo(ce.x, ce.y, cf.x, cf.y, cg.x, cg.y);
            }
            pointF.set(cg.x, cg.y);
            i = i2 + 1;
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static double b(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return ((d2 - d) * d3) + d;
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + ((i2 - i) * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(float f, float f2) {
        return g((int) f, (int) f2);
    }

    private static int g(int i, int i2) {
        return i - (h(i, i2) * i2);
    }

    private static int h(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2, j jVar) {
        if (eVar.e(jVar.getName(), i)) {
            list.add(eVar2.Rx(jVar.getName()).a(jVar));
        }
    }
}
