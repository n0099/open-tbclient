package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.PolystarShape;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class m implements j, l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31772a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31773b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31774c;

    /* renamed from: d  reason: collision with root package name */
    public final PolystarShape.Type f31775d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31776e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31777f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31778g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31779h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31780i;
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
        public static final /* synthetic */ int[] f31781a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f31781a = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31781a[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        com.ksad.lottie.a.b.a<Float, Float> aVar2;
        this.f31774c = fVar;
        this.f31773b = polystarShape.a();
        this.f31775d = polystarShape.b();
        this.f31776e = polystarShape.c().a();
        this.f31777f = polystarShape.d().a();
        this.f31778g = polystarShape.e().a();
        this.f31780i = polystarShape.g().a();
        this.k = polystarShape.i().a();
        if (this.f31775d == PolystarShape.Type.Star) {
            this.f31779h = polystarShape.f().a();
            aVar2 = polystarShape.h().a();
        } else {
            aVar2 = null;
            this.f31779h = null;
        }
        this.j = aVar2;
        aVar.a(this.f31776e);
        aVar.a(this.f31777f);
        aVar.a(this.f31778g);
        aVar.a(this.f31780i);
        aVar.a(this.k);
        if (this.f31775d == PolystarShape.Type.Star) {
            aVar.a(this.f31779h);
            aVar.a(this.j);
        }
        this.f31776e.a(this);
        this.f31777f.a(this);
        this.f31778g.a(this);
        this.f31780i.a(this);
        this.k.a(this);
        if (this.f31775d == PolystarShape.Type.Star) {
            this.f31779h.a(this);
            this.j.a(this);
        }
    }

    private void b() {
        this.m = false;
        this.f31774c.invalidateSelf();
    }

    private void c() {
        com.ksad.lottie.a.b.a<?, Float> aVar;
        double d2;
        int i2;
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
        float floatValue = this.f31776e.e().floatValue();
        double radians = Math.toRadians((this.f31778g == null ? 0.0d : aVar.e().floatValue()) - 90.0d);
        double d5 = floatValue;
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float floatValue2 = this.f31780i.e().floatValue();
        float floatValue3 = this.f31779h.e().floatValue();
        com.ksad.lottie.a.b.a<?, Float> aVar2 = this.j;
        float floatValue4 = aVar2 != null ? aVar2.e().floatValue() / 100.0f : 0.0f;
        com.ksad.lottie.a.b.a<?, Float> aVar3 = this.k;
        float floatValue5 = aVar3 != null ? aVar3.e().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f4 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i2 = i3;
            double d6 = f4;
            d2 = d5;
            f2 = (float) (d6 * Math.cos(radians));
            f3 = (float) (d6 * Math.sin(radians));
            this.f31772a.moveTo(f2, f3);
            d3 = radians + ((f11 * f13) / 2.0f);
        } else {
            d2 = d5;
            i2 = i3;
            double d7 = floatValue2;
            float cos = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.f31772a.moveTo(cos, sin);
            d3 = radians + f12;
            f2 = cos;
            f3 = sin;
            f4 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i4 = 0;
        boolean z = false;
        while (true) {
            double d8 = i4;
            if (d8 >= ceil) {
                PointF e2 = this.f31777f.e();
                this.f31772a.offset(e2.x, e2.y);
                this.f31772a.close();
                return;
            }
            float f14 = z ? floatValue2 : floatValue3;
            int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i5 == 0 || d8 != ceil - 2.0d) {
                f5 = f11;
                f6 = f12;
            } else {
                f5 = f11;
                f6 = (f11 * f13) / 2.0f;
            }
            if (i5 == 0 || d8 != ceil - 1.0d) {
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
                this.f31772a.lineTo(cos2, sin2);
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
                if (i2 != 0) {
                    if (i4 == 0) {
                        f18 *= f13;
                        f19 *= f13;
                    } else if (d4 == d10 - 1.0d) {
                        f21 *= f13;
                        f22 *= f13;
                    }
                }
                this.f31772a.cubicTo(f2 - f18, f3 - f19, cos2 + f21, sin2 + f22, cos2, sin2);
            }
            d3 += f6;
            z = !z;
            i4++;
            f2 = cos2;
            f3 = sin2;
            floatValue4 = f9;
            f4 = f10;
            f12 = f7;
            f11 = f5;
            ceil = d10;
        }
    }

    private void e() {
        com.ksad.lottie.a.b.a<?, Float> aVar;
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor(this.f31776e.e().floatValue());
        double radians = Math.toRadians((this.f31778g == null ? 0.0d : aVar.e().floatValue()) - 90.0d);
        double d5 = floor;
        float floatValue = this.k.e().floatValue() / 100.0f;
        float floatValue2 = this.f31780i.e().floatValue();
        double d6 = floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f31772a.moveTo(cos, sin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f2 = floatValue2 * floatValue * 0.25f;
                this.f31772a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.f31772a.lineTo(cos2, sin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF e2 = this.f31777f.e();
        this.f31772a.offset(e2.x, e2.y);
        this.f31772a.close();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
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
            return this.f31772a;
        }
        this.f31772a.reset();
        int i2 = AnonymousClass1.f31781a[this.f31775d.ordinal()];
        if (i2 == 1) {
            c();
        } else if (i2 == 2) {
            e();
        }
        this.f31772a.close();
        com.ksad.lottie.d.f.a(this.f31772a, this.l);
        this.m = true;
        return this.f31772a;
    }
}
