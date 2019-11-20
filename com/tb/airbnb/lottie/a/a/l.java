package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class l implements k, a.InterfaceC0577a {
    private boolean ei;
    @Nullable
    private q ksf;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> ksi;
    private final PolystarShape.Type ksp;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksr;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> kss;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> kst;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksu;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksv;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public l(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = fVar;
        this.name = polystarShape.getName();
        this.ksp = polystarShape.cLP();
        this.ksq = polystarShape.cLQ().cLl();
        this.ksi = polystarShape.cLu().cLl();
        this.ksr = polystarShape.cLw().cLl();
        this.kst = polystarShape.cLS().cLl();
        this.ksv = polystarShape.cLU().cLl();
        if (this.ksp == PolystarShape.Type.Star) {
            this.kss = polystarShape.cLR().cLl();
            this.ksu = polystarShape.cLT().cLl();
        } else {
            this.kss = null;
            this.ksu = null;
        }
        aVar.a(this.ksq);
        aVar.a(this.ksi);
        aVar.a(this.ksr);
        aVar.a(this.kst);
        aVar.a(this.ksv);
        if (this.ksp == PolystarShape.Type.Star) {
            aVar.a(this.kss);
            aVar.a(this.ksu);
        }
        this.ksq.b(this);
        this.ksi.b(this);
        this.ksr.b(this);
        this.kst.b(this);
        this.ksv.b(this);
        if (this.ksp == PolystarShape.Type.Star) {
            this.kst.b(this);
            this.ksv.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.ei = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cLd() == ShapeTrimPath.Type.Simultaneously) {
                    this.ksf = (q) bVar;
                    this.ksf.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.ei) {
            return this.path;
        }
        this.path.reset();
        switch (this.ksp) {
            case Star:
                bB();
                break;
            case Polygon:
                bC();
                break;
        }
        this.path.close();
        com.tb.airbnb.lottie.c.f.a(this.path, this.ksf);
        this.ei = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bB() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float floatValue = this.ksq.getValue().floatValue();
        double radians = Math.toRadians((this.ksr == null ? 0.0d : this.ksr.getValue().floatValue()) - 90.0d);
        float f6 = (float) (6.283185307179586d / floatValue);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        double d2 = f8 != 0.0f ? radians + ((1.0f - f8) * f7) : radians;
        float floatValue2 = this.kst.getValue().floatValue();
        float floatValue3 = this.kss.getValue().floatValue();
        if (this.ksu == null) {
            f = 0.0f;
        } else {
            f = this.ksu.getValue().floatValue() / 100.0f;
        }
        float f9 = 0.0f;
        if (this.ksv != null) {
            f9 = this.ksv.getValue().floatValue() / 100.0f;
        }
        if (f8 != 0.0f) {
            float f10 = floatValue3 + ((floatValue2 - floatValue3) * f8);
            cos = (float) (f10 * Math.cos(d2));
            sin = (float) (f10 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + ((f6 * f8) / 2.0f);
            f2 = f10;
        } else {
            cos = (float) (floatValue2 * Math.cos(d2));
            sin = (float) (floatValue2 * Math.sin(d2));
            this.path.moveTo(cos, sin);
            d = d2 + f7;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(floatValue) * 2.0d;
        int i = 0;
        boolean z = false;
        float f11 = sin;
        float f12 = cos;
        while (true) {
            double d3 = d;
            if (i < ceil) {
                float f13 = z ? floatValue2 : floatValue3;
                float f14 = (f2 == 0.0f || ((double) i) != ceil - 2.0d) ? f7 : (f6 * f8) / 2.0f;
                if (f2 != 0.0f && i == ceil - 1.0d) {
                    f13 = f2;
                }
                float cos2 = (float) (f13 * Math.cos(d3));
                float sin2 = (float) (f13 * Math.sin(d3));
                if (f == 0.0f && f9 == 0.0f) {
                    this.path.lineTo(cos2, sin2);
                } else {
                    float atan2 = (float) (Math.atan2(f11, f12) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f15 = z ? f : f9;
                    float f16 = z ? f9 : f;
                    float f17 = z ? floatValue3 : floatValue2;
                    float f18 = z ? floatValue2 : floatValue3;
                    float f19 = cos3 * f17 * f15 * 0.47829f;
                    float f20 = f17 * f15 * 0.47829f * sin3;
                    float f21 = f18 * f16 * 0.47829f * cos4;
                    float f22 = f18 * f16 * 0.47829f * sin4;
                    if (f8 != 0.0f) {
                        if (i == 0) {
                            f20 *= f8;
                            f3 = f22;
                            f4 = f19 * f8;
                            f5 = f21;
                        } else if (i == ceil - 1.0d) {
                            float f23 = f21 * f8;
                            f3 = f22 * f8;
                            f4 = f19;
                            f5 = f23;
                        }
                        this.path.cubicTo(f12 - f4, f11 - f20, f5 + cos2, f3 + sin2, cos2, sin2);
                    }
                    f3 = f22;
                    f4 = f19;
                    f5 = f21;
                    this.path.cubicTo(f12 - f4, f11 - f20, f5 + cos2, f3 + sin2, cos2, sin2);
                }
                d = d3 + f14;
                i++;
                z = !z;
                f11 = sin2;
                f12 = cos2;
            } else {
                PointF value = this.ksi.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void bC() {
        int floor = (int) Math.floor(this.ksq.getValue().floatValue());
        double radians = Math.toRadians((this.ksr == null ? 0.0d : this.ksr.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.ksv.getValue().floatValue() / 100.0f;
        float floatValue2 = this.kst.getValue().floatValue();
        float cos = (float) (floatValue2 * Math.cos(radians));
        float sin = (float) (floatValue2 * Math.sin(radians));
        this.path.moveTo(cos, sin);
        double d = radians + f;
        double ceil = Math.ceil(floor);
        int i = 0;
        while (true) {
            int i2 = i;
            float f2 = cos;
            double d2 = d;
            float f3 = sin;
            if (i2 < ceil) {
                cos = (float) (floatValue2 * Math.cos(d2));
                sin = (float) (floatValue2 * Math.sin(d2));
                if (floatValue != 0.0f) {
                    float atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                    float cos2 = (float) Math.cos(atan2);
                    float sin2 = (float) Math.sin(atan2);
                    float atan22 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                    this.path.cubicTo(f2 - (cos2 * ((floatValue2 * floatValue) * 0.25f)), f3 - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (((float) Math.cos(atan22)) * floatValue2 * floatValue * 0.25f), (((float) Math.sin(atan22)) * floatValue2 * floatValue * 0.25f) + sin, cos, sin);
                } else {
                    this.path.lineTo(cos, sin);
                }
                d = d2 + f;
                i = i2 + 1;
            } else {
                PointF value = this.ksi.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }
}
