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
/* loaded from: classes3.dex */
class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f7979a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f7980b;

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (f7980b == null) {
            f7980b = new SparseArrayCompat<>();
        }
        return f7980b;
    }

    private static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, float f, aj<T> ajVar) {
        return new com.ksad.lottie.e.a<>(ajVar.b(jsonReader, f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.ksad.lottie.e.a<T> a(JsonReader jsonReader, com.ksad.lottie.d dVar, float f, aj<T> ajVar, boolean z) {
        return z ? a(dVar, jsonReader, f, ajVar) : a(jsonReader, f, ajVar);
    }

    private static <T> com.ksad.lottie.e.a<T> a(com.ksad.lottie.d dVar, JsonReader jsonReader, float f, aj<T> ajVar) {
        Interpolator interpolator;
        T t;
        PointF b2;
        PointF pointF;
        T t2;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f2 = 0.0f;
        T t3 = null;
        T t4 = null;
        boolean z = false;
        PointF pointF4 = null;
        PointF pointF5 = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 5;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
                        c = 4;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 1;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3701:
                    if (nextName.equals(Config.FEED_LIST_PART)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3707:
                    if (nextName.equals("to")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 1:
                    t3 = ajVar.b(jsonReader, f);
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 2:
                    t2 = ajVar.b(jsonReader, f);
                    b2 = pointF5;
                    pointF = pointF4;
                    break;
                case 3:
                    pointF2 = p.b(jsonReader, f);
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 4:
                    pointF3 = p.b(jsonReader, f);
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 6:
                    pointF = p.b(jsonReader, f);
                    b2 = pointF5;
                    t2 = t4;
                    break;
                case 7:
                    b2 = p.b(jsonReader, f);
                    pointF = pointF4;
                    t2 = t4;
                    break;
                default:
                    jsonReader.skipValue();
                    b2 = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
            }
            pointF5 = b2;
            pointF4 = pointF;
            t4 = t2;
        }
        jsonReader.endObject();
        if (z) {
            interpolator = f7979a;
            t = t3;
        } else if (pointF2 == null || pointF3 == null) {
            interpolator = f7979a;
            t = t4;
        } else {
            pointF2.x = com.ksad.lottie.d.e.b(pointF2.x, -f, f);
            pointF2.y = com.ksad.lottie.d.e.b(pointF2.y, -100.0f, 100.0f);
            pointF3.x = com.ksad.lottie.d.e.b(pointF3.x, -f, f);
            pointF3.y = com.ksad.lottie.d.e.b(pointF3.y, -100.0f, 100.0f);
            int a2 = com.ksad.lottie.d.f.a(pointF2.x, pointF2.y, pointF3.x, pointF3.y);
            WeakReference<Interpolator> a3 = a(a2);
            Interpolator interpolator2 = a3 != null ? a3.get() : null;
            if (a3 == null || interpolator2 == null) {
                interpolator2 = PathInterpolatorCompat.create(pointF2.x / f, pointF2.y / f, pointF3.x / f, pointF3.y / f);
                try {
                    a(a2, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            interpolator = interpolator2;
            t = t4;
        }
        com.ksad.lottie.e.a<T> aVar = new com.ksad.lottie.e.a<>(dVar, t3, t, interpolator, f2, null);
        aVar.f = pointF4;
        aVar.g = pointF5;
        return aVar;
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = a().get(i);
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f7980b.put(i, weakReference);
        }
    }
}
