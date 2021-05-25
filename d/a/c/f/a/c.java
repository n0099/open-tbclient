package d.a.c.f.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    public Rect q = new Rect();

    @Override // d.a.c.f.a.a
    public void a(d dVar, ImageView imageView) {
        e eVar = this.k;
        if (eVar.f39023c) {
            float f2 = eVar.f39024d / 2.0f;
            if (!eVar.f39027g) {
                this.f39012g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            RectF rectF = this.f39011f;
            PointF b2 = b(rectF.left, rectF.top, this.f39010e);
            RectF rectF2 = this.f39011f;
            PointF b3 = b(rectF2.right, rectF2.bottom, this.f39010e);
            this.f39012g.set(Math.max((int) b2.x, 0) + f2, Math.max((int) b2.y, 0) + f2, Math.min((int) b3.x, width) - f2, Math.min((int) b3.y, height) - f2);
        }
    }

    @Override // d.a.c.f.a.a
    public void f(Canvas canvas, ImageView imageView) {
        if (this.k.f39023c) {
            canvas.drawRect(this.f39012g, this.f39008c);
        }
    }

    @Override // d.a.c.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix = this.f39010e;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (dVar.e()) {
            Bitmap bitmap = dVar.f39018a.getBitmap();
            this.q.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.q, this.f39011f, this.f39007b);
        } else if (dVar.d()) {
            this.q.set(0, 0, dVar.b(), dVar.a());
            dVar.f39019b.g(canvas, this.q, this.f39011f, this.f39007b);
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
        this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
        this.f39009d.setColor(this.k.m);
        canvas.drawRect(this.n, this.f39009d);
        canvas.translate(-scrollX, -scrollY);
    }
}
