package d.a.a.y;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.d f41800a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f41801b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public T f41802c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f41803d;

    /* renamed from: e  reason: collision with root package name */
    public final float f41804e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f41805f;

    /* renamed from: g  reason: collision with root package name */
    public float f41806g;

    /* renamed from: h  reason: collision with root package name */
    public float f41807h;
    public int i;
    public int j;
    public float k;
    public float l;
    public PointF m;
    public PointF n;

    public a(d.a.a.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f41806g = -3987645.8f;
        this.f41807h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f41800a = dVar;
        this.f41801b = t;
        this.f41802c = t2;
        this.f41803d = interpolator;
        this.f41804e = f2;
        this.f41805f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.f41800a == null) {
            return 1.0f;
        }
        if (this.l == Float.MIN_VALUE) {
            if (this.f41805f == null) {
                this.l = 1.0f;
            } else {
                this.l = e() + ((this.f41805f.floatValue() - this.f41804e) / this.f41800a.e());
            }
        }
        return this.l;
    }

    public float c() {
        if (this.f41807h == -3987645.8f) {
            this.f41807h = ((Float) this.f41802c).floatValue();
        }
        return this.f41807h;
    }

    public int d() {
        if (this.j == 784923401) {
            this.j = ((Integer) this.f41802c).intValue();
        }
        return this.j;
    }

    public float e() {
        d.a.a.d dVar = this.f41800a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.f41804e - dVar.o()) / this.f41800a.e();
        }
        return this.k;
    }

    public float f() {
        if (this.f41806g == -3987645.8f) {
            this.f41806g = ((Float) this.f41801b).floatValue();
        }
        return this.f41806g;
    }

    public int g() {
        if (this.i == 784923401) {
            this.i = ((Integer) this.f41801b).intValue();
        }
        return this.i;
    }

    public boolean h() {
        return this.f41803d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f41801b + ", endValue=" + this.f41802c + ", startFrame=" + this.f41804e + ", endFrame=" + this.f41805f + ", interpolator=" + this.f41803d + '}';
    }

    public a(T t) {
        this.f41806g = -3987645.8f;
        this.f41807h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f41800a = null;
        this.f41801b = t;
        this.f41802c = t;
        this.f41803d = null;
        this.f41804e = Float.MIN_VALUE;
        this.f41805f = Float.valueOf(Float.MAX_VALUE);
    }
}
