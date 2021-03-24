package d.b.b.f.a;

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

    @Override // d.b.b.f.a.a
    public void a(d dVar, ImageView imageView) {
        int b2 = dVar.b();
        int a2 = dVar.a();
        RectF rectF = this.f42148f;
        PointF b3 = b(rectF.left, rectF.top, this.f42147e);
        int i = (int) b3.x;
        int i2 = (int) b3.y;
        RectF rectF2 = this.f42148f;
        PointF b4 = b(rectF2.right, rectF2.bottom, this.f42147e);
        int i3 = (int) b4.x;
        int i4 = (int) b4.y;
        this.q.reset();
        this.q.postScale((i3 - i) / b2, (i4 - i2) / a2);
        this.q.postTranslate(i, i2);
        if (dVar.e()) {
            Bitmap bitmap = dVar.f42154a.getBitmap();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.r = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.r = dVar.f42155b.d();
        }
        BitmapShader bitmapShader = this.r;
        if (bitmapShader == null) {
            return;
        }
        bitmapShader.setLocalMatrix(this.q);
        this.f42144b.setShader(this.r);
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        this.s.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width), Math.min(i4, height));
        e eVar = this.k;
        if (eVar.f42159c) {
            float f2 = eVar.f42160d / 2.0f;
            if (!eVar.f42163g) {
                this.f42149g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                return;
            }
            RectF rectF3 = this.f42149g;
            RectF rectF4 = this.s;
            rectF3.set(rectF4.left + f2, rectF4.top + f2, rectF4.right - f2, rectF4.bottom - f2);
        }
    }

    @Override // d.b.b.f.a.a
    public void f(Canvas canvas, ImageView imageView) {
        e eVar = this.k;
        if (eVar.f42159c) {
            if (!eVar.f42158b) {
                canvas.drawPath(l(this.f42149g, eVar.f42157a), this.f42145c);
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
            canvas.drawCircle(f2, f3, min - (this.k.f42160d / 2.0f), this.f42145c);
        }
    }

    @Override // d.b.b.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        boolean d2 = dVar.d();
        if (d2 && dVar.d()) {
            dVar.f42155b.b(true);
        }
        e eVar = this.k;
        if (!eVar.f42158b) {
            canvas.drawPath(l(this.s, eVar.f42157a), this.f42144b);
        } else {
            RectF rectF = this.s;
            canvas.drawCircle((rectF.right + rectF.left) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, Math.min(rectF.width(), this.s.height()) / 2.0f, this.f42144b);
        }
        if (d2 && dVar.d()) {
            dVar.f42155b.b(false);
        }
    }

    @Override // d.b.b.f.a.a
    public void i(Canvas canvas, ImageView imageView) {
        if (this.k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.f42146d.setColor(this.k.m);
        if (!this.k.f42158b) {
            this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            canvas.drawPath(l(this.n, this.k.f42157a), this.f42146d);
        } else {
            float width = imageView.getWidth() / 2.0f;
            float height = imageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height) - (this.k.f42160d / 2.0f), this.f42146d);
        }
        canvas.translate(-scrollX, -scrollY);
    }
}
