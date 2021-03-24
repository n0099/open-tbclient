package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.PolystarShape;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class m implements j, l, a.InterfaceC0351a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31246a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31247b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31248c;

    /* renamed from: d  reason: collision with root package name */
    public final PolystarShape.Type f31249d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31250e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31251f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31252g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31253h;
    public final com.ksad.lottie.a.b.a<?, Float> i;
    @Nullable
    public final com.ksad.lottie.a.b.a<?, Float> j;
    public final com.ksad.lottie.a.b.a<?, Float> k;
    @Nullable
    public r l;
    public boolean m;

    /* renamed from: com.ksad.lottie.a.a.m$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31254a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f31254a = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31254a[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        com.ksad.lottie.a.b.a<Float, Float> aVar2;
        this.f31248c = fVar;
        this.f31247b = polystarShape.a();
        this.f31249d = polystarShape.b();
        this.f31250e = polystarShape.c().a();
        this.f31251f = polystarShape.d().a();
        this.f31252g = polystarShape.e().a();
        this.i = polystarShape.g().a();
        this.k = polystarShape.i().a();
        if (this.f31249d == PolystarShape.Type.Star) {
            this.f31253h = polystarShape.f().a();
            aVar2 = polystarShape.h().a();
        } else {
            aVar2 = null;
            this.f31253h = null;
        }
        this.j = aVar2;
        aVar.a(this.f31250e);
        aVar.a(this.f31251f);
        aVar.a(this.f31252g);
        aVar.a(this.i);
        aVar.a(this.k);
        if (this.f31249d == PolystarShape.Type.Star) {
            aVar.a(this.f31253h);
            aVar.a(this.j);
        }
        this.f31250e.a(this);
        this.f31251f.a(this);
        this.f31252g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.f31249d == PolystarShape.Type.Star) {
            this.f31253h.a(this);
            this.j.a(this);
        }
    }

    private void b() {
        this.m = false;
        this.f31248c.invalidateSelf();
    }

    private void c() {
        com.ksad.lottie.a.b.a<?, Float> aVar;
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
        float floatValue = this.f31250e.e().floatValue();
        double radians = Math.toRadians((this.f31252g == null ? 0.0d : aVar.e().floatValue()) - 90.0d);
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
        float floatValue2 = this.i.e().floatValue();
        float floatValue3 = this.f31253h.e().floatValue();
        com.ksad.lottie.a.b.a<?, Float> aVar2 = this.j;
        float floatValue4 = aVar2 != null ? aVar2.e().floatValue() / 100.0f : 0.0f;
        com.ksad.lottie.a.b.a<?, Float> aVar3 = this.k;
        float floatValue5 = aVar3 != null ? aVar3.e().floatValue() / 100.0f : 0.0f;
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
            this.f31246a.moveTo(f18, f19);
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
            this.f31246a.moveTo(f4, f5);
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
            if (d11 >= ceil) {
                PointF e2 = this.f31251f.e();
                this.f31246a.offset(e2.x, e2.y);
                this.f31246a.close();
                return;
            }
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
                this.f31246a.lineTo(f23, f24);
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
                this.f31246a.cubicTo(f4 - f28, f5 - f29, f23 + f31, f24 + f32, f23, f24);
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
        }
    }

    private void e() {
        com.ksad.lottie.a.b.a<?, Float> aVar;
        double d2;
        double d3;
        double d4;
        int i;
        int floor = (int) Math.floor(this.f31250e.e().floatValue());
        double radians = Math.toRadians((this.f31252g == null ? 0.0d : aVar.e().floatValue()) - 90.0d);
        double d5 = floor;
        Double.isNaN(d5);
        float floatValue = this.k.e().floatValue() / 100.0f;
        float floatValue2 = this.i.e().floatValue();
        double d6 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.f31246a.moveTo(f2, f3);
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
                this.f31246a.cubicTo(f2 - (cos3 * f6), f3 - (((float) Math.sin(atan2)) * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i = i2;
                this.f31246a.lineTo(f4, f5);
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
        PointF e2 = this.f31251f.e();
        this.f31246a.offset(e2.x, e2.y);
        this.f31246a.close();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                    this.l = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.m) {
            return this.f31246a;
        }
        this.f31246a.reset();
        int i = AnonymousClass1.f31254a[this.f31249d.ordinal()];
        if (i == 1) {
            c();
        } else if (i == 2) {
            e();
        }
        this.f31246a.close();
        com.ksad.lottie.d.f.a(this.f31246a, this.l);
        this.m = true;
        return this.f31246a;
    }
}
