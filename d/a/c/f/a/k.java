package d.a.c.f.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    public a t;
    public Path r = new Path();
    public Paint s = null;
    public boolean u = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void b(Canvas canvas);
    }

    @Override // d.a.c.f.a.a
    public void c(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.c(dVar, imageView, scaleType);
        a aVar = this.t;
        if (aVar == null || (a2 = aVar.a(j())) == null) {
            return;
        }
        this.r.set(a2);
        if (this.s == null) {
            Paint paint = new Paint();
            this.s = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.s.setAntiAlias(true);
            this.s.setColor(637534208);
            this.s.setDither(true);
            this.s.setStrokeWidth(2.0f);
        }
        r();
    }

    @Override // d.a.c.f.a.a
    public void g(Canvas canvas, d dVar, ImageView imageView) {
        super.g(canvas, dVar, imageView);
        if (this.u) {
            canvas.drawPath(this.r, this.s);
            a aVar = this.t;
            if (aVar != null) {
                aVar.b(canvas);
            }
        }
    }

    public void r() {
    }

    public void s() {
    }

    public void t(a aVar) {
        this.t = aVar;
    }

    public void u(boolean z) {
        this.u = z;
    }
}
