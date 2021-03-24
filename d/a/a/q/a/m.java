package d.a.a.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class m implements l, a.InterfaceC0528a, j {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41251a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f41252b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41253c;

    /* renamed from: d  reason: collision with root package name */
    public final PolystarShape.Type f41254d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41255e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41256f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41257g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41258h;
    public final d.a.a.q.b.a<?, Float> i;
    @Nullable
    public final d.a.a.q.b.a<?, Float> j;
    public final d.a.a.q.b.a<?, Float> k;
    @Nullable
    public r l;
    public boolean m;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41259a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f41259a = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41259a[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(d.a.a.f fVar, d.a.a.s.k.a aVar, PolystarShape polystarShape) {
        this.f41253c = fVar;
        this.f41252b = polystarShape.d();
        this.f41254d = polystarShape.j();
        this.f41255e = polystarShape.g().a();
        this.f41256f = polystarShape.h().a();
        this.f41257g = polystarShape.i().a();
        this.i = polystarShape.e().a();
        this.k = polystarShape.f().a();
        if (this.f41254d == PolystarShape.Type.Star) {
            this.f41258h = polystarShape.b().a();
            this.j = polystarShape.c().a();
        } else {
            this.f41258h = null;
            this.j = null;
        }
        aVar.h(this.f41255e);
        aVar.h(this.f41256f);
        aVar.h(this.f41257g);
        aVar.h(this.i);
        aVar.h(this.k);
        if (this.f41254d == PolystarShape.Type.Star) {
            aVar.h(this.f41258h);
            aVar.h(this.j);
        }
        this.f41255e.a(this);
        this.f41256f.a(this);
        this.f41257g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.f41254d == PolystarShape.Type.Star) {
            this.f41258h.a(this);
            this.j.a(this);
        }
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        i();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.i() == ShapeTrimPath.Type.Simultaneously) {
                    this.l = rVar;
                    rVar.d(this);
                }
            }
        }
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        d.a.a.q.b.a<?, Float> aVar;
        d.a.a.q.b.a<?, Float> aVar2;
        if (t == d.a.a.j.o) {
            this.f41255e.m(cVar);
        } else if (t == d.a.a.j.p) {
            this.f41257g.m(cVar);
        } else if (t == d.a.a.j.f41186h) {
            this.f41256f.m(cVar);
        } else if (t == d.a.a.j.q && (aVar2 = this.f41258h) != null) {
            aVar2.m(cVar);
        } else if (t == d.a.a.j.r) {
            this.i.m(cVar);
        } else if (t == d.a.a.j.s && (aVar = this.j) != null) {
            aVar.m(cVar);
        } else if (t == d.a.a.j.t) {
            this.k.m(cVar);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    public final void f() {
        d.a.a.q.b.a<?, Float> aVar;
        double d2;
        double d3;
        double d4;
        int i;
        int floor = (int) Math.floor(this.f41255e.h().floatValue());
        double radians = Math.toRadians((this.f41257g == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floor;
        Double.isNaN(d5);
        float floatValue = this.k.h().floatValue() / 100.0f;
        float floatValue2 = this.i.h().floatValue();
        double d6 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.f41251a.moveTo(f2, f3);
        double d7 = (float) (6.283185307179586d / d5);
        Double.isNaN(d7);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i2 = 0;
        while (i2 < ceil) {
            double cos2 = Math.cos(d8);
            Double.isNaN(d6);
            float f4 = (float) (cos2 * d6);
            double sin2 = Math.sin(d8);
            Double.isNaN(d6);
            double d9 = ceil;
            float f5 = (float) (d6 * sin2);
            if (floatValue != 0.0f) {
                d3 = d6;
                i = i2;
                d2 = d8;
                double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float f6 = floatValue2 * floatValue * 0.25f;
                this.f41251a.cubicTo(f2 - (cos3 * f6), f3 - (((float) Math.sin(atan2)) * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i = i2;
                this.f41251a.lineTo(f4, f5);
            }
            Double.isNaN(d4);
            d8 = d2 + d4;
            i2 = i + 1;
            f3 = f5;
            f2 = f4;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF h2 = this.f41256f.h();
        this.f41251a.offset(h2.x, h2.y);
        this.f41251a.close();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41252b;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.m) {
            return this.f41251a;
        }
        this.f41251a.reset();
        int i = a.f41259a[this.f41254d.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            f();
        }
        this.f41251a.close();
        d.a.a.v.f.b(this.f41251a, this.l);
        this.m = true;
        return this.f41251a;
    }

    public final void h() {
        d.a.a.q.b.a<?, Float> aVar;
        double d2;
        float f2;
        float f3;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        double d4;
        float f12;
        float f13;
        float floatValue = this.f41255e.h().floatValue();
        double radians = Math.toRadians((this.f41257g == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floatValue;
        Double.isNaN(d5);
        float f14 = (float) (6.283185307179586d / d5);
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((int) floatValue);
        if (f16 != 0.0f) {
            double d6 = (1.0f - f16) * f15;
            Double.isNaN(d6);
            radians += d6;
        }
        float floatValue2 = this.i.h().floatValue();
        float floatValue3 = this.f41258h.h().floatValue();
        d.a.a.q.b.a<?, Float> aVar2 = this.j;
        float floatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        d.a.a.q.b.a<?, Float> aVar3 = this.k;
        float floatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (f16 != 0.0f) {
            float f17 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            double d7 = f17;
            double cos = Math.cos(radians);
            Double.isNaN(d7);
            d2 = d5;
            float f18 = (float) (d7 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d7);
            float f19 = (float) (d7 * sin);
            this.f41251a.moveTo(f18, f19);
            double d8 = (f14 * f16) / 2.0f;
            Double.isNaN(d8);
            d3 = radians + d8;
            f4 = f18;
            f6 = f17;
            f2 = floatValue2;
            f5 = f19;
            f3 = f15;
        } else {
            d2 = d5;
            f2 = floatValue2;
            double d9 = f2;
            double cos2 = Math.cos(radians);
            Double.isNaN(d9);
            f3 = f15;
            f4 = (float) (d9 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d9);
            f5 = (float) (d9 * sin2);
            this.f41251a.moveTo(f4, f5);
            double d10 = f3;
            Double.isNaN(d10);
            d3 = radians + d10;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f20 = floatValue5;
        boolean z = false;
        while (true) {
            double d11 = i;
            if (d11 < ceil) {
                float f21 = z ? f2 : floatValue3;
                float f22 = (f6 == 0.0f || d11 != ceil - 2.0d) ? f3 : (f14 * f16) / 2.0f;
                if (f6 == 0.0f || d11 != ceil - 1.0d) {
                    f7 = f14;
                    f8 = f21;
                    f9 = f2;
                } else {
                    f7 = f14;
                    f9 = f2;
                    f8 = f6;
                }
                double d12 = f8;
                double cos3 = Math.cos(d3);
                Double.isNaN(d12);
                float f23 = (float) (d12 * cos3);
                double sin3 = Math.sin(d3);
                Double.isNaN(d12);
                float f24 = (float) (d12 * sin3);
                if (floatValue4 == 0.0f && f20 == 0.0f) {
                    this.f41251a.lineTo(f23, f24);
                    d4 = d3;
                    f10 = floatValue3;
                    f11 = floatValue4;
                    f12 = f3;
                    f13 = f22;
                } else {
                    f10 = floatValue3;
                    f11 = floatValue4;
                    double atan2 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    d4 = d3;
                    f12 = f3;
                    f13 = f22;
                    double atan22 = (float) (Math.atan2(f24, f23) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f25 = z ? f11 : f20;
                    float f26 = z ? f20 : f11;
                    float f27 = (z ? f10 : f9) * f25 * 0.47829f;
                    float f28 = cos4 * f27;
                    float f29 = f27 * sin4;
                    float f30 = (z ? f9 : f10) * f26 * 0.47829f;
                    float f31 = cos5 * f30;
                    float f32 = f30 * sin5;
                    if (f16 != 0.0f) {
                        if (i == 0) {
                            f28 *= f16;
                            f29 *= f16;
                        } else if (d11 == ceil - 1.0d) {
                            f31 *= f16;
                            f32 *= f16;
                        }
                    }
                    this.f41251a.cubicTo(f4 - f28, f5 - f29, f23 + f31, f24 + f32, f23, f24);
                }
                double d13 = f13;
                Double.isNaN(d13);
                z = !z;
                i++;
                f5 = f24;
                d3 = d4 + d13;
                f3 = f12;
                f4 = f23;
                f2 = f9;
                f14 = f7;
                floatValue3 = f10;
                floatValue4 = f11;
            } else {
                PointF h2 = this.f41256f.h();
                this.f41251a.offset(h2.x, h2.y);
                this.f41251a.close();
                return;
            }
        }
    }

    public final void i() {
        this.m = false;
        this.f41253c.invalidateSelf();
    }
}
