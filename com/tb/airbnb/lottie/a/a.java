package com.tb.airbnb.lottie.a;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.c.b;
import com.tb.airbnb.lottie.c.f;
import com.tb.airbnb.lottie.e;
import com.tb.airbnb.lottie.model.a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<T> {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private final e composition;
    public final float ed;
    @Nullable
    public final T kn;
    @Nullable
    public final T ko;
    @Nullable
    public final Interpolator kp;
    @Nullable
    public Float kq;
    private float kr = Float.MIN_VALUE;
    private float ks = Float.MIN_VALUE;

    public static void g(List<? extends a<?>> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            list.get(i2).kq = Float.valueOf(list.get(i2 + 1).ed);
            i = i2 + 1;
        }
        a<?> aVar = list.get(size - 1);
        if (aVar.kn == null) {
            list.remove(aVar);
        }
    }

    public a(e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.composition = eVar;
        this.kn = t;
        this.ko = t2;
        this.kp = interpolator;
        this.ed = f;
        this.kq = f2;
    }

    public float di() {
        if (this.kr == Float.MIN_VALUE) {
            this.kr = (this.ed - ((float) this.composition.dAX())) / this.composition.bn();
        }
        return this.kr;
    }

    public float bV() {
        if (this.ks == Float.MIN_VALUE) {
            if (this.kq == null) {
                this.ks = 1.0f;
            } else {
                this.ks = di() + ((this.kq.floatValue() - this.ed) / this.composition.bn());
            }
        }
        return this.ks;
    }

    public boolean dL() {
        return this.kp == null;
    }

    public boolean n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= di() && f < bV();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.kn + ", endValue=" + this.ko + ", startFrame=" + this.ed + ", endFrame=" + this.kq + ", interpolator=" + this.kp + '}';
    }

    /* renamed from: com.tb.airbnb.lottie.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0685a {
        private static SparseArrayCompat<WeakReference<Interpolator>> jV;

        private static SparseArrayCompat<WeakReference<Interpolator>> dA() {
            if (jV == null) {
                jV = new SparseArrayCompat<>();
            }
            return jV;
        }

        @Nullable
        private static WeakReference<Interpolator> l(int i) {
            WeakReference<Interpolator> weakReference;
            synchronized (C0685a.class) {
                weakReference = dA().get(i);
            }
            return weakReference;
        }

        private static void a(int i, WeakReference<Interpolator> weakReference) {
            synchronized (C0685a.class) {
                jV.put(i, weakReference);
            }
        }

        private C0685a() {
        }

        public static <T> a<T> a(JSONObject jSONObject, e eVar, float f, m.a<T> aVar) {
            T c;
            Interpolator interpolator;
            T t;
            PointF pointF;
            PointF pointF2;
            Interpolator interpolator2;
            float f2 = 0.0f;
            if (jSONObject.has("t")) {
                f2 = (float) jSONObject.optDouble("t", 0.0d);
                Object opt = jSONObject.opt("s");
                T c2 = opt != null ? aVar.c(opt, f) : null;
                Object opt2 = jSONObject.opt("e");
                T c3 = opt2 != null ? aVar.c(opt2, f) : null;
                JSONObject optJSONObject = jSONObject.optJSONObject(Config.OS);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("i");
                if (optJSONObject == null || optJSONObject2 == null) {
                    pointF = null;
                    pointF2 = null;
                } else {
                    PointF a = b.a(optJSONObject, f);
                    PointF a2 = b.a(optJSONObject2, f);
                    pointF2 = a;
                    pointF = a2;
                }
                if (jSONObject.optInt("h", 0) == 1) {
                    interpolator2 = a.LINEAR_INTERPOLATOR;
                    c3 = c2;
                } else if (pointF2 == null) {
                    interpolator2 = a.LINEAR_INTERPOLATOR;
                } else {
                    pointF2.x = com.tb.airbnb.lottie.c.e.clamp(pointF2.x, -f, f);
                    pointF2.y = com.tb.airbnb.lottie.c.e.clamp(pointF2.y, -100.0f, 100.0f);
                    pointF.x = com.tb.airbnb.lottie.c.e.clamp(pointF.x, -f, f);
                    pointF.y = com.tb.airbnb.lottie.c.e.clamp(pointF.y, -100.0f, 100.0f);
                    int c4 = f.c(pointF2.x, pointF2.y, pointF.x, pointF.y);
                    WeakReference<Interpolator> l = l(c4);
                    interpolator2 = l != null ? l.get() : null;
                    if (l == null || interpolator2 == null) {
                        interpolator2 = PathInterpolatorCompat.create(pointF2.x / f, pointF2.y / f, pointF.x / f, pointF.y / f);
                        try {
                            a(c4, new WeakReference(interpolator2));
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
                interpolator = interpolator2;
                c = c3;
                t = c2;
            } else {
                c = aVar.c(jSONObject, f);
                interpolator = null;
                t = c;
            }
            return new a<>(eVar, t, c, interpolator, f2, null);
        }

        public static <T> List<a<T>> a(JSONArray jSONArray, e eVar, float f, m.a<T> aVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i), eVar, f, aVar));
            }
            a.g(arrayList);
            return arrayList;
        }
    }
}
