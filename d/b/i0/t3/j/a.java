package d.b.i0.t3.j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.tieba.view.bubbleView.ArrowDirection;
/* loaded from: classes5.dex */
public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public RectF f61192a;

    /* renamed from: b  reason: collision with root package name */
    public Path f61193b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public Paint f61194c;

    /* renamed from: d  reason: collision with root package name */
    public Path f61195d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f61196e;

    /* renamed from: f  reason: collision with root package name */
    public float f61197f;

    /* renamed from: g  reason: collision with root package name */
    public float f61198g;

    /* renamed from: h  reason: collision with root package name */
    public float f61199h;
    public float i;
    public float j;

    /* renamed from: d.b.i0.t3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1590a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61200a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f61200a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61200a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61200a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61200a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(RectF rectF, float f2, float f3, float f4, float f5, float f6, int i, int i2, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.f61194c = paint;
        this.f61192a = rectF;
        this.f61197f = f2;
        this.f61198g = f3;
        this.f61199h = f4;
        this.i = f5;
        this.j = f6;
        paint.setColor(i2);
        if (f6 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f61196e = paint2;
            paint2.setColor(i);
            this.f61195d = new Path();
            e(arrowDirection, this.f61193b, f6);
            e(arrowDirection, this.f61195d, 0.0f);
            return;
        }
        e(arrowDirection, this.f61193b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f61198g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61198g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61198g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, ((rectF.bottom - this.f61199h) - this.f61198g) - f2);
        float f6 = rectF.right;
        float f7 = this.f61198g;
        float f8 = rectF.bottom;
        float f9 = this.f61199h;
        path.arcTo(new RectF(f6 - f7, (f8 - f7) - f9, f6 - f2, (f8 - f9) - f2), 0.0f, 90.0f);
        float f10 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f61197f) + this.i) - f10, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + this.i + (this.f61197f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.i + f10, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + Math.min(this.f61198g, this.i) + f2, (rectF.bottom - this.f61199h) - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f61198g;
        float f14 = this.f61199h;
        path.arcTo(new RectF(f11 + f2, (f12 - f13) - f14, f13 + f11, (f12 - f14) - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f61198g + f2);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f61198g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void b(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61199h) - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f61197f) + this.i) - f3, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + this.i + (this.f61197f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.i + f3, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + this.i + f2, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + f2, (rectF.bottom - this.f61199h) - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    public final void c(RectF rectF, Path path, float f2) {
        path.moveTo(this.f61197f + rectF.left + this.f61198g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61198g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61198g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61198g) - f2);
        float f6 = rectF.right;
        float f7 = this.f61198g;
        float f8 = rectF.bottom;
        path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - f2, f8 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61197f + this.f61198g + f2, rectF.bottom - f2);
        float f9 = rectF.left;
        float f10 = this.f61197f;
        float f11 = rectF.bottom;
        float f12 = this.f61198g;
        path.arcTo(new RectF(f9 + f10 + f2, f11 - f12, f12 + f9 + f10, f11 - f2), 90.0f, 90.0f);
        float f13 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f61197f + f2, (this.f61199h + this.i) - f13);
        path.lineTo(rectF.left + f2 + f2, this.i + (this.f61199h / 2.0f));
        path.lineTo(rectF.left + this.f61197f + f2, this.i + f13);
        path.lineTo(rectF.left + this.f61197f + f2, rectF.top + this.f61198g + f2);
        float f14 = rectF.left;
        float f15 = this.f61197f;
        float f16 = rectF.top;
        float f17 = this.f61198g;
        path.arcTo(new RectF(f14 + f15 + f2, f2 + f16, f14 + f17 + f15, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rectF, Path path, float f2) {
        path.moveTo(this.f61197f + rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.width() - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + this.f61197f + f2, rectF.bottom - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f61197f + f2, (this.f61199h + this.i) - f3);
        path.lineTo(rectF.left + f2 + f2, this.i + (this.f61199h / 2.0f));
        path.lineTo(rectF.left + this.f61197f + f2, this.i + f3);
        path.lineTo(rectF.left + this.f61197f + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j > 0.0f) {
            canvas.drawPath(this.f61195d, this.f61196e);
        }
        canvas.drawPath(this.f61193b, this.f61194c);
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f2) {
        int i = C1590a.f61200a[arrowDirection.ordinal()];
        if (i == 1) {
            float f3 = this.f61198g;
            if (f3 <= 0.0f) {
                d(this.f61192a, path, f2);
            } else if (f2 > 0.0f && f2 > f3) {
                d(this.f61192a, path, f2);
            } else {
                c(this.f61192a, path, f2);
            }
        } else if (i == 2) {
            float f4 = this.f61198g;
            if (f4 <= 0.0f) {
                i(this.f61192a, path, f2);
            } else if (f2 > 0.0f && f2 > f4) {
                i(this.f61192a, path, f2);
            } else {
                h(this.f61192a, path, f2);
            }
        } else if (i == 3) {
            float f5 = this.f61198g;
            if (f5 <= 0.0f) {
                g(this.f61192a, path, f2);
            } else if (f2 > 0.0f && f2 > f5) {
                g(this.f61192a, path, f2);
            } else {
                f(this.f61192a, path, f2);
            }
        } else if (i != 4) {
        } else {
            float f6 = this.f61198g;
            if (f6 <= 0.0f) {
                b(this.f61192a, path, f2);
            } else if (f2 > 0.0f && f2 > f6) {
                b(this.f61192a, path, f2);
            } else {
                a(this.f61192a, path, f2);
            }
        }
    }

    public final void f(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f61198g + f2, rectF.top + f2);
        path.lineTo(((rectF.width() - this.f61198g) - this.f61197f) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61198g;
        float f5 = this.f61197f;
        float f6 = rectF.top;
        path.arcTo(new RectF((f3 - f4) - f5, f6 + f2, (f3 - f5) - f2, f4 + f6), 270.0f, 90.0f);
        float f7 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f61197f) - f2, this.i + f7);
        path.lineTo((rectF.right - f2) - f2, this.i + (this.f61199h / 2.0f));
        path.lineTo((rectF.right - this.f61197f) - f2, (this.i + this.f61199h) - f7);
        path.lineTo((rectF.right - this.f61197f) - f2, (rectF.bottom - this.f61198g) - f2);
        float f8 = rectF.right;
        float f9 = this.f61198g;
        float f10 = this.f61197f;
        float f11 = rectF.bottom;
        path.arcTo(new RectF((f8 - f9) - f10, f11 - f9, (f8 - f10) - f2, f11 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61197f + f2, rectF.bottom - f2);
        float f12 = rectF.left;
        float f13 = rectF.bottom;
        float f14 = this.f61198g;
        path.arcTo(new RectF(f12 + f2, f13 - f14, f14 + f12, f13 - f2), 90.0f, 90.0f);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f61198g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void g(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61197f) - f2, rectF.top + f2);
        float f3 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f61197f) - f2, this.i + f3);
        path.lineTo((rectF.right - f2) - f2, this.i + (this.f61199h / 2.0f));
        path.lineTo((rectF.right - this.f61197f) - f2, (this.i + this.f61199h) - f3);
        path.lineTo((rectF.right - this.f61197f) - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f61192a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f61192a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + Math.min(this.i, this.f61198g) + f2, rectF.top + this.f61199h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.i + f3, rectF.top + this.f61199h + f2);
        path.lineTo(rectF.left + (this.f61197f / 2.0f) + this.i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f61197f) + this.i) - f3, rectF.top + this.f61199h + f2);
        path.lineTo((rectF.right - this.f61198g) - f2, rectF.top + this.f61199h + f2);
        float f4 = rectF.right;
        float f5 = this.f61198g;
        float f6 = rectF.top;
        float f7 = this.f61199h;
        path.arcTo(new RectF(f4 - f5, f6 + f7 + f2, f4 - f2, f5 + f6 + f7), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61198g) - f2);
        float f8 = rectF.right;
        float f9 = this.f61198g;
        float f10 = rectF.bottom;
        path.arcTo(new RectF(f8 - f9, f10 - f9, f8 - f2, f10 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61198g + f2, rectF.bottom - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f61198g;
        path.arcTo(new RectF(f11 + f2, f12 - f13, f13 + f11, f12 - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f61199h + this.f61198g + f2);
        float f14 = rectF.left;
        float f15 = f14 + f2;
        float f16 = rectF.top;
        float f17 = this.f61199h;
        float f18 = f16 + f17 + f2;
        float f19 = this.f61198g;
        path.arcTo(new RectF(f15, f18, f14 + f19, f19 + f16 + f17), 180.0f, 90.0f);
        path.close();
    }

    public final void i(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.i + f2, rectF.top + this.f61199h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.i + f3, rectF.top + this.f61199h + f2);
        path.lineTo(rectF.left + (this.f61197f / 2.0f) + this.i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f61197f) + this.i) - f3, rectF.top + this.f61199h + f2);
        path.lineTo(rectF.right - f2, rectF.top + this.f61199h + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + this.f61199h + f2);
        path.lineTo(rectF.left + this.i + f2, rectF.top + this.f61199h + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f61194c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f61194c.setColorFilter(colorFilter);
    }
}
