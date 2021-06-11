package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.mobstat.Config;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f31871a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f31872b;

    public static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (f31872b == null) {
            f31872b = new SparseArrayCompat<>();
        }
        return f31872b;
    }

    public static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, float f2, aj<T> ajVar) {
        return new com.ksad.lottie.e.a<>(ajVar.b(jsonReader, f2));
    }

    public static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, com.ksad.lottie.d dVar, float f2, aj<T> ajVar, boolean z) {
        return z ? a(dVar, jsonReader, f2, ajVar) : a(jsonReader, f2, ajVar);
    }

    public static <T> com.ksad.lottie.e.a<T> a(com.ksad.lottie.d dVar, JsonReader jsonReader, float f2, aj<T> ajVar) {
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
                    t = ajVar.b(jsonReader, f2);
                    break;
                case 2:
                    t2 = ajVar.b(jsonReader, f2);
                    break;
                case 3:
                    pointF = p.b(jsonReader, f2);
                    break;
                case 4:
                    pointF2 = p.b(jsonReader, f2);
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
                    pointF3 = p.b(jsonReader, f2);
                    break;
                case 7:
                    pointF4 = p.b(jsonReader, f2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = f31871a;
            t2 = t;
        } else if (pointF == null || pointF2 == null) {
            interpolator = f31871a;
        } else {
            float f4 = -f2;
            pointF.x = com.ksad.lottie.d.e.b(pointF.x, f4, f2);
            pointF.y = com.ksad.lottie.d.e.b(pointF.y, -100.0f, 100.0f);
            pointF2.x = com.ksad.lottie.d.e.b(pointF2.x, f4, f2);
            float b2 = com.ksad.lottie.d.e.b(pointF2.y, -100.0f, 100.0f);
            pointF2.y = b2;
            int a2 = com.ksad.lottie.d.f.a(pointF.x, pointF.y, pointF2.x, b2);
            WeakReference<Interpolator> a3 = a(a2);
            Interpolator interpolator2 = a3 != null ? a3.get() : null;
            if (a3 == null || interpolator2 == null) {
                interpolator2 = PathInterpolatorCompat.create(pointF.x / f2, pointF.y / f2, pointF2.x / f2, pointF2.y / f2);
                try {
                    a(a2, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolator2;
        }
        com.ksad.lottie.e.a<T> aVar = new com.ksad.lottie.e.a<>(dVar, t, t2, interpolator, f3, null);
        aVar.f31918f = pointF3;
        aVar.f31919g = pointF4;
        return aVar;
    }

    @Nullable
    public static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = a().get(i2);
        }
        return weakReference;
    }

    public static void a(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f31872b.put(i2, weakReference);
        }
    }
}
