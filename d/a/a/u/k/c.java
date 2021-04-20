package d.a.a.u.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.k;
import d.a.a.s.c.p;
import d.a.a.x.h;
/* loaded from: classes.dex */
public class c extends a {
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> A;
    public final Paint x;
    public final Rect y;
    public final Rect z;

    public c(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        this.x = new d.a.a.s.a(3);
        this.y = new Rect();
        this.z = new Rect();
    }

    @Nullable
    public final Bitmap J() {
        return this.n.t(this.o.k());
    }

    @Override // d.a.a.u.k.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == k.C) {
            if (cVar == null) {
                this.A = null;
            } else {
                this.A = new p(cVar);
            }
        }
    }

    @Override // d.a.a.u.k.a, d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        Bitmap J = J();
        if (J != null) {
            rectF.set(0.0f, 0.0f, J.getWidth() * h.e(), J.getHeight() * h.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // d.a.a.u.k.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap J = J();
        if (J == null || J.isRecycled()) {
            return;
        }
        float e2 = h.e();
        this.x.setAlpha(i);
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.A;
        if (aVar != null) {
            this.x.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.y.set(0, 0, J.getWidth(), J.getHeight());
        this.z.set(0, 0, (int) (J.getWidth() * e2), (int) (J.getHeight() * e2));
        canvas.drawBitmap(J, this.y, this.z, this.x);
        canvas.restore();
    }
}
