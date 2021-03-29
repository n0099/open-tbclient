package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f41434a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f41435b;

    @Nullable
    public static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = e().get(i);
        }
        return weakReference;
    }

    public static <T> d.a.a.w.a<T> b(JsonReader jsonReader, d.a.a.d dVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        if (z) {
            return c(dVar, jsonReader, f2, j0Var);
        }
        return d(jsonReader, f2, j0Var);
    }

    public static <T> d.a.a.w.a<T> c(d.a.a.d dVar, JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        boolean z = false;
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        float f3 = 0.0f;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 111) {
                    if (hashCode != 3701) {
                        if (hashCode != 3707) {
                            if (hashCode != 104) {
                                if (hashCode != 105) {
                                    if (hashCode != 115) {
                                        if (hashCode == 116 && nextName.equals("t")) {
                                            c2 = 0;
                                        }
                                    } else if (nextName.equals("s")) {
                                        c2 = 1;
                                    }
                                } else if (nextName.equals("i")) {
                                    c2 = 4;
                                }
                            } else if (nextName.equals("h")) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("to")) {
                            c2 = 6;
                        }
                    } else if (nextName.equals(Config.FEED_LIST_PART)) {
                        c2 = 7;
                    }
                } else if (nextName.equals(Config.OS)) {
                    c2 = 3;
                }
            } else if (nextName.equals("e")) {
                c2 = 2;
            }
            switch (c2) {
                case 0:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t = j0Var.a(jsonReader, f2);
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
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = p.e(jsonReader, f2);
                    break;
                case 7:
                    pointF4 = p.e(jsonReader, f2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = f41434a;
            t2 = t;
        } else if (pointF != null && pointF2 != null) {
            float f4 = -f2;
            pointF.x = d.a.a.v.e.b(pointF.x, f4, f2);
            pointF.y = d.a.a.v.e.b(pointF.y, -100.0f, 100.0f);
            pointF2.x = d.a.a.v.e.b(pointF2.x, f4, f2);
            float b2 = d.a.a.v.e.b(pointF2.y, -100.0f, 100.0f);
            pointF2.y = b2;
            int g2 = d.a.a.v.f.g(pointF.x, pointF.y, pointF2.x, b2);
            WeakReference<Interpolator> a2 = a(g2);
            Interpolator interpolator2 = a2 != null ? a2.get() : null;
            if (a2 == null || interpolator2 == null) {
                interpolator2 = PathInterpolatorCompat.create(pointF.x / f2, pointF.y / f2, pointF2.x / f2, pointF2.y / f2);
                try {
                    f(g2, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolator2;
        } else {
            interpolator = f41434a;
        }
        d.a.a.w.a<T> aVar = new d.a.a.w.a<>(dVar, t, t2, interpolator, f3, null);
        aVar.i = pointF3;
        aVar.j = pointF4;
        return aVar;
    }

    public static <T> d.a.a.w.a<T> d(JsonReader jsonReader, float f2, j0<T> j0Var) throws IOException {
        return new d.a.a.w.a<>(j0Var.a(jsonReader, f2));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> e() {
        if (f41435b == null) {
            f41435b = new SparseArrayCompat<>();
        }
        return f41435b;
    }

    public static void f(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f41435b.put(i, weakReference);
        }
    }
}
