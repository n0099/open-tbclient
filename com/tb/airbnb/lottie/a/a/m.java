package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class m implements j, l, a.InterfaceC0763a {
    private boolean BB;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOA;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOB;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOC;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOD;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOE;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOF;
    @Nullable
    private r mOp;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> mOs;
    private final PolystarShape.Type mOz;
    private final String name;
    private final Path path = new Path();

    public m(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.lottieDrawable = fVar;
        this.name = polystarShape.getName();
        this.mOz = polystarShape.dBO();
        this.mOA = polystarShape.dBP().dBs();
        this.mOs = polystarShape.dBv().dBs();
        this.mOB = polystarShape.dBx().dBs();
        this.mOD = polystarShape.dBR().dBs();
        this.mOF = polystarShape.dBT().dBs();
        if (this.mOz == PolystarShape.Type.Star) {
            this.mOC = polystarShape.dBQ().dBs();
            this.mOE = polystarShape.dBS().dBs();
        } else {
            this.mOC = null;
            this.mOE = null;
        }
        aVar.a(this.mOA);
        aVar.a(this.mOs);
        aVar.a(this.mOB);
        aVar.a(this.mOD);
        aVar.a(this.mOF);
        if (this.mOz == PolystarShape.Type.Star) {
            aVar.a(this.mOC);
            aVar.a(this.mOE);
        }
        this.mOA.b(this);
        this.mOs.b(this);
        this.mOB.b(this);
        this.mOD.b(this);
        this.mOF.b(this);
        if (this.mOz == PolystarShape.Type.Star) {
            this.mOC.b(this);
            this.mOE.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0763a
    public void ha() {
        invalidate();
    }

    private void invalidate() {
        this.BB = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dBi() == ShapeTrimPath.Type.Simultaneously) {
                    this.mOp = (r) bVar;
                    this.mOp.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path hd() {
        if (this.BB) {
            return this.path;
        }
        this.path.reset();
        switch (this.mOz) {
            case Star:
                hi();
                break;
            case Polygon:
                hj();
                break;
        }
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.mOp);
        this.BB = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void hi() {
        float f;
        float cos;
        float sin;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float floatValue = this.mOA.getValue().floatValue();
        double radians = Math.toRadians((this.mOB == null ? 0.0d : this.mOB.getValue().floatValue()) - 90.0d);
        float f6 = (float) (6.283185307179586d / floatValue);
        float f7 = f6 / 2.0f;
        float f8 = floatValue - ((int) floatValue);
        double d2 = f8 != 0.0f ? radians + ((1.0f - f8) * f7) : radians;
        float floatValue2 = this.mOD.getValue().floatValue();
        float floatValue3 = this.mOC.getValue().floatValue();
        if (this.mOE == null) {
            f = 0.0f;
        } else {
            f = this.mOE.getValue().floatValue() / 100.0f;
        }
        float f9 = 0.0f;
        if (this.mOF != null) {
            f9 = this.mOF.getValue().floatValue() / 100.0f;
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
                PointF value = this.mOs.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void hj() {
        int floor = (int) Math.floor(this.mOA.getValue().floatValue());
        double radians = Math.toRadians((this.mOB == null ? 0.0d : this.mOB.getValue().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / floor);
        float floatValue = this.mOF.getValue().floatValue() / 100.0f;
        float floatValue2 = this.mOD.getValue().floatValue();
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
                PointF value = this.mOs.getValue();
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
        if (t == com.tb.airbnb.lottie.j.AJ) {
            this.mOA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AK) {
            this.mOB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AC) {
            this.mOs.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AM && this.mOC != null) {
            this.mOC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AN) {
            this.mOD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AO && this.mOE != null) {
            this.mOE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AP) {
            this.mOF.a(cVar);
        }
    }
}
