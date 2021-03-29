package d.a.a.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class m implements l, a.InterfaceC0529a, j {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41252a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f41253b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41254c;

    /* renamed from: d  reason: collision with root package name */
    public final PolystarShape.Type f41255d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41256e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41257f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41258g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41259h;
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
        public static final /* synthetic */ int[] f41260a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f41260a = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41260a[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(d.a.a.f fVar, d.a.a.s.k.a aVar, PolystarShape polystarShape) {
        this.f41254c = fVar;
        this.f41253b = polystarShape.d();
        this.f41255d = polystarShape.j();
        this.f41256e = polystarShape.g().a();
        this.f41257f = polystarShape.h().a();
        this.f41258g = polystarShape.i().a();
        this.i = polystarShape.e().a();
        this.k = polystarShape.f().a();
        if (this.f41255d == PolystarShape.Type.Star) {
            this.f41259h = polystarShape.b().a();
            this.j = polystarShape.c().a();
        } else {
            this.f41259h = null;
            this.j = null;
        }
        aVar.h(this.f41256e);
        aVar.h(this.f41257f);
        aVar.h(this.f41258g);
        aVar.h(this.i);
        aVar.h(this.k);
        if (this.f41255d == PolystarShape.Type.Star) {
            aVar.h(this.f41259h);
            aVar.h(this.j);
        }
        this.f41256e.a(this);
        this.f41257f.a(this);
        this.f41258g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.f41255d == PolystarShape.Type.Star) {
            this.f41259h.a(this);
            this.j.a(this);
        }
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
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
            this.f41256e.m(cVar);
        } else if (t == d.a.a.j.p) {
            this.f41258g.m(cVar);
        } else if (t == d.a.a.j.f41187h) {
            this.f41257f.m(cVar);
        } else if (t == d.a.a.j.q && (aVar2 = this.f41259h) != null) {
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
        int floor = (int) Math.floor(this.f41256e.h().floatValue());
        double radians = Math.toRadians((this.f41258g == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floor;
        float floatValue = this.k.h().floatValue() / 100.0f;
        float floatValue2 = this.i.h().floatValue();
        double d6 = floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f41252a.moveTo(cos, sin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d3 = d6;
                i = i2;
                d2 = d8;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f2 = floatValue2 * floatValue * 0.25f;
                this.f41252a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i = i2;
                this.f41252a.lineTo(cos2, sin2);
            }
            d8 = d2 + d4;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF h2 = this.f41257f.h();
        this.f41252a.offset(h2.x, h2.y);
        this.f41252a.close();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41253b;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.m) {
            return this.f41252a;
        }
        this.f41252a.reset();
        int i = a.f41260a[this.f41255d.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            f();
        }
        this.f41252a.close();
        d.a.a.v.f.b(this.f41252a, this.l);
        this.m = true;
        return this.f41252a;
    }

    public final void h() {
        d.a.a.q.b.a<?, Float> aVar;
        double d2;
        int i;
        double d3;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        double d4;
        float f8;
        float f9;
        float f10;
        float floatValue = this.f41256e.h().floatValue();
        double radians = Math.toRadians((this.f41258g == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floatValue;
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i2 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float floatValue2 = this.i.h().floatValue();
        float floatValue3 = this.f41259h.h().floatValue();
        d.a.a.q.b.a<?, Float> aVar2 = this.j;
        float floatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        d.a.a.q.b.a<?, Float> aVar3 = this.k;
        float floatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f4 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i = i2;
            double d6 = f4;
            d2 = d5;
            f2 = (float) (d6 * Math.cos(radians));
            f3 = (float) (d6 * Math.sin(radians));
            this.f41252a.moveTo(f2, f3);
            d3 = radians + ((f11 * f13) / 2.0f);
        } else {
            d2 = d5;
            i = i2;
            double d7 = floatValue2;
            float cos = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.f41252a.moveTo(cos, sin);
            d3 = radians + f12;
            f2 = cos;
            f3 = sin;
            f4 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d8 = i3;
            if (d8 < ceil) {
                float f14 = z ? floatValue2 : floatValue3;
                int i4 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                if (i4 == 0 || d8 != ceil - 2.0d) {
                    f5 = f11;
                    f6 = f12;
                } else {
                    f5 = f11;
                    f6 = (f11 * f13) / 2.0f;
                }
                if (i4 == 0 || d8 != ceil - 1.0d) {
                    f7 = f12;
                    d4 = d8;
                    f8 = f14;
                } else {
                    f7 = f12;
                    d4 = d8;
                    f8 = f4;
                }
                double d9 = f8;
                double d10 = ceil;
                float cos2 = (float) (d9 * Math.cos(d3));
                float sin2 = (float) (d9 * Math.sin(d3));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f41252a.lineTo(cos2, sin2);
                    f9 = floatValue4;
                    f10 = f4;
                } else {
                    f9 = floatValue4;
                    f10 = f4;
                    double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f15 = z ? f9 : floatValue5;
                    float f16 = z ? floatValue5 : f9;
                    float f17 = (z ? floatValue3 : floatValue2) * f15 * 0.47829f;
                    float f18 = cos3 * f17;
                    float f19 = f17 * sin3;
                    float f20 = (z ? floatValue2 : floatValue3) * f16 * 0.47829f;
                    float f21 = cos4 * f20;
                    float f22 = f20 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f18 *= f13;
                            f19 *= f13;
                        } else if (d4 == d10 - 1.0d) {
                            f21 *= f13;
                            f22 *= f13;
                        }
                    }
                    this.f41252a.cubicTo(f2 - f18, f3 - f19, cos2 + f21, sin2 + f22, cos2, sin2);
                }
                d3 += f6;
                z = !z;
                i3++;
                f2 = cos2;
                f3 = sin2;
                floatValue4 = f9;
                f4 = f10;
                f12 = f7;
                f11 = f5;
                ceil = d10;
            } else {
                PointF h2 = this.f41257f.h();
                this.f41252a.offset(h2.x, h2.y);
                this.f41252a.close();
                return;
            }
        }
    }

    public final void i() {
        this.m = false;
        this.f41254c.invalidateSelf();
    }
}
