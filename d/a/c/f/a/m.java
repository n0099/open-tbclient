package d.a.c.f.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    public Path t;
    public boolean u;
    public Rect v;

    @Override // d.a.c.f.a.a
    public void e(Canvas canvas, Drawable drawable) {
        canvas.save();
        r(drawable.getBounds());
        try {
            canvas.clipPath(this.t);
        } catch (Exception unused) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void r(Rect rect) {
        if (rect == null) {
            return;
        }
        boolean z = true;
        boolean z2 = this.t == null || this.u != this.k.f39358b;
        Rect rect2 = this.v;
        if (rect2 != null && rect2.contains(rect)) {
            z = z2;
        }
        this.u = this.k.f39358b;
        if (z) {
            this.v = rect;
            Path path = new Path();
            this.t = path;
            if (this.u) {
                this.t.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
            } else {
                path.addRoundRect(new RectF(rect), this.k.f39357a, Path.Direction.CW);
            }
            this.t.close();
        }
    }
}
