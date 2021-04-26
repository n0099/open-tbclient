package d.a.c.f.a;

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
    public InterfaceC0520a f40097a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f40098b = new Paint(6);

    /* renamed from: c  reason: collision with root package name */
    public Paint f40099c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    public Paint f40100d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    public Matrix f40101e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public RectF f40102f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public RectF f40103g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public RectF f40104h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    public RectF f40105i = new RectF();
    public RectF j = new RectF();
    public e k = new e();
    public float[] l = new float[9];
    public PointF m = new PointF();
    public RectF n = new RectF();

    /* renamed from: d.a.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0520a {
        boolean a(Canvas canvas, Drawable drawable);
    }

    public a() {
        this.f40099c.setStyle(Paint.Style.STROKE);
        this.f40099c.setAntiAlias(true);
        this.f40098b.setAntiAlias(true);
        this.f40100d.setAntiAlias(true);
        this.f40100d.setStyle(Paint.Style.FILL);
    }

    public static Matrix.ScaleToFit m(ImageView.ScaleType scaleType) {
        int i2;
        if (scaleType != ImageView.ScaleType.FIT_XY) {
            if (scaleType == ImageView.ScaleType.FIT_START) {
                i2 = 2;
            } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                i2 = 3;
            } else if (scaleType == ImageView.ScaleType.FIT_END) {
                i2 = 4;
            }
            return o[i2 - 1];
        }
        i2 = 1;
        return o[i2 - 1];
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
            this.f40102f.set(0.0f, 0.0f, b2, a2);
            a(dVar, imageView);
            return;
        }
        boolean z = (b2 <= 0 || width == b2) && (a2 <= 0 || height == a2);
        this.f40101e.reset();
        if (ImageView.ScaleType.FIT_XY != scaleType && !z) {
            float f5 = b2;
            float f6 = a2;
            this.f40102f.set(0.0f, 0.0f, f5, f6);
            if (ImageView.ScaleType.CENTER == scaleType) {
                this.f40101e.setTranslate((width - b2) * 0.5f, (height - a2) * 0.5f);
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
                this.f40101e.setScale(f2, f2);
                this.f40101e.postTranslate(f4, f3);
            } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                float min = (b2 > width || a2 > height) ? Math.min(width / f5, height / f6) : 1.0f;
                this.f40101e.setScale(min, min);
                this.f40101e.postTranslate((width - (f5 * min)) * 0.5f, (height - (f6 * min)) * 0.5f);
            } else {
                this.f40104h.set(0.0f, 0.0f, f5, f6);
                this.f40105i.set(0.0f, 0.0f, width, height);
                this.f40101e.setRectToRect(this.f40104h, this.f40105i, m(scaleType));
            }
        } else {
            this.f40102f.set(0.0f, 0.0f, width, height);
        }
        int length = this.k.f40112a.length;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.k.f40112a;
            if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                fArr[i2] = fArr[i2] * this.f40102f.height();
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
        InterfaceC0520a interfaceC0520a = this.f40097a;
        if (interfaceC0520a == null || !interfaceC0520a.a(canvas, drawable)) {
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
        d.a.c.j.d.a aVar = dVar.f40110b;
        if (aVar != null && aVar.v()) {
            if ((dVar.f40110b.p().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.f40110b.p().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && (matrix = this.f40101e) != null) {
                canvas.concat(matrix);
            }
            this.j.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            dVar.f40110b.i(canvas, this.j);
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
        return this.f40102f;
    }

    public Matrix k() {
        return this.f40101e;
    }

    public Path l(RectF rectF, float[] fArr) {
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        return path;
    }

    public void n(Matrix matrix) {
        this.f40101e = matrix;
    }

    public void o(InterfaceC0520a interfaceC0520a) {
        this.f40097a = interfaceC0520a;
    }

    public void p(e eVar) {
        this.k = eVar;
    }

    public void q() {
        this.f40098b.setAlpha((int) (this.k.k * 255.0f));
        if (this.k.f40117f) {
            this.f40098b.setColorFilter(p);
        } else {
            this.f40098b.setColorFilter(null);
        }
        this.f40099c.setColor(this.k.f40116e);
        this.f40099c.setStrokeWidth(this.k.f40115d);
    }
}
