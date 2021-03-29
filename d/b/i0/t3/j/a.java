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
    public RectF f61193a;

    /* renamed from: b  reason: collision with root package name */
    public Path f61194b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public Paint f61195c;

    /* renamed from: d  reason: collision with root package name */
    public Path f61196d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f61197e;

    /* renamed from: f  reason: collision with root package name */
    public float f61198f;

    /* renamed from: g  reason: collision with root package name */
    public float f61199g;

    /* renamed from: h  reason: collision with root package name */
    public float f61200h;
    public float i;
    public float j;

    /* renamed from: d.b.i0.t3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1591a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61201a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f61201a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61201a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61201a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f61201a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(RectF rectF, float f2, float f3, float f4, float f5, float f6, int i, int i2, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.f61195c = paint;
        this.f61193a = rectF;
        this.f61198f = f2;
        this.f61199g = f3;
        this.f61200h = f4;
        this.i = f5;
        this.j = f6;
        paint.setColor(i2);
        if (f6 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f61197e = paint2;
            paint2.setColor(i);
            this.f61196d = new Path();
            e(arrowDirection, this.f61194b, f6);
            e(arrowDirection, this.f61196d, 0.0f);
            return;
        }
        e(arrowDirection, this.f61194b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f61199g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61199g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61199g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, ((rectF.bottom - this.f61200h) - this.f61199g) - f2);
        float f6 = rectF.right;
        float f7 = this.f61199g;
        float f8 = rectF.bottom;
        float f9 = this.f61200h;
        path.arcTo(new RectF(f6 - f7, (f8 - f7) - f9, f6 - f2, (f8 - f9) - f2), 0.0f, 90.0f);
        float f10 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f61198f) + this.i) - f10, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + this.i + (this.f61198f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.i + f10, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + Math.min(this.f61199g, this.i) + f2, (rectF.bottom - this.f61200h) - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f61199g;
        float f14 = this.f61200h;
        path.arcTo(new RectF(f11 + f2, (f12 - f13) - f14, f13 + f11, (f12 - f14) - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f61199g + f2);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f61199g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void b(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61200h) - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f61198f) + this.i) - f3, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + this.i + (this.f61198f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.i + f3, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + this.i + f2, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + f2, (rectF.bottom - this.f61200h) - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    public final void c(RectF rectF, Path path, float f2) {
        path.moveTo(this.f61198f + rectF.left + this.f61199g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61199g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61199g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61199g) - f2);
        float f6 = rectF.right;
        float f7 = this.f61199g;
        float f8 = rectF.bottom;
        path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - f2, f8 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61198f + this.f61199g + f2, rectF.bottom - f2);
        float f9 = rectF.left;
        float f10 = this.f61198f;
        float f11 = rectF.bottom;
        float f12 = this.f61199g;
        path.arcTo(new RectF(f9 + f10 + f2, f11 - f12, f12 + f9 + f10, f11 - f2), 90.0f, 90.0f);
        float f13 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f61198f + f2, (this.f61200h + this.i) - f13);
        path.lineTo(rectF.left + f2 + f2, this.i + (this.f61200h / 2.0f));
        path.lineTo(rectF.left + this.f61198f + f2, this.i + f13);
        path.lineTo(rectF.left + this.f61198f + f2, rectF.top + this.f61199g + f2);
        float f14 = rectF.left;
        float f15 = this.f61198f;
        float f16 = rectF.top;
        float f17 = this.f61199g;
        path.arcTo(new RectF(f14 + f15 + f2, f2 + f16, f14 + f17 + f15, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rectF, Path path, float f2) {
        path.moveTo(this.f61198f + rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.width() - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + this.f61198f + f2, rectF.bottom - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f61198f + f2, (this.f61200h + this.i) - f3);
        path.lineTo(rectF.left + f2 + f2, this.i + (this.f61200h / 2.0f));
        path.lineTo(rectF.left + this.f61198f + f2, this.i + f3);
        path.lineTo(rectF.left + this.f61198f + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j > 0.0f) {
            canvas.drawPath(this.f61196d, this.f61197e);
        }
        canvas.drawPath(this.f61194b, this.f61195c);
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f2) {
        int i = C1591a.f61201a[arrowDirection.ordinal()];
        if (i == 1) {
            float f3 = this.f61199g;
            if (f3 <= 0.0f) {
                d(this.f61193a, path, f2);
            } else if (f2 > 0.0f && f2 > f3) {
                d(this.f61193a, path, f2);
            } else {
                c(this.f61193a, path, f2);
            }
        } else if (i == 2) {
            float f4 = this.f61199g;
            if (f4 <= 0.0f) {
                i(this.f61193a, path, f2);
            } else if (f2 > 0.0f && f2 > f4) {
                i(this.f61193a, path, f2);
            } else {
                h(this.f61193a, path, f2);
            }
        } else if (i == 3) {
            float f5 = this.f61199g;
            if (f5 <= 0.0f) {
                g(this.f61193a, path, f2);
            } else if (f2 > 0.0f && f2 > f5) {
                g(this.f61193a, path, f2);
            } else {
                f(this.f61193a, path, f2);
            }
        } else if (i != 4) {
        } else {
            float f6 = this.f61199g;
            if (f6 <= 0.0f) {
                b(this.f61193a, path, f2);
            } else if (f2 > 0.0f && f2 > f6) {
                b(this.f61193a, path, f2);
            } else {
                a(this.f61193a, path, f2);
            }
        }
    }

    public final void f(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f61199g + f2, rectF.top + f2);
        path.lineTo(((rectF.width() - this.f61199g) - this.f61198f) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f61199g;
        float f5 = this.f61198f;
        float f6 = rectF.top;
        path.arcTo(new RectF((f3 - f4) - f5, f6 + f2, (f3 - f5) - f2, f4 + f6), 270.0f, 90.0f);
        float f7 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f61198f) - f2, this.i + f7);
        path.lineTo((rectF.right - f2) - f2, this.i + (this.f61200h / 2.0f));
        path.lineTo((rectF.right - this.f61198f) - f2, (this.i + this.f61200h) - f7);
        path.lineTo((rectF.right - this.f61198f) - f2, (rectF.bottom - this.f61199g) - f2);
        float f8 = rectF.right;
        float f9 = this.f61199g;
        float f10 = this.f61198f;
        float f11 = rectF.bottom;
        path.arcTo(new RectF((f8 - f9) - f10, f11 - f9, (f8 - f10) - f2, f11 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61198f + f2, rectF.bottom - f2);
        float f12 = rectF.left;
        float f13 = rectF.bottom;
        float f14 = this.f61199g;
        path.arcTo(new RectF(f12 + f2, f13 - f14, f14 + f12, f13 - f2), 90.0f, 90.0f);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f61199g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void g(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f61198f) - f2, rectF.top + f2);
        float f3 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f61198f) - f2, this.i + f3);
        path.lineTo((rectF.right - f2) - f2, this.i + (this.f61200h / 2.0f));
        path.lineTo((rectF.right - this.f61198f) - f2, (this.i + this.f61200h) - f3);
        path.lineTo((rectF.right - this.f61198f) - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f61193a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f61193a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + Math.min(this.i, this.f61199g) + f2, rectF.top + this.f61200h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.i + f3, rectF.top + this.f61200h + f2);
        path.lineTo(rectF.left + (this.f61198f / 2.0f) + this.i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f61198f) + this.i) - f3, rectF.top + this.f61200h + f2);
        path.lineTo((rectF.right - this.f61199g) - f2, rectF.top + this.f61200h + f2);
        float f4 = rectF.right;
        float f5 = this.f61199g;
        float f6 = rectF.top;
        float f7 = this.f61200h;
        path.arcTo(new RectF(f4 - f5, f6 + f7 + f2, f4 - f2, f5 + f6 + f7), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f61199g) - f2);
        float f8 = rectF.right;
        float f9 = this.f61199g;
        float f10 = rectF.bottom;
        path.arcTo(new RectF(f8 - f9, f10 - f9, f8 - f2, f10 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f61199g + f2, rectF.bottom - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f61199g;
        path.arcTo(new RectF(f11 + f2, f12 - f13, f13 + f11, f12 - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f61200h + this.f61199g + f2);
        float f14 = rectF.left;
        float f15 = f14 + f2;
        float f16 = rectF.top;
        float f17 = this.f61200h;
        float f18 = f16 + f17 + f2;
        float f19 = this.f61199g;
        path.arcTo(new RectF(f15, f18, f14 + f19, f19 + f16 + f17), 180.0f, 90.0f);
        path.close();
    }

    public final void i(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.i + f2, rectF.top + this.f61200h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.i + f3, rectF.top + this.f61200h + f2);
        path.lineTo(rectF.left + (this.f61198f / 2.0f) + this.i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f61198f) + this.i) - f3, rectF.top + this.f61200h + f2);
        path.lineTo(rectF.right - f2, rectF.top + this.f61200h + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + this.f61200h + f2);
        path.lineTo(rectF.left + this.i + f2, rectF.top + this.f61200h + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f61195c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f61195c.setColorFilter(colorFilter);
    }
}
