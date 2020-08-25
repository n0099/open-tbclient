package com.tb.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.tb.airbnb.lottie.a.a.j;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF kl = hVar.kl();
        path.moveTo(kl.x, kl.y);
        PointF pointF = new PointF(kl.x, kl.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.km().size()) {
                break;
            }
            com.tb.airbnb.lottie.model.a aVar = hVar.km().get(i2);
            PointF js = aVar.js();
            PointF jt = aVar.jt();
            PointF ju = aVar.ju();
            if (js.equals(pointF) && jt.equals(ju)) {
                path.lineTo(ju.x, ju.y);
            } else {
                path.cubicTo(js.x, js.y, jt.x, jt.y, ju.x, ju.y);
            }
            pointF.set(ju.x, ju.y);
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
    public static int i(float f, float f2) {
        return l((int) f, (int) f2);
    }

    private static int l(int i, int i2) {
        return i - (m(i, i2) * i2);
    }

    private static int m(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2, j jVar) {
        if (eVar.j(jVar.getName(), i)) {
            list.add(eVar2.VE(jVar.getName()).a(jVar));
        }
    }
}
