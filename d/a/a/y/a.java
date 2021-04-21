package d.a.a.y;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.d f41895a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f41896b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public T f41897c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f41898d;

    /* renamed from: e  reason: collision with root package name */
    public final float f41899e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f41900f;

    /* renamed from: g  reason: collision with root package name */
    public float f41901g;

    /* renamed from: h  reason: collision with root package name */
    public float f41902h;
    public int i;
    public int j;
    public float k;
    public float l;
    public PointF m;
    public PointF n;

    public a(d.a.a.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f41901g = -3987645.8f;
        this.f41902h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f41895a = dVar;
        this.f41896b = t;
        this.f41897c = t2;
        this.f41898d = interpolator;
        this.f41899e = f2;
        this.f41900f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.f41895a == null) {
            return 1.0f;
        }
        if (this.l == Float.MIN_VALUE) {
            if (this.f41900f == null) {
                this.l = 1.0f;
            } else {
                this.l = e() + ((this.f41900f.floatValue() - this.f41899e) / this.f41895a.e());
            }
        }
        return this.l;
    }

    public float c() {
        if (this.f41902h == -3987645.8f) {
            this.f41902h = ((Float) this.f41897c).floatValue();
        }
        return this.f41902h;
    }

    public int d() {
        if (this.j == 784923401) {
            this.j = ((Integer) this.f41897c).intValue();
        }
        return this.j;
    }

    public float e() {
        d.a.a.d dVar = this.f41895a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.f41899e - dVar.o()) / this.f41895a.e();
        }
        return this.k;
    }

    public float f() {
        if (this.f41901g == -3987645.8f) {
            this.f41901g = ((Float) this.f41896b).floatValue();
        }
        return this.f41901g;
    }

    public int g() {
        if (this.i == 784923401) {
            this.i = ((Integer) this.f41896b).intValue();
        }
        return this.i;
    }

    public boolean h() {
        return this.f41898d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f41896b + ", endValue=" + this.f41897c + ", startFrame=" + this.f41899e + ", endFrame=" + this.f41900f + ", interpolator=" + this.f41898d + '}';
    }

    public a(T t) {
        this.f41901g = -3987645.8f;
        this.f41902h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.f41895a = null;
        this.f41896b = t;
        this.f41897c = t;
        this.f41898d = null;
        this.f41899e = Float.MIN_VALUE;
        this.f41900f = Float.valueOf(Float.MAX_VALUE);
    }
}
