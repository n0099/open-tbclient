package d.a.a.v;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import d.a.a.q.a.r;
import java.io.Closeable;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final PathMeasure f41443a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    public static final Path f41444b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public static final Path f41445c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f41446d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    public static final float f41447e = (float) Math.sqrt(2.0d);

    /* renamed from: f  reason: collision with root package name */
    public static float f41448f = -1.0f;

    public static void a(Path path, float f2, float f3, float f4) {
        d.a.a.c.a("applyTrimPathIfNeeded");
        f41443a.setPath(path, false);
        float length = f41443a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            d.a.a.c.c("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = e.f(min, length);
                max = e.f(max, length);
            }
            if (min < 0.0f) {
                min = e.f(min, length);
            }
            if (max < 0.0f) {
                max = e.f(max, length);
            }
            if (min == max) {
                path.reset();
                d.a.a.c.c("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            f41444b.reset();
            f41443a.getSegment(min, max, f41444b, true);
            if (max > length) {
                f41445c.reset();
                f41443a.getSegment(0.0f, max % length, f41445c, true);
                f41444b.addPath(f41445c);
            } else if (min < 0.0f) {
                f41445c.reset();
                f41443a.getSegment(min + length, length, f41445c, true);
                f41444b.addPath(f41445c);
            }
            path.set(f41444b);
            d.a.a.c.c("applyTrimPathIfNeeded");
        } else {
            d.a.a.c.c("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, @Nullable r rVar) {
        if (rVar == null) {
            return;
        }
        a(path, rVar.h().h().floatValue() / 100.0f, rVar.e().h().floatValue() / 100.0f, rVar.f().h().floatValue() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f2 = pointF.x;
            float f3 = pointF2.x;
            float f4 = pointF2.y;
            path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float e() {
        if (f41448f == -1.0f) {
            f41448f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f41448f;
    }

    public static float f(Matrix matrix) {
        float[] fArr = f41446d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f41447e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = f41446d;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static int g(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (((float) PayBeanFactory.BEAN_ID_WIDTHDRAW) * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (i * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i * 31 * f5) : i;
    }

    public static boolean h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }
}
