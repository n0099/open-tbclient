package d.a.c.f.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    public Rect v = new Rect();

    @Override // d.a.c.f.a.c, d.a.c.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix = this.f42663e;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        canvas.save();
        if (this.u) {
            try {
                canvas.clipPath(this.r);
            } catch (Error unused) {
            }
        }
        if (dVar.e()) {
            Bitmap bitmap = dVar.f42671a.getBitmap();
            this.v.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.v, this.f42664f, this.f42660b);
        } else {
            this.v.set(0, 0, dVar.b(), dVar.a());
            dVar.f42672b.g(canvas, this.v, this.f42664f, this.f42660b);
        }
        canvas.restore();
    }
}
