package d.b.c.f.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class a {
    public static final Matrix.ScaleToFit[] o = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    public static final PorterDuffColorFilter p = new PorterDuffColorFilter(1409286144, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0562a f42641a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f42642b = new Paint(6);

    /* renamed from: c  reason: collision with root package name */
    public Paint f42643c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    public Paint f42644d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    public Matrix f42645e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public RectF f42646f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public RectF f42647g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public RectF f42648h = new RectF();
    public RectF i = new RectF();
    public RectF j = new RectF();
    public e k = new e();
    public float[] l = new float[9];
    public PointF m = new PointF();
    public RectF n = new RectF();

    /* renamed from: d.b.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0562a {
        boolean a(Canvas canvas, Drawable drawable);
    }

    public a() {
        this.f42643c.setStyle(Paint.Style.STROKE);
        this.f42643c.setAntiAlias(true);
        this.f42642b.setAntiAlias(true);
        this.f42644d.setAntiAlias(true);
        this.f42644d.setStyle(Paint.Style.FILL);
    }

    public static Matrix.ScaleToFit m(ImageView.ScaleType scaleType) {
        int i;
        if (scaleType != ImageView.ScaleType.FIT_XY) {
            if (scaleType == ImageView.ScaleType.FIT_START) {
                i = 2;
            } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                i = 3;
            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                i = 4;
            }
            return o[i - 1];
        }
        i = 1;
        return o[i - 1];
    }

    public abstract void a(d dVar, ImageView imageView);

    public PointF b(float f2, float f3, Matrix matrix) {
        matrix.getValues(this.l);
        float[] fArr = this.l;
        this.m.set((int) ((fArr[0] * f2) + (fArr[1] * f3) + fArr[2]), (int) ((f2 * fArr[3]) + (f3 * fArr[4]) + fArr[5]));
        return this.m;
    }

    public void c(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float f2;
        float f3;
        float f4;
        if (imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            return;
        }
        int b2 = dVar.b();
        int a2 = dVar.a();
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            this.f42646f.set(0.0f, 0.0f, b2, a2);
            a(dVar, imageView);
            return;
        }
        boolean z = (b2 <= 0 || width == b2) && (a2 <= 0 || height == a2);
        this.f42645e.reset();
        if (ImageView.ScaleType.FIT_XY != scaleType && !z) {
            float f5 = b2;
            float f6 = a2;
            this.f42646f.set(0.0f, 0.0f, f5, f6);
            if (ImageView.ScaleType.CENTER == scaleType) {
                this.f42645e.setTranslate((width - b2) * 0.5f, (height - a2) * 0.5f);
            } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                if (b2 * height > a2 * width) {
                    f2 = height / f6;
                    f4 = (width - (f5 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / f5;
                    f3 = (height - (f6 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                this.f42645e.setScale(f2, f2);
                this.f42645e.postTranslate(f4, f3);
            } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                float min = (b2 > width || a2 > height) ? Math.min(width / f5, height / f6) : 1.0f;
                this.f42645e.setScale(min, min);
                this.f42645e.postTranslate((width - (f5 * min)) * 0.5f, (height - (f6 * min)) * 0.5f);
            } else {
                this.f42648h.set(0.0f, 0.0f, f5, f6);
                this.i.set(0.0f, 0.0f, width, height);
                this.f42645e.setRectToRect(this.f42648h, this.i, m(scaleType));
            }
        } else {
            this.f42646f.set(0.0f, 0.0f, width, height);
        }
        int length = this.k.f42655a.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.k.f42655a;
            if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                fArr[i] = fArr[i] * this.f42646f.height();
            }
        }
        a(dVar, imageView);
    }

    public void d(Canvas canvas, ImageView imageView, Drawable drawable) {
        if (drawable != null) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            if ((scrollX | scrollY) == 0) {
                e(canvas, drawable);
                return;
            }
            canvas.translate(scrollX, scrollY);
            e(canvas, drawable);
            canvas.translate(-scrollX, -scrollY);
        }
    }

    public void e(Canvas canvas, Drawable drawable) {
        InterfaceC0562a interfaceC0562a = this.f42641a;
        if (interfaceC0562a == null || !interfaceC0562a.a(canvas, drawable)) {
            drawable.draw(canvas);
        }
    }

    public abstract void f(Canvas canvas, ImageView imageView);

    public void g(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix;
        q();
        int save = canvas.save();
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        int paddingLeft = imageView.getPaddingLeft();
        int paddingRight = imageView.getPaddingRight();
        int paddingTop = imageView.getPaddingTop();
        int paddingBottom = imageView.getPaddingBottom();
        canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
        canvas.translate(paddingLeft, paddingTop);
        int save2 = canvas.save();
        Matrix matrix2 = this.k.l;
        if (matrix2 != null) {
            canvas.concat(matrix2);
        }
        d.b.c.j.d.a aVar = dVar.f42653b;
        if (aVar != null && aVar.v()) {
            if ((dVar.f42653b.p().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.f42653b.p().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && (matrix = this.f42645e) != null) {
                canvas.concat(matrix);
            }
            this.j.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.f42653b.i(canvas, this.j);
        } else {
            h(canvas, dVar, imageView);
        }
        if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
            canvas.restoreToCount(save2);
        }
        f(canvas, imageView);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public abstract void h(Canvas canvas, d dVar, ImageView imageView);

    public abstract void i(Canvas canvas, ImageView imageView);

    public RectF j() {
        return this.f42646f;
    }

    public Matrix k() {
        return this.f42645e;
    }

    public Path l(RectF rectF, float[] fArr) {
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        return path;
    }

    public void n(Matrix matrix) {
        this.f42645e = matrix;
    }

    public void o(InterfaceC0562a interfaceC0562a) {
        this.f42641a = interfaceC0562a;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q() {
        this.f42642b.setAlpha((int) (this.k.k * 255.0f));
        if (this.k.f42660f) {
            this.f42642b.setColorFilter(p);
        } else {
            this.f42642b.setColorFilter(null);
        }
        this.f42643c.setColor(this.k.f42659e);
        this.f42643c.setStrokeWidth(this.k.f42658d);
    }
}
