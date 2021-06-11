package d.a.n0.r3.i.g;

import android.graphics.Matrix;
import com.baidu.tieba.video.editvideo.scale.PivotPoint;
import com.baidu.tieba.video.editvideo.scale.ScalableType;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f63817a;

    /* renamed from: b  reason: collision with root package name */
    public b f63818b;

    /* renamed from: d.a.n0.r3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1630a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63819a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63820b;

        static {
            int[] iArr = new int[PivotPoint.values().length];
            f63820b = iArr;
            try {
                iArr[PivotPoint.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63820b[PivotPoint.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63820b[PivotPoint.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63820b[PivotPoint.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f63820b[PivotPoint.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f63820b[PivotPoint.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f63820b[PivotPoint.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f63820b[PivotPoint.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f63820b[PivotPoint.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[ScalableType.values().length];
            f63819a = iArr2;
            try {
                iArr2[ScalableType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f63819a[ScalableType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f63819a[ScalableType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f63819a[ScalableType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f63819a[ScalableType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f63819a[ScalableType.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f63819a[ScalableType.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f63819a[ScalableType.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f63819a[ScalableType.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f63819a[ScalableType.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f63819a[ScalableType.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f63819a[ScalableType.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f63819a[ScalableType.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f63819a[ScalableType.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f63819a[ScalableType.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f63819a[ScalableType.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f63819a[ScalableType.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f63819a[ScalableType.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f63819a[ScalableType.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f63819a[ScalableType.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f63819a[ScalableType.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f63819a[ScalableType.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f63819a[ScalableType.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f63819a[ScalableType.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f63819a[ScalableType.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f63819a[ScalableType.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    public a(b bVar, b bVar2) {
        this.f63817a = bVar;
        this.f63818b = bVar2;
    }

    public final Matrix a() {
        if (this.f63818b.a() <= this.f63817a.b() && this.f63818b.a() <= this.f63817a.a()) {
            return l(PivotPoint.CENTER);
        }
        return c();
    }

    public final Matrix b() {
        if (this.f63818b.a() <= this.f63817a.b() && this.f63818b.a() <= this.f63817a.a()) {
            return l(PivotPoint.RIGHT_BOTTOM);
        }
        return d();
    }

    public final Matrix c() {
        return h(PivotPoint.CENTER);
    }

    public final Matrix d() {
        return h(PivotPoint.RIGHT_BOTTOM);
    }

    public final Matrix e() {
        return h(PivotPoint.LEFT_TOP);
    }

    public final Matrix f() {
        return j(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    public final Matrix g(PivotPoint pivotPoint) {
        float b2 = this.f63817a.b() / this.f63818b.b();
        float a2 = this.f63817a.a() / this.f63818b.a();
        float max = Math.max(b2, a2);
        return j(max / b2, max / a2, pivotPoint);
    }

    public final Matrix h(PivotPoint pivotPoint) {
        float b2 = this.f63817a.b() / this.f63818b.b();
        float a2 = this.f63817a.a() / this.f63818b.a();
        float min = Math.min(b2, a2);
        return j(min / b2, min / a2, pivotPoint);
    }

    public final Matrix i(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3, f4, f5);
        return matrix;
    }

    public final Matrix j(float f2, float f3, PivotPoint pivotPoint) {
        switch (C1630a.f63820b[pivotPoint.ordinal()]) {
            case 1:
                return i(f2, f3, 0.0f, 0.0f);
            case 2:
                return i(f2, f3, 0.0f, this.f63817a.a() / 2.0f);
            case 3:
                return i(f2, f3, 0.0f, this.f63817a.a());
            case 4:
                return i(f2, f3, this.f63817a.b() / 2.0f, 0.0f);
            case 5:
                return i(f2, f3, this.f63817a.b() / 2.0f, this.f63817a.a() / 2.0f);
            case 6:
                return i(f2, f3, this.f63817a.b() / 2.0f, this.f63817a.a());
            case 7:
                return i(f2, f3, this.f63817a.b(), 0.0f);
            case 8:
                return i(f2, f3, this.f63817a.b(), this.f63817a.a() / 2.0f);
            case 9:
                return i(f2, f3, this.f63817a.b(), this.f63817a.a());
            default:
                return null;
        }
    }

    public final Matrix k() {
        return j(this.f63818b.b() / this.f63817a.b(), this.f63818b.a() / this.f63817a.a(), PivotPoint.LEFT_TOP);
    }

    public final Matrix l(PivotPoint pivotPoint) {
        return j(this.f63818b.b() / this.f63817a.b(), this.f63818b.a() / this.f63817a.a(), pivotPoint);
    }

    public Matrix m(ScalableType scalableType) {
        switch (C1630a.f63819a[scalableType.ordinal()]) {
            case 1:
                return k();
            case 2:
                return f();
            case 3:
                return c();
            case 4:
                return e();
            case 5:
                return d();
            case 6:
                return l(PivotPoint.LEFT_TOP);
            case 7:
                return l(PivotPoint.LEFT_CENTER);
            case 8:
                return l(PivotPoint.LEFT_BOTTOM);
            case 9:
                return l(PivotPoint.CENTER_TOP);
            case 10:
                return l(PivotPoint.CENTER);
            case 11:
                return l(PivotPoint.CENTER_BOTTOM);
            case 12:
                return l(PivotPoint.RIGHT_TOP);
            case 13:
                return l(PivotPoint.RIGHT_CENTER);
            case 14:
                return l(PivotPoint.RIGHT_BOTTOM);
            case 15:
                return g(PivotPoint.LEFT_TOP);
            case 16:
                return g(PivotPoint.LEFT_CENTER);
            case 17:
                return g(PivotPoint.LEFT_BOTTOM);
            case 18:
                return g(PivotPoint.CENTER_TOP);
            case 19:
                return g(PivotPoint.CENTER);
            case 20:
                return g(PivotPoint.CENTER_BOTTOM);
            case 21:
                return g(PivotPoint.RIGHT_TOP);
            case 22:
                return g(PivotPoint.RIGHT_CENTER);
            case 23:
                return g(PivotPoint.RIGHT_BOTTOM);
            case 24:
                return n();
            case 25:
                return a();
            case 26:
                return b();
            default:
                return null;
        }
    }

    public final Matrix n() {
        if (this.f63818b.a() <= this.f63817a.b() && this.f63818b.a() <= this.f63817a.a()) {
            return l(PivotPoint.LEFT_TOP);
        }
        return e();
    }
}
