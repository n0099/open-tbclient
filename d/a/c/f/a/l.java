package d.a.c.f.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    public BitmapShader r;
    public Matrix q = new Matrix();
    public RectF s = new RectF();

    @Override // d.a.c.f.a.a
    public void a(d dVar, ImageView imageView) {
        int b2 = dVar.b();
        int a2 = dVar.a();
        RectF rectF = this.f39011f;
        PointF b3 = b(rectF.left, rectF.top, this.f39010e);
        int i2 = (int) b3.x;
        int i3 = (int) b3.y;
        RectF rectF2 = this.f39011f;
        PointF b4 = b(rectF2.right, rectF2.bottom, this.f39010e);
        int i4 = (int) b4.x;
        int i5 = (int) b4.y;
        this.q.reset();
        this.q.postScale((i4 - i2) / b2, (i5 - i3) / a2);
        this.q.postTranslate(i2, i3);
        if (dVar.e()) {
            Bitmap bitmap = dVar.f39018a.getBitmap();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.r = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.r = dVar.f39019b.d();
        }
        BitmapShader bitmapShader = this.r;
        if (bitmapShader == null) {
            return;
        }
        bitmapShader.setLocalMatrix(this.q);
        this.f39007b.setShader(this.r);
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        this.s.set(Math.max(i2, 0), Math.max(i3, 0), Math.min(i4, width), Math.min(i5, height));
        e eVar = this.k;
        if (eVar.f39023c) {
            float f2 = eVar.f39024d / 2.0f;
            if (!eVar.f39027g) {
                this.f39012g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                return;
            }
            RectF rectF3 = this.f39012g;
            RectF rectF4 = this.s;
            rectF3.set(rectF4.left + f2, rectF4.top + f2, rectF4.right - f2, rectF4.bottom - f2);
        }
    }

    @Override // d.a.c.f.a.a
    public void f(Canvas canvas, ImageView imageView) {
        e eVar = this.k;
        if (eVar.f39023c) {
            if (!eVar.f39022b) {
                canvas.drawPath(l(this.f39012g, eVar.f39021a), this.f39008c);
                return;
            }
            RectF rectF = this.s;
            float f2 = (rectF.right + rectF.left) / 2.0f;
            float f3 = (rectF.top + rectF.bottom) / 2.0f;
            float min = Math.min(rectF.width(), this.s.height()) / 2.0f;
            if (min <= 0.0f) {
                f2 = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                f3 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
            }
            canvas.drawCircle(f2, f3, min - (this.k.f39024d / 2.0f), this.f39008c);
        }
    }

    @Override // d.a.c.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        boolean d2 = dVar.d();
        if (d2 && dVar.d()) {
            dVar.f39019b.b(true);
        }
        e eVar = this.k;
        if (!eVar.f39022b) {
            canvas.drawPath(l(this.s, eVar.f39021a), this.f39007b);
        } else {
            RectF rectF = this.s;
            canvas.drawCircle((rectF.right + rectF.left) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, Math.min(rectF.width(), this.s.height()) / 2.0f, this.f39007b);
        }
        if (d2 && dVar.d()) {
            dVar.f39019b.b(false);
        }
    }

    @Override // d.a.c.f.a.a
    public void i(Canvas canvas, ImageView imageView) {
        if (this.k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.f39009d.setColor(this.k.m);
        if (!this.k.f39022b) {
            this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            canvas.drawPath(l(this.n, this.k.f39021a), this.f39009d);
        } else {
            float width = imageView.getWidth() / 2.0f;
            float height = imageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height) - (this.k.f39024d / 2.0f), this.f39009d);
        }
        canvas.translate(-scrollX, -scrollY);
    }
}
