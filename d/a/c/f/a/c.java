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
        if (eVar.f42676c) {
            float f2 = eVar.f42677d / 2.0f;
            if (!eVar.f42680g) {
                this.f42665g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            RectF rectF = this.f42664f;
            PointF b2 = b(rectF.left, rectF.top, this.f42663e);
            RectF rectF2 = this.f42664f;
            PointF b3 = b(rectF2.right, rectF2.bottom, this.f42663e);
            this.f42665g.set(Math.max((int) b2.x, 0) + f2, Math.max((int) b2.y, 0) + f2, Math.min((int) b3.x, width) - f2, Math.min((int) b3.y, height) - f2);
        }
    }

    @Override // d.a.c.f.a.a
    public void f(Canvas canvas, ImageView imageView) {
        if (this.k.f42676c) {
            canvas.drawRect(this.f42665g, this.f42661c);
        }
    }

    @Override // d.a.c.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix = this.f42663e;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (dVar.e()) {
            Bitmap bitmap = dVar.f42671a.getBitmap();
            this.q.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.q, this.f42664f, this.f42660b);
        } else if (dVar.d()) {
            this.q.set(0, 0, dVar.b(), dVar.a());
            dVar.f42672b.g(canvas, this.q, this.f42664f, this.f42660b);
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
        this.f42662d.setColor(this.k.m);
        canvas.drawRect(this.n, this.f42662d);
        canvas.translate(-scrollX, -scrollY);
    }
}
