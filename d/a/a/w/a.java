package d.a.a.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.d f41450a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f41451b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final T f41452c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f41453d;

    /* renamed from: e  reason: collision with root package name */
    public final float f41454e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f41455f;

    /* renamed from: g  reason: collision with root package name */
    public float f41456g;

    /* renamed from: h  reason: collision with root package name */
    public float f41457h;
    public PointF i;
    public PointF j;

    public a(d.a.a.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f41456g = Float.MIN_VALUE;
        this.f41457h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.f41450a = dVar;
        this.f41451b = t;
        this.f41452c = t2;
        this.f41453d = interpolator;
        this.f41454e = f2;
        this.f41455f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= c() && f2 < b();
    }

    public float b() {
        if (this.f41450a == null) {
            return 1.0f;
        }
        if (this.f41457h == Float.MIN_VALUE) {
            if (this.f41455f == null) {
                this.f41457h = 1.0f;
            } else {
                this.f41457h = c() + ((this.f41455f.floatValue() - this.f41454e) / this.f41450a.e());
            }
        }
        return this.f41457h;
    }

    public float c() {
        d.a.a.d dVar = this.f41450a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f41456g == Float.MIN_VALUE) {
            this.f41456g = (this.f41454e - dVar.m()) / this.f41450a.e();
        }
        return this.f41456g;
    }

    public boolean d() {
        return this.f41453d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f41451b + ", endValue=" + this.f41452c + ", startFrame=" + this.f41454e + ", endFrame=" + this.f41455f + ", interpolator=" + this.f41453d + '}';
    }

    public a(T t) {
        this.f41456g = Float.MIN_VALUE;
        this.f41457h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.f41450a = null;
        this.f41451b = t;
        this.f41452c = t;
        this.f41453d = null;
        this.f41454e = Float.MIN_VALUE;
        this.f41455f = Float.valueOf(Float.MAX_VALUE);
    }
}
