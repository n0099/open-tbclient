package d.a.a.v;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import d.a.a.q.a.j;
import d.a.a.s.j.h;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean d(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static int e(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int f(float f2, float f3) {
        return g((int) f2, (int) f3);
    }

    public static int g(int i, int i2) {
        return i - (i2 * e(i, i2));
    }

    public static void h(h hVar, Path path) {
        path.reset();
        PointF b2 = hVar.b();
        path.moveTo(b2.x, b2.y);
        PointF pointF = new PointF(b2.x, b2.y);
        for (int i = 0; i < hVar.a().size(); i++) {
            d.a.a.s.a aVar = hVar.a().get(i);
            PointF a2 = aVar.a();
            PointF b3 = aVar.b();
            PointF c2 = aVar.c();
            if (a2.equals(pointF) && b3.equals(c2)) {
                path.lineTo(c2.x, c2.y);
            } else {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            }
            pointF.set(c2.x, c2.y);
        }
        if (hVar.d()) {
            path.close();
        }
    }

    public static double i(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float j(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int k(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i + (f2 * (i2 - i)));
    }

    public static void l(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2, j jVar) {
        if (eVar.c(jVar.getName(), i)) {
            list.add(eVar2.a(jVar.getName()).i(jVar));
        }
    }
}
