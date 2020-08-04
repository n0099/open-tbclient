package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class m implements j, l, a.InterfaceC0874a {
    private boolean Cd;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private r nOj;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> nOm;
    private final PolystarShape.Type nOt;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOu;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOv;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOw;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOx;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOy;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOz;
    private final String name;
    private final Path path = new Path();

    public m(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = fVar;
        this.name = polystarShape.getName();
        this.nOt = polystarShape.dRz();
        this.nOu = polystarShape.dRA().dRd();
        this.nOm = polystarShape.dRg().dRd();
        this.nOv = polystarShape.dRi().dRd();
        this.nOx = polystarShape.dRC().dRd();
        this.nOz = polystarShape.dRE().dRd();
        if (this.nOt == PolystarShape.Type.Star) {
            this.nOw = polystarShape.dRB().dRd();
            this.nOy = polystarShape.dRD().dRd();
        } else {
            this.nOw = null;
            this.nOy = null;
        }
        aVar.a(this.nOu);
        aVar.a(this.nOm);
        aVar.a(this.nOv);
        aVar.a(this.nOx);
        aVar.a(this.nOz);
        if (this.nOt == PolystarShape.Type.Star) {
            aVar.a(this.nOw);
            aVar.a(this.nOy);
        }
        this.nOu.b(this);
        this.nOm.b(this);
        this.nOv.b(this);
        this.nOx.b(this);
        this.nOz.b(this);
        if (this.nOt == PolystarShape.Type.Star) {
            this.nOw.b(this);
            this.nOy.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0874a
    public void hq() {
        invalidate();
    }

    private void invalidate() {
        this.Cd = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dQT() == ShapeTrimPath.Type.Simultaneously) {
                    this.nOj = (r) bVar;
                    this.nOj.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path ht() {
        if (this.Cd) {
            return this.path;
        }
        this.path.reset();
        switch (this.nOt) {
            case Star:
                hy();
                break;
            case Polygon:
                hz();
                break;
        }
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.nOj);
        this.Cd = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void hy() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float floatValue = this.nOu.getValue().floatValue();
        double radians = Math.toRadians((this.nOv == null ? 0.0d : this.nOv.getValue().floatValue()) - 90.0d);
        float f6 = (float) (6.283185307179586d / floatValue);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        double d2 = f8 != 0.0f ? radians + ((1.0f - f8) * f7) : radians;
        float floatValue2 = this.nOx.getValue().floatValue();
        float floatValue3 = this.nOw.getValue().floatValue();
        if (this.nOy == null) {
            f = 0.0f;
        } else {
            f = this.nOy.getValue().floatValue() / 100.0f;
        }
        float f9 = 0.0f;
        if (this.nOz != null) {
            f9 = this.nOz.getValue().floatValue() / 100.0f;
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
                PointF value = this.nOm.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void hz() {
        int floor = (int) Math.floor(this.nOu.getValue().floatValue());
        double radians = Math.toRadians((this.nOv == null ? 0.0d : this.nOv.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.nOz.getValue().floatValue() / 100.0f;
        float floatValue2 = this.nOx.getValue().floatValue();
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
                PointF value = this.nOm.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Bo) {
            this.nOu.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bp) {
            this.nOv.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bh) {
            this.nOm.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bq && this.nOw != null) {
            this.nOw.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Br) {
            this.nOx.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bs && this.nOy != null) {
            this.nOy.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bt) {
            this.nOz.a(cVar);
        }
    }
}
