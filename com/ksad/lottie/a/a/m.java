package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.PolystarShape;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class m implements j, l, a.InterfaceC1037a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8244a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f8245b;
    private final com.ksad.lottie.f c;
    private final PolystarShape.Type d;
    private final com.ksad.lottie.a.b.a<?, Float> e;
    private final com.ksad.lottie.a.b.a<?, PointF> f;
    private final com.ksad.lottie.a.b.a<?, Float> g;
    @Nullable
    private final com.ksad.lottie.a.b.a<?, Float> h;
    private final com.ksad.lottie.a.b.a<?, Float> i;
    @Nullable
    private final com.ksad.lottie.a.b.a<?, Float> j;
    private final com.ksad.lottie.a.b.a<?, Float> k;
    @Nullable
    private r l;
    private boolean m;

    public m(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.c = fVar;
        this.f8245b = polystarShape.a();
        this.d = polystarShape.b();
        this.e = polystarShape.c().a();
        this.f = polystarShape.d().a();
        this.g = polystarShape.e().a();
        this.i = polystarShape.g().a();
        this.k = polystarShape.i().a();
        if (this.d == PolystarShape.Type.Star) {
            this.h = polystarShape.f().a();
            this.j = polystarShape.h().a();
        } else {
            this.h = null;
            this.j = null;
        }
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.i);
        aVar.a(this.k);
        if (this.d == PolystarShape.Type.Star) {
            aVar.a(this.h);
            aVar.a(this.j);
        }
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.d == PolystarShape.Type.Star) {
            this.h.a(this);
            this.j.a(this);
        }
    }

    private void b() {
        this.m = false;
        this.c.invalidateSelf();
    }

    private void c() {
        float sin;
        double d;
        float f;
        float f2;
        float f3;
        float f4;
        float floatValue = this.e.e().floatValue();
        double radians = Math.toRadians((this.g == null ? 0.0d : this.g.e().floatValue()) - 90.0d);
        float f5 = (float) (6.283185307179586d / floatValue);
        float f6 = f5 / 2.0f;
        float f7 = floatValue - ((int) floatValue);
        double d2 = f7 != 0.0f ? radians + ((1.0f - f7) * f6) : radians;
        float floatValue2 = this.i.e().floatValue();
        float floatValue3 = this.h.e().floatValue();
        float floatValue4 = this.j != null ? this.j.e().floatValue() / 100.0f : 0.0f;
        float floatValue5 = this.k != null ? this.k.e().floatValue() / 100.0f : 0.0f;
        if (f7 != 0.0f) {
            float f8 = ((floatValue2 - floatValue3) * f7) + floatValue3;
            float cos = (float) (f8 * Math.cos(d2));
            sin = (float) (f8 * Math.sin(d2));
            this.f8244a.moveTo(cos, sin);
            d = d2 + ((f5 * f7) / 2.0f);
            f = f8;
            f2 = cos;
        } else {
            float cos2 = (float) (floatValue2 * Math.cos(d2));
            sin = (float) (floatValue2 * Math.sin(d2));
            this.f8244a.moveTo(cos2, sin);
            d = d2 + f6;
            f = 0.0f;
            f2 = cos2;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f9 = sin;
        float f10 = f2;
        while (true) {
            double d3 = d;
            if (i >= ceil) {
                PointF e = this.f.e();
                this.f8244a.offset(e.x, e.y);
                this.f8244a.close();
                return;
            }
            float f11 = z ? floatValue2 : floatValue3;
            float f12 = (f == 0.0f || ((double) i) != ceil - 2.0d) ? f6 : (f5 * f7) / 2.0f;
            if (f != 0.0f && i == ceil - 1.0d) {
                f11 = f;
            }
            float cos3 = (float) (f11 * Math.cos(d3));
            float sin2 = (float) (f11 * Math.sin(d3));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f8244a.lineTo(cos3, sin2);
            } else {
                float atan2 = (float) (Math.atan2(f9, f10) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                float atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f13 = z ? floatValue4 : floatValue5;
                float f14 = z ? floatValue5 : floatValue4;
                float f15 = z ? floatValue3 : floatValue2;
                float f16 = z ? floatValue2 : floatValue3;
                float f17 = f15 * f13 * 0.47829f * cos4;
                float f18 = f15 * f13 * 0.47829f * sin3;
                float f19 = f16 * f14 * 0.47829f * cos5;
                float f20 = f16 * f14 * 0.47829f * sin4;
                if (f7 != 0.0f) {
                    if (i == 0) {
                        f17 *= f7;
                        f18 *= f7;
                        f3 = f20;
                        f4 = f19;
                    } else if (i == ceil - 1.0d) {
                        f3 = f20 * f7;
                        f4 = f19 * f7;
                    }
                    this.f8244a.cubicTo(f10 - f17, f9 - f18, f4 + cos3, f3 + sin2, cos3, sin2);
                }
                f3 = f20;
                f4 = f19;
                this.f8244a.cubicTo(f10 - f17, f9 - f18, f4 + cos3, f3 + sin2, cos3, sin2);
            }
            d = d3 + f12;
            i++;
            z = !z;
            f9 = sin2;
            f10 = cos3;
        }
    }

    private void e() {
        int floor = (int) Math.floor(this.e.e().floatValue());
        double radians = Math.toRadians((this.g == null ? 0.0d : this.g.e().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.k.e().floatValue() / 100.0f;
        float floatValue2 = this.i.e().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.f8244a.moveTo(cos, sin);
        double d = radians + f;
        double ceil = Math.ceil(floor);
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = sin;
            float f3 = cos;
            if (i2 >= ceil) {
                PointF e = this.f.e();
                this.f8244a.offset(e.x, e.y);
                this.f8244a.close();
                return;
            }
            cos = (float) (floatValue2 * Math.cos(d));
            sin = (float) (floatValue2 * Math.sin(d));
            if (floatValue != 0.0f) {
                float atan2 = (float) (Math.atan2(f2, f3) - 1.5707963267948966d);
                float cos2 = (float) Math.cos(atan2);
                float sin2 = (float) Math.sin(atan2);
                float atan22 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                this.f8244a.cubicTo(f3 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f2 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
            } else {
                this.f8244a.lineTo(cos, sin);
            }
            d += f;
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1037a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            b bVar = list.get(i2);
            if ((bVar instanceof r) && ((r) bVar).b() == ShapeTrimPath.Type.Simultaneously) {
                this.l = (r) bVar;
                this.l.a(this);
            }
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.m) {
            return this.f8244a;
        }
        this.f8244a.reset();
        switch (this.d) {
            case Star:
                c();
                break;
            case Polygon:
                e();
                break;
        }
        this.f8244a.close();
        com.ksad.lottie.d.f.a(this.f8244a, this.l);
        this.m = true;
        return this.f8244a;
    }
}
