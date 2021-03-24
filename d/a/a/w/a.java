package d.a.a.w;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.d f41449a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f41450b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final T f41451c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f41452d;

    /* renamed from: e  reason: collision with root package name */
    public final float f41453e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f41454f;

    /* renamed from: g  reason: collision with root package name */
    public float f41455g;

    /* renamed from: h  reason: collision with root package name */
    public float f41456h;
    public PointF i;
    public PointF j;

    public a(d.a.a.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f41455g = Float.MIN_VALUE;
        this.f41456h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.f41449a = dVar;
        this.f41450b = t;
        this.f41451c = t2;
        this.f41452d = interpolator;
        this.f41453e = f2;
        this.f41454f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= c() && f2 < b();
    }

    public float b() {
        if (this.f41449a == null) {
            return 1.0f;
        }
        if (this.f41456h == Float.MIN_VALUE) {
            if (this.f41454f == null) {
                this.f41456h = 1.0f;
            } else {
                this.f41456h = c() + ((this.f41454f.floatValue() - this.f41453e) / this.f41449a.e());
            }
        }
        return this.f41456h;
    }

    public float c() {
        d.a.a.d dVar = this.f41449a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f41455g == Float.MIN_VALUE) {
            this.f41455g = (this.f41453e - dVar.m()) / this.f41449a.e();
        }
        return this.f41455g;
    }

    public boolean d() {
        return this.f41452d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f41450b + ", endValue=" + this.f41451c + ", startFrame=" + this.f41453e + ", endFrame=" + this.f41454f + ", interpolator=" + this.f41452d + '}';
    }

    public a(T t) {
        this.f41455g = Float.MIN_VALUE;
        this.f41456h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.f41449a = null;
        this.f41450b = t;
        this.f41451c = t;
        this.f41452d = null;
        this.f41453e = Float.MIN_VALUE;
        this.f41454f = Float.valueOf(Float.MAX_VALUE);
    }
}
