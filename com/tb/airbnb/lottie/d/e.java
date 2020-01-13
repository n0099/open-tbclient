package com.tb.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tb.airbnb.lottie.a.a.j;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    public static PointF b(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF cW = hVar.cW();
        path.moveTo(cW.x, cW.y);
        PointF pointF = new PointF(cW.x, cW.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.cX().size()) {
                break;
            }
            com.tb.airbnb.lottie.model.a aVar = hVar.cX().get(i2);
            PointF cd = aVar.cd();
            PointF ce = aVar.ce();
            PointF cf = aVar.cf();
            if (cd.equals(pointF) && ce.equals(cf)) {
                path.lineTo(cf.x, cf.y);
            } else {
                path.cubicTo(cd.x, cd.y, ce.x, ce.y, cf.x, cf.y);
            }
            pointF.set(cf.x, cf.y);
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
        return f((int) f, (int) f2);
    }

    private static int f(int i, int i2) {
        return i - (g(i, i2) * i2);
    }

    private static int g(int i, int i2) {
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
            list.add(eVar2.Rm(jVar.getName()).a(jVar));
        }
    }
}
