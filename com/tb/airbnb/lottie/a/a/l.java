package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class l implements k, a.InterfaceC0687a {
    private boolean fV;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private q mMT;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> mMW;
    private final PolystarShape.Type mNd;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNe;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNf;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNg;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNh;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNi;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNj;
    private final String name;
    private final Path path = new Path();

    public l(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = fVar;
        this.name = polystarShape.getName();
        this.mNd = polystarShape.dBY();
        this.mNe = polystarShape.dBZ().dBq();
        this.mMW = polystarShape.dBC().dBq();
        this.mNf = polystarShape.dBE().dBq();
        this.mNh = polystarShape.dCb().dBq();
        this.mNj = polystarShape.dCd().dBq();
        if (this.mNd == PolystarShape.Type.Star) {
            this.mNg = polystarShape.dCa().dBq();
            this.mNi = polystarShape.dCc().dBq();
        } else {
            this.mNg = null;
            this.mNi = null;
        }
        aVar.a(this.mNe);
        aVar.a(this.mMW);
        aVar.a(this.mNf);
        aVar.a(this.mNh);
        aVar.a(this.mNj);
        if (this.mNd == PolystarShape.Type.Star) {
            aVar.a(this.mNg);
            aVar.a(this.mNi);
        }
        this.mNe.b(this);
        this.mMW.b(this);
        this.mNf.b(this);
        this.mNh.b(this);
        this.mNj.b(this);
        if (this.mNd == PolystarShape.Type.Star) {
            this.mNh.b(this);
            this.mNj.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        invalidate();
    }

    private void invalidate() {
        this.fV = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dBh() == ShapeTrimPath.Type.Simultaneously) {
                    this.mMT = (q) bVar;
                    this.mMT.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bF() {
        if (this.fV) {
            return this.path;
        }
        this.path.reset();
        switch (this.mNd) {
            case Star:
                bK();
                break;
            case Polygon:
                bL();
                break;
        }
        this.path.close();
        com.tb.airbnb.lottie.c.f.a(this.path, this.mMT);
        this.fV = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void bK() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float floatValue = this.mNe.getValue().floatValue();
        double radians = Math.toRadians((this.mNf == null ? 0.0d : this.mNf.getValue().floatValue()) - 90.0d);
        float f6 = (float) (6.283185307179586d / floatValue);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        double d2 = f8 != 0.0f ? radians + ((1.0f - f8) * f7) : radians;
        float floatValue2 = this.mNh.getValue().floatValue();
        float floatValue3 = this.mNg.getValue().floatValue();
        if (this.mNi == null) {
            f = 0.0f;
        } else {
            f = this.mNi.getValue().floatValue() / 100.0f;
        }
        float f9 = 0.0f;
        if (this.mNj != null) {
            f9 = this.mNj.getValue().floatValue() / 100.0f;
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
                PointF value = this.mMW.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void bL() {
        int floor = (int) Math.floor(this.mNe.getValue().floatValue());
        double radians = Math.toRadians((this.mNf == null ? 0.0d : this.mNf.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.mNj.getValue().floatValue() / 100.0f;
        float floatValue2 = this.mNh.getValue().floatValue();
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
                PointF value = this.mMW.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }
}
