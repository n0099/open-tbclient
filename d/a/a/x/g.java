package d.a.a.x;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import d.a.a.s.b.k;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static PointF f41793a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }

    public static float c(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static int f(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int g(float f2, float f3) {
        return h((int) f2, (int) f3);
    }

    public static int h(int i, int i2) {
        return i - (i2 * f(i, i2));
    }

    public static void i(d.a.a.u.j.h hVar, Path path) {
        path.reset();
        PointF b2 = hVar.b();
        path.moveTo(b2.x, b2.y);
        f41793a.set(b2.x, b2.y);
        for (int i = 0; i < hVar.a().size(); i++) {
            d.a.a.u.a aVar = hVar.a().get(i);
            PointF a2 = aVar.a();
            PointF b3 = aVar.b();
            PointF c2 = aVar.c();
            if (a2.equals(f41793a) && b3.equals(c2)) {
                path.lineTo(c2.x, c2.y);
            } else {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            }
            f41793a.set(c2.x, c2.y);
        }
        if (hVar.d()) {
            path.close();
        }
    }

    public static double j(double d2, double d3, @FloatRange(from = 0.0d, to = 1.0d) double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float k(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int l(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (int) (i + (f2 * (i2 - i)));
    }

    public static void m(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2, k kVar) {
        if (dVar.c(kVar.getName(), i)) {
            list.add(dVar2.a(kVar.getName()).i(kVar));
        }
    }
}
