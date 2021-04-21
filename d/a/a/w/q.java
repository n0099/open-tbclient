package d.a.a.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f41865b;

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f41864a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static JsonReader.a f41866c = JsonReader.a.a("t", "s", "e", Config.OS, "i", "h", "to", Config.FEED_LIST_PART);

    @Nullable
    public static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = e().get(i);
        }
        return weakReference;
    }

    public static <T> d.a.a.y.a<T> b(JsonReader jsonReader, d.a.a.d dVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        if (z) {
            return c(dVar, jsonReader, f2, j0Var);
        }
        return d(jsonReader, f2, j0Var);
    }

    public static <T> d.a.a.y.a<T> c(d.a.a.d dVar, JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator linearInterpolator;
        jsonReader.o();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41866c)) {
                case 0:
                    f3 = (float) jsonReader.w();
                    break;
                case 1:
                    t3 = j0Var.a(jsonReader, f2);
                    break;
                case 2:
                    t2 = j0Var.a(jsonReader, f2);
                    break;
                case 3:
                    pointF = p.e(jsonReader, f2);
                    break;
                case 4:
                    pointF2 = p.e(jsonReader, f2);
                    break;
                case 5:
                    if (jsonReader.x() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF4 = p.e(jsonReader, f2);
                    break;
                case 7:
                    pointF3 = p.e(jsonReader, f2);
                    break;
                default:
                    jsonReader.F();
                    break;
            }
        }
        jsonReader.r();
        if (z) {
            interpolator = f41864a;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                float f4 = -f2;
                pointF.x = d.a.a.x.g.c(pointF.x, f4, f2);
                pointF.y = d.a.a.x.g.c(pointF.y, -100.0f, 100.0f);
                pointF2.x = d.a.a.x.g.c(pointF2.x, f4, f2);
                float c2 = d.a.a.x.g.c(pointF2.y, -100.0f, 100.0f);
                pointF2.y = c2;
                int i = d.a.a.x.h.i(pointF.x, pointF.y, pointF2.x, c2);
                WeakReference<Interpolator> a2 = a(i);
                Interpolator interpolator2 = a2 != null ? a2.get() : null;
                if (a2 == null || interpolator2 == null) {
                    pointF.x /= f2;
                    pointF.y /= f2;
                    float f5 = pointF2.x / f2;
                    pointF2.x = f5;
                    float f6 = pointF2.y / f2;
                    pointF2.y = f6;
                    try {
                        linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, f5, f6);
                    } catch (IllegalArgumentException e2) {
                        if (e2.getMessage().equals("The Path cannot loop back on itself.")) {
                            linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                        } else {
                            linearInterpolator = new LinearInterpolator();
                        }
                    }
                    interpolator2 = linearInterpolator;
                    try {
                        f(i, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            } else {
                interpolator = f41864a;
            }
            t = t2;
        }
        d.a.a.y.a<T> aVar = new d.a.a.y.a<>(dVar, t3, t, interpolator, f3, null);
        aVar.m = pointF4;
        aVar.n = pointF3;
        return aVar;
    }

    public static <T> d.a.a.y.a<T> d(JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        return new d.a.a.y.a<>(j0Var.a(jsonReader, f2));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> e() {
        if (f41865b == null) {
            f41865b = new SparseArrayCompat<>();
        }
        return f41865b;
    }

    public static void f(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f41865b.put(i, weakReference);
        }
    }
}
