package d.a.k0.u3.j;

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
    public RectF f62252a;

    /* renamed from: b  reason: collision with root package name */
    public Path f62253b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public Paint f62254c;

    /* renamed from: d  reason: collision with root package name */
    public Path f62255d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f62256e;

    /* renamed from: f  reason: collision with root package name */
    public float f62257f;

    /* renamed from: g  reason: collision with root package name */
    public float f62258g;

    /* renamed from: h  reason: collision with root package name */
    public float f62259h;

    /* renamed from: i  reason: collision with root package name */
    public float f62260i;
    public float j;

    /* renamed from: d.a.k0.u3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1679a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62261a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f62261a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62261a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f62261a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f62261a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(RectF rectF, float f2, float f3, float f4, float f5, float f6, int i2, int i3, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.f62254c = paint;
        this.f62252a = rectF;
        this.f62257f = f2;
        this.f62258g = f3;
        this.f62259h = f4;
        this.f62260i = f5;
        this.j = f6;
        paint.setColor(i3);
        if (f6 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f62256e = paint2;
            paint2.setColor(i2);
            this.f62255d = new Path();
            e(arrowDirection, this.f62253b, f6);
            e(arrowDirection, this.f62255d, 0.0f);
            return;
        }
        e(arrowDirection, this.f62253b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f62258g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f62258g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f62258g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, ((rectF.bottom - this.f62259h) - this.f62258g) - f2);
        float f6 = rectF.right;
        float f7 = this.f62258g;
        float f8 = rectF.bottom;
        float f9 = this.f62259h;
        path.arcTo(new RectF(f6 - f7, (f8 - f7) - f9, f6 - f2, (f8 - f9) - f2), 0.0f, 90.0f);
        float f10 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f62257f) + this.f62260i) - f10, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + this.f62260i + (this.f62257f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.f62260i + f10, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + Math.min(this.f62258g, this.f62260i) + f2, (rectF.bottom - this.f62259h) - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f62258g;
        float f14 = this.f62259h;
        path.arcTo(new RectF(f11 + f2, (f12 - f13) - f14, f13 + f11, (f12 - f14) - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f62258g + f2);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f62258g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void b(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f62259h) - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(((rectF.left + this.f62257f) + this.f62260i) - f3, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + this.f62260i + (this.f62257f / 2.0f), (rectF.bottom - f2) - f2);
        path.lineTo(rectF.left + this.f62260i + f3, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + this.f62260i + f2, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + f2, (rectF.bottom - this.f62259h) - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    public final void c(RectF rectF, Path path, float f2) {
        path.moveTo(this.f62257f + rectF.left + this.f62258g + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f62258g) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f62258g;
        float f5 = rectF.top;
        path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f62258g) - f2);
        float f6 = rectF.right;
        float f7 = this.f62258g;
        float f8 = rectF.bottom;
        path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - f2, f8 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f62257f + this.f62258g + f2, rectF.bottom - f2);
        float f9 = rectF.left;
        float f10 = this.f62257f;
        float f11 = rectF.bottom;
        float f12 = this.f62258g;
        path.arcTo(new RectF(f9 + f10 + f2, f11 - f12, f12 + f9 + f10, f11 - f2), 90.0f, 90.0f);
        float f13 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f62257f + f2, (this.f62259h + this.f62260i) - f13);
        path.lineTo(rectF.left + f2 + f2, this.f62260i + (this.f62259h / 2.0f));
        path.lineTo(rectF.left + this.f62257f + f2, this.f62260i + f13);
        path.lineTo(rectF.left + this.f62257f + f2, rectF.top + this.f62258g + f2);
        float f14 = rectF.left;
        float f15 = this.f62257f;
        float f16 = rectF.top;
        float f17 = this.f62258g;
        path.arcTo(new RectF(f14 + f15 + f2, f2 + f16, f14 + f17 + f15, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rectF, Path path, float f2) {
        path.moveTo(this.f62257f + rectF.left + f2, rectF.top + f2);
        path.lineTo(rectF.width() - f2, rectF.top + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + this.f62257f + f2, rectF.bottom - f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f62257f + f2, (this.f62259h + this.f62260i) - f3);
        path.lineTo(rectF.left + f2 + f2, this.f62260i + (this.f62259h / 2.0f));
        path.lineTo(rectF.left + this.f62257f + f2, this.f62260i + f3);
        path.lineTo(rectF.left + this.f62257f + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j > 0.0f) {
            canvas.drawPath(this.f62255d, this.f62256e);
        }
        canvas.drawPath(this.f62253b, this.f62254c);
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f2) {
        int i2 = C1679a.f62261a[arrowDirection.ordinal()];
        if (i2 == 1) {
            float f3 = this.f62258g;
            if (f3 <= 0.0f) {
                d(this.f62252a, path, f2);
            } else if (f2 > 0.0f && f2 > f3) {
                d(this.f62252a, path, f2);
            } else {
                c(this.f62252a, path, f2);
            }
        } else if (i2 == 2) {
            float f4 = this.f62258g;
            if (f4 <= 0.0f) {
                i(this.f62252a, path, f2);
            } else if (f2 > 0.0f && f2 > f4) {
                i(this.f62252a, path, f2);
            } else {
                h(this.f62252a, path, f2);
            }
        } else if (i2 == 3) {
            float f5 = this.f62258g;
            if (f5 <= 0.0f) {
                g(this.f62252a, path, f2);
            } else if (f2 > 0.0f && f2 > f5) {
                g(this.f62252a, path, f2);
            } else {
                f(this.f62252a, path, f2);
            }
        } else if (i2 != 4) {
        } else {
            float f6 = this.f62258g;
            if (f6 <= 0.0f) {
                b(this.f62252a, path, f2);
            } else if (f2 > 0.0f && f2 > f6) {
                b(this.f62252a, path, f2);
            } else {
                a(this.f62252a, path, f2);
            }
        }
    }

    public final void f(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f62258g + f2, rectF.top + f2);
        path.lineTo(((rectF.width() - this.f62258g) - this.f62257f) - f2, rectF.top + f2);
        float f3 = rectF.right;
        float f4 = this.f62258g;
        float f5 = this.f62257f;
        float f6 = rectF.top;
        path.arcTo(new RectF((f3 - f4) - f5, f6 + f2, (f3 - f5) - f2, f4 + f6), 270.0f, 90.0f);
        float f7 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f62257f) - f2, this.f62260i + f7);
        path.lineTo((rectF.right - f2) - f2, this.f62260i + (this.f62259h / 2.0f));
        path.lineTo((rectF.right - this.f62257f) - f2, (this.f62260i + this.f62259h) - f7);
        path.lineTo((rectF.right - this.f62257f) - f2, (rectF.bottom - this.f62258g) - f2);
        float f8 = rectF.right;
        float f9 = this.f62258g;
        float f10 = this.f62257f;
        float f11 = rectF.bottom;
        path.arcTo(new RectF((f8 - f9) - f10, f11 - f9, (f8 - f10) - f2, f11 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f62257f + f2, rectF.bottom - f2);
        float f12 = rectF.left;
        float f13 = rectF.bottom;
        float f14 = this.f62258g;
        path.arcTo(new RectF(f12 + f2, f13 - f14, f14 + f12, f13 - f2), 90.0f, 90.0f);
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = this.f62258g;
        path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
        path.close();
    }

    public final void g(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + f2, rectF.top + f2);
        path.lineTo((rectF.width() - this.f62257f) - f2, rectF.top + f2);
        float f3 = f2 / 2.0f;
        path.lineTo((rectF.right - this.f62257f) - f2, this.f62260i + f3);
        path.lineTo((rectF.right - f2) - f2, this.f62260i + (this.f62259h / 2.0f));
        path.lineTo((rectF.right - this.f62257f) - f2, (this.f62260i + this.f62259h) - f3);
        path.lineTo((rectF.right - this.f62257f) - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f62252a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f62252a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + Math.min(this.f62260i, this.f62258g) + f2, rectF.top + this.f62259h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f62260i + f3, rectF.top + this.f62259h + f2);
        path.lineTo(rectF.left + (this.f62257f / 2.0f) + this.f62260i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f62257f) + this.f62260i) - f3, rectF.top + this.f62259h + f2);
        path.lineTo((rectF.right - this.f62258g) - f2, rectF.top + this.f62259h + f2);
        float f4 = rectF.right;
        float f5 = this.f62258g;
        float f6 = rectF.top;
        float f7 = this.f62259h;
        path.arcTo(new RectF(f4 - f5, f6 + f7 + f2, f4 - f2, f5 + f6 + f7), 270.0f, 90.0f);
        path.lineTo(rectF.right - f2, (rectF.bottom - this.f62258g) - f2);
        float f8 = rectF.right;
        float f9 = this.f62258g;
        float f10 = rectF.bottom;
        path.arcTo(new RectF(f8 - f9, f10 - f9, f8 - f2, f10 - f2), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f62258g + f2, rectF.bottom - f2);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.f62258g;
        path.arcTo(new RectF(f11 + f2, f12 - f13, f13 + f11, f12 - f2), 90.0f, 90.0f);
        path.lineTo(rectF.left + f2, rectF.top + this.f62259h + this.f62258g + f2);
        float f14 = rectF.left;
        float f15 = f14 + f2;
        float f16 = rectF.top;
        float f17 = this.f62259h;
        float f18 = f16 + f17 + f2;
        float f19 = this.f62258g;
        path.arcTo(new RectF(f15, f18, f14 + f19, f19 + f16 + f17), 180.0f, 90.0f);
        path.close();
    }

    public final void i(RectF rectF, Path path, float f2) {
        path.moveTo(rectF.left + this.f62260i + f2, rectF.top + this.f62259h + f2);
        float f3 = f2 / 2.0f;
        path.lineTo(rectF.left + this.f62260i + f3, rectF.top + this.f62259h + f2);
        path.lineTo(rectF.left + (this.f62257f / 2.0f) + this.f62260i, rectF.top + f2 + f2);
        path.lineTo(((rectF.left + this.f62257f) + this.f62260i) - f3, rectF.top + this.f62259h + f2);
        path.lineTo(rectF.right - f2, rectF.top + this.f62259h + f2);
        path.lineTo(rectF.right - f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.bottom - f2);
        path.lineTo(rectF.left + f2, rectF.top + this.f62259h + f2);
        path.lineTo(rectF.left + this.f62260i + f2, rectF.top + this.f62259h + f2);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f62254c.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f62254c.setColorFilter(colorFilter);
    }
}
