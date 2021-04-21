package d.b.c.f.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class h extends k {
    public final Paint v = new Paint();
    public final Paint w = new Paint();
    public final Rect x = new Rect(0, 0, 0, 0);
    public final Rect y = new Rect(0, 0, 0, 0);

    public h() {
        this.v.setColor(-16777216);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setAntiAlias(true);
        this.w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // d.b.c.f.a.c, d.b.c.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix = this.f42885e;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (dVar.e()) {
            Bitmap bitmap = dVar.f42892a.getBitmap();
            if (this.u) {
                v(canvas, bitmap);
                return;
            }
            this.y.set(0, 0, dVar.b(), dVar.a());
            dVar.f42893b.g(canvas, this.y, this.f42886f, this.f42882b);
        } else if (dVar.d()) {
            if (this.u) {
                v(canvas, dVar.f42893b.p());
                return;
            }
            this.y.set(0, 0, dVar.b(), dVar.a());
            dVar.f42893b.g(canvas, this.y, this.f42886f, this.f42882b);
        } else {
            this.y.set(0, 0, dVar.b(), dVar.a());
            dVar.f42893b.g(canvas, this.y, this.f42886f, this.f42882b);
        }
    }

    public void v(Canvas canvas, Bitmap bitmap) {
        this.y.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.x.set(0, 0, (int) this.f42886f.width(), (int) this.f42886f.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.r, this.v);
        canvas.drawBitmap(bitmap, this.y, this.f42886f, this.w);
        canvas.restore();
    }
}
